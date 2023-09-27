package dev.lampirg.dice;

import java.util.stream.IntStream;

public interface DiceThrower {
    IntStream throwMultipleDices(int diceAmount, int lowestValue, int highestValue);

    default int throwDice(int lowestValue, int highestValue) {
        return throwMultipleDices(1, lowestValue, highestValue).findAny().orElseThrow();
    }
}
