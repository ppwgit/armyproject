package com.solvd.lab.army.mybatis;

import com.solvd.lab.army.model.Operation;
import com.solvd.lab.army.model.Skill;
import com.solvd.lab.army.model.Soldier;
import com.solvd.lab.army.model.Unit;
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

public class SoldierRunner {
    private static final Logger logger = LogManager.getLogger(SoldierRunner.class);

    public static void main(String[] args) throws SQLException, IOException, InterruptedException, ClassNotFoundException, ParseException {

        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
/*
        //getAll
     List<Soldier> soldiers = session.selectList("com.solvd.lab.army.mybatis.mappers.SoldierMapper.getAll");

        for(Soldier st : soldiers ){
            System.out.println(st.getId());
            System.out.println(st.getFirstName());
            System.out.println(st.getLastName());
            System.out.println(st.getEmail());
        }

        System.out.println("Read All Successfully ");



        System.out.println("get By Id");
        //---------- Select byId
        Soldier soldierById = (Soldier) session.selectOne("com.solvd.lab.army.mybatis.mappers.SoldierMapper.getById", 1);

        //Print the student details
        System.out.println(soldierById.getId());
        System.out.println(soldierById.getFirstName());
        System.out.println(soldierById.getLastName());
        System.out.println(soldierById.getEmail());

        //----------- update

        //select a particular student using id
        Soldier soldierUp = (Soldier) session.selectOne("com.solvd.lab.army.mybatis.mappers.SoldierMapper.getById", 1);
        System.out.println(soldierUp.toString());

        //Set new values to the mail and phone number of the student
        soldierUp.setEmail("sayonaraupdate@yahoo.com");
        soldierUp.setContactNumber("90000000");

        //Update the student record
        session.update("com.solvd.lab.army.mybatis.mappers.SoldierMapper.update",soldierUp);

        //verifying the record
        Soldier sd = (Soldier) session.selectOne("com.solvd.lab.army.mybatis.mappers.SoldierMapper.getById", 1);
        System.out.println("Details of the Soldier after update operation" );
        System.out.println(sd.toString());



        //----------------------------- end update


        //----Insert

        //LocalDate dateOfBirth = LocalDate.parse("1998-10-03");
       SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date dateOfBirth = format.parse("1998-10-03");
        Soldier sdIn = new Soldier("Yannawa", "taan", dateOfBirth, "Female", "12385755564", "55754428788", "newguy@email.com", "new guy address", 1, 1, 1, "Active Duty", "Alive");
        session.insert("com.solvd.lab.army.mybatis.mappers.SoldierMapper.insert", sdIn);



        //----Delete
        //Delete operation
        session.delete("com.solvd.lab.army.mybatis.mappers.SoldierMapper.delete", 10);


        //----------------- Rank

        Soldier soldierRank = (Soldier) session.selectOne("com.solvd.lab.army.mybatis.mappers.SoldierMapper.findRankForSoldier",1);
        System.out.println(soldierRank.getRankName());


        //----------------- Base

        Soldier soldierBase = (Soldier) session.selectOne("com.solvd.lab.army.mybatis.mappers.SoldierMapper.findBaseForSoldier",1);
        System.out.println(soldierBase.getBaseName());



        //-----------------  select all
        List<Soldier> aliveSoldiers = session.selectList("com.solvd.lab.army.mybatis.mappers.SoldierMapper.findAllAliveSoldiers");

        for(Soldier st : aliveSoldiers ){
            System.out.println(st.getId());
            System.out.println(st.getFirstName());
            System.out.println(st.getLastName());
            System.out.println(st.getEmail());
        }




        // skills
        List<Soldier> soldiers = session.selectList("com.solvd.lab.army.mybatis.mappers.SoldierMapper.findSkillsBySoldierId",1);
        for(Soldier st : soldiers ){
            System.out.println(st.getId());
            List<Skill> skills = st.getSkills();
            for (Skill skill : skills) {
                System.out.println("- " + skill.getName());
            }

        }

        // Operations

        List<Soldier> soldiers = session.selectList("com.solvd.lab.army.mybatis.mappers.SoldierMapper.findOperationsBySoldierId",1);
        for(Soldier st : soldiers ){
            System.out.println(st.getId());
            List<Operation> operations = st.getOperations();
            for (Operation operation : operations) {
                System.out.println("- " + operation.getName());
                System.out.println("- " + operation.getStartDate());
                System.out.println("- " + operation.getEndDate());
                System.out.println("- " + operation.getLocation());
            }

        }
*/
        //----------------- Unit
        List<Soldier> soldiers = session.selectList("com.solvd.lab.army.mybatis.mappers.SoldierMapper.findUnitsBySoldierId",1);
        for(Soldier st : soldiers ){
            List<Unit> units = st.getUnits();
            for (Unit unit : units) {
                System.out.println("- " +  unit.getSoldierId() + "  " + unit.getId() + "  "+ unit.getName() + " " + unit.getUnitType());
            }

        }
        session.commit();
        session.close();
    }

    }

