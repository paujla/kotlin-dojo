package com.springernature.checkpoint1

import com.springernature.checkpoint1.Cell.*

class BoardRenderer(private val board: Board) {

    fun render() =
            0.until(board.size)
                    .map { this.renderRow(it) }
                    .joinToString("-----\n")

    private fun renderRow(row: Int) =
            0.until(board.size)
                    .map { column -> renderCell(row, column) + squareSeparator(column) }
                    .joinToString("") + "\n"

    private fun renderCell(row: Int, column: Int) =
            when (board[row, column]) {
                X -> "X"
                O -> "O"
                Empty -> " "
            }

    private fun squareSeparator(column: Int) = if (column < board.size - 1) "|" else ""
}
