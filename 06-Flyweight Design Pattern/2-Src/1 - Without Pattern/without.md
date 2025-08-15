## Without Flyweight Pattern (Naive Approach)

```java
// Tree class with all data stored individually (no sharing)
class Tree {
    private String name;
    private String color;
    private String texture;
    private int x;
    private int y;

    public Tree(String name, String color, String texture, int x, int y) {
        this.name = name;
        this.color = color;
        this.texture = texture;
        this.x = x;
        this.y = y;
    }

    public void draw() {
        System.out.println("Drawing a " + name + " tree at (" + x + "," + y + ") with color " + color + " and texture " + texture);
    }
}
```
```java
// Forest class that holds all tree instances
class Forest {
    private List<Tree> trees = new ArrayList<>();

    public void plantTree(String name, String color, String texture, int x, int y) {
        Tree tree = new Tree(name, color, texture, x, y);
        trees.add(tree);
    }

    public void drawForest() {
        for (Tree tree : trees) {
            tree.draw();
        }
    }
}

// Main class to simulate forest creation
public class FlyWeight {
    public static void main(String[] args) {
        Forest forest = new Forest();

        // Simulate planting 10 trees with the same type
        for (int i = 0; i < 10; i++) {
            forest.plantTree("Oak", "Green", "Rough", getRandomX(), getRandomY());
        }

        // Simulate planting 10 trees of another type
        for (int i = 0; i < 10; i++) {
            forest.plantTree("Pine", "Dark Green", "Smooth", getRandomX(), getRandomY());
        }

        // Draw all trees
        forest.drawForest();
    }

    private static int getRandomX() {
        return (int) (Math.random() * 10000);
    }

    private static int getRandomY() {
        return (int) (Math.random() * 10000);
    }
}
```

### Explanation
* Each Tree object contains full information, including type, color, and texture.
* Even though many trees are of the same type, every instance duplicates the same data, wasting memory.
* In total, you're creating 20,000 full tree objects, even though only 2 types exist (Oak and Pine).

### Drawbacks
* **High memory usage:** Each object duplicates "Oak", "Green", "Rough" or "Pine", "Yellow", "Smooth".
* **Slow performance:** Due to increased garbage collection and object creation.
* **No reuse of shared data.**