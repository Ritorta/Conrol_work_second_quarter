package Task.Task_1_to_12.data;
public abstract class Animal {

    protected String id;
    protected String animal_type;

    public Animal(String id, String animal_type) {
        this.id = id;
        this.animal_type = animal_type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAnimal_type() {
        return animal_type;
    }

    public void setAnimal_type(String animal_type) {
        this.animal_type = animal_type;
    }

    public abstract void displayCommands();
}
