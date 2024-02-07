package org.example;

import java.util.Random;

public class YellowBot extends BaseBot {
    public YellowBot() {
        super(Ansi.colorize("YellowBot", Ansi.YELLOW));
    }

    public int turn(BaseBot enemy) {
        // The yellow bot heals if it has low health, otherwise it randomly
        // attacks relentlessly until enemy health is below 50, then it fires rockets if it has them
        // or randomly attacks/reloads them if it has no rockets.

        Random random = new Random();
        if (getHealth() < 35) {
            return BaseBot.HEAL;
        } else {
            if (enemy.getHealth() > 50) {
                return BaseBot.ATTACK;
            } else if (getRocketCount() > 0) {
                return BaseBot.FIRE_ROCKET;
            } else {
                if (random.nextBoolean()) {
                    return BaseBot.ATTACK;
                } else {
                    return BaseBot.RELOAD_ROCKETS;
                }
            }
        }
    }
}
