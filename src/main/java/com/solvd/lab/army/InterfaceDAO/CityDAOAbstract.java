package com.solvd.lab.army.InterfaceDAO;

import com.solvd.lab.army.entity.Base;
import com.solvd.lab.army.entity.City;

import java.util.List;

public abstract class CityDAOAbstract {

    public abstract void insert(City city);
    public abstract void update(City city);
    public abstract void delete(int cityId);
    public abstract List<City> getAllCity();
    public abstract City getCityById(int cityId);
}
