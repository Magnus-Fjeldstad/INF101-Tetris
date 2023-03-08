package no.uib.inf101.tetris.view;
import javax.swing.JPanel;


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Dimension;
import java.awt.geom.Rectangle2D;
import java.awt.Color;
import java.awt.Font;

public class TetrisView extends JPanel {

    ViewableTetrisModel window;
    ColorTheme color;

    public TetrisView(ViewableTetrisModel window){
        this.window = window;
        this.setFocusable(true);
        this.setPreferredSize(new Dimension(300, 400));
      }

      @Override
      public void paintComponent(Graphics g) {
        super.paintComponent(g);
      }

}

