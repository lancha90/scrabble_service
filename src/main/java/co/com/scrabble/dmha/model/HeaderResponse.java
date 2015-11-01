package co.com.scrabble.dmha.model;

/**
 * Header response model to tranform json
 * @author <a href="mailto:diego.herrera@ingeneo.com.co">Diego Mauricio Herrera Alzate</a>
 *
 */
public class HeaderResponse {

	private int code;
	private String message;
	
	public HeaderResponse(int code, String message) {
		super();
		this.code = code;
		this.message = message;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
