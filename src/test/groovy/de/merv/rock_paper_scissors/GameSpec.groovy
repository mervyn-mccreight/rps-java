package de.merv.rock_paper_scissors

import spock.lang.Specification

class GameSpec extends Specification {

    def "a game should consist of 100 runs"() {
        when:
        Game game = new Game();
        game.run();

        then:
        game.playedGames() == 100;
    }
}
