package com.solvd.lab.army.service;

import java.sql.SQLException;
import java.util.List;

public interface IService<T> {
    public T getById(int id) throws SQLException;
    public List<T> getAll() throws SQLException;
    public void insert(T object) throws SQLException;
    public void update(T object) throws SQLException;
    public void delete(int id) throws SQLException;
}
