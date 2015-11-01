package co.com.scrabble.dmha.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	
	public static void main(String[] args) {
		
		
		String s = "**H* *E";
		
		
		System.out.println("Espacio: "+(s.contains(" "))+"<");
		
//		Pattern p = Pattern.compile("\\w+");
		Pattern p = Pattern.compile("[A-Z]");
		
		Matcher m = p.matcher(s);
		
		if(m.find()){
			do{
				System.out.println(m.group());
			}
			while(m.find());
		}
		
		/*if(m.find()){
			System.out.println(m.group());
			System.out.println(m.matches());
		}else{
			System.out.println("NO");
		}*/
		
	}
}
