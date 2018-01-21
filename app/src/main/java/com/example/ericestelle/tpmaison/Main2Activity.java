package com.example.ericestelle.tpmaison;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tv = (TextView) findViewById(R.id.viewBouton1);

        Intent intent = this.getIntent();
        String contenu = intent.getStringExtra("name");
        //this.tv.setText(contenu);

        switch (contenu) {
            case "je suis le bouton1":
                this.tv.setText(Html.fromHtml(getResources().getString(R.string.test)));
                break;
            case "bouton2":
                break;

        }


    }
}
