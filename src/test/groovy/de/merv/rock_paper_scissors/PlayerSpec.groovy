package de.merv.rock_paper_scissors

import spock.lang.Specification
import spock.lang.Unroll

import static de.merv.rock_paper_scissors.Hand.*

class PlayerSpec extends Specification {

    @Unroll
    def "a static player for #pick should play #pick"() {
        when:
        Hand playersHand = new Player().plays();

        then:
        playersHand == pick;

        where:
        pick     | _
        ROCK     | _
        PAPER    | _
        SCISSORS | _
    }
}
