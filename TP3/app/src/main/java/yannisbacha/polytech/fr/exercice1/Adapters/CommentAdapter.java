package yannisbacha.polytech.fr.exercice1.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import yannisbacha.polytech.fr.exercice1.Models.Comment;
import yannisbacha.polytech.fr.exercice1.R;
import yannisbacha.polytech.fr.exercice1.ViewHolders.CommentViewHolder;

public class CommentAdapter extends MainAdapter {
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_comment, parent, false);
        CommentViewHolder cvh = new CommentViewHolder(view);
        return cvh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        Comment com = (Comment) getViewManager().getObjects().get(i);
        if(viewHolder instanceof CommentViewHolder && com != null) {
            CommentViewHolder cvh = (CommentViewHolder) viewHolder;
            cvh.fillComment(com);
        }
    }
}
