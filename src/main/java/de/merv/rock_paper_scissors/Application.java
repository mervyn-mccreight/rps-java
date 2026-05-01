package de.merv.rock_paper_scissors;

import java.util.random.RandomGenerator;

public class Application {

    static void main() {
        var rockPlayer = new Player(() -> Hand.ROCK);
        var definedHands = Hand.values().length;
        var randomPlayer = new Player(() -> Hand.random(() -> RandomGenerator.getDefault().nextInt(definedHands)));
        var game = new Game(rockPlayer, randomPlayer);

        game.run();

        game.printState(System.out);
    }
}
