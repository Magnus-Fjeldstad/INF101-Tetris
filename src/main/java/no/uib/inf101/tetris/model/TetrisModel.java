package no.uib.inf101.tetris.model;

import no.uib.inf101.grid.GridCell;
import no.uib.inf101.grid.GridDimension;
import no.uib.inf101.tetris.model.tetromino.Tetromino;
import no.uib.inf101.tetris.model.tetromino.TetrominoFactory;
import no.uib.inf101.tetris.view.ViewableTetrisModel;

public class TetrisModel implements ViewableTetrisModel {

    TetrisBoard board;
    TetrominoFactory tetrominoFactory;
    Tetromino tetromino;

    public TetrisModel(TetrisBoard board,TetrominoFactory tetrominoFactory){
        this.board = board;
        this.tetrominoFactory = tetrominoFactory;
        this.tetromino = tetrominoFactory.getNext();
        tetromino = tetromino.shiftedToTopCenterOf(board);
    }

    /**
     * @return a GridDimension in this case the board
     */
    @Override
    public GridDimension getDimension() {
        return board;
    }

    /**
     * @return a Iterable<GridCell<Character>> in this case the board
     */
    @Override
    public Iterable<GridCell<Character>> getTilesOnBoard() {
        return board;
    }

    /**
     * @return a Iterable<GridCell<Character>> in this case tetromino
     */
    @Override
    public Iterable<GridCell<Character>> getFallingPiece() {
        return tetromino;
    }

    
    
}
