package de.merv.rock_paper_scissors

import spock.lang.Specification

import java.util.concurrent.ThreadLocalRandom

class GameSpec extends Specification {

    def "a game should consist of 100 runs"() {
        when:
        Game game = new Game(new Player({ Hand.ROCK }), new Player({ Hand.ROCK }))
        game.run()

        then:
        game.playedGames() == 100
    }

    def "a rock player always wins against a scissors player"() {
        when:
        Game game = new Game(new Player({ Hand.ROCK }), new Player({ Hand.SCISSORS }))
        game.run()

        then:
        game.playedGames() == 100
        game.playerOneWins() == 100
        game.playerTwoWins() == 0
        game.draws() == 0
    }

    def "wins, draws and losses should be equal to the count of played games"() {
        given:
        def randomPlayer = new Player({
            Hand.random({
                ThreadLocalRandom.current().nextInt(Hand.values().length)
            })
        })

        when:
        Game game = new Game(randomPlayer, randomPlayer)
        game.run()

        then:
        game.playerOneWins() + game.playerTwoWins() + game.draws() == game.playedGames()
    }
}
