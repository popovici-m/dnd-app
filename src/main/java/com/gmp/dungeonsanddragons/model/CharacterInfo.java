package com.gmp.dungeonsanddragons.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;


@Entity
public class CharacterInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String level;
	private String clas;
	private String race;
	@ElementCollection
    private List<String> equipment = new ArrayList<String>();
	@ElementCollection
	private List<String> spells = new ArrayList<String>();
	@ManyToOne(optional = false, cascade = {CascadeType.ALL})
    private User user;
	
	public CharacterInfo() {
	}
	
	public CharacterInfo(@NotNull(message = "Character name is required.") String name, String level, String clas, String race, List<String> equipment, List<String> spells) {
		this.name = name;
		this.level = level;
		this.clas = clas;
		this.race = race;
		this.equipment = equipment;
		this.spells = spells;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getRace() {
		return race;
	}
	public void setRace(String race) {
		this.race = race;
	}
	public String getClas() {
		return clas;
	}
	public void setClas(String clas) {
		this.clas = clas;
	}
	public List<String> getEquipment() {
		return equipment;
	}
	public void setEquipment(List<String> equipment) {
		this.equipment = equipment;
	}
	public List<String> getSpells() {
		return spells;
	}
	public void setSpells(List<String> spells) {
		this.spells = spells;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	
	@Override
	public String toString() {
		return String.format("Character[id=%s name=%s age=%s class=%s race=%s equipment=[%s] spells=[%s]]", id, name, level, clas, race, equipment, spells);
	}
}
