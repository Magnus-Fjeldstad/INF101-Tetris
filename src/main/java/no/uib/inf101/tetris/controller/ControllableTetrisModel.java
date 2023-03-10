package no.uib.inf101.tetris.controller;

public interface ControllableTetrisModel {
    /**
     * 
     * @param deltaRow how many rows that is moved
     * @param deltaCol how many rows that is moved
     * @return true if the Tetromino object is moved and false if it didnt move
     */
    boolean moveTetromino(int deltaRow, int deltaCol);
}
