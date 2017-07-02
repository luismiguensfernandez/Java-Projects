import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HangmanGame {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		
		HangmanCore game = new HangmanCore();

		while(game.state() == STATE.PLAYING)
		{
			System.out.println("Word:" + game.word());
			System.out.println("Tries Left: " + game.triesLeft());
			System.out.print("[letter] ? ");
			String line = bufferedReader.readLine();
			game.play(line.charAt(0));

			switch (game.state()) {
			case GAME_OVER:
				System.out.println("GAME OVER");
				System.out.println("Word:" + game.word());
				break;
			case WIN:
				System.out.println("You win!");
				System.out.println("Word:" + game.word());
				break;
			default:
				// do nothing
			}
		}
	}
}
