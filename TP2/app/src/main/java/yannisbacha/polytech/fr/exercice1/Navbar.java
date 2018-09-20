package yannisbacha.polytech.fr.exercice1;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.widget.TextView;
import android.widget.RelativeLayout;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.content.Context;

public class Navbar extends RelativeLayout {
    public Navbar(Context context) {
        super(context);
        this.initialize(context, null);
    }

    public Navbar(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.initialize(context, attrs);
    }

    public Navbar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.initialize(context, attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public Navbar(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.initialize(context, attrs);
    }

    private void initialize(Context context, AttributeSet attrs) {
        inflate(context, R.layout.navbar, this);

        TextView titreTextView = findViewById(R.id.titre);
        TextView retourTextView = findViewById(R.id.retour);

        if (attrs != null) {
            TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.Navbar, 0, 0);

            String titre = array.getString(R.styleable.Navbar_titre);
            if (titreTextView != null) {
                titreTextView.setText(titre);
            }

            String retour = array.getString(R.styleable.Navbar_retour);
            if (retourTextView != null) {
                retourTextView.setText(retour);
            }

            array.recycle();
        }
    }
}
