package scores;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class list handles HighScores in our game.
 */
public class HighScore2 {
	
	/**
	 * URL where are stored the scores.
	 */
	private static final String SCORE_URL = "https://api.thingspeak.com/channels/109317/feeds.csv";
	
	/**
	 * The separator used in the csv file.
	 */
	private static final String CSV_SPERATOR = ",";
	
	/**
	 * Index (column) of the player's name in the csv file.
	 */
	private static final int INDEX_PLAYER_NAME = 3; 
	
	/**
	 * Index (column) of the player's score in the csv file.
	 */
	private static final int INDEX_PLAYER_SCORE = 2;
	
	
	
	/**
	 * This URL represents where the highscores can be retrieve from a server. 
	 */
	private URL scoresURL;
	
	/**
	 * Constructor for the HighScores handler.
	 */
	public HighScore2() {
		try {
			this.scoresURL = new URL(SCORE_URL);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Retrieve all previous scores stored on the server. 
	 * 
	 * @return List of all previous scores.
	 * @throws IOException An error can occur during the communication with the server.
	 */
	public List<String> getScores() throws IOException {
		List<String> scores = new ArrayList<>();
		BufferedReader input = new BufferedReader(new InputStreamReader(scoresURL.openStream()));
		
		// We skip the first line (header) which doesn't contain score
		String inputLine = input.readLine();
		while ((inputLine = input.readLine()) != null) {
			if (inputLine.length() > 0) {
				scores.add(inputLine);				
			}
		}

		return scores;
	}
	
	public BestPlayer2[] tenBestScores(List<String> readLines) {
		List<BestPlayer2> bestPlayers = new ArrayList<>();
		
		for (String line : readLines) {
			// Parsing of the line
			String[] columns = line.split(CSV_SPERATOR); 
			int score = Integer.parseInt(columns[INDEX_PLAYER_SCORE]);
			String name = columns[INDEX_PLAYER_NAME];
			BestPlayer2 player = new BestPlayer2(name, score);
			
			bestPlayers.add(player);
		}
		
		Collections.sort(bestPlayers, Collections.reverseOrder());
		return bestPlayers.toArray(new BestPlayer2[10]);
	}

}
