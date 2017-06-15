package com.home.viv.Interface;

import com.home.viv.Objects.Person;
import com.home.viv.Objects.Pole;

import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by viv on 15.06.2017.
 */
public interface PersonCRUD {

    void createPerson(String lname, String fname, String adress, String email, int pole);
    void editPerson(int Person_id, String lname, String fname, String adress, String email, int pole);
    void deletePerson(int Person_id);
    Person findPerson(int Person_id, String lname, String fname, String adress, String email, int pole);
    ArrayList<Person> getAllPersons();

}
