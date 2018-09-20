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

        btnCategories = findViewById(R.id.btnCategories);
        btnCategories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, CategoryActivity.class);
                startActivity(intent);
            }
        });

        btnDetails = findViewById(R.id.btnDetails);
        btnDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, MovieReviewActivity.class);
                intent.putExtra("Titre","Jurassic Park");
                intent.putExtra("Image", "@drawable/jurassic");
                intent.putExtra("Description","Description : Ne pas réveiller le chat qui dort, c'est ce que le milliardaire John Hammond aurait dû se rappeler avant de se lancer dans le clonage de dinosaures. C'est à partir d'une goutte de sang absorbée par un moustique fossilisé que John Hammond et son équipe ont réussi à faire renaître une dizaine d'espèces de dinosaures.");
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