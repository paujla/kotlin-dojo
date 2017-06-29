package com.springernature.checkpoint1

import java.io.IOException

class ConsoleUI(private var game: Game, private val `in`: () -> String? = ::readLine, private val out: (String) -> Unit = ::println) {

    fun run() {
        out(render())

        while (!game.isGameOver) {
            try {
                val input = `in`() ?: break
                val move = parseInput(input)
                game = game.makeMove(move, game.nextCellToPlace())
                out(render())
            } catch (invalidMove: Game.InvalidMove) {
                out(invalidMove.message + "\n" + render())
            } catch (e: IOException) {
                out("Unrecoverable error")
            }
        }
    }

    fun render() = GameRenderer(game).render()

    private fun parseInput(input: String): Move {
        try {
            val split = input.split(" ")
            if (split.size < 2) {
                throw Game.InvalidMove(invalidInputMessage(input))
            }
            val row = Integer.parseInt(split[0])
            val column = Integer.parseInt(split[1])
            return Move(row, column)
        } catch (e: NumberFormatException) {
            throw Game.InvalidMove(invalidInputMessage(input))
        }

    }

    private fun invalidInputMessage(s: String) =
        "Invalid input '$s', please make sure it's zero-indexed 'x y' coordinates"
}
