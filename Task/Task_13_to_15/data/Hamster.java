package Task.Task_13_to_15.data;

import java.sql.Date;

public class Hamster extends HomeAnimals {
    
    public Hamster(String id, String animal_type, String name, String color, Date date_birth, String commands) {
        super(id, animal_type, name, color, date_birth, commands);
    }

    @Override
    public String toString() {
        return "Hamster: " + " Animal type: " + animal_type + " Name: " + name + " Color: " + color + 
        " Date birthsday: " + date_birth + " Commands: " + commands;
    }

    @Override
	public void displayCommands() {
		System.out.println("Commands for Hamster " + getName() + ": " + getCommands());
	}
    
    @Override
    public void NewCommand(String command) {
		String updatedCommads = getCommands() + "," + command;
		setCommands(updatedCommads);
	}
}
