package com.springernature.checkpoint3

fun main(args: Array<String>) {
    val game = Game()
    val ui = ConsoleUI(game)
    ui.run()
}