package com.example.worksheet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;



import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.ActionBar.LayoutParams;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class User extends Activity{
	

	TextView date_pend_up;
	TextView date_pend_down;
	TableLayout t1;
	 
	TextView tvname;
	TextView tvclass;
	TextView tvbatch;
	TextView tvcenter;
	List<String> categories_code;
	
	List<String> categories_description;
	List<String> categories_batch;
	List<String> categories_class;
	List<String> categories_center;
	List<String> categories_subject;
	List<String> categories_faculty;
	List<String> categories_student;
	List<String> categories_topics;
	List<String> categories_submitted_Info;
	List<String> categories_completed_Info;
	List<String> categories_Date;
	
	private Calendar calendar;
	//private TextView date_pend_down,date_pend_up,date_log_down,date_log_up;
	private int year, month, day;
	int flag,flag_btn_click;
	Button sub;
	JSONParser jparser = new JSONParser();
	Dialog dialogReg;
	ListView lv1;
	String send ;
	String topics;
	String name;
	String roll;
	String center;
	String batch;
	String cls;
	String subject;
	String NAME_ROLL_PAIR;
	int total,comp,notcomp;
//	int flag,flag_btn_click;
	String password_string;
	String username_string;
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	@SuppressLint("NewApi")
	@Override
	
	
	//-----------------------------------------------settting method--------------------------------------------------------------------
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		subject="";
		total=0;
		comp=0;
		notcomp=0;
		name="";
		roll="";
		 center="";
		 batch="";
		 cls="";
		 NAME_ROLL_PAIR="";
		setContentView(R.layout.studentview);
	//	getActionBar().hide();
		categories_code =new ArrayList<String>();
		//send =new ArrayList<String>();
		send = "";
		categories_subject=new ArrayList<String>();
		 categories_student=new ArrayList<String>();
		 categories_topics=new ArrayList<String>();
		 categories_submitted_Info=new ArrayList<String>();
		 categories_completed_Info=new ArrayList<String>();
		 categories_Date=new ArrayList<String>();
		 categories_description =new ArrayList<String>();
		 calendar = Calendar.getInstance();
	      year = calendar.get(Calendar.YEAR);
	      
	      month = calendar.get(Calendar.MONTH);
	      day = calendar.get(Calendar.DAY_OF_MONTH);
	      
	      Bundle extras = getIntent().getExtras();
	       username_string = extras.getString("EXTRA_USERNAME");
	       password_string = extras.getString("EXTRA_PASSWORD");
	       name=  extras.getString("name");
	       roll=  extras.getString("roll");
	     batch=  extras.getString("batch");
	       center=   extras.getString("center");
	     cls=	extras.getString("class");
	     NAME_ROLL_PAIR=roll+"-"+name;
		date_pend_up = (TextView) findViewById(R.id.textpdh);
		date_pend_down = (TextView) findViewById(R.id.textpdl);
		tvname= (TextView) findViewById(R.id.welcome);
		tvclass= (TextView) findViewById(R.id.cls);
		tvcenter= (TextView) findViewById(R.id.cntr);
		tvbatch= (TextView) findViewById(R.id.batch);
		
		  tvname.setText("Welcome " +name);  
          tvclass.setText(cls);
          tvbatch.setText(batch);
          tvcenter.setText("    "+center);
		 showDate0(year, appending0(month+1),appending0( day));
	      showDate1(year,appending0(month+1),appending0( day));
	    
	

	
	
	
	
	}
	//-----------------------------------------------settting method ends--------------------------------------------------------------------
	 
	
	public void MATHLETICS(View v){
		clearAllLists();
		subject="MATHLETICS";
		new studentsview().execute();
	}
	
public void sci(View v){
	clearAllLists();
	subject="SCI-FI";
	new studentsview().execute();
	}
public void soc(View v){
	clearAllLists();
	subject="SOCIALITY";
	new studentsview().execute();
}
public void eng(View v){
	clearAllLists();
	subject="ENGLISH";
	new studentsview().execute();
}
public void other(View v){
	clearAllLists();
	subject="OTHERS";
	new studentsview().execute();
}

