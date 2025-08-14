### Code Example:

```
class Coffee {
    public double cost() {
        return 5;
    }
    public String description() {
        return "Simple Coffee";
    }
}

class MilkCoffee extends Coffee {
    public double cost() {
        return super.cost() + 1;
    }
    public String description() {
        return super.description() + ", Milk";
    }
}
```

```
class MilkSugarCoffee extends MilkCoffee {
    public double cost() {
        return super.cost() + 0.5;
    }
    public String description() {
        return super.description() + ", Sugar";
    }
}

class MilkSugarWhippedCreamCoffee extends MilkSugarCoffee {
    public double cost() {
        return super.cost() + 1.5;
    }
    public String description() {
        return super.description() + ", Whipped Cream";
    }
}
```

**Problem:** What if you want Milk + Sugar + WhippedCream? Too many subclasses\!

### Why This Is a Problem:

  * For every new combination, you need a new subclass.
  * Imagine how many combinations exist for 4-5 ingredients\!
  * You lose flexibility and maintainability.
  * Violates Open/Closed Principle — you have to keep modifying or adding new classes.