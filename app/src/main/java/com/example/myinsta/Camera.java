package com.example.myinsta;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.io.File;
import java.io.IOException;

public class Camera extends AppCompatActivity {
    private static final int REQUEST_IMAGE_CAPTURE = 1;
    ImageView img;
    private String currentphotopath;
    BottomNavigationView navigationView;

    Intent camtohome,camtoreels,camtosearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        img = findViewById(R.id.cameraimgview);
        camtohome=new Intent(this,MainActivity.class);
        camtoreels=new Intent(this,Reels_Activity.class);
        camtosearch=new Intent(this,Search_Activity.class);
        navigationView=findViewById(R.id.camerabottomappbar);
        navigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.search:
                        startActivity(camtosearch);
                        break;
                    case R.id.reels:
                        startActivity(camtoreels);
                        break;
                    case R.id.bottom_home:
                        startActivity(camtohome);
                        break;
                    default:    break;

                }
                return true;
            }
        });
        String filename="photos";
        File storageDirectory=getExternalFilesDir(Environment.DIRECTORY_PICTURES);

        try {
            File imagefile=File.createTempFile(filename,".jpg",storageDirectory);

            currentphotopath=imagefile.getAbsolutePath();
            Uri imageuri= FileProvider.getUriForFile(Camera.this,
                    "com.example.myinsta.fileprovider",imagefile);
            Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            intent.putExtra(MediaStore.EXTRA_OUTPUT,imageuri);
            startActivityForResult(intent,1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==1 && resultCode==RESULT_OK)
        {
            Bitmap bitmap= BitmapFactory.decodeFile(currentphotopath);
            img.setImageBitmap(bitmap);
        }
    }

}
