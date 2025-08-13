
import java.util.ArrayList;
import java.util.List;

// --- Observer Pattern ---

//The Observer interface defines the contract for objects that want to be notified of changes.
interface Observer {
    void update();
}

/**
 * The Subject (or Observable) class in the Observer pattern.
 * It holds the core data (student information) and a list of its dependents (observers).
 * It's responsible for managing observers and notifying them when its state changes.
 */
class studentModel {
    private String name;
    private int age;
    // A list to store all the registered observers.
    private List<Observer> observers = new ArrayList<>();

  
    public void setStudentData(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public String getName() {
        return name;
    }

 
    public int getAge() {
        return age;
    }

     // Registers an observer to receive notifications.
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    /**
     * Notifies all registered observers that the model's state has changed.
     * It iterates through the list and calls the 'update' method on each observer.
     */
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}

// --- MVC (Model-View-Controller) Pattern ---

// View
/**
 * The View class in the MVC pattern. It's also an Observer, so it can
 * automatically update itself when the studentModel's data changes.
 * It's responsible for displaying the student's information.
 */
class StudentView implements Observer {
    private studentModel model;

    /**
     * Constructs the view and registers itself with the model as an observer.
     * @param model The studentModel instance this view will display.
     */
    public StudentView(studentModel model) {
        this.model = model;
        // The view subscribes to the model for updates.
        this.model.addObserver(this);
    }

    /**
     * Prints the student's details to the console.
     */
    public void displaystudent() {
        System.out.println("====Student Details====");
        System.out.println("Name: " + model.getName());
        System.out.println("Age: " + model.getAge());
        System.out.println("=======================");
    }

    /**
     * The callback method for the Observer pattern.
     * This method is called by the studentModel when its data is updated.
     */
    @Override
    public void update() {
        // When the model changes, the view updates its display.
        displaystudent();
    }
}

// Controller
/**
 * The controller is the intermediary between the model and view.
 * It handles user input (represented here by method calls) and delegates actions.
 * This class uses the Strategy pattern to allow for different behaviors.
 */
// controller(Strategy pattern)

/**
 * The Strategy interface defines a common interface for all concrete action strategies.
 * This allows the controller to use different strategies interchangeably.
 */
interface ActionStrategy {
    /**
     * Executes a specific action on the studentModel.
     * @param model The studentModel to act upon.
     * @param name The name to use for the action.
     * @param age The age to use for the action.
     */
    void execute(studentModel model, String name, int age);
}

/**
 * A concrete strategy for adding a new student.
 * It sets the data and then notifies all observers (e.g., the view) of the change.
 */
class AddStudentAction implements ActionStrategy {
    @Override
    public void execute(studentModel model, String name, int age) {
        System.out.println("[Controller] Adding new student...");
        model.setStudentData(name, age);
        // Notifies all registered views that the model has changed.
        model.notifyObservers();
    }
}

/**
 * A concrete strategy for updating an existing student.
 * It sets the new data and then notifies all observers.
 */
class UpdatestudentAction implements ActionStrategy {
    @Override
    public void execute(studentModel model, String name, int age) {
        System.out.println("[Controller] Updating student data...");
        model.setStudentData(name, age);
        // Notifies all registered views that the model has changed.
        model.notifyObservers();
    }
}

/**
 * The Controller class that holds a reference to a strategy.
 * It can change its strategy at runtime, demonstrating the Strategy pattern.
 */
class studentController {
    // The controller holds a reference to the current strategy.
    private ActionStrategy actionStrategy;
    private studentModel model;

    /**
     * Constructs the controller with an initial strategy and the model.
     * @param actionStrategy The initial strategy to use.
     * @param model The studentModel to interact with.
     */
    public studentController(ActionStrategy actionStrategy, studentModel model) {
        this.actionStrategy = actionStrategy;
        this.model = model;
    }

    /**
     * Changes the current strategy at runtime.
     * @param actionStrategy The new strategy to use.
     */
    public void setActionStrategy(ActionStrategy actionStrategy) {
        this.actionStrategy = actionStrategy;
    }

    /**
     * Handles a request by executing the current strategy.
     * @param name The name to pass to the strategy.
     * @param age The age to pass to the strategy.
     */
    public void handleRequest(String name, int age) {
        // The controller delegates the action to the current strategy.
        actionStrategy.execute(model, name, age);
    }
}

/**
 * The main class to demonstrate the combined design patterns.
 * This class sets up the MVC components and orchestrates the interactions.
 */
public class Compound {
    public static void main(String[] args) {

        // 1. Setup the Model, View, and Controller.
        // The model holds the data.
        studentModel model = new studentModel();
        // The view displays the model's data and registers as an observer.
        StudentView view = new StudentView(model);
        // The controller is created with an initial 'add' strategy.
        studentController controller = new studentController(new AddStudentAction(), model);

        // 2. Perform actions via the controller.
        // The controller uses the 'AddStudentAction' strategy to add a new student.
        // This action updates the model, which then notifies the view to update its display.
        controller.handleRequest("John Doe", 20); // Adding a new student

        // 3. Change the controller's strategy at runtime.
        // The controller is now configured to use the 'UpdateStudentAction'.
        controller.setActionStrategy(new UpdatestudentAction());

        // 4. Perform another action with the new strategy.
        // The controller uses the 'UpdatestudentAction' to change the student's age.
        // This action also updates the model and triggers the view to update.
        controller.handleRequest("John Doe", 21); // Updating the student's age

        // Explicitly use the view variable to display the student details
        view.displaystudent();
    }
}