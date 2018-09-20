package yannisbacha.polytech.fr.exercice1.Models;

import android.support.annotation.NonNull;

public class Alphabet extends MovieListingItem {
    private String letter;

    public Alphabet(String letter) {
        this.letter = letter;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    @Override
    public int compareTo(@NonNull MovieListingItem o) {
        return 0;
    }
}
