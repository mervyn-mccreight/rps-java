package de.merv.rock_paper_scissors;

public enum Hand {
    ROCK,
    PAPER,
    SCISSORS;

    public GameResult plays(Hand opponent) {
        if (this.equals(opponent)) {
            return GameResult.DRAW;
        }

        return null;
    }
}
