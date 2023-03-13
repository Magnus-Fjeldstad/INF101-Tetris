package no.uib.inf101.tetris.controller;

import no.uib.inf101.tetris.midi.TetrisSong;
import no.uib.inf101.tetris.model.GameState;
import no.uib.inf101.tetris.view.TetrisView;

import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.Timer;

public class TetrisController implements  java.awt.event.KeyListener {

    ControllableTetrisModel controller;
    TetrisView tetrisView;
    Timer timer;
    TetrisSong song;

    public TetrisController(ControllableTetrisModel controller, TetrisView tetrisView){
        this.controller = controller;
        this.tetrisView = tetrisView;
        tetrisView.addKeyListener(this);
        tetrisView.setFocusable(true);
        this.timer = new Timer(controller.milliSeconds(), this:: clockTick);
        timer.start();
        song.run();
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
            timer.restart();
        }
        else if (e.getKeyCode() == KeyEvent.VK_UP) {
            controller.rotateClockwise();
        }
        else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            controller.dropTetromino();
        }
        tetrisView.repaint();
        
    }
    public void delay(){
        timer.setDelay(controller.milliSeconds());
        timer.setInitialDelay(2000);
    }

    public void clockTick(ActionEvent e){
        if(!(controller.getGameState() == GameState.GAME_OVER)){
            controller.clockTick();
            tetrisView.repaint();
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyReleased'");
    }
   
}
