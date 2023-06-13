package com.solvd.lab.army.modelJson;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.solvd.lab.army.model.Operation;
import com.solvd.lab.army.model.Rank;
import com.solvd.lab.army.model.Role;
import com.solvd.lab.army.model.Skill;
import com.solvd.lab.army.model.Unit;
import com.solvd.lab.army.model.*;
import com.solvd.lab.army.utils.DateAdapter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class SoldierJson {
    private static final Logger logger = LogManager.getLogger(SoldierJson.class);

    @JsonProperty("id")
    private Long id;

    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("lastName")
    private String lastName;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @JsonProperty("dateOfBirth")
    private Date dateOfBirth;

    @JsonProperty("gender")
    private String gender;

    @JsonProperty("contactNumber")
    private String contactNumber;

    @JsonProperty("emergencyNumber")
    private String emergencyNumber;

    @JsonProperty("email")
    private String email;

    @JsonProperty("address")
    private String address;

    @JsonProperty("rankId")
    private Long rankId;

    @JsonProperty("roleId")
    private Long roleId;

    @JsonProperty("baseId")
    private Long baseId;

    @JsonProperty("serviceStatus")
    private String serviceStatus;

    @JsonProperty("soldierStatus")
    private String soldierStatus;

    @JsonProperty("rank")
    private RankJson rank;

    @JsonProperty("role")
    private RoleJson role;

    @JsonProperty("base")
    private BaseJson base;

    @JsonProperty("skills")
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
   private List<SkillJson> skills;

    @JsonProperty("operations")
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    private List<OperationJson> operations;

    @JsonProperty("units")
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    private List<UnitJson> units;

    public SoldierJson() {
    }

    public SoldierJson(long id, String firstName, String lastName, Date dateOfBirth, String gender, String contactNumber, String emergencyNumber, String email, String address, long rankId, long roleId, long baseId, String serviceStatus, String serviceStatus1, String soldierStatus) {
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


    public List<SkillJson> getSkills() {
        return skills;
    }
    public void setSkills(List<SkillJson> skills) {
        this.skills = skills;
    }
    public List<OperationJson> getOperations() {
        return operations;
    }

    public void setOperations(List<OperationJson> operations) {
        this.operations = operations;
    }
    public List<UnitJson> getUnits() {
        return units;
    }
    public void setUnits(List<UnitJson> units) {
        this.units = units;
    }

    public RankJson getRank() {
        return rank;
    }
    public void setRank(RankJson rank) {
        this.rank = rank;
    }
    public RoleJson getRole() {
        return role;
    }
    public void setRole(RoleJson role) {
        this.role = role;
    }
    public BaseJson getBase() {
        return base;
    }

    public void setBase(BaseJson base) {
        this.base = base;
    }
}
