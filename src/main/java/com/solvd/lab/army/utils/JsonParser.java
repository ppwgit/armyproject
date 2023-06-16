package com.solvd.lab.army.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.lab.army.dao.impl.SoldierDAOImpl;
import com.solvd.lab.army.modelJson.OperationJson;
import com.solvd.lab.army.modelJson.SkillJson;
import com.solvd.lab.army.modelJson.SoldierJson;
import com.solvd.lab.army.modelJson.UnitJson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonParser {
    private static final Logger logger = LogManager.getLogger(JsonParser.class);

    ObjectMapper objectMapper = new ObjectMapper();
    String jsonfilepath = "C:/Users/ppw/solvdlab/army/src/main/java/com/solvd/lab/army/xml/soldiers.xml";

    File jsonFile = new File(jsonfilepath);
    SoldierJson soldiers;

    {
        try {
            soldiers = objectMapper.readValue(jsonFile,SoldierJson .class);
            for (SoldierJson soldier : soldiers.getSoldiers()) {
                soldier.getId();
                soldier.getFirstName();
                soldier.getLastName();
                soldier.getDateOfBirth();
                soldier.getGender();
                soldier.getContactNumber();
                soldier.getEmergencyNumber();
                soldier.getEmail();
                soldier.getAddress();

                for (UnitJson unit : soldier.getUnits()) {
                    unit.getName();
                }

                for (SkillJson skill : soldier.getSkills()) {
                    skill.getName();
                }

                for (OperationJson operation : soldier.getOperations()) {
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