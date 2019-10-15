package id.ac.politanisamarinda.panicbutton.Model;

import com.google.gson.annotations.SerializedName;

public class UserIncident {

	@SerializedName("incident_id")
	private int incidentId;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("latitude")
	private int latitude;

	@SerializedName("user_data_id")
	private int userDataId;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("id")
	private int id;

	@SerializedName("longitude")
	private int longitude;

	public void setIncidentId(int incidentId){
		this.incidentId = incidentId;
	}

	public int getIncidentId(){
		return incidentId;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setLatitude(int latitude){
		this.latitude = latitude;
	}

	public int getLatitude(){
		return latitude;
	}

	public void setUserDataId(int userDataId){
		this.userDataId = userDataId;
	}

	public int getUserDataId(){
		return userDataId;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setLongitude(int longitude){
		this.longitude = longitude;
	}

	public int getLongitude(){
		return longitude;
	}

	@Override
 	public String toString(){
		return 
			"UserIncident{" +
			"incident_id = '" + incidentId + '\'' + 
			",updated_at = '" + updatedAt + '\'' + 
			",latitude = '" + latitude + '\'' + 
			",user_data_id = '" + userDataId + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",id = '" + id + '\'' + 
			",longitude = '" + longitude + '\'' + 
			"}";
		}
}