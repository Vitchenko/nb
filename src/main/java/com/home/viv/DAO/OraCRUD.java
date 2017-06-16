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

    public void createPerson(String fname, String lname, String adress, String email, int pole, String ph_number) {


        String sqlstr="INSERT ALL INTO PERSON (PERSON_ID, LNAME, PERSON.FNAME, PERSON.ADRESS, PERSON.Pole, PERSON.Email) " +
                "VALUES (Person_sc.NEXTVAL, '"+ lname +"', '"+fname+"', '"+adress+"', '"+pole+"', '+ "+email+"') " +
                "INTO PHONES (PHONES.PHONES_ID, PHONES.PH_NUMBER, PHONES.PERSON_ID) VALUES (Phones_sc.NEXTVAL, '"+ph_number+"', " +
                "Person_sc.currval ) select * from dual";


        try {

            statement.executeUpdate(sqlstr);
            System.out.println();
        }
        catch (SQLException Ex) {

            //Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, Ex);
            System.out.println(Ex);
        }


    }

    public void editPerson(int Person_id, String lname, String fname, String adress, String email, int pole, String ph_number) {

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

    public Person findPerson(int Person_id) {

        //Добавить проверку что такой Person_id существует

        Person pr=null;

        try {

            ResultSet rs = statement.executeQuery("SELECT P.PERSON_ID,P.LNAME,P.FNAME,P.ADRESS,P.EMAIL,P.POLE, F.PH_NUMBER FROM PERSON P, PHONES f WHERE P.PERSON_ID=f.PERSON_ID AND P.PERSON_ID="+Person_id);
            StringBuffer sb = new StringBuffer(75);

            int person_id;
            String fname;
            String lname;
            String adress;
            String email;
            int pole;
            String ph_number;

            while (rs.next()) {

                person_id = rs.getInt("PERSON_ID");
                fname = rs.getString("FNAME");
                lname = rs.getString("LNAME");
                adress = rs.getString("ADRESS");
                email = rs.getString("EMAIL");
                pole = rs.getInt("POLE");
                ph_number= rs.getString("PH_NUMBER");

                pr = new Person(person_id, fname, lname, adress, email, pole, ph_number);

            }
        }catch(SQLException e){
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
            e.printStackTrace();
        }
        return pr;

    }



    public ArrayList<Person> getAllPersons() {

        ArrayList<Person> persons = new ArrayList<Person>();

    try {

        ResultSet rs = statement.executeQuery("SELECT P.PERSON_ID,P.LNAME,P.FNAME,P.ADRESS,P.EMAIL,P.POLE, F.PH_NUMBER FROM PERSON P, PHONES f WHERE P.PERSON_ID=f.PERSON_ID");
        StringBuffer sb = new StringBuffer(75);

        int person_id;
        String fname;
        String lname;
        String adress;
        String email;
        int pole;
        String ph_number;

        while (rs.next()) {

            person_id = rs.getInt("PERSON_ID");
            fname = rs.getString("FNAME");
            lname = rs.getString("LNAME");
            adress = rs.getString("ADRESS");
            email = rs.getString("EMAIL");
            pole = rs.getInt("POLE");
            ph_number= rs.getString("PH_NUMBER");

            Person pr = new Person(person_id, fname, lname, adress, email, pole, ph_number);

            persons.add(pr);


        }
    }catch(SQLException e){
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
            e.printStackTrace();
    }
        return persons;


    }

}
