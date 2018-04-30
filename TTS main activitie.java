package com.mycompany.myapp6;

import android.app.*;
import android.os.*;
import android.speech.tts.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import java.util.*;

public class MainActivity extends Activity implements TextToSpeech.OnInitListener
{

	public TextToSpeech mts;
	public Button bu;
	public EditText tv;
	public String st;
	


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main); 
		mts=new TextToSpeech(this,this); 
		bu=(Button) findViewById(R.id.mainButton1);
		tv=(EditText) findViewById(R.id.mainEditText1);
		
		
		bu.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View p1)
				{
				if(tv.getText().toString().trim().length()==0){
					mts.speak("you have to enter all the fields ,you asshole", TextToSpeech.QUEUE_FLUSH,null);
				}else{
					st=tv.getText().toString();
					Toast.makeText(MainActivity.this,st,Toast.LENGTH_SHORT).show();
					mts.speak(st,TextToSpeech.QUEUE_FLUSH,null);
					}
				}
				
			
		});
		
	}

	@Override
	protected void onDestroy()
	{
		String fk="hey ,bye bye ,see you later, ";
		mts.speak(fk,TextToSpeech.QUEUE_FLUSH,null);
		super.onDestroy();
	}
		
	
	public void onInit(int p1)
	{
		// TODO: Implement this method
		if(p1==TextToSpeech.SUCCESS){ 
		
		int rl =mts.setLanguage(Locale.US);
		
		if(rl==TextToSpeech.LANG_MISSING_DATA || rl==TextToSpeech.LANG_NOT_SUPPORTED){ 
		Toast.makeText(this,"not supported",Toast.LENGTH_SHORT);
		} else{ 
		bu.setEnabled(true);
		
		}
		}else{
			Toast.makeText(this,"not Intlised",Toast.LENGTH_SHORT).show();
		}
	}
		
   
}