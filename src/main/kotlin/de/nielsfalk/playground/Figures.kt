package de.nielsfalk.playground

import de.nielsfalk.playground.Figures.*

private val rules = mapOf(
        rock to scissors,
        paper to rock,
        scissors to paper
)

enum class Figures {
    rock, paper, scissors;

    fun fight(other: Figures): Figures? {
        if (rules[this] == other) {
            return this
        }
        if (rules[other] == this) {
            return other
        }
        return null
    }
}