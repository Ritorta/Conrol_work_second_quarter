package Task.Task_1_to_12.data;

import java.sql.Date;
import java.util.List;

public abstract class home_animals extends animals
{
    private String name;
    private String color;
    private Date date_birth;
    private List<String> commands;

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

    public List<String> getCommands() {
        return commands;
    }

    public void setCommands(List<String> commands) {
        this.commands = commands;
    }

  
    

   
    
}
