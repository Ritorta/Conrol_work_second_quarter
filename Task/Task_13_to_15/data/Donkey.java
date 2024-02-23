package Task.Task_13_to_15.data;

import java.util.Date;

public class Donkey extends PackAnimals {
    
    public Donkey(int id, String name, String color, Date date_birth, String commands) {
        super(id, name, color, date_birth, commands);
    }

    @Override
    public String toString() {
        return "Donkey: " + " Animal type: " + animal_type + " Name: " + name + " Color: " + color + 
        " Date birthsday: " + date_birth + " Commands: " + commands;
    }

    @Override
	public void displayCommands() {
		System.out.println("Commands for Donkey " + getName() + ": " + getCommands());
	}

    @Override
    public void NewCommand(String command) {
		String updatedCommads = getCommands() + "," + command;
		setCommands(updatedCommads);
	}
}
