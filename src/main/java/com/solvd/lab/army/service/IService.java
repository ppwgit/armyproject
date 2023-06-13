package com.solvd.lab.army.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface IService<T> {
    public T getById(int id) throws SQLException, IOException, InterruptedException, ClassNotFoundException;
    public List<T> getAll() throws SQLException, IOException, InterruptedException, ClassNotFoundException;
    public void insert(T object) throws SQLException, IOException, InterruptedException, ClassNotFoundException;
    public void update(T object) throws SQLException, IOException, InterruptedException, ClassNotFoundException;
    public void delete(int id) throws SQLException, IOException, InterruptedException, ClassNotFoundException;
}
