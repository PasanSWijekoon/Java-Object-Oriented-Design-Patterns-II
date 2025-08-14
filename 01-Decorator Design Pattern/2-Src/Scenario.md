### Real-World Example – Coffee Shop

**Scenario:**

In a coffee shop, a customer can order **simple coffee** or coffee with **extra ingredients** (milk, sugar, whipped cream, etc.).

Each topping adds a **cost** and modifies the **description**.

### Class Diagram

```mermaid
classDiagram
    direction LR
    interface Coffee {
        <<interface>>
        +cost(): double
        +description(): String
    }
    class SimpleCofee {
        +cost(): double
        +description(): String
    }
    abstract class CofeeDecorator {
        <<abstract>>
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

    SimpleCofee ..|> Coffee
    CofeeDecorator ..|> Coffee
    CofeeDecorator "1" *-- "1" Coffee : cofee
    MilkDecorator --|> CofeeDecorator
    SugarDecorator --|> CofeeDecorator
    
    
```