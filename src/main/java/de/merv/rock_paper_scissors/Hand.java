package de.merv.rock_paper_scissors;

import java.util.function.IntSupplier;

public enum Hand {
    ROCK,
    PAPER,
    SCISSORS;

    private Hand winsAgainst;

    static {
        ROCK.winsAgainst = SCISSORS;
        PAPER.winsAgainst = ROCK;
        SCISSORS.winsAgainst = PAPER;
    }

    private static final Hand[] CACHE = values();

    public static Hand random(IntSupplier randomNumberGenerator) {
        return CACHE[randomNumberGenerator.getAsInt()];
    }

    public GameResult plays(Hand opponent) {
        return switch (opponent) {
            case Hand x when this.equals(x) -> GameResult.DRAW;
            case Hand x when winsAgainst.equals(x) -> GameResult.WIN;
            default -> GameResult.LOSE;
        };
    }
}
