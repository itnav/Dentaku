package com.example.itnav.viewflipper;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.ViewFlipper;


public class MyActivity extends Activity implements View.OnClickListener{

    private static final String TAG = "ViewFlipper";
    private GestureDetector gesDetect;
    private ViewFlipper viewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        viewFlipper = (ViewFlipper)findViewById(R.id.flipper);
        viewFlipper.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub
                Log.v(TAG, "onTouch");
                // 表示されているMyImageViewを取得
                //MyImageView view = (MyImageView)viewFlipper.getCurrentView();
                RelativeLayout layout = (RelativeLayout)viewFlipper.getCurrentView();
                MyImageView view = (MyImageView)layout.findViewById(R.id.view_id);
                // MyImageViewのScaleGestureDetectorにイベントを渡す.
                if(view.onTouchEvent(event) == true) {
                    return true;
                    }
                // GestureDetectorにイベントを渡す.
                return gesDetect.onTouchEvent(event);
                }
            });


        gesDetect = new GestureDetector(this, new GestureDetector.OnGestureListener() {

            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                // TODO Auto-generated method stub
                Log.v(TAG, "onFling");
                // 左右フリック判定
                if(Math.abs(velocityX) > Math.abs(velocityY)) {
                    if(velocityX > 0) {
                        viewFlipper.showNext();
                        }
                    else {
                        viewFlipper.showPrevious();
                        }
                    }
                return false;
                }

            @Override
            public boolean onDown(MotionEvent e) {
                // TODO Auto-generated method stub
                return true;
                }
            @Override
            public void onLongPress(MotionEvent e) {
                // TODO Auto-generated method stub
                }
            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                // TODO Auto-generated method stub
                return false;
                }
            @Override
            public void onShowPress(MotionEvent e) {
                // TODO Auto-generated method stub
                }
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                // TODO Auto-generated method stub
                return false;
                }

            });

        }
    @Override
    public void onClick(View v){
        int id = v.getId();
        if(id == R.id.button_id){
            Log.v("onClick", "push button");
            RelativeLayout layout = (RelativeLayout)viewFlipper.getCurrentView();
            MyImageView view = (MyImageView)layout.findViewById(R.id.view_id);
            view.goBackOriginalSize();
        }
    }
}





