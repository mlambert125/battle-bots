package org.example;

import java.util.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static final double TURN_DELAY = 0.5;
    public static final double ROUND_DELAY = 1.0;

    public static void main( String[] args ) {
        double turnDelay = TURN_DELAY;
        double roundDelay = ROUND_DELAY;

        if (args.length == 1) {
            turnDelay = Double.parseDouble(args[0]);
            roundDelay = turnDelay;
        } else if (args.length == 2) {
            turnDelay = Double.parseDouble(args[0]);
            roundDelay = Double.parseDouble(args[1]);
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println(Ansi.colorize("Welcome to the Bot Arena!", Ansi.BLUE));
        System.out.println("Please select the first bot:");
        System.out.println("1. PlayerBot");
        System.out.println(Ansi.colorize("2. RedBot", Ansi.RED));
        System.out.println(Ansi.colorize("3. BlueBot", Ansi.BLUE));
        System.out.println(Ansi.colorize("4. YellowBot", Ansi.YELLOW));

        int bot1 = scanner.nextInt();
        BaseBot player1 = getBot(bot1);

        System.out.println("Please select the second bot:");
        System.out.println("1. PlayerBot");
        System.out.println(Ansi.colorize("2. RedBot", Ansi.RED));
        System.out.println(Ansi.colorize("3. BlueBot", Ansi.BLUE));
        System.out.println(Ansi.colorize("4. YellowBot", Ansi.YELLOW));

        int bot2 = scanner.nextInt();
        BaseBot player2 = getBot(bot2);

        Arena arena = new Arena(turnDelay, roundDelay);
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
