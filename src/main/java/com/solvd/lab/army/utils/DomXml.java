package com.solvd.lab.army.utils;

import com.solvd.lab.army.ArmyApp;
import com.solvd.lab.army.model.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.dom.DOMSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DomXml {
    private static final Logger logger = LogManager.getLogger(ArmyApp.class);

    public static void main(String[] args) {
        try {
            String xmlFile = "C:/Users/ppw/solvdlab/army/src/main/java/resources/xml/soldiers.xml";
            String xsdFile = "C:/Users/ppw/solvdlab/army/src/main/java/resources/xml/soldiers.xsd";

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);

            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = schemaFactory.newSchema(new File(xsdFile));
            schema.newValidator().validate(new DOMSource(document));

            Element rootElement = document.getDocumentElement();
            NodeList soldierList = rootElement.getElementsByTagName("soldier");

            try {

                for (int i = 0; i < soldierList.getLength(); i++) {
                    Element soldierElement = (Element) soldierList.item(i);

                    Long id = Long.parseLong(soldierElement.getAttribute("id"));
                    String firstName = soldierElement.getElementsByTagName("firstName").item(0).getTextContent();
                    String lastName = soldierElement.getElementsByTagName("lastName").item(0).getTextContent();
                    String dateOfBirthString = soldierElement.getElementsByTagName("dateOfBirth").item(0).getTextContent();
                    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    Date dateOfBirth = dateFormat.parse(dateOfBirthString);
                    String gender = soldierElement.getElementsByTagName("gender").item(0).getTextContent();
                    String contactNumber = soldierElement.getElementsByTagName("contactNumber").item(0).getTextContent();
                    String emergencyNumber = soldierElement.getElementsByTagName("emergencyNumber").item(0).getTextContent();
                    String email = soldierElement.getElementsByTagName("email").item(0).getTextContent();
                    String address = soldierElement.getElementsByTagName("address").item(0).getTextContent();
                    Long rankId = Long.parseLong(soldierElement.getElementsByTagName("rankId").item(0).getTextContent());
                    Long roleId = Long.parseLong(soldierElement.getElementsByTagName("roleId").item(0).getTextContent());
                    Long baseId = Long.parseLong(soldierElement.getElementsByTagName("baseId").item(0).getTextContent());
                    String serviceStatus = soldierElement.getElementsByTagName("serviceStatus").item(0).getTextContent();
                    String soldierStatus = soldierElement.getElementsByTagName("soldierStatus").item(0).getTextContent();

                    Soldier soldier = new Soldier();
                    soldier.setId(id);
                    soldier.setFirstName(firstName);
                    soldier.setLastName(lastName);
                    soldier.setDateOfBirth(dateOfBirth);
                    soldier.setGender(gender);
                    soldier.setContactNumber(contactNumber);
                    soldier.setEmergencyNumber(emergencyNumber);
                    soldier.setEmail(email);
                    soldier.setAddress(address);
                    soldier.setRankId(rankId);
                    soldier.setRoleId(roleId);
                    soldier.setBaseId(baseId);
                    //Rank
                    Element rankElement = (Element) soldierElement.getElementsByTagName("rank").item(0);
                    //Long rankId = Long.parseLong(rankElement.getAttribute("id"));
                    String rankName = rankElement.getElementsByTagName("name").item(0).getTextContent();
                    Rank rank = new Rank();
                    //rank.setId(crankId);
                    rank.setName(rankName);
                    soldier.setRank(rank);
                    //Role
                    Element roleElement = (Element) soldierElement.getElementsByTagName("role").item(0);
                    String roleName = roleElement.getElementsByTagName("name").item(0).getTextContent();
                    Role role = new Role();
                    role.setName(roleName);
                    soldier.setRole(role);

                    //Base
                    Element baseElement = (Element) soldierElement.getElementsByTagName("base").item(0);
                    String baseName = baseElement.getElementsByTagName("name").item(0).getTextContent();
                    Base base = new Base();
                    base.setName(baseName);
                    soldier.setBase(base);

                    //Skill List --Skills
                    List<Skill> skillList = new ArrayList<>();
                    Element skillsElement = (Element) soldierElement.getElementsByTagName("skills").item(0);
                    NodeList skillElements = skillsElement.getElementsByTagName("skill");
                    for (int j = 0; j < skillElements.getLength(); j++) {
                        Element soldierSkillElement = (Element) skillElements.item(j);
                        Long skillId = Long.parseLong(soldierSkillElement.getAttribute("id"));
                        String skillName = soldierSkillElement.getElementsByTagName("name").item(0).getTextContent();
                        String description = soldierSkillElement.getElementsByTagName("description").item(0).getTextContent();
                        Skill skill = new Skill(skillId, skillName, description);
                        skillList.add(skill);
                    }
                    soldier.setSkills(skillList);

                    List<Operation> operationList = new ArrayList<>();
                    Element operationsElement = (Element) soldierElement.getElementsByTagName("operations").item(0);
                    NodeList operationElements = operationsElement.getElementsByTagName("operation");
                    for (int j = 0; j < operationElements.getLength(); j++) {
                        Element soldierOperationElement = (Element) operationElements.item(j);
                        Long operationId = Long.parseLong(soldierOperationElement.getAttribute("id"));
                        String operationName = soldierOperationElement.getElementsByTagName("name").item(0).getTextContent();
                        String startDateString = soldierElement.getElementsByTagName("startDate").item(0).getTextContent();
                        dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        Date startDate = dateFormat.parse(startDateString);
                        String endDateString = soldierElement.getElementsByTagName("endDate").item(0).getTextContent();
                        dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        Date endDate = dateFormat.parse(endDateString);
                        String location = soldierOperationElement.getElementsByTagName("location").item(0).getTextContent();
                        Long operationYpeId = Long.parseLong(soldierOperationElement.getAttribute("id"));

                        Operation operation = new Operation(operationId, operationName, startDate, endDate, location, operationYpeId);
                        operationList.add(operation);

                        //OperationType
                        NodeList operationTypeElements = operationsElement.getElementsByTagName("operationType");
                        for (int k = 0; k < operationTypeElements.getLength(); k++) {
                            Element soldierOperationTypeElement = (Element) operationElements.item(j);
                            Long operationTypeId = Long.parseLong(soldierOperationElement.getAttribute("id"));
                            String operationTypeName = soldierOperationElement.getElementsByTagName("name").item(0).getTextContent();

                            OperationType operationType = new OperationType(operationTypeId, operationName);
                            operation.setOperationType(operationType);
                        }

                    }
                    soldier.setOperations(operationList);

                    //Unit
                    List<Unit> units = new ArrayList<>();
                    Element unitsElement = (Element) soldierElement.getElementsByTagName("units").item(0);
                    NodeList unitElements = unitsElement.getElementsByTagName("unit");
                    for (int j = 0; j < unitElements.getLength(); j++) {
                        Element unitElement = (Element) unitElements.item(j);
                        Long unitId = Long.parseLong(unitElement.getAttribute("id"));
                        String unitName = unitElement.getElementsByTagName("name").item(0).getTextContent();
                        String unitType = unitElement.getElementsByTagName("unitType").item(0).getTextContent();
                        Long soldierId = Long.parseLong(unitElement.getAttribute("soldierId"));
                        Unit unit = new Unit(unitId, unitName, unitType, soldierId);
                        units.add(unit);
                    }
                    soldier.setUnits(units);
                }
            } catch (Exception e) {
                logger.error(e);
            }
        } catch (ParserConfigurationException e) {
            logger.error(e);
        } catch (IOException e) {
            logger.error(e);
        } catch (SAXException e) {
            logger.error(e);
        }
    }
}