package dev.lampirg.creature;

import dev.lampirg.dice.DiceThrower;

public class Monster extends Creature {
    public Monster(int maxHealth, int defense, int attack, int lowestDamage, int highestDamage, DiceThrower diceThrower) {
        super(maxHealth, defense, attack, lowestDamage, highestDamage, diceThrower);
    }
}
