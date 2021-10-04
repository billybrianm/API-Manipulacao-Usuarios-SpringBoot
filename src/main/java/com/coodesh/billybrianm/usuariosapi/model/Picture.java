package com.coodesh.billybrianm.usuariosapi.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Picture {
	
	@Column(name = "picture_large")
	private String large;
	
	@Column(name = "picture_medium")
	private String medium;
	
	@Column(name = "picture_thumbnail")
	private String thumbnail;
	
	private Picture() {}

	public Picture(String large, String medium, String thumbnail) {
		super();
		this.large = large;
		this.medium = medium;
		this.thumbnail = thumbnail;
	}

	public String getLarge() {
		return large;
	}

	public void setLarge(String large) {
		this.large = large;
	}

	public String getMedium() {
		return medium;
	}

	public void setMedium(String medium) {
		this.medium = medium;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((large == null) ? 0 : large.hashCode());
		result = prime * result + ((medium == null) ? 0 : medium.hashCode());
		result = prime * result + ((thumbnail == null) ? 0 : thumbnail.hashCode());
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
		Picture other = (Picture) obj;
		if (large == null) {
			if (other.large != null)
				return false;
		} else if (!large.equals(other.large))
			return false;
		if (medium == null) {
			if (other.medium != null)
				return false;
		} else if (!medium.equals(other.medium))
			return false;
		if (thumbnail == null) {
			if (other.thumbnail != null)
				return false;
		} else if (!thumbnail.equals(other.thumbnail))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Picture [large=" + large + ", medium=" + medium + ", thumbnail=" + thumbnail + "]";
	}
	
	

}
