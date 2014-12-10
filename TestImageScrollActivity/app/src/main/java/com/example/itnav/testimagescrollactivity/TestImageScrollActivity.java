package com.example.itnav.testimagescrollactivity;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;


public class TestImageScrollActivity extends Activity implements View.OnClickListener, View.OnTouchListener {
private static final String DISPLAY_MODE_CENTER = "Center";
    private static final String DISPLAY_MODE_FIT_CENTER = "Fit Center";
    private ImageView.ScaleType mImageScaleType = ImageView.ScaleType.CENTER;
    private int mOverX;
    private int mOverY;
    private ImageView mImageView;
    private TextView mDisplayModeTextView;
    private float mTouchBeginX;
    private float mTouchBeginY;
    private static int calcOverValue (int display, int image) {
        return (display < image ? (image - display) / 2 : 0);

    }
    private static int calcScrollValue (int move, int pos, int over) {
        int newPos = pos + move;
        if (newPos < -over) {
            move = - (over + pos);
        } else if (over < newPos) {
            move = over - pos;
        }
        return move;
    }
    @Override
    public void onConfigurationChanged (Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        this.updateOverSize ();
        this.mImageView.scrollTo(0, 0);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_my);

        this.mDisplayModeTextView = (TextView) this.findViewById(R.id.display_mode);
        this.mDisplayModeTextView.setText (DISPLAY_MODE_CENTER);
        this.mDisplayModeTextView.setOnTouchListener(this);
        this.updateOverSize();
    }
    public void onClick( View v ) {
        if( this.mImageScaleType == ImageView.ScaleType.CENTER ) {
            this.mImageScaleType = ImageView.ScaleType.FIT_CENTER;
            this.mDisplayModeTextView.setText( DISPLAY_MODE_FIT_CENTER );

        } else {
            this.mImageScaleType = ImageView.ScaleType.CENTER;
            this.mDisplayModeTextView.setText( DISPLAY_MODE_CENTER );
        }

        this.mImageView.setScaleType( this.mImageScaleType );
        this.mImageView.scrollTo( 0, 0 );
    }
    public boolean onTouch( View v, MotionEvent event ) {
        if( this.mImageScaleType == ImageView.ScaleType.FIT_CENTER ) { return false; }

        switch( event.getAction() ) {
            case MotionEvent.ACTION_DOWN:
                this.mTouchBeginX = event.getX();
                this.mTouchBeginY = event.getY();
                break;

            case MotionEvent.ACTION_MOVE:
                float x = event.getX(), y = event.getY();
                this.scrollImage( x, y );

                this.mTouchBeginX = x;
                this.mTouchBeginY = y;
                break;

            case MotionEvent.ACTION_UP:
                this.scrollImage( event.getX(), event.getY() );
                break;
        }

        return true;
    }
    private void scrollImage( float x, float y ) {
        int moveX = ( this.mOverX == 0 ? 0 : calcScrollValue( ( int )( this.mTouchBeginX - x ), this.mImageView.getScrollX(), this.mOverX ) );
        int moveY = ( this.mOverY == 0 ? 0 : calcScrollValue( ( int )( this.mTouchBeginY - y ), this.mImageView.getScrollY(), this.mOverY ) );
        this.mImageView.scrollBy( moveX, moveY );
    }
    private void updateOverSize() {
        Display display = ( (WindowManager)this.getSystemService( Context.WINDOW_SERVICE ) ).getDefaultDisplay();
        Drawable image   = this.mImageView.getDrawable();

        this.mOverX = calcOverValue( display.getWidth(),  image.getIntrinsicWidth()  );
        this.mOverY = calcOverValue( display.getHeight(), image.getIntrinsicHeight() );
    }


}
