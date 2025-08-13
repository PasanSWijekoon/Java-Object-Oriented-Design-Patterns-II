# Introduction

* **Definition:** An anti-pattern is a common but ineffective (or counter-productive) solution to a recurring problem.
* They often start as “good ideas” but lead to bad results in the long run.
* **Example:** Using Singleton everywhere — turning it into a “God Object.”

# Why Study Anti-Patterns?

* Helps developers **recognize bad practices early**.
* Prevents **technical debt**.
* Improves **code maintainability**.
* Encourages **best practices**.

# Common Causes
* Lack of design knowledge.
* Copy-paste programming.
* Over-engineering.
* Misusing design patterns.
* Pressure from deadlines.

# Types of Anti-Patterns
1. Design Anti-Patterns
2. Coding Anti-Patterns
3. Project Management Anti-Patterns

---

# Common Java Anti-Patterns

| Anti-Pattern | Description | Why It's Bad |
| :--- | :--- | :--- |
| **God Object** | One class does too much | Hard to maintain, violates SRP |
| **Spaghetti Code** | Messy, unstructured code | Difficult to debug/extend |
| **Golden Hammer** | Using one pattern/tech everywhere | Reduces flexibility |
| **Lava Flow** | Dead/obsolete code remains | Wastes memory, confuses devs |
| **Premature Optimization** | Optimizing too early | Adds complexity without benefit |
| **Poltergeist** | Classes with no real purpose | Adds unnecessary indirection |

### Example – God Object

**Problem:** One class controls all business logic, database access, UI, etc.

**Java Example (Bad):**

```java
class GodObject {
    public void connectDB() { /* ... */ }
    public void renderUI() { /* ... */ }
    public void processOrder() { /* ... */ }
}
```

**Why it's bad:**

  * Violates Single Responsibility Principle.
  * Hard to maintain, test, or extend.

-----

### Refactored Solution

```java
class DatabaseManager {
    public void connectDB() { /* ... */ }
}

class UIManager {
    public void renderUI() { /* ... */ }
}

class OrderProcessor {
    public void processOrder() { /* ... */ }
}
```

  * Responsibilities are separated, making the code cleaner.

-----

### Best Practices to Avoid Anti-Patterns

  * Follow **SOLID principles.**
  * Use **design patterns wisely.**
  * Refactor regularly.
  * Write unit tests.
  * Perform code reviews.

  **SOLID PRINCIPLES**

* **S** - **SINGLE RESPONSIBILITY**: A class should have only one single responsibility and should have one and only one reason for change.
* **O** - **OPEN CLOSED PRINCIPLE**: A class should be open for extension, but closed for modifications.
* **L** - **LISKOV SUBSTITUTION**: Objects in a program should be replaceable with instances of their subtypes without altering the correctness of program.
* **I** - **INTERFACE SEGREGATION**: Segregate interfaces as per the requirements of program, rather than one general purpose implementation.
* **D** - **DEPENDENCY INVERSION**: Should depend on abstractions rather than concrete implementations.


# Advantages & Disadvantages of Studying Anti-Patterns

## Advantages (of knowing them)

* **Recognize mistakes early** $\rightarrow$ prevents long-term technical debt.
* **Improved code quality** $\rightarrow$ by avoiding bad practices.
* **Better decision-making** $\rightarrow$ choose the right pattern for the job.
* **Team alignment** $\rightarrow$ everyone shares a common understanding of what not to do.
* **Refactoring guidance** $\rightarrow$ provides clear fixes for common bad solutions.

## Disadvantages (if not handled carefully)

* **Misinterpretation risk** $\rightarrow$ junior devs may copy anti-pattern examples thinking they're correct.
* **Time consumption** $\rightarrow$ discussing them too much can delay feature development.
* **Over-caution** $\rightarrow$ fear of making mistakes may slow down creativity.
* **Legacy system frustration** $\rightarrow$ recognizing anti-patterns in old code without resources to fix them can cause morale issues.