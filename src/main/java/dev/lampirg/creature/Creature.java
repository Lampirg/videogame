package dev.lampirg.creature;

import dev.lampirg.dice.DiceThrower;
import dev.lampirg.dice.UnboundedDiceThrower;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
public abstract class Creature {

    private Health health;
    private boolean isAlive;

    private int defense;
    private int attack;

    private DiceThrower diceThrower;

    private DamageRange damageRange;

    public Creature(int maxHealth, int defense, int attack, int lowestDamage, int highestDamage, DiceThrower diceThrower) {
        health = new Health(maxHealth, maxHealth);
        isAlive = true;
        this.defense = defense;
        this.attack = attack;
        damageRange = new DamageRange(lowestDamage, highestDamage);
        // TODO: replace hardcode with DI
        this.diceThrower = diceThrower;
    }

    public int getMaxHealth() {
        return health.maxHealth;
    }

    public int getCurrentHealth() {
        return health.currentHealth;
    }

    public void setMaxHealth(int newMaxHealth) {
        health.maxHealth = newMaxHealth;
    }

    public void setCurrentHealth(int newCurrentHealth) {
        if (newCurrentHealth > health.maxHealth) {
            newCurrentHealth = health.maxHealth;
        }
        health.currentHealth = newCurrentHealth;
    }

    public void throwIfDead() {
        if (!isAlive) {
            throw new IllegalStateException("Creature is dead but a method for alive-only creatures is called");
        }
    }

    public void dealDamage(int damage) {
        if (!isAlive) {
            return;
        }
        if (health.currentHealth <= damage) {
            health.currentHealth = 0;
            isAlive = false;
            return;
        }
        health.currentHealth -= damage;
    }

    public void attackCreature(Creature creature) {
        // TODO: replace with aspect
        throwIfDead();
        int modifier = Math.max(1, attack - (creature.getDefense() + 1));
        boolean success = diceThrower.throwMultipleDices(modifier, 1, 7)
                .anyMatch(dice -> dice >= 5);
        if (!success) {
            return;
        }
        creature.dealDamage(diceThrower.throwDice(damageRange.from, damageRange.to));
    }

    @AllArgsConstructor
    private static class Health {
        private int maxHealth;
        private int currentHealth;
    }

    public static DamageRange damageRange(int from, int to) {
        return new DamageRange(from, to);
    }

    @Data
    @AllArgsConstructor
    public static class DamageRange {
        private int from;
        private int to;
    }
}
