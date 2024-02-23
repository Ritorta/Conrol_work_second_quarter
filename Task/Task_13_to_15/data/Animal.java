package Task.Task_13_to_15.data;
public abstract class Animal {

    protected final int id;
    protected String animal_type;

    public Animal(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public abstract void displayCommands();

    public abstract void NewCommand(String command);
}
