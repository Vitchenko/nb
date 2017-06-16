package com.home.viv;

import com.home.viv.DAO.DBConnect;
import com.home.viv.DAO.OraCRUD;
import com.home.viv.Objects.Person;
import com.sun.org.apache.xpath.internal.SourceTree;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by viv on 14.06.2017.
 */
public class Menu {

    DBConnect dbConnect = new DBConnect();

    OraCRUD oraCRUD;
    Statement st;


    public void startWork(){
        st = dbConnect.openDb("jdbc:oracle:thin:@localhost:1521:XE", "nb", "nb");
        oraCRUD=new OraCRUD(st);

    }

    public void printHeader() {
        //печатает заголовок меню
        System.out.println("");
        System.out.println("(1) List all persons <1 + Enter> ");
        System.out.println("(2) All information about person for id <2 + Enter>");
        System.out.println("(3) Insert Person <3 + Enter> ");
        System.out.println("(4) Delete Person <4 + Enter> ");
        System.out.println("(5) Update Person <5 + Enter> ");
        System.out.println("(0) Exit program  <0 + Enter> ");
        System.out.println("");
    }

    public void menuDialog() {

        boolean isEnd = false;
        Scanner in = new Scanner(System.in);
        ArrayList<Person> persons=new ArrayList<Person>();

        while (!isEnd) {
            this.printHeader();
            try {
                System.out.println("Insert Number:");
                int s = in.nextInt();
                switch (s) {
                    case 1:
                        persons=oraCRUD.getAllPersons();
                        printPersonList(persons);
                        break;
                    case 2:
                        System.out.println("Insert PERSON_ID:");
                        int id = in.nextInt();
                        System.out.println(oraCRUD.findPerson(id));
                        break;
                    case 3:
                        String ff = in.nextLine();//очистака буфера
                        System.out.println("For create new person insert all parameters:");
                        System.out.println("Family Name:");
                        String fname = in.nextLine();
                        System.out.println("Last Name:");
                        String lname = in.nextLine();
                        System.out.println("Adress:");
                        String adress = in.nextLine();
                        System.out.println("Email:");
                        String email = in.nextLine();
                        System.out.println("Phone:");
                        String phone = in.nextLine();
                        System.out.println("Pole (1- Male| 2- Female):");
                        int pole = Integer.parseInt(in.nextLine());
                        oraCRUD.createPerson(fname,lname,adress,email,pole,phone);
                        System.out.println("Successfully create person " + fname +" "+ lname);
                        break;

                    case 4:
                        System.out.println("Insert number of deleted people&:");
                        s = in.nextInt();
                        oraCRUD.deletePerson(s);
                        break;
                    case 0:
                        System.out.println("Exit Program!!!");
                        dbConnect.closeDb(st);
                        isEnd = true;
                }
            } catch (Exception e) {
                System.out.println("Error" + e);
            } finally {
                System.out.println();
                in.nextLine();
            }
        }

    }

    void printPersonList(ArrayList<Person> persons){
        for(int i=0; i < persons.size(); i++ ){
            System.out.println(persons.get(i));

        }
    }

}