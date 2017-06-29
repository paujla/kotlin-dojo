package com.springernature.checkpoint2

import com.springernature.checkpoint2.Cell.*

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

    fun whichWinner(): Cell? {
//        if (isASolutionFor(X))
        TODO("not implemented yet")
    }

    private fun isASolutionFor(cell: Cell): Boolean {
//        solutions.fold(false, { acc, solution ->
        TODO("not implemented yet")
    }

    internal class InvalidMove(message: String) : Exception(message)
}

val solutions = listOf(
        listOf(Pair(0, 0), Pair(0, 1), Pair(0, 2)),
        listOf(Pair(1, 0), Pair(1, 1), Pair(1, 2)),
        listOf(Pair(2, 0), Pair(2, 1), Pair(2, 2)),
        listOf(Pair(0, 0), Pair(1, 0), Pair(2, 0)),
        listOf(Pair(0, 1), Pair(1, 1), Pair(2, 1)),
        listOf(Pair(0, 2), Pair(1, 2), Pair(2, 2)),
        listOf(Pair(0, 0), Pair(1, 1), Pair(2, 2)),
        listOf(Pair(2, 0), Pair(1, 1), Pair(0, 2))
)