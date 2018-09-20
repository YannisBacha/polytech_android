package yannisbacha.polytech.fr.exercice2.ViewHolders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import yannisbacha.polytech.fr.exercice2.Models.Category;
import yannisbacha.polytech.fr.exercice2.Models.Comment;
import yannisbacha.polytech.fr.exercice2.R;

public class CommentViewHolder extends RecyclerView.ViewHolder {
    private TextView username;
    private TextView comment;
    private ImageView avatar;

    public CommentViewHolder(@NonNull View itemView) {
        super(itemView);

        username = itemView.findViewById(R.id.commentUser);
        comment = itemView.findViewById(R.id.commentText);
        avatar = itemView.findViewById(R.id.avatar);

    }

    public void fillComment(Comment comment) {
        if(comment != null) {
            if(username != null)
                username.setText(comment.getUsername());
            if(this.comment != null)
                this.comment.setText(comment.getComment());
            if(avatar != null)
                avatar.setImageBitmap(comment.getAvatar());
        }
    }
}
