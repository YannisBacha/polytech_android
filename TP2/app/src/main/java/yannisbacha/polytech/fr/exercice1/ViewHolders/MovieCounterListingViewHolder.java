package yannisbacha.polytech.fr.exercice1.ViewHolders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import yannisbacha.polytech.fr.exercice1.Models.Alphabet;
import yannisbacha.polytech.fr.exercice1.Models.MovieCounter;
import yannisbacha.polytech.fr.exercice1.R;

public class MovieCounterListingViewHolder extends RecyclerView.ViewHolder {
    private TextView counter;

    public MovieCounterListingViewHolder(@NonNull View itemView) {
        super(itemView);

        counter = itemView.findViewById(R.id.movieCounter);
    }

    public void fillCounter(MovieCounter movieCounter) {
        if (counter != null) {
            counter.setText(movieCounter.getNumberOfMovies());
        }
    }
}
