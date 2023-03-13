package no.uib.inf101.tetris.model.tetromino;

import java.util.Random;

public class RandomTetrominoFactory implements TetrominoFactory{

    
    Random random = new Random();
    /**
     * @return returns a random new Tetromino object from one of the shapes.
     */
    @Override
    public Tetromino getNext() {
        char[] family = {'T', 'J', 'S', 'Z', 'I', 'O', 'L'};
        char randomShape = family[random.nextInt(family.length)];
        return Tetromino.newTetromino(randomShape);
    }
}
