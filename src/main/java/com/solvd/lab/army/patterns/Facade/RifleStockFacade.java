package com.solvd.lab.army.patterns.Facade;

public class RifleStockFacade {
    private RifleStock rifleStock;

    public RifleStockFacade(String rifleNumber, Long initialAmount) {
        this.rifleStock = new RifleStock(rifleNumber, initialAmount);
    }

    public boolean checkAvailability(Long amount) {
        return rifleStock.checkAvailability(amount);
    }

    public void processRequisition(Long amount) {
        if (checkAvailability(amount)) {
            rifleStock.decreaseStock(amount);
            System.out.println("Rifle requisition processed success.");
        } else {
            System.out.println("Insufficient rifle stock for the requisition.");
        }
    }

    public void processReturn(Long amount) {
        rifleStock.restoreStock(amount);
        System.out.println("Rifle return processed success.");
    }
}
