package com.springernature.checkpoint0;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.springernature.checkpoint0.Cell.Empty;
import static com.springernature.checkpoint0.Cell.X;
import static java.util.Arrays.asList;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class BoardTest {

    @Test
    public void setAValueOnTheBoard() {
        List<List<Cell>> lists = IntStream.range(0, 3)
                .mapToObj(index -> new ArrayList<>(asList(Empty, Empty, Empty)))
                .collect(Collectors.toList());
        Board board = new Board(lists);
        Board actual = board.set(0, 1, X);

        assertThat(actual.get(0,1), equalTo(X));
    }
}