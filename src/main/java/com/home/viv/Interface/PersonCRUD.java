package com.home.viv.Interface;

import com.home.viv.Objects.Person;
import com.home.viv.Objects.Pole;

import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by viv on 15.06.2017.
 */
public interface PersonCRUD {

    void createPerson(String fname, String lname, String adress, String email, int pole, String ph_number);
    void editPerson(int Person_id, String lname, String fname, String adress, String email, int pole, String ph_number);
    void deletePerson(int Person_id);
    Person findPerson(int Person_id);
    //продумать! как сделать поиск по остальным параметрам??? String lname, String fname, String adress, String email, int pole, String ph_number
    ArrayList<Person> getAllPersons();

}
