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
public class TestHighScore2 {

	/**
	 * Program entry point.
	 * 
	 * @param args Console arguments.
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {	
		// Print the ten best scores
		HighScore2 highscore = new HighScore2();
		BestPlayer2[] bestPlayers = highscore.tenBestScores(highscore.getScores());
		int i = 1;
		for (BestPlayer2 player : bestPlayers) {
			if (player != null) {
				System.out.println(i + ". " + player);	
				i++;
			}
		}
		
		// Username
		System.out.print("Username: ");
		Scanner stdin = new Scanner(System.in);
		String username = stdin.nextLine();
		stdin.close();
		
		// Read scores from the scoreSamples.txt
		Path scoreFile = Paths.get("scoreSamples.txt");
		List<String> scores = Files.readAllLines(scoreFile);
		int playerScoreIndex = new Random().nextInt(scores.size());
		// Display player's name and score
		System.out.println("Username: " + username + ", Score: " + scores.get(playerScoreIndex));
	}
	
}