package co.com.scrabble.dmha.model;

/**
 * Class to define structure to response
 * @author <a href="mailto:diego.herrera@ingeneo.com.co">Diego Mauricio Herrera Alzate</a>
 *
 */
public class ScrabbleWord {

	private int points;
	private String word;
	
	public ScrabbleWord(String word,int points) {
		super();
		this.word = word;
		this.points = points;
	}
	
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	
}
