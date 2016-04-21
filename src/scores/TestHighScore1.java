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
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {	
		// Print all scores
		HighScore1 highscore = new HighScore1();
		for (String line : highscore.getScores()) {
			System.out.println(line);
		}
		
		// Username
		System.out.print("Username: ");
		Scanner stdin = new Scanner(System.in);
		String username = stdin.nextLine();
		stdin.close();
		
		// Read scores from the scoreSamples.txt
		int score = getRandomScoreFromFile();
		// Display player's name and score
		System.out.println("Username: " + username + ", Score: " + score);
	}

	/**
	 * Pick up a random score in the list of score in the file 'scoreSamples'.
	 * 
	 * @return Random score.
	 * @throws IOException Error if we have an IO issue with the file.
	 */
	private static int getRandomScoreFromFile() throws IOException {
		Path scoreFile = Paths.get("scoreSamples.txt");
		List<String> scores = Files.readAllLines(scoreFile);
		int playerScoreIndex = new Random().nextInt(scores.size());
		return Integer.parseInt(scores.get(playerScoreIndex));
	}
	
}
