package yannisbacha.polytech.fr.exercice1.Models;

import android.graphics.Bitmap;

public class MovieCard {
    private Bitmap img;
    private String name;
    private String description;

    public MovieCard(Bitmap img, String name, String description) {
        this.img = img;
        this.name = name;
        this.description = "Description : " + description;
    }

    public Bitmap getImg() {
        return img;
    }

    public void setImg(Bitmap img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
