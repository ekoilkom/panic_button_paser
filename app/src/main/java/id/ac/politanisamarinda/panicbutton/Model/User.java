package id.ac.politanisamarinda.panicbutton.Model;

import com.google.gson.annotations.SerializedName;

public class User{

	@SerializedName("no_hp")
	private Object noHp;

	@SerializedName("pekerjaan")
	private Object pekerjaan;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("no_ktp")
	private Object noKtp;

	@SerializedName("name")
	private String name;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("email_verified_at")
	private Object emailVerifiedAt;

	@SerializedName("id")
	private int id;

	@SerializedName("deleted_at")
	private Object deletedAt;

	@SerializedName("email")
	private String email;

	@SerializedName("alamat")
	private Object alamat;

	public void setNoHp(Object noHp){
		this.noHp = noHp;
	}

	public Object getNoHp(){
		return noHp;
	}

	public void setPekerjaan(Object pekerjaan){
		this.pekerjaan = pekerjaan;
	}

	public Object getPekerjaan(){
		return pekerjaan;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setNoKtp(Object noKtp){
		this.noKtp = noKtp;
	}

	public Object getNoKtp(){
		return noKtp;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setEmailVerifiedAt(Object emailVerifiedAt){
		this.emailVerifiedAt = emailVerifiedAt;
	}

	public Object getEmailVerifiedAt(){
		return emailVerifiedAt;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setDeletedAt(Object deletedAt){
		this.deletedAt = deletedAt;
	}

	public Object getDeletedAt(){
		return deletedAt;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	public void setAlamat(Object alamat){
		this.alamat = alamat;
	}

	public Object getAlamat(){
		return alamat;
	}

	@Override
 	public String toString(){
		return 
			"User{" + 
			"no_hp = '" + noHp + '\'' + 
			",pekerjaan = '" + pekerjaan + '\'' + 
			",updated_at = '" + updatedAt + '\'' + 
			",no_ktp = '" + noKtp + '\'' + 
			",name = '" + name + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",email_verified_at = '" + emailVerifiedAt + '\'' + 
			",id = '" + id + '\'' + 
			",deleted_at = '" + deletedAt + '\'' + 
			",email = '" + email + '\'' + 
			",alamat = '" + alamat + '\'' + 
			"}";
		}
}