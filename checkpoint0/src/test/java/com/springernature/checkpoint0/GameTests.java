package com.springernature.checkpoint0;

import org.junit.Test;

import static com.springernature.checkpoint0.Cell.O;
import static com.springernature.checkpoint0.Cell.X;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class GameTests {

    @Test
    public void initialStateOfTheGame() {
        Game game = new Game();

        assertThat(game.nextCellToPlace(), equalTo(X));
        assertThat(new BoardRenderer(game.board()).render(), equalTo(
                " | | \n" +
                        "-----\n" +
                        " | | \n" +
                        "-----\n" +
                        " | | \n"
        ));
    }

    @Test
    public void crossMakesTheFirstMove() throws Game.InvalidMove {
        Game game = new Game();
        Game gameAfterMove = game.makeMove(new Move(1, 1), X);

        assertThat(gameAfterMove.nextCellToPlace(), equalTo(O));
        assertThat(new BoardRenderer(gameAfterMove.board()).render(), equalTo(
                " | | \n" +
                        "-----\n" +
                        " |X| \n" +
                        "-----\n" +
                        " | | \n"
        ));
    }

    @Test(expected = Game.InvalidMove.class)
    public void playerMakesInvalidMove() throws Game.InvalidMove {
        Game game = new Game();
        game.makeMove(new Move(100, 100), X);
    }
}