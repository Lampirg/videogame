import dev.lampirg.creature.Monster;
import dev.lampirg.creature.Player;
import dev.lampirg.dice.DiceThrower;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.IntStream;

@ExtendWith(MockitoExtension.class)
public class TestPlayer {

    Player player;
    Monster monster;
    @Mock
    DiceThrower diceThrower;

    @BeforeEach
    void setUp() {
        player = new Player(30, 4, 5, 1, 5, diceThrower);
        monster = new Monster(30, 2, 5, 1, 5, diceThrower);
    }

    @Test
    void testHitGivenTwoDices() {
        Mockito.when(
                diceThrower.throwMultipleDices(2, 1, 7)
        ).thenReturn(IntStream.of(3, 5));
        Mockito.when(
                diceThrower.throwDice(1, 5)
        ).thenReturn(3);
        player.attackCreature(monster);
        Assertions.assertEquals(27, monster.getCurrentHealth());
    }

    @Test
    void testHitGivenOneDice() {
        monster.setDefense(3);
        Mockito.when(
                diceThrower.throwMultipleDices(1, 1, 7)
        ).thenReturn(IntStream.of(5));
        Mockito.when(
                diceThrower.throwDice(1, 5)
        ).thenReturn(3);
        player.attackCreature(monster);
        Assertions.assertEquals(27, monster.getCurrentHealth());
    }

    @Test
    void testMissGivenOneDice() {
        monster.setDefense(9);
        Mockito.when(
                diceThrower.throwMultipleDices(1, 1, 7)
        ).thenReturn(IntStream.of(4));
        player.attackCreature(monster);
        Assertions.assertEquals(30, monster.getCurrentHealth());
    }

    @Test
    void testDead() {
        player.dealDamage(40);
        Assertions.assertEquals(0, player.getCurrentHealth());
        Assertions.assertFalse(player.isAlive());
        Assertions.assertThrows(IllegalStateException.class, () -> player.attackCreature(monster));
    }

    @Test
    void testHealing() {
        player.dealDamage(15);
        player.heal();
        Assertions.assertEquals(3, player.getRemainHeals());
        Assertions.assertEquals(24, player.getCurrentHealth());
    }

    @Test
    void testHealingOverMax() {
        player.dealDamage(5);
        player.heal();
        Assertions.assertEquals(30, player.getCurrentHealth());
    }

    @Test
    void testIllegalHealing() {
        for (int i = 0; i < 4; i++) {
            player.heal();
        }
        Assertions.assertEquals(0, player.getRemainHeals());
        Assertions.assertThrows(IllegalStateException.class, () -> player.heal());
    }

    @Test
    void testIllegalArguments() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Player(-1, 1, 1, 1, 4, diceThrower));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Player(6, 0, 1, 1, 4, diceThrower));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Player(6, 35, 1, 1, 4, diceThrower));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Player(6, 1, -5, 1, 4, diceThrower));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Player(6, 1, 875, 1, 4, diceThrower));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Player(6, 1, 1, 7, 2, diceThrower));
    }
}
