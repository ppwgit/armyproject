package com.solvd.lab.army.InterfaceDAO;

import com.solvd.lab.army.entity.Country;

import java.util.List;

public interface ICountryDAO {
    public void insert(Country country);
    public void update(Country country);
    public void delete(int countryId);
    public List<Country> getAllCountries();
    public Country getCountryById(int countryId);
}
