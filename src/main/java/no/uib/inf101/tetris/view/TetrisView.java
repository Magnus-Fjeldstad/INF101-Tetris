package no.uib.inf101.tetris.view;
import javax.swing.JPanel;


import no.uib.inf101.grid.GridCell;
import no.uib.inf101.tetris.model.GameState;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Dimension;
import java.awt.geom.Rectangle2D;
import java.awt.Color;
import java.awt.Font;


public class TetrisView extends JPanel {
    //feltvariabler
    ViewableTetrisModel window;
    ColorTheme colorTheme;
    private static final double OUTERMARGIN = 30;


    //kontruktør
    public TetrisView(ViewableTetrisModel window){
        this.colorTheme = new DefaultColorTheme();
        this.setBackground(colorTheme.getBackgroundColor());
        this.window = window;
        this.setFocusable(true);
        this.setPreferredSize(new Dimension(400, 600));
      }

    

    /**
     * @param g draws the game
     */
      @Override
      public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        drawGame(g2);

      }

    /**
     * 
     * @param g2 takes in a g2 parameter that is used to draw 2D rectangles.
     */
      public void drawGame(Graphics2D g2){
        Rectangle2D rectangle = new Rectangle2D.Double(OUTERMARGIN , OUTERMARGIN, this.getWidth() - 2 * OUTERMARGIN , this.getHeight() - 2 * OUTERMARGIN );
        g2.setColor(colorTheme.getBackgroundColor());
        g2.fill(rectangle);

        g2.setColor(colorTheme.getFrameColor());
        g2.fill(rectangle);
       
        drawCells(g2, window.getTilesOnBoard(),new CellPositionToPixelConverter(rectangle,window.getDimension(), 3), colorTheme);
        drawCells(g2, window.getFallingPiece(),new CellPositionToPixelConverter(rectangle,window.getDimension(), 3), colorTheme);
        drawShadowCells(g2, window.viewShadowTetromino(),new CellPositionToPixelConverter(rectangle,window.getDimension(), 3), colorTheme);

        //if the gameState is "GameOver" a new opaque rectangle is drawn and a strin "GAME OVER" is drawn
        if(window.getGameState() == GameState.GAME_OVER){
          g2.setColor(colorTheme.getGameOverColor());
          g2.fill(rectangle);

          Font gameoverFont = new Font("Comic Sans", Font.BOLD, 30);
          
          g2.setColor(Color.WHITE);
          g2.setFont(gameoverFont);
        
          g2.drawString("GAME OVER!",this.getWidth()/4, this.getHeight()/2  );
        } 
      }

    /**
     * 
     * @param g "Pencil" 
     * @param cell Each cell in the iterable list GridCell<Charaters> used to draw different colors based on a char
     * @param converter Converts a CellPosition to a Pixel
     * @param CT Color Theme set in DefualtColorTheme
     */
      public static void drawCells(Graphics2D g, Iterable<GridCell<Character>> cell, CellPositionToPixelConverter converter, ColorTheme CT){
        for (GridCell<Character> gridCell : cell) {     
            Color color = CT.getCellColor(gridCell.value());
            Rectangle2D rect = converter.getBoundsForCell(gridCell.pos());
            g.setColor(color);
            g.fill(rect);
        }
      }

      /**
       * @return same as drawCells but for a shadowCell
       */
      public static void drawShadowCells(Graphics2D g, Iterable<GridCell<Character>> cell, CellPositionToPixelConverter converter, ColorTheme CT){
        for (GridCell<Character> gridCell : cell) {     
            Color color = CT.getShadowColor(gridCell.value());
            Rectangle2D rect = converter.getBoundsForCell(gridCell.pos());
            g.setColor(color);
            g.fill(rect);
        }
  }  
}
