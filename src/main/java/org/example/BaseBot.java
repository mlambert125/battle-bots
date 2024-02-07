package org.example;

public class BaseBot {
    public static final int DO_NOTHING = 0;
    public static final int ATTACK = 1;
    public static final int HEAL = 2;
    public static final int FIRE_ROCKET = 3;
    public static final int RELOAD_ROCKETS = 4;
    public static final int DEFEND = 5;
    private String name;
    private int health;
    private int rocketCount;

    public String _getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void _takeDamage(int damage) {
        health -= damage;
    }

    public void _heal(int amount) {
        health += amount;
    }

    public void _decrementRocketCount() {
        rocketCount--;
    }

    public void _reloadRockets() {
        rocketCount = 3;
    }

    public int getRocketCount() {
        return rocketCount;
    }

    public BaseBot(String name) {
        this.name = name;
        this.health = 100;
        this.rocketCount = 3;
    }

    public int turn(BaseBot enemy) {
        return DO_NOTHING;
    }
}
