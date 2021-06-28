package com.gmp.dungeonsanddragons.external;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Spell {
	private ApiReference spell;
	
	public ApiReference getSpell() {
		return spell;
	}
}
