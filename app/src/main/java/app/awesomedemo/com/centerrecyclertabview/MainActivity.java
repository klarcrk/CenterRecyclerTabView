package app.awesomedemo.com.centerrecyclertabview;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> tabItems = new ArrayList<>();
    private int[] colors = new int[]{Color.MAGENTA, Color.CYAN, Color.LTGRAY, Color.GREEN, Color.YELLOW, Color.BLUE};
    Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for (int i = 0; i < 50; i++) {
            tabItems.add("tab" + i * i);
        }
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(new RecyclerView.Adapter() {
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.tab_item_view_for_centerrecycler, parent, false);
                RecyclerView.ViewHolder viewHolder = new RecyclerView.ViewHolder(itemView) {
                };
                return viewHolder;
            }

            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
                View itemView = holder.itemView;
                TextView textView = (TextView) itemView;
                String label = tabItems.get(position);
                textView.setText(label);
                textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                });
                int color = colors[random.nextInt(colors.length)];
                textView.setBackgroundColor(color);
            }

            @Override
            public int getItemCount() {
                return tabItems.size();
            }
        });

        LinearSnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);

    }
}
