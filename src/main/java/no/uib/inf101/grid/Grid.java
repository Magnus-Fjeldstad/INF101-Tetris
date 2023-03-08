package no.uib.inf101.grid;

import java.util.ArrayList;
import java.util.Iterator;


public class Grid<E> implements IGrid<E> {
    //fieldVariables
    private final int rows;
    private final int cols;
    private final ArrayList<ArrayList<E>> grid;


    // Contructor
    public Grid(int rows, int cols,E initValue){
        this.rows = rows;
        this.cols = cols;
        grid = new ArrayList<ArrayList<E>>();

        for (int i = 0; i < rows; i++) {
            ArrayList<E> row = new ArrayList<E>();

            for (int j = 0; j < cols; j++) {
                row.add(initValue);
        }

         grid.add(row);
        }
  }

  //Second Constructor, this is the "grid"
  public Grid(int rows, int cols){
    this(rows, cols, null);
}
        
    @Override
    public int rows() {
        return rows;
    }

    @Override
    public int cols() {
        return cols;
    }

    
    //TODO Endre på koden
    @Override
    public Iterator<GridCell<E>> iterator() {
        ArrayList<GridCell<E>> listElements = new ArrayList<>();
    
            for (int y = 0; y < rows; y++) {
                for (int x = 0; x < cols; x++) {
                    CellPosition pos = new CellPosition(y, x);
                    GridCell<E> gridItem = new GridCell<E>(pos, get(pos));
    
                    listElements.add(gridItem);
                }
            }
            return listElements.iterator();
        }
    

    @Override
    public void set(CellPosition pos, E value) {
       if(!positionIsOnGrid(pos)){
        throw new IndexOutOfBoundsException("The position is out of bounds");
       }

       else{
        
        grid.get(pos.row()).set(pos.col(), value); 

       }
    }

    @Override
    public E get(CellPosition pos) {
        if(!positionIsOnGrid(pos)){
            throw new IndexOutOfBoundsException("The Postion is out of bounds");
        }
        else{
            return grid.get(pos.row()).get(pos.col());
        }

    }

    @Override
    public boolean positionIsOnGrid(CellPosition pos) {
        return pos.row() >= 0 && pos.row() < this.rows() && pos.col() >= 0 && pos.col() < this.cols();
    }

   
}
