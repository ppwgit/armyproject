package com.solvd.lab.army.service.impl;


import com.solvd.lab.army.dao.ICountryDAO;
import com.solvd.lab.army.dao.IStateDAO;
import com.solvd.lab.army.dao.impl.CountryDAOImpl;
import com.solvd.lab.army.dao.impl.StateDAOImpl;
import com.solvd.lab.army.model.Country;
import com.solvd.lab.army.model.State;
import com.solvd.lab.army.service.IService;

import java.sql.SQLException;
import java.util.List;

public class StateServiceImpl implements IService<State> {
    private IStateDAO stateDAO = new StateDAOImpl();
    private ICountryDAO countryDAO = new CountryDAOImpl();


    @Override
    public State getById(int id)  throws SQLException  {
        State state = stateDAO.getById(id);
        state.setCountry(countryDAO.getById(id));
        return state;
    }

    @Override
    public List<State> getAll() throws SQLException{
        return stateDAO.getAll();
    }

    @Override
    public void insert(State state) throws SQLException{
        stateDAO.insert(state);
    }

    @Override
    public void update(State state) throws SQLException{
        stateDAO.update(state);

    }

    @Override
    public void delete(int id) throws SQLException{
        stateDAO.delete(id);
    }
}