package telran.games.bullsAndCows;


import java.util.ArrayList;
import static telran.games.bullsAndCows.BullsAndCowsModel.*;
import static telran.games.bullsAndCows.BullsAndCowsView.*;

public class BullsCowsGameImpl implements GuessGame{
	String secret;
	private boolean isGameStarted = false;
	private boolean isGameFinished = false;
	private static ArrayList<String> buffer = new ArrayList<String>();
	private final static int MAX_DIGITS = 4;
	@Override
	public String toString() {
		return "BullsCowsGameImpl [secret=" + secret + ", isGameStarted=" + isGameStarted + ", isGameFinished="
				+ isGameFinished + "]";
	}
	public BullsCowsGameImpl() {
	}
	@Override
	public String startGame() {
		secret =  genUniqueRandomNumber();
		isGameStarted = true;
		isGameFinished = false;		
		buffer.clear();
		buffer.add(prompt());
		return prompt();
	}

	@Override
	public String prompt() {
		return "Game of Cows and Bulls! Please gues the number (4 digits) type move as command and number as string";
	}

	@Override
	public String move(String userInput) {
		System.out.println(userInput);
		
		int[] result = compareToSecret(secret, userInput);
		buffer.add(String.format("%s (%d cows; %d bulls)", userInput, result[0], result[1]));
		if (result[0] == 0 && result[1] == MAX_DIGITS) {
			isGameFinished = true;
			buffer.add("Finish!");
			sendToFile(buffer);
			return "Finish! Total moves - "+(buffer.size()-2);
		}
		return String.format("%s (%d cows; %d bulls)", userInput, result[0], result[1]);
	}

	@Override
	public boolean isFinished() {
		return isGameFinished;
	}
	public boolean isStarted() {
		return isGameStarted;
	}
}
