package id.ac.politanisamarinda.panicbutton.Model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResponseListUserIncident{

	@SerializedName("data")
	private List<UserIncident> listUserIncident;

	@SerializedName("success")
	private boolean success;

	@SerializedName("message")
	private String message;

	public void setListUserIncident(List<UserIncident> listUserIncident){
		this.listUserIncident = listUserIncident;
	}

	public List<UserIncident> getListUserIncident(){
		return listUserIncident;
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
			"ResponseListUserIncident{" + 
			"listUserIncident = '" + listUserIncident + '\'' +
			",success = '" + success + '\'' + 
			",message = '" + message + '\'' + 
			"}";
		}
}