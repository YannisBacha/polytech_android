package yannisbacha.polytech.fr.exercice1.ViewHolders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import yannisbacha.polytech.fr.exercice1.Models.Alphabet;
import yannisbacha.polytech.fr.exercice1.Models.MovieCard;
import yannisbacha.polytech.fr.exercice1.R;

public class AlphabetListingViewHolder extends RecyclerView.ViewHolder {
    private TextView letter;

    public AlphabetListingViewHolder(@NonNull View itemView) {
        super(itemView);

        letter = itemView.findViewById(R.id.letterAlphabet);
    }

    public void fillLetter(Alphabet alphabet) {
        if (letter != null) {
            letter.setText(alphabet.getLetter());
        }
    }
}
