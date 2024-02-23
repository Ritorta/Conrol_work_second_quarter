package Task.Task_1_to_12.data;

import java.sql.Date;
import java.util.List;

public class Dog extends HomeAnimals {
    
    public Dog(String animal_type, String name, String color, Date date_birth, String commands) {
        super(animal_type, name, color, date_birth, commands);
    }

    @Override
    public String toString() {
        return "Dog: " + " Animal type: " + animal_type + " Name: " + name + " Color: " + color + 
        " Date birthsday: " + date_birth + " Commands: " + commands;
    }
}
