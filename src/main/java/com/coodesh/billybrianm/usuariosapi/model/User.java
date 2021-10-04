package com.coodesh.billybrianm.usuariosapi.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.coodesh.billybrianm.usuariosapi.enums.StatusEnum;


@Entity
@Table(name = "users")
public class User {
	
	@Id
    @GeneratedValue
	private Long userid;
	
	@Column(name = "gender")
	private String gender;
	
	@Embedded
	private Name name;
	
	@Embedded
	private Location location;
	
	@Column(name = "email")
	private String email;

	@Embedded
	private Login login;
	
	@Embedded
	private DateOfBirth dob;

	@Embedded
	private Registered registered;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name ="cell")
	private String cell;
	
	@Embedded
	private Identifier id;
	
	@Embedded
	private Picture picture;
	
	@Column(name = "nat")
	private String nat;
	
	@Column(name= "imported_t")
	private Date imported_t;
	
	@Column(name="status")
	private StatusEnum status;
	
	public User () { }

	public User(Long userid, String gender, Name name, Location location, String email, Login login, DateOfBirth dob,
			Registered registered, String phone, String cell, Identifier id, Picture picture, String nat,
			Date imported_t, StatusEnum status) {
		super();
		this.userid = userid;
		this.gender = gender;
		this.name = name;
		this.location = location;
		this.email = email;
		this.login = login;
		this.dob = dob;
		this.registered = registered;
		this.phone = phone;
		this.cell = cell;
		this.id = id;
		this.picture = picture;
		this.nat = nat;
		this.imported_t = imported_t;
		this.status = status;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public DateOfBirth getDob() {
		return dob;
	}

	public void setDob(DateOfBirth dob) {
		this.dob = dob;
	}

	public Registered getRegistered() {
		return registered;
	}

	public void setRegistered(Registered registered) {
		this.registered = registered;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCell() {
		return cell;
	}

	public void setCell(String cell) {
		this.cell = cell;
	}

	public Identifier getId() {
		return id;
	}

	public void setId(Identifier id) {
		this.id = id;
	}

	public Picture getPicture() {
		return picture;
	}

	public void setPicture(Picture picture) {
		this.picture = picture;
	}

	public String getNat() {
		return nat;
	}

	public void setNat(String nat) {
		this.nat = nat;
	}

	public Date getImported_t() {
		return imported_t;
	}

	public void setImported_t(Date imported_t) {
		this.imported_t = imported_t;
	}

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cell == null) ? 0 : cell.hashCode());
		result = prime * result + ((dob == null) ? 0 : dob.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((imported_t == null) ? 0 : imported_t.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((nat == null) ? 0 : nat.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((picture == null) ? 0 : picture.hashCode());
		result = prime * result + ((registered == null) ? 0 : registered.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((userid == null) ? 0 : userid.hashCode());
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
		User other = (User) obj;
		if (cell == null) {
			if (other.cell != null)
				return false;
		} else if (!cell.equals(other.cell))
			return false;
		if (dob == null) {
			if (other.dob != null)
				return false;
		} else if (!dob.equals(other.dob))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (imported_t == null) {
			if (other.imported_t != null)
				return false;
		} else if (!imported_t.equals(other.imported_t))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (nat == null) {
			if (other.nat != null)
				return false;
		} else if (!nat.equals(other.nat))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (picture == null) {
			if (other.picture != null)
				return false;
		} else if (!picture.equals(other.picture))
			return false;
		if (registered == null) {
			if (other.registered != null)
				return false;
		} else if (!registered.equals(other.registered))
			return false;
		if (status != other.status)
			return false;
		if (userid == null) {
			if (other.userid != null)
				return false;
		} else if (!userid.equals(other.userid))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [userid=" + userid + ", gender=" + gender + ", name=" + name + ", location=" + location
				+ ", email=" + email + ", login=" + login + ", dob=" + dob + ", registered=" + registered + ", phone="
				+ phone + ", cell=" + cell + ", id=" + id + ", picture=" + picture + ", nat=" + nat + ", imported_t="
				+ imported_t + ", status=" + status + "]";
	}

	
	
	
	
	

}