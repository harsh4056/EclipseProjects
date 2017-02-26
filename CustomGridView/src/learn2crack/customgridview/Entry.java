package learn2crack.customgridview;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;




import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Entry extends Activity {

	EditText name;
	EditText parent;
	EditText school;
	EditText comment;
	EditText Prev_res;
	EditText van;
	EditText admts;
	Spinner batch;
	Spinner cls;
	Spinner centre;
	TextView date_1;
	List<String> batch_;
	List<String> cls_;
	List<String> centre_;
	String date_view;
	private Calendar calendar;
	private int year, month, day;
	Button doj;
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
  

        setContentView(R.layout.entry);
    	 name = (EditText)findViewById(R.id.name);
    	 parent = (EditText)findViewById(R.id.parent);
    	 school = (EditText)findViewById(R.id.school);
    	 comment = (EditText)findViewById(R.id.comment);
    	 Prev_res = (EditText)findViewById(R.id.Prev_res);
    	 van = (EditText)findViewById(R.id.van);
    	 admts = (EditText)findViewById(R.id.admts);
    	 batch =(Spinner) findViewById(R.id.batch);
    	 cls =(Spinner) findViewById(R.id.cls);
    	 centre =(Spinner) findViewById(R.id.centre);
    	 date_1=(TextView)findViewById(R.id.date_1);
    	 batch_= new ArrayList<String>();
    	 cls_= new ArrayList<String>();
    	 centre_= new ArrayList<String>();
    	  calendar = Calendar.getInstance();
          year = calendar.get(Calendar.YEAR);
          doj=(Button)findViewById(R.id.date_of_join);
          
          month = calendar.get(Calendar.MONTH);
          day = calendar.get(Calendar.DAY_OF_MONTH);
          showDate(year, month+1, day);
          
          
          
         batch_.add("A");
         batch_.add("B");
         batch_.add("C");
          // Creating adapter for spinner
          ArrayAdapter<String> dataAdapterbatch = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, batch_);
          
          // Drop down layout style - list view with radio button
          dataAdapterbatch.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
          
          // attaching data adapter to spinner
          batch.setAdapter(dataAdapterbatch);
          
          
          //----------------------------------------------------------------
          
          
          
          cls_.add("4th");
          cls_.add("5th");
          cls_.add("6th");
          cls_.add("7th");
          cls_.add("8th");
          cls_.add("9th");
          cls_.add("10th");
           // Creating adapter for spinner
           ArrayAdapter<String> dataAdapterclass = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, cls_);
           
           // Drop down layout style - list view with radio button
           dataAdapterclass.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
           
           // attaching data adapter to spinner
           cls.setAdapter(dataAdapterclass);
          
          
          
         //-----------------------------------------------------------------------------------------
           
           
           
           
           
           centre_.add("DDN");
           centre_.add("RT");
           centre_.add("CC");
           centre_.add("PB");
         
            // Creating adapter for spinner
            ArrayAdapter<String> dataAdaptercentre = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, centre_);
            
            // Drop down layout style - list view with radio button
            dataAdaptercentre.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            
            // attaching data adapter to spinner
            centre.setAdapter(dataAdaptercentre);
           
           
           
           
           
           
           
           
           
           
           //---------------------------------------------------------
          
          
          
          

   
}

	 @SuppressWarnings("deprecation")
	    public void join_date(View view) {
	       showDialog(999);
	      // Toast.makeText(getApplicationContext(), "ca", Toast.LENG .show();
	    }

	    @Override
	    protected Dialog onCreateDialog(int id) {
	       // TODO Auto-generated method stub
	       if (id == 999) {
	          return new DatePickerDialog(this, myDateListener, year, month, day);
	       }
	       return null;
	    }

	    private DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
	       @Override
	       public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3) {
	          // TODO Auto-generated method stub
	          // arg1 = year
	          // arg2 = month
	          // arg3 = day
	          showDate(arg1, arg2+1, arg3);
	       }
	    };
	
	 private void showDate(int year, int month, int day) {
	       date_1.setText(new StringBuilder().append(year).append("-")
	       .append(month).append("-").append(day));
	       date_view =""+String.valueOf(year)+"-"+String.valueOf(month)+"-"+String.valueOf(day);
	      // Toast.makeText(this, "date_view:" + date_view, 1).show();
	    }

	 public void submit(View view) {
		 
		 
		@SuppressWarnings("unused")
		String n= name.getText().toString();
		 try{

				complainparser userinfo = new complainparser(getBaseContext(),
						name.getText().toString(),
						parent.getText().toString(),
						school.getText().toString(),
						comment.getText().toString(),
						Prev_res.getText().toString(),
						van.getText().toString(),
						admts.getText().toString(),
						batch.getSelectedItem().toString(),
						cls.getSelectedItem().toString(),
						centre.getSelectedItem().toString(),
				           date_view);
				
				
		        	userinfo.execute();
				
		        	Toast.makeText(getApplicationContext(), "Student details has been submitted been sucessfully l",
		        			   Toast.LENGTH_LONG).show();
				}
				catch(Exception e)
				{
					
					
				}
		   }
	
	
	
	
	
	
}
