package com.gmp.dungeonsanddragons.external;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Equipment {

    private ApiReference equipment;
    private Integer quantity;
    @JsonProperty("equipment_category")
    private ApiReference equipment_category;

    public Equipment() {
    }

    public Equipment(ApiReference equipment, Integer quantity) {
        this.equipment = equipment;
        this.quantity = quantity;
    }

    public ApiReference getEquipment() {
        return equipment;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public ApiReference getEquipmentCategory() {
        return equipment_category;
    }
}
