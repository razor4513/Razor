package com.example.razor;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

public class Splash extends Activity {
	MediaPlayer ourSong;

	@Override
	protected void onCreate(Bundle blah) {
		// TODO Auto-generated method stub
		super.onCreate(blah);
		setContentView(R.layout.splash);
		ourSong= MediaPlayer.create(Splash.this, R.raw.soundfile);
		ourSong.start();		
		Thread timer = new Thread(){
			public void run(){
				try{
					sleep(10000);
				}catch(InterruptedException e){
					e.printStackTrace();
				}finally{
					Intent openStartingPoint = new Intent("com.example.razor.MENU");
					startActivity(openStartingPoint);//onpause is called here
				}
			}
		};
		timer.start();
	}

	@Override
	protected void onPause() {//called when activity fades to background
		// TODO Auto-generated method stub
		super.onPause();
		ourSong.release();
		finish();//kill yourself
	}
	
	

}
