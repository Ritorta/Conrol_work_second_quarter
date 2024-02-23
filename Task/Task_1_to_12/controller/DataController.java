package Task.Task_1_to_12.controller;

import java.util.Scanner;

import Task.Task_1_to_12.service.Database;

import java.util.InputMismatchException;

public class DataController {

    private Database database;
    private Scanner scanner;

    public DataController(Database database){
        this.database = database;
        scanner = new Scanner(System.in);
    }



    public void consoleMenu() {
        System.out.println("Menu: ");
        System.out.println("1. Show all animals in the registry.");
        System.out.println("2. Add new animal.");
        System.out.println("3. Add new command to animal.");
        System.out.println("4. Show list of commands for animal.");
        System.out.println("5. Exit.");
}
}
