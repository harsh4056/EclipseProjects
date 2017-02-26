package learn2crack.customgridview;


import android.os.Build;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends Activity {
	GridView grid;
	String[] web = {
		    "Time Table",
			"Add Student",
			"Attendance",
			"Students Attendance",
			"Flickr",
			"Pinterest",
			"Quora",
			"Twitter",
			"Vimeo",
			"WordPress",
			"Youtube",
			"Stumbleupon"
			
	} ;
	int[] imageId = {
			R.drawable.timetable,
			R.drawable.addnew,
			R.drawable.attendance,
			R.drawable.timetable,
			R.drawable.timetable,
			R.drawable.timetable,
			R.drawable.timetable,
			R.drawable.timetable,
			R.drawable.timetable,
			R.drawable.timetable,
			R.drawable.timetable,
			R.drawable.timetable
			
			
			
	};
	
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		getActionBar().hide();
		CustomGrid adapter = new CustomGrid(MainActivity.this, web, imageId);
		grid=(GridView)findViewById(R.id.grid);
				grid.setAdapter(adapter);
				grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

		            @Override
		            public void onItemClick(AdapterView<?> parent, View view,
		                                    int position, long id) {
		            	
		            	
		            	// String  itemValue    = (String) grid.getItemAtPosition(position);
		                 
		            	if(web[+ position].equals("Time Table"))
		            	{
		            		
		            		Intent time = new Intent(MainActivity.this,time_table.class);
		            		startActivity(time);
		            		finish();
		            		
		            	}
		            	
		            	if(web[+ position].equals("Add Student"))
		            	{
		            		
		            		Intent time = new Intent(MainActivity.this,Entry.class);
		            		startActivity(time);
		            		finish();
		            		
		            	}
		            	
		            	if(web[+ position].equals("Attendance"))
		            	{
		            		
		            		Intent time = new Intent(MainActivity.this,AttendanceActivity.class);
		            		startActivity(time);
		            		finish();
		            		
		            	}
		            	
		            	
		            	
		            	if(web[+ position].equals("Students Attendance"))
		            	{
		            		
		            		Intent time = new Intent(MainActivity.this,StudAttendance.class);
		            		startActivity(time);
		            		finish();
		            	}
		            	
		                Toast.makeText(MainActivity.this, "You Clicked at " +web[+ position], Toast.LENGTH_SHORT).show();

		            }
		        });

	}



}
