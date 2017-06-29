package com.springernature.checkpoint1

class GameRenderer(private val game: Game) {

    fun render(): String {
        val message =
            if (game.isGameADraw) {
                "Game is a draw!"
            } else {
                "\n" + BoardRenderer(game.board()).render() + "\n" +
                    "Player " + game.nextCellToPlace() + " please make a move: "
            }
        return message
    }
}