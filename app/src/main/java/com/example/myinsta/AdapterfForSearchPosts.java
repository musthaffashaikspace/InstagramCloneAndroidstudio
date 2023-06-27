package com.example.myinsta;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class AdapterfForSearchPosts extends RecyclerView.Adapter<AdapterfForSearchPosts.ViewHolder> {

    List<Postimagesforsearch> postimages=new ArrayList<>();

    RelativeLayout rel;

    public void setRel(RelativeLayout rel) {
        this.rel = rel;
    }

    public void setPostimages(List<Postimagesforsearch> postimages) {
        this.postimages = postimages;
        notifyDataSetChanged();
    }

    static  int saved=0,i=0;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.postsrelativelayout,parent,
                false);
        AdapterfForSearchPosts.ViewHolder holder=new AdapterfForSearchPosts.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.img.setImageResource(postimages.get(position).getImg());
        holder.t.setTitle(postimages.get(position).getStr());
        holder.t.setTitleTextAppearance(rel.getContext(), androidx.appcompat.R.style.TextAppearance_AppCompat_Small);
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
                    Snackbar.make(rel,"Saved",Snackbar.LENGTH_SHORT)
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


    public class ViewHolder extends RecyclerView.ViewHolder
    {
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
