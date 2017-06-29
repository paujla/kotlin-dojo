package com.springernature.checkpoint3

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import com.springernature.checkpoint3.Cell.*
import org.junit.Test

class BoardTest {

    @Test fun `set a value on the board`() {
        val lists = 0.until(3).map { List(3, { Empty }) }

        val board = Board(lists)
        val actual = board.set(0, 1, X)

        assertThat(actual[0, 1], equalTo(X))
    }

    @Test fun `board is not full`() {
        val board = Board(listOf(
            listOf(X, X, Empty),
            listOf(O, X, X),
            listOf(X, O, O)))

        assertThat(board.isBoardFull(), equalTo(false))
    }

    @Test fun `board is full`() {
        val board = Board(listOf(
            listOf(X, X, O),
            listOf(O, X, X),
            listOf(X, O, O)))

        assertThat(board.isBoardFull(), equalTo(true))
    }

    @Test fun `contains the same cell in all the coordinates provided`() {
        val board = Board(listOf(
            listOf(X, X, O),
            listOf(O, X, X),
            listOf(X, O, X)))
        val actual = board.all(listOf(Pair(0, 0), Pair(1, 1), Pair(2, 2)), X)

        assertThat(actual, equalTo(true))
    }
}