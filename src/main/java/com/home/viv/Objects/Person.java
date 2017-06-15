package com.home.viv.Objects;

import java.util.ArrayList;
import com.home.viv.Objects.Pole;


/**
 * Created by viv on 15.06.2017.
 */
public class Person {

    private int person_id;
    private String fname;
    private String lname;
    private String adress;
    private String email;
    private int pole;

    public Person(int person_id, String fname, String lname, String adress, String email, int pole) {
        this.person_id = person_id;
        this.fname = fname;
        this.lname = lname;
        this.adress = adress;
        this.email = email;
        this.pole = pole;
    }

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPole() {
        return pole;
    }

    public void setPole(int pole) {
        this.pole = pole;
    }

    @Override
    public String toString() {
        return "Person{" +
                "person_id=" + person_id +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", adress='" + adress + '\'' +
                ", email='" + email + '\'' +
                ", pole=" + pole +
                '}';
    }
}
