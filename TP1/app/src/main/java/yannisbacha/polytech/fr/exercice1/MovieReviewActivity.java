package yannisbacha.polytech.fr.exercice1;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MovieReviewActivity extends AppCompatActivity {
    private EditText commentaireEditText;
    private boolean flagAimer;
    private LinearLayout aimerLinearLayout;
    private ImageView aimerImgView;
    private TextView aimerTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moviereview);

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

        // Gestion des boutons (Partager,Commenter,Aimer)
        LinearLayout partagerLinearLayout = findViewById(R.id.btnPartager);
        partagerLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MovieReviewActivity.this, R.string.partagerAction, Toast.LENGTH_SHORT).show();
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
                    aimerTextView.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.colorWhite));
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

        // Gestion de la saisie du commentaire
        ImageButton envoyerImageButton = findViewById(R.id.commentaireAction);
        envoyerImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MovieReviewActivity.this);
                builder.setTitle(R.string.commMessage)
                       .setMessage(commentaireEditText.getText())
                       .setPositiveButton(R.string.fermer, new DialogInterface.OnClickListener() {
                           public void onClick(DialogInterface dialog, int which) {
                               dialog.dismiss();
                           }
                       }).show();
                // On vide la chaine après envoi
                commentaireEditText.setText("");
            }
        });
    }

    // Retour à la page d'accueil
    private void backToHome() {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

}
