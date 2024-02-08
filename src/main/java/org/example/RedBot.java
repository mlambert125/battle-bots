package org.example;

/**
 * A bot that fires rockets and then attacks unless it has low
 * health, in which case it heals.  It never reloads its rockets,
 * and it does not inspect the enemy's health or rocket count.
 */
public class RedBot extends BaseBot{
    /**
     * Creates a new RedBot.
     */
    public RedBot() {
        super(Ansi.colorize("RedBot", Ansi.RED));
    }

    /**
     * Returns the action code for the bot's turn.
     *
     * @param enemy the enemy bot
     * @return the action code for the bot's turn
     */
    public int turn(BaseBot enemy) {
        if (getHealth() < 35) {
            return BaseBot.HEAL;
        } else if (getRocketCount() > 0) {
            return BaseBot.FIRE_ROCKET;
        }
        return BaseBot.ATTACK;
    }
}
