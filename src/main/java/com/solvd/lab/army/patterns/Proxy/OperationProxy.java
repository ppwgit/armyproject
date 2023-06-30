package com.solvd.lab.army.patterns.Proxy;

import com.solvd.lab.army.model.Operation;
import com.solvd.lab.army.model.Soldier;

import java.util.Date;

public class OperationProxy  implements  IOperationData{

    private Soldier soldier;

    public OperationProxy(Soldier soldier) {
        this.soldier = soldier;
    }

    @Override
    public Operation getOperationData() {
        if (soldier.getRankId() == 1) {
            return new Operation(1L, "Secret Operation No.154", new Date(), new Date(), "Operation in China",1L);
        } else {
            throw new UnauthorizedAccessException("You are not authorized to access the operation data.");
        }
    }
}