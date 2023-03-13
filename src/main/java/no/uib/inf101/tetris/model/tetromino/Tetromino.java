package no.uib.inf101.tetris.model.tetromino;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;


import no.uib.inf101.grid.CellPosition;
import no.uib.inf101.grid.GridCell;
import no.uib.inf101.grid.GridDimension;

public class Tetromino implements Iterable<GridCell<Character>>{
    //Fieldvariables
    char family;
    boolean[][] piece;
    CellPosition leftUpperPos;

    //Contructor
    private Tetromino(char family, boolean[][] piece,CellPosition leftUpperPos ){
        this.family = family;
        this.piece = piece;
        this.leftUpperPos = leftUpperPos;
    }


    /**
     * 
     * @param family a char to determine the "family" of the Tetromino object
     * @return a new Tetromino object based on the "family" parameter
     */

    protected static Tetromino newTetromino(char family){
        CellPosition leftPos = new CellPosition(0, 0);
        switch (family) {
            case 'T':
                return new Tetromino(family, new boolean[][] {
                    { false, false, false },
                    {  true,  true,  true },
                    { false,  true, false }
                }
                , leftPos);

            case 'S':
                return new Tetromino(family, new boolean[][] {
                    { false, false, false },
                    {  false,  true,  true },
                    { true,  true, false }
                }
                , leftPos);

            case 'Z':
                return new Tetromino(family, new boolean[][] {
                    { false, false, false },
                    {  true,  true,  false },
                    { false,  true, true }
                }
                , leftPos);
            case 'L':
                return new Tetromino(family, new boolean[][] {
                    { false, false, false },
                    {  true,  true,  true },
                    { true,  false, false }
                }
                , leftPos);

            case 'J':
                return new Tetromino(family, new boolean[][] {
                    { false, false, false },
                    {  true,  true,  true },
                    { false,  false, true }
                }
                , leftPos);
            case 'I':
                return new Tetromino(family, new boolean[][] {
                    { false, false, false, false },
                    {  true,  true,  true, true },
                    { false,  false, false, false },
                    { false,  false, false, false }
                }
                , leftPos);
            case 'O':
                return new Tetromino(family, new boolean[][] {
                    { false, false, false, false },
                    { false, true,  true, false },
                    { false,  true, true, false },
                    { false,  false, false, false }
                }
                , leftPos);

            default:
                throw new IllegalArgumentException("Piece does not exist");
        }
    }
    
    /**
     * 
     * @param deltaRow Moved by deltaRow
     * @param deltaCol Moved by deltaCol
     * @return The Tetromino object moved by the deltaRow/deltaCol parameters
     */

    public Tetromino shiftedBy(int deltaRow, int deltaCol){
        int newDeltaRow = this.leftUpperPos.row() + deltaRow;
        int newDeltaCol = this.leftUpperPos.col() + deltaCol;
        return new Tetromino(this.family, this.piece, new CellPosition(newDeltaRow, newDeltaCol));
        
    }

    

     /**
      * 
      * @param grid a grid/playing board as a parameter
      * @return a new Tetromino object moved to the middle of the board
      */
    public Tetromino shiftedToTopCenterOf(GridDimension grid){
        //int halfBoard = grid.cols()/2;
        int center = (grid.cols()-piece.length)/2;
        int deltaRow = -1;
        return new Tetromino(this.family, this.piece, new CellPosition(deltaRow, center));
          
    }

    @Override
    public Iterator<GridCell<Character>> iterator() {
        List<GridCell<Character>> itr = new ArrayList<>();
        Character c = this.family;

        int numRows = piece.length;
        int numCols = piece[0].length;
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                if (piece[row][col]) {
                    //Gets the row value of a piece where its "true" and ads it to the upperLeftPos (0,0) to get where the piece is
                    //Gets the col value of a piece where its "true" and ads it to the upperLeftPos (0,0) to get where the piece is    
                    int rowValue = leftUpperPos.row() + row;
                    int colValue = leftUpperPos.col() + col;                 
                    itr.add(new GridCell<Character>((new CellPosition(rowValue, colValue)), c));
                }
            }
        }
        return itr.iterator();
    }

    
//hashCode method to get the hash of each piece see existing javadoc
  @Override
    public int hashCode() {
        return Objects.hash(family, Arrays.deepHashCode(piece), leftUpperPos);
    }


//equals method to compare the different objects to see if they are the same see existing javadoc
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
          }

        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Tetromino)) {
            return false;
          }

        Tetromino other = (Tetromino) obj;
        return family == other.family &&  Arrays.deepEquals(piece, other.piece) && Objects.equals(leftUpperPos, other.leftUpperPos);
    }


    /**
     * Rotates a Postioned Piece to one with a shape rotated within it's box.
     * @param x decides the way of roatetion, 0 for clockwise, 1 for counter-clockwise.
     * @return a roted copy of a tetromino object
     */
    
    public Tetromino getRotatedCopy(){

        boolean [][] oldPiece = this.piece;

        boolean [][] newPiece = new boolean[piece.length][piece[0].length];

        for (int numRow = 0; numRow < piece.length; numRow ++) {
           for (int numCol = 0; numCol < piece[0].length; numCol ++) {           
                newPiece[numRow][numCol] = oldPiece[((piece.length) - 1) - numCol][numRow];                             
            } 
        }
        return new Tetromino(family, newPiece, leftUpperPos);
    }
}

