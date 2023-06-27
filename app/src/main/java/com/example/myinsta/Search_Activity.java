package com.example.myinsta;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.List;

public class Search_Activity extends AppCompatActivity {
    RecyclerView recyclerViewSearchPosts;
    List<Postimagesforsearch> imageslist;
    RecyclerViewAdapterSearch adapter;
    BottomNavigationView nav;
    Intent searchtohome,searchtoreels,searchtocamera;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        nav=findViewById(R.id.bottomnavisearchactivity);
        searchtohome=new Intent(this,MainActivity.class);
        searchtoreels=new Intent(this,Reels_Activity.class);
        searchtocamera=new Intent(this,Camera.class);
        recyclerViewSearchPosts=findViewById(R.id.recyclerviewsearchposts);
        adapter=new RecyclerViewAdapterSearch(this);
        imageslist=new ArrayList<>();
        imageslist.add(new Postimagesforsearch(R.drawable.dp1,"deepikapadukone"));
        imageslist.add(new Postimagesforsearch(R.drawable.jwm1,"jabwemet"));
        imageslist.add(new Postimagesforsearch(R.drawable.ce1,"chennaiexpress"));
        imageslist.add(new Postimagesforsearch(R.drawable.doc1,"medstudents"));
        imageslist.add(new Postimagesforsearch(R.drawable.srk1,"iamsrk"));
        imageslist.add(new Postimagesforsearch(R.drawable.dp2,"deepikapadukone"));
        imageslist.add(new Postimagesforsearch(R.drawable.jwm2,"jabwemet"));
        imageslist.add(new Postimagesforsearch(R.drawable.ce2,"chennaiexpress"));
        imageslist.add(new Postimagesforsearch(R.drawable.doc2,"medstudents"));
        imageslist.add(new Postimagesforsearch(R.drawable.srk2,"iamsrk"));
        imageslist.add(new Postimagesforsearch(R.drawable.dp3,"deepikapadukone"));
        imageslist.add(new Postimagesforsearch(R.drawable.jwm3,"jabwemet"));
        imageslist.add(new Postimagesforsearch(R.drawable.ce3,"chennaiexpress"));
        imageslist.add(new Postimagesforsearch(R.drawable.doc3,"medstudents"));
        imageslist.add(new Postimagesforsearch(R.drawable.srk3,"iamsrk"));
        imageslist.add(new Postimagesforsearch(R.drawable.dp4,"deepikapadukone"));
        imageslist.add(new Postimagesforsearch(R.drawable.jwm5,"jabwemet"));
        imageslist.add(new Postimagesforsearch(R.drawable.doc4,"medstudents"));
        imageslist.add(new Postimagesforsearch(R.drawable.srk4,"iamsrk"));
        imageslist.add(new Postimagesforsearch(R.drawable.dp5,"deepikapadukone"));
        imageslist.add(new Postimagesforsearch(R.drawable.jwm6,"jabwemet"));
        imageslist.add(new Postimagesforsearch(R.drawable.doc5,"medstudents"));
        imageslist.add(new Postimagesforsearch(R.drawable.srk5,"iamsrk"));
        imageslist.add(new Postimagesforsearch(R.drawable.dp6,"deepikapadukone"));
        imageslist.add(new Postimagesforsearch(R.drawable.doc6,"medstudents"));
        imageslist.add(new Postimagesforsearch(R.drawable.srk6,"iamsrk"));
        imageslist.add(new Postimagesforsearch(R.drawable.dp7,"deepikapadukone"));
        imageslist.add(new Postimagesforsearch(R.drawable.doc7,"medstudents"));
        imageslist.add(new Postimagesforsearch(R.drawable.srk7,"iamsrk"));
        imageslist.add(new Postimagesforsearch(R.drawable.dp8,"deepikapadukone"));
        imageslist.add(new Postimagesforsearch(R.drawable.doc8,"medstudents"));
        imageslist.add(new Postimagesforsearch(R.drawable.srk8,"iamsrk"));
        imageslist.add(new Postimagesforsearch(R.drawable.doc9,"medstudents"));
        imageslist.add(new Postimagesforsearch(R.drawable.srk9,"iamsrk"));
        nav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.bottom_home:
                        startActivity(searchtohome);
                        break;
                    case R.id.reels:
                        startActivity(searchtoreels);
                        break;
                    case R.id.bottom_more:
                        startActivity(searchtocamera);
                        break;
                    default:break;
                }
                return true;
            }
        });
        adapter.setPostimagesforsearchList(imageslist);
        recyclerViewSearchPosts.setAdapter(adapter);
        recyclerViewSearchPosts.setLayoutManager(new StaggeredGridLayoutManager(3,
                LinearLayoutManager.VERTICAL));
    }

}