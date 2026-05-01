package de.merv.rock_paper_scissors;

import java.io.PrintStream;
import java.text.MessageFormat;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Game {

    private static final int RUNS = 100;

    private final Player playerOne;
    private final Player playerTwo;
    private final List<GameResult> results = new LinkedList<>();

    public Game(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public void run() {
        for (int i = 0; i < RUNS; i++) {
            results.add(playerOne.plays().plays(playerTwo.plays()));
        }
    }

    public long playedGames() {
        return results.size();
    }

    public long playerOneWins() {
        return Collections.frequency(results, GameResult.WIN);
    }

    public long playerTwoWins() {
        return Collections.frequency(results, GameResult.LOSE);
    }

    public long draws() {
        return playedGames() - (playerOneWins() + playerTwoWins());
    }

    public void printState(PrintStream out) {
        var message = MessageFormat.format("Games played: {0}" + System.lineSeparator() +
                        "# of wins of Player One: {1}" + System.lineSeparator() +
                        "# of wins of Player Two: {2}" + System.lineSeparator() +
                        "# of draws: {3}" + System.lineSeparator(),
                playedGames(),
                playerOneWins(),
                playerTwoWins(),
                draws());

        out.print(message);
    }
}
