package dev.lampirg;

import dev.lampirg.creature.Monster;
import dev.lampirg.creature.Player;
import dev.lampirg.dice.DiceThrower;
import dev.lampirg.dice.UnboundedDiceThrower;

public class Main {
    public static void main(String[] args) {
        DiceThrower diceThrower = new UnboundedDiceThrower();
        Player hero = new Player(5, 2, 5, 3, 7, diceThrower);
        System.out.println("Mighty hero arrived to purge this unholy world from darkness!");
        Monster beast = new Monster(20, 2, 1, 1, 3, diceThrower);
        System.out.println("Wild dark beast appears!");
        while (true) {
            System.out.println("Hero attacks!");
            hero.attackCreature(beast);
            if (!beast.isAlive()) {
                System.out.println("Great hero saved this world!");
                return;
            }
            System.out.println("Monster strikes back!");
            beast.attackCreature(hero);
            if (!hero.isAlive()) {
                System.out.println("Oh no! Hero has fallen!");
                return;
            }
        }
    }
}
