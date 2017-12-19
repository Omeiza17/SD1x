package week_III;

import java.util.ArrayList;

public class Movie implements Comparable<Movie> {
    private String name;
    private ArrayList<Actor> actors;
    private double rating;

    Movie(String name) {
        this.name = name;
        actors = new ArrayList<>();
        rating = 0.0;
    }

    public Movie() {
        this("");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Actor> getActors() {
        return actors;
    }

    public void setActors(ArrayList<Actor> actors) {
        this.actors = actors;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public boolean equals(Object otherMovie) {
        return otherMovie instanceof Movie && ((Movie)otherMovie).getName().equals(this.getName());
    }

    @Override
    public String toString() {
        return String.format("%s has a rating of %.2f", this.getName(), this.getRating());
    }

    @Override
    public int compareTo(Movie object) {
        double diff = this.getRating() - object.getRating();
        if (diff > 0) return 1;
        else if (diff == 0) return 0;
        return -1;
    }
}
