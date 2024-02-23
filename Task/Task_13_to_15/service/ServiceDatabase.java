package Task.Task_13_to_15.service;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Date;

import Task.Task_13_to_15.data.Animal;
import Task.Task_13_to_15.data.Camel;
import Task.Task_13_to_15.data.Cat;
import Task.Task_13_to_15.data.Dog;
import Task.Task_13_to_15.data.Donkey;
import Task.Task_13_to_15.data.Hamster;
import Task.Task_13_to_15.data.HomeAnimals;
import Task.Task_13_to_15.data.Horse;
import Task.Task_13_to_15.data.PackAnimals;


public class ServiceDatabase {

    private final List<Animal> animals;
    private static final String filePath = "Task/Task_13_to_15/data/Database.txt";
    

    public ServiceDatabase(){
        animals = new ArrayList<>();
        loadDatabase();
        
    }

    // private void saveDatabase(){
    //     try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
    //         for(Animal animal : animals) {
    //             int id = animal.getId();
                
    //             if (animal instanceof HomeAnimals) {
    //                 HomeAnimals homeAnimal = (HomeAnimals) animal;
    //                 String line = "HomeAnimal id: " + id + ", " + homeAnimal.getName() + ", " + homeAnimal.getColor() + ", " + homeAnimal.getDate_birth() + ", " +
    //                 String.join(",", homeAnimal.getCommands());
    //                 writer.write(line);
	// 				writer.newLine();
    //             } else if (animal instanceof PackAnimals) {
    //                 PackAnimals packAnimal = (PackAnimals) animal;
    //                 String line = "PackAnimal," + id + ", " + packAnimal.getName() + ", " + packAnimal.getColor() + ", " + packAnimal.getDate_birth() + ", " +
    //                 String.join(",", packAnimal.getCommands());
    //                 writer.write(line);
	// 				writer.newLine();
    //             } else {
    //                 System.out.println("Incorrect animal type: " + id);
    //             }  
    //         }
    //     } catch (IOException e) {
    //         System.out.println("Error save Database: " + e.getMessage());
    //     }
    // }
    
	private void saveDatabase() {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
			for (Animal animal : animals) {
				int id = animal.getId();
	
				if (animal instanceof HomeAnimals) {
					HomeAnimals homeAnimal = (HomeAnimals) animal;
					String line = "HomeAnimal," + id + ", " + homeAnimal.getName() + ", " + homeAnimal.getColor() + ", " + homeAnimal.getDate_birth() + ", " +
							String.join(",", homeAnimal.getCommands());
					writer.write(line);
					writer.newLine();
				} else if (animal instanceof PackAnimals) {
					PackAnimals packAnimal = (PackAnimals) animal;
					String line = "PackAnimal," + id + ", " + packAnimal.getName() + ", " + packAnimal.getColor() + ", " + packAnimal.getDate_birth() + ", " +
							String.join(",", packAnimal.getCommands());
					writer.write(line);
					writer.newLine();
				} else {
					System.out.println("Incorrect animal type: " + id);
				}
			}
			System.out.println("Database save complete.");
		} catch (IOException e) {
			System.out.println("Error saving database: " + e.getMessage());
		}
	}

    private void loadDatabase() {
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] data = line.split(",");
				if (data.length >= 6) {
					String className = data[0];
                    int id = Integer.parseInt(data[1]);
					String name = data[2];
                    String color = data[3];
                    Date date_birth;
                try {
                    date_birth = new SimpleDateFormat("dd.MM.yyyy").parse(data[4]);
                } catch (ParseException e) {
                    System.out.println("Error parsing date: " + data[4]);
                    continue;
                }
					String commands = String.join(",", Arrays.copyOfRange(data, 6, data.length));

					Animal animal;
					switch (className) {
						case "Dog" -> animal = new Dog(id, name, color, date_birth, commands);
						case "Cat" -> animal = new Cat(id, name, color, date_birth, commands);
						case "Hamster" -> animal = new Hamster(id, name, color, date_birth, commands);

                        case "Camel" -> animal = new Camel(id, name, color, date_birth, commands);
						case "Donkey" -> animal = new Donkey(id, name, color, date_birth, commands);
						case "Horse" -> animal = new Horse(id, name, color, date_birth, commands);
						default -> {
							System.out.println("Unknown animal class: " + className);
							continue;
						}
					}
					animals.add(animal);
				} else {
					System.out.println("Invalid data in file: " + line);
				}
			}
			System.out.println("Database load complete.");
		} catch (IOException e) {
			System.out.println("Error read database: " + e.getMessage());
		}
	}

    public void addAnimal(Animal animal){
        animals.add(animal);
        saveDatabase();
    }

    public void displayAnimalCommands(int id) {
        for (Animal animal : animals) {
        if (animal.getId() == id) {
                animal.displayCommands();
                return;
            }
        }
        System.out.println("Amimals id " + id + " not found.");
    }
    
    public void displayAllAnimals() {
		try {
			File file = new File(filePath);
			Scanner fileScanner = new Scanner(file);

			while (fileScanner.hasNextLine()) {
				String animalData = fileScanner.nextLine();
				System.out.println(animalData);
			}

			fileScanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("DataBase file not found.");
		}
	}

    public void NewCommand(int id, String command) {
		for (Animal animal : animals) {
			if (animal.getId() == id) {
				String[] commands = command.split(",");
				for (int i = 0; i < commands.length; i++) {
					String trimmedCommand = commands[i].trim();
					commands[i] = trimmedCommand;
				}
				animal.NewCommand(command);
				saveDatabase();
				System.out.println("Commands add sucess.");
				return;
			}
		}
		System.out.println("Animals id " + id + " not found.");
	}

    	

}
