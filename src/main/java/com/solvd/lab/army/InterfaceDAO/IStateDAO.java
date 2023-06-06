package com.solvd.lab.army.InterfaceDAO;

import com.solvd.lab.army.entity.State;

import java.util.List;

public interface IStateDAO {
    public void insert(State state);
    public void update(State state);
    public void delete(int stateId);
    public List<State> getAllStates();
    public State getStateById(int stateId);
}
