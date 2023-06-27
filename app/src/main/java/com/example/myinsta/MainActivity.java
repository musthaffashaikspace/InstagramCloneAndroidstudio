package com.example.myinsta;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    MaterialToolbar topappbar;
    RecyclerView storyrecyclerview,postscrollrecyview;

    BottomNavigationView bottomappbar;
    Intent hometosearch,hometoreels,hometocamera;
    RelativeLayout mainactivity;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainactivity=findViewById(R.id.mainactivity);
        topappbar=findViewById(R.id.topappbar);
        bottomappbar=findViewById(R.id.bottomappbar);
        storyrecyclerview=findViewById(R.id.storyrecycleview);
        postscrollrecyview=findViewById(R.id.postscrollrecyview);
        hometosearch=new Intent(this,Search_Activity.class);
        hometoreels=new Intent(this,Reels_Activity.class);
        hometocamera=new Intent(this,Camera.class);
        Resources res=getResources();
        List<AfreenStoryImages> StoryImagesList=new ArrayList<>();
        List<Postimages> imagesforposts=new ArrayList<>();
        StoryImagesList.add(new AfreenStoryImages(R.drawable.person,ResourcesCompat.getDrawable(res,R.drawable.person,null)));
        StoryImagesList.add(new AfreenStoryImages(R.drawable.delhi,ResourcesCompat.getDrawable(res,R.drawable.delhi,null)));
        StoryImagesList.add(new AfreenStoryImages(R.drawable.turkeymarkets,ResourcesCompat.getDrawable(res,R.drawable.turkeymarkets,null)));
        StoryImagesList.add(new AfreenStoryImages(R.drawable.samarkand,ResourcesCompat.getDrawable(res,R.drawable.samarkand,null)));
        StoryImagesList.add(new AfreenStoryImages(R.drawable.peshawar,ResourcesCompat.getDrawable(res,R.drawable.peshawar,null)));
        StoryImagesList.add(new AfreenStoryImages(R.drawable.olddelhi,ResourcesCompat.getDrawable(res,R.drawable.olddelhi,null)));
        StoryImagesList.add(new AfreenStoryImages(R.drawable.tajmahal1,ResourcesCompat.getDrawable(res,R.drawable.tajmahal1,null)));
        StoryImagesList.add(new AfreenStoryImages(R.drawable.train,ResourcesCompat.getDrawable(res,R.drawable.train,null)));
        StoryImagesList.add(new AfreenStoryImages(R.drawable.takjamahal2,ResourcesCompat.getDrawable(res,R.drawable.takjamahal2,null)));
        RecyclerViewAdapterStory recyclerViewAdapterStory=new RecyclerViewAdapterStory(this);
        recyclerViewAdapterStory.setAfreenStoryImagesList(StoryImagesList);
        storyrecyclerview.setAdapter(recyclerViewAdapterStory);
        storyrecyclerview.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,
                false));

        imagesforposts.add(new Postimages(R.drawable.salman,"beingsalmankhan"));
        imagesforposts.add(new Postimages(R.drawable.virat,"viratkohli"));
        imagesforposts.add(new Postimages(R.drawable.messi,"leomessi"));
        imagesforposts.add(new Postimages(R.drawable.diana,"royalarchive"));
        imagesforposts.add(new Postimages(R.drawable.onedirection,"onedirection"));
        imagesforposts.add(new Postimages(R.drawable.godfather,"dogfather"));
        imagesforposts.add(new Postimages(R.drawable.bradpitt,"fightclubfans"));
        imagesforposts.add(new Postimages(R.drawable.srk4,"iamsrk"));

        RecyclerViewPosts recyclerViewPosts=new RecyclerViewPosts(this);
        recyclerViewPosts.setMainactivity(mainactivity);
        recyclerViewPosts.setPostimages(imagesforposts);
        postscrollrecyview.setAdapter(recyclerViewPosts);
        postscrollrecyview.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL
        ,false));

        bottomappbar.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.search:
                        startActivity(hometosearch);
                        break;
                    case R.id.reels:
                        startActivity(hometoreels);
                        break;
                    case R.id.bottom_more:
                        startActivity(hometocamera);
                        break;
                    default:    break;

                }
                return true;
            }
        });

    }

}