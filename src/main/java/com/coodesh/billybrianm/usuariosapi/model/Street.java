package com.coodesh.billybrianm.usuariosapi.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Street {

	@Column(name = "street_number")
	private Integer number;
	
	@Column(name = "street_name")
	private String name;
	
	public Street() {
		
	}

	public Street(Integer number, String name) {
		super();
		this.number = number;
		this.name = name;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
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
		Street other = (Street) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Street [number=" + number + ", name=" + name + "]";
	}
	
	
}
