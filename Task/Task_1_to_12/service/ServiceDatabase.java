package Task.Task_1_to_12.service;
import Task.Task_1_to_12.data.Animal;
import Task.Task_1_to_12.data.HomeAnimals;
import Task.Task_1_to_12.data.PackAnimals;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ServiceDatabase {

    private List<Animal> animals;
    private static String fileParh = "data/Database.txt";

    public ServiceDatabase(){
        animals = new ArrayList<>();
        
    }

    private void saveDatabase(){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileParh))) {
            for(Animal animal : animals) {
                String className = animal.getAnimal_type();
                
                if (animal instanceof HomeAnimals) {
                    HomeAnimals homeAnimal = (HomeAnimals) animal;
                    String line = "HomeAnimal," + homeAnimal.getName() + "," + homeAnimal.getColor() + "," + homeAnimal.getDate_birth() + "," +
                    String.join(",", homeAnimal.getCommands());
                    writer.write(line);
                } else if (animal instanceof PackAnimals) {
                    PackAnimals packAnimal = (PackAnimals) animal;
                    String line = "PackAnimal," + packAnimal.getName() + "," + packAnimal.getColor() + "," + packAnimal.getDate_birth() + "," +
                    String.join(",", packAnimal.getCommands());
                    writer.write(line);
                } else {
                    System.out.println("Incorrect animal type: " + className);
                }  
            }
        } catch (IOException e) {
            System.out.println("Error save Database: " + e.getMessage());
        }
    }
    
    public void addAnimal(Animal animal){
        animals.add(animal);
        saveDatabase();
    }

    public void displayAnimalCommands(String id) {
        for (Animal animal : animals) {
        if (animal.getId().equals(id)) {
                animal.displayCommands();
                return;
            }
        }
        System.out.println("Amimals id " + id + " not found.");
    }
    
}
