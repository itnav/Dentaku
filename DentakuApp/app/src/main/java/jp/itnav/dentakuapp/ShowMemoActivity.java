package jp.itnav.dentakuapp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import java.io.FileOutputStream;

public class ShowMemoActivity extends Activity implements OnClickListener{

    EditText editText,editText2;
    Button button;
    String filename;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_memo);

        editText =(EditText)findViewById(R.id.editText);
        editText2 =(EditText)findViewById(R.id.editText2);
        button =(Button)findViewById(R.id.button);
        button.setOnClickListener(this);
        editText.setText("");
    }

    @Override
    public void onClick(View v) {
        if(v == button) {
            try{
                FileOutputStream fos = openFileOutput(filename, Context.MODE_PRIVATE);
                fos.write(editText2.getText().toString().getBytes());
                fos.close();
            }catch(Exception e){};
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.show_memo, menu);
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
