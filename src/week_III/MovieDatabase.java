package week_III;

import java.util.ArrayList;
import java.util.Collections;

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
        return movieList.get(actorList.size() - 1).getName();
    }

    void printDatabase() {
        for (Actor actor: getActorList()) {
            System.out.printf("%s: ", actor.getName());
            for (Movie movie: actor.getMovies()) {
                System.out.printf("%s\t", movie.getName());
            }
            System.out.println();
        }
    }
}
