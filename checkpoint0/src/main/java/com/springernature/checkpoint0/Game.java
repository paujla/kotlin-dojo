package com.springernature.checkpoint0;

import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.springernature.checkpoint0.Cell.*;
import static java.util.Arrays.asList;

class Game {
    private final Board board;
    private final Cell currentPlayer;

    Game() {
        this(new Board(IntStream.range(0, 3)
                .mapToObj(index -> new ArrayList<>(asList(Empty, Empty, Empty)))
                .collect(Collectors.toList())), X);
    }

    private Game(Board board, Cell cell) {
        this.board = board;
        this.currentPlayer = cell;
    }

    Game makeMove(Move move, Cell cell) throws InvalidMove {
        if (move.row < 0 || move.row >= board.size() || move.column < 0 || move.column >= board.size()) {
            throw new InvalidMove("Invalid move: (" + move.row + "," + move.column + ") it must be between 0 and " + (board.size() - 1));
        }

        return new Game(board.set(move.row, move.column, cell), Objects.equals(currentPlayer, X) ? O : X);
    }

    Board board() {
        return new Board(board);
    }

    Cell nextCellToPlace() {
        return currentPlayer;
    }

    boolean isGameOver() {
        // TODO implement later
        return false;
    }

    boolean isGameADraw() {
        // TODO implement later
        return false;
    }

    static class InvalidMove extends Exception {
        InvalidMove(String message) {
            super(message);
        }
    }
}
