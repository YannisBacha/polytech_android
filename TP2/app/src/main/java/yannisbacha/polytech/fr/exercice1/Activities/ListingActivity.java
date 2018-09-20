package yannisbacha.polytech.fr.exercice1.Activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yannisbacha.polytech.fr.exercice1.Adapters.ListingAdapter;
import yannisbacha.polytech.fr.exercice1.Models.Alphabet;
import yannisbacha.polytech.fr.exercice1.Models.MovieCard;
import yannisbacha.polytech.fr.exercice1.Models.MovieCounter;
import yannisbacha.polytech.fr.exercice1.Models.MovieListingItem;
import yannisbacha.polytech.fr.exercice1.R;

public class ListingActivity extends AppCompatActivity implements IRecyclerViewManager {
    private RecyclerView listingRecyclerView;
    public static List<MovieListingItem> movieListingItems;
    private RelativeLayout moviecard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listing);
        createListing();
        organiseListing();

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

        listingRecyclerView = findViewById(R.id.listingRV);
        ListingAdapter la = new ListingAdapter(this);
        la.setViewManager(this);
        listingRecyclerView.setAdapter(la);
        listingRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    // Retour à la page d'accueil
    private void backToHome() {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

    public void createListing() {
        Context cnt = this;
        movieListingItems = new ArrayList<>();
        movieListingItems.add(new MovieCard(BitmapFactory.decodeResource(cnt.getResources(), R.mipmap.avatarmovie), "Avatar", "avatarmovie", "Malgré sa paralysie, Jake Sully, un ancien marine immobilisé dans un fauteuil roulant, est resté un combattant au plus profond de son être. Il est recruté pour se rendre à des années-lumière de la Terre, sur Pandora, où de puissants groupes industriels exploitent un minerai rarissime destiné à résoudre la crise énergétique sur Terre."));
        movieListingItems.add(new MovieCard(BitmapFactory.decodeResource(cnt.getResources(), R.mipmap.jurassicworld), "Jurassic World", "jurassicworld", "L'île Nublar accueille maintenant un parc thématique complètement fonctionnel sur les dinosaures, appelé Jurassic World. Après dix ans d'opération et un nombre de visiteurs en chute libre, une nouvelle attraction est créée dans le but d'attirer d'autres curieux, mais les résultats ne sont pas exactement ceux auxquels l'organisation s'attendait."));
        movieListingItems.add(new MovieCard(BitmapFactory.decodeResource(cnt.getResources(), R.mipmap.jurassic), "Jurassic Park", "jurassic", "Ne pas réveiller le chat qui dort, c'est ce que le milliardaire John Hammond aurait dû se rappeler avant de se lancer dans le clonage de dinosaures. C'est à partir d'une goutte de sang absorbée par un moustique fossilisé que John Hammond et son équipe ont réussi à faire renaître une dizaine d'espèces de dinosaures."));
        movieListingItems.add(new MovieCard(BitmapFactory.decodeResource(cnt.getResources(), R.mipmap.jurassic2), "Jurassic Park 2 : Lost World", "jurassic2","Quatre ans après le terrible fiasco de son Jurassic Park, le milliardaire John Hammond rappelle le Dr Ian Malcolm pour l'informer de son nouveau projet. Sur une île déserte, voisine du parc, vivent en liberté des centaines de dinosaures de toutes tailles et de toutes espèces. Ce sont des descendants des animaux clonés en laboratoire. D'abord réticent, Ian se décide à rejoindre le docteur quand il apprend que sa fiancée fait partie de l'expédition scientifique."));
        movieListingItems.add(new MovieCard(BitmapFactory.decodeResource(cnt.getResources(), R.mipmap.spider), "Spider-Man : Homecoming", "spider", "Après ses spectaculaires débuts avec les Avengers, le jeune Peter Parker découvre peu à peu sa nouvelle identité, celle de Spider-Man, le superhéros lanceur de toile. Galvanisé par ses expériences précédentes, Peter rentre chez lui auprès de sa tante May, sous l'oeil attentif de son nouveau mentor, Tony Stark. L'apparition d'un nouvel ennemi, le Vautour, va mettre en danger tout ce qui compte pour lui."));
        movieListingItems.add(new MovieCard(BitmapFactory.decodeResource(cnt.getResources(), R.mipmap.spider1), "Spider-Man", "spider1", "Orphelin, Peter Parker est élevé par sa tante May et son oncle Ben dans le quartier Queens de New York. Tout en poursuivant ses études à l'université, il trouve un emploi de photographe au journal Daily Bugle. Il partage son appartement avec Harry Osborn, son meilleur ami, et rêve de séduire la belle Mary Jane."));
        movieListingItems.add(new MovieCard(BitmapFactory.decodeResource(cnt.getResources(), R.mipmap.jurassicworld2), "Jurassic World : Fallen Kingdom", "jurassicworld2", "Isla Nublar a été abandonnée par les humains alors que les dinosaures survivants sont livrés à eux-mêmes dans la jungle. Lorsque le volcan inactif de l'île commence à rugir, Owen et Claire s’organisent pour sauver les dinosaures restants de l’extinction.  Owen se fait un devoir de retrouver Blue, son principal raptor qui a disparu dans la nature, alors que Claire, qui a maintenant un véritable respect pour ces créatures, s’en fait une mission."));
        movieListingItems.add(new MovieCard(BitmapFactory.decodeResource(cnt.getResources(), R.mipmap.jurassic3), "Jurassic Park 3", "jurassic3", "Paul et Amanda Kirby, un couple de milliardaires, décident de survoler l'île de Sorna pour fêter leurs noces. Pour cela ils contactent le paléontologue Alan Grant, en besoin de subvention pour ses recherches, et lui proposent alors une grosse somme d'argent s'il leur fait survoler la fameuse île. Alan accepte mais celui-ci flaire une entourloupe lorsque le pilote amorce sa descente sur l'île."));
        movieListingItems.add(new MovieCard(BitmapFactory.decodeResource(cnt.getResources(), R.mipmap.rpo), "Ready Player One", "rpo", "En 2045, le monde est au bord du chaos. Les êtres humains se réfugient dans l'OASIS, univers virtuel mis au point par le brillant et excentrique James Halliday. Avant de disparaître, celui-ci a décidé de léguer son immense fortune à quiconque découvrira l'oeuf de Pâques numérique qu'il a pris soin de dissimuler dans l'OASIS. L'appât du gain provoque une compétition planétaire."));
    }

    private void organiseListing() {
        Collections.sort(movieListingItems);

        ArrayList<MovieListingItem> movieListingItemsFinal = new ArrayList<>();
        String currentLetter = null;
        int movieCounter = 0;

        for (MovieListingItem movie : movieListingItems) {
            if (currentLetter != null) {
                if (!((MovieCard) movie).getName().toLowerCase().substring(0,1).equals(currentLetter)) {
                    currentLetter = ((MovieCard) movie).getName().toLowerCase().substring(0,1);
                    movieListingItemsFinal.add(new MovieCounter(movieCounter + ""));
                    movieCounter = 0;
                    movieListingItemsFinal.add(new Alphabet(currentLetter));
                }
            }
            else {
                currentLetter = "a";
                movieListingItemsFinal.add(new Alphabet(currentLetter));
            }

            movieListingItemsFinal.add((MovieCard) movie);
            movieCounter++;
        }
        movieListingItemsFinal.add(new MovieCounter(movieCounter + ""));

        movieListingItems = movieListingItemsFinal;
    }

    @Override
    public int getItemCount() {
        return movieListingItems.size();
    }

    @Override
    public List<Object> getObjects() {
        return new ArrayList<Object>(movieListingItems);
    }
}
