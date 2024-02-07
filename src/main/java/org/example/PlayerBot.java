package org.example;

public class PlayerBot extends BaseBot {
    public PlayerBot() {
        super("PlayerBot");
    }

    public int turn(BaseBot enemy) {
        // TODO: Implement your bot here, this function will be called for each turn.
        // Rules:
        // 1. You must return one of the following actions:
        //    BaseBot.DO_NOTHING
        //    BaseBot.ATTACK
        //    BaseBot.HEAL
        //    BaseBot.FIRE_ROCKET
        //    BaseBot.RELOAD_ROCKETS
        //    BaseBot.DEFEND
        // 2. You can inspect your own health and rocket count with getHealth() and getRocketCount()
        // 3. You can inspect the enemy's health and rocket count with enemy.getHealth() and enemy.getRocketCount()
        // 4. You may NOT call any method on either bot that starts with an underscore
        return BaseBot.DO_NOTHING;
    }
}
