package yannisbacha.polytech.fr.exercice2.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import yannisbacha.polytech.fr.exercice2.Models.Category;
import yannisbacha.polytech.fr.exercice2.R;
import yannisbacha.polytech.fr.exercice2.ViewHolders.CategoryViewHolder;

public class CategoryAdapter extends RecyclerView.Adapter {
    private List<Category> categories;

    public CategoryAdapter() {
        this.createCategories();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_category, parent, false);
        CategoryViewHolder cvh = new CategoryViewHolder(view);
        return cvh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        Category cat = categories.get(i);
        if(viewHolder instanceof CategoryViewHolder && cat != null) {
            CategoryViewHolder cvh = (CategoryViewHolder) viewHolder;
            cvh.fillCategory(cat);
        }
    }

    @Override
    public int getItemCount() {
        if(categories != null)
            return categories.size();
        return 0;
    }

    public void createCategories() {
        categories = new ArrayList<Category>();
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
