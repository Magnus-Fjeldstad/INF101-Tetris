package no.uib.inf101.tetris.model.tetromino;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import no.uib.inf101.grid.CellPosition;
import no.uib.inf101.grid.GridCell;
import no.uib.inf101.tetris.model.TetrisBoard;

public class TestTetromino {
    @Test
    public void testHashCodeAndEquals() {
    Tetromino t1 = Tetromino.newTetromino('T');
    Tetromino t2 = Tetromino.newTetromino('T');
    Tetromino t3 = Tetromino.newTetromino('T').shiftedBy(1, 0);
    Tetromino s1 = Tetromino.newTetromino('S');
    Tetromino s2 = Tetromino.newTetromino('S').shiftedBy(0, 0);
    
    assertEquals(t1, t2);
    assertEquals(s1, s2);
    assertEquals(t1.hashCode(), t2.hashCode());
    assertEquals(s1.hashCode(), s2.hashCode());
    assertNotEquals(t1, t3);
    assertNotEquals(t1, s1);
    }

    @Test
    public void tetrominoIterationOfT() {
    // Create a standard 'T' tetromino placed at (10, 100) to test
    Tetromino tetro = Tetromino.newTetromino('T');
    tetro = tetro.shiftedBy(10, 100);

    // Collect which objects are iterated through
    List<GridCell<Character>> objs = new ArrayList<>();
    for (GridCell<Character> gc : tetro) {
        objs.add(gc);
    }

    // Check that we got the expected GridCell objects
    assertEquals(4, objs.size());
    assertTrue(objs.contains(new GridCell<>(new CellPosition(11, 100), 'T')));
    assertTrue(objs.contains(new GridCell<>(new CellPosition(11, 101), 'T')));
    assertTrue(objs.contains(new GridCell<>(new CellPosition(11, 102), 'T')));
    assertTrue(objs.contains(new GridCell<>(new CellPosition(12, 101), 'T')));
    }

    @Test
    public void tetrominoIterationOfS() {
    // Create a standard 'S' tetromino placed at (10, 100) to test
    Tetromino tetro = Tetromino.newTetromino('S');
    tetro = tetro.shiftedBy(10, 100);

    // Collect which objects are iterated through
    List<GridCell<Character>> objs = new ArrayList<>();
    for (GridCell<Character> gc : tetro) {
        objs.add(gc);
    }

    // Check that we got the expected GridCell objects
    assertEquals(4, objs.size());
    assertTrue(objs.contains(new GridCell<>(new CellPosition(12, 100), 'S')));
    assertTrue(objs.contains(new GridCell<>(new CellPosition(12, 101), 'S')));
    assertTrue(objs.contains(new GridCell<>(new CellPosition(11, 101), 'S')));
    assertTrue(objs.contains(new GridCell<>(new CellPosition(11, 102), 'S')));
    }

    @Test
    public void movedByToShiftedBy() {
    // Create a standard 'S' tetromino placed at (20, 200) to test
    Tetromino tetro = Tetromino.newTetromino('S');
    //Moved the tetro two times by 20 rows and 200 cols
    tetro = tetro.shiftedBy(10, 100);
    tetro = tetro.shiftedBy(10, 100);

    // Collect which objects are iterated through
    List<GridCell<Character>> objs = new ArrayList<>();
    for (GridCell<Character> gc : tetro) {
        objs.add(gc);
    }

    // Check that we got the expected GridCell objects
    assertEquals(4, objs.size());
    assertTrue(objs.contains(new GridCell<>(new CellPosition(22, 200), 'S')));
    assertTrue(objs.contains(new GridCell<>(new CellPosition(22, 201), 'S')));
    assertTrue(objs.contains(new GridCell<>(new CellPosition(21, 201), 'S')));
    assertTrue(objs.contains(new GridCell<>(new CellPosition(21, 202), 'S')));
    }



    @Test
    public void shiftedToTopCenterOfO() {
    // Create a standard 'S' tetromino placed at (20, 200) to test
    Tetromino tetro = Tetromino.newTetromino('O');
    //Moved the tetro two times by 20 rows and 200 cols
    tetro = tetro.shiftedToTopCenterOf(new TetrisBoard(5, 9));

    // Collect which objects are iterated through
    List<GridCell<Character>> objs = new ArrayList<>();
    for (GridCell<Character> gc : tetro) {
        objs.add(gc);
    }

    // Check that we got the expected GridCell objects
    assertEquals(4, objs.size());
    System.out.println(tetro.leftUpperPos.row());
    System.out.println(tetro.leftUpperPos.col());
    assertTrue(objs.contains(new GridCell<>(new CellPosition(0, 3), 'O')));
    assertTrue(objs.contains(new GridCell<>(new CellPosition(0,4), 'O')));
    assertTrue(objs.contains(new GridCell<>(new CellPosition(1,3), 'O')));
    assertTrue(objs.contains(new GridCell<>(new CellPosition(1,4), 'O')));
    }


    @Test
    public void getRotatedCopy() {
    // Create a standard 'S' tetromino placed at (10, 100) to test
    Tetromino tetro = Tetromino.newTetromino('S');
    //Moved the tetro two times by 10 rows and 100 cols
    tetro = tetro.shiftedBy(10, 100);
    //rotates the tetromino object clockwise on its center cell
    tetro = tetro.getRotatedCopy();

    // Collect which objects are iterated through
    List<GridCell<Character>> objs = new ArrayList<>();
    for (GridCell<Character> gc : tetro) {
        objs.add(gc);
    }

    //Checks if the tetromino was rotated
    assertEquals(4, objs.size());
    assertTrue(objs.contains(new GridCell<>(new CellPosition(10, 100), 'S')));
    assertTrue(objs.contains(new GridCell<>(new CellPosition(11, 100), 'S')));
    assertTrue(objs.contains(new GridCell<>(new CellPosition(12, 101), 'S')));
    assertTrue(objs.contains(new GridCell<>(new CellPosition(11, 101), 'S')));
    
    }
}


