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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
}
