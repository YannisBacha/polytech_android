package yannisbacha.polytech.fr.exercice1.Activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Movie;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import yannisbacha.polytech.fr.exercice1.Adapters.CommentAdapter;
import yannisbacha.polytech.fr.exercice1.Models.Comment;
import yannisbacha.polytech.fr.exercice1.Models.MovieCard;
import yannisbacha.polytech.fr.exercice1.Models.MovieListingItem;
import yannisbacha.polytech.fr.exercice1.R;

public class MovieReviewActivity extends AppCompatActivity implements IRecyclerViewManager{
    private EditText commentaireEditText;
    private boolean flagAimer;
    private LinearLayout aimerLinearLayout;
    private ImageView aimerImgView;
    private TextView aimerTextView;
    private RecyclerView commentRecyclerView;
    private CommentAdapter ca;
    private List<Comment> comments;
    private int anonymous;
    private MovieCard movie;

    private TextView titre;
    private TextView desc;
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moviereview);
        createComments();
        anonymous = 1;

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

        affichage();

        // Gestion des boutons (Partager,Commenter,Aimer)
        LinearLayout partagerLinearLayout = findViewById(R.id.btnPartager);
        partagerLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("image/jpeg");
                String titre = movie.getName();
                String description = movie.getDescription();
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Partage du film : " + titre);
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, "\n" +description);
                Uri uri = Uri.parse("android.resource://"+ getPackageName() +"/drawable/" + movie.getTag());
                sharingIntent.putExtra(Intent.EXTRA_STREAM, uri);
                sharingIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                startActivity(Intent.createChooser(sharingIntent, "Partager avec"));
             }
        });

        // On récupère la zone de texte pour y placer le focus
        commentaireEditText = findViewById(R.id.commentaireText);
        LinearLayout commenterLinearLayout = findViewById(R.id.btnCommenter);
        commenterLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                commentaireEditText.requestFocus();
                // Je n'arrivais pas à avoir le focus (source : https://stackoverflow.com/questions/17586102/edittext-request-focus-not-working)
                InputMethodManager imm = (InputMethodManager) getSystemService(getApplicationContext().INPUT_METHOD_SERVICE);
                imm.showSoftInput(commentaireEditText, InputMethodManager.SHOW_IMPLICIT);
            }
        });

        // On modifie le button "Aimer" pour pouvoir "Ne pas aimer"
        this.flagAimer = false;
        aimerLinearLayout = findViewById(R.id.btnAimer);
        aimerImgView = findViewById(R.id.btnAimerImg);
        aimerTextView = findViewById(R.id.btnAimerText);
        aimerLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(flagAimer) {
                    aimerLinearLayout.setBackgroundResource(R.drawable.special_button);
                    aimerTextView.setText(R.string.aimer);
                    aimerTextView.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.white));
                    aimerImgView.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.aimer));
                }
                else {
                    aimerLinearLayout.setBackgroundResource(R.drawable.special_buttonbis);
                    aimerTextView.setText(R.string.desaimer);
                    aimerTextView.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimaryDark));
                    aimerImgView.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.mipmap.desaimer));
                }
                flagAimer = !flagAimer;
            }
        });


        commentRecyclerView = findViewById(R.id.commentsRV);
        ca = new CommentAdapter();
        ca.setViewManager(this);
        commentRecyclerView.setAdapter(ca);
        commentRecyclerView.setLayoutManager(new LinearLayoutManager(this));


        // Gestion de la saisie du commentaire
        ImageButton envoyerImageButton = findViewById(R.id.commentaireAction);
        envoyerImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addComment();
                commentRecyclerView.scrollToPosition(ca.getItemCount()-1);
                commentaireEditText.setText("");
                InputMethodManager imm = (InputMethodManager) getSystemService(getApplicationContext().INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        });
    }

    // Retour à la page d'accueil
    private void backToHome() {
        onBackPressed();
    }

    public void createComments() {
        Context cnt = this;
        comments = new ArrayList<Comment>();
        comments.add(new Comment("Hysttos", "Superbe film <3", cnt));
        comments.add(new Comment("Hartyshow", "J'ai pas vu le film", cnt));
        comments.add(new Comment("Habrycot", "Je me suis endormi devant", cnt));
        comments.add(new Comment("Ato ", "J'ai dépensé sans compter", cnt));
        comments.add(new Comment("Hysttoria", "Superbe film <3", cnt));
        comments.add(new Comment("Gaëtan", "Superbe fdhzqduomqhfuekfhuheufhmofhihdoimehvusfhblfnleshqziljeslfhimqhiqz" +
                "bzjkdmzhqudqzl:dhquzdlmqzhdumodz \n zudiqzldgzuqidgqzukdlqzdqidludklqzhdiqzuomdhqzildzhq:dilqzdhmqlzilm <3", cnt));
        comments.add(new Comment("Alexandre", "J'ai pas vu le film", cnt));
        comments.add(new Comment("Pierre", "Superbe référence cinématographique", cnt));
    }

    public void addComment() {
        this.comments.add(new Comment("Anonyme " + anonymous, commentaireEditText.getText().toString(), this));
        ca.notifyItemInserted(this.getItemCount() -1);
        anonymous++;
    }

    @Override
    public int getItemCount() {
        return comments.size();
    }

    @Override
    public List<Object> getObjects() {
        return new ArrayList<Object>(comments);
    }

    private void affichage() {
        movie = (MovieCard) MovieManager.getInstance(this).getMovieByID(getIntent().getIntExtra("ID", 0));
        titre = findViewById(R.id.titre);
        titre.setText(movie.getName());
        titre = findViewById(R.id.titreMovie);
        titre.setText(movie.getName());
        titre = findViewById(R.id.titreMovie2);
        titre.setText(movie.getName());
        desc = findViewById(R.id.description);
        desc.setText(movie.getDescription());

        image = findViewById(R.id.imageMovie);
        int imgRessource = getResources().getIdentifier("@drawable/" + movie.getTag(), null,getApplicationContext().getPackageName());
        image.setImageDrawable(getResources().getDrawable(imgRessource));
    }
}
