package no.uib.inf101.tetris.model;

import no.uib.inf101.grid.CellPosition;
import no.uib.inf101.grid.Grid;

public class TetrisBoard extends Grid<Character> {

    public TetrisBoard(int rows, int cols) {
        super(rows, cols, '-');

    }  
    
    //Turns cellposistions to string
    public String prettyString() {
        String stringBoard = "";
        for (int i = 0; i < this.rows(); ++i) {  // rows er høyden
            for(int j = 0; j < this.cols(); j++){//cols er bredden                 
                    stringBoard += this.get( new CellPosition(i,j));                                          
            }
            if (i < this.rows() -1){
                stringBoard += ("\n");}   
        }
        return stringBoard;
    }  
    
    /**
     * 
     * @param row takes in an int row
     * @return true if the row only contains the initValue false othervise
     */
    public boolean checkRows(int row){
        for (int i = 0; i < this.cols(); i++) {
            if(this.get(new CellPosition(row, i)).equals(('-'))){
                return true;
            }                       
        }
        return false;
    }

    /**
     * 
     * @param row the row you want to alter
     * @param value value you want to set, van be '-', T, S, I...
     */
    public void setRowsValue(int row, char value){
        for (int i = 0; i < this.cols(); i++) {
            this.set(new CellPosition(row, i), value);
        }
    }

    /**
     * 
     * @param row the row you want to copy
     * @param copyRow the copyed row
     */
    public void copyRows(int row, int copyRow){
        for (int i = 0; i < this.cols(); i++) {
            this.set(new CellPosition(row, i), this.get(new CellPosition(copyRow, i)));
        }
    }

    /**
     * 
     * @return remove rows
     */
    public int removeFullRows() {
        int numClearedRows = 0;
        int a = this.rows() - 1; //Bottom Row
        int b = this.rows() - 1;
        while (a >= 0) {//As long as there is still rows
            while (b >= 0 && !checkRows(b)) {
                numClearedRows++;
                b--;
            }
            if (b >= 0) {
                copyRows(a, b);
            } 
            else {
                setRowsValue(a, '-');
            }
            a--;
            b--;
        }
        return numClearedRows;
    }
}
