package com.solvd.lab.army.modelJson;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.solvd.lab.army.model.Soldier;

import java.util.List;

public class UnitJson {
        @JsonProperty("id")
        private Long id;

        @JsonProperty("name")
        private String name;

        @JsonProperty("unitType")
        private String unitType;

        @JsonProperty("soldierId")
        private Long soldierId;

        @JsonProperty("units")
        private List<UnitJson> units;

        public UnitJson() {

        }

    public UnitJson(long id, String name, String unitType, long soldierId) {
    this.id = id;
    this.name = name;
    this.unitType = unitType;
    this.soldierId = soldierId;
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

        public String getUnitType() {
            return unitType;
        }

        public void setUnitType(String unitType) {
            this.unitType = unitType;
        }

        public Long getSoldierId() {
            return soldierId;
        }

        public void setSoldierId(Long soldierId) {
            this.soldierId = soldierId;
        }

       public List<UnitJson> getUnit() {
        return units;
       }

       public void setUnit(List<UnitJson> units) {
        this.units = units;
      }
        public String toString() {
        return "UnitJson{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", unitType='" + unitType + '\'' +
                ", soldierId=" + soldierId + '\'' +
                ", units=" + units + '\'' +
                '}';
    }

}
