package com.example.ashi.posterwall;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class EventsFragment extends Fragment {
    ListView listv;
    String[] title={"event 1 ","event 2","event 3","event 4"};
    int[] image={R.drawable.event,R.drawable.event2,R.drawable.event3,R.drawable.event4};
    String[] detail={"This is event 1","This is event 2","This is event 3","This is event 4"};

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.event_fragment,container,false);
        listv= (ListView)v.findViewById(R.id.lv);
        CustomAdapter ca=new CustomAdapter();
        listv.setAdapter(ca);
       listv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               Intent intent =new Intent(getActivity(),eventDetail.class);
               Bundle b=new Bundle();
               b.putString("title",title[i]);
               b.putInt("image",image[i]);
               b.putString("details",detail[i]);
               intent.putExtras(b);
               startActivity(intent);
           }
       });
        return v;
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
            LayoutInflater layoutinflater=getActivity().getLayoutInflater();
            convertview=layoutinflater.inflate(R.layout.customlayout,null);
            TextView t1= (TextView) convertview.findViewById(R.id.title);
            ImageView img= (ImageView) convertview.findViewById(R.id.img);
            t1.setText(title[position]);
            img.setImageResource(image[position]);
            return convertview;
        }
    }
}
