package de.merv.rock_paper_scissors;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;

public class Application {

    public static void main(String[] args) {
        Player krapotke = new Player(() -> Hand.ROCK);
        Supplier<Hand> strategy = () -> Hand.random(() -> ThreadLocalRandom.current()
                .nextInt(Hand.values().length));
        Player randomPlayer = new Player(strategy);
        Game game = new Game(krapotke, randomPlayer);

        game.run();

        game.printState(System.out);
    }
}
