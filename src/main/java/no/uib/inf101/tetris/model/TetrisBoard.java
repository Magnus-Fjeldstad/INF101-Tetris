package no.uib.inf101.tetris.model;

import no.uib.inf101.grid.CellPosition;
import no.uib.inf101.grid.Grid;

public class TetrisBoard extends Grid<Character> {
    private int score;

    public TetrisBoard(int rows, int cols) {
        super(rows, cols, '-');
        this.score = 0;
        //this.score = 0;
        //this.removedRows = removedRows += removeFullRows();
    }  
    
    /**
     * 
     * @return a string of the board
     */
    public String prettyString() {
        String stringBoard = "";
        for (int i = 0; i < this.rows(); ++i) {  // rows er høyden
            for(int j = 0; j < this.cols(); j++){//cols er bredden                 
                    stringBoard += this.get(new CellPosition(i,j));                                          
            }
            if (i < this.rows() -1){
                stringBoard += ("\n");}   
        }
        return stringBoard;
    }  

    /**
     * 
     * @param row takes in an int row
     * @return true if the row only contains the initValue. False otherwise
     */
    private boolean checkRows(int row){
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
    private void setRowsValue(int row, char value){
        for (int i = 0; i < this.cols(); i++) {
            this.set(new CellPosition(row, i), value);
        }
    }

    /**
     * 
     * @param row the row you want to copy
     * @param copyRow the copyed row
     */
    private void copyRows(int oldRow, int copyRow){
        for (int i = 0; i < this.cols(); i++) {
            this.set(new CellPosition(oldRow, i), this.get(new CellPosition(copyRow, i)));
        }
    }

    /**
     * Removes rows based on an algorithm. Checks if the rows are full, if they are
     * ones removed and a copy of the upper row is moved one step further "down".
     * @return the amount of removed rows.
     */
    public  int removeFullRows() {
        int numClearedRows = 0;
        int a = this.rows() - 1; //Bottom Row
        int b = this.rows() - 1;
        while (a >= 0) {
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
        if (numClearedRows > 0) {
            if (numClearedRows == 1) {
                this.score += 100;
            } else if (numClearedRows == 2) {
                this.score += 300;
            } else if (numClearedRows == 3) {
                this.score += 500;
            } else if (numClearedRows == 4) {
                this.score += 800;
            }

        }

        return numClearedRows;
    }
    /**
     * 
     * @return the score
     */
    public int getScore(){
        return this.score;
    }
}
