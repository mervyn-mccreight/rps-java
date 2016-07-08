package de.merv.rock_paper_scissors;

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
