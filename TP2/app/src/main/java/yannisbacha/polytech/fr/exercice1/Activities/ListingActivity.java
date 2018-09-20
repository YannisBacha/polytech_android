package yannisbacha.polytech.fr.exercice1.Activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yannisbacha.polytech.fr.exercice1.Adapters.ListingAdapter;
import yannisbacha.polytech.fr.exercice1.Models.Alphabet;
import yannisbacha.polytech.fr.exercice1.Models.MovieCard;
import yannisbacha.polytech.fr.exercice1.Models.MovieCounter;
import yannisbacha.polytech.fr.exercice1.Models.MovieListingItem;
import yannisbacha.polytech.fr.exercice1.R;

public class ListingActivity extends AppCompatActivity implements IRecyclerViewManager {
    private RecyclerView listingRecyclerView;
    public static List<MovieListingItem> movieListingItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listing);
        createListing();
        organiseListing();

        // Gestion de la NavBar
        ImageButton closeButton = findViewById(R.id.closeButton);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backToHome();
            }
        });

        LinearLayout backLinearLayout = findViewById(R.id.backButton);
        backLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backToHome();
            }
        });

        listingRecyclerView = findViewById(R.id.listingRV);
        ListingAdapter la = new ListingAdapter();
        la.setViewManager(this);
        listingRecyclerView.setAdapter(la);
        listingRecyclerView.setLayoutManager(new LinearLayoutManager(this));


    }

    // Retour à la page d'accueil
    private void backToHome() {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

    public void createListing() {
        Context cnt = this;
        movieListingItems = new ArrayList<>();
        movieListingItems.add(new MovieCard(BitmapFactory.decodeResource(cnt.getResources(), R.mipmap.jurassic), "Jurassic", "balbalbalbalbalabalbalbalabl blab l bla bl abal bal balbalblablabla bl bl"));
        movieListingItems.add(new MovieCard(BitmapFactory.decodeResource(cnt.getResources(), R.mipmap.jurassic), "Aurassic", "balbalbalbalbalabalbalbalabl blab l bla bl abal bal balbalblablabla bl bl"));
        movieListingItems.add(new MovieCard(BitmapFactory.decodeResource(cnt.getResources(), R.mipmap.jurassic), "Jurassic", "balbalbalbalbalabalbalbalabl blab l bla bl abal bal balbalblablabla bl bl"));
        movieListingItems.add(new MovieCard(BitmapFactory.decodeResource(cnt.getResources(), R.mipmap.jurassic), "Jurassic", "balbalbalbalbalabalbalbalabl blab l bla bl abal bal balbalblablabla bl bl"));
        movieListingItems.add(new MovieCard(BitmapFactory.decodeResource(cnt.getResources(), R.mipmap.jurassic), "Lurassic", "balbalbalbalbalabalbalbalabl blab l bla bl abal bal balbalblablabla bl bl"));
        movieListingItems.add(new MovieCard(BitmapFactory.decodeResource(cnt.getResources(), R.mipmap.jurassic), "Jurassic", "balbalbalbalbalabalbalbalabl blab l bla bl abal bal balbalblablabla bl bl"));
        movieListingItems.add(new MovieCard(BitmapFactory.decodeResource(cnt.getResources(), R.mipmap.jurassic), "Burassic", "balbalbalbalbalabalbalbalabl blab l bla bl abal bal balbalblablabla bl bl"));
        movieListingItems.add(new MovieCard(BitmapFactory.decodeResource(cnt.getResources(), R.mipmap.jurassic), "Burassic", "balbalbalbalbalabalbalbalabl blab l bla bl abal bal balbalblablabla bl bl"));
        movieListingItems.add(new MovieCard(BitmapFactory.decodeResource(cnt.getResources(), R.mipmap.jurassic), "JLurassic", "balbalbalbalbalabalbalbalabl blab l bla bl abal bal balbalblablabla bl bl"));
        movieListingItems.add(new MovieCard(BitmapFactory.decodeResource(cnt.getResources(), R.mipmap.jurassic), "Jurassic", "balbalbalbalbalabalbalbalabl blab l bla bl abal bal balbalblablabla bl bl"));
        movieListingItems.add(new MovieCard(BitmapFactory.decodeResource(cnt.getResources(), R.mipmap.jurassic), "Curassic", "balbalbalbalbalabalbalbalabl blab l bla bl abal bal balbalblablabla bl bl"));
        movieListingItems.add(new MovieCard(BitmapFactory.decodeResource(cnt.getResources(), R.mipmap.jurassic), "Jurassic", "balbalbalbalbalabalbalbalabl blab l bla bl abal bal balbalblablabla bl bl"));
        movieListingItems.add(new MovieCard(BitmapFactory.decodeResource(cnt.getResources(), R.mipmap.jurassic), "Hurassic", "balbalbalbalbalabalbalbalabl blab l bla bl abal bal balbalblablabla bl bl"));
        movieListingItems.add(new MovieCard(BitmapFactory.decodeResource(cnt.getResources(), R.mipmap.jurassic), "Jurassic", "balbalbalbalbalabalbalbalabl blab l bla bl abal bal balbalblablabla bl bl"));
        movieListingItems.add(new MovieCard(BitmapFactory.decodeResource(cnt.getResources(), R.mipmap.jurassic), "Lurassic", "balbalbalbalbalabalbalbalabl blab l bla bl abal bal balbalblablabla bl bl"));
        movieListingItems.add(new MovieCard(BitmapFactory.decodeResource(cnt.getResources(), R.mipmap.jurassic), "Jurassic", "balbalbalbalbalabalbalbalabl blab l bla bl abal bal balbalblablabla bl bl"));
    }

    private void organiseListing() {
        Collections.sort(movieListingItems);

        ArrayList<MovieListingItem> movieListingItemsFinal = new ArrayList<>();
        String currentLetter = null;
        int movieCounter = 0;

        for (MovieListingItem movie : movieListingItems) {
            if (currentLetter != null) {
                if (!((MovieCard) movie).getName().toLowerCase().substring(0,1).equals(currentLetter)) {
                    currentLetter = ((MovieCard) movie).getName().toLowerCase().substring(0,1);
                    movieListingItemsFinal.add(new MovieCounter(movieCounter + ""));
                    movieCounter = 0;
                    movieListingItemsFinal.add(new Alphabet(currentLetter));
                }
            }
            else {
                currentLetter = "a";
                movieListingItemsFinal.add(new Alphabet(currentLetter));
            }

            movieListingItemsFinal.add((MovieCard) movie);
            movieCounter++;
        }

        movieListingItems = movieListingItemsFinal;

    }

    @Override
    public int getItemCount() {
        return movieListingItems.size();
    }

    @Override
    public List<Object> getObjects() {
        return new ArrayList<Object>(movieListingItems);
    }
}
