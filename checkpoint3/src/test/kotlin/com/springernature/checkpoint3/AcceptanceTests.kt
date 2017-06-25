package com.springernature.checkpoint3

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import com.springernature.checkpoint3.Cell.O
import com.springernature.checkpoint3.Cell.X
import org.junit.Before
import org.junit.Test
import java.util.*

class AcceptanceTests {

    private lateinit var game: Game
    private lateinit var inputs: LinkedList<String>
    private lateinit var outputs: LinkedList<String>
    private lateinit var ui: ConsoleUI

    @Before fun setUp() {
        game = Game()
        inputs = LinkedList<String>()
        outputs = LinkedList<String>()
        ui = ConsoleUI(game, { if (inputs.isEmpty()) null else inputs.pop() }) { outputs.push(it) }
    }

    @Test fun `a game in which noughts win`() {
        ui.run()
        assertThat(outputs.pollFirst(), equalTo(
                "\n" +
                        " | | \n" +
                        "-----\n" +
                        " | | \n" +
                        "-----\n" +
                        " | | \n" +
                        "\n" +
                        "Player X please make a move: "
        ))

        inputs.add("0 0")
        ui.run()
        assertThat(outputs.pollFirst(), equalTo(
                "\n" +
                        "X| | \n" +
                        "-----\n" +
                        " | | \n" +
                        "-----\n" +
                        " | | \n" +
                        "\n" +
                        "Player O please make a move: "
        ))

        inputs.add("1 1")
        ui.run()
        assertThat(ui.render(), equalTo(
                "\n" +
                        "X| | \n" +
                        "-----\n" +
                        " |O| \n" +
                        "-----\n" +
                        " | | \n" +
                        "\n" +
                        "Player X please make a move: "
        ))

        inputs.add("1 2")
        ui.run()
        assertThat(ui.render(), equalTo(
                "\n" +
                        "X| | \n" +
                        "-----\n" +
                        " |O|X\n" +
                        "-----\n" +
                        " | | \n" +
                        "\n" +
                        "Player O please make a move: "
        ))

        inputs.add("0 2")
        ui.run()
        assertThat(ui.render(), equalTo(
                "\n" +
                        "X| |O\n" +
                        "-----\n" +
                        " |O|X\n" +
                        "-----\n" +
                        " | | \n" +
                        "\n" +
                        "Player X please make a move: "
        ))

        inputs.add("1 0")
        ui.run()
        assertThat(ui.render(), equalTo(
                "\n" +
                        "X| |O\n" +
                        "-----\n" +
                        "X|O|X\n" +
                        "-----\n" +
                        " | | \n" +
                        "\n" +
                        "Player O please make a move: "
        ))

        inputs.add("2 0")
        ui.run()

        assertThat(ui.render(), equalTo(
                "\n" +
                        "X| |O\n" +
                        "-----\n" +
                        "X|O|X\n" +
                        "-----\n" +
                        "O| | \n" +
                        "\n" +
                        "O is the winner!\n"
        ))
    }

    @Test fun `game is a draw`() {
        val game = Game()
        val actualGame = game.makeMove(Move(0, 0), X)
                .makeMove(Move(1, 0), O)
                .makeMove(Move(1, 1), X)
                .makeMove(Move(2, 0), O)
                .makeMove(Move(2, 1), X)
                .makeMove(Move(0, 1), O)
                .makeMove(Move(0, 2), X)
                .makeMove(Move(2, 2), O)
                .makeMove(Move(1, 2), X)

        val actual = GameRenderer(actualGame).render()

        assertThat(actual, equalTo(
                "\n" +
                        "X|O|X\n" +
                        "-----\n" +
                        "O|X|X\n" +
                        "-----\n" +
                        "O|X|O\n" +
                        "\n" +
                        "Game is a draw!"
        ))
    }

    @Test fun `handle invalid input string`() {
        inputs.add("some string")
        ui.run()

        assertThat(outputs.pollFirst(), equalTo(
                "Invalid input 'some string', please make sure it's zero-indexed 'x y' coordinates\n" +
                        "\n" +
                        " | | \n" +
                        "-----\n" +
                        " | | \n" +
                        "-----\n" +
                        " | | \n" +
                        "\n" +
                        "Player X please make a move: "
        ))
    }

    @Test fun `handle invalid input number`() {
        inputs.add("123")
        ui.run()

        assertThat(outputs.pollFirst(), equalTo(
                "Invalid input '123', please make sure it's zero-indexed 'x y' coordinates\n" +
                        "\n" +
                        " | | \n" +
                        "-----\n" +
                        " | | \n" +
                        "-----\n" +
                        " | | \n" +
                        "\n" +
                        "Player X please make a move: "
        ))
    }
}
