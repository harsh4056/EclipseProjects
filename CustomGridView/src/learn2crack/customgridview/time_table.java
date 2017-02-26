package learn2crack.customgridview;



import android.os.Build;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

public class time_table extends Activity {
	
	
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.timetable);
		getActionBar().hide();
		
     Button    create = (Button) findViewById(R.id.create);

     create.setOnClickListener(new View.OnClickListener() {
        			
        			@Override
        			public void onClick(View v) {
        				
        				//pref.logout();
        				Intent intent = new Intent(time_table.this, cnv.class);
        				
        				startActivity(intent);
        				finish();
        				
        			}
        		});
        
        
   Button view = (Button) findViewById(R.id.view);




        
        
        view.setOnClickListener(new View.OnClickListener() {
        			
        			@Override
        			public void onClick(View v) {
        				
        				//pref.logout();
        				Intent intent = new Intent(time_table.this, cnv.class);
        				
        				startActivity(intent);
        				finish();
        				
        			}
        		});
		
		
	}


}
