package com.example.worksheet;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {
Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        
        
        
        
        b= (Button) findViewById(R.id.button1);
        
        
        
        
        
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    
    public void open (View v){
    	
    	Intent i = new Intent(this,Wsubmission.class);
    	startActivity(i);
    }
    
    
    public void admin (View v){
    	
    	Intent i = new Intent(this,Admin.class);
    	startActivity(i);
    }
    
    public void teacherMode(View v)
    {
    	Intent i = new Intent(this,TeacherLogin.class);
    	startActivity(i);
    	
    }
    public void user(View v)
    {
    	Intent i = new Intent(this,UserLogin.class);
    	i.putExtra("user","user") ;
    	startActivity(i);
    	
    }
    
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
        	Intent i = new Intent(this,Admin.class);
        	startActivity(i);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
