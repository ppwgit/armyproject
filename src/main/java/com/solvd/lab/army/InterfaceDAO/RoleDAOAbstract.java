package com.solvd.lab.army.InterfaceDAO;

import com.solvd.lab.army.entity.City;
import com.solvd.lab.army.entity.Role;

import java.util.List;

public abstract class RoleDAOAbstract {
    public abstract void insert(Role role);
    public abstract void update(Role role);
    public abstract void delete(int roleId);
    public abstract List<Role> getAllRoles();
    public abstract Role getRoleById(int roleId);
}
