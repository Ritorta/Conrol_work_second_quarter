package Task.Task_1_to_12.controller;

import java.util.Scanner;
import java.util.InputMismatchException;
import Task.Task_1_to_12.service.ServiceDatabase;

public class DataController {
    
    private ServiceDatabase servicedatabase;
    private Scanner scanner;

    public DataController(ServiceDatabase servicedatabase){
        this.servicedatabase = servicedatabase;
        scanner = new Scanner(System.in);
    }

    public void consoleMenu() {
        while(true) {
            try {
                System.out.println("Menu: ");
                System.out.println("1. Show all animals in the registry.");
                System.out.println("2. Add new animal.");
                System.out.println("3. Add new command to animal.");
                System.out.println("4. Show list of commands for animal.");
                System.out.println("5. Exit.");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1: 
                    case 2: 
                    case 3: 
                    case 4:
                    case 5: System.out.println("Goodbye"); 
                        return;
                    default: System.out.println("Error: Incorrect choice");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Incorrect enter");
				scanner.nextLine();
            }
        }
    
    }


}
