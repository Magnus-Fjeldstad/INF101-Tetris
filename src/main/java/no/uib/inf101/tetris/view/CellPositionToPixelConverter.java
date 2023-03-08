package no.uib.inf101.tetris.view;

import java.awt.geom.Rectangle2D;

import no.uib.inf101.grid.CellPosition;
import no.uib.inf101.grid.GridDimension;



public class CellPositionToPixelConverter {
  
  Rectangle2D box;
  GridDimension gd;
  double margin;

  // Konstruktøren
  public CellPositionToPixelConverter(Rectangle2D box, GridDimension gd, double margin) {
    this.box = box;
    this.gd = gd;
    this.margin = margin;
  }

  // Metode som finner posisjoneringen til en celle
  public Rectangle2D getBoundsForCell(CellPosition cellPos) {
    double boxWidth = box.getWidth();
    double boxHeight = box.getHeight();
    double boxY = box.getY();
    double boxX = box.getX();
    double cpCol = cellPos.col();
    double cpRow = cellPos.row() ;
    double gdCols = gd.cols();
    double gdRows = gd.rows () ;
    double cellMargin = margin;
    double cellWidth = (boxWidth - (cellMargin * (gdCols + 1))) / gdCols;
    double cellHeight = (boxHeight - (cellMargin * (gdRows + 1))) / gdRows;
    double cellX = (boxX + (cellMargin * (cpCol + 1)) + (cellWidth * cpCol));
    double cellY = (boxY + (cellMargin * (cpRow + 1)) + (cellHeight * cpRow));

    // Lager et rektangel ut ifra verdiene som ble regnet ut uvenfor
    return new Rectangle2D.Double(cellX, cellY, cellWidth, cellHeight);
  }
}
