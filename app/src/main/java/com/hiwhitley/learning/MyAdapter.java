package com.hiwhitley.learning;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import app.awesomedemo.com.centerrecyclertabview.R;

/**
 * Created by hiwhitley on 2016/9/4.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ItemViewHolder>{
    private List<Integer> mImages;
    private RecyclerView recyclerView;
    AdapterHelper adapterHelper = new AdapterHelper();
    public MyAdapter(RecyclerView recyclerView,List<Integer> images){
        this.recyclerView = recyclerView;
        this.mImages = images;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view_card, parent, false);
        return new ItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ItemViewHolder holder, final int position) {
        adapterHelper.onBindViewHolder(recyclerView,holder,position,getItemCount());
        holder.mImageView.setImageResource(mImages.get(position));
    }

    @Override
    public int getItemCount() {
        return mImages.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        private ImageView mImageView;
        public ItemViewHolder(View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id.imageView);
        }
    }
}
