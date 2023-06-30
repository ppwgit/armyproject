package com.solvd.lab.army.patterns.Facade;

public class RifleStock {
    private Long availableAmount;
    private String rifleNumber;

    public RifleStock(String rifleNumber, Long initialAmount) {
        this.rifleNumber = rifleNumber;
        this.availableAmount = initialAmount;
    }

    public boolean checkAvailability(Long amount) {
        return availableAmount >= amount;
    }

    public void decreaseStock(Long amount) {
        availableAmount -= amount;
        System.out.println("Rifles - Decreased stock by " + amount + ". Current stock: " + availableAmount);
    }

    public void restoreStock(Long amount) {
        availableAmount += amount;
        System.out.println("Rifles - Restored stock by " + amount + ". Current stock: " + availableAmount);
    }

    public String getRifleNumber() {
        return rifleNumber;
    }
}
