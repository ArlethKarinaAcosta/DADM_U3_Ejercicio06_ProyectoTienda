package com.example.arlet.dadm_u3_ejercicio06_proyectotienda;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class Lienzo3 extends View {
    Imagen3 icono1, icono2, icono3, icono4, icono5, puntero, icono6, icono7, icono8;
    String mensaje;
    Main3Activity puntero2;
    public Lienzo3(Context context) {
        super(context);

        icono1 = new Imagen3(R.drawable.brochafinal, 100, 50, this);
        icono2 = new Imagen3(R.drawable.brochaproductofinal1, 200, 700, this);
        icono3 = new Imagen3(R.drawable.brochaproducto2, 200, 1100, this);
        icono4 = new Imagen3(R.drawable.brochaproductofinal3, 200, 1600, this);
        icono5 = new Imagen3(R.drawable.brochaproductofinal4, 200, 2100, this);
        icono6 = new Imagen3(R.drawable.brocha, 900, 550, this);
        icono7 = new Imagen3(R.drawable.descripcionmascara1, 900, 1550, this);
        mensaje = "Brocha para rubor";

        puntero = null;


        icono8 = new Imagen3(R.drawable.back, 1500, 100, this);
        puntero2 = (Main3Activity) context;
    }


    public void onDraw(Canvas c)
    {
        super.onDraw(c);
        Paint p = new Paint();

        c.drawColor(Color.parseColor("#F8E0F7"));
        p.setColor(Color.parseColor("#A9F5F2"));
        c.drawRect(0, 1450, 1800, 1200,p);
        p.setColor(Color.RED);
        c.drawRect(40, 2300, 600, 0, p);
        icono1.pintar(c,p);
        icono2.pintar(c,p);
        icono3.pintar(c,p);
        icono4.pintar(c,p);
        icono5.pintar(c,p);
        icono6.pintar(c,p);
        icono7.pintar(c,p);
        p.setTextSize(80);
        p.setColor(Color.parseColor("#5F4C0B"));
        c.drawText(mensaje, 750, 1350, p);
        icono8.pintar(c,p);
    }

    public boolean onTouchEvent(MotionEvent e)
    {
        float xp = e.getX();
        float yp = e.getY();

        switch (e.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                if(icono2.estaEnArea(xp, yp))
                {
                    puntero = icono2;
                    mensaje ="Brocha para rubor";
                    icono6 = new Imagen3(R.drawable.brocha, 700, 50, this);
                    icono7 = new Imagen3(R.drawable.descripcionbrocha1, 900, 1550, this);
                }
                if(icono3.estaEnArea(xp, yp))
                {
                    puntero = icono3;
                    icono6 = new Imagen3(R.drawable.brochagrande2, 650, 50, this);
                    mensaje ="Brocha para rubor de 5 cm";
                    icono7 = new Imagen3(R.drawable.descripcionbrocha2, 900, 1550, this);
                }
                if(icono4.estaEnArea(xp, yp))
                {
                    puntero = icono4;
                    mensaje = "Brocha para sombras MAC";
                    icono6 = new Imagen3(R.drawable.brochagrande3, 700, 50, this);
                    icono7 = new Imagen3(R.drawable.descripcionbrocha3, 900, 1550, this);
                }
                if(icono5.estaEnArea(xp, yp))
                {
                    puntero = icono5;
                    mensaje ="Brocha para rubor Mary Kay";
                    icono6 = new Imagen3(R.drawable.brochagrande4, 600, 50, this);
                    icono7 = new Imagen3(R.drawable.descripcionbrocha4, 900, 1550, this);
                }
                if(icono8.estaEnArea(xp, yp))
                {
                    Intent volver = new Intent(puntero2, MainActivity.class);
                    puntero2.startActivity(volver);
                }


                break;
            case MotionEvent.ACTION_MOVE:
                if(puntero != null)
                {
                    if(icono2.estaEnArea(xp, yp))
                    {
                        icono2.mover(yp);
                        icono3.mover(yp+400);
                        icono4.mover(yp+800);
                        icono5.mover(yp+1200);
                    }
                    if(icono3.estaEnArea(xp, yp))
                    {
                        icono2.mover(yp-400);
                        icono3.mover(yp);
                        icono4.mover(yp+500);
                        icono5.mover(yp+900);
                    }
                    if(icono4.estaEnArea(xp, yp))
                    {
                        icono2.mover(yp-400);
                        icono3.mover(yp-100);
                        icono4.mover(yp);
                        icono5.mover(yp+400);
                    }
                    if(icono5.estaEnArea(xp, yp))
                    {
                        icono2.mover(yp-1000);
                        icono3.mover(yp-600);
                        icono4.mover(yp-100);
                        icono5.mover(yp);
                    }
                }
                break;
            case MotionEvent.ACTION_UP:
                break;

        }
        invalidate();
        return true;
    }



}
