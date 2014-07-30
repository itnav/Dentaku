package jp.itnav.dentakuapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import jp.itnav.dentakuapp.datamanager.DataManager;
import jp.itnav.dentakuapp.view.MemoListView;


public class MemoListActivity extends Activity {
    private DataManager dataManager;
    private MemoListView memoListView;
    private LinearLayout memoHolder;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataManager = new DataManager(this);
        setContentView(R.layout.activity_memo_list);

        String[] memoList = dataManager.getMemoList();

        memoHolder = (LinearLayout) findViewById(R.id.memoList);

        memoListView = new MemoListView(this, memoHolder);
        for (int i = 0; i < memoList.length; i++) {
            memoListView.addMemoTitle(memoList[i], new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("text", ((TextView) v).getText().toString());
                }
            });
        }

        btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MemoListActivity.this, ShowMemoActivity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.memo_list, menu);
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
