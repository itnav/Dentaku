package com.example.itnav.pageradapter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by itnav on 2014/08/13.
 */
public class sub extends Activity {
  @Override
    public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.picture);

      Button button = (Button) findViewById(R.id.backButton1);
      button.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              finish();
          }
      });
  }
}
