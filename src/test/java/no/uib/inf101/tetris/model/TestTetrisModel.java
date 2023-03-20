package no.uib.inf101.tetris.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import no.uib.inf101.grid.CellPosition;
import no.uib.inf101.grid.GridCell;
import no.uib.inf101.tetris.model.tetromino.PatternedTetrominoFactory;
import no.uib.inf101.tetris.model.tetromino.TetrominoFactory;
import no.uib.inf101.tetris.view.ViewableTetrisModel;

public class TestTetrisModel {
    @Test
    public void initialPositionOfO() {
        TetrisBoard board = new TetrisBoard(20, 10);
        TetrominoFactory factory = new PatternedTetrominoFactory("O");
        ViewableTetrisModel model = new TetrisModel(board, factory);

        List<GridCell<Character>> tetroCells = new ArrayList<>();
        for (GridCell<Character> gc : model.getFallingPiece()) {
            tetroCells.add(gc);
        }

        assertEquals(4, tetroCells.size());
        assertTrue(tetroCells.contains(new GridCell<>(new CellPosition(0, 4), 'O')));
        assertTrue(tetroCells.contains(new GridCell<>(new CellPosition(0, 5), 'O')));
        assertTrue(tetroCells.contains(new GridCell<>(new CellPosition(1, 4), 'O')));
        assertTrue(tetroCells.contains(new GridCell<>(new CellPosition(1, 5), 'O')));
        }

        @Test
        public void initialPositionOfI() {
        TetrisBoard board = new TetrisBoard(20, 10);
        TetrominoFactory factory = new PatternedTetrominoFactory("I");
        ViewableTetrisModel model = new TetrisModel(board, factory);

        List<GridCell<Character>> tetroCells = new ArrayList<>();
        for (GridCell<Character> gc : model.getFallingPiece()) {
            tetroCells.add(gc);
        }

        assertEquals(4, tetroCells.size());
        assertTrue(tetroCells.contains(new GridCell<>(new CellPosition(0, 3), 'I')));
        assertTrue(tetroCells.contains(new GridCell<>(new CellPosition(0, 4), 'I')));
        assertTrue(tetroCells.contains(new GridCell<>(new CellPosition(0, 5), 'I')));
        assertTrue(tetroCells.contains(new GridCell<>(new CellPosition(0, 5), 'I')));
    }


    @Test
    public void TestdropTetormino(){
    TetrisBoard board = new TetrisBoard(20,10);
    TetrominoFactory factory = new PatternedTetrominoFactory("Z");

    TetrisModel fallingTetromino = new TetrisModel(board, factory);



    fallingTetromino.dropTetromino();
    List<GridCell<Character>> tetroCellsDropped = new ArrayList<>();
    for (GridCell<Character> gc : fallingTetromino.getFallingPiece()) {
        tetroCellsDropped.add(gc);
    }

    assertEquals(4, tetroCellsDropped.size());
    assertTrue(board.get(new CellPosition(19, 4)) == 'Z');
    assertTrue(board.get(new CellPosition(19, 5)) == 'Z');
    assertTrue(board.get(new CellPosition(18, 4)) == 'Z');
    assertTrue(board.get(new CellPosition(18, 4)) == 'Z');

    }
    
    @Test
    public void moveTetromino(){
    TetrisBoard board = new TetrisBoard(20,10);
    TetrominoFactory factory = new PatternedTetrominoFactory("O");

    TetrisModel movedTettromino = new TetrisModel(board, factory);



    movedTettromino.moveTetromino(3,3);
    List<GridCell<Character>> tetroCellsMoved = new ArrayList<>();
    for (GridCell<Character> gc : movedTettromino.getFallingPiece()) {
        tetroCellsMoved.add(gc);
    }

    //Checks if the tetromino is moved out of its strating position
    assertEquals(4, tetroCellsMoved.size());
    assertFalse(tetroCellsMoved.contains(new GridCell<>(new CellPosition(0, 4), 'O')));
    assertFalse(tetroCellsMoved.contains(new GridCell<>(new CellPosition(0, 5), 'O')));
    assertFalse(tetroCellsMoved.contains(new GridCell<>(new CellPosition(1, 4), 'O')));
    assertFalse(tetroCellsMoved.contains(new GridCell<>(new CellPosition(1, 5), 'O')));

    }

    @Test
    public void moveTetrominoFalse(){
    TetrisBoard board = new TetrisBoard(10,10);
    TetrominoFactory factory = new PatternedTetrominoFactory("O");
    TetrisModel movedTettromino = new TetrisModel(board, factory);
    //Makes a 'T' Tetromino
    board.set(new CellPosition(2, 6), 'T');
    board.set(new CellPosition(2, 7), 'T');
    board.set(new CellPosition(2, 8), 'T');
    board.set(new CellPosition(3, 7), 'T');
    
    //Tries to move the Tetromino to the position of the T tetromino
    movedTettromino.moveTetromino(2,1);
    List<GridCell<Character>> tetroCellsMoved = new ArrayList<>();
    for (GridCell<Character> gc : movedTettromino.getFallingPiece()) {
        tetroCellsMoved.add(gc);
    }

    //The tetromino should stay in place since the cells is already occupied by the 'T' tetromino
    //Checks if the tetromino is not moved out of its strating position
    assertEquals(4, tetroCellsMoved.size());
    assertTrue(tetroCellsMoved.contains(new GridCell<>(new CellPosition(0, 4), 'O')));
    assertTrue(tetroCellsMoved.contains(new GridCell<>(new CellPosition(0, 5), 'O')));
    assertTrue(tetroCellsMoved.contains(new GridCell<>(new CellPosition(1, 4), 'O')));
    assertTrue(tetroCellsMoved.contains(new GridCell<>(new CellPosition(1, 5), 'O')));

    }
}
