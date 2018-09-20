package yannisbacha.polytech.fr.exercice1.Adapters;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import yannisbacha.polytech.fr.exercice1.Models.Category;
import yannisbacha.polytech.fr.exercice1.Models.MovieCard;
import yannisbacha.polytech.fr.exercice1.R;
import yannisbacha.polytech.fr.exercice1.ViewHolders.CategoryViewHolder;
import yannisbacha.polytech.fr.exercice1.ViewHolders.ListingViewHolder;

public class ListingAdapter extends MainAdapter {
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_film_card, parent, false);
        ListingViewHolder lvh = new ListingViewHolder(view);
        return lvh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        MovieCard card = (MovieCard) getViewManager().getObjects().get(i);
        if(viewHolder instanceof ListingViewHolder && card != null) {
            ListingViewHolder lvh = (ListingViewHolder) viewHolder;
            lvh.fillCard(card);
        }
    }
}
