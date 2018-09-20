package yannisbacha.polytech.fr.exercice1.Activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

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
    private RelativeLayout moviecard;

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
        movieListingItems.add(new MovieCard(BitmapFactory.decodeResource(cnt.getResources(), R.mipmap.avatarmovie), "Avatar", "balbalbalbalbalabalbalbalabl blab l bla bl abal bal balbalblablabla bl bl"));
        movieListingItems.add(new MovieCard(BitmapFactory.decodeResource(cnt.getResources(), R.mipmap.jurassicworld), "Jurassic World", "balbalbalbalbalabalbalbalabl blab l bla bl abal bal balbalblablabla bl bl"));
        movieListingItems.add(new MovieCard(BitmapFactory.decodeResource(cnt.getResources(), R.mipmap.jurassic), "Jurassic Park", "balbalbalbalbalabalbalbalabl blab l bla bl abal bal balbalblablabla bl bl"));
        movieListingItems.add(new MovieCard(BitmapFactory.decodeResource(cnt.getResources(), R.mipmap.jurassic2), "Jurassic Park 2 : Lost World", "balbalbalbalbalabalbalbalabl blab l bla bl abal bal balbalblablabla bl bl"));
        movieListingItems.add(new MovieCard(BitmapFactory.decodeResource(cnt.getResources(), R.mipmap.spider), "Spider-Man : Homecoming", "balbalbalbalbalabalbalbalabl blab l bla bl abal bal balbalblablabla bl bl"));
        movieListingItems.add(new MovieCard(BitmapFactory.decodeResource(cnt.getResources(), R.mipmap.spider1), "Spider-Man", "balbalbalbalbalabalbalbalabl blab l bla bl abal bal balbalblablabla bl bl"));
        movieListingItems.add(new MovieCard(BitmapFactory.decodeResource(cnt.getResources(), R.mipmap.jurassicworld2), "Jurassic World : Fallen Kingdom", "balbalbalbalbalabalbalbalabl blab l bla bl abal bal balbalblablabla bl bl"));
        movieListingItems.add(new MovieCard(BitmapFactory.decodeResource(cnt.getResources(), R.mipmap.jurassic3), "Jurassic Park 3", "balbalbalbalbalabalbalbalabl blab l bla bl abal bal balbalblablabla bl bl"));
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
        movieListingItemsFinal.add(new MovieCounter(movieCounter + ""));

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
