package scores;

/**
 * This class represents a player with a name and a score.
 */
public class BestPlayer3 implements Comparable<BestPlayer3> {
	
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
	public BestPlayer3(String playerName, int playerScore) {
		this.name = playerName;
		this.score = playerScore;
	}

	@Override
	public int compareTo(BestPlayer3 otherPlayer) {
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

	/**
	 * Get the name of the player.
	 * 
	 * @return The name of the player.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the name of the player.
	 *  
	 * @param name The new name of the player.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get the score of the player.
	 * 
	 * @return The score of the player.
	 */
	public int getScore() {
		return score;
	}

	/**
	 * Set the score of the player.
	 * 
	 * @param score The new score of the player.
	 */
	public void setScore(int score) {
		this.score = score;
	}
}
