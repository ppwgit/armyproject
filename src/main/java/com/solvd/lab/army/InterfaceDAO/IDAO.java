package com.solvd.lab.army.InterfaceDAO;

import java.util.List;

public interface IDAO<T> {
        public T getById(int id);
        public List<T> getAll();
        public void insert(T object);
        public void update(T object);
        public void delete(int id);
    }

