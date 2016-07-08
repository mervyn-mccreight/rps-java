package de.merv.rock_paper_scissors;

import java.security.SecureRandom;

public enum Hand {
    ROCK,
    PAPER,
    SCISSORS;

    private Hand winsAgainst;
    private static final SecureRandom random = new SecureRandom();

    static {
        ROCK.winsAgainst = SCISSORS;
        PAPER.winsAgainst = ROCK;
        SCISSORS.winsAgainst = PAPER;
    }

    public static Hand random() {
        return values()[random.nextInt(values().length)];
    }

    public GameResult plays(Hand opponent) {
        if (this.equals(opponent)) {
            return GameResult.DRAW;
        }

        if (opponent.equals(winsAgainst)) {
            return GameResult.WIN;
        }

        return GameResult.LOSE;
    }
}
