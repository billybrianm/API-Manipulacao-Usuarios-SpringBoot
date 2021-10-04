package com.coodesh.billybrianm.usuariosapi.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Name {
	
	@Column(name = "name_title")
	private String title;
	
	@Column(name = "name_first")
	private String first;
	
	@Column(name = "name_last")
	private String last;
	
	public Name () {
		
	}

	public Name(String title, String first, String last) {
		super();
		this.title = title;
		this.first = first;
		this.last = last;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((first == null) ? 0 : first.hashCode());
		result = prime * result + ((last == null) ? 0 : last.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Name other = (Name) obj;
		if (first == null) {
			if (other.first != null)
				return false;
		} else if (!first.equals(other.first))
			return false;
		if (last == null) {
			if (other.last != null)
				return false;
		} else if (!last.equals(other.last))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Name [title=" + title + ", first=" + first + ", last=" + last + "]";
	}
	
	
	

}
