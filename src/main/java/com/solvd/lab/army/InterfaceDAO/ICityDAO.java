package com.solvd.lab.army.InterfaceDAO;

import com.solvd.lab.army.entity.City;

import java.util.List;

public interface ICityDAO {
    public void insert(City city);
    public void update(City city);
    public void delete(int cityId);
    public List<City> getAllCities();
    public City getCityById(int cityId);
}
