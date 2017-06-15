package com.home.viv.DAO;

import com.home.viv.Interface.PersonCRUD;
import com.home.viv.Main;
import com.home.viv.Objects.Person;
import com.home.viv.Objects.Pole;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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

    }

    public void editPerson(int Person_id, String lname, String fname, String adress, String email, int pole) {

    }

    public void deletePerson(int Person_id) {

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
