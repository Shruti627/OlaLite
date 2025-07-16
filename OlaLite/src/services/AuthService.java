package services;


import exceptions.InvalidLoginException;
import models.User;

import java.util.HashMap;
import java.util.Map;

public class AuthService {

	HashMap<String,User > users = new HashMap<String, User>();
	public void signUp(String name,String email,String mobile,String password) {
		if (users.containsKey(email)) {
			System.out.println("❌ User already exists. Try logging in.");
		}else {
			User user=new User(name, mobile, email, password);  //(HAS A RELATION)
			users.put(email, user);
			System.out.println("✅ Signup successful!!!");
			
		}
		
	}
	 public User login(String email, String password) throws InvalidLoginException {
	        User user = users.get(email);
	        if (user != null && user.getPassword().equals(password)) {
	            user.setLoggedIn(true);
	            System.out.println("✅ Login successful! Welcome " + user.getName());
	            return user;
	        } else {
	            throw new InvalidLoginException("Invalid email or password.");
	        }
	    }
	    public void logout(User user) {
	        if (user != null) {
	            user.setLoggedIn(false);
//	            System.out.println("🚪 Logged out successfully.");
	        }
	    }
	    public boolean isLoggedIn(User user) {
	        return user != null && user.isLoggedIn();
	    }

}
