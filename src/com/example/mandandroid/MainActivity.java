package com.example.mandandroid;

import java.util.Random;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class MainActivity extends Activity implements OnClickListener {


	private static final Random rgenerator = new Random();
	private ImageView iv;
	private int q;
	MediaPlayer a;
	MediaPlayer b;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		q = rgenerator.nextInt(119);
		iv = (ImageView) findViewById(R.id.imageView1);
		int resId = getResources().getIdentifier("w"+q, "drawable", getPackageName());
		iv.setImageResource(resId);
		iv.setOnClickListener(this);
		a = MediaPlayer.create(getApplicationContext(), R.raw.lmsm); 
		a.start(); 
		a.setVolume(0.8f,0.8f);
		a.setLooping(true);
	
	}
	
	protected void onPause() {
	    super.onPause();
	    a.stop();
	}
	protected void onResume() {
	    super.onResume();
	    a = MediaPlayer.create(getApplicationContext(), R.raw.lmsm); 
	    a.start();
	    a.setLooping(true);
	}
	
    
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}


	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.imageView1)
		{
			int resIdAudio = getResources().getIdentifier("wal_ter"+ rgenerator.nextInt(5),"raw", getPackageName());
			b = MediaPlayer.create(getApplicationContext(), resIdAudio);
			b.start();
			int resId = getResources().getIdentifier("w"+ rgenerator.nextInt(119), "drawable", getPackageName());
			iv.setImageResource(resId);
		}
	}
}