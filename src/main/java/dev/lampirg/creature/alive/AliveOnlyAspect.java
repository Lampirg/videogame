package dev.lampirg.creature.alive;

import dev.lampirg.creature.Creature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AliveOnlyAspect {

    @Before("target(dev.lampirg.creature.Creature) && @annotation(dev.lampirg.creature.alive.AliveOnly)")
    public void throwIfDead(Creature creature) {
        creature.throwIfDead();
    }
}
