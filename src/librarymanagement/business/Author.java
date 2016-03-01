package librarymanagement.business;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Author extends Person implements Serializable{

	private String credentials;
	private String shortBio;
	
	public String getCredentials() {
		return credentials;
	}
	public void setCredentials(String credentials) {
		this.credentials = credentials;
	}
	public String getShortBio() {
		return shortBio;
	}
	public void setShortBio(String shortBio) {
		this.shortBio = shortBio;
	}
	
}
