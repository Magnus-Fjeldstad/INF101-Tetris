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
    private static final double OUTERMARGIN = 200;
    private static final double UPPEROUTERMARGIN = 30;
    



    //kontruktør
    public TetrisView(ViewableTetrisModel window){
        this.colorTheme = new DefaultColorTheme();
        this.setBackground(colorTheme.getBackgroundColor());
        this.window = window;
        this.setFocusable(true);
        this.setPreferredSize(new Dimension(700, 600));
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
        Rectangle2D rectangle = new Rectangle2D.Double(OUTERMARGIN , UPPEROUTERMARGIN, this.getWidth() - 2 * OUTERMARGIN , this.getHeight() - 2 * UPPEROUTERMARGIN );
        g2.setColor(colorTheme.getBackgroundColor());
        g2.fill(rectangle);

        g2.setColor(colorTheme.getFrameColor());
        g2.fill(rectangle);

        //Draws the cells
        drawCells(g2, window.getTilesOnBoard(),new CellPositionToPixelConverter(rectangle,window.getDimension(), 3), colorTheme);
        drawCells(g2, window.getFallingPiece(),new CellPositionToPixelConverter(rectangle,window.getDimension(), 3), colorTheme);
        drawShadowCells(g2, window.viewShadowTetromino(),new CellPositionToPixelConverter(rectangle,window.getDimension(), 3), colorTheme);
        
        //Variables to make the integer getScore to string
        int score = window.getScore();
        String scoreString = Integer.toString(score);
        Font scoreFont = new Font("Arial", Font.BOLD, 20);
        //Draw The Score on the side while game is active
        if(window.getGameState()==GameState.ACTIVE_GAME){
          g2.setFont(scoreFont);
          g2.setColor(Color.WHITE);
          g2.drawString("SCORE: " + scoreString, (this.getWidth()/18), this.getHeight()/2);
        }
       
        //if the gameState is "GameOver" a new opaque rectangle is drawn and a strin "GAME OVER" is drawn
        if(window.getGameState() == GameState.GAME_OVER){
          Rectangle2D gameOverRect = new Rectangle2D.Double(0 , 0, this.getWidth(), this.getHeight());
          g2.setColor(colorTheme.getGameOverColor());
          g2.fill(gameOverRect);

          //Draws the gameOver text
          Font gameoverFont = new Font("Arial", Font.BOLD, 40);
          g2.setColor(Color.WHITE);
          g2.setFont(gameoverFont);
          g2.drawString("GAME OVER!",(this.getWidth()/2)-(g2.getFontMetrics().stringWidth("GAME OVER!")/2), this.getHeight()/2);

          //Draws the score when gameover
          g2.setFont(scoreFont);
          g2.drawString("SCORE: " + scoreString,(this.getWidth()/2)-(g2.getFontMetrics().stringWidth("SCORE: " + scoreString)/2), (int) (this.getHeight()/1.7));
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
