package org.example;
import java.util.*;

/**
 * This class represents an arena in which two bots can fight.
 */
public class Arena {
    /**
     * The delay between turns in seconds.
     */
    private double turnDelay;

    /**
     * The delay between rounds in seconds.
     */
    private double roundDelay;

    /**
     * Creates a new arena with the given turn and round delays.
     *
     * @param turnDelay the delay between turns in seconds
     * @param roundDelay the delay between rounds in seconds
     */
    public Arena(double turnDelay, double roundDelay) {
        this.turnDelay = turnDelay;
        this.roundDelay = roundDelay;
    }

    /**
     * Fights the two given bots against each other.
     *
     * @param player1 the first bot
     * @param player2 the second bot
     * @throws InterruptedException if the fight thread (main thread) is interrupted
     */
    public void fight(BaseBot player1, BaseBot player2) throws InterruptedException {
        int round = 1;
        while (player1.getHealth() > 0 && player2.getHealth() > 0) {
            int player1Action = player1.turn(player2);
            int player2Action = player2.turn(player1);

            Random random = new Random();

            System.out.println(Ansi.colorize("============= Round " + round + " ==============", Ansi.CYAN));
            if (random.nextBoolean()) {
                processMove(player1Action, player1, player2, player2Action == BaseBot.DEFEND);
                System.out.println("-------------------------------------");
                Thread.sleep((int)(turnDelay * 1000));
                processMove(player2Action, player2, player1, player1Action == BaseBot.DEFEND);
            } else {
                processMove(player2Action, player2, player1, player1Action == BaseBot.DEFEND);
                System.out.println("-------------------------------------");
                Thread.sleep((int)(turnDelay * 1000));
                processMove(player1Action, player1, player2, player2Action == BaseBot.DEFEND);
            }

            System.out.println("-------------- SCORES ---------------");
            System.out.println(player1._getName() + ": " + player1.getHealth() + " health");
            System.out.println(player2._getName() + ": " + player2.getHealth() + " health");
            Thread.sleep((int)(roundDelay * 1000));
            round++;
        }
        BaseBot winner  = player1.getHealth() > 0 ? player1 : player2;
        BaseBot loser = player1.getHealth() > 0 ? player2 : player1;

        System.out.println(loser._getName() + " has been defeated!");
        System.out.println(winner._getName() + " wins, with " + winner.getHealth() + " health remaining!");
    }

    /**
     * Processes a move for a bot.
     *
     * @param action the action to perform
     * @param source the bot performing the action
     * @param target the bot being targeted
     * @param targetDefending whether the target is defending
     * @throws InterruptedException if the fight thread (main thread) is interrupted
     */
    public void processMove(int action, BaseBot source, BaseBot target, boolean targetDefending) throws InterruptedException {
        Random random = new Random();
        switch (action) {
            case BaseBot.DO_NOTHING:
                System.out.println(source._getName() + " does nothing...");
                break;
            case BaseBot.ATTACK:
                System.out.println(source._getName() + " attacks " + target._getName() + "!");

                if (random.nextInt(10) < 1) {
                    System.out.println(source._getName() + " misses with their attack!");
                } else {
                    int damage = random.nextInt(10);
                    if (targetDefending) {
                        System.out.println(target._getName() + " defends against the attack!");
                        damage = (int) (damage * 0.25);
                    }
                    System.out.println(target._getName() + " takes " + damage + " damage!");
                    target._takeDamage(damage);
                }
                break;
            case BaseBot.HEAL:
                int healAmount = random.nextInt(15);
                System.out.println(source._getName() + " heals for " + healAmount + " health!");
                source._heal(healAmount);
                break;
            case BaseBot.FIRE_ROCKET:
                if (source.getRocketCount() == 0) {
                    System.out.println(source._getName() + " tries to fire a rocket, but they're out!");
                    break;
                }

                System.out.println(source._getName() + " fires a rocket at " + target._getName() + "!");
                if (random.nextInt( 10) < 2) {
                    System.out.println(source._getName() + " misses with their rocket!");
                } else {
                    int rocketDamage = random.nextInt( 15) + 10;
                    if (targetDefending) {
                        System.out.println(target._getName() + " defends against the rocket!");
                        rocketDamage = (int) (rocketDamage * 0.25);
                    }
                    System.out.println(target._getName() + " takes " + rocketDamage + " damage!");
                    target._takeDamage(rocketDamage);

                }
                source._decrementRocketCount();
                break;
            case BaseBot.RELOAD_ROCKETS:
                System.out.println(source._getName() + " reloads their rockets.");
                source._reloadRockets();
                break;
            case BaseBot.DEFEND:
                System.out.println(source._getName() + " is defending...");
                break;
        }
    }
}
