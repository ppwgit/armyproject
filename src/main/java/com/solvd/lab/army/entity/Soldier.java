package com.solvd.lab.army.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Soldier {
    private static final Logger logger = LogManager.getLogger(Soldier.class);

    private Integer id;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String gender;
    private String contactNumber;
    private String emergencyNumber;
    private String email;
    private String address;
    private Integer rankId;
    private Integer roleId;
    private Integer baseId;
    private String serviceStatus;
    private String soldierStatus;
    private Rank rank;
    private Role role;
    private Base base;
    private List<SoldierSkill> soldierSkills;
    private List<SoldierOperation> soldierOperations;
    private List<Unit> units;

    public Soldier() {
    }

    public Soldier(Integer id, String firstName, String lastName,Date dateOfBirth,String gender,String contactNumber,String emergencyNumber,
              String email, String address,String serviceStatus ,String soldierStatus   ) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.contactNumber = contactNumber;
        this.emergencyNumber = emergencyNumber;
        this.email = email;
        this.address = address;
        this.serviceStatus = serviceStatus;
        this.soldierStatus= soldierStatus;
    }
    public Soldier(String firstName, String lastName,Date dateOfBirth,String gender,String contactNumber,String emergencyNumber,
                   String email, String address,String serviceStatus ,String soldierStatus   ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.contactNumber = contactNumber;
        this.emergencyNumber = emergencyNumber;
        this.email = email;
        this.address = address;
        this.serviceStatus = serviceStatus;
        this.soldierStatus= soldierStatus;
    }
    public Soldier  (Integer id, String firstName, String lastName,Date dateOfBirth,
                     String gender,  String contactNumber ,String emergencyNumber ,String email ,
                     String address,Integer rankId,Integer roleId,Integer baseId,String serviceStatus,
                     String soldierStatus,Rank rank, Role role, Base base){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.contactNumber = contactNumber;
        this.emergencyNumber = emergencyNumber;
        this.email = email;
        this.address = address;
        this.rankId = rankId;
        this.roleId = roleId;
        this.baseId = baseId;
        this.serviceStatus = serviceStatus;
        this.soldierStatus= soldierStatus;
        this.rank = rank;
        this.role = role;
        this.base = base;
        this.soldierSkills = new ArrayList<>();
        this.soldierOperations = new ArrayList<>();
        this.units = new ArrayList<>();

    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmergencyNumber() {
        return emergencyNumber;
    }

    public void setEmergencyNumber(String emergencyNumber) {
        this.emergencyNumber = emergencyNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getRankId() {
        return rankId;
    }

    public void setRankId(Integer rankId) {
        this.rankId = rankId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
    public Integer getBaseId() {
        return baseId;
    }

    public void setBaseId(Integer baseId) {
        this.baseId = baseId;
    }

    public String getServiceStatus() {
        return serviceStatus;
    }

    public void setServiceStatus(String serviceStatus) {
        this.serviceStatus = serviceStatus;
    }

    public String getSoldierStatus() {
        return soldierStatus;
    }

    public void setSoldierStatus(String soldierStatus) {
        this.soldierStatus = soldierStatus;
    }

}
