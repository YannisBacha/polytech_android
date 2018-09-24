package yannisbacha.polytech.fr.exercice1.Models;

import android.support.annotation.NonNull;

public class MovieCounter extends MovieListingItem {
    private String numberOfMovies;

    public MovieCounter(String numberOfMovies) {
        this.setNumberOfMovies(numberOfMovies);
    }

    public String getNumberOfMovies() {
        return numberOfMovies;
    }

    public void setNumberOfMovies(String numberOfMovies) {
        this.numberOfMovies = Integer.valueOf(numberOfMovies.split(" ")[0]) > 1 ? numberOfMovies + " films" : numberOfMovies + " film";
    }

    @Override
    public int compareTo(@NonNull MovieListingItem o) {
        return 0;
    }
}
