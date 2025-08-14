### Real-World Example – Coffee Shop

**Scenario:**

In a coffee shop, a customer can order **simple coffee** or coffee with **extra ingredients** (milk, sugar, whipped cream, etc.).

Each topping adds a **cost** and modifies the **description**.

### Class Diagram

```mermaid
classDiagram
    direction LR
    %% Coffee is an interface
    class Coffee {
        +cost(): double
        +description(): String
    }
    class SimpleCofee {
        +cost(): double
        +description(): String
    }
    %% CofeeDecorator is an abstract class
    class CofeeDecorator {
        #cofee: Coffee
    }
    class MilkDecorator {
        +cost(): double
        +description(): String
    }
    class SugarDecorator {
        +cost(): double
        +description(): String
    }

    Coffee <|.. SimpleCofee
    Coffee <|.. CofeeDecorator
    CofeeDecorator "1" *-- "1" Coffee : cofee
    CofeeDecorator <|-- MilkDecorator
    CofeeDecorator <|-- SugarDecorator
    
    
```