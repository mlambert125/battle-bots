# Battle Bots!

## Description

This project runs a simple simulation where two robots battle eachother.
Each bot is derived from the `BaseBot` class and overrides the `turn` method
in order to implement its own strategy.

In the `turn` method, a bot can examine it's own state and the state of
the other bot, and then decide what action to take.  This method returns
an integer representing the action to take.  The action codes are defined
as constants in the `BaseBot` class, and are as follows:

- `BaseBot.DO_NOTHING` - Do nothing
- `BaseBot.ATTACK` - Attack the other bot for 0-10 damage (10% chance of missing)
- `BaseBot.HEAL` - Heal for 0-15 health
- `BaseBot.FIRE_ROCKET` - Attack the other bot for 10-25 damage (20% chance of missing) and reduce rockets by 1
- `BaseBot.RELOAD_ROCKETS` -  Reload rockets back to 3
- `BaseBot.DEFEND` - Defend against an attack

For attacks, the bot can choose to use a normal attack (unlimited uses) or a rocket attack (limited uses).

Each bot has three rockets that can be fired.  Once the bot is out, it must reload
them before it can fire a rocket successfully again.

The bot also has a health attribute, which starts at 100.  If the bot's health reaches 0,
it is considered dead and the game is over.

When you run the simulation, you will be prompted to choose two bots to battle.  The battle will be displayed
turn by turn, and the winner will be announced at the end.

## Task

Your task is to implement a bot that can defeat the other bots.  You can implement your bot by modifying the `PlayerBot`
class.  Specifically, you should alter the `turn` method to implement your strategy.  You can look at the other bots
for inspiration, but you should not modify them.

Each turn in the arena, the `turn` method will be called on each bot.  The bot should examine the state of itself and/or
the other bot, and then decide what action to take.  The bot should return an integer representing the action to take as
described above.

You can check your health and rocket count each turn, as well as the health and rocket count of the other bot.  You can
keep track of any state that you like by addding and modifying class level variables (see the `BlueBot` class for an 
example).

You may not call any methods on your bot or the other bot if the method starts with an underscore.  These methods are
only to be used by the arena class to orchestrate the fight.

## Running the Simulation

To run the simulation, open the App.java file and run it.  You will be prompted to choose two bots to battle.  The battle
will be displayed turn by turn, and the winner will be announced at the end.  If you want to speed up the simulation, you
can change the `TURN_DELAY` and `APP_DELAY` variables in the `App` class to a smaller number of seconds.  (Zero will make
the simulation run as fast as possible.)

## Building and Running from the Terminal

Scripts are provided to build and run the program from the terminal as well.  To build the program, run the `build.sh` 
script.  To run the program, run the `run.sh` script.  When you call run.sh, you can optionally provide arguments for
the delay timings.  If you provide one number, it is used for both delays.  If you provide two numbers, the first is used
for the turn delay and the second is used for the round delay.  For example:

To run with a 0.5 second turn delay and a 1 second round delay:

```bash
./run.sh 0.5 1
```
To run with a 0.5 second delay for both turns and rounds:

```bash
./run.sh 0.5
```

You may want to look at these scripts to see how the program is built and run from the terminal, and how you might do
similar things with your own projects.