public void all(View v){
	clearAllLists();
	categories_description.clear();
	subject="";
	new studentsview().execute();
}


	
	
    private class time extends AsyncTask<String, Void, String> {
    	JSONObject json;
    	private ProgressDialog dialog = new ProgressDialog(User.this);

        /** progress dialog to show user that the backup is processing. */
        /** application context. */

        protected void onPreExecute() {
            this.dialog.setMessage("Please wait...");
            this.dialog.show();
        }
    	
    	
        @Override
        protected String doInBackground(String... urls) 
        {
       
        	
        	
        	
        	List<NameValuePair> params = new ArrayList<NameValuePair>();
		//	params.add(new BasicNameValuePair("datelow", date_pend_down.getText().toString()));
			
			
			 String url = "http://176.32.230.250/anshuli.com/sharpenup3/submit_schedule.php";
				
			
          json  = jparser.makeHttpRequest(url, "POST", params);
			
			
			JSONArray jsonArray;
     		
        	
			return null;
        }
        // onPostExecute displays the results of the AsyncTask.
        @SuppressLint("NewApi")
		@Override
        protected void onPostExecute(String result)
        {  			
        	
      this.dialog.dismiss();
      
  	try {
		// Checking for SUCCESS TAG
		
		//forjson.clear();
		
		
		//Toast.makeText(MainActivity.this, (CharSequence) json, 1).show();
	
			 JSONArray account= json.getJSONArray("pendings");
		        for(int i = 0; i < account.length(); i++)
		        {
		        	json =account.getJSONObject(i);
		        	
		        	topics=json.getString("TOPIC");
		      
		        	 	// forjson.add(Roll+"-"+ NAME);
		        	 	//categories_description.add(description);
		        	 	
		        	 	
		        	 	
		        }
		       
		      
		        
	}
	catch (JSONException e) 
	{
		e.printStackTrace();
	}

      
      User.this.recreate();
      /*  Intent time = new Intent(cnv.this,Main.class);
		startActivity(time);
		finish();*/
     
            
       }
    
 }
	
    //------------------for topics---------------------------------------
    
    
    private class studentsview1 extends AsyncTask<String, Void, String> {
    	JSONObject json;
    	 String parts[];
    	private ProgressDialog dialog = new ProgressDialog(User.this);

        /** progress dialog to show user that the backup is processing. */
        /** application context. */

        protected void onPreExecute() {
            this.dialog.setMessage("Please wait...");
            this.dialog.show();
        }
    	
    	
        @Override
        protected String doInBackground(String... urls) 
        {
        	List<NameValuePair> params = new ArrayList<NameValuePair>();
			//params.add(new BasicNameValuePair("datelow", date_pend_down.getText().toString()));
			params.add(new BasicNameValuePair("username", username_string));
			//params.add(new BasicNameValuePair("center", spinner_center.getSelectedItem().toString()));
			params.add(new BasicNameValuePair("password", password_string));
		
			 String url = "http://176.32.230.250/anshuli.com/sharpenup3/studDetails.php";
				
			 
			
         json = jparser.makeHttpRequest(url, "POST", params);
			
			
			//JSONArray jsonArray;
     		
        	
			return null;
        }
        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result)
        {  			
        	
      this.dialog.dismiss();
      	 
    //JSONArray jsonArray;
		
  	try {
			// Checking for SUCCESS TAG
			
  		//forjson.clear();
			
			
			//Toast.makeText(MainActivity.this, (CharSequence) json, 1).show();
		
				 JSONArray account= json.getJSONArray("pendings");
			        for(int i = 0; i < account.length(); i++)
			        {
			        	json =account.getJSONObject(i);
			        	
			        
			        
			        	 	
			        }
			       
			      
			        
  	}
  	catch (JSONException e) 
  	{
			e.printStackTrace();
		}


        
       }
    
 }	 
    
    
    //------------------------------------------------------------------------------------
    
    
    
    
    
    
	
	 
    private class studentsview extends AsyncTask<String, Void, String> {
    	JSONObject json;
    	private ProgressDialog dialog = new ProgressDialog(User.this);

        /** progress dialog to show user that the backup is processing. */
        /** application context. */

        protected void onPreExecute() {
            this.dialog.setMessage("Please wait...");
            this.dialog.show();
        }
    	
    	
        @Override
        protected String doInBackground(String... urls) 
        {
        	List<NameValuePair> params = new ArrayList<NameValuePair>();
        	params.add(new BasicNameValuePair("datelow", date_pend_down.getText().toString()));
			params.add(new BasicNameValuePair("batch", batch));
			params.add(new BasicNameValuePair("datehigh", date_pend_up.getText().toString()));
			params.add(new BasicNameValuePair("class",cls ));
			params.add(new BasicNameValuePair("subject",subject ));
			//params.add(new BasicNameValuePair("teacher", ));
		//	params.add(new BasicNameValuePair("topics", ));
			params.add(new BasicNameValuePair("center", center));
				//params.add(new BasicNameValuePair("send", send));
			 String url = "http://176.32.230.250/anshuli.com/sharpenup3/getStudents.php";
				
			 
			
         json = jparser.makeHttpRequest(url, "POST", params);
			
			
			JSONArray jsonArray;
     		
        	
			return null;
        }
        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result)
        {  			
        	
      this.dialog.dismiss();
      	 
      JSONArray jsonArray;
		
  	try {
			// Checking for SUCCESS TAG
			
  		categories_code.clear();
			
			
			//Toast.makeText(MainActivity.this, (CharSequence) json, 1).show();
		
				 JSONArray account= json.getJSONArray("pendings");
			        for(int i = 0; i < account.length(); i++)
			        {
			        	json =account.getJSONObject(i);
			        	String student =json.getString("STUDENTS");
			        	String sbmtd=json.getString("SUBMITTED");
			        	String cmptd=json.getString("COMPLETED");
			            String topic=json.getString("TOPIC");
			            String subject=json.getString("SUBJECT");
			            String date= json.getString("SUBMIT_DATE");
			            if(student.contains(NAME_ROLL_PAIR)){
			            categories_student.add(student);
			            categories_Date.add(date);
			            categories_subject.add(subject);
			            if(sbmtd.contains(NAME_ROLL_PAIR)){
			            categories_submitted_Info.add("Yes");
			            
			            }else
			            {
			            	 categories_submitted_Info.add("No");
			            }
			            
			            
			            if(cmptd.contains(NAME_ROLL_PAIR)){
			            categories_completed_Info.add("Yes");
			            
			            }
			            
			            else{
			            	 categories_completed_Info.add("No");
			            }
			            categories_topics.add(topic);		
			            }  }
			        
        
			        	
			        	 	
  		
			        	 	
			        
			      /* Toast.makeText(User.this, "total:"+total+"Completed:"+comp+"notcompleted:"+notcomp, 1).show();
			       int perComp= (int)((comp * 100.0f) / total); 
			       categories_code.add("Completed :"+perComp+"%");
			       int perNotComp=(int)((notcomp * 100.0f) / total);
			       categories_code.add("Not Completed :"+perNotComp+"%");*/
  	}
  	catch (JSONException e) 
  	{
			e.printStackTrace();
		}

     setlist();
            
       }
    
 }
	
	
	
	
	
	
	
	
	
	
	public  int counter(String s){
		
		int counter = 0;
		for( int i=0; i<s.length(); i++ ) {
		    if( s.charAt(i) == ',' ) {
		        counter++;
		    } 
		}
		return counter;
	}
	
	
	
	

	
	//--------------------------------------------Date Time ranges-------------------------------------------
		@SuppressWarnings("deprecation")
		   public void date_pend_low_range(View view) {
		      showDialog(999);
		   //   Toast.makeText(getApplicationContext(), "You Rock DUde!!", Toast.LENGTH_SHORT).show();
		      flag=0;
		   }
		
	

		@SuppressWarnings("deprecation")
		  public void date_pend_high_range(View view) {
		      showDialog(999);
		    //  Toast.makeText(getApplicationContext(), "You Rock DUde!!", Toast.LENGTH_SHORT) .show();
		      flag=1;
		   }
		  
		/*@SuppressWarnings("deprecation")
		  public void date_logged_low(View view) {
		      showDialog(999);
		      //Toast.makeText(getApplicationContext(), "You Rock DUde!!", Toast.LENGTH_SHORT) .show();
		      flag=2;
		   }
		@SuppressWarnings("deprecation")
		  public void date_logged_high(View view) {
		      showDialog(999);
		     // Toast.makeText(getApplicationContext(), "You Rock DUde!!", Toast.LENGTH_SHORT) .show();
		      flag=3;
		   }
*/
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
		    	  
		    	  arg2=arg2+1;
		         // TODO Auto-generated method stub
		         // arg1 = year
		         // arg2 = month
		         // arg3 = day
		    	  String strm="";
		    	  String strd="";

	         strm =appending0(arg2);
	         strd  =appending0(arg3);  	  
		    	  if (flag==0)
		         showDate0(arg1, strm, strd);
		    	  else if  (flag==1)
		 	         showDate1(arg1, strm, strd);
		    	  /*else  if (flag==2)
		 	         showDate2(arg1, strm, strd);
		    	  else if (flag==3)
		 	         showDate3(arg1, strm, strd);*/
		      }
		   };

	 private void showDate0(int year, String month, String day) {
			   date_pend_down.setText(new StringBuilder().append(year).append("-")
		      .append(month).append("-").append(day));
		   }
		   
		      public String appending0(int argument)
		      {String s;
		    	  
		    	  if (argument<10){
		    		  StringBuilder sb = new StringBuilder();
		    	  sb.append("0");
		    	  sb.append(argument);
		    	  s = sb.toString();
		    	  }
		    	  
		    	  else{
		    		  StringBuilder sb = new StringBuilder();
			    	 
			    	  sb.append(argument);
			    	  s = sb.toString();
		    	  }
		    	  
		    	  
		    	  return s;
		      }
		   
		   private void showDate1(int year, String month, String day) {
			   date_pend_up.setText(new StringBuilder().append(year).append("-")
					      .append(month).append("-").append(day));
		   }
		   /*private void showDate2(int year, String month, String day) {
			   date_log_down.setText(new StringBuilder().append(year).append("-")
					      .append(month).append("-").append(day));
		   }
		   private void showDate3(int year, String month, String day) {
			   date_log_up.setText(new StringBuilder().append(year).append("-")
					      .append(month).append("-").append(day));
		   }*/
		//-----------------------------------------------------------------------------------------------
		   

	
	
	
	
		   @TargetApi(Build.VERSION_CODES.HONEYCOMB)
		protected void setlist() {
		        // TODO Auto-generated method stub
				
		        dialogReg = new Dialog(User.this);
		        dialogReg.requestWindowFeature(Window.FEATURE_NO_TITLE);
		        dialogReg.setContentView(R.layout.students);
		        Integer count=2;
		        
		        t1 = (TableLayout)dialogReg.findViewById(R.id.main_table);
		   
		        TableRow tr_head = new TableRow(this);
				tr_head.setId(10);
				tr_head.setBackgroundColor(Color.parseColor("#DCEDC8"));
				tr_head.setLayoutParams(new LayoutParams(
				LayoutParams.MATCH_PARENT,
				LayoutParams.MATCH_PARENT));
				
				TextView label_date = new TextView(this);
		        label_date.setId(20);
		        label_date.setText(" Date ");
		        label_date. setTextSize(TypedValue.COMPLEX_UNIT_DIP,15);
		        label_date.setTextColor(Color.BLACK);
		        label_date.setPadding(0, 0, 0, 0);
		        tr_head.addView(label_date);// add the column to the table row here
		        if(subject.contentEquals("")){
		        TextView label_subject = new TextView(this);
		        label_subject.setId(21);// define id that must be unique
		        label_subject.setText("Subject "); // set the text for the header 
		        label_subject. setTextSize(TypedValue.COMPLEX_UNIT_DIP,15);
		        label_subject.setTextColor(Color.BLACK); // set the color
		       label_subject.setPadding(5, 5, 5, 5); // set the padding (if required)
		        tr_head.addView(label_subject); // add the column to the table row here}
		        }
		        TextView label_topic = new TextView(this);
		        label_topic.setId(21);// define id that must be unique
		        label_topic.setText("Topic "); // set the text for the header 
		        label_topic.setTextColor(Color.BLACK); // set the color
		        label_topic. setTextSize(TypedValue.COMPLEX_UNIT_DIP,15);
		        label_topic.setPadding(5, 5, 5, 5); // set the padding (if required)
		        tr_head.addView(label_topic); // add the column to the table row here
		        
		        TextView label_submitted = new TextView(this);
		        label_submitted.setId(21);// define id that must be unique
		        label_submitted.setText("Submitted "); // set the text for the header 
		        label_submitted. setTextSize(TypedValue.COMPLEX_UNIT_DIP,15);
		        label_submitted.setTextColor(Color.BLACK); // set the color
		       label_submitted.setPadding(5, 5, 5, 5); // set the padding (if required)
		        tr_head.addView(label_submitted); // add the column to the table row here
		        
		        TextView label_Completed = new TextView(this);
		        label_Completed.setId(21);// define id that must be unique
		        label_Completed.setText("Completed "); // set the text for the header
		        label_Completed. setTextSize(TypedValue.COMPLEX_UNIT_DIP,15);
		        label_Completed.setTextColor(Color.BLACK); // set the color
		        label_Completed.setPadding(5, 5, 5, 5); // set the padding (if required)
		        tr_head.addView(label_Completed); // add the column to the table row here
		        
		        
		        t1.addView(tr_head, new TableLayout.LayoutParams(
		                LayoutParams.MATCH_PARENT,
		                LayoutParams.MATCH_PARENT));
		        for(int i=0;i<categories_student.size();i++){
		        	
		        	gridViewSet(i, t1);
		        	
		        	
		        	
		        	
		        	
		        	
		        }
		        
		        
		        
		        
		        
		               
				dialogReg.show();
		    }

		public void gridViewSet(int location,TableLayout tl){
	        TableRow tr_head = new TableRow(this);
					tr_head.setId(10);
					
					if(categories_submitted_Info.get(location).equals("No") && categories_completed_Info.get(location).equals("No")  ){
						tr_head.setBackgroundColor(Color.parseColor("#FF5252"));
					}
					else if(categories_submitted_Info.get(location).equals("Yes") && categories_completed_Info.get(location).equals("Yes")  ){
						tr_head.setBackgroundColor(Color.parseColor("#8BC34A"));
					}
					else{
						tr_head.setBackgroundColor(Color.parseColor("#B6B6B6"));
					}
					tr_head.setLayoutParams(new LayoutParams(
					LayoutParams.MATCH_PARENT,
					LayoutParams.MATCH_PARENT));
					
					
					
					TextView label_date = new TextView(this);
			        label_date.setId(20);
			        label_date.setText(categories_Date.get(location)+"  ");
			        label_date. setTextSize(TypedValue.COMPLEX_UNIT_DIP,15);
			        label_date.setTextColor(Color.BLACK);
			      //  label_date.setPadding(0, 0, 0, 0);
			        tr_head.addView(label_date);// add the column to the table row here
			        if(subject.contentEquals("")){
			        TextView label_subject = new TextView(this);
			        label_subject.setId(21);// define id that must be unique
			        label_subject.setText(categories_subject.get(location)); // set the text for the header 
			        label_subject.setTextColor(Color.BLACK); // set the color
			        label_subject. setTextSize(TypedValue.COMPLEX_UNIT_DIP,15);
			       // label_subject.setPadding(5, 5, 5, 5); // set the padding (if required)
			        tr_head.addView(label_subject); // add the column to the table row here}
			        }
			        TextView label_topic = new TextView(this);
			        label_topic.setId(21);// define id that must be unique
			        label_topic.setText(categories_topics.get(location)); // set the text for the header 
			        label_topic.setTextColor(Color.BLACK); // set the color
			        label_topic.setPadding(5, 5, 5, 5); // set the padding (if required)
			        label_topic.setTextSize(TypedValue.COMPLEX_UNIT_DIP,15);
			        tr_head.addView(label_topic); // add the column to the table row here
			        
			        TextView label_submitted = new TextView(this);
			        label_submitted.setId(21);// define id that must be unique
			        label_submitted.setText(categories_submitted_Info.get(location)); // set the text for the header 
			        label_submitted.setTextColor(Color.BLACK); // set the color
			        label_submitted.setTextSize(TypedValue.COMPLEX_UNIT_DIP,15);
			      //  label_submitted.setPadding(5, 5, 5, 5); // set the padding (if required)
			        tr_head.addView(label_submitted); // add the column to the table row here
			        
			        TextView label_Completed = new TextView(this);
			        label_Completed.setId(21);// define id that must be unique
			        label_Completed.setText(categories_completed_Info.get(location)); // set the text for the header 
			        label_Completed.setTextColor(Color.BLACK); // set the color
			        label_Completed.setTextSize(TypedValue.COMPLEX_UNIT_DIP,15);
			       // label_Completed.setPadding(5, 5, 5, 5); // set the padding (if required)
			        tr_head.addView(label_Completed); // add the column to the table row here
			        
			        
			        tl.addView(tr_head, new TableLayout.LayoutParams(
			                LayoutParams.MATCH_PARENT,
			                LayoutParams.MATCH_PARENT));
		}
		   
		   
	 public void clearAllLists()
	 {
		  categories_student.clear();
          categories_Date.clear();
          categories_subject.clear();
          categories_completed_Info.clear();
          categories_submitted_Info.clear();
          categories_topics.clear();		
	 }
	
		   public void onListItemClick(ListView parent, View v,int position,long id){
				CheckedTextView item = (CheckedTextView) v;
				//Toast.makeText(this, c[position] + " checked : " +
				//item.isChecked(), Toast.LENGTH_SHORT).show();
			}
	
		   private void viewall() {
				
			   ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(User.this, android.R.layout.simple_list_item_1, categories_description);
		   	   
		        lv1.setTextFilterEnabled(true);
		        lv1.setAdapter(dataAdapter); 
		        for (int i = 0; i < dataAdapter.getCount(); i++) {
		        	lv1.setItemChecked(i, true);
		        	}
		        
			     // ListView Item Click Listener
				 
					}

}

