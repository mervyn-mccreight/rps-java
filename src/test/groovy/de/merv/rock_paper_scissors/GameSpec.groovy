package de.merv.rock_paper_scissors

import spock.lang.Specification

class GameSpec extends Specification {

    def "a game should consist of 100 runs"() {
        when:
        Game game = new Game(new Player({ Hand.ROCK }), new Player({ Hand.ROCK }));
        game.run();

        then:
        game.playedGames() == 100;
    }

    def "a rock player always wins against a scissors player"() {
        when:
        Game game = new Game(new Player({ Hand.ROCK }), new Player({ Hand.SCISSORS }));
        game.run();

        then:
        game.playedGames() == 100;
        game.playerOneWins() == 100;
        game.playerTwoWins() == 0;
        game.draws() == 0;
    }
}
