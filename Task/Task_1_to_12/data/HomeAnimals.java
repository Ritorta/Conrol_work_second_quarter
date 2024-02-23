package Task.Task_1_to_12.data;

import java.sql.Date;
import java.util.List;

public abstract class HomeAnimals extends Animal {
    
    protected String name;
    protected String color;
    protected Date date_birth;
    protected String commands;

    public HomeAnimals(String animal_type, String name, String color, Date date_birth, String commands) {
        super(animal_type);
        this.name = name;
        this.color = color;
        this.date_birth = date_birth;
        this.commands = commands;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Date getDate_birth() {
        return date_birth;
    }

    public void setDate_birth(Date date_birth) {
        this.date_birth = date_birth;
    }

    public String getCommands() {
        return commands;
    }

    public void setCommands(String commands) {
        this.commands = commands;
    }
}
