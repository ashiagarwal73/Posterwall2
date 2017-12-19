package com.example.ashi.posterwall;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class societyEvents extends AppCompatActivity {
    String[] title={"event 1","event 2","event 3","event 4"};
    int[] image={R.drawable.event,R.drawable.event2,R.drawable.event3,R.drawable.event4};
    String[] detail={"This is event 1","This is event 2","This is event 3","This is event 4"};
    ListView list;String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_society_events);
        Intent intent=getIntent();
        name=intent.getStringExtra("name");
        TextView textView= (TextView) findViewById(R.id.textview);
        textView.setText("Events of "+name);
        list= (ListView) findViewById(R.id.list);
        CustomAdapter ca=new CustomAdapter();
        list.setAdapter(ca);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent =new Intent(societyEvents.this,eventDetail.class);
                Bundle b=new Bundle();
                b.putString("title",title[i]);
                b.putInt("image",image[i]);
                b.putString("details",detail[i]);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
    }
    public class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return image.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int position, View convertview, ViewGroup parent) {
            LayoutInflater layoutinflater = getLayoutInflater();
            convertview = layoutinflater.inflate(R.layout.customlayout, null);
            TextView t1 = (TextView) convertview.findViewById(R.id.title);
            ImageView img = (ImageView) convertview.findViewById(R.id.img);
                t1.setText(title[position]);
                img.setImageResource(image[position]);
                return convertview;
        }
    }
}