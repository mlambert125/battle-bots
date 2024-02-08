package org.example;

/**
 * Base class for all bots.  This class is provided for you and should not be modified.
 */
public abstract class BaseBot {
    /**
     * The action code for doing nothing.
     */
    public static final int DO_NOTHING = 0;

    /**
     * The action code for attacking the enemy.
     */
    public static final int ATTACK = 1;

    /**
     * The action code for healing the bot.
     */
    public static final int HEAL = 2;

    /**
     * The action code for firing a rocket at the enemy.
     */
    public static final int FIRE_ROCKET = 3;

    /**
     * The action code for reloading rockets.
     */
    public static final int RELOAD_ROCKETS = 4;

    /**
     * The action code for defending against rockets.
     */
    public static final int DEFEND = 5;

    /**
     * The name of the bot.
     */
    private String name;

    /**
     * The health of the bot.
     */
    private int health;

    /**
     * The number of rockets the bot has.
     */
    private int rocketCount;

    /**
     * Gets the name of the bot.
     *
     * @return the name of the bot
     */
    public String _getName() {
        return name;
    }

    /**
     * Gets the health of the bot.
     *
     * @return the health of the bot
     */
    public int getHealth() {
        return health;
    }

    /**
     * Gets the number of rockets the bot has.
     *
     * @return the number of rockets the bot has
     */
    public int getRocketCount() {
        return rocketCount;
    }

    /**
     * Takes damage from an attack.
     *
     * @param damage the amount of damage to take
     */
    public void _takeDamage(int damage) {
        health -= damage;
    }

    /**
     * Heals the bot for a given amount.
     *
     * @param amount the amount to heal
     */
    public void _heal(int amount) {
        health += amount;
    }

    /**
     * Decrements the rocket count by one.
     */
    public void _decrementRocketCount() {
        rocketCount--;
    }

    /**
     * Reloads the rockets to three.
     */
    public void _reloadRockets() {
        rocketCount = 3;
    }

    /**
     * Creates a new bot with the given name.
     *
     * @param name the name of the bot
     */
    public BaseBot(String name) {
        this.name = name;
        this.health = 100;
        this.rocketCount = 3;
    }

    /**
     * The turn function for the bot.  This function should be overridden by subclasses.
     *
     * @param enemy the enemy bot
     * @return the action to take
     */
    public abstract int turn(BaseBot enemy);
}
