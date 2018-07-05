package week_III;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import static java.lang.System.*;

public class MovieDatabase {

    private ArrayList<Movie> movieList;
    private ArrayList<Actor> actorList;

    public MovieDatabase() {
        movieList = new ArrayList<>();
        actorList = new ArrayList<>();
    }

    ArrayList<Movie> getMovieList() {
        return movieList;
    }

    ArrayList<Actor> getActorList() {
        return actorList;
    }

    void addMovie(String name, String[] actors) {
        Movie newMovie = new Movie(name);
        if (!movieList.contains(newMovie)) {
            movieList.add(newMovie);
            for (String actorName: actors) {
                Actor actor = new Actor(actorName);
                if (!actorList.contains(actor)) {
                    actorList.add(actor);
                }
                else {
                    actor = actorList.get(actorList.indexOf(actor));
                }
                newMovie.getActors().add(actor);
                actor.getMovies().add(newMovie);
            }
        }
    }

    void addRating (String name, double rating) {
        if (movieList.indexOf(new Movie(name)) != -1) {
            movieList.get(movieList.indexOf(new Movie(name))).setRating(rating);
        }
        else if (getMovieList().contains(new Movie(name))) {
            updateRating(name, rating);
        }
    }

    void updateRating (String name, double newRating) {
        movieList.get(movieList.indexOf(new Movie(name))).setRating(newRating);
    }

    String getBestActor() {
        Collections.sort(actorList);
        return actorList.get(actorList.size() - 1).getName();
    }

    String getBestMovie() {
        Collections.sort(movieList);
        return movieList.get(movieList.size() - 1).getName();
    }

    void printDatabase() {
        for (Actor actor: getActorList()) {
            out.printf("%s:\t", actor.getName());
            for (Movie movie: actor.getMovies()) {
                out.printf("%s\t", movie.getName());
            }
            out.println();
        }
    }

    public static void main(String[] args) {
        MovieDatabase favorites = new MovieDatabase();
        File rating_file = new File("C:\\Users\\sMich\\IdeaProjects\\SD1x\\src\\week_III\\ratings.txt");
        File movie_file = new File("C:\\Users\\sMich\\IdeaProjects\\SD1x\\src\\week_III\\movies.txt");
        HashMap<String, List<String>> map = new HashMap<>();
        try {
            Scanner scan = new Scanner(movie_file);
            Scanner scanner = new Scanner(rating_file);
            while (scan.hasNext()) {
                String[] line = scan.nextLine().split(", ");
                String[] titles = Arrays.copyOfRange(line, 1, line.length);

                for (String title: titles) {
                    if (map.containsKey(title)) {
                        List<String> values = map.get(title);
                        values.add(line[0]);
                    }
                    else {
                        List<String> values = new ArrayList<>();
                        values.add(line[0]);
                        map.put(title, values);
                    }
                }
            }
            map.keySet().forEach((String key) -> favorites.addMovie(key, map.get(key).toArray(new String[map.get(key)
                    .size()])));
            while (scanner.hasNext()) {
                String[] rate = scanner.nextLine().split("\t");
                favorites.addRating(rate[0], Double.parseDouble(rate[1]));
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.toString());
        }
        favorites.printDatabase();
        System.out.println("---------------------");
        System.out.printf("The best actor in this movie database is %s\n", favorites.getBestActor());
        System.out.printf("The best movie in this movie database is %s\n", favorites.getBestMovie());
    }
}
