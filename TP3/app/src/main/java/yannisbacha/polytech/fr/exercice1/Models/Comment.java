package yannisbacha.polytech.fr.exercice1.Models;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import yannisbacha.polytech.fr.exercice1.R;

public class Comment {
    private Bitmap avatar;
    private String username;
    private String comment;

    public Comment(String username, String comment, Context cnt) {
        this.setAvatar(BitmapFactory.decodeResource(cnt.getResources(), R.mipmap.avatar));
        this.username = username;
        this.comment = comment;
    }

    public Bitmap getAvatar() {
        return avatar;
    }

    public void setAvatar(Bitmap avatar) {
        this.avatar = avatar;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
