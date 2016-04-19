package scores;

/**
 * This class represents a player with a name and a score.
 */
public class BestPlayer2 implements Comparable<BestPlayer2> {
	
	/**
	 * Player's name.
	 */
	private String name;
	
	/**
	 * Player's score.
	 */
	private int score;
	
	/**
	 * Construct a new player.
	 * 
	 * @param playerName The name of the player.
	 * @param playerScore The current score for the player.
	 */
	public BestPlayer2(String playerName, int playerScore) {
		this.name = playerName;
		this.score = playerScore;
	}

	@Override
	public int compareTo(BestPlayer2 otherPlayer) {
		if (this.score == otherPlayer.score) {
			return 0;
		} else {			
			return this.score < otherPlayer.score ? -1 : 1;
		}
	}
	
	@Override
	public String toString() {
		return "Username: " + this.name + ", Score: " + this.score;
	}

}
