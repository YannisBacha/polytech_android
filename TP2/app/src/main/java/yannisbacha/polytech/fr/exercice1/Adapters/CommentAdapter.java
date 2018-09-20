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

public class CommentAdapter extends RecyclerView.Adapter {
    private List<Comment> comments;
    private Context cnt;

    public CommentAdapter(Context cnt){
        this.cnt = cnt;
        this.createComments(cnt);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_comment, parent, false);
        CommentViewHolder cvh = new CommentViewHolder(view);
        return cvh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        Comment com = comments.get(i);
        if(viewHolder instanceof CommentViewHolder && com != null) {
            CommentViewHolder cvh = (CommentViewHolder) viewHolder;
            cvh.fillComment(com);
        }
    }

    @Override
    public int getItemCount() {
        if(comments != null)
            return comments.size();
        return 0;
    }

    public void createComments(Context cnt) {
        comments = new ArrayList<Comment>();
        comments.add(new Comment("Hysttos", "Superbe film <3", cnt));
        comments.add(new Comment("Hartyshow", "J'ai pas vu le film", cnt));
        comments.add(new Comment("Hysttos", "Superbe film <3", cnt));
        comments.add(new Comment("Hartyshow", "J'ai pas vu le film", cnt));
        comments.add(new Comment("Hysttos", "Superbe film <3", cnt));
        comments.add(new Comment("Hysttos", "Superbe fdhzqduomqhfuekfhuheufhmofhihdoimehvusfhblfnleshqziljeslfhimqhiqz" +
                "bzjkdmzhqudqzl:dhquzdlmqzhdumodz \n zudiqzldgzuqidgqzukdlqzdqidludklqzhdiqzuomdhqzildzhq:dilqzdhmqlzilm <3", cnt));
        comments.add(new Comment("Hartyshow", "J'ai pas vu le film", cnt));
        comments.add(new Comment("Hysttos", "Superbe film <3", cnt));
        comments.add(new Comment("Hysttos", "Superbe film <3", cnt));
        comments.add(new Comment("Hartyshow", "J'ai pas vu le film", cnt));
        comments.add(new Comment("Hysttos", "Superbe film <3", cnt));
        comments.add(new Comment("Hysttos", "Superbe film <3", cnt));
        comments.add(new Comment("Hartyshow", "J'ai pas vu le film", cnt));
        comments.add(new Comment("Hysttos", "Superbe film <3", cnt));
        comments.add(new Comment("Hysttos", "Superbe film <3", cnt));
        comments.add(new Comment("Hartyshow", "J'ai pas vu le film", cnt));
        comments.add(new Comment("Hysttos", "Superbe film <3", cnt));
        comments.add(new Comment("Hysttos", "Superbe film <3", cnt));
        comments.add(new Comment("Hartyshow", "J'ai pas vu le film", cnt));
        comments.add(new Comment("Hysttos", "Superbe film <3", cnt));
        comments.add(new Comment("Hysttos", "Superbe film <3", cnt));
        comments.add(new Comment("Hartyshow", "J'ai pas vu le film", cnt));
        comments.add(new Comment("Hysttos", "Superbe film <3", cnt));

    }

    public void addComment(Comment comm) {
        this.comments.add(comm);
        this.notifyItemInserted(this.getItemCount() -1);
    }

    public Context getCnt() {
        return cnt;
    }
}
