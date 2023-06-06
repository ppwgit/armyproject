package com.solvd.lab.army.model;

public class Unit{
        private Long id;
        private String name;
        private String unitType;
        private Long soldierId;
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
