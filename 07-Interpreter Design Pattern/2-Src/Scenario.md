### Real-World Example: Mathematical Expression Evaluator

**Problem Statement:**

Imagine you are building a simple calculator that takes user input as a string (e.g., `"10 - 2 + 4"`) and returns the correct result. At first glance, this looks simple — just parse the numbers and operations and evaluate.

But what if later you want to:

* **Add new operations (e.g., multiplication, division):** The initial, simple parsing logic would need to be rewritten to handle the new operators and their precedence rules.
* **Support parentheses (e.g., `"10 - (2 + 4)"`):** This introduces the need for a more complex parsing strategy that can handle nested expressions.
* **Handle complex rules (e.g., custom priority levels, functions like `sqrt(16)`):** Hard-coding these rules would lead to a brittle and unmaintainable system.

The Interpreter pattern provides a structured and extensible way to address these challenges. By defining a grammar for mathematical expressions, we can build a robust system that can be easily extended to handle more complex scenarios without a complete redesign.