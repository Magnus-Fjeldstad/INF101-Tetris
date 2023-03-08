package no.uib.inf101.tetris.model.tetromino;

import no.uib.inf101.grid.CellPosition;
import no.uib.inf101.grid.GridDimension;

public class Tetromino {
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



    static Tetromino newTetromino(char family){
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

    public Tetromino shiftedBy(int deltaRow, int deltaCol){
        return new Tetromino(family, piece, new CellPosition(this.leftUpperPos.row() + deltaRow, this.leftUpperPos.col() + deltaCol));
        
    }

    public Tetromino shiftedToTopCenterOf(GridDimension grid){
        return new Tetromino(family, piece, new CellPosition(0, this.leftUpperPos.col() + 4));     
    }
    
    
}
