package com.example.worksheet;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Admin extends Activity{
	 Button b;
	  @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.admin);
	        
	        
	        
	        
	     
	        
	        
	        
	        
	        
	        
	    }
	  
	  
	  
	  public void addTopic( View v){
		  
		  Intent i = new Intent(Admin.this,AddTopics.class);
		  startActivity(i);
		  
	  }
	  
  public void percent_subs( View v){
		  
		  Intent i = new Intent(Admin.this,Percent_submissions.class);
		  startActivity(i);
		  
	  }
  public void percent_comps( View v){
	  
	  Intent i = new Intent(Admin.this,Percent_completions.class);
	  startActivity(i);
	  
  }
	  
	  

}
