package com.solvd.lab.army.patterns.Observer;

import java.util.ArrayList;
import java.util.List;

public class EquipmentStock implements  IEquipmentStock{
    private List<Observer> observers;
    private Long rifleAmount;
    private Long submachineGunAmount;
    private Long machineGunAmount;

    public EquipmentStock() {
        this.observers = new ArrayList<>();
        this.rifleAmount = 0L;
        this.submachineGunAmount = 0L;
        this.machineGunAmount = 0L;
    }

    @Override
    public void register(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unregister(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(long quantity) {
        for (Observer observer : observers) {
            observer.update(rifleAmount, submachineGunAmount, machineGunAmount);
        }
    }

    public void setRifleAmount(Long amount) {
        rifleAmount = amount;
        notifyObservers(rifleAmount);
    }

    public void setSubmachineGunAmount(Long amount) {
        submachineGunAmount = amount;
        notifyObservers(submachineGunAmount);
    }

    public void setMachineGunAmount(Long amount) {
        machineGunAmount = amount;
        notifyObservers(machineGunAmount);
    }

    public Long getRifleAmount() {
        return rifleAmount;
    }

    public Long getSubmachineGunAmount() {
        return submachineGunAmount;
    }

    public Long getMachineGunAmount() {
        return machineGunAmount;
    }
}
