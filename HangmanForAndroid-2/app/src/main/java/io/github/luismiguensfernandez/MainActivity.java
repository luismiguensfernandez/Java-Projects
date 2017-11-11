package io.github.luismiguensfernandez;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.view.View;

import java.util.SortedMap;

public class MainActivity extends Activity{

    private TextView m_displayWord;
    private ImageView m_hangmanImage;
    private SortedMap<Character, Button> m_keyboard;

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
                        ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        fullLayout.setOrientation(LinearLayout.VERTICAL);
        fullLayout.setWeightSum(100.0f);

        LinearLayout topLayout = new LinearLayout(this);
        topLayout.setLayoutParams(
                new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT,
                        25.0f));
        topLayout.setOrientation(LinearLayout.VERTICAL);

        LinearLayout middleLayout = new LinearLayout(this);
        middleLayout.setLayoutParams(
                new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT,
                        50.0f));
        middleLayout.setOrientation(LinearLayout.VERTICAL);

        LinearLayout bottomLayout = new LinearLayout(this);
        bottomLayout.setLayoutParams(
                new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT,
                        25.0f));
        bottomLayout.setOrientation(LinearLayout.VERTICAL);

        fullLayout.addView(topLayout);
        fullLayout.addView(middleLayout);
        fullLayout.addView(bottomLayout);

        m_displayWord = new TextView(this);
        m_displayWord.setGravity(Gravity.CENTER);
        m_displayWord.setLayoutParams(
                new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        //m_displayWord.setAutoSizeTextTypeUniformWithConfiguration(  TextView.AUTO_SIZE_TEXT_TYPE_UNIFORM);
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
