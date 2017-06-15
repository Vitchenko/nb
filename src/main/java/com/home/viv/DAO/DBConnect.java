package com.home.viv.DAO;

import com.home.viv.Main;

import java.sql.*;
import java.util.Locale;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by viv on 14.06.2017.
 */
public class DBConnect {

    public Statement openDb(String url, String name, String password) {

        Connection connection = null;
        Locale.setDefault(Locale.ENGLISH);

        try {
            //load driver
            Class.forName("oracle.jdbc.driver.OracleDriver");
            //create connect
            connection = DriverManager.getConnection(url, name, password);
            Statement statement = null;
            statement = connection.createStatement();

            return statement;

        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }

    }

    public boolean closeDb(Statement st){

        try{
            st.close();
            return true;

        } catch (SQLException ex) {
            //выводим наиболее значимые сообщения
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }











    public void GetEmpId(Statement stm) {
        Throwable ex;

        System.out.println("Insert number of person? + <Enter>");

        Scanner in = new Scanner(System.in);
        int EmpId = in.nextInt();


        String sqstr ="SELECT E.EMPLOYEE_ID, E.LAST_NAME,E.FIRST_NAME, E.SALARY, E.EMAIL, E.PHONE_NUMBER, " +
                "D.DEPARTMENT_NAME, L.CITY FROM EMPLOYEES E, DEPARTMENTS D, LOCATIONS L WHERE " +
                "E.EMPLOYEE_ID="+ EmpId +" AND E.DEPARTMENT_ID=D.DEPARTMENT_ID AND D.LOCATION_ID=L.LOCATION_ID";

        try {
            ResultSet result1 = stm.executeQuery(sqstr);
            while (result1.next()) {

                System.out.println("Информация о сотрулнике Таб Номер: " + EmpId);
                System.out.println("Фамилия: " + result1.getString("LAST_NAME"));
                System.out.println("Имя: " + result1.getString("FIRST_NAME"));
                System.out.println("Зарплата: " + result1.getDouble("SALARY"));
                System.out.println("Подразделение: " + result1.getString("DEPARTMENT_NAME"));
                System.out.println("EMail: " + result1.getString("EMAIL"));
                System.out.println("Телефон: " + result1.getString("PHONE_NUMBER"));
                System.out.println("В городе: " + result1.getString("CITY"));
            }


        } catch (SQLException Ex) {
            //выводим наиболее значимые сообщения
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, Ex);

        }

    }

    public void addNewEmployee(Statement st) throws SQLException {

        Scanner scanner= new Scanner(System.in);

        System.out.println("Для добавления нового сотрулника введите следующие параметры:");
        //in.nextLine();
        System.out.println("Фамилия:");
        String firstName = scanner.nextLine();
        System.out.println("Имя:");
        String lastName = scanner.nextLine();
        System.out.println("Email:");
        String email = scanner.nextLine();
        System.out.println("Телефон:");
        String phone = scanner.nextLine();
        System.out.println("Зарплата:");
        Double Salary = scanner.nextDouble();

        String sqlstr="INSERT INTO Employees (EMPLOYEE_ID, FIRST_NAME , LAST_NAME, EMAIL, PHONE_NUMBER, " +
                "HIRE_DATE, JOB_ID, SALARY, COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) " +
                "VALUES(Employees_sc.nextval, '" +firstName+ "','"+lastName+"','"+email+"','"+phone+"', " +
                "SYSDATE-10,'IT_PROG',"+Salary+", 0.1, 100, 100)";

        try {
            //System.out.println(sqlstr);
            st.executeUpdate(sqlstr);
            System.out.println("Новый сотрудник успешно добавлен");
            System.out.println();
        }
        catch (SQLException Ex) {

            //Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, Ex);
            System.out.println(Ex);
        }





    }

    public void deleteEmployeeById(Statement st) throws SQLException {
        System.out.println("Тест УДАЛЕН СОТРУЛНИК");
        //DELETE FROM EMPLOYEES WHERE EMPLOYEE_ID=550;

        Scanner scanner= new Scanner(System.in);

        System.out.println("Для удаления сотрулника введите его табельный номер:");
        int Employee_id = scanner.nextInt();


        String sqlstr="DELETE FROM EMPLOYEES WHERE EMPLOYEE_ID=" + Employee_id;

        try {

            st.executeUpdate(sqlstr);
            System.out.println("Сотрудник, табельный номер: " + Employee_id + " удален");
            System.out.println();
        }
        catch (SQLException Ex) {
            //выводим наиболее значимые сообщения
            //Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, Ex);
            System.out.println(Ex);
        }

    }

}
