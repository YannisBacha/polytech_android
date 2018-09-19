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

public class ListingAdapter extends RecyclerView.Adapter {
    private List<MovieCard> movieCards;

    public ListingAdapter(Context cnt) {
        this.createListing(cnt);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_film_card, parent, false);
        ListingViewHolder lvh = new ListingViewHolder(view);
        return lvh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        MovieCard card = movieCards.get(i);
        if(viewHolder instanceof ListingViewHolder && card != null) {
            ListingViewHolder lvh = (ListingViewHolder) viewHolder;
            lvh.fillCard(card);
        }
    }

    @Override
    public int getItemCount() {
        if(movieCards != null)
            return movieCards.size();
        return 0;
    }

    public void createListing(Context cnt) {
        movieCards = new ArrayList<MovieCard>();
        movieCards.add(new MovieCard(BitmapFactory.decodeResource(cnt.getResources(), R.mipmap.jurassic), "Jurassic", "balbalbalbalbalabalbalbalabl blab l bla bl abal bal balbalblablabla bl bl"));
        movieCards.add(new MovieCard(BitmapFactory.decodeResource(cnt.getResources(), R.mipmap.jurassic), "Jurassic", "balbalbalbalbalabalbalbalabl blab l bla bl abal bal balbalblablabla bl bl"));
        movieCards.add(new MovieCard(BitmapFactory.decodeResource(cnt.getResources(), R.mipmap.jurassic), "Jurassic", "balbalbalbalbalabalbalbalabl blab l bla bl abal bal balbalblablabla bl bl"));
        movieCards.add(new MovieCard(BitmapFactory.decodeResource(cnt.getResources(), R.mipmap.jurassic), "Jurassic", "balbalbalbalbalabalbalbalabl blab l bla bl abal bal balbalblablabla bl bl"));
        movieCards.add(new MovieCard(BitmapFactory.decodeResource(cnt.getResources(), R.mipmap.jurassic), "Jurassic", "balbalbalbalbalabalbalbalabl blab l bla bl abal bal balbalblablabla bl bl"));
        movieCards.add(new MovieCard(BitmapFactory.decodeResource(cnt.getResources(), R.mipmap.jurassic), "Jurassic", "balbalbalbalbalabalbalbalabl blab l bla bl abal bal balbalblablabla bl bl"));
        movieCards.add(new MovieCard(BitmapFactory.decodeResource(cnt.getResources(), R.mipmap.jurassic), "Jurassic", "balbalbalbalbalabalbalbalabl blab l bla bl abal bal balbalblablabla bl bl"));
        movieCards.add(new MovieCard(BitmapFactory.decodeResource(cnt.getResources(), R.mipmap.jurassic), "Jurassic", "balbalbalbalbalabalbalbalabl blab l bla bl abal bal balbalblablabla bl bl"));
        movieCards.add(new MovieCard(BitmapFactory.decodeResource(cnt.getResources(), R.mipmap.jurassic), "Jurassic", "balbalbalbalbalabalbalbalabl blab l bla bl abal bal balbalblablabla bl bl"));
        movieCards.add(new MovieCard(BitmapFactory.decodeResource(cnt.getResources(), R.mipmap.jurassic), "Jurassic", "balbalbalbalbalabalbalbalabl blab l bla bl abal bal balbalblablabla bl bl"));
        movieCards.add(new MovieCard(BitmapFactory.decodeResource(cnt.getResources(), R.mipmap.jurassic), "Jurassic", "balbalbalbalbalabalbalbalabl blab l bla bl abal bal balbalblablabla bl bl"));
        movieCards.add(new MovieCard(BitmapFactory.decodeResource(cnt.getResources(), R.mipmap.jurassic), "Jurassic", "balbalbalbalbalabalbalbalabl blab l bla bl abal bal balbalblablabla bl bl"));
        movieCards.add(new MovieCard(BitmapFactory.decodeResource(cnt.getResources(), R.mipmap.jurassic), "Jurassic", "balbalbalbalbalabalbalbalabl blab l bla bl abal bal balbalblablabla bl bl"));
        movieCards.add(new MovieCard(BitmapFactory.decodeResource(cnt.getResources(), R.mipmap.jurassic), "Jurassic", "balbalbalbalbalabalbalbalabl blab l bla bl abal bal balbalblablabla bl bl"));
        movieCards.add(new MovieCard(BitmapFactory.decodeResource(cnt.getResources(), R.mipmap.jurassic), "Jurassic", "balbalbalbalbalabalbalbalabl blab l bla bl abal bal balbalblablabla bl bl"));
        movieCards.add(new MovieCard(BitmapFactory.decodeResource(cnt.getResources(), R.mipmap.jurassic), "Jurassic", "balbalbalbalbalabalbalbalabl blab l bla bl abal bal balbalblablabla bl bl"));
    }
}
