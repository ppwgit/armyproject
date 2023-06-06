package com.solvd.lab.army.test;


import com.solvd.lab.army.daoImpl.DAOClass;

public class TestDAOClass {
    public static void main(String[] args) {
        DAOClass dao = new DAOClass();

        System.out.println("Fetching data from the database...");
        dao.fetchData();


    }
}