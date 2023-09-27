package dev.lampirg.creature;

import dev.lampirg.dice.DiceThrower;
import lombok.Getter;

@Getter
public class Player extends Creature {

    private int remainHeals;

    public Player(int maxHealth, int defense, int attack, int lowestDamage, int highestDamage, DiceThrower diceThrower) {
        super(maxHealth, defense, attack, lowestDamage, highestDamage, diceThrower);
        remainHeals = 4;
    }

    public void heal() {
        if (remainHeals <= 0) {
            throw new IllegalStateException("Healing when no heals remain");
        }
        int toHeal = (int) (getMaxHealth() * 0.3);
        setCurrentHealth(getCurrentHealth() + toHeal);
        remainHeals--;
    }

}
