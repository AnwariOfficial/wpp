package com.chc.wpp;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.pouriahemati.phjustifiedtextview.PHJustifiedTextView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


public class PoetryRecyclerAdapter extends RecyclerView.Adapter<PoetryRecyclerAdapter.ViewHolder> {

    private List<Poetry> mData;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    // data is passed into the constructor
    PoetryRecyclerAdapter(Context context, List<Poetry> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.poetry_recycler_view, parent, false);
        return new ViewHolder(view);
    }



    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Poetry idea = mData.get(position);
       holder.userName.setText(idea.getUserName());
       holder.date.setText(String.valueOf(idea.getPostDate()));
       holder.ideaPost.setText(idea.getIdeaPost());
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mData.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView userName;
        TextView date;
        TextView ideaPost;

        ViewHolder(View itemView) {
            super(itemView);
            userName = itemView.findViewById(R.id.userName);
            date = itemView.findViewById(R.id.date);
            ideaPost = itemView.findViewById(R.id.poem);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
    Poetry getItem(int id) {
        return mData.get(id);
    }


    // allows clicks events to be caught
    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
