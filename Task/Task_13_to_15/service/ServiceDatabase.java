package Task.Task_13_to_15.service;

import Task.Task_13_to_15.data.Animal;
import Task.Task_13_to_15.data.Camel;
import Task.Task_13_to_15.data.Cat;
import Task.Task_13_to_15.data.Dog;
import Task.Task_13_to_15.data.Donkey;
import Task.Task_13_to_15.data.Hamster;
import Task.Task_13_to_15.data.HomeAnimals;
import Task.Task_13_to_15.data.Horse;
import Task.Task_13_to_15.data.PackAnimals;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.Date;
import java.util.HashSet;

public class ServiceDatabase {

    private final List<Animal> animals;
    private static final String filePath = "Task/Task_13_to_15/data/Database.txt";
	// Вызов загрузки базы данных
    public ServiceDatabase(){
        animals = new ArrayList<>();
        loadDatabase();      
    }
	// Вызов сохранения базы данных
	public void addAnimal(Animal animal){
        animals.add(animal);
		saveDatabase(); // New.
    }
	/*  Новая версия метода saveDatabase,
	Внесены следующие изменения:
	 - Реализована красивая таблица
	*/
	private void saveDatabase() {
    try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        Set<Integer> uniqueIds = new HashSet<>();

        String header = String.format("%-15s %-5s %-18s %-20s %-15s %-20s", "Animal Type", "ID", "Name", "Color", "Date of Birth", "Commands");
        writer.println(header);

        for (Animal animal : animals) {
            String className = animal.getClass().getSimpleName();
            int id = animal.getId();

            if (!uniqueIds.add(id)) {
                System.out.println("Error: Duplicate ID " + id + " found. Skipping animal.");
                continue;
            }

            if (animal instanceof HomeAnimals) {
                HomeAnimals homeAnimal = (HomeAnimals) animal;
                String line = String.format("%-15s %-5d %-18s %-20s %-15s %-20s", className, id, homeAnimal.getName(), homeAnimal.getColor(), sdf.format(homeAnimal.getDate_birth()),
                        String.join(" ", homeAnimal.getCommands()));
                writer.println(line);
            } else if (animal instanceof PackAnimals) {
                PackAnimals packAnimal = (PackAnimals) animal;
                String line = String.format("%-15s %-5d %-18s %-20s %-15s %-20s", className, id, packAnimal.getName(), packAnimal.getColor(), sdf.format(packAnimal.getDate_birth()),
                        String.join(" ", packAnimal.getCommands()));
                writer.println(line);
            } else {
                System.out.println("Incorrect animal type: " + className);
            }
        }
        System.out.println("Database save complete.");
		} catch (IOException e) {
			System.out.println("Error saving database: " + e.getMessage());
		}
	}
	/*  Новая версия метода loadDatabase,
	Внесены следующие изменения:
	 - Чтение с пробелами
	*/
	private void loadDatabase() {
		try (Scanner scanner = new Scanner(new File(filePath))) {
			animals.clear();
			scanner.nextLine();

			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] data = line.split("\\s+");
		
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
					String commands = String.join(" ", Arrays.copyOfRange(data, 5, data.length));
		
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
			}
			System.out.println("Database load complete.");
		} catch (FileNotFoundException e) {
			System.out.println("Database file not found.");
		
		}
	}
	/* Новая версия метода NewCommand,
	- Сохранение без дублирования пробелов.
	- Добавляет пробел после запятой в самом начале.
	*/
	public void NewCommand(int id, String command) {
		for (Animal animal : animals) {
			if (animal.getId() == id) {
				String[] commands = command.split(", ");
				for (int i = 0; i < commands.length; i++) {
					String trimmedCommand = commands[i].trim();
					commands[i] = trimmedCommand;
				}
				animal.NewCommand(" " + String.join(", ", commands));
				saveDatabase(); // New.
				System.out.println("Commands add sucess.");
				return;
			}
		}
		System.out.println("Animals id " + id + " not found.");
	}
	// Вывод списка всех животных
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
	// Вывод списка команд животного по id
	public void displayAnimalCommands(int id) {
		for (Animal animal : animals) {
			if (animal.getId() == id) {
				animal.displayCommands();
				return;
			}
		}
		System.out.println("Animal with ID " + id + " not found.");
	}
}