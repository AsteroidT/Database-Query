package VaccineApp;

import java.sql.*;
import java.util.Scanner;

public class vaccineApp {

    public static void main(String[] args) throws SQLException {

        int sqlCode = 0;      // Variable to hold SQLCODE
        String sqlState = "00000";  // Variable to hold SQLSTATE
        int choice = -1;

        // Register the driver.  You must register the driver before you can use it.
        try {
            DriverManager.registerDriver(new com.ibm.db2.jcc.DB2Driver());
        } catch (Exception cnfe) {
            System.out.println("Class not found");
        }

        // This is the url you must use for DB2.
        //Note: This url may not valid now !
        String url = "jdbc:db2://winter2021-comp421.cs.mcgill.ca:50000/cs421";

        //REMEMBER to remove your user id and password before submitting your code!!
        String your_userid = null;
        String your_password = null;
        //AS AN ALTERNATIVE, you can just set your password in the shell environment in the Unix (as shown below) and read it from there.
        //$  export SOCSPASSWD=yoursocspasswd
        if (your_userid == null && (your_userid = System.getenv("SOCSUSER")) == null) {
            System.err.println("Error!! do not have a password to connect to the database!");
            System.exit(1);
        }
        if (your_password == null && (your_password = System.getenv("SOCSPASSWD")) == null) {
            System.err.println("Error!! do not have a password to connect to the database!");
            System.exit(1);
        }
        Connection con = DriverManager.getConnection(url, your_userid, your_password);
        Statement statement = con.createStatement();

        String createSQL;

        try {
            createSQL = "CREATE TABLE People_register_for_vaccine" +
                    "(pname VARCHAR(30) NOT NULL" +
                    ",gender VARCHAR(30) NOT NULL" +
                    ",city VARCHAR(30) NOT NULL" +
                    ",job VARCHAR(30) NOT NULL" +
                    ",insurance_number INTEGER NOT NULL" +
                    ",date_of_registration DATE NOT NULL" +
                    ",date_of_birth DATE NOT NULL " +
                    ",phonenumber INTEGER NOT NULL" +
                    "  ,PRIMARY KEY (insurance_number)" +
                    ")";
            statement.executeUpdate(createSQL);
        } catch (SQLException e) {
            sqlCode = e.getErrorCode(); // Get SQLCODE
            sqlState = e.getSQLState(); // Get SQLSTATE
            if (sqlCode != -601) {
                // Your code to handle errors comes here;
                // something more meaningful than a print would be good
                System.out.println("Code: " + sqlCode + "  sqlState: " + sqlState);
                System.out.println(e);
            }
        }

        try {
            createSQL = "CREATE TABLE Health_care_workers" +
                    "(" +
                    "pname VARCHAR(30) NOT NULL" +
                    ",gender VARCHAR(30) NOT NULL" +
                    ",city VARCHAR(30) NOT NULL" +
                    ",job VARCHAR(30) NOT NULL" +
                    ",insurance_number INTEGER NOT NULL REFERENCES People_register_for_vaccine(insurance_number)" +
                    ",date_of_registration DATE NOT NULL" +
                    ",date_of_birth DATE NOT NULL " +
                    ",phonenumber INTEGER NOT NULL" +
                    ",priority INTEGER NOT NULL" +
                    "  ,PRIMARY KEY (insurance_number)" +
                    ")";
            statement.executeUpdate(createSQL);
        } catch (SQLException e) {
            sqlCode = e.getErrorCode(); // Get SQLCODE
            sqlState = e.getSQLState(); // Get SQLSTATE
            if (sqlCode != -601) {
                // Your code to handle errors comes here;
                // something more meaningful than a print would be good
                System.out.println("Code: " + sqlCode + "  sqlState: " + sqlState);
                System.out.println(e);
            }
        }

        try {
            createSQL = "CREATE TABLE Teachers_and_Children_below_10" +
                    "(" +
                    "pname VARCHAR(30) NOT NULL" +
                    ",gender VARCHAR(30) NOT NULL" +
                    ",city VARCHAR(30) NOT NULL" +
                    ",job VARCHAR(30) NOT NULL" +
                    ",insurance_number INTEGER NOT NULL REFERENCES People_register_for_vaccine(insurance_number)" +
                    ",date_of_registration DATE NOT NULL" +
                    ",date_of_birth DATE NOT NULL " +
                    ",phonenumber INTEGER NOT NULL" +
                    ",priority INTEGER NOT NULL" +
                    "  ,PRIMARY KEY (insurance_number)" +
                    ")";
            statement.executeUpdate(createSQL);
        } catch (SQLException e) {
            sqlCode = e.getErrorCode(); // Get SQLCODE
            sqlState = e.getSQLState(); // Get SQLSTATE
            if (sqlCode != -601) {
                // Your code to handle errors comes here;
                // something more meaningful than a print would be good
                System.out.println("Code: " + sqlCode + "  sqlState: " + sqlState);
                System.out.println(e);
            }
        }

        try {
            createSQL = "CREATE TABLE Essential_service_workers" +
                    "(" +
                    "pname VARCHAR(30) NOT NULL" +
                    ",gender VARCHAR(30) NOT NULL" +
                    ",city VARCHAR(30) NOT NULL" +
                    ",job VARCHAR(30) NOT NULL" +
                    ",insurance_number INTEGER NOT NULL REFERENCES People_register_for_vaccine(insurance_number)" +
                    ",date_of_registration DATE NOT NULL" +
                    ",date_of_birth DATE NOT NULL " +
                    ",phonenumber INTEGER NOT NULL" +
                    ",priority INTEGER NOT NULL" +
                    "  ,PRIMARY KEY (insurance_number)" +
                    ")";
            statement.executeUpdate(createSQL);
        } catch (SQLException e) {
            sqlCode = e.getErrorCode(); // Get SQLCODE
            sqlState = e.getSQLState(); // Get SQLSTATE
            if (sqlCode != -601) {
                // Your code to handle errors comes here;
                // something more meaningful than a print would be good
                System.out.println("Code: " + sqlCode + "  sqlState: " + sqlState);
                System.out.println(e);
            }
        }

        try {
            createSQL = "CREATE TABLE Everybody_else" +
                    "(" +
                    "pname VARCHAR(30) NOT NULL" +
                    ",gender VARCHAR(30) NOT NULL" +
                    ",city VARCHAR(30) NOT NULL" +
                    ",job VARCHAR(30) NOT NULL" +
                    ",insurance_number INTEGER NOT NULL REFERENCES People_register_for_vaccine(insurance_number)" +
                    ",date_of_registration DATE NOT NULL" +
                    ",date_of_birth DATE NOT NULL " +
                    ",phonenumber INTEGER NOT NULL" +
                    ",priority INTEGER NOT NULL" +
                    "  ,PRIMARY KEY (insurance_number)" +
                    ")";
            statement.executeUpdate(createSQL);
        } catch (SQLException e) {
            sqlCode = e.getErrorCode(); // Get SQLCODE
            sqlState = e.getSQLState(); // Get SQLSTATE
            if (sqlCode != -601) {
                // Your code to handle errors comes here;
                // something more meaningful than a print would be good
                System.out.println("Code: " + sqlCode + "  sqlState: " + sqlState);
                System.out.println(e);
            }
        }

        try {
            createSQL = "CREATE TABLE Vaccine_locations" +
                    "(" +
                    "  vname VARCHAR(30) NOT NULL" +
                    "  ,vdate DATE NOT NULL" +
                    "  ,Available_vaccine INTEGER NOT NULL" +
                    "  ,vcity VARCHAR(30) NOT NULL" +
                    "  ,Available_slots VARCHAR(30) NOT NULL" +
                    "  ,vcapacity INTEGER NOT NULL" +
                    "  ,PRIMARY KEY (vname)" +
                    ")";
            statement.executeUpdate(createSQL);
        } catch (SQLException e) {
            sqlCode = e.getErrorCode(); // Get SQLCODE
            sqlState = e.getSQLState(); // Get SQLSTATE
            if (sqlCode != -601) {
                // Your code to handle errors comes here;
                // something more meaningful than a print would be good
                System.out.println("Code: " + sqlCode + "  sqlState: " + sqlState);
                System.out.println(e);
            }
        }

        try {
            createSQL = "CREATE TABLE Registered_nurses" +
                    "(" +
                    "Canadian_nurse_license_number INTEGER NOT NULL" +
                    ",phonenumber INTEGER NOT NULL" +
                    ",nname VARCHAR(30) NOT NULL" +
                    ",ngender VARCHAR(30) NOT NULL" +
                    ",actual_employer VARCHAR(30) NOT NULL" +
                    "  ,PRIMARY KEY (Canadian_nurse_license_number)" +
                    ")";
            statement.executeUpdate(createSQL);
        } catch (SQLException e) {
            sqlCode = e.getErrorCode(); // Get SQLCODE
            sqlState = e.getSQLState(); // Get SQLSTATE
            if (sqlCode != -601) {
                // Your code to handle errors comes here;
                // something more meaningful than a print would be good
                System.out.println("Code: " + sqlCode + "  sqlState: " + sqlState);
                System.out.println(e);
            }
        }

        try {
            createSQL = "CREATE TABLE Company" +
                    "(" +
                    "   cname VARCHAR(30) NOT NULL" +
                    "  ,PRIMARY KEY (cname)" +
                    ")";
            statement.executeUpdate(createSQL);
        } catch (SQLException e) {
            sqlCode = e.getErrorCode(); // Get SQLCODE
            sqlState = e.getSQLState(); // Get SQLSTATE
            if (sqlCode != -601) {
                // Your code to handle errors comes here;
                // something more meaningful than a print would be good
                System.out.println("Code: " + sqlCode + "  sqlState: " + sqlState);
                System.out.println(e);
            }
        }

        try {
            createSQL = "CREATE TABLE Vaccine" +
                    "(" +
                    " Number_of_does_needed INTEGER NOT NULL" +
                    "  ,waiting_period INTEGER NOT NULL" +
                    "  ,Manufacturing_date DATE NOT NULL" +
                    "  ,Batch_number INTEGER NOT NULL " +
                    "  ,Vial_number INTEGER NOT NULL " +
                    "  ,cname VARCHAR(30) NOT NULL" +
                    "  ,expire_date DATE NOT NULL" +
                    "  ,PRIMARY KEY(Batch_number,Vial_number,cname)" +
                    ")";
            statement.executeUpdate(createSQL);
        } catch (SQLException e) {
            sqlCode = e.getErrorCode(); // Get SQLCODE
            sqlState = e.getSQLState(); // Get SQLSTATE
            if (sqlCode != -601) {
                // Your code to handle errors comes here;
                // something more meaningful than a print would be good
                System.out.println("Code: " + sqlCode + "  sqlState: " + sqlState);
                System.out.println(e);
            }
        }

        try {
            createSQL = "CREATE TABLE Vaccination_assignment" +
                    "(" +
                    "   insurance_number INTEGER NOT NULL" +
                    "  ,vname VARCHAR(30) NOT NULL" +
                    "  ,assignment_number INTEGER NOT NULL" +
                    "  ,slot_assigned INTEGER NOT NULL" +
                    "  ,vaccination_date DATE NOT NULL" +
                    "  ,PRIMARY KEY (vname, insurance_number)" +
                    "  ,FOREIGN KEY(vname) REFERENCES Vaccine_locations(vname)" +
                    "  ,FOREIGN KEY(insurance_number) REFERENCES People_register_for_vaccine(insurance_number)" +
                    ")";
            statement.executeUpdate(createSQL);
        } catch (SQLException e) {
            sqlCode = e.getErrorCode(); // Get SQLCODE
            sqlState = e.getSQLState(); // Get SQLSTATE
            if (sqlCode != -601) {
                // Your code to handle errors comes here;
                // something more meaningful than a print would be good
                System.out.println("Code: " + sqlCode + "  sqlState: " + sqlState);
                System.out.println(e);
            }
        }

        try {
            createSQL = "CREATE TABLE Injection" +
                    "(" +
                    "   insurance_number INTEGER NOT NULL" +
                    "  ,vname VARCHAR(30) NOT NULL" +
                    "  ,cname VARCHAR(30) NOT NULL" +
                    "  ,Batch_number INTEGER NOT NULL " +
                    "  ,Vial_number INTEGER NOT NULL " +
                    "  ,assignment_number Integer NOT NULL" +
                    "  ,Canadian_nurse_license_number INTEGER NOT NULL" +
                    "  ,PRIMARY KEY (assignment_number)" +
                    "  ,FOREIGN KEY(insurance_number) REFERENCES People_register_for_vaccine(insurance_number)" +
                    "  ,FOREIGN KEY(Canadian_nurse_license_number) REFERENCES Registered_nurses(Canadian_nurse_license_number)" +
                    ")";
            statement.executeUpdate(createSQL);
        } catch (SQLException e) {
            sqlCode = e.getErrorCode(); // Get SQLCODE
            sqlState = e.getSQLState(); // Get SQLSTATE
            if (sqlCode != -601) {
                // Your code to handle errors comes here;
                // something more meaningful than a print would be good
                System.out.println("Code: " + sqlCode + "  sqlState: " + sqlState);
                System.out.println(e);
            }
        }

        try {
            createSQL = "CREATE TABLE Storage" +
                    "(" +
                    "  cname VARCHAR(30) NOT NULL" +
                    "  ,Batch_number INTEGER NOT NULL " +
                    "  ,Vial_number INTEGER NOT NULL " +
                    "  ,vname VARCHAR(30) NOT NULL" +
                    "  ,number_of_vials_in_the_batch Integer NOT NULL" +
                    "  ,PRIMARY KEY (cname, Batch_number, Vial_number)" +
                    "  ,FOREIGN KEY(cname, Batch_number, Vial_number) REFERENCES Vaccine(cname, Batch_number, Vial_number)" +
                    ")";
            statement.executeUpdate(createSQL);
        } catch (SQLException e) {
            sqlCode = e.getErrorCode(); // Get SQLCODE
            sqlState = e.getSQLState(); // Get SQLSTATE
            if (sqlCode != -601) {
                // Your code to handle errors comes here;
                // something more meaningful than a print would be good
                System.out.println("Code: " + sqlCode + "  sqlState: " + sqlState);
                System.out.println(e);
            }
        }

        try {
            createSQL = "CREATE TABLE Deputed" +
                    "(" +
                    "  Canadian_nurse_license_number INTEGER NOT NULL" +
                    "  ,slot_assigned INTEGER NOT NULL " +
                    "  ,date_assigned DATE NOT NULL " +
                    "  ,vname VARCHAR(30) NOT NULL" +
                    "  ,PRIMARY KEY (Canadian_nurse_license_number, vname)" +
                    "  ,FOREIGN KEY(vname) REFERENCES Vaccine_locations" +
                    "  ,FOREIGN KEY(Canadian_nurse_license_number) REFERENCES Registered_nurses " +
                    ")";
            statement.executeUpdate(createSQL);
        } catch (
                SQLException e) {
            sqlCode = e.getErrorCode(); // Get SQLCODE
            sqlState = e.getSQLState(); // Get SQLSTATE
            if (sqlCode != -601) {
                // Your code to handle errors comes here;
                // something more meaningful than a print would be good
                System.out.println("Code: " + sqlCode + "  sqlState: " + sqlState);
                System.out.println(e);
            }
        }

        PreparedStatement addPerson = con.prepareStatement("INSERT INTO People_register_for_vaccine VALUES(?,?,?,?,?,?,?,?)");
        PreparedStatement checkPerson = con.prepareStatement("SELECT insurance_number FROM People_register_for_vaccine where insurance_number = ?");
        PreparedStatement updatePerson = con.prepareStatement("UPDATE People_register_for_vaccine SET pname = ?, gender = ?, city = ?, job = ?, phonenumber = ? WHERE insurance_number = ?");
        PreparedStatement assignSlot = con.prepareStatement("INSERT INTO Vaccination_assignment VALUES (?,?,?,?,?)");
        PreparedStatement slotCheck = con.prepareStatement("SELECT COUNT(va.insurance_number) AS occupied FROM Vaccination_assignment va WHERE va.vname = ? AND va.slot_assigned = ? AND va.vaccination_date = ?");
        PreparedStatement updateSlot = con.prepareStatement("UPDATE vaccine_locations SET available_slots = available_slots - 1 WHERE vname = ?");
        PreparedStatement injectionTimes = con.prepareStatement("SELECT COUNT(i.assignment_number) as number_of_does_injected FROM injection i WHERE insurance_number = ? group by i.insurance_number");
        PreparedStatement injectionInformation = con.prepareStatement("SELECT cname, batch_number, vial_number FROM injection WHERE insurance_number = ?");
        PreparedStatement injectionNeeded = con.prepareStatement("SELECT number_of_does_needed FROM vaccine WHERE cname = ? AND batch_number = ? AND vial_number = ?");
        PreparedStatement vaccinationInformation = con.prepareStatement("INSERT INTO Injection VALUES (?,?,?,?,?,?,?)");

        while (true) {
            String name = null;
            String gender = null;
            String city = null;
            String job = null;
            int insurnum = 0;
            String dateOfRegistration = null;
            String dateOfBirth = null;
            int phonenumber = 0;
            int assignmentNumber = 0;
            int slotassigned = 0;
            String vaccinationDate = null;
            int batchNumber = 0;
            int vialNumber = 0;
            int numberOfDoesInjected = 0;
            int numberOfDoesNeeded = 0;
            int CNLN = 0;

            System.out.println(
                    "VaccineApp Main Menu\n" +
                            "  1. Add a person\n" +
                            "  2. Assign a slot to a Person\n" +
                            "  3. Enter Vaccination information\n" +
                            "  4. Exit Application\n" +
                            "Please Enter Your Option:"
            );

            Scanner keyboard = new Scanner(System.in);
            choice = keyboard.nextInt();
            keyboard.nextLine();

            if (choice < 1 || choice > 4) {
                System.out.println("Please enter a number between 1~4");
            } else if (choice == 4) {
                break;
            } else if (choice == 1) {
                try {
                    System.out.println("Please enter his/her insurance number:");
                    insurnum = keyboard.nextInt();
                    keyboard.nextLine();
                    checkPerson.setInt(1, insurnum);
                    ResultSet rs = checkPerson.executeQuery();
                    int checker = 0;
                    while (rs.next()) {
                        checker = rs.getInt("insurance_number");
                    }

                    if (checker != 0) {
                        System.out.println("The person already exists, update information?\n" +
                                "  1. YES\n" +
                                "  2. NO");

                        checker = keyboard.nextInt();
                        keyboard.nextLine();

                        if (checker == 1) {
                            updatePerson.setInt(6, insurnum);

                            System.out.println("Please enter the new name:");
                            name = keyboard.nextLine();
                            updatePerson.setString(1, name);

                            System.out.println("Please enter the new gender:");
                            gender = keyboard.nextLine();
                            updatePerson.setString(2, gender);

                            System.out.println("Please enter the new city");
                            city = keyboard.nextLine();
                            updatePerson.setString(3, city);

                            System.out.println("Please enter the new job:");
                            job = keyboard.nextLine();
                            updatePerson.setString(4, job);

                            System.out.println("Please enter the new phone number:");
                            phonenumber = keyboard.nextInt();
                            keyboard.nextLine();
                            updatePerson.setInt(5, phonenumber);

                            int row = updatePerson.executeUpdate();

                            if (row != 0) {
                                System.out.println("Successfully updated");
                            }
                        }
                    } else {

                        addPerson.setInt(5, insurnum);

                        System.out.println("Please enter his/her name:");
                        name = keyboard.nextLine();
                        addPerson.setString(1, name);

                        System.out.println("Please enter his/her gender:");
                        gender = keyboard.nextLine();
                        addPerson.setString(2, gender);

                        System.out.println("Please enter his/her city:");
                        city = keyboard.nextLine();
                        addPerson.setString(3, city);

                        System.out.println("Please enter his/her job");
                        job = keyboard.nextLine();
                        addPerson.setString(4, job);

                        System.out.println("Please enter his/her date of registration (yyyy-[m]m-[d]d): ");
                        dateOfRegistration = keyboard.nextLine();
                        addPerson.setDate(6, Date.valueOf(dateOfRegistration));

                        System.out.println("Please enter his/her date of birth (yyyy-[m]m-[d]d): ");
                        dateOfBirth = keyboard.nextLine();
                        addPerson.setDate(7, Date.valueOf(dateOfBirth));

                        System.out.println("Please enter his/her phone number:");
                        phonenumber = keyboard.nextInt();
                        keyboard.nextLine();
                        addPerson.setInt(8, phonenumber);

                        int row = addPerson.executeUpdate();

                        if (row != 0) {
                            System.out.println("A new person is successfully added.");
                        }
                    }

                } catch (SQLException e) {
                    sqlCode = e.getErrorCode(); // Get SQLCODE
                    sqlState = e.getSQLState(); // Get SQLSTATE

                    // Your code to handle errors comes here;
                    // something more meaningful than a print would be good
                    System.out.println("Code: " + sqlCode + "  sqlState: " + sqlState);
                    System.out.println(e);
                }
            } else if (choice == 2) {
                try {
                    System.out.println("Please enter his/her insurance number:");
                    insurnum = keyboard.nextInt();
                    keyboard.nextLine();

                    injectionTimes.setInt(1, insurnum);
                    injectionInformation.setInt(1, insurnum);
                    assignSlot.setInt(1, insurnum);

                    ResultSet rs = injectionTimes.executeQuery();
                    while (rs.next()) {
                        numberOfDoesInjected = rs.getInt("number_of_does_injected");
                    }

                    rs = injectionInformation.executeQuery();
                    while (rs.next()) {
                        name = rs.getString("cname");
                        batchNumber = rs.getInt("batch_number");
                        vialNumber = rs.getInt("vial_number");
                    }

                    injectionNeeded.setString(1, name);
                    injectionNeeded.setInt(2, batchNumber);
                    injectionNeeded.setInt(3, vialNumber);

                    rs = injectionNeeded.executeQuery();

                    while (rs.next()) {
                        numberOfDoesNeeded = rs.getInt("number_of_does_needed");
                    }

                    if (numberOfDoesInjected < numberOfDoesNeeded || numberOfDoesInjected == 0) {

                        while (true) {
                            System.out.println("Please enter the name of the vaccination location:");
                            name = keyboard.nextLine();
                            assignSlot.setString(2, name);
                            updateSlot.setString(1, name);
                            slotCheck.setString(1, name);

                            System.out.println("Please enter the slot assigned:");
                            slotassigned = keyboard.nextInt();
                            keyboard.nextLine();
                            assignSlot.setInt(4, slotassigned);
                            slotCheck.setInt(2, slotassigned);

                            System.out.println("Please enter the vaccination date");
                            vaccinationDate = keyboard.nextLine();
                            assignSlot.setDate(5, Date.valueOf(vaccinationDate));
                            slotCheck.setDate(3, Date.valueOf(vaccinationDate));

                            rs = slotCheck.executeQuery();
                            int occupied = 0;
                            while (rs.next()) {
                                occupied = rs.getInt("occupied");
                            }

                            if (occupied != 0) {
                                System.out.println("Slot " + slotassigned + " at " + name + " is already assigned");
                            } else {
                                break;
                            }
                        }

                        System.out.println("Please enter the assignment number:");
                        assignmentNumber = keyboard.nextInt();
                        keyboard.nextLine();
                        assignSlot.setInt(3, assignmentNumber);

                        int row = assignSlot.executeUpdate();
                        if (row != 0) {
                            System.out.println("Slot Assigned");
                            updateSlot.executeUpdate();
                        }
                    }
                    else {
                        System.out.println("Already reach the recommended injection time.");
                    }
                } catch (SQLException e) {
                    sqlCode = e.getErrorCode(); // Get SQLCODE
                    sqlState = e.getSQLState(); // Get SQLSTATE

                    // Your code to handle errors comes here;
                    // something more meaningful than a print would be good
                    System.out.println("Code: " + sqlCode + "  sqlState: " + sqlState);
                    System.out.println(e);
                }
            } else if (choice == 3) {
                System.out.println("Please enter the insurance number:");
                insurnum = keyboard.nextInt();
                keyboard.nextLine();
                vaccinationInformation.setInt(1, insurnum);

                System.out.println("Please enter the name of vaccination location:");
                name = keyboard.nextLine();
                vaccinationInformation.setString(2, name);

                System.out.println("Please enter the name of company");
                name = keyboard.nextLine();
                vaccinationInformation.setString(3, name);

                System.out.println("Please enter the batch number:");
                batchNumber = keyboard.nextInt();
                keyboard.nextLine();
                vaccinationInformation.setInt(4, batchNumber);

                System.out.println("Please enter the vial number:");
                vialNumber = keyboard.nextInt();
                keyboard.nextLine();
                vaccinationInformation.setInt(5, vialNumber);

                System.out.println("Please enter the assignemnt number:");
                assignmentNumber = keyboard.nextInt();
                keyboard.nextLine();
                vaccinationInformation.setInt(6, assignmentNumber);

                System.out.println("Please enter the Canadian nurse license number:");
                CNLN = keyboard.nextInt();
                keyboard.nextLine();
                vaccinationInformation.setInt(7, CNLN);

                int row = vaccinationInformation.executeUpdate();

                if (row != 0) {
                    System.out.println("Vaccination information successfully added");
                }
            }
        }

        // Finally but importantly close the statement and connection
        statement.close();
        con.close();
    }
}

