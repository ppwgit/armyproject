package com.solvd.lab.army.InterfaceDAO;

import com.solvd.lab.army.entity.City;
import com.solvd.lab.army.entity.Location;

import java.util.List;

public abstract class LocationDAOAbstract {
    public abstract void insert(Location location);
    public abstract void update(Location location);
    public abstract void delete(int locationId);
    public abstract List<Location> getAllLocations();
    public abstract Location getLocationById(int locationId);
}
