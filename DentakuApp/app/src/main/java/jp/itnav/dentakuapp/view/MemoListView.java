package jp.itnav.dentakuapp.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by nakashionarumi on 2014/07/30.
 */
public class MemoListView {
	private Context context;
	private LinearLayout memoList;

	public MemoListView(Context context, LinearLayout linearLayout) {

		this.context = context;
		memoList = linearLayout;
	}

	public void addMemoTitle(String title, View.OnClickListener onClickListener) {
		TextView textView = new TextView(context);
		textView.setText(title);
		textView.setOnClickListener(onClickListener);
		textView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
		memoList.addView(textView);
	}

}
