package com.example.vaio.myapplication;

import android.content.Intent;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    int sonKart;
    int skor=0;
    int hata=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent i = getIntent();
        String s = i.getStringExtra("mesaj");
        TextView tv = (TextView)findViewById(R.id.textView2);
        tv.setText(s.toString());

        Kart kartlar[] = new Kart[16];
        GridLayout gl = (GridLayout) findViewById(R.id.kartlar);
        for(int j=1;j<=16;j++)
        {
            kartlar[j-1] = new Kart(this,j);
            kartlar[j-1].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final Kart k = (Kart)v;
                    k.cevir();

                    if(sonKart>0)
                    {
                       final Kart k2= (Kart) findViewById(sonKart);



                        if (k2.onPlanID == k.onPlanID && k.getId() != k2.getId())
                        {
                                k2.cevrilebilir=false;
                                k.cevrilebilir=false;
                            skor++;
                            ((TextView)findViewById(R.id.textView3)).setText("skorumuz : " + skor);
                        }
                        else
                        {
                            Handler h = new Handler();
                            h.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    k2.cevir();
                                    k.cevir();
                                }
                            },500);

                            hata++;
                            
                            sonKart=0;
                            ((TextView)findViewById(R.id.textView4)).setText("hatamız : " + hata);
                        }
                    }
                    else
                    {
                        sonKart=k.getId();
                    }
                }
            });
        }
        for(int j=0;j<16;j++)
        {
            int rg = (int)(Math.random()*16);
            Kart k = kartlar[rg];
            kartlar[rg]=kartlar[j];
            kartlar[j]=k;
        }

        for(int j=0;j<16;j++)
        gl.addView(kartlar[j]);
    }
}
