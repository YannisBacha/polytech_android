package yannisbacha.polytech.fr.exercice1.ViewHolders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import yannisbacha.polytech.fr.exercice1.Models.MovieCard;
import yannisbacha.polytech.fr.exercice1.R;

public class MovieListingViewHolder extends RecyclerView.ViewHolder {
    private RelativeLayout movieCard;
    private ImageView movieImg;
    private TextView movieCardName;
    private TextView movieCardDescription;
    private ImageView movieDetailsLink;

    public MovieListingViewHolder(@NonNull View itemView) {
        super(itemView);

        movieCard = itemView.findViewById(R.id.movieCard);
        movieImg = itemView.findViewById(R.id.movieImg);
        movieCardName = itemView.findViewById(R.id.movieCardName);
        movieCardDescription = itemView.findViewById(R.id.movieCardDescription);
        movieDetailsLink = itemView.findViewById(R.id.movieDetailsLink);
    }

    public void fillCard(MovieCard movieCard) {
        if (movieCard != null) {
            if (movieImg != null){
                movieImg.setImageBitmap(movieCard.getImg());
            }
            if (movieCardName != null){
                movieCardName.setText(movieCard.getName());
            }
            if (movieCardDescription != null){
                movieCardDescription.setText(movieCard.getDescription());
            }
            if (this.movieCard != null) {
                this.movieCard.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        /*Intent intent = new Intent();
                        startActivity(intent);*/
                    }
                });
            }
        }
    }
}