package PrototypeDesignPattern;

public class CharacterFactory {
    private Character prototypeCharacter;

    public CharacterFactory() {
        prototypeCharacter =
                new Character("DefaultName", 100, 50, 1); // Default prototype character
    }

    // Create a character by cloning the prototype and changing only the required
    // attributes
    public Character createCharacterWithNewName(String name)
            throws CloneNotSupportedException {
        Character clonedCharacter = prototypeCharacter.clone();
        clonedCharacter = new Character(name, clonedCharacter.health,
                clonedCharacter.attackPower, clonedCharacter.level);
        return clonedCharacter;
    }

    public Character createCharacterWithNewLevel(int level)
            throws CloneNotSupportedException {
        Character clonedCharacter = prototypeCharacter.clone();
        clonedCharacter = new Character(clonedCharacter.name,
                clonedCharacter.health, clonedCharacter.attackPower, level);
        return clonedCharacter;
    }

    public Character createCharacterWithNewAttackPower(int attackPower)
            throws CloneNotSupportedException {
        Character clonedCharacter = prototypeCharacter.clone();
        clonedCharacter = new Character(clonedCharacter.name,
                clonedCharacter.health, attackPower, clonedCharacter.level);
        return clonedCharacter;
    }
}
