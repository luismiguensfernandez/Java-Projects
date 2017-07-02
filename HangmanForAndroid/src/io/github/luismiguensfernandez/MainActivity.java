package io.github.luismiguensfernandez;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		TextView text = new TextView(this);
		
		try {
			text.setText(RandomWord.get(this.getApplicationContext()));
		} catch (Exception e) {
			text.setText("Something wrong selecting a random word: \n" + e.getLocalizedMessage());
		}
		
		setContentView(text);
	}
}
