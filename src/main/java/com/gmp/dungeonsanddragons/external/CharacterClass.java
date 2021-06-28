package com.gmp.dungeonsanddragons.external;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CharacterClass {

    private ApiReference characterClass;
    @JsonProperty("starting_equipment")
    private List<Equipment> starting_equipment;
    @JsonProperty("starting_equipment")
    private List<Spell> spells;

    public ApiReference getCharacterClass() {
        return characterClass;
    }

    public List<Equipment> getStartingEquipment() {
        return starting_equipment;
    }

}
