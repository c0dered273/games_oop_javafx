package ru.job4j.chess.figures.black;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class BishopBlackTest {
    @Test
    public void createFigureTest() {
        Figure bishop = new BishopBlack(Cell.C1);
        assertThat(bishop.position(), is(Cell.C1));
    }

    @Test
    public void copyTest() {
        Figure bishop_old = new BishopBlack(Cell.C1);
        Figure bishop_new = bishop_old.copy(Cell.A3);
        assertThat(bishop_new.position(), is(Cell.A3));
    }

    @Test
    public void positiveWayTest() {
        Figure bishop = new BishopBlack(Cell.C1);
        Cell[] result = bishop.way(Cell.C1, Cell.G5);
        Cell[] expect = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(result, is(expect));
    }

    @Test
    public void negativeWayTest() {
        Figure bishop = new BishopBlack(Cell.D4);
        Cell[] result = bishop.way(Cell.D4, Cell.B6);
        Cell[] expect = {Cell.C5, Cell.B6};
        assertThat(result, is(expect));
    }

    @Test(expected = IllegalStateException.class)
    public void nonDiagonalTest() {
        Figure bishop = new BishopBlack(Cell.C2);
        Cell[] result = bishop.way(Cell.C2, Cell.B5);
    }

    @Test
    public void zeroWayTest() {
        Figure bishop = new BishopBlack(Cell.C2);
        Cell[] result = bishop.way(Cell.C2, Cell.C2);
        Cell[] expect = {};
        assertThat(result, is(expect));
    }
}
