### Introduction to Decorator Design Pattern

#### Definition:

The Decorator Pattern is a **structural design pattern** that lets you **dynamically attach new behaviors or responsibilities to an object without modifying its structure.**

#### Problem it Solves:

Avoids subclass explosion and promotes flexible code by using composition instead of inheritance.

### Why Decorator Pattern?

* Allows behavior to be added to an object dynamically at runtime without modifying its structure.
* Avoids a combinatorial explosion of subclasses for each add-on combination.

### Characteristics of Decorator Pattern

* Uses composition over inheritance.
* Follows Open/Closed Principle.
* Can wrap objects multiple times for layered functionality.
* Decorators and components share the **same interface**.

### Key Components of Decorator Pattern

| Component | Description |
| :--- | :--- |
| **Component** (Interface) | Common interface for core and decorators |
| **ConcreteComponent** | Basic implementation (e.g., SimpleCoffee) |
| **Decorator** (Abstract class) | Has a reference to a component and implements the same interface |
| **ConcreteDecorator** | Adds new responsibilities (e.g., MilkDecorator) |

### Advantages of Decorator Pattern

* Promotes **flexibility and reusability**.
* Adheres to the **Open/Closed Principle**.
* Avoids complex inheritance hierarchies.
* Enables **dynamic behavior changes at runtime**.

### Disadvantages of Decorator Pattern

* Can lead to **too many small classes**.
* **Complex debugging** if many decorators are layered.
* Increased **object instantiation**.
* **Not intuitive** for beginners.