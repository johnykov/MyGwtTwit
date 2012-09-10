package pl.janek.lisda.shared;

import java.io.Serializable;

public class Twit implements Serializable{
	
	private static final long serialVersionUID = -6591042541665009677L;
	private String message;

	
	public Twit() {
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public Twit(String message) {
		super();
		this.message = message;
	}

}
