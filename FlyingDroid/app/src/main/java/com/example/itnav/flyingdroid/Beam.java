package com.example.itnav.flyingdroid;

import android.content.Context;
import android.graphics.Canvas;

/**
 * Created by itnav on 2014/09/12.
 */
public class Beam extends AbstractGameObject {



    public Beam (Context context, int width, int height) {
        super(context, R.drawable.ic_launcher, width, height);
    }

    @Override
    public void setMovingBoundary(int left, int top, int right, int bottom) {
        super.setMovingBoundary(left, top, right, bottom);
        right += width;
        x = left;
        this.bottom -= height;
        y = 300;
       // y = getY();
    }



    public void draw(Canvas c) {
        draw(c, x, y);
        x += 5;
        if (x > right) {
            x = left;

          //  y = getY();

        }
    }
}
