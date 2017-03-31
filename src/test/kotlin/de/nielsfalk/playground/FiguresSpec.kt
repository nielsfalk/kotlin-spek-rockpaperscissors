package de.nielsfalk.playground

import com.winterbe.expekt.should
import de.nielsfalk.playground.Figures.*
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.data_driven.data
import org.jetbrains.spek.data_driven.on


/**
 * @author Niels Falk
 */
object FiguresSpec : Spek({
    describe("the rules") {
        on("equal figures (%s and %s)",
                data(rock, rock),
                data(paper, paper),
                data(scissors, scissors)) { first, second ->
            it("should tie") {
                first.fight(second).should.be.`null`
            }
        }

        on("%s fights %s",
                data(rock, scissors, expected = rock),
                data(rock, paper, expected = paper),
                data(scissors, paper, expected = scissors),
                data(scissors, rock, expected = rock),
                data(paper, rock, expected = paper),
                data(paper, scissors, expected = scissors)) { first, second, expectedWinner ->
            it("should win ${expectedWinner}") {
                first.fight(second).should.equal(expectedWinner)
            }
        }
    }
})