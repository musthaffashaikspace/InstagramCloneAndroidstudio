package com.example.myinsta;

import android.graphics.drawable.Drawable;

public class Postimages {
    int image;
    String str;

    public Postimages(int image, String str) {
        this.image = image;
        this.str = str;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
}
