package jp.itnav.dentakuapp.datamanager;

import android.content.Context;
import android.content.SharedPreferences;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by nakashionarumi on 2014/07/30.
 */
public class DataManager {
	private static final String PREF_KEY = "PREF_KEY";
	private static final String DATA_KEY = "DATA_KEY";

	private Context context;

	private SharedPreferences sharedPreferences;
	private JSONObject data;

	private void initData() {
		try {
			data = new JSONObject(sharedPreferences.getString(DATA_KEY, ""));
		} catch (JSONException e) {
			data = new JSONObject();
		}
	}

	public DataManager(Context context) {
		this.context = context;

		sharedPreferences = context.getSharedPreferences(PREF_KEY, Context.MODE_PRIVATE);
		initData();
	}

	public String[] getMemoList() {
		if (data.names() != null) {
			JSONArray jsonArray = data.names();
			String[] names = new String[jsonArray.length()];

			for (int i = 0; i < names.length; i++) {
				try {
					names[i] = jsonArray.getString(i);
				} catch (JSONException e) {
					names[i] = "";
					e.printStackTrace();
				}
			}

			return (names);
		} else {
			return (new String[0]);
		}
	}

	public String getMemo(String name) {
		try {
			String memo = data.getString(name);
			return (memo);
		} catch (JSONException e) {
			return ("メモがありません");
		}
	}

	public void saveMemo(String name, String memo) {
		try {
			data.put(name, memo);
			SharedPreferences.Editor editor = sharedPreferences.edit();

			editor.putString(DATA_KEY, data.toString());
			editor.commit();

			initData();
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
}
