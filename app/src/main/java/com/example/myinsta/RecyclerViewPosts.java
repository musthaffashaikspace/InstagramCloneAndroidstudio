package com.example.myinsta;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewPosts extends RecyclerView.Adapter<RecyclerViewPosts.ViewHolder> {
    List<Postimages> postimages=new ArrayList<>();
    Context context;
    static int i=0,saved=0;
    RelativeLayout mainactivity;

    public void setMainactivity(RelativeLayout mainactivity) {
        this.mainactivity = mainactivity;
    }

    public RecyclerViewPosts(Context context) {
        this.context = context;
    }
    public void setPostimages(List<Postimages> postimages) {
        this.postimages = postimages;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.postsrelativelayout,parent,
                false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.img.setImageResource(postimages.get(position).getImage());
        holder.t.setTitle(postimages.get(position).getStr());
        holder.t.setTitleTextAppearance(context, androidx.appcompat.R.style.TextAppearance_AppCompat_Small);
        holder.bottomsave.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if(saved==0)
                {
                    item.setCheckable(true);
                    item.setChecked(false);
                    saved++;
                }
                if(item.isChecked()) {
                    item.setIcon(R.drawable.instasave);
                    item.setChecked(false);
                }
                else {
                    Snackbar.make(mainactivity,"Saved",Snackbar.LENGTH_SHORT)
                            .setAction("UNDO", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    item.setIcon(R.drawable.instasave);
                                    item.setChecked(false);
                                }
                            })
                            .show();
                    item.setIcon(R.drawable.instasaved);
                    item.setChecked(true);
                }
                return true;
            }
        });

        holder.bottom.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.postbottomlike:
                        if(i==0)
                        {
                            item.setCheckable(true);
                            item.setChecked(false);
                            i++;
                        }
                        if(item.isChecked()) {
                            item.setIcon(R.drawable.favroite);
                            item.setChecked(false);
                        }
                        else {
                            item.setIcon(R.drawable.instaliked);
                            item.setChecked(true);
                        }
                        break;
                    case R.id.postbottomcomment:

                    default:break;
                }

                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return postimages.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        BottomAppBar bottom,bottomsave;
        MaterialToolbar t;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.imagepost);
            bottom=itemView.findViewById(R.id.bottombarpost);
            bottomsave=itemView.findViewById(R.id.bottombarsave);
            t=itemView.findViewById(R.id.posttopbarid);
        }
    }
}
