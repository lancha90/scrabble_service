package co.com.scrabble.dmha.model;

import java.util.List;

public class ScrabbleResponse extends HeaderResponse{

	private List<ScrabbleWord> words;
	
	public ScrabbleResponse(int code,String message, List<ScrabbleWord> words){
		super(code,message);
		this.words=words;
	}

	
	public List<ScrabbleWord> getWords() {
		return words;
	}

	public void setWords(List<ScrabbleWord> words) {
		this.words = words;
	}
	
}
