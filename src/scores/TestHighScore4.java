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
public class TestHighScore4 {

	/**
	 * Program entry point.
	 * 
	 * @param args
	 *            Console arguments.
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		Scanner stdin = new Scanner(System.in);
		HighScore3 highscore = new HighScore3();
		
		boolean done = false;

		// Loop
		while (!done) {

			// Print the ten best scores
			BestPlayer3[] bestPlayers = highscore.tenBestScores(highscore.getScores());
			printBestPlayers(bestPlayers);

			// Ask Player
			System.out.print("Do you want to start a new game ? (yes or no) ");
			String response = stdin.nextLine();
			if (response.equals("yes")) {

				// Username
				System.out.print("Username: ");
				String username = stdin.nextLine();

				// Read scores from the scoreSamples.txt
				int score = getRandomScoreFromFile();
				// Display player's name and score
				System.out.println("Username: " + username + ", Score: " + score);

				// Add if he's in the top 10
				for (BestPlayer3 player : bestPlayers) {
					if (player != null && player.getScore() < score) {
						highscore.sendScore(new BestPlayer3(username, score));
					}
				}

			} else if (response.equals("no")) {
				done = true;
			} else {
				System.err.println("Please write 'yes' or 'no'.");
			}

		} // End game loop
		
		stdin.close();

	}

	/**
	 * Print the ladder of the best players.
	 * 
	 * @param bestPlayers
	 *            The best players to display.
	 */
	private static void printBestPlayers(BestPlayer3[] bestPlayers) {
		int i = 1;
		for (BestPlayer3 player : bestPlayers) {
			if (player != null) {
				System.out.println(i + ". " + player);
				i++;
			}
		}
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
