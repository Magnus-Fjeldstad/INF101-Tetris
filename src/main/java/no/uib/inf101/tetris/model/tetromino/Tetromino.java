package no.uib.inf101.tetris.model.tetromino;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.math.*;

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
        return new Tetromino(family, piece, new CellPosition(this.leftUpperPos.row() + deltaRow, this.leftUpperPos.col() + deltaCol));
        
    }

    /**
     * 
     * @param grid the playing board represented in a grid 
     * @return a new Tetromino object moved to the center and top of the board
     */
    public Tetromino shiftedToTopCenterOf(GridDimension grid){
        int halfBoard = Math.round(grid.cols()/2);

        return new Tetromino(family, piece, new CellPosition(0, this.leftUpperPos.col() + halfBoard));     
    }

    @Override
    public Iterator<GridCell<Character>> iterator() {
        List<GridCell<Character>> itr = new ArrayList<>();
        Character c = this.family;

        int numRows = piece.length;
        int numCols = piece[0].length;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (piece[i][j]) {
                    //Gets the row value of a piece where its "true" and ads it to the upperLeftPos (0,0) to get where the piece is
                    //Gets the col value of a piece where its "true" and ads it to the upperLeftPos (0,0) to get where the piece is    
                    int rowValue = leftUpperPos.row() + i;
                    int colValue = leftUpperPos.col() + j;                 
                    itr.add(new GridCell<Character>((new CellPosition(rowValue, colValue)), c));
                }
            }
        }
        return itr.iterator();
    }

    
//hashCode method to get the hash of each piece
  @Override
    public int hashCode() {
        return Objects.hash(family, Arrays.deepHashCode(piece), leftUpperPos);
    }


//equals method to compare the different objects to see if they are the same.
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
        return family == other.family && 
            Arrays.deepEquals(piece, other.piece) &&
            Objects.equals(leftUpperPos, other.leftUpperPos);
    }
}

