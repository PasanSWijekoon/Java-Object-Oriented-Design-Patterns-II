A new spreadsheet software, **CalcPro**, allows users to enter custom formulas in cells, such as:

* `"ADD[5, 10]"`
* `"MULTIPLY(ADD(2, 3), 4)"`
* `"DIVIDE(SUBTRACT(20, 4), 2)"`

Currently, CalcPro uses string **splitting and nested if-else conditions** in its formula parser to evaluate expressions. Every time a new formula operation is added (e.g., `"POWER(base, exponent)!"`), developers must modify the parsing code in multiple places, which makes it difficult to maintain and error-prone.

The development team wants to **refactor the formula parser using the Interpreter Design Pattern** so that:

1. Each formula is parsed into an Abstract Syntax Tree (AST) with terminal and non-terminal expressions.
2. Operations like ADD, SUBTRACT, MULTIPLY, and DIVIDE are implemented as separate expression classes that can be easily extended.
3. The context holds variable values (e.g., x = 5) so formulas like `"MULTIPLY(ADD(x, 3), 2)"` can be evaluated dynamically.

**Tasks:**

1. Write Java code that:
   * Parses and evaluates formulas like `"ADD[5, 10]"` and `"MULTIPLY(ADD(2, 3), 4)"`.
   * Supports variables by storing them in a context.
2. Show how the client can:
   I. Evaluate `"ADD[5, 10]"` -> Output: 15
   II. Evaluate `"MULTIPLY(ADD(2, 3), 4)"` -> Output: 20
   III. Evaluate `"DIVIDE(SUBTRACT(20, 4), 2)"` -> Output: 8
3. Explain how adding a `"POWER"` operation would require minimal changes due to the Interpreter pattern's extensibility.