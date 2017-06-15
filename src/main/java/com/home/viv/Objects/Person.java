package com.home.viv.Objects;

import java.util.ArrayList;
import com.home.viv.Objects.Pole;


/**
 * Created by viv on 15.06.2017.
 */
public class Person {

    private int Person_id;
    private String Lname;
    private String Fname;
    private String Adress;
    private Pole pole;
    private ArrayList<String> phoneNum=new ArrayList<String>();

    public Person(int person_id, String lname, String fname, String adress, Pole pole, ArrayList<String> phoneNum)
    {
        Person_id = person_id;
        Lname = lname;
        Fname = fname;
        Adress = adress;
        this.pole = pole;
        this.phoneNum = phoneNum;
    }

    public int getPerson_id() {
        return Person_id;
    }

    public void setPerson_id(int person_id) {
        Person_id = person_id;
    }

    public String getLname() {
        return Lname;
    }

    public void setLname(String lname) {
        Lname = lname;
    }

    public String getFname() {
        return Fname;
    }

    public void setFname(String fname) {
        Fname = fname;
    }

    public String getAdress() {
        return Adress;
    }

    public void setAdress(String adress) {
        Adress = adress;
    }

    public Pole getPole() {
        return pole;
    }

    public void setPole(Pole pole) {
        this.pole = pole;
    }

    public ArrayList<String> getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(ArrayList<String> phoneNum) {
        this.phoneNum = phoneNum;
    }
}
