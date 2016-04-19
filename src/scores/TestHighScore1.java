package scores;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Test class for HighScore class.
 */
public class TestHighScore1 {

	/**
	 * Program entry point.
	 * 
	 * @param args Console arguments.
	 */
	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		
		// Username
		System.out.print("Username: ");
		String username = stdin.nextLine();
		stdin.close();
		
		// Read scores from the scoreSamples.txt
		Path scoreFile = Paths.get("scoreSamples.txt");
		try {
			List<String> scores = Files.readAllLines(scoreFile);
			int playerScoreIndex = new Random().nextInt(scores.size());
			// Display player's name and score
			System.out.println("Username: " + username + ", Score: " + scores.get(playerScoreIndex));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
