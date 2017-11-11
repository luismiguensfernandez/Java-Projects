package io.github.luismiguensfernandez;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.view.View;

public class MainActivity extends Activity{

    private TextView m_displayWord;
    private ImageView m_hangmanImage;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(this.hangmanLayout());
        startGame();
	}

	private View hangmanLayout() {

        LinearLayout fullLayout = new LinearLayout(this);
        fullLayout.setLayoutParams(
                new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT));
        fullLayout.setOrientation(LinearLayout.VERTICAL);

        LinearLayout topLayout = new LinearLayout(this);
        topLayout.setLayoutParams(
                new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT,
                        1.0f));
        topLayout.setOrientation(LinearLayout.VERTICAL);

        LinearLayout middleLayout = new LinearLayout(this);
        middleLayout.setLayoutParams(
                new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT,
                        2.0f));
        middleLayout.setOrientation(LinearLayout.VERTICAL);

        LinearLayout bottomLayout = new LinearLayout(this);
        bottomLayout.setLayoutParams(
                new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT,
                        1.0f));
        bottomLayout.setOrientation(LinearLayout.VERTICAL);

        fullLayout.addView(topLayout);
        fullLayout.addView(middleLayout);
        fullLayout.addView(bottomLayout);

        m_displayWord = new TextView(this);
        TextView blabla2 =  new TextView(this);
        TextView blabla3 =  new TextView(this);
        blabla2.setText("xxxxxxxxxxxxxxxx");
        blabla3.setText("xxxxxxxxxxxxxxxxxxxxxxxx");
        topLayout.addView(m_displayWord);
        middleLayout.addView(blabla2);
        bottomLayout.addView(blabla3);

        return fullLayout;
    }

    private void startGame()
    {
        try {
            m_displayWord.setText(RandomWord.get(this.getApplicationContext()));
        } catch (Exception e) {
            m_displayWord.setText("Something wrong selecting a random word: \n" +
                                                                        e.getLocalizedMessage());
        };
    }
}
