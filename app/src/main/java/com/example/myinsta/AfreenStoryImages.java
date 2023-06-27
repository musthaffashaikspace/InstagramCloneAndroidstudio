package com.example.myinsta;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

public class AfreenStoryImages {
    private int img;
    private Drawable drawable;

    public AfreenStoryImages(int img, Drawable drawable) {
        this.img = img;
        this.drawable = drawable;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public Drawable getDrawable() {
        return drawable;
    }

    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
    }
}
