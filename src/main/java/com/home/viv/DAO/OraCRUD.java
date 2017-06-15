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
    DBConnect dbConnect;

    public void createPerson(String Lname, String Fame, String Fname, String Adress, Pole pole, ArrayList<String> phoneNum) {

    }

    public void GetAllPep (Statement st){

        try {
            System.out.println();
            ResultSet result1 = st.executeQuery("SELECT PERSON_ID,LNAME,FNAME,ADRESS,EMAIL,POLE FROM PERSON");

            StringBuffer sb = new StringBuffer(75);

            while (result1.next()) {


                sb=sb.append(String.valueOf(result1.getRow()))
                        .append(" ID: ").append(String.valueOf(result1.getInt("PERSON_ID")))
                        .append(" Last Name: ").append(result1.getString("LNAME"))
                        .append(" First Name: ").append(result1.getString("FNAME"))
                        .append(" Address: ").append(result1.getString("ADRESS"))
                        .append(" EMAIL ").append(result1.getString("EMAIL"));
                System.out.println(sb);
                sb =sb.delete(0,sb.length()) ;}

        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);

        }
    }













    public void editPerson(int Person_id, String Lname, String Fame, String Fname, String Adress, Pole pole, ArrayList<String> phoneNum) {

    }

    public void DeletePerson(int Person_id) {

    }

    public Person FindPerson(int Person_id, String Lname, String Fame, String Fname, String Adress, Pole pole, ArrayList<String> phoneNum) {
        return null;//for test
    }

    public ArrayList<Person> GetAllPerson() {
        return null;//for test
    }
}
