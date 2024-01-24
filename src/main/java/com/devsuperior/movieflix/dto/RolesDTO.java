package com.devsuperior.movieflix.dto;


import java.io.Serializable;

public class RolesDTO implements Serializable {

	private String profile;

	public RolesDTO() {
	}

	public RolesDTO(String profile) {
		this.profile = profile;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}
}
