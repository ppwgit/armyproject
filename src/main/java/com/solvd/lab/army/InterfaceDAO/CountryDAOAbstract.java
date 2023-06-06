package com.solvd.lab.army.InterfaceDAO;

import com.solvd.lab.army.entity.Country;

import java.util.List;

public abstract class CountryDAOAbstract {
    public abstract void insert(Country country);
    public abstract void update(Country country);
    public abstract void delete(int countryId);
    public abstract List<Country> getAllCountries();
    public abstract Country getCountryById(int countryId);
}
