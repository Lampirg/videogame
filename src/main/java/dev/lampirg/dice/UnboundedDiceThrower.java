package dev.lampirg.dice;

import java.util.random.RandomGenerator;
import java.util.stream.IntStream;


public class UnboundedDiceThrower implements DiceThrower {

    private RandomGenerator randomGenerator;

    public UnboundedDiceThrower() {
        randomGenerator = RandomGenerator.getDefault();
    }


    @Override
    public IntStream throwMultipleDices(int diceAmount, int lowestValue, int highestValue) {
        return randomGenerator.ints(diceAmount, lowestValue, highestValue);
    }

    @Override
    public int throwDice(int lowestValue, int highestValue) {
        return randomGenerator.nextInt(lowestValue, highestValue);
    }
}
