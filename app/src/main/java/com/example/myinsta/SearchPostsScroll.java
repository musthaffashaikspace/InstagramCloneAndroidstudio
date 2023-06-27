package com.example.myinsta;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.RelativeLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.List;

public class SearchPostsScroll extends AppCompatActivity {
    RecyclerView recyclerView;
    List<Postimagesforsearch> postimages;
    AdapterfForSearchPosts adapter;
    BottomNavigationView nav;
    RelativeLayout rel;

    Intent postscrolltohome,postscrolltosearch,postscrolltoreels;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_posts_scroll);
        recyclerView=findViewById(R.id.searchpostsscroll);
        rel=findViewById(R.id.activitysearchpostscroll);
        postimages=new ArrayList<>();
        adapter=new AdapterfForSearchPosts();
        postscrolltohome=new Intent(this,MainActivity.class);
        postscrolltosearch =new Intent(this,Search_Activity.class);
        postscrolltoreels=new Intent(this,Reels_Activity.class);
        nav=findViewById(R.id.bottomnavisearchscroll);
        Intent intent=getIntent();
        List<Integer>dpvalues= intent.getIntegerArrayListExtra("deepikapadukone");
        List<Integer>jwmvalues= intent.getIntegerArrayListExtra("jabwemet");
        List<Integer>cevalues= intent.getIntegerArrayListExtra("chennaiexpress");
        List<Integer>docvalues= intent.getIntegerArrayListExtra("medstudents");
        List<Integer>srkvalues= intent.getIntegerArrayListExtra("iamsrk");
        for(int i=0;i<9;i++)
        {
            if(i<8)
                postimages.add(new Postimagesforsearch(dpvalues.get(i),"deepikapadukone" ));
            if(i<5)
                postimages.add(new Postimagesforsearch(jwmvalues.get(i),"jabwemet" ));
            if(i<3)
                postimages.add(new Postimagesforsearch(cevalues.get(i),"chennaiexpress" ));
            postimages.add(new Postimagesforsearch(docvalues.get(i),"medstudents" ));
            postimages.add(new Postimagesforsearch(srkvalues.get(i),"iamsrk" ));
        }
        adapter.setPostimages(postimages);
        adapter.setRel(rel);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL
                ,false));
        recyclerView.scrollToPosition(getIntent().getExtras().getInt("scrollposition"));
        nav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.bottom_home:
                        startActivity(postscrolltohome);
                        break;
                    case R.id.search:
                        startActivity(postscrolltosearch);
                        break;
                    case R.id.reels:
                        startActivity(postscrolltoreels);
                        break;
                    default:break;
                }
                return true;
            }
        });
    }
}