package yannisbacha.polytech.fr.exercice1.Models;

import android.support.annotation.NonNull;

public abstract class MovieListingItem implements Comparable<MovieListingItem> {
    @Override
    public abstract int compareTo(@NonNull MovieListingItem o);
}
