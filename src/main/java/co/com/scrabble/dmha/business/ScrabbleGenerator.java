package co.com.scrabble.dmha.business;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import co.com.scrabble.dmha.model.ScrabbleResponse;
import co.com.scrabble.dmha.model.ScrabbleWord;

public class ScrabbleGenerator {

	private List<String> dictionay = new ArrayList<String>(Arrays.asList("ABRIGO",
			"BOLIVAR", "CAMPO", "DIGO", "ESTOY", "FARO", "GRANO", "HIGADO",
			"INFORME", "JIRAFA", "KILO", "LIMON", "MICO", "NICOLAS", "ORIGEN",
			"PASO", "QUESO", "RUGBY", "SAPO", "TIMBRE", "UMBRAL", "VICTOR",
			"WALTER", "XML", "YA", "ZETA"));

	public ScrabbleGenerator() {
		super();
	}

	public ScrabbleResponse getWordsDictionary(String data) {

		ScrabbleResponse toReturn;
		// define object to return
		List<ScrabbleWord> toReturnWords = new ArrayList<ScrabbleWord>();

		// remove all commas
		data = data.replaceAll(",", "").toUpperCase();

		// define regex to validate is the word is valid
		Pattern p = Pattern.compile("\\w+");
		Matcher m;

		// build regex to evaluate words from dictionary
		String regex = "[" + data + "]";

		// define temporal value
		String tmp = "";

		for (String item : dictionay) {

			// replace letters from parameters of service
			tmp = item.replaceAll(regex, CommonConstants.SYMBOL_ASTERISK);
			m = p.matcher(tmp);

			// are there space in data ?
			if (m.find()) {

				if (data.contains(" ")) {
					int count = 0;
					do {
						if (m.group().length() == 1) {
							count++;
						} else {
							count = 99;
							break;
						}
					} while (m.find());

					if (count == 1) {
						toReturnWords.add(new ScrabbleWord(item,
								getPoints(item)));
					}
				}
			} else {
				// validate if the word from dictionary is valid (all characters
				// in *) and add value to return
				toReturnWords.add(new ScrabbleWord(item, getPoints(item)));
			}

		}

		if (toReturnWords.size() == 0) {
			toReturn = new ScrabbleResponse(CommonConstants.HTTP_NO_CONTENT,
					"Oops, no se encontraron palabras validas!", toReturnWords);
		} else {
			toReturn = new ScrabbleResponse(CommonConstants.HTTP_OK,
					"Woo, encontramos palabras validas!", toReturnWords);
		}

		return toReturn;
	}

	/**
	 * Calculate points to a word
	 * 
	 * @param word
	 * @return
	 */
	private int getPoints(String word) {
		int points = 0;

		for (int i = 0; i < word.length(); i++) {

			if (word.charAt(i) == 'A' || word.charAt(i) == 'E'
					|| word.charAt(i) == 'O' || word.charAt(i) == 'I'
					|| word.charAt(i) == 'S' || word.charAt(i) == 'N'
					|| word.charAt(i) == 'L' || word.charAt(i) == 'R'
					|| word.charAt(i) == 'U' || word.charAt(i) == 'T') {
				points += 1;
			} else if (word.charAt(i) == 'D' || word.charAt(i) == 'G') {
				points += 2;
			} else if (word.charAt(i) == 'C' || word.charAt(i) == 'B'
					|| word.charAt(i) == 'M' || word.charAt(i) == 'P') {
				points += 3;
			} else if (word.charAt(i) == 'H' || word.charAt(i) == 'F'
					|| word.charAt(i) == 'Y' || word.charAt(i) == 'V') {
				points += 4;
			} else if (word.charAt(i) == 'H') {
				points += 5;
			} else if (word.charAt(i) == 'J' || word.charAt(i) == 'Ñ'
					|| word.charAt(i) == 'X') {
				points += 8;
			} else if (word.charAt(i) == 'Z') {
				points += 10;
			}

		}

		return points;
	}

}
