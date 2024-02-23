package Task.Task_12_to_15.controller;

import java.util.Scanner;

import Task.Task_12_to_15.data.Camel;
import Task.Task_12_to_15.data.Cat;
import Task.Task_12_to_15.data.Dog;
import Task.Task_12_to_15.data.Donkey;
import Task.Task_12_to_15.data.Hamster;
import Task.Task_12_to_15.data.HomeAnimals;
import Task.Task_12_to_15.data.Horse;
import Task.Task_12_to_15.data.PackAnimals;
import Task.Task_12_to_15.service.ServiceDatabase;

import java.util.InputMismatchException;

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
                System.out.println("1. Show all animals in the registry");
                System.out.println("2. Add new animal");
                System.out.println("3. Add new command to animal");
                System.out.println("4. Show list of commands for animal");
                System.out.println("5. Exit");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1: servicedatabase.displayAllAnimals();
                    case 2: addNewAnimal();
                    case 3: NewCommand();
                    case 4: displayAnimalCommands();
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

    private void addNewAnimal() {
        System.out.println("Enter type animal, 1 - Home Animals, 2 - Pack Animals");
        String type = scanner.nextLine();
        
        if(type.equals("1")){
        System.out.println("Enter id animal:");
		String id = scanner.nextLine();
        System.out.println("Enter name animal:");
		String name = scanner.nextLine();
        System.out.println("Enter color animal:");
		String color = scanner.nextLine();
        System.out.println("Enter date_birth animal:");
		String date_birth = scanner.nextLine();
		System.out.println("Enter command animal:");
		String commands = scanner.nextLine();

		System.out.println("Select animals to add: ");
		System.out.println("1. Dog");
		System.out.println("2. Cat");
		System.out.println("3. Hamster");
		int animalClass = scanner.nextInt();
		scanner.nextLine();

		HomeAnimals homeAnimal;
		switch (animalClass) {
			case 1 -> homeAnimal = new Dog(id, name, color, commands, null, commands);
			case 2 -> homeAnimal = new Cat(id, name, color, date_birth, null, commands);
			case 3 -> homeAnimal = new Hamster(id, name, color, date_birth, null, commands);
			default -> {
				System.out.println("Error incorect select");
				return;
			}
        }

        servicedatabase.addAnimal(homeAnimal);
		System.out.println("Animal added to the database");

        } else if(type.equals("2")){
        System.out.println("Enter id animal:");
		String id = scanner.nextLine();
        System.out.println("Enter name animal:");
		String name = scanner.nextLine();
        System.out.println("Enter color animal:");
		String color = scanner.nextLine();
        System.out.println("Enter date_birth animal:");
		String date_birth = scanner.nextLine();
		System.out.println("Enter command animal:");
		String commands = scanner.nextLine();

		System.out.println("Select animals to add: ");
		System.out.println("4. Donkey");
		System.out.println("5. Horse");
        System.out.println("6. Horse");
		int animalClass = scanner.nextInt();
		scanner.nextLine();
        PackAnimals packAnimal;
		switch (animalClass) {

            case 4 -> packAnimal = new Donkey(id, name, color, date_birth, null, commands);
			case 5 -> packAnimal = new Horse(id, name, color, date_birth, null, commands);
            case 6 -> packAnimal = new Camel(id, name, color, date_birth, null, commands);
            default -> {
				System.out.println("Error incorect select");
				return;
			}
		}

		servicedatabase.addAnimal(packAnimal);
		System.out.println("Animals complete to add database");
        } else {
        System.out.println("Error incorrect select type of animal");
        }

    }

    private void displayAnimalCommands() {
		System.out.println("Enter id animals: ");
		String id = scanner.nextLine();

        ServiceDatabase serviceDatabase = new ServiceDatabase();
		serviceDatabase.displayAnimalCommands(id);
	}

    private void NewCommand() {
		System.out.println("Enter id animal:");
		String id = scanner.nextLine();
		System.out.println("Enter new commands:");
		String command = scanner.nextLine();

		servicedatabase.NewCommand(id, command);
		System.out.println("Commands add sucess.");
	}
}