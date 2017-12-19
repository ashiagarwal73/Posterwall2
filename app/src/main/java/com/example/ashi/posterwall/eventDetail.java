package com.example.ashi.posterwall;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class eventDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_detail);
        Intent i=getIntent();
        Bundle b=i.getExtras();
        String title=b.getString("title");
            int img = b.getInt("image");
        String details=b.getString("details");
            TextView Title = (TextView) findViewById(R.id.tit);
            Title.setText(title);
            TextView t;
            ImageView im = (ImageView) findViewById(R.id.im);
            im.setImageResource(img);
            t = (TextView) findViewById(R.id.details);
            t.setText("Details: "+details);
    }
}
