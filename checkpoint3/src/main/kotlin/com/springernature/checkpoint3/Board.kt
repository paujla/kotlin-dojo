package com.springernature.checkpoint3

import com.springernature.checkpoint3.Cell.Empty
import java.util.*

data class Board(private val grid: List<List<Cell>>) {

    constructor(board: Board) : this(board.grid)

    operator fun set(row: Int, column: Int, value: Cell): Board {
        val gridCopy = grid.map { ArrayList(it) }
        gridCopy[row][column] = value
        return Board(gridCopy)
    }

    operator fun get(row: Int, column: Int) = grid[row][column]

    val size = grid.size

    fun isBoardFull() =
            grid.all { subList -> subList.all { it != Empty } }

    fun all(coordinates: List<Pair<Int, Int>>, cell: Cell) =
            coordinates.all { (first, second) -> get(first, second) == cell }
}