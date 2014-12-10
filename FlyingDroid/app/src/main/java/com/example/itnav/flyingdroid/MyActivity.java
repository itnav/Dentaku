package com.example.itnav.flyingdroid;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MyActivity extends Activity {

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
    }

    @Override
    protected void onPause () {
        super.onPause();
        super.onPause();
        mediaPlayer.pause();
    }

    @Override
    protected void onResume () {
        super.onResume();
        mediaPlayer.start();
        mediaPlayer.setLooping(true);
    }

    @Override
    protected void onStart () {
        super.onStart();
        mediaPlayer = MediaPlayer.create(this, R.raw.boss);
    }

    @Override
    protected void onStop () {
        super.onStop();
        mediaPlayer.stop();
        mediaPlayer.release();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
