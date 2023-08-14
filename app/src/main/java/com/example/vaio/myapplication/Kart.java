package com.example.vaio.myapplication;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatDrawableManager;
import android.widget.Button;
import androidx.appcompat.*;

/**
 * Created by VAIO on 28.09.2017.
 */

public class Kart extends AppCompatButton {
    boolean acikMi=false;
    boolean cevrilebilir=true;
    int resimID;
    int arkaPlanID;
    int onPlanID;
    Drawable on;
    Drawable arka;
    public Kart(Context context,int id) {
        super(context);
        setId(id);
        arkaPlanID= R.drawable.back;

        if(id%8==1)
            onPlanID=R.drawable.c1;
        if(id%8==2)
            onPlanID=R.drawable.c2;
        if(id%8==3)
            onPlanID=R.drawable.c3;
        if(id%8==4)
            onPlanID=R.drawable.c4;
        if(id%8==5)
            onPlanID=R.drawable.c5;
        if(id%8==6)
            onPlanID=R.drawable.c6;
        if(id%8==7)
            onPlanID=R.drawable.c7;
        if(id%8==0)
            onPlanID=R.drawable.c8;

         arka= AppCompatDrawableManager.get().getDrawable(context,arkaPlanID);
         on= AppCompatDrawableManager.get().getDrawable(context,onPlanID);
        setBackground(arka);
    }
    public void cevir()
    {
        if(cevrilebilir)
            if(!acikMi)
            {
                setBackground(on);
                acikMi=true;
            }
            else
            {
                setBackground(arka);
                acikMi=false;
            }
    }
}
