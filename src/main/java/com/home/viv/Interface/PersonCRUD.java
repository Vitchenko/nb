package com.home.viv.Interface;

import com.home.viv.Objects.Person;
import com.home.viv.Objects.Pole;

import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by viv on 15.06.2017.
 */
public interface PersonCRUD {
    void createPerson(Statement statement, String Lname, String Fame, String Fname, String Adress, Pole pole, ArrayList<String> phoneNum);
    void editPerson(Statement statement, int Person_id, String Lname, String Fame, String Fname,String Adress, Pole pole, ArrayList<String> phoneNum);
    void DeletePerson(Statement statement, int Person_id);
    Person FindPerson(Statement statement, int Person_id, String Lname, String Fame, String Fname, String Adress, Pole pole, ArrayList<String> phoneNum);
    ArrayList<Person> GetAllPerson(Statement statement);

}
