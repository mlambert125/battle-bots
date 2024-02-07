package org.example;

public class BlueBot extends BaseBot {
    public int defend_counter = 0;

    public BlueBot() {
        super("BlueBot");
    }

    public int turn(BaseBot enemy) {
        // The blue bot defends if its enemy has rockets.  Otherwise, it fires rockets
        // or reloads them if it has none.

        if (enemy.getRocketCount() > 0) {
            if (defend_counter < 3) {
                defend_counter++;
                return BaseBot.DEFEND;
            } else {
                defend_counter = 0;
                return BaseBot.ATTACK;
            }
        } else if (this.getRocketCount() > 0) {
            return BaseBot.FIRE_ROCKET;
        } else {
            return BaseBot.RELOAD_ROCKETS;
        }
    }
}
