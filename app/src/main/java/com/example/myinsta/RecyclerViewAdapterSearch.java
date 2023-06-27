package com.example.myinsta;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapterSearch extends RecyclerView.Adapter<RecyclerViewAdapterSearch.ViewHolder> {
    List<Postimagesforsearch> postimagesforsearchList=new ArrayList<>();
    Context context;
    Intent searchtoscrollposts;

    public RecyclerViewAdapterSearch(Context context) {
        this.context = context;
        searchtoscrollposts=new Intent(context,SearchPostsScroll.class);
    }

    public void setPostimagesforsearchList(List<Postimagesforsearch> postimagesforsearchList) {
        this.postimagesforsearchList = postimagesforsearchList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.postsforsearch,parent
        ,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.img.setImageResource(postimagesforsearchList.get(position).getImg());
        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Integer>dpvalues=new ArrayList<>();
                dpvalues.add(R.drawable.dp1);
                dpvalues.add(R.drawable.dp2);
                dpvalues.add(R.drawable.dp3);
                dpvalues.add(R.drawable.dp4);
                dpvalues.add(R.drawable.dp5);
                dpvalues.add(R.drawable.dp6);
                dpvalues.add(R.drawable.dp7);
                dpvalues.add(R.drawable.dp8);

                searchtoscrollposts.putIntegerArrayListExtra("deepikapadukone",dpvalues);
                ArrayList<Integer>jwmvalues=new ArrayList<>();
                jwmvalues.add(R.drawable.jwm1);
                jwmvalues.add(R.drawable.jwm2);
                jwmvalues.add(R.drawable.jwm3);
                jwmvalues.add(R.drawable.jwm5);
                jwmvalues.add(R.drawable.jwm6);
                searchtoscrollposts.putIntegerArrayListExtra("jabwemet",jwmvalues);
                ArrayList<Integer>docvalues=new ArrayList<>();
                docvalues.add(R.drawable.doc1);
                docvalues.add(R.drawable.doc2);
                docvalues.add(R.drawable.doc3);
                docvalues.add(R.drawable.doc4);
                docvalues.add(R.drawable.doc5);
                docvalues.add(R.drawable.doc6);
                docvalues.add(R.drawable.doc7);
                docvalues.add(R.drawable.doc8);
                docvalues.add(R.drawable.doc9);
                searchtoscrollposts.putIntegerArrayListExtra("medstudents",docvalues);

                ArrayList<Integer>chevalues=new ArrayList<>();
                chevalues.add(R.drawable.ce1);
                chevalues.add(R.drawable.ce2);
                chevalues.add(R.drawable.ce3);

                searchtoscrollposts.putIntegerArrayListExtra("chennaiexpress",chevalues);

                ArrayList<Integer>srkvalues=new ArrayList<>();
                srkvalues.add(R.drawable.srk1);
                srkvalues.add(R.drawable.srk2);
                srkvalues.add(R.drawable.srk3);
                srkvalues.add(R.drawable.srk4);
                srkvalues.add(R.drawable.srk5);
                srkvalues.add(R.drawable.srk6);
                srkvalues.add(R.drawable.srk7);
                srkvalues.add(R.drawable.srk8);
                srkvalues.add(R.drawable.srk9);
                searchtoscrollposts.putIntegerArrayListExtra("iamsrk",srkvalues);
                Bundle b=new Bundle();
                b.putInt("scrollposition",position);
                searchtoscrollposts.putExtras(b);
                context.startActivity(searchtoscrollposts);
            }
        });

    }

    @Override
    public int getItemCount() {
        return postimagesforsearchList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.imgviewpostsearch);
        }
    }
}
