package com.springernature.checkpoint0;

import java.util.ArrayList;
import java.util.List;
import static java.util.stream.Collectors.toList;

class Board {
    private final List<List<Cell>> grid;

    Board(List<List<Cell>> grid) {
        this.grid = grid;
    }

    Board(Board board) {
        grid = new ArrayList<>(board.size());
        for (int row = 0; row < board.size(); row++) {
            grid.add(new ArrayList<>(board.grid.get(row)));
        }
    }

    Board set(int row, int column, Cell value) {
        List<List<Cell>> gridCopy = grid.stream().map(ArrayList::new).collect(toList());
        gridCopy.get(row).set(column, value);
        return new Board(gridCopy);
    }

    Cell get(int row, int column) {
        return grid.get(row).get(column);
    }

    int size() {
        return grid.size();
    }
}
