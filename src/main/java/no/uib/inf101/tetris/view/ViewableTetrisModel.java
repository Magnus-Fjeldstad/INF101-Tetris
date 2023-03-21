package no.uib.inf101.tetris.view;

import no.uib.inf101.grid.GridCell;
import no.uib.inf101.grid.GridDimension;
import no.uib.inf101.tetris.model.GameState;

/*
 * @param getDimension 
 */
public interface ViewableTetrisModel{
    /**
     * 
     * @return the gridDimension
     */
    GridDimension getDimension();

    /**
     * 
     * @return the tiles of the board
     */

    Iterable<GridCell<Character>> getTilesOnBoard();

    /**
     * 
     * @return the tiles of the fallingTetromino
     */
    Iterable<GridCell<Character>> getFallingPiece();

    /**
     * 
     * @return the gameStare
     */

    GameState getGameState();


    /**
     * 
     * @return a shadow of a tetromino dropped to the lowest legal position.
     * The shadowTetromino is neved set to the board therefor it wont be interacted with 
     * any other part of the game.
     */
    Iterable<GridCell<Character>> viewShadowTetromino();

    /**
     * 
     * @return the current score
     */
    int getScore();
}