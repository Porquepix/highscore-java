package scores;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class HighScore1 {
	
	private static final String SCORE_URL = "https://api.thingspeak.com/channels/109317/feeds.csv";
	
	private URL scoresURL;
	
	public HighScore1() {
		try {
			this.scoresURL = new URL(SCORE_URL);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
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

}
