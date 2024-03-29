package no.uib.inf101.tetris.model;



import no.uib.inf101.grid.CellPosition;
import no.uib.inf101.grid.GridCell;
import no.uib.inf101.grid.GridDimension;
import no.uib.inf101.tetris.controller.ControllableTetrisModel;
import no.uib.inf101.tetris.model.tetromino.Tetromino;
import no.uib.inf101.tetris.model.tetromino.TetrominoFactory;
import no.uib.inf101.tetris.view.ViewableTetrisModel;

public class TetrisModel implements ViewableTetrisModel, ControllableTetrisModel {

    private final  TetrisBoard board;
    private final  TetrominoFactory tetrominoFactory;
    private Tetromino fallingTetromino;
    private GameState gameState;


    public TetrisModel(TetrisBoard board, TetrominoFactory tetrominoFactory){
        this.board = board;
        this.tetrominoFactory = tetrominoFactory;
        this.fallingTetromino = tetrominoFactory.getNext();

        fallingTetromino = fallingTetromino.shiftedToTopCenterOf(board);



        this.gameState = GameState.ACTIVE_GAME;

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
        for (GridCell<Character> gridCell : fallingTetromino) {
            CellPosition pos = gridCell.pos();
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


    /**
     * @return checks if the rotatedCopy of a fallingTetromino object is allowed usiong the 'isLeagalPos' method.
     * If it is leagel it return true and the piece rotate counter clockwise otherwise nothing happens to the fallingTetromino
     */
    @Override
    public boolean rotateClockwise() {
        Tetromino fallingTetrominoCopy = fallingTetromino.getRotatedCopy();
        if(isLeagalPos(fallingTetrominoCopy)){
            this.fallingTetromino = fallingTetrominoCopy;
            return true;
        }
        return false;
    }

    

    /**
     * create a newTetromino object. Checks if its allowed to spawn
     * and if it is this.fallingTetromino = newTetromino
     */
    private void newFallingTetromino() {
        Tetromino newTetromino = tetrominoFactory.getNext();
        newTetromino = newTetromino.shiftedToTopCenterOf(board);
        for (GridCell<Character> gridCell : newTetromino){
            CellPosition pos = gridCell.pos();
            if(!board.positionIsOnGrid(pos) || board.get(pos)!= '-'){
                this.gameState = GameState.GAME_OVER;
                break;
            }
            else{
                this.fallingTetromino = newTetromino;}        
        }
    }

    /**
     * Iterates throug the fallingTetromino object and sets it in place if it is called upon
     */
    private void glueTetromino(){
        for (GridCell<Character> cellChar : fallingTetromino) {
            board.set(cellChar.pos(), cellChar.value());
        }
        board.removeFullRows();
        newFallingTetromino();
        
    }
    /**
     * takes in the fallingTetromino and shifts it by how many rows until the isLegalPos is False 
     * if the isLegalPos == false then the loop breaks
     */
    @Override
    public void dropTetromino(){
        while(true){
            Tetromino fallingTetrominoCopy = fallingTetromino.shiftedBy(1, 0);
            if (!isLeagalPos(fallingTetrominoCopy)) {
                break;
            }
            else{
                moveTetromino(1, 0);}              
        }
        glueTetromino();
    }

    /**
     * Gets the gamestate
     * @return the gamestate
     */
    @Override
    public GameState getGameState() {
        return this.gameState;
    }
    
    /**
     * return an int that represent every millisecond the "clock" should tick
     * the delay decreases when the level goes up.
     * @return the ticks in milliseconds
     */
    @Override
    public int getTimerDelay() {
        int speed = 1000;
        if(board.getLevel()== 1){
            speed = 1000;
        }
        if(board.getLevel()== 2){
            speed = 800;
        }
        if(board.getLevel()== 4){
            speed = 600;
        }
        if(board.getLevel()>= 5){
            speed = 400;
        }
        return speed;
        
    }

    
    @Override
    public void clockTick() {
        if (moveTetromino(1,0) == false) {
            glueTetromino();
        }
                 
    }

    @Override
    public Iterable<GridCell<Character>> viewShadowTetromino(){
        Tetromino shadowTetromino = fallingTetromino;
        while(true){
            Tetromino shadowTetrominoCopy  = shadowTetromino.shiftedBy(1, 0); //makes a copy and
            if(!isLeagalPos(shadowTetrominoCopy)){//checks the if the copy moved by 1 row is legal if not it breaks
                break;
            }
            else{
                shadowTetromino = shadowTetrominoCopy;} //Sets the shadowTetromino to the shadowTetrominoCopy value             
        }
        return shadowTetromino;
    }

    @Override
    public int getScore() {
        return board.getScore();
    }     
}
