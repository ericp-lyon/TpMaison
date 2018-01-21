package com.example.ericestelle.tpmaison;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

// 3 possibilités d'interactiondans l'interface

public class MainActivity extends AppCompatActivity {

   /* private View.OnClickListener detectClicBouton = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Toast.makeText(MainActivity.this, "clic sur le boutton 2", Toast.LENGTH_LONG).show();
        }
    };*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button b1 = (Button) this.findViewById(R.id.bt1);
        Button b2 = (Button) this.findViewById(R.id.bt2);
        Button b3 = (Button) findViewById(R.id.bt3);
        Button b4 = (Button) findViewById(R.id.bt4);
        Button b5 = (Button) findViewById(R.id.btActionBar);

    }

    public void clic(View v) {
        //1er cas de figure sur l'envoi de 'lintent sur activity2
        //Intent intentBouton = new Intent(this, Main2Activity.class);

        //2eme cas envoi de 'lintent sur activity Webview
        Intent intentBouton = new Intent(this, ActivityWebview.class);

        switch (v.getId()) {
            case R.id.bt1:
                intentBouton.putExtra("name", "je suis le bouton1");
                Toast.makeText(MainActivity.this, "bouton 1", Toast.LENGTH_LONG).show();
                break;
            case R.id.bt2:
                intentBouton.putExtra("name", "je suis bien le bouton2");
                Toast.makeText(MainActivity.this, "bouton 2", Toast.LENGTH_LONG).show();
                break;

            case R.id.bt3:
                intentBouton.putExtra("name", "je suis le bouton3");
                Toast.makeText(MainActivity.this, "bouton 3", Toast.LENGTH_LONG).show();
                break;

            case R.id.bt4:
                intentBouton.putExtra("name", "je suis bien le bouton4");
                Toast.makeText(MainActivity.this, "bouton4", Toast.LENGTH_LONG).show();
                break;


        }

        startActivity(intentBouton);
        //au moment du lancement de l'intent, nous annulons la transition entre les 2 activitys
        this.overridePendingTransition(0, 0);

    }


}
