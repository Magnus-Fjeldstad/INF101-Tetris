package no.uib.inf101.tetris.model.tetromino;

import java.util.Random;

public class RandomTetrominoFactory implements TetrominoFactory{

    private final Random random = new Random();

    /**
     * Returns a new random tetromino object based on the Random random feature
     */
    @Override
    public Tetromino getNext() {
        char[] shapes = {'T', 'J', 'S', 'Z', 'I', 'O'};
        char randomShape = shapes[random.nextInt(shapes.length)];
        return Tetromino.newTetromino(randomShape);
    }
}
