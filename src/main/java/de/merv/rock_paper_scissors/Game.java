package de.merv.rock_paper_scissors;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class Game {

    private static final int RUNS = 100;

    private final Player playerOne;
    private final Player playerTwo;

    private List<GameResult> results = new LinkedList<>();

    public Game(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public void run() {
        IntStream.range(0, RUNS).forEach(
                i -> results.add(playerOne.plays().plays(playerTwo.plays()))
        );
    }

    public long playedGames() {
        return results.size();
    }

    public long playerOneWins() {
        return results.stream().filter(r -> r.equals(GameResult.WIN)).count();
    }

    public long playerTwoWins() {
        return results.stream().filter(r -> r.equals(GameResult.LOSE)).count();
    }

    public long draws() {
        return playedGames() - (playerOneWins() + playerTwoWins());
    }
}
