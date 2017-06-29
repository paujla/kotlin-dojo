package com.springernature.checkpoint2

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

    fun all(coordinates: List<Pair<Int, Int>>, cell: Cell): Boolean {
        TODO("not implemented yet")
    }

    fun isFull(): Boolean {
        TODO("not implemented yet")
    }
}
