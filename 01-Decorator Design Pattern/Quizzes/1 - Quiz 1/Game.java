/**
 *
 * @author pasan
 */

// Component interface
interface Character {
    String getDescription();
    int getPower();
}

// Concrete Components
class Warrior implements Character {
    @Override
    public String getDescription() {
        return "Warrior";
    }

    @Override
    public int getPower() {
        return 100;
    }
}

class Archer implements Character {
    @Override
    public String getDescription() {
        return "Archer";
    }

    @Override
    public int getPower() {
        return 80;
    }
}

class Mage implements Character {
    @Override
    public String getDescription() {
        return "Mage";
    }

    @Override
    public int getPower() {
        return 70;
    }
}

// Abstract Decorator
abstract class CharacterUpgradeDecorator implements Character {
    protected Character decoratedCharacter;

    public CharacterUpgradeDecorator(Character decoratedCharacter) {
        this.decoratedCharacter = decoratedCharacter;
    }

    @Override
    public String getDescription() {
        return decoratedCharacter.getDescription();
    }

    @Override
    public int getPower() {
        return decoratedCharacter.getPower();
    }
}

// Concrete Decorators
class FireEnchantment extends CharacterUpgradeDecorator {
    public FireEnchantment(Character decoratedCharacter) {
        super(decoratedCharacter);
    }

    @Override
    public String getDescription() {
        return decoratedCharacter.getDescription() + " with Fire Enchantment";
    }

    @Override
    public int getPower() {
        return decoratedCharacter.getPower() + 30;
    }
}

class ArmorUpgrade extends CharacterUpgradeDecorator {
    public ArmorUpgrade(Character decoratedCharacter) {
        super(decoratedCharacter);
    }

    @Override
    public String getDescription() {
        return decoratedCharacter.getDescription() + " with Armor Upgrade";
    }

    @Override
    public int getPower() {
        return decoratedCharacter.getPower() + 40;
    }
}

class SpeedBoost extends CharacterUpgradeDecorator {
    public SpeedBoost(Character decoratedCharacter) {
        super(decoratedCharacter);
    }

    @Override
    public String getDescription() {
        return decoratedCharacter.getDescription() + " with Speed Boost";
    }

    @Override
    public int getPower() {
        return decoratedCharacter.getPower() + 20;
    }
}

class MagicShield extends CharacterUpgradeDecorator {
    public MagicShield(Character decoratedCharacter) {
        super(decoratedCharacter);
    }

    @Override
    public String getDescription() {
        return decoratedCharacter.getDescription() + " with Magic Shield";
    }

    @Override
    public int getPower() {
        return decoratedCharacter.getPower() + 50;
    }
}

public class Game {
    public static void main(String[] args) {
        // Create a Warrior character
        Character warrior = new Warrior();
        System.out.println("Base Warrior: " + warrior.getDescription() + ", Power: " + warrior.getPower());

        // Apply Fire Enchantment
        warrior = new FireEnchantment(warrior);
        System.out.println("Warrior with Fire Enchantment: " + warrior.getDescription() + ", Power: " + warrior.getPower());

        // Apply Armor Upgrade to the already enchanted warrior
        warrior = new ArmorUpgrade(warrior);
        System.out.println("Warrior with Fire Enchantment with Armor Upgrade: " + warrior.getDescription() + ", Power: " + warrior.getPower());

        // Create an Archer and apply multiple upgrades in a different order
        Character archer = new Archer();
        archer = new SpeedBoost(archer);
        archer = new MagicShield(archer);
        System.out.println("Archer with Speed Boost with Magic Shield: " + archer.getDescription() + ", Power: " + archer.getPower());

        // Create a Mage with one upgrade
        Character mage = new Mage();
        mage = new FireEnchantment(mage);
        System.out.println("Mage with Fire Enchantment: " + mage.getDescription() + ", Power: " + mage.getPower());
    }
}
