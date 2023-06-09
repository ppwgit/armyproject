package com.solvd.lab.army.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Soldier {
    private static final Logger logger = LogManager.getLogger(Soldier.class);

    private Long id;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String gender;
    private String contactNumber;
    private String emergencyNumber;
    private String email;
    private String address;
    private Long rankId;
    private Long roleId;
    private Long baseId;
    private String serviceStatus;
    private String soldierStatus;
    private Rank rank;
    private Role role;
    private Base base;
   // private List<SoldierSkill> soldierSkills;
   // private List<SoldierOperation> soldierOperations;
   private List<Skill> skills;
   private List<Operation> operations;
    private List<Unit> units;

    public Soldier() {
    }

    public Soldier(long id, String firstName, String lastName, Date dateOfBirth, String gender, String contactNumber, String emergencyNumber, String email, String address, long rankId, long roleId, long baseId, String serviceStatus, String serviceStatus1, String soldierStatus) {
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
        skills = new ArrayList<>();
        operations = new ArrayList<>();
        units = new ArrayList<>();
        this.rank = rank;
        this.role = role;
        this.base = base;

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Long getRankId() {
        return rankId;
    }

    public void setRankId(Long rankId) {
        this.rankId = rankId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
    public Long getBaseId() {
        return baseId;
    }

    public void setBaseId(Long baseId) {
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


    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }
    public List<Operation> getOperations() {
        return operations;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }
    public List<Unit> getUnits() {
        return units;
    }

    public void setUnits(List<Unit> units) {
        this.units = units;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
    public Base getBase() {
        return base;
    }

    public void setBase(Base base) {
        this.base = base;
    }
}
