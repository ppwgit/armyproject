package com.solvd.lab.army.model;

import com.solvd.lab.army.utils.DateAdapter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@XmlRootElement(name = "soldiers")
@XmlAccessorType(XmlAccessType.FIELD)
public class Soldier {
    private static final Logger logger = LogManager.getLogger(Soldier.class);

    private Long id;

    @XmlElement(name = "firstName")
    private String firstName;

    @XmlElement(name = "lastName")
    private String lastName;

    @XmlJavaTypeAdapter(DateAdapter.class)
    private Date dateOfBirth;

    @XmlElement(name = "gender")
    private String gender;

    @XmlElement(name = "contactNumber")
    private String contactNumber;

    @XmlElement(name = "emergencyNumber")
    private String emergencyNumber;

    @XmlElement(name = "email")
    private String email;

    @XmlElement(name = "address")
    private String address;

    @XmlElement(name = "rankId")
    private Long rankId;

    @XmlElement(name = "roleId")
    private Long roleId;

    @XmlElement(name = "baseId")
    private Long baseId;

    @XmlElement(name = "serviceStatus")
    private String serviceStatus;

    @XmlElement(name = "soldierStatus")
    private String soldierStatus;

    @XmlElement(name = "rank")
    private Rank rank;

    private String rankName;

    @XmlElement(name = "role")
    private Role role;

    private String roleName;

    @XmlElement(name = "base")
    private Base base;

    private String baseName;

   @XmlElementWrapper(name = "skills")
   @XmlElement(name = "skill")
   private List<Skill> skills;

    @XmlElementWrapper(name = "operations")
    @XmlElement(name = "operation")
    private List<Operation> operations;

    @XmlElementWrapper(name = "units")
    @XmlElement(name = "unit")
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


    public String getRankName() {
        return rankName;
    }

    public void setRankName(String rankName) {
        this.rankName = rankName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getBaseName() {
        return baseName;
    }

    public void setBaseName(String baseName) {
        this.baseName = baseName;
    }

}
