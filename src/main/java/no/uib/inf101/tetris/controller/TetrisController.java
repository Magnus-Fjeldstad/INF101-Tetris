package no.uib.inf101.tetris.controller;

import no.uib.inf101.tetris.view.TetrisView;

import java.awt.event.KeyEvent;

public class TetrisController implements  java.awt.event.KeyListener {

    ControllableTetrisModel controller;
    TetrisView tetrisView;

    public TetrisController(ControllableTetrisModel controller, TetrisView tetrisView){
        this.controller = controller;
        this.tetrisView = tetrisView;
        tetrisView.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
    }


    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            controller.moveTetromino(0, -1);
        }
        else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            controller.moveTetromino(0, 1);
        }
        else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            controller.moveTetromino(1, 0);
        }
        else if (e.getKeyCode() == KeyEvent.VK_UP) {
            controller.rotateCounterClockwise();
        }
        else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            controller.moveTetromino(1, 0);
        }
        tetrisView.repaint();
        
    }


    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyReleased'");
    }
   
}
