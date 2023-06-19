package com.solvd.lab.army.mybatis;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface IMapper <T>{
    public T getById(long id) throws SQLException, IOException, InterruptedException, ClassNotFoundException;
    public List<T> getAll() throws SQLException, IOException, InterruptedException, ClassNotFoundException;
    public void insert(T object) throws SQLException, IOException, InterruptedException, ClassNotFoundException;
    public void update(T object) throws SQLException, IOException, InterruptedException, ClassNotFoundException;
    public void delete(long id) throws SQLException, IOException, InterruptedException, ClassNotFoundException;
}

