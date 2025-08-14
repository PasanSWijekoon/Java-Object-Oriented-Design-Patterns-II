### Real-World Example – Coffee Shop

**Scenario:**

In a coffee shop, a customer can order **simple coffee** or coffee with **extra ingredients** (milk, sugar, whipped cream, etc.).

Each topping adds a **cost** and modifies the **description**.

### Class Diagram

```plantuml
@startuml
interface Coffee {
  + cost(): double
  + description(): String
}

class SimpleCofee implements Coffee {
  + cost(): double
  + description(): String
}

abstract class CofeeDecorator implements Coffee {
  # cofee: Coffee
  + CofeeDecorator(cofee: Coffee)
}

class MilkDecorator extends CofeeDecorator {
  + MilkDecorator(cofee: Coffee)
  + cost(): double
  + description(): String
}

class SugarDecorator extends CofeeDecorator {
  + SugarDecorator(cofee: Coffee)
  + cost(): double
  + description(): String
}

Coffee <|.. SimpleCofee
Coffee <|.. CofeeDecorator
CofeeDecorator <|-- MilkDecorator
CofeeDecorator <|-- SugarDecorator

CofeeDecorator o-- Coffee

@enduml
    
    
```