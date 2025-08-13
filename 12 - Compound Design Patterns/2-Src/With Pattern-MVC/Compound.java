import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update();
}

class studentModel{
    private String name;
    private int age;
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

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}

//View

class StudentView implements Observer {
    private studentModel model;

    public StudentView(studentModel model) {
        this.model = model;
        this.model.addObserver(this);
    }

    public void displaystudent() {
        System.out.println("====Student Details====");
        System.out.println("Name: " + model.getName());
        System.out.println("Age: " + model.getAge());
        System.out.println("=======================");
    }

    @Override
    public void update() {
        displaystudent();
    }
}


//controller(Strategy pattern)

interface ActionStrategy {
    void execute(studentModel model,String name ,int age);
}

class AddStudentAction implements ActionStrategy {
    @Override
    public void execute(studentModel model, String name, int age) {
        System.out.println("[Controller] Adding new student...");
        model.setStudentData(name, age);
        model.notifyObservers();
    }
}

class UpdatestudentAction implements ActionStrategy {
    @Override
    public void execute(studentModel model, String name, int age) {
        System.out.println("[Controller] Updating student data...");
        model.setStudentData(name, age);
        model.notifyObservers();
    }
}

class studentController{
    private ActionStrategy actionStrategy;
    private studentModel model;

    public studentController(ActionStrategy actionStrategy, studentModel model) {
        this.actionStrategy = actionStrategy;
        this.model = model;
    }

    public void setActionStrategy(ActionStrategy actionStrategy) {
        this.actionStrategy = actionStrategy;
    }

    public void handleRequest(String name, int age) {
        actionStrategy.execute(model, name, age);
    }

}

public class Compound {
    public static void main(String[] args) {

        studentModel model = new studentModel();
        StudentView view = new StudentView(model);
        studentController controller = new studentController(new AddStudentAction(), model);
        controller.handleRequest("John Doe", 20); // Adding a new student
        controller.setActionStrategy(new UpdatestudentAction());
        controller.handleRequest("John Doe", 21); // Updating the student's age

    }
}