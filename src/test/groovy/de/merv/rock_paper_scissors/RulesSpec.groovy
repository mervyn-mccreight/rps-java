package de.merv.rock_paper_scissors

import spock.lang.Specification
import spock.lang.Unroll

import static de.merv.rock_paper_scissors.GameResult.*
import static de.merv.rock_paper_scissors.Hand.*

class HandsSpec extends Specification {

    @Unroll
    def "#one vs. #two should be a #expectedResult for #one"() {
        when:
        GameResult result = one.plays(two);

        then:
        result == expectedResult;

        where:
        one      | two      || expectedResult
        ROCK     | ROCK     || DRAW
        ROCK     | PAPER    || LOSE
        ROCK     | SCISSORS || WIN
        PAPER    | PAPER    || DRAW
        PAPER    | SCISSORS || LOSE
        PAPER    | ROCK     || WIN
        SCISSORS | SCISSORS || DRAW
        SCISSORS | ROCK     || LOSE
        SCISSORS | PAPER    || WIN
    }
}
