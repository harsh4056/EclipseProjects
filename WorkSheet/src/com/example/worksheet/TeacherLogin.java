package com.example.worksheet;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class TeacherLogin extends Activity {
EditText et;
String user;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.teacherlogin);
		
		
		et=(EditText) findViewById(R.id.editText1);
		
	}

	
	
	
	public void enter(View v){
		


		Intent i =new Intent(TeacherLogin.this,TeacherSelect.class);
		i.putExtra("teacher",et.getText().toString() );
		startActivity(i);
	}
}
