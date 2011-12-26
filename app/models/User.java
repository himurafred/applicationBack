package models;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable{
	
	private String id;
	
	private Date lastConnexion;
	
	public User(String id, Date lastConnexion){
		this.id = id;
		this.lastConnexion = lastConnexion;
	
	}

	public void setId(String id) {
		this.id = id;
	}
		
	public String getId() {
		return id;
	}
	
	public void setLastConnexion(Date lastConnexion) {
		this.lastConnexion = lastConnexion;
	}
	
	public Date getLastConnexion() {
		return lastConnexion;
	}
	
	@Override
	public String toString(){
		return ("id : " + id + " lastConnexion : " + lastConnexion);
	}
}
