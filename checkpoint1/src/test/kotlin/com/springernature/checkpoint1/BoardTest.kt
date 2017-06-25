package com.springernature.checkpoint1

import com.springernature.checkpoint1.Cell.Empty
import com.springernature.checkpoint1.Cell.X
import org.hamcrest.core.IsEqual.equalTo
import org.junit.Assert.assertThat
import org.junit.Test

class BoardTest {

    @Test
    fun `set a value on the board`() {
        val lists = 0.until(3).map { List(3, { Empty }) }

        val board = Board(lists)
        val actual = board.set(0, 1, X)

        assertThat(actual[0, 1], equalTo(X))
    }
}