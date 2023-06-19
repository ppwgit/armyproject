package com.solvd.lab.army.mybatis;

import com.solvd.lab.army.model.City;
import com.solvd.lab.army.model.Soldier;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class CityRunner {
    private static final Logger logger = LogManager.getLogger(CityRunner.class);

    public static void main(String[] args) throws SQLException, IOException, InterruptedException, ClassNotFoundException, ParseException {

        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();

        //getAll
     List<City> cities = session.selectList("com.solvd.lab.army.mybatis.mappers.CityMapper.getAll");

        for(City city : cities ){
            System.out.println(city.getId());
            System.out.println(city.getName());
            System.out.println(city.getZipCode());
            System.out.println(city.getStateId());
        }

        System.out.println("Read All Successfully ");



        System.out.println("get By Id");
        //---------- Select byId
        City cityById = (City) session.selectOne("com.solvd.lab.army.mybatis.mappers.CityMapper.getById", 1);

        //Print the student details
        System.out.println(cityById.getId());
        System.out.println(cityById.getName());
        System.out.println(cityById.getStateId());
        System.out.println(cityById.getZipCode());

        //----------- update

        //select a particular student using id
        City cityupd = (City) session.selectOne("com.solvd.lab.army.mybatis.mappers.CityMapper.getById", 1);
        System.out.println(cityupd.toString());

        //Set new values to the mail and phone number of the student
        cityupd.setName("Choompon");
        cityupd.setStateId(1L);
        cityupd.setZipCode("5784255");

        //Update the student record
        session.update("com.solvd.lab.army.mybatis.mappers.CityMapper.update",cityupd);

        //verifying the record
        City sd = (City) session.selectOne("com.solvd.lab.army.mybatis.mappers.CityMapper.getById", 1);
        System.out.println(sd.toString());



        //----------------------------- end update

/*
        //----Insert

        //LocalDate dateOfBirth = LocalDate.parse("1998-10-03");
         City cityInsert = new City("Banna","25478", 1);
        session.insert("com.solvd.lab.army.mybatis.mappers.CityMapper.insert", cityInsert);



        //----Delete
        //Delete operation
        session.delete("com.solvd.lab.army.mybatis.mappers.CityMapper.delete", 2);

        session.commit();
        session.close(); */
    }

    }

