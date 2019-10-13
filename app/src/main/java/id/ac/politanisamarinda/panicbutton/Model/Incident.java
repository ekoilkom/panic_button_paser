package id.ac.politanisamarinda.panicbutton.Model;

import com.google.gson.annotations.SerializedName;

public class Incident {

	@SerializedName("nama")
	private String nama;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("foto")
	private String foto;

	@SerializedName("id")
	private int id;

	@SerializedName("deleted_at")
	private String deletedAt;

	public void setNama(String nama){
		this.nama = nama;
	}

	public String getNama(){
		return nama;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
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

	public void setDeletedAt(String deletedAt){
		this.deletedAt = deletedAt;
	}

	public String getDeletedAt(){
		return deletedAt;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	@Override
 	public String toString(){
		return 
			"Incident{" +
			"nama = '" + nama + '\'' + 
			",updated_at = '" + updatedAt + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",id = '" + id + '\'' + 
			",deleted_at = '" + deletedAt + '\'' + 
			"}";
		}
}