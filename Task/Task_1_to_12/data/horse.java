package Task.Task_1_to_12.data;

import java.sql.Date;
import java.util.List;

public class horse extends pack_animals
{
    public horse(int id, String animal_type, String name, String color, Date date_birth, List<String> commands)
    {
        super(id, animal_type, name, color, date_birth, commands);
    }

    @Override
    public String toString() {
        return "Horse Id: " + id + " Animal type: " + animal_type + " Name: " + name + " Color: " + color + 
        " Date birthsday: " + date_birth + " Commands: " + commands;
    }
    

    
}
