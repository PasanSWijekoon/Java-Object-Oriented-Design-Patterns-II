import java.util.ArrayList;
import java.util.List;

//Visitor Interface
interface ClientVisitor {
    void visit(BusinessClient businessClient);

    void visit(IndividualClient individualClient);
}

// Element Interface
interface ClientElement {
    void accept(ClientVisitor visitor);
}

// Concrete Visitors
class ReportGeneratorVisitor implements ClientVisitor {
    @Override
    public void visit(BusinessClient businessClient) {
        System.out.println(
                "Generating report for: " + businessClient.getName() + " with revenue: " + businessClient.getRevenue());
    }

    @Override
    public void visit(IndividualClient individualClient) {
        System.out.println(
                "Generating report for: " + individualClient.getName() + " with age: " + individualClient.getAge());
    }
}

class PremiumCalculatorVisitor implements ClientVisitor {
    @Override
    public void visit(BusinessClient businessClient) {
        double premium = businessClient.getRevenue() * 0.001 + businessClient.getEmployees() * 50;
        System.out.println("Calculating premium for: " + businessClient.getName() + " with premium: " + premium);
    }

    @Override
    public void visit(IndividualClient individualClient) {
        double premium;
        if (individualClient.getAge() < 30) {
            premium = 300;
        } else {
            premium = 500;
        }
        System.out.println(
                "Calculating Individual premium for: " + individualClient.getName() + " with premium: " + premium);
    }
}

// Concrete Elements
class BusinessClient implements ClientElement {
    private String name;
    private double revenue;
    private int employees;

    public BusinessClient(String name, double revenue, int employees) {
        this.name = name;
        this.revenue = revenue;
        this.employees = employees;
    }

    public String getName() {
        return name;
    }

    public double getRevenue() {
        return revenue;
    }

    public int getEmployees() {
        return employees;
    }

    @Override
    public void accept(ClientVisitor visitor) {
        visitor.visit(this);
    }
}

class IndividualClient implements ClientElement {
    private String name;
    private int age;

    public IndividualClient(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public void accept(ClientVisitor visitor) {
        visitor.visit(this);
    }
}

public class Visitor {
    public static void main(String[] args) {
        List<ClientElement> clients = new ArrayList<>();
        clients.add(new BusinessClient("ABC Corp", 1000000, 50));
        clients.add(new IndividualClient("John Doe", 28));

        ClientVisitor reportGenerator = new ReportGeneratorVisitor();
        ClientVisitor premiumCalculator = new PremiumCalculatorVisitor();

        for (ClientElement client : clients) {
            client.accept(reportGenerator);
            client.accept(premiumCalculator);
        }
    }
}