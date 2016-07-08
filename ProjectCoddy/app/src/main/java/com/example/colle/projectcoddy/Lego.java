package com.example.colle.projectcoddy;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;


public class Lego extends Activity {
    private List<LegoLV> myLego = new ArrayList<LegoLV>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lego);

        populateLegoList();
        populateListView();
        registerClickCallback();
    }

    private void populateLegoList() {
        myLego.add(new LegoLV("Crabby", "Age 4 & 5",R.drawable.crab, "Easy and Cute"));
        myLego.add(new LegoLV("T-Rex", "Age 4 & 5",R.drawable.dino, "Scare Your Mom"));
        myLego.add(new LegoLV("Mr.Owl", "Age 6 & up",R.drawable.owl, "Intermediate"));
        myLego.add(new LegoLV("Rocket", "Age 6 & up",R.drawable.rocket, "Difficult"));
    }

    private void populateListView() {
        ArrayAdapter<LegoLV> adapter = new MyListAdapter();
        ListView list = (ListView)findViewById(R.id.legoListView);
        list.setAdapter(adapter);
    }

    private void registerClickCallback() {
        ListView list = (ListView) findViewById(R.id.legoListView);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id)
            {
                LegoLV clickedLego = myLego.get(position);
                String message = "You clicked project " + position
                        + " Which is project " + clickedLego.getMake();
                Toast.makeText(Lego.this, message, Toast.LENGTH_LONG).show();
            }
        });
    }

    private class MyListAdapter extends ArrayAdapter<LegoLV>{
        public MyListAdapter(){
            super(Lego.this, R.layout.item_view, myLego);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            //Make sure I have a view to work with (may have been given null
            View itemView = convertView;
            if (itemView == null){
                itemView = getLayoutInflater().inflate(R.layout.item_view, parent, false);
            }

            // Find the lego I need to work with
            LegoLV currentLego = myLego.get(position);

            //Fill the view
            ImageView imageview = (ImageView)itemView.findViewById(R.id.item_icon);
            imageview.setImageResource(currentLego.getIconID());

            //Make:
            TextView makeText = (TextView) itemView.findViewById(R.id.item_txtMake);
            makeText.setText(currentLego.getMake());

            //Age:
            TextView ageText = (TextView) itemView.findViewById(R.id.item_txtYear);
            ageText.setText(currentLego.getAge());

            //Condition:
            TextView conditionText = (TextView) itemView.findViewById(R.id.item_txtCondition);
            conditionText.setText(currentLego.getCondition());

            return itemView;
        }

    }
}