package com.solvd.lab.army.entity;

import java.util.List;

public class Unit{
        private Integer id;
        private String name;
        private String unitType;
        private Integer soldierId;
        private Soldier soldier;

        public Unit() {

        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
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

        public Integer getSoldierId() {
            return soldierId;
        }

        public void setSoldierId(Integer soldierId) {
            this.soldierId = soldierId;
        }
}
