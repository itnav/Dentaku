package com.example.itnav.zoomableimageview;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;


public class MyActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        ZoomableImageView view = new ZoomableImageView(this);
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT));
           setContentView(view);


    }



}
