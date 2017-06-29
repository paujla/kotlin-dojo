package com.springernature.checkpoint3

import com.springernature.checkpoint3.Cell.*

class Game(private val board: Board = Board(List(3, { List(3, { Empty }) })),
           private val currentPlayer: Cell = X) {

    fun makeMove(move: Move, cell: Cell): Game {
        if (move.row < 0 || move.row >= board.size || move.column < 0 || move.column >= board.size) {
            throw InvalidMove("Invalid move: (" + move.row + "," + move.column + ") it must be between 0 and " + (board.size - 1))
        }

        return if (board[move.row, move.column] == Empty) {
            Game(board.set(move.row, move.column, cell), if (currentPlayer == X) O else X)
        } else {
            throw InvalidMove("Invalid move: (" + move.row + "," + move.column + ") position already taken.")
        }
    }

    fun board() = Board(board)

    fun nextCellToPlace() = currentPlayer

    val isGameOver: Boolean
        get() = board.isBoardFull() || whichWinner() != null

    val isGameADraw: Boolean
        get() = board.isBoardFull() && whichWinner() == null

    fun whichWinner() =
        if (isASolutionFor(X)) X
        else if (isASolutionFor(O)) O
        else null

    private fun isASolutionFor(cell: Cell) =
        solutions.fold(false, { acc, solution ->
            if (acc) {
                true
            } else {
                board.all(solution, cell)
            }
        })

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