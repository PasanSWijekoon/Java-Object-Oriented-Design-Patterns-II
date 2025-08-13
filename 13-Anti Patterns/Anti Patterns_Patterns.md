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