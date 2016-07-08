package com.example.colle.projectcoddy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by colle on 7/5/2016.
 */
public class Display extends Activity {

    public Button Benterhere;

    public void init(){
        Benterhere = (Button)findViewById(R.id.Benterhere);
        Benterhere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent anewpage = new Intent(Display.this, Lego.class);
                startActivity(anewpage);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);

        String username = getIntent().getStringExtra("Username");

        TextView tv = (TextView)findViewById(R.id.TVusername);
        tv.setText(username);

        init();
    }

}

