package org.example;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static final double TURN_DELAY = 0.5;
    public static final double ROUND_DELAY = 1.0;

    public static void main( String[] args ) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Bot Arena!");
        System.out.println("Please select the first bot:");
        System.out.println("1. PlayerBot");
        System.out.println("2. RedBot");
        System.out.println("3. BlueBot");
        System.out.println("4. YellowBot");

        int bot1 = scanner.nextInt();
        BaseBot player1 = getBot(bot1);

        System.out.println("Please select the second bot:");
        System.out.println("1. PlayerBot");
        System.out.println("2. RedBot");
        System.out.println("3. BlueBot");
        System.out.println("4. YellowBot");

        int bot2 = scanner.nextInt();
        BaseBot player2 = getBot(bot2);

        Arena arena = new Arena(TURN_DELAY, ROUND_DELAY);
        try {
            arena.fight(player1, player2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static BaseBot getBot(int bot) {
        switch (bot) {
            case 1:
                return new PlayerBot();
            case 2:
                return new RedBot();
            case 3:
                return new BlueBot();
            case 4:
                return new YellowBot();
            default:
                return null;
        }
    }
}
