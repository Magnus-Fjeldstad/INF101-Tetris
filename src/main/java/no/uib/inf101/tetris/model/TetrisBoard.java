package no.uib.inf101.tetris.model;

import no.uib.inf101.grid.CellPosition;
import no.uib.inf101.grid.Grid;

public class TetrisBoard extends Grid<Character> {

    public TetrisBoard(int rows, int cols) {
        super(rows, cols, '-');

    }  


    public String prettyString() {
        String stringBoard = "";
        for (int i = 0; i < this.rows(); ++i) {  // rows er antall rader i brettet
            for(int j = 0; j < this.cols(); j++){                
                    stringBoard += this.get( new CellPosition(i,j));
                                           
            }
            if (i < this.rows() -1){
                stringBoard += ("\n");}   
        }
        return stringBoard;
    }     
}
