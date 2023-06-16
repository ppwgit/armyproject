package com.solvd.lab.army.utils;

import com.solvd.lab.army.model.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JAXBParser {
    private static final Logger logger = LogManager.getLogger(JAXBParser.class);

    public static void main(String[] args) {
            try {
                String xmlpath = "C:/Users/ppw/solvdlab/army/src/main/java/com/solvd/lab/army/xml/soldiers.xml";
                File xmlFile = new File(xmlpath);

                JAXBContext jaxbContext = JAXBContext.newInstance(Soldier.class);
                Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();


                //Soldier soldiers = (Soldier) jaxbUnmarshaller.unmarshal(xmlFile);
               List<Soldier> soldiers = (List<Soldier>) jaxbUnmarshaller.unmarshal(xmlFile);
                for (Soldier soldier : soldiers) {
                    long id = soldier.getId();
                    String firstName = soldier.getFirstName();
                    String lastName = soldier.getLastName();
                    Date dateOfBirth = soldier.getDateOfBirth();
                    String gender = soldier.getGender();
                    String contactNumber = soldier.getContactNumber();
                    String emergencyNumber = soldier.getEmergencyNumber();
                    String email = soldier.getEmail();
                    String address = soldier.getAddress();
                    long rankId = soldier.getRankId();
                    long roleId = soldier.getRoleId();
                    long baseId = soldier.getBaseId();
                    String serviceStatus = soldier.getServiceStatus();
                    String soldierStatus = soldier.getSoldierStatus();

                    //Rank
                    Rank rank = soldier.getRank();
                    long rankobjId = rank.getId();
                    String rankName = rank.getName();

                    //Role
                    Role role = soldier.getRole();
                    long roleobjId = role.getId();
                    String roleName = role.getName();

                    //Base
                    Base base = soldier.getBase();
                    long baseobjId = base.getId();
                    String baseName = base.getName();
                    String geography = base.getGeography();
                    long locationId = base.getLocationId();
                    String basecontactNumber = base.getContactNumber();
                    String baseemail = base.getEmail();

                    //Skills which declare in model get/setSkills
                    List<Skill> skills = soldier.getSkills();
                    for (Skill skill : skills) {
                        long skillId = skill.getId();
                        String name = skill.getName();
                        String description = skill.getDescription();
                    }

                    //Operation
                    List<Operation> operations = soldier.getOperations();
                    for (Operation operation : operations) {
                        long operationId = operation.getId();
                        String name = operation.getName();
                        Date startDate = operation.getStartDate();
                        Date endDate = operation.getEndDate();
                        String location = operation.getLocation();
                        long operationTypeId = operation.getOperationTypeId();
                    }

                    //Unit
                    List<Unit> units = soldier.getUnits();
                    for (Unit unit : units) {
                        long unitId = unit.getId();
                        String name = unit.getName();
                        String unitType = unit.getUnitType();
                        long unitsoldierId = unit.getSoldierId();
                    }
                }

            } catch (JAXBException e) {
                logger.error(e);
            }
        }
    }