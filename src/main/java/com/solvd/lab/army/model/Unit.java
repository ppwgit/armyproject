package com.solvd.lab.army.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Unit{
        private Long id;

        @XmlElement(name = "name")
        private String name;

        @XmlElement(name = "unitType")
        private String unitType;

        @XmlElement(name = "soldierId")
        private Long soldierId;

        @XmlElement(name = "soldier")
        private Soldier soldier;

        public Unit() {

        }

    public Unit(long id, String name, String unitType, long soldierId) {
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
}
