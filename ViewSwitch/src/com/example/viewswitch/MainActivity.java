package com.example.viewswitch;





import java.util.Random;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.TextView.OnEditorActionListener;

public class MainActivity extends Activity {
  private Context context;
	EditText et;
	LinearLayout ll1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		context=this;
		 et= (EditText) findViewById(R.id.editText1);
		 ll1= (LinearLayout) findViewById(R.id.ll1);
			et.setOnEditorActionListener(new OnEditorActionListener() {
				@Override
				public boolean onEditorAction(TextView tv, int actionId, KeyEvent event) {
					if (actionId == EditorInfo.IME_ACTION_DONE) {
					//	Toast.makeText(context, et.getText().toString(), Toast.LENGTH_SHORT).show();
						addTextView();
						return true;
					}
					return false;
				}
			});
	
	 
	}

	
	
	
	protected void addTextView() {
		String tvText= et.getText().toString();
	et.setText("");
	TextView tv=  new TextView(this);
	tv.setText(tvText);
	tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
	Random rnd = new Random(); 
	int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256)); 
tv.setTextColor(color);
	LayoutParams lp= new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
	tv.setLayoutParams(lp);
	ll1.addView(tv);	
	}




	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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
