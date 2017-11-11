package io.github.luismiguensfernandez;

import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.view.View;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;

public class MainActivity extends Activity{

    private TextView m_displayWord;
    private ImageView m_hangmanImage;
    private Map<Character, Button> m_keyboard;

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
                        ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT,
                        50.0f));
        middleLayout.setOrientation(LinearLayout.VERTICAL);

        LinearLayout bottomLayout = new LinearLayout(this);
        bottomLayout.setLayoutParams(
                new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT,
                        25.0f));

        fullLayout.addView(topLayout);
        fullLayout.addView(middleLayout);
        fullLayout.addView(bottomLayout);

        m_displayWord = new TextView(this);
        m_displayWord.setGravity(Gravity.CENTER);
        m_displayWord.setLayoutParams(
                new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        m_displayWord.setTextSize(35.0f);

        TextView blabla2 =  new TextView(this);
        blabla2.setText("xxxxxxxxxxxxxxxx");
        topLayout.addView(m_displayWord);
        middleLayout.addView(blabla2);

        GridLayout keyboardLayout = new GridLayout(this);
        keyboardLayout.setColumnCount(6);

        bottomLayout.addView(keyboardLayout);

        m_keyboard = new HashMap<>();
        for (char letter = 'A'; letter <= 'Z'; ++letter)
        {
            Button button = new Button(this);
            button.setText(Character.toString(letter));
            m_keyboard.put(letter, button);
            keyboardLayout.addView(button);
            button.setEnabled(false);
        }

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
