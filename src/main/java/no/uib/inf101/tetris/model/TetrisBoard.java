package no.uib.inf101.tetris.model;

import no.uib.inf101.grid.CellPosition;
import no.uib.inf101.grid.Grid;

public class TetrisBoard extends Grid<Character> {
    int removedRows;

    public TetrisBoard(int rows, int cols) {
        super(rows, cols, '-');
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
     * 
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
        removedRows += numClearedRows;
        return numClearedRows;
    }

    public int getScore(){
        int score = 0;
        int oldRemoved = 0;
        if ((this.removedRows- oldRemoved)==1){
            score += 100;
            oldRemoved += 1;
        }
        if ((this.removedRows- oldRemoved)==2){
            score += 300;
            oldRemoved += 2;
        }
        if ((this.removedRows- oldRemoved)==3){
            score += 500;
            oldRemoved += 3;
        }
        if ((this.removedRows-oldRemoved) == 4){
            score += 800;
            oldRemoved += 4;
        }
        System.out.println(this.removedRows);
        System.out.println(oldRemoved);
        return score; 
    }
}
