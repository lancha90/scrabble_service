package co.com.scrabble.dmha.service;

import static spark.Spark.get;
import spark.Request;
import spark.Response;
import spark.Route;
import co.com.scrabble.dmha.business.CommonConstants;
import co.com.scrabble.dmha.business.ScrabbleGenerator;
import co.com.scrabble.dmha.model.HeaderResponse;

import com.google.gson.Gson;

public class RunService {
	
	/**
	 * GSon object for JSON format trasnformations
	 */
	private static final Gson gson = new Gson();
	
	/**
	 * Business methods
	 */
	private static final ScrabbleGenerator business = new ScrabbleGenerator();
	
	

	
	public static void main(String[] args) {
		
		/**
		 * Root url to check status of service
		 */
		get(new Route("/") {
			@Override
			public Object handle(Request req, Response res) {
				HeaderResponse toReturn = new HeaderResponse(CommonConstants.HTTP_OK, "Service is running...");
				return gson.toJson(toReturn);
			}
		});
		
		
		/**
		 * service to return words to play scrabble
		 */
		get(new Route("/rest/scrabble") {
			@Override
			public Object handle(Request req, Response res) {
				Object toReturn;
				String params = req.queryParams("list");
				
				// Validate if @list param exist
				if(params == null){
					res.status(CommonConstants.HTTP_BAD_REQUEST);
					toReturn = new HeaderResponse(CommonConstants.HTTP_BAD_REQUEST, "Malformed request syntax, e.g. /rest/scrabble?list=r,u,g,b,y");
				}else{
					toReturn = business.getWordsDictionary(params);
				}
				
				return gson.toJson(toReturn);
			}
		});
		
		
		
		
	}

}
