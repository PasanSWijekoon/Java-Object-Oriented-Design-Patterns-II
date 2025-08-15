import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Flyweight Interface
interface DrawableTree {
    void draw(int x, int y);
}

// Concrete Flyweight
// This class contains the intrinsic, shared state (name, color, texture).
// It acts as the flyweight object.
class TreeType implements DrawableTree {
    private String name;
    private String color;
    private String texture;

    public TreeType(String name, String color, String texture) {
        this.name = name;
        this.color = color;
        this.texture = texture;
    }

    @Override
    public void draw(int x, int y) {
        // The extrinsic state (x, y) is passed as a parameter.
        System.out.println("Drawing " + name + " tree at (" + x + "," + y + ") with " + color + " color and " + texture + " texture.");
    }
}

// Flyweight Factory
// This class ensures that no duplicate TreeType objects are created.
// It stores and reuses existing flyweight objects.
class TreeFactory {
    private static final Map<String, DrawableTree> treeTypes = new HashMap<>();

    public static DrawableTree getTreeType(String name, String color, String texture) {
        String key = name + "_" + color + "_" + texture;
        if (!treeTypes.containsKey(key)) {
            treeTypes.put(key, new TreeType(name, color, texture));
        }
        return treeTypes.get(key);
    }

    public static int getTotalTypes() {
        return treeTypes.size();
    }
}

// Context Class (Unshared)
// This class contains the extrinsic, unshared state (x, y) and
// a reference to the shared flyweight object (TreeType).
class Tree {
    private int x;
    private int y;
    private DrawableTree type;

    public Tree(int x, int y, DrawableTree type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public void draw() {
        type.draw(x, y);
    }
}

// Client Class
// This class manages the collection of flyweight objects and their contexts.
class Forest {
    private List<Tree> trees = new ArrayList<>();

    public void plantTree(int x, int y, String name, String color, String texture) {
        DrawableTree type = TreeFactory.getTreeType(name, color, texture);
        Tree tree = new Tree(x, y, type);
        trees.add(tree);
    }

    public void drawForest() {
        for (Tree tree : trees) {
            tree.draw();
        }
    }

    public int getTreeCount() {
        return trees.size();
    }
}

// Main class to demonstrate the pattern, updated with the new code from your image
public class FlyWeight {
    public static void main(String[] args) {
        Forest forest = new Forest();

        // Plant 1000 Pine trees
        for (int i = 0; i < 1000; i++) {
            forest.plantTree(getRandomX(), getRandomY(), "Pine", "Yellow", "Smooth");
        }

        // Plant 1000 Oak trees
        for (int i = 0; i < 1000; i++) {
            forest.plantTree(getRandomX(), getRandomY(), "Oak", "Green", "Rough");
        }

        // Draw the forest
        // Note: The drawForest() method would likely be very slow with 2000 items
        // but it demonstrates the functionality of the pattern.
        // forest.drawForest();

        System.out.println("\nTotal Tree Count: " + forest.getTreeCount());
        System.out.println("Total Tree Types: " + TreeFactory.getTotalTypes());
    }

    private static int getRandomX() {
        return (int) (Math.random() * 1000);
    }

    private static int getRandomY() {
        return (int) (Math.random() * 1000);
    }
}

