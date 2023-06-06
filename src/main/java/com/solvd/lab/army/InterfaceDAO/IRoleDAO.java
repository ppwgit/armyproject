package com.solvd.lab.army.InterfaceDAO;

import com.solvd.lab.army.entity.Role;

import java.util.List;

public interface IRoleDAO {
    public void insert(Role role);
    public void update(Role role);
    public void delete(int roleId);
    public List<Role> getAllRoles();
    public Role getRoleById(int roleId);
}
