package com.example.ericestelle.tpmaison;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import static android.view.View.INVISIBLE;

public class ActivityWebview extends AppCompatActivity {

    private WebView wv;
    private ProgressBar pb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
//lancement de la progressbar à l'ouverture mais il faut qu'elle s'arrête à un moment avec la classWebChrome client
        deposeProgressBar();

        wv = (WebView) findViewById(R.id.infoWikiBouton1);


        Intent intent = this.getIntent();
        String contenu = intent.getStringExtra("name");
        String url = "";

        //definir que mon application est le receptacle de la vue et non une application externe
        this.wv.setWebViewClient(new WebViewClient());
        //activation de javaScript
        this.wv.getSettings().setJavaScriptEnabled(true);

        this.wv.setWebChromeClient(new WebChromeClient() {

            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if (newProgress > 20) pb.setVisibility(View.INVISIBLE);
            }
        });


        switch (contenu) {
            case "je suis le bouton1":
                url = getResources().getString(R.string.testUrl);
                break;
            case "bouton2":
                break;
        }
        this.wv.loadUrl(url);





    }


    public void deposeProgressBar() {
        // creation dynamiquement d'unenouvelle vue en lui donnant les paramètres
        LinearLayout progressBarLinear = new LinearLayout(this);
        this.addContentView(progressBarLinear, new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        // creation de la progress bar et parametre d'affichage pour prendre tout l 'ecran
        progressBarLinear.setGravity(Gravity.CENTER);
        this.pb = new ProgressBar(this);
        progressBarLinear.addView(this.pb);
    }

    @Override
    protected void onPause() {
        super.onPause();
        this.overridePendingTransition(0, 0);
    }
}
