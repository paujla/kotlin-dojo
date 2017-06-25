package com.springernature.checkpoint1

import com.springernature.checkpoint1.Cell.*

class Game(private val board: Board = Board(List(3, { List(3, { Empty }) })),
           private val currentPlayer: Cell = X) {

    fun makeMove(move: Move, cell: Cell): Game {
        if (move.row < 0 || move.row >= board.size || move.column < 0 || move.column >= board.size) {
            throw InvalidMove("Invalid move: (" + move.row + "," + move.column + ") it must be between 0 and " + (board.size - 1))
        }

        return Game(board.set(move.row, move.column, cell), if (currentPlayer == X) O else X)
    }

    fun board() = Board(board)

    fun nextCellToPlace() = currentPlayer

    // TODO implement later
    val isGameOver: Boolean
        get() = false

    // TODO implement later
    val isGameADraw: Boolean
        get() = false

    // TODO implement later
    internal class InvalidMove(message: String) : Exception(message)
}
