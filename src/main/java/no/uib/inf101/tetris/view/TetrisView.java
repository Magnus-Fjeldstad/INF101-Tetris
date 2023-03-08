package no.uib.inf101.tetris.view;
import javax.swing.JPanel;


import no.uib.inf101.grid.GridCell;


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Dimension;
import java.awt.geom.Rectangle2D;
import java.awt.Color;


public class TetrisView extends JPanel {
    //feltvariabler
    ViewableTetrisModel window;
    ColorTheme colorTheme;

    //kontruktør
    public TetrisView(ViewableTetrisModel window){
        this.colorTheme = new DefaultColorTheme();
        this.setBackground(colorTheme.getBackgroundColor());
        this.window = window;
        this.setFocusable(true);
        this.setPreferredSize(new Dimension(300, 400));
      }


      
      @Override
      public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        drawGame(g2);
      }

      public void drawGame(Graphics2D g2){
        Rectangle2D rectangle = new Rectangle2D.Double(0, 0, getWidth() , getHeight());
        g2.setColor(colorTheme.getFrameColor());
        g2.fill(rectangle);

        drawCells(g2, window.getTilesOnBoard(),new CellPositionToPixelConverter(getBounds(),window.getDimension(), 2), colorTheme);
      }

      public static void drawCells(Graphics2D g, Iterable<GridCell<Character>> cell, CellPositionToPixelConverter converter, ColorTheme CT){
        for (GridCell<Character> gridCell : cell) {     
            Color color = CT.getCellColor(gridCell.value());
            Rectangle2D rect = converter.getBoundsForCell(gridCell.pos());
            g.setColor(color);
            g.fill(rect);
        }
    }
}
