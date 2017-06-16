package com.home.viv.DAO;

import com.home.viv.Interface.PersonCRUD;
import com.home.viv.Main;
import com.home.viv.Objects.Person;
import com.home.viv.Objects.Pole;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by viv on 15.06.2017.
 */
public class OraCRUD implements PersonCRUD{
//implementation DBConnect for Oracle DB

    private Statement statement;


    public OraCRUD(Statement statement) {
        this.statement = statement;
    }

    public void createPerson(String lname, String fname, String adress, String email, int pole) {

//        Scanner scanner= new Scanner(System.in);
//
//        System.out.println("For create new person insert all parameters:");
//        //in.nextLine();
//        System.out.println("Family Name:");
//        String firstName = scanner.nextLine();
//        System.out.println("Name:");
//        String lastName = scanner.nextLine();
//        System.out.println("Adress:");
//        String email = scanner.nextLine();
//        System.out.println("Email:");
//        String phone = scanner.nextLine();
//        System.out.println("Pole (1- Male| 2- Female):");
//        Int Salary = scanner.nextLine();
//
//        String sqlstr="INSERT INTO PERSON (PERSON_ID, FNAME, LNAME, ADRESS, EMAIL, POLE) VALUES(PERSON_SC.nextval, 20," +
//                " 'Ivanov', 'Ivan','vk@vk.com',1)";
//
//        try {
//            //System.out.println(sqlstr);
//            statement.executeUpdate(sqlstr);
//            System.out.println("New Person successfully added");
//            System.out.println();
//        }
//        catch (SQLException Ex) {
//
//            //Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, Ex);
//            System.out.println(Ex);
//        }


    }

    public void editPerson(int Person_id, String lname, String fname, String adress, String email, int pole) {

    }

    public void deletePerson(int Person_id) {

        String sqlstr="DELETE FROM PERSON WHERE PERSON_ID = " + Person_id;

            try {
                statement.executeUpdate(sqlstr);
                System.out.println("Person ID : " + Person_id + " delete from DB");
                System.out.println();
            }
            catch (SQLException Ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, Ex);
                System.out.println(Ex);
            }

    }

    public Person findPerson(int Person_id, String lname, String fname, String adress, String email, int pole) {
        return null;
    }



    public ArrayList<Person> getAllPersons() {

        ArrayList<Person> persons = new ArrayList<Person>();

    try {

        ResultSet rs = statement.executeQuery("SELECT PERSON_ID,LNAME,FNAME,ADRESS,EMAIL,POLE FROM PERSON");
        StringBuffer sb = new StringBuffer(75);

        int person_id;
        String fname;
        String lname;
        String adress;
        String email;
        int pole;

        while (rs.next()) {

            person_id = rs.getInt("PERSON_ID");
            fname = rs.getString("FNAME");
            lname = rs.getString("LNAME");
            adress = rs.getString("ADRESS");
            email = rs.getString("EMAIL");
            pole = rs.getInt("POLE");

            Person pr = new Person(person_id, fname, lname, adress, email, pole);

            persons.add(pr);


        }
    }catch(SQLException e){
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
            e.printStackTrace();
    }
        return persons;


    }

}
