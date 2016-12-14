package app.awesomedemo.com.centerrecyclertabview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class TestAddChild extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_add_child);
        RelativeLayout container = (RelativeLayout) findViewById(R.id.activity_text_add_child);
        TextView topView = new TextView(this);
        topView.setText("top text");
        RelativeLayout.LayoutParams topParam = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        topParam.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        container.addView(topView, topParam);
    }
}
