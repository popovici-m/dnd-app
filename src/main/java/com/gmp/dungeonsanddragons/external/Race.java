package com.gmp.dungeonsanddragons.external;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Race {
	private ApiReference race;
    
	public Race() {
	}
	public Race(ApiReference race) {
		this.race = race;
	}
	public ApiReference getRace() {
		return race;
	}
    
}
