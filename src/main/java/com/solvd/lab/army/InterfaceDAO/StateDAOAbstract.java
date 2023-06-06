package com.solvd.lab.army.InterfaceDAO;

import com.solvd.lab.army.entity.Base;
import com.solvd.lab.army.entity.State;

import java.util.List;

public abstract class StateDAOAbstract {
    public abstract void insert(State state);
    public abstract void update(State state);
    public abstract void delete(int stateId);
    public abstract List<State> getAllStates();
    public abstract State getStateById(int stateId);
}
