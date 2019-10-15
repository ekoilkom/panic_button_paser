package id.ac.politanisamarinda.panicbutton.Model;

import com.google.gson.annotations.SerializedName;

public class UserIncident{

	@SerializedName("incident_id")
	private int incidentId;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("foto")
	private String foto;

	@SerializedName("user_info")
	private String userInfo;

	@SerializedName("latitude")
	private double latitude;

	@SerializedName("user_data_id")
	private int userDataId;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("id")
	private int id;

	@SerializedName("user_data")
	private User userData;

	@SerializedName("deleted_at")
	private String deletedAt;

	@SerializedName("incident")
	private Incident incident;

	@SerializedName("longitude")
	private double longitude;

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

	public void setFoto(String foto){
		this.foto = foto;
	}

	public String getFoto(){
		return foto;
	}

	public void setUserInfo(String userInfo){
		this.userInfo = userInfo;
	}

	public String getUserInfo(){
		return userInfo;
	}

	public void setLatitude(double latitude){
		this.latitude = latitude;
	}

	public double getLatitude(){
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

	public void setUserData(User userData){
		this.userData = userData;
	}

	public User getUserData(){
		return userData;
	}

	public void setDeletedAt(String deletedAt){
		this.deletedAt = deletedAt;
	}

	public String getDeletedAt(){
		return deletedAt;
	}

	public void setIncident(Incident incident){
		this.incident = incident;
	}

	public Incident getIncident(){
		return incident;
	}

	public void setLongitude(double longitude){
		this.longitude = longitude;
	}

	public double getLongitude(){
		return longitude;
	}

	@Override
	public String toString(){
		return
				"DataItem{" +
						"incident_id = '" + incidentId + '\'' +
						",updated_at = '" + updatedAt + '\'' +
						",foto = '" + foto + '\'' +
						",user_info = '" + userInfo + '\'' +
						",latitude = '" + latitude + '\'' +
						",user_data_id = '" + userDataId + '\'' +
						",created_at = '" + createdAt + '\'' +
						",id = '" + id + '\'' +
						",user_data = '" + userData + '\'' +
						",deleted_at = '" + deletedAt + '\'' +
						",incident = '" + incident + '\'' +
						",longitude = '" + longitude + '\'' +
						"}";
	}
}