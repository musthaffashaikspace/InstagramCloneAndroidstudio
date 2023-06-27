package com.example.myinsta;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapterStory extends RecyclerView.Adapter<RecyclerViewAdapterStory
        .ViewHolder> {

    List<AfreenStoryImages> afreenStoryImagesList=new ArrayList<>();

    Context context;


   public RecyclerViewAdapterStory(Context context)
   {
       this.context=context;
   }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.stories_layout,parent
        ,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.storybutton.setForeground(afreenStoryImagesList.get(position).getDrawable());
        holder.storybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(context,StoryView.class);
                Bundle b=new Bundle();
                b.putInt("image",afreenStoryImagesList.get(position).getImg());
                in.putExtras(b);
                context.startActivity(in);
            }
        });

   }

    @Override
    public int getItemCount() {
        return afreenStoryImagesList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        ExtendedFloatingActionButton storybutton;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            storybutton=itemView.findViewById(R.id.afreenstoryfab);
        }
    }
    public void setAfreenStoryImagesList(List<AfreenStoryImages> afreenStoryImagesList) {
        this.afreenStoryImagesList = afreenStoryImagesList;
        notifyDataSetChanged();
    }
}


