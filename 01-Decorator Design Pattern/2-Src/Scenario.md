### Real-World Example – Coffee Shop

**Scenario:**

In a coffee shop, a customer can order **simple coffee** or coffee with **extra ingredients** (milk, sugar, whipped cream, etc.).

Each topping adds a **cost** and modifies the **description**.

### Class Diagram

```mermaid
graph TD
    subgraph Component_Interface
        A[Coffee]
    end

    subgraph Concrete_Component
        B[SimpleCoffee]
    end

    subgraph Decorator_Abstract_Class
        C[CoffeeDecorator]
    end

    subgraph Concrete_Decorator
        D[MilkDecorator]
        E[SugarDecorator]
    end
    
    B --|implements|--> A
    C --|implements|--> A
    D --|extends|--> C
    E --|extends|--> C

    %% Methods (drawn as associations for illustration)
    A -- cost() --> F1[ ]
    A -- description() --> F2[ ]
    B -- cost() --> F3[ ]
    B -- description() --> F4[ ]
    C -- cost() --> F5[ ]
    C -- description() --> F6[ ]
    D -- cost() --> F7[ ]
    D -- description() --> F8[ ]
    E -- cost() --> F9[ ]
    E -- description() --> F10[ ]

    %% Optional: show CoffeeDecorator references its component
    C -.-> A

    %% Styling
    style A fill:#F4B400,stroke:#EA4335,stroke-width:2px,color:#000
    style B fill:#4285F4,stroke:#34A853,stroke-width:2px,color:#000
    style C fill:#4285F4,stroke:#EA4335,stroke-width:2px,color:#000
    style D fill:#34A853,stroke:#EA4335,stroke-width:2px,color:#000
    style E fill:#34A853,stroke:#EA4335,stroke-width:2px,color:#000
    
    
```