package yannisbacha.polytech.fr.exercice1.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import yannisbacha.polytech.fr.exercice1.Models.Category;
import yannisbacha.polytech.fr.exercice1.R;
import yannisbacha.polytech.fr.exercice1.ViewHolders.CategoryViewHolder;

public class CategoryAdapter extends MainAdapter {
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_category, parent, false);
        CategoryViewHolder cvh = new CategoryViewHolder(view);
        return cvh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        Category cat = (Category) getViewManager().getObjects().get(i);
        if(viewHolder instanceof CategoryViewHolder && cat != null) {
            CategoryViewHolder cvh = (CategoryViewHolder) viewHolder;
            cvh.fillCategory(cat);
        }
    }
}
