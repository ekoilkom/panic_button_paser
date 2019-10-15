package id.ac.politanisamarinda.panicbutton.Model;

import com.google.gson.annotations.SerializedName;

public class LoginApi {

	@SerializedName("expires")
	private int expires;

	@SerializedName("user")
	private User user;

	@SerializedName("token")
	private String token;

	public void setExpires(int expires){
		this.expires = expires;
	}

	public int getExpires(){
		return expires;
	}

	public void setUser(User user){
		this.user = user;
	}

	public User getUser(){
		return user;
	}

	public void setToken(String token){
		this.token = token;
	}

	public String getToken(){
		return token;
	}

	@Override
 	public String toString(){
		return 
			"LoginApi{" +
			"expires = '" + expires + '\'' + 
			",user = '" + user + '\'' + 
			",token = '" + token + '\'' + 
			"}";
		}
}