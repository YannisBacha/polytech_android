package yannisbacha.polytech.fr.exercice1.Adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Movie;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import yannisbacha.polytech.fr.exercice1.Activities.ListingActivity;
import yannisbacha.polytech.fr.exercice1.Activities.MovieManager;
import yannisbacha.polytech.fr.exercice1.Activities.MovieReviewActivity;
import yannisbacha.polytech.fr.exercice1.Models.Alphabet;
import yannisbacha.polytech.fr.exercice1.Models.MovieCard;
import yannisbacha.polytech.fr.exercice1.Models.MovieCounter;
import yannisbacha.polytech.fr.exercice1.R;
import yannisbacha.polytech.fr.exercice1.ViewHolders.AlphabetListingViewHolder;
import yannisbacha.polytech.fr.exercice1.ViewHolders.MovieCounterListingViewHolder;
import yannisbacha.polytech.fr.exercice1.ViewHolders.MovieListingViewHolder;

public class ListingAdapter extends MainAdapter {
    private Context context;
    public final static int ALPHABET_ROW_ID = 0;
    public final static int MOVIE_CARD_ROW_ID = 1;
    public final static int COUNTER_ROW_ID = 2;
    private MovieManager mm;

    public ListingAdapter(Context context) {
        this.context = context;
        this.mm =  MovieManager.getInstance(this.context);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case ALPHABET_ROW_ID :
                View viewAlphabet = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_alphabet, parent, false);
                return new AlphabetListingViewHolder(viewAlphabet);

            case MOVIE_CARD_ROW_ID :
                View viewMovieCard = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_film_card, parent, false);
                return new MovieListingViewHolder(viewMovieCard);

            case COUNTER_ROW_ID :
                View viewCounter = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_movie_counter, parent, false);
                return new MovieCounterListingViewHolder(viewCounter);

            default:
                View viewAlphabet2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_alphabet, parent, false);
                return new AlphabetListingViewHolder(viewAlphabet2);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        switch (viewHolder.getItemViewType()) {
            case ALPHABET_ROW_ID :
                Alphabet alphabet = (Alphabet) getViewManager().getObjects().get(i);
                if(viewHolder instanceof AlphabetListingViewHolder && alphabet != null) {
                    AlphabetListingViewHolder alvh = (AlphabetListingViewHolder) viewHolder;
                    alvh.fillLetter(alphabet);
                }
                break;

            case MOVIE_CARD_ROW_ID :
                MovieCard card = (MovieCard) getViewManager().getObjects().get(i);
                if(viewHolder instanceof MovieListingViewHolder && card != null) {
                    MovieListingViewHolder lvh = (MovieListingViewHolder) viewHolder;
                    lvh.fillCard(card);
                }
                break;

            case COUNTER_ROW_ID :
                MovieCounter movieCounter = (MovieCounter) getViewManager().getObjects().get(i);
                if(viewHolder instanceof MovieCounterListingViewHolder && movieCounter != null) {
                    MovieCounterListingViewHolder lvh = (MovieCounterListingViewHolder) viewHolder;
                    lvh.fillCounter(movieCounter);
                }
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (mm.getMovieByID(position) instanceof Alphabet)
            return ALPHABET_ROW_ID;
        if (mm.getMovieByID(position) instanceof MovieCard)
            return MOVIE_CARD_ROW_ID;
        if (mm.getMovieByID(position) instanceof MovieCounter)
            return COUNTER_ROW_ID;

        return ALPHABET_ROW_ID;
    }
}
