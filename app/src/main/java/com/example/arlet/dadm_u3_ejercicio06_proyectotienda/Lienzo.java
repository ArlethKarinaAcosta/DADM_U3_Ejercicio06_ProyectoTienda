package com.example.arlet.dadm_u3_ejercicio06_proyectotienda;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;

public class Lienzo extends View {
    Imagen icono, icono2, icono3, puntero, icono4, icono5, icono6, icono7, icono8, icono10, icono9;
    String mensaje, mensaje2, mensaje3, mensaje4, MainActivity;
    MainActivity puntero2;
    public Lienzo(Context context) {



        super(context);
        mensaje3 = "Máscaras";


        icono = new Imagen(R.drawable.logoprincipal2, 150, 100, this);
        icono2 = new Imagen(R.drawable.mascarafinal, 30, 800, this);
        icono3 = new Imagen(R.drawable.brochafinal, 350, 800, this);
        icono4= new Imagen(R.drawable.labialfinal, 650, 800, this);
        icono5 = new Imagen(R.drawable.polvofinal, 950, 800, this);
        icono6 = new Imagen(R.drawable.sombrasnuevasfinal, 1400, 800, this);
        icono7 = new Imagen(R.drawable.eslogan3, 650, 100, this);
        icono8 = new Imagen(R.drawable.catalogo, 600, 480, this);
        icono9 = new Imagen(R.drawable.descripcionmascara2, 250, 1550, this);
        icono10 = new Imagen(R.drawable.go2, 1250, 1650, this);



        puntero = null;

        puntero2 = (MainActivity) context;

    }

    protected void onDraw(final Canvas c)
    {
        super.onDraw(c);

        final Paint p = new Paint();

        c.drawColor(Color.parseColor("#F8E0F7"));
        p.setColor(Color.RED);
        c.drawRect(0, 1300, 1800, 750, p);
        p.setColor(Color.parseColor("#A9F5F2"));
        c.drawRect(0, 1500, 1800, 1350,p);
        p.setTextSize(90);
        icono.pintar(c,p);
        icono2.pintar(c,p);
        icono3.pintar(c,p);
        icono4.pintar(c,p);
        icono5.pintar(c,p);
        icono6.pintar(c,p);
        icono7.pintar(c,p);
        icono8.pintar(c,p);
        icono9.pintar(c,p);
        p.setTextSize(80);
        p.setColor(Color.parseColor("#5F4C0B"));
        c.drawText(mensaje3, 700, 1450, p);
        icono10.pintar(c,p);


    }

    public boolean onTouchEvent(MotionEvent e)
    {
        float xp = e.getX();
        float yp = e.getY();

        switch (e.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                if (icono2.estaEnArea(xp, yp)) {
                    mensaje3="Máscaras";
                    puntero = icono2;
                    icono9 = new Imagen(R.drawable.descripcionmascara2, 200, 1600, this);

                }
                if (icono3.estaEnArea(xp, yp)) {
                    puntero = icono3;
                    mensaje3="Brochas";
                    icono9 = new Imagen(R.drawable.descripcionbrochas2, 200, 1600, this);

                }
                if (icono4.estaEnArea(xp, yp)) {
                    puntero = icono4;
                    mensaje3="Labiales";
                    icono9 = new Imagen(R.drawable.descripcionlabiales2, 200, 1600, this);

                }

                if (icono5.estaEnArea(xp, yp)){
                    puntero = icono5;
                    mensaje3="Polvos";
                    icono9 = new Imagen(R.drawable.descripcionpolvos2, 200, 1600, this);

                }
                if (icono6.estaEnArea(xp, yp)){
                    puntero = icono6;
                    mensaje3="Sombras";
                    icono9 = new Imagen(R.drawable.descripcionsombras4, 200, 1600, this);

                }

                if(icono10.estaEnArea(xp, yp) && puntero == icono2)
                {
                    cambioPantalla(1);
                }
                if(icono10.estaEnArea(xp, yp) && puntero == icono3)
                {
                    cambioPantalla(2);
                }
                if(icono10.estaEnArea(xp, yp) && puntero == icono4)
                {
                    cambioPantalla(3);
                }
                if(icono10.estaEnArea(xp, yp) && puntero == icono5)
                {
                    cambioPantalla(4);
                }
                if(icono10.estaEnArea(xp, yp) && puntero == icono6)
                {
                    cambioPantalla(5);
                }
                break;
            case MotionEvent.ACTION_MOVE:

                    if(puntero !=null)
                    {
                        if(icono2.estaEnArea(xp, yp))
                        {
                            icono2.mover(xp);
                            icono3.mover(xp+470);
                            icono4.mover(xp+820);
                            icono5.mover(xp+1220);
                            icono6.mover(xp+1820);
                        }
                        if(icono3.estaEnArea(xp, yp))
                        {
                            icono2.mover(xp-30);
                            icono3.mover(xp);
                            icono4.mover(xp+600);
                            icono5.mover(xp+900);
                            icono6.mover(xp+1300);
                        }
                        if(icono4.estaEnArea(xp, yp))
                        {
                            icono2.mover(xp-920);
                            icono3.mover(xp-450);
                            icono4.mover(xp);
                            icono5.mover(xp+500);
                            icono6.mover(xp+6000);
                        }
                        if(icono5.estaEnArea(xp, yp))
                        {
                            icono2.mover(xp-1500);
                            icono3.mover(xp-1000);
                            icono4.mover(xp-500);
                            icono5.mover(xp);
                            icono6.mover(xp+600);
                        }
                        if(icono6.estaEnArea(xp, yp))
                        {
                            icono2.mover(xp-1900);
                            icono3.mover(xp-1400);
                            icono4.mover(xp-1000);
                            icono5.mover(xp-550);
                            icono6.mover(xp);
                        }
                    }

                break;
            case MotionEvent.ACTION_UP:
                break;
        }



        invalidate();
        return true;
    }

    public void cambioPantalla(int n)
    {
        switch (n)
        {
            case 1:
                Intent mascara = new Intent(puntero2, Main2Activity.class);
                puntero2.startActivity(mascara);
                break;
            case 2:
                Intent brocha = new Intent(puntero2, Main3Activity.class);
                puntero2.startActivity(brocha);
                break;
            case 3:
                Intent labial = new Intent(puntero2, Main4Activity.class);
                puntero2.startActivity(labial);
                break;
            case 4:
                Intent polvo = new Intent(puntero2, Main5Activity.class);
                puntero2.startActivity(polvo);
                break;
            case 5:
                Intent sombra = new Intent(puntero2, Main6Activity.class);
                puntero2.startActivity(sombra);
                break;

        }
    }
}
