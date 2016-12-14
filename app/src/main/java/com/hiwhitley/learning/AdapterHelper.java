package com.hiwhitley.learning;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by hiwhitley on 2016/9/4.
 */
public class AdapterHelper {


    public void onCreateViewHolder(ViewGroup parent, int viewType) {

    }

    public void onBindViewHolder(RecyclerView recyclerView, final RecyclerView.ViewHolder holder, final int position, int itemCount) {
        View itemView = holder.itemView;
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) itemView.getLayoutParams();
        int itemWidth = layoutParams.width;
        if (position == 0) {
            int recyclerViewWidth = recyclerView.getWidth();
            layoutParams.setMarginStart((recyclerViewWidth - itemWidth) / 2);
            layoutParams.setMarginEnd(0);
        } else if (position == itemCount - 1) {
            //
            int recyclerViewWidth = recyclerView.getWidth();
            layoutParams.setMarginStart(0);
            layoutParams.setMarginEnd((recyclerViewWidth - itemWidth) / 2);
        } else {
            layoutParams.setMarginStart(0);
            layoutParams.setMarginEnd(0);
        }
    }

}
