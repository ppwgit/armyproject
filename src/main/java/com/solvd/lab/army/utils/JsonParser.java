package com.solvd.lab.army.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.lab.army.model.Soldier;
import com.solvd.lab.army.model.Operation;
import com.solvd.lab.army.model.Skill;
import com.solvd.lab.army.model.Unit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;


public class JsonParser {
    private static final Logger logger = LogManager.getLogger(JsonParser.class);

    ObjectMapper objectMapper = new ObjectMapper();
    String jsonfilepath = "C:/Users/ppw/solvdlab/army/src/main/java/resources/soldiers.json";

    File jsonFile = new File(jsonfilepath);
    Soldier soldiers;

    {
        try {
            soldiers = objectMapper.readValue(jsonFile,Soldier .class);
            for (Soldier soldier : soldiers.getSoldiers()) {
                soldier.getId();
                soldier.getFirstName();
                soldier.getLastName();
                soldier.getDateOfBirth();
                soldier.getGender();
                soldier.getContactNumber();
                soldier.getEmergencyNumber();
                soldier.getEmail();
                soldier.getAddress();

                for (Unit unit : soldier.getUnits()) {
                    unit.getName();
                }

                for (Skill skill : soldier.getSkills()) {
                    skill.getName();
                }

                for (Operation operation : soldier.getOperations()) {
                    operation.getName();
                }

                soldier.getRank().getName();
                soldier.getBase().getName();
                soldier.getRole().getName();

            }
        } catch (IOException e) {
            logger.error(e);
        }
    }
}