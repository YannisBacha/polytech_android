package yannisbacha.polytech.fr.exercice1.Activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Movie;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
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
    private RelativeLayout moviecard;
    private Button btnCategories;
    public static List<MovieListingItem> movieListingItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listing);
        movieListingItems = MovieManager.getInstance(this).getMovies();

        btnCategories = findViewById(R.id.btnCategories);
        btnCategories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListingActivity.this, CategoryActivity.class);
                startActivity(intent);
            }
        });

        listingRecyclerView = findViewById(R.id.listingRV);
        ListingAdapter la = new ListingAdapter(this);
        la.setViewManager(this);
        listingRecyclerView.setAdapter(la);
        listingRecyclerView.setLayoutManager(new LinearLayoutManager(this));
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
