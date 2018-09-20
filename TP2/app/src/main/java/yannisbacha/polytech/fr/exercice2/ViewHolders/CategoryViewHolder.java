package yannisbacha.polytech.fr.exercice2.ViewHolders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import yannisbacha.polytech.fr.exercice2.Models.Category;
import yannisbacha.polytech.fr.exercice2.R;

public class CategoryViewHolder extends RecyclerView.ViewHolder {
    private TextView name;

    public CategoryViewHolder(@NonNull View itemView) {
        super(itemView);

        name = itemView.findViewById(R.id.textCategory);
    }

    public void fillCategory(Category category) {
        if(category != null && name != null) {
            name.setText(category.getName());
        }
    }
}
