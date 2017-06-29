package com.springernature.checkpoint1

import com.springernature.checkpoint1.Cell.O
import com.springernature.checkpoint1.Cell.X
import org.hamcrest.core.IsEqual.equalTo
import org.junit.Assert.assertThat
import org.junit.Test

class GameTests {

    @Test fun `initial state of the game`() {
        val game = Game()

        assertThat(game.nextCellToPlace(), equalTo(X))
        assertThat(BoardRenderer(game.board()).render(), equalTo(
            " | | \n" +
            "-----\n" +
            " | | \n" +
            "-----\n" +
            " | | \n"
        ))
    }

    @Test fun `cross makes the first move`() {
        val game = Game()
        val gameAfterMove = game.makeMove(Move(1, 1), X)

        assertThat(gameAfterMove.nextCellToPlace(), equalTo(O))
        assertThat(BoardRenderer(gameAfterMove.board()).render(), equalTo(
            " | | \n" +
            "-----\n" +
            " |X| \n" +
            "-----\n" +
            " | | \n"
        ))
    }

    @Test(expected = Game.InvalidMove::class)
    fun `player makes invalid move`() {
        val game = Game()
        game.makeMove(Move(100, 100), X)
    }
}