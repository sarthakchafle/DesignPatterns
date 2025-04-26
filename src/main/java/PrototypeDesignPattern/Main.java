package PrototypeDesignPattern;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        CharacterFactory factory = new CharacterFactory();
        Character warrior = factory.createCharacterWithNewName("Warrior");
        Character mage = factory.createCharacterWithNewName("Mage");
        Character knight = factory.createCharacterWithNewLevel(5);

        warrior.showCharacterInfo();
        mage.showCharacterInfo();
        knight.showCharacterInfo();
    }
}
