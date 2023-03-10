package no.uib.inf101.tetris.model;

import no.uib.inf101.grid.CellPosition;
import no.uib.inf101.grid.GridCell;
import no.uib.inf101.grid.GridDimension;
import no.uib.inf101.tetris.controller.ControllableTetrisModel;
import no.uib.inf101.tetris.model.tetromino.Tetromino;
import no.uib.inf101.tetris.model.tetromino.TetrominoFactory;
import no.uib.inf101.tetris.view.ViewableTetrisModel;

public class TetrisModel implements ViewableTetrisModel, ControllableTetrisModel {

    TetrisBoard board;
    TetrominoFactory tetrominoFactory;
    Tetromino fallingTetromino;

    public TetrisModel(TetrisBoard board, TetrominoFactory tetrominoFactory){
        this.board = board;
        this.tetrominoFactory = tetrominoFactory;
        this.fallingTetromino = tetrominoFactory.getNext();
        fallingTetromino = fallingTetromino.shiftedToTopCenterOf(board);
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
        return fallingTetromino;
    }


    /**
     * 
     * @param fallingTetromino takes in the fallingTetromino object 
     * @return a Boolean true/false. True if the entire tetromino object can fit
     * in the board and if the position is not occupied by a piece.
     */
    public boolean isLeagalPos(Tetromino fallingTetromino){
        for (GridCell<Character> cellChar : fallingTetromino) {
            CellPosition pos = cellChar.pos();
            if(!(board.positionIsOnGrid(pos) && board.get(pos).equals('-'))){
                return false;
            }
        }
        return true;
    }

    /**
     * Makes a copy of the falling tetromino object and moves the fallingTetromino object useing the copy
     * if and only if the position is Leaga using isLeagalPos
     */
    @Override
    public boolean moveTetromino(int deltaRow, int deltaCol) {
        Tetromino fallingTetrominoCopy = fallingTetromino.shiftedBy(deltaRow, deltaCol);
        if(isLeagalPos(fallingTetrominoCopy)){
            this.fallingTetromino = fallingTetrominoCopy;
            return true;
        }
        return false;
    }

    

    
    
}
