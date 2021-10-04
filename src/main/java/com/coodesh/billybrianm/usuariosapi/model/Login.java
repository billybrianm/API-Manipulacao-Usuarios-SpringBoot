package com.coodesh.billybrianm.usuariosapi.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Login {
	
	@Column(name = "login_uuid")
	private String uuid;
	
	@Column(name = "login_username")
	private String username;
	
	@Column(name = "login_password")
	private String password;
	
	@Column(name = "login_salt")
	private String salt;
	
	@Column(name = "login_md5")
	private String md5;
	
	@Column(name = "login_sha1")
	private String sha1;
	
	@Column(name = "login_sha256")
	private String sha256;
	
	
	public Login () 
	{}


	public Login(String uuid, String username, String password, String salt, String md5, String sha1, String sha256) {
		super();
		this.uuid = uuid;
		this.username = username;
		this.password = password;
		this.salt = salt;
		this.md5 = md5;
		this.sha1 = sha1;
		this.sha256 = sha256;
	}


	public String getUuid() {
		return uuid;
	}


	public void setUuid(String uuid) {
		this.uuid = uuid;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getSalt() {
		return salt;
	}


	public void setSalt(String salt) {
		this.salt = salt;
	}


	public String getMd5() {
		return md5;
	}


	public void setMd5(String md5) {
		this.md5 = md5;
	}


	public String getSha1() {
		return sha1;
	}


	public void setSha1(String sha1) {
		this.sha1 = sha1;
	}


	public String getSha256() {
		return sha256;
	}


	public void setSha256(String sha256) {
		this.sha256 = sha256;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((md5 == null) ? 0 : md5.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((salt == null) ? 0 : salt.hashCode());
		result = prime * result + ((sha1 == null) ? 0 : sha1.hashCode());
		result = prime * result + ((sha256 == null) ? 0 : sha256.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		result = prime * result + ((uuid == null) ? 0 : uuid.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Login other = (Login) obj;
		if (md5 == null) {
			if (other.md5 != null)
				return false;
		} else if (!md5.equals(other.md5))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (salt == null) {
			if (other.salt != null)
				return false;
		} else if (!salt.equals(other.salt))
			return false;
		if (sha1 == null) {
			if (other.sha1 != null)
				return false;
		} else if (!sha1.equals(other.sha1))
			return false;
		if (sha256 == null) {
			if (other.sha256 != null)
				return false;
		} else if (!sha256.equals(other.sha256))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		if (uuid == null) {
			if (other.uuid != null)
				return false;
		} else if (!uuid.equals(other.uuid))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Login [uuid=" + uuid + ", username=" + username + ", password=" + password + ", salt=" + salt + ", md5="
				+ md5 + ", sha1=" + sha1 + ", sha256=" + sha256 + "]";
	}
	
	
	

}
