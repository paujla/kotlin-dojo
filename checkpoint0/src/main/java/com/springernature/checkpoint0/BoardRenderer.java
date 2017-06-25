package com.springernature.checkpoint0;

import java.util.stream.IntStream;
import static java.util.stream.Collectors.joining;

class BoardRenderer {
    private final Board board;

    BoardRenderer(Board board) {
        this.board = board;
    }

    String render() {
        return IntStream.range(0, board.size())
                .mapToObj(this::renderRow)
                .collect(joining("-----\n"));
    }

    private String renderRow(int row) {
        return IntStream.range(0, board.size())
                .mapToObj(column -> renderCell(row, column) + squareSeparator(column))
                .collect(joining()) + "\n";
    }

    private String renderCell(int row, int column) {
        switch (board.get(row, column)) {
            case X: return "X";
            case O: return "O";
            case Empty: return " ";
            default: throw new IllegalStateException("It never happens!");
        }
    }

    private String squareSeparator(int column) {
        return column < board.size() - 1 ? "|" : "";
    }
}
