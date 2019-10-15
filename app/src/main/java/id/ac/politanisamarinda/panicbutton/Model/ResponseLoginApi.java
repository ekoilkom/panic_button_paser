package id.ac.politanisamarinda.panicbutton.Model;

import com.google.gson.annotations.SerializedName;

public class ResponseLoginApi{

	@SerializedName("loginApi")
	private LoginApi loginApi;

	@SerializedName("success")
	private boolean success;

	@SerializedName("message")
	private String message;

	public void setLoginApi(LoginApi loginApi){
		this.loginApi = loginApi;
	}

	public LoginApi getLoginApi(){
		return loginApi;
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
			"ResponseLoginApi{" + 
			"loginApi = '" + loginApi + '\'' +
			",success = '" + success + '\'' + 
			",message = '" + message + '\'' + 
			"}";
		}
}