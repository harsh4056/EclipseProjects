package com.example.alarmexample;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import android.widget.Toast;


public class MyService extends Service {
	JSONParser jparser = new JSONParser();
	public MyService() {
	}

	@Override
	public IBinder onBind(Intent intent) {
		throw new UnsupportedOperationException("Not yet implemented");
	}

	@Override
	public void onCreate() {
		Toast.makeText(this, "Service was Created "+("\ud83d\ude01"), Toast.LENGTH_LONG).show();

	}

	@Override
	public void onStart(Intent intent, int startId) {
		Toast.makeText(this, "Service was Started"+("\ud83d\ude01"), Toast.LENGTH_LONG).show();
		new studentsview().execute();
		// Perform your long running operations here.
	

	}

	@Override
	public void onDestroy() {
		
		Toast.makeText(this, "Service was Stopped", Toast.LENGTH_LONG).show();
 
	}
	
	
	
	@SuppressWarnings("deprecation")
	private void triggerNotification(String message,String heading) {
		   String ns = Context.NOTIFICATION_SERVICE;
		   NotificationManager mNotificationManager = (NotificationManager) getSystemService(ns);

		   int icon = R.drawable.ic_launcher;        
		   CharSequence tickerText = "Hello"; // ticker-text
		   long when = System.currentTimeMillis();         
		   Context context = getApplicationContext();     
		   CharSequence contentTitle = heading;  
		   CharSequence contentText = message;      
		   Intent notificationIntent = new Intent(this, MainActivity.class);
		   PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);
	
		Notification notification = new Notification(icon, tickerText, when);
		   notification.setLatestEventInfo(context, contentTitle, contentText, contentIntent);
		   notification.defaults = Notification.DEFAULT_ALL;

		   // and this
		   final int HELLO_ID = 1;
		   mNotificationManager.notify(HELLO_ID, notification);
		}
	
	
	  private class studentsview extends AsyncTask<String, Void, String> {
	    	JSONObject json;
	    

	        /** progress dialog to show user that the backup is processing. */
	        /** application context. */

	        protected void onPreExecute() {
	     
	        }
	       
	    	
	    	
	        @Override
	        protected String doInBackground(String... urls) 
	        {
	        	List<NameValuePair> params = new ArrayList<NameValuePair>();
				//params.add(new BasicNameValuePair("datelow", date_pend_down.getText().toString()));
	        	params.add(new BasicNameValuePair("subject", "SOCIALITY"));
				//params.add(new BasicNameValuePair("center", spinner_center.getSelectedItem().toString()));
				params.add(new BasicNameValuePair("class", "6th"));
			
				 String url = "http://176.32.230.250/anshuli.com/sharpenup3/gettopics.php";
					
				 
				
	         json = jparser.makeHttpRequest(url, "POST", params);
				
				
				//JSONArray jsonArray;
	     		
	        	
				return null;
	        }
	        // onPostExecute displays the results of the AsyncTask.
	        @Override
	        protected void onPostExecute(String result)
	        {  			
	        	
	    
	      	 
	    //JSONArray jsonArray;
			
	  	try {
				// Checking for SUCCESS TAG
				
	  		//forjson.clear();
				
	  		 String	topics="";
	  		 String id="";
				//Toast.makeText(MainActivity.this, (CharSequence) json, 1).show();
			
					 JSONArray account= json.getJSONArray("pendings");
				        for(int i = 0; i < account.length(); i++)
				        {
				        	json =account.getJSONObject(i);
				        	
				       	topics=json.getString("TOPIC");
				        	id= json.getString("S_NO");
				        	 	
				        	 	// forjson.add(Roll+"-"+ NAME);
				        	 	//categories_description.add(description);
				        	 	
				        	 	
				        	 	
				        }
				       if(!topics.equals(""))
				    triggerNotification(topics, id);
				   
				        
	  	}
	  	catch (JSONException e) 
	  	{
				e.printStackTrace();
				Toast.makeText(getApplicationContext(), "No internet connectivity "+("\ud83d\ude2d"), Toast.LENGTH_LONG).show();
			}
        catch(NullPointerException e)
	  	{
        	e.printStackTrace();
        	Toast.makeText(getApplicationContext(), "No internet connectivity"+("\ud83d\ude2d"), Toast.LENGTH_LONG).show();
	  	}
	 
	         }
	    
	 }	 

	
	
	
	
	
	
	
	
	
	
	
}