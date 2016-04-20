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
	 * @param args Console arguments.
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {	
		//Loop
		while (true){
			// Print the ten best scores
			HighScore3 highscore = new HighScore3();
			BestPlayer3[] bestPlayers = highscore.tenBestScores(highscore.getScores());
			int i = 1;
			for (BestPlayer3 player : bestPlayers) {
				if (player != null) {
					System.out.println(i + ". " + player);	
					i++;
				}
			}
			//Ask Player
			System.out.print("Do you want to start a new game ? (yes or no) ");
			Scanner stin = new Scanner(System.in);
			String response = stin.nextLine();
			stin.close();
			if (response=="yes"){
				// Username
				System.out.print("Username: ");
				Scanner stdin = new Scanner(System.in);
				String username = stdin.nextLine();
				stdin.close();
			
				// Read scores from the scoreSamples.txt
				Path scoreFile = Paths.get("scoreSamples.txt");
				List<String> scores = Files.readAllLines(scoreFile);
				int playerScoreIndex = new Random().nextInt(scores.size());
				String playerScore = scores.get(playerScoreIndex);
				// Display player's name and score
				System.out.println("Username: " + username + ", Score: " + playerScore);
			
				//Add if he's in the top 10
				for (BestPlayer3 player : bestPlayers) {
					if (player!=null && player.getScore() < Integer.parseInt(playerScore)) {
						highscore.sendScore(new BestPlayer3(username, Integer.parseInt(playerScore)));
					}
				}
			}
		}
		
	}
	
}

