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

import java.util.ArrayList;
import java.util.List;

import yannisbacha.polytech.fr.exercice1.Adapters.ListingAdapter;
import yannisbacha.polytech.fr.exercice1.Models.MovieCard;
import yannisbacha.polytech.fr.exercice1.R;

public class ListingActivity extends AppCompatActivity implements IRecyclerViewManager{
    private RecyclerView listingRecyclerView;
    private List<MovieCard> movieCards;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listing);
        createListing();

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

    @Override
    public int getItemCount() {
        return movieCards.size();
    }

    @Override
    public List<Object> getObjects() {
        return new ArrayList<Object>(movieCards);
    }
}
