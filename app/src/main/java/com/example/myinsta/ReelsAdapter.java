package com.example.myinsta;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class ReelsAdapter extends RecyclerView.Adapter<ReelsAdapter.ViewHolder> {

    List<reelsinfo> reelsinfo=new ArrayList<>();
    static  int i=0,j=0;
    private Resources res;
    private RelativeLayout rel;
    Context con;

    public void setReelsinfo(List<com.example.myinsta.reelsinfo> reelsinfo) {
        this.reelsinfo = reelsinfo;
        notifyDataSetChanged();
    }

    public ReelsAdapter(Context context, RelativeLayout re)
    {
        con=context;
        res= context.getResources();
        rel=re;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.reelslayout,parent,
                false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.vv.setVideoPath(reelsinfo.get(position).getVideopath());
        holder.text.setText((reelsinfo.get(position).getAccountname()));
        MediaController med=new MediaController(con);
        holder.vv.setMediaController(med);
        holder.vv.start();
        holder.like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i==0)
                {
                    v.setForeground(ResourcesCompat.getDrawable(res,R.drawable.instaliked,null));
                    i=1;
                }
                else
                {
                    v.setForeground(ResourcesCompat.getDrawable(res,R.drawable.whiteheart,null));
                    i=0;
                }
            }
        });
        holder.save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vi) {
                if(j==0)
                {
                    vi.setForeground(ResourcesCompat.getDrawable(res,R.drawable.savereel,null));
                    j=1;
                }
                else
                {
                    vi.setForeground(ResourcesCompat.getDrawable(res,R.drawable.savedreel,null));
                    j=0;
                    Snackbar.make(rel,"Saved",Snackbar.LENGTH_SHORT)
                            .setAction("UNDO", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    vi.setForeground(ResourcesCompat.getDrawable(res,R.drawable.savereel,null));
                                }
                            })
                            .show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return reelsinfo.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        VideoView vv;
        TextView text;
        FloatingActionButton like,save;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            vv=itemView.findViewById(R.id.onereel);
            text=itemView.findViewById(R.id.accounttextreels);
            like=itemView.findViewById(R.id.reelslike);
            save=itemView.findViewById(R.id.reelsave);
        }
    }
}
