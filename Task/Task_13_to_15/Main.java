package Task.Task_13_to_15;

import Task.Task_13_to_15.controller.DataController;
import Task.Task_13_to_15.service.ServiceDatabase;

public class Main {
    
    public static void main(String[] args) {
        ServiceDatabase database = new ServiceDatabase();
        DataController menu = new DataController(database);
        menu.consoleMenu();
    }

}
