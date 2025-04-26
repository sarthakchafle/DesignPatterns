package PrototypeDesignPattern;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Character implements Cloneable{
    public String name;
    public int health;
    public int attackPower;
    public int level;

    @Override
    public Character clone() {
        try {
            return (Character) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
    public void showCharacterInfo() {
        System.out.println("Character [Name=" + name + ", Health=" + health
                + ", AttackPower=" + attackPower + ", Level=" + level + "]");
    }
}
