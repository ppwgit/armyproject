package com.solvd.lab.army.test;


import com.solvd.lab.army.dao.impl.SoldierDAOImpl;

public class TestSoldierDAOClass {
    public static void main(String[] args) {
        SoldierDAOImpl dao = new SoldierDAOImpl();

        System.out.println("Fetching data from the database...");

        // Test the getAll() method
        /*List<Soldier> soldiers = dao.getAllSoldiers();
        System.out.println("All Soldiers:");
        for (Soldier soldier : soldiers) {
            System.out.println(soldier.getId() + " " + soldier.getFirstName() + " " + soldier.getLastName() + " " + soldier.getDateOfBirth() + " " + soldier.getGender()
                    + " " + soldier.getContactNumber() + " " + soldier.getEmergencyNumber() + " " + soldier.getEmail() + " " + soldier.getAddress() + " " + soldier.getServiceStatus() + " " + soldier.getSoldierStatus());

        }*/

      /*  // Test the getById(int id) method
        System.out.println("All Soldiers: getById");
        Soldier soldier = dao.getSoldierById(1);
        System.out.println(soldier.getFirstName() + " " + soldier.getLastName() + " " + soldier.getDateOfBirth() + " "+ soldier.getGender()
                + " " + soldier.getContactNumber() + " " + soldier.getEmergencyNumber() + " " + soldier.getEmail() +" "+ soldier.getAddress()+ " "+ soldier.getServiceStatus()+ " " + soldier.getSoldierStatus());
// Test the create(User user) method
        User newUser = new User("John Doe", "john.doe@example.com");
        userImpl.create(newUser);
        System.out.println("New User created: " + newUser);

        // Test the update(User user) method
        user.setEmail("newemail@example.com");
        userImpl.update(user);
        System.out.println("Updated User: " + user);

        // Test the delete(int id) method
        userImpl.delete(user.getId());
        System.out.println("User deleted with ID: " + user.getId());
    }*/
    }
}