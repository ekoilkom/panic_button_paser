package id.ac.politanisamarinda.panicbutton.Model;

import com.google.gson.annotations.SerializedName;

public class ResponseUserIncident{

	@SerializedName("data")
	private UserIncident userIncident;

	@SerializedName("success")
	private boolean success;

	@SerializedName("message")
	private String message;

	public void setUserIncident(UserIncident userIncident){
		this.userIncident = userIncident;
	}

	public UserIncident getUserIncident(){
		return userIncident;
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
			"ResponseUserIncident{" + 
			"userIncident = '" + userIncident + '\'' +
			",success = '" + success + '\'' + 
			",message = '" + message + '\'' + 
			"}";
		}
}