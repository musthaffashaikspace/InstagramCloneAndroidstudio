package com.example.myinsta;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.VideoView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class Reels_Activity extends AppCompatActivity {
    RelativeLayout rel;
    RecyclerView recy;
    BottomNavigationView bottom;
    Intent reelstohome,reelstosearch,reelstocamera;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reels);
        rel=findViewById(R.id.reelslayout);
        recy=findViewById(R.id.reelshowrecyview);
        bottom=findViewById(R.id.bottomappbarreels);
        reelstohome=new Intent(this,MainActivity.class);
        reelstosearch=new Intent(this,Search_Activity.class);
        reelstocamera=new Intent(this,Camera.class);
        String videopath="android.resource://" + getPackageName() + "/";
        List<reelsinfo> reelsinfoList=new ArrayList<>();
        reelsinfoList.add(new reelsinfo("iamsrk",videopath+R.raw.raone));
        reelsinfoList.add(new reelsinfo("tylerd",videopath+R.raw.fightclub));
        reelsinfoList.add(new reelsinfo("iamsrk",videopath+R.raw.jawan));

        ReelsAdapter res=new ReelsAdapter(this,rel);
        res.setReelsinfo(reelsinfoList);
        recy.setAdapter(res);

        recy.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,
                false));
        bottom.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.bottom_home:
                        startActivity(reelstohome);
                        break;
                    case R.id.search:
                        startActivity(reelstosearch);
                        break;
                    case R.id.bottom_more:
                        startActivity(reelstocamera);
                        break;
                    default:break;
                }
                return true;
            }
        });

    }
}