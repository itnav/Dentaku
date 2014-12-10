package com.example.itnav.viewflipper;

import android.content.Context;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.SimpleOnScaleGestureListener;
import android.widget.ImageView;

/**
 * Created by itnav on 2014/08/29.
 */
public class MyImageView extends ImageView {

    private static final String TAG = "MyImageView";

    // 画像処理
    private Matrix orgMatrix = new Matrix();
    private Matrix baseMatrix = new Matrix(); // タッチダウン時の画像保存用
    private Matrix imgMatrix = new Matrix(); //　画像変換用
    private ScaleGestureDetector gesDetect = null;

    public MyImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
        setScaleType(ImageView.ScaleType.MATRIX);
        gesDetect = new ScaleGestureDetector(context, onScaleGestureListener);
        }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // TODO Auto-generated method stub
        gesDetect.onTouchEvent(event);
        // マルチタッチ処理中か
        if(gesDetect.isInProgress()) {
            return true;
            }
        return false;
        }

    public final SimpleOnScaleGestureListener onScaleGestureListener = new SimpleOnScaleGestureListener() {
        @Override
        public boolean onScale(ScaleGestureDetector detector) {
            // TODO Auto-generated method stub
            Log.v(TAG, "onScale");
            imgMatrix.set(baseMatrix);
            imgMatrix.postScale(detector.getScaleFactor(), detector.getScaleFactor(),
                    detector.getFocusX(), detector.getFocusY());
            setImageMatrix(imgMatrix);
            return super.onScale(detector);
            }

        @Override
        public boolean onScaleBegin(ScaleGestureDetector detector) {
            // TODO Auto-generated method stub
            Log.v(TAG, "onScaleBegin");
            baseMatrix.set(imgMatrix);
            return super.onScaleBegin(detector);
            }
        @Override
        public void onScaleEnd(ScaleGestureDetector detector) {
            // TODO Auto-generated method stub
            Log.v(TAG, "onScaleEnd");
            super.onScaleEnd(detector);
            }
        };
    public void goBackOriginalSize(){
        setImageMatrix(orgMatrix);
    }
}
