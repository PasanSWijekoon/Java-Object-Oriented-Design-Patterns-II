### Real-World Example – Coffee Shop

**Scenario:**

In a coffee shop, a customer can order **simple coffee** or coffee with **extra ingredients** (milk, sugar, whipped cream, etc.).

Each topping adds a **cost** and modifies the **description**.

### Class Diagram

```mermaid
classDiagram
    interface Coffee {
        <<interface>>
        +double cost()
        +String description()
    }

    class SimpleCofee {
        +double cost()
        +String description()
    }

    class CofeeDecorator {
        <<abstract>>
        #Coffee cofee
        +CofeeDecorator(Coffee cofee)
    }

    class MilkDecorator {
        +MilkDecorator(Coffee cofee)
        +double cost()
        +String description()
    }

    class SugarDecorator {
        +SugarDecorator(Coffee cofee)
        +double cost()
        +String description()
    }
    
    class Decorator {
        +main(String[] args)
    }
    
    Coffee <|.. SimpleCofee : implements
    Coffee <|.. CofeeDecorator : implements
    CofeeDecorator <|-- MilkDecorator : extends
    CofeeDecorator <|-- SugarDecorator : extends
    CofeeDecorator "1" *-- "1" Coffee : has a
    MilkDecorator "1" *-- "1" Coffee : has a
    SugarDecorator "1" *-- "1" Coffee : has a
    
    
```