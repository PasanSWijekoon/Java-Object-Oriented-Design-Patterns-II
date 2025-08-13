# Introduction

- **Definition:** A Compound Pattern is a design solution that combines two or more patterns to address complex design issues.
- They often appear in real-world systems where a single pattern alone is not enough.
- **Example:** MVC (Model-View-Controller) combines Observer, Strategy, and Composite.

## Why Use Compound Patterns?

- Complex problems require multiple solutions.
- Increases flexibility, scalability, and maintainability.
- Avoids reinventing the wheel by reusing proven solutions.
- Patterns complement each other's strengths.

# Common Compound Patterns

* **Model-View-Controller (MVC)** $\to$ Observer + Strategy + Composite
* **Model-View-Presenter (MVP)** $\to$ Observer + Strategy
* Decorator + Factory
* Command + Composite
* Adapter + Facade

# Key Characteristics

1.  **Combination of Patterns** – not random, but logically related.
2.  **High Cohesion** – patterns support each other’s responsibilities.
3.  **Loose Coupling** – promotes flexibility.
4.  **Scalability** – can evolve without major refactoring.
5.  **Reusability** – components can be used independently.

**Real-World Example: MVC**

| Component | Related Design Pattern(s)                  | Purpose                                                              |
| :-------- | :----------------------------------------- | :------------------------------------------------------------------- |
| Model     | Observer Pattern                           | Allows Views to be notified when Model changes                       |
| View      | Composite Pattern (sometimes), Strategy Pattern for UI rendering | Allows complex UI composition and interchangeable rendering        |
| Controller| Strategy Pattern or Command Pattern        | Encapsulates user actions and delegates to appropriate logic         |