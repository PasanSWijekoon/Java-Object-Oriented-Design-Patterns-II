### Real-World Example – Coffee Shop

**Scenario:**

In a coffee shop, a customer can order **simple coffee** or coffee with **extra ingredients** (milk, sugar, whipped cream, etc.).

Each topping adds a **cost** and modifies the **description**.

### Class Diagram

```mermaid
graph TD
    subgraph Component Interface
        A[Coffee]
    end

    subgraph Concrete Component
        B[SimpleCoffee]
    end

    subgraph Decorator Abstract class
        C[CoffeeDecorator]
    end

    subgraph Concrete Decorator
        D[MilkDecorator]
        E[SugarDecorator]
    end
    
    A -- implements --> B
    A -- implements --> C

    C -- implements --> D
    C -- implements --> E

    style A fill:#F4B400,stroke:#EA4335,stroke-width:2px,color:#000
    style B fill:#4285F4,stroke:#34A853,stroke-width:2px,color:#000
    style C fill:#4285F4,stroke:#EA4335,stroke-width:2px,color:#000
    style D fill:#34A853,stroke:#EA4335,stroke-width:2px,color:#000
    style E fill:#34A853,stroke:#EA4335,stroke-width:2px,color:#000
    
    A -->|cost()|
    A -->|description()|
    B -->|cost()|
    B -->|description()|
    C -->|cost()|
    C -->|description()|
    D -->|cost()|
    D -->|description()|
    E -->|cost()|
    E -->|description()|
    
    C ---.-> A
    C ---.-> D
    C ---.-> E
    
    
```