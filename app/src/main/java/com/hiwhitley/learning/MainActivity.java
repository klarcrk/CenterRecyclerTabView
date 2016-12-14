package com.hiwhitley.learning;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import app.awesomedemo.com.centerrecyclertabview.R;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private List<Integer> mImagesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
    }

    private void initView() {
        mImagesList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            mImagesList.add(R.drawable.ic_item1);
            mImagesList.add(R.drawable.ic_item2);
            mImagesList.add(R.drawable.ic_item3);
        }
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_main);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(new MyAdapter(mRecyclerView,mImagesList));

//        LinearSnapHelper mLinearSnapHelper = new LinearSnapHelper();
//        mLinearSnapHelper.attachToRecyclerView(mRecyclerView);

        mRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(mRecyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(view.getContext(), "position" + position, Toast.LENGTH_SHORT).show();
                mRecyclerView.smoothScrollToPosition(position);
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        }));
        LinearSnapHelper mMySnapHelper = new LinearSnapHelper();
        mMySnapHelper.attachToRecyclerView(mRecyclerView);
        RecyclerView.ViewHolder firstViewHolder = mRecyclerView.findViewHolderForAdapterPosition(0);
        View firstView = layoutManager.findViewByPosition(0);
    }
}
