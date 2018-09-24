package yannisbacha.polytech.fr.exercice1.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import yannisbacha.polytech.fr.exercice1.Adapters.CategoryAdapter;
import yannisbacha.polytech.fr.exercice1.Models.Category;
import yannisbacha.polytech.fr.exercice1.R;

public class CategoryActivity extends AppCompatActivity implements IRecyclerViewManager{
    private RecyclerView categoryRecyclerView;
    private List<Category> categories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        createCategories();

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

        categoryRecyclerView = findViewById(R.id.categoriesRV);
        CategoryAdapter ca = new CategoryAdapter();
        ca.setViewManager(this);
        categoryRecyclerView.setAdapter(ca);
        categoryRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    // Retour à la page d'accueil
    private void backToHome() {
        onBackPressed();
    }

    @Override
    public int getItemCount() {
        return this.categories.size();
    }

    @Override
    public List<Object> getObjects() {
        return new ArrayList<Object>(categories);
    }

    public void createCategories() {
        categories = new ArrayList<>();
        categories.add(new Category("Action"));
        categories.add(new Category("Horreur"));
        categories.add(new Category("Aventure"));
        categories.add(new Category("Thriller"));
        categories.add(new Category("Documentaire"));
        categories.add(new Category("Comédie"));
        categories.add(new Category("Film Français"));
        categories.add(new Category("Crime"));
        categories.add(new Category("Fantastique"));
        categories.add(new Category("Western"));
        categories.add(new Category("Romance"));
        categories.add(new Category("Dramatique"));
        categories.add(new Category("Jeunesse"));
        categories.add(new Category("Science-Fiction"));
        categories.add(new Category("Action"));
        categories.add(new Category("Horreur"));
        categories.add(new Category("Aventure"));
        categories.add(new Category("Thriller"));
        categories.add(new Category("Documentaire"));
        categories.add(new Category("Comédie"));
        categories.add(new Category("Film Français"));
        categories.add(new Category("Crime"));
        categories.add(new Category("Fantastique"));
        categories.add(new Category("Western"));
        categories.add(new Category("Romance"));
        categories.add(new Category("Dramatique"));
        categories.add(new Category("Jeunesse"));
        categories.add(new Category("Science-Fiction"));
    }
}
