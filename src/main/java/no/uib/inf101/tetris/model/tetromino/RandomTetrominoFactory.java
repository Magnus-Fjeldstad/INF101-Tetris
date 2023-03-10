package no.uib.inf101.tetris.model.tetromino;

import java.util.Random;

public class RandomTetrominoFactory implements TetrominoFactory{

    private final Random random = new Random();
    private final char[] family = {'T', 'J', 'S', 'Z', 'I', 'O', 'L'};
    private final char randomShape = family[random.nextInt(family.length)];

    /**
     * @return returns a random new Tetromino object from one of the shapes.
     */
    @Override
    public Tetromino getNext() {
        return Tetromino.newTetromino(randomShape);
    }
}
