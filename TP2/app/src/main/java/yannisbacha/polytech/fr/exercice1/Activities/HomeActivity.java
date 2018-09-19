package yannisbacha.polytech.fr.exercice1.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import yannisbacha.polytech.fr.exercice1.R;

public class HomeActivity extends AppCompatActivity{
    private Button btnDetails;
    private Button btnCategories;
    private Button btnListing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnDetails = findViewById(R.id.btnDetails);
        btnCategories = findViewById(R.id.btnCategories);
        btnCategories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, CategoryActivity.class);
                startActivity(intent);
            }
        });
        btnDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, MovieReviewActivity.class);
                startActivity(intent);
            }
        });

        btnListing = findViewById(R.id.btnListing);
        btnListing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, ListingActivity.class);
                startActivity(intent);
            }
        });
    }
}