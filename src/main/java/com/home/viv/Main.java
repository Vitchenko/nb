package com.home.viv;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Notebook");

        Menu m=new Menu();

        m.startWork(); //connect to DB and print all persons
        m.menuDialog(); //организация зацикленного меню
    }
}
