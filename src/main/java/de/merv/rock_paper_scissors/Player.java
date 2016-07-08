package de.merv.rock_paper_scissors;

import java.util.function.Supplier;

public class Player {

    private final Supplier<Hand> pick;

    public Player(Supplier<Hand> pick) {
        this.pick = pick;
    }

    public Hand plays() {
        return pick.get();
    }
}
