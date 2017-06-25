package com.springernature.checkpoint0;

public class GameRenderer {
    private Game game;

    GameRenderer(Game game) {
        this.game = game;
    }

    String render() {
        String message;
        if (game.isGameADraw()) {
            message = "Game is a draw!";
        } else {
            message = "\n" +
                    new BoardRenderer(game.board()).render() + "\n" +
                    "Player " + game.nextCellToPlace() + " please make a move: ";
        }
        return message;
    }
}
