package id.ac.politanisamarinda.panicbutton.Model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResponseIncidents{

	@SerializedName("data")
	private List<Incident> data;

	@SerializedName("success")
	private boolean success;

	@SerializedName("message")
	private String message;

	public void setData(List<Incident> data){
		this.data = data;
	}

	public List<Incident> getData(){
		return data;
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
			"ResponseIncidents{" + 
			"data = '" + data + '\'' + 
			",success = '" + success + '\'' + 
			",message = '" + message + '\'' + 
			"}";
		}
}