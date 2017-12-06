package week_III;

import java.util.ArrayList;

public class Actor implements Comparable<Actor> {
    private String name;
    private ArrayList<Movie> movies;

    Actor(String name) {
        this.name = name;
        movies = new ArrayList<>();
    }
    public Actor(){
        this("");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    public double getActorRating() {
        double ratingSum = 0.0;
        for (Movie movie: getMovies()) ratingSum += movie.getRating();
        return ratingSum / getMovies().size();
    }

    public boolean equals(Object otherActor) {
        return otherActor instanceof Actor && ((Actor) otherActor).getName().equals(this.getName());
    }

    @Override
    public String toString() {
        return String.format("%s has an average rating of %s", getName(), getActorRating());
    }

    @Override
    public int compareTo(Actor object) {
        double diff = this.getActorRating() - object.getActorRating();
        if (diff > 0) return 1;
        else if (diff == 0) return 0;
        else return -1;
    }
}
