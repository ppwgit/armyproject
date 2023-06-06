package com.solvd.lab.army.InterfaceDAO;

import com.solvd.lab.army.entity.Location;

import java.util.List;

public interface ILocationDAO {
    public void insert(Location location);
    public void update(Location location);
    public void delete(int locationId);
    public List<Location> getAllLocations();
    public Location getLocationById(int locationId);
}
