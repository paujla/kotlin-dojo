package com.springernature.checkpoint3

class GameRenderer(private val game: Game) {

    fun render(): String {
        val message =
            if (game.isGameADraw) {
                "Game is a draw!"
            } else {
                game.whichWinner()?.let { it.name + " is the winner!\n" } ?:
                    "Player " + game.nextCellToPlace() + " please make a move: "
            }
        return "\n" +
            BoardRenderer(game.board()).render() + "\n" +
            message
    }
}