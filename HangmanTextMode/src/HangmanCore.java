import java.util.ArrayList;
import java.util.List;

enum STATE {PLAYING, GAME_OVER, WIN };

public class HangmanCore {
	private STATE m_state;
	private String m_word;
	private List<Character> m_playedLetters;
	private int m_triesLeft;
	
	private HangmanCore(String word, int nTries)
	{
		m_state = STATE.PLAYING;
		m_word = word.toUpperCase();
		m_playedLetters = new ArrayList<Character>();
		m_triesLeft = nTries;
	}
	
	public HangmanCore()
	{
		this("test", 8);
	}
	
	public int triesLeft() 
	{ 
		return m_triesLeft; 
	}
	
	public void play(Character letter)
	{
		if(Character.isLetter(letter) == false)
			return; // Do nothing
		
		letter = Character.toUpperCase(letter);
		
		if(m_playedLetters.contains(letter) == false)
			m_playedLetters.add(letter);
			if (m_word.indexOf(letter) ==  -1) // -1 means not found
			{
				m_triesLeft--;
				updateState();
			}
			
	}
	
	public STATE state()
	{
		return m_state;
	}
	
	public String word()
	{
		String word = " ";
		for (Character letter: m_word.toCharArray())
			if(m_playedLetters.contains(letter) == true)
				word += letter.toString() + ' ';
			else
				word += Character.toString('_') + ' ';
		return word;
	}
	
	private void updateState()
	{
		if(m_triesLeft == 0)
			m_state = STATE.GAME_OVER;
		
		boolean everythingFound = true;
		for(Character letter: m_word.toCharArray())
		{
			if(m_playedLetters.contains(letter) == false)
			{
				everythingFound = false;
				break;
			}
		}
		
		if(everythingFound)
			m_state = STATE.WIN;
	}
}
