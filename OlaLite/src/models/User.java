package models;

import java.util.ArrayList;
import java.util.List;

public class User {

	private String name;
	private String mobile_number;
	private String email;
	private String password;
	private boolean loggedIn = false;

	public User(String name, String mobile_number, String email, String password) {
		this.name = name;
		this.mobile_number = mobile_number;
		this.email = email;
		this.password = password;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile_number() {
		return mobile_number;
	}

	public void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	private List<String> favoriteLocations = new ArrayList<>();

	public List<String> getFavoriteLocations() {
	    return favoriteLocations;
	}

	public void addFavoriteLocation(String location) {
	    if (!favoriteLocations.contains(location)) {
	        favoriteLocations.add(location);
	    }
	}


}
