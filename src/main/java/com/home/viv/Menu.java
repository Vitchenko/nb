package com.home.viv;

import com.home.viv.DAO.DBConnect;

import java.sql.Statement;
import java.util.Scanner;

/**
 * Created by viv on 14.06.2017.
 */
public class Menu {

    DBConnect dao = new DBConnect();
    Main m = new Main();
    Statement st;


    public void startWork(){
        st = dao.openDb("jdbc:oracle:thin:@localhost:1521:XE", "nb", "nb");
//        dao.GetAllPep(st);

    }

    public void printHeader() {
        //печатает заголовок меню
        System.out.println("");
        System.out.println("(1) All information about person (press) <1 + Enter>");
        System.out.println("(2) Insert Person <2 + Enter> ");
        System.out.println("(3) Delete Person <3 + Enter> ");
        System.out.println("(4) List all persons <4 + Enter> ");
        System.out.println("(0) Exit program  <0 + Enter> ");
        System.out.println("");
    }

    public void menuDialog() {

        boolean isEnd = false;
        Scanner in = new Scanner(System.in);


        while (!isEnd) {
            this.printHeader();
            try {
                System.out.println("Insert Number:");
                int s = in.nextInt();
                switch (s) {
                    case 1:
                        dao.GetEmpId(st);
                        break;
                    case 2:
                        dao.addNewEmployee(st);
                        break;
                    case 3:
                        dao.deleteEmployeeById(st);
                        break;
                    case 4:
                        dao.GetAllPep(st);
                        break;
                    case 0:
                        System.out.println("Программа завершена");
                        dao.closeDb(st);
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



}