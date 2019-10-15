package id.ac.politanisamarinda.panicbutton.Model;

import com.google.gson.annotations.SerializedName;

public class ResponseUser{

	@SerializedName("data")
	private User user;

	@SerializedName("success")
	private boolean success;

	@SerializedName("message")
	private String message;

	public void setUser(User user){
		this.user = user;
	}

	public User getUser(){
		return user;
	}

	public void setSuccess(boolean success){
		this.success = success;
	}

	public boolean isSuccess(){
		return success;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	@Override
 	public String toString(){
		return 
			"ResponseUser{" + 
			"user = '" + user + '\'' +
			",success = '" + success + '\'' + 
			",message = '" + message + '\'' + 
			"}";
		}
}