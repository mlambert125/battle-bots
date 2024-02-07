package org.example;

public class RedBot extends BaseBot{
    public RedBot() {
        super("RedBot");
    }

    public int turn(BaseBot enemy) {
        // The red bot fires rockets and then attacks unless it has low health, in which case it heals.
        // It never reloads its rockets, and it does not inspect the enemy's health or rocket count.

        if (getHealth() < 35) {
            return BaseBot.HEAL;
        } else if (getRocketCount() > 0) {
            return BaseBot.FIRE_ROCKET;
        }
        return BaseBot.ATTACK;
    }
}
