package de.merv.rock_paper_scissors;

public class Application {

    public static void main(String[] args) {
        Player krapotke = new Player(() -> Hand.ROCK);
        Player randomPlayer = new Player(Hand::random);
        Game game = new Game(krapotke, randomPlayer);

        game.run();

        game.printState(System.out);
    }
}
