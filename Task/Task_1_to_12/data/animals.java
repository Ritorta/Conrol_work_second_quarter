package Task.Task_1_to_12.data;

public class animals {
    protected int id;
    protected String animal_type;

    public animals(int id, String animal_type) {
        this.id = id;
        this.animal_type = animal_type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnimal_type() {
        return animal_type;
    }

    public void setAnimal_type(String animal_type) {
        this.animal_type = animal_type;
    }  
}
