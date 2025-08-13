**Real-World Example: MVC**

| Component | Related Design Pattern(s)                  | Purpose                                                              |
| :-------- | :----------------------------------------- | :------------------------------------------------------------------- |
| Model     | Observer Pattern                           | Allows Views to be notified when Model changes                       |
| View      | Composite Pattern (sometimes), Strategy Pattern for UI rendering | Allows complex UI composition and interchangeable rendering        |
| Controller| Strategy Pattern or Command Pattern        | Encapsulates user actions and delegates to appropriate logic         |


**Advantages**
* High flexibility in design.
* Reusable components.
* Better separation of concerns.
* Easy to maintain and extend.

**Disadvantages**
* More complex to design and understand.
* Potential overengineering.
* Requires strong pattern knowledge.

**Summary**
* Compound Patterns combine multiple design patterns.
* They solve bigger, real-world problems.
* MVC is the most well-known example.
* They require careful planning to avoid unnecessary complexity.