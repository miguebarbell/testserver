package us.debloat.testserver.models;

public class Score {
	public int score;
	public String difficulty;
	public int id;
	public String username;

	public Score(int score, String difficulty, String username) {
		this.score = score;
		this.difficulty = difficulty;
//		this.id = id;
		this.username = username;
	}
}
