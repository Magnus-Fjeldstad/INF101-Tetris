package no.uib.inf101.tetris.controller;

import no.uib.inf101.tetris.model.GameState;

public interface ControllableTetrisModel {
    /**
     * 
     * @param deltaRow how many rows that is moved
     * @param deltaCol how many rows that is moved
     * @return true if the Tetromino object is moved and false if it didnt move
     */
    public boolean moveTetromino(int deltaRow, int deltaCol);

    /**
     * 
     * @return a roateted fallingTetromino object
     */
    public boolean rotateClockwise();

    /**
     * @return a dropped tetromino object
     */
    public void dropTetromino();
    
    /**
     * 
     * @return the gamestate
     */

    public GameState getGameState();

    /**
     * 
     * @return everytime a tetromino should move in milliseconds
     */
    public int getTimerDelay();

    /**
     * a tick based on a preset timer in milliseconds
     * moves the tetromino one row up each tick
     */
    public void clockTick();
}
