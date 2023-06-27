package com.example.myinsta;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class StoryView extends AppCompatActivity {
    ImageView img;
    FloatingActionButton likebutton,sendbutton;
    Resources res;

    static int i=0;
    Intent io;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_view);
        Bundle b=getIntent().getExtras();
        img=findViewById(R.id.imagestory);
        img.setImageResource((Integer) b.get("image"));
        likebutton=findViewById(R.id.storylike);
        io=new Intent(this,MainActivity.class);
        sendbutton=findViewById(R.id.storysend);
        res=getResources();
        likebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i==0)
                {
                    likebutton.setForeground(ResourcesCompat.getDrawable(res,R.drawable.storyliked,null));
                    i=1;
                }
                else {
                    likebutton.setForeground(ResourcesCompat.getDrawable(res,R.drawable.storylike,null));
                    i=0;
                }
            }
        });
        sendbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(io);
            }
        });

    }
}