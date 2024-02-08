package org.example;

/**
 * A bot that defends if its enemy has rockets, and fires rockets
 * if it has them or reloads them if it has none.
 */
public class BlueBot extends BaseBot {
    /**
     * The number of consecutive turns the bot has defended.
     */
    public int defend_counter = 0;

    /**
     * Creates a new BlueBot.
     */
    public BlueBot() {
        super(Ansi.colorize("BlueBot", Ansi.BLUE));
    }

    /**
     * Returns the action code for the bot's turn.
     *
     * @param enemy the enemy bot
     * @return the action code for the bot's turn
     */
    public int turn(BaseBot enemy) {
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
