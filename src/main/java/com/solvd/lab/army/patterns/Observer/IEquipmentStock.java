package com.solvd.lab.army.patterns.Observer;

public interface IEquipmentStock {
    public void register(Observer observer);
    public void unregister(Observer observer);
    public void notifyObservers(long quantity);
}
