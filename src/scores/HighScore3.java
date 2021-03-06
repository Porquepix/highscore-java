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
public class HighScore3 {
	
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
	public HighScore3() {
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
	
	/**
	 * Extract the data from the read lines and convert then into 
	 * BestPlayer object.
	 * 
	 * @param readLines The csv lines read from the server.
	 * @return Array of BestPlayer corresponding to each csv lines.
	 */
	public BestPlayer3[] tenBestScores(List<String> readLines) {
		List<BestPlayer3> bestPlayers = new ArrayList<>();
		
		for (String line : readLines) {
			// Parsing of the line
			String[] columns = line.split(CSV_SPERATOR); 
			int score = Integer.parseInt(columns[INDEX_PLAYER_SCORE]);
			String name = columns[INDEX_PLAYER_NAME];
			BestPlayer3 player = new BestPlayer3(name, score);
			
			bestPlayers.add(player);
		}
		
		Collections.sort(bestPlayers, Collections.reverseOrder());
		return bestPlayers.subList(0, 10).toArray(new BestPlayer3[10]);
	}
	
	/**
	 * Send a a new highscore to the server. 
	 * 
	 * @param player Player with his highscore to send to the server.
	 * @throws IOException  An error can occur during the communication with the server.
	 */
	public void sendScore(BestPlayer3 player) throws IOException{
		String nom = player.getName();
		int score = player.getScore();
		
		// See thinkspeak API
		URL getURL = new URL("https://api.thingspeak.com/update?api_key=3KIYU8HBCBTTFKP2&field1=" + score + "&field2=" + nom);
		getURL.openStream();
	}

}
