package br.com.swhw.android.part1.modernart;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class MainActivity extends Activity {
	
	private final static String TAG = "ModerArtUI-app";
	private SeekBar seekBar;
	
	private Button button1;
	private Button button2;
	private Button button3;
	private Button button5;
	
	private int color1;
	private int color2;
	private int color3;
	private int color5;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		color1 = getResources().getColor(R.color.button1);
		color2 = getResources().getColor(R.color.button2);
		color3 = getResources().getColor(R.color.button3);
		color5 = getResources().getColor(R.color.button5);
		Log.d(TAG, "Default Red: " + Color.red(color1));
		
		button1 = (Button)findViewById(R.id.button1);
		button2 = (Button)findViewById(R.id.button2);
		button3 = (Button)findViewById(R.id.button3);
		button5 = (Button)findViewById(R.id.button5);
		
		seekBar = (SeekBar) findViewById(R.id.seekBar1);
		seekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
			}
			
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				changeButtonsColor(progress);
			}
		});
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    int id = item.getItemId();
	    if (id == R.id.action_moreinformation) {
	        new VisitMomaDialogFragment().show(getFragmentManager(), "MomaDialog");
	        
	    }
	    return true;
	}
	
	private void changeButtonsColor(int seekbarValue) {
		button1.setBackgroundColor(Color.rgb(getNewValue(Color.red(color1), seekbarValue), getNewValue(Color.green(color1), seekbarValue), getNewValue(Color.blue(color1), seekbarValue)));
		button2.setBackgroundColor(Color.rgb(getNewValue(Color.red(color2), seekbarValue), Color.green(color2), getNewValue(Color.blue(color2), seekbarValue)));
		button3.setBackgroundColor(Color.rgb(getNewValue(Color.red(color3), seekbarValue), getNewValue(Color.green(color3), seekbarValue), Color.blue(color3)));
		button5.setBackgroundColor(Color.rgb(getNewValue(Color.red(color5), seekbarValue), getNewValue(Color.green(color5), seekbarValue), getNewValue(Color.blue(color5), seekbarValue)));
	}
	
	private int getNewValue(int defaultValue, int rate) {
		double step = (175 - defaultValue)/100d;
		return (int)(defaultValue+(step/2 * rate));
	}
}
