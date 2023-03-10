package no.uib.inf101.tetris.model.tetromino;

public class PatternedTetrominoFactory implements TetrominoFactory{

    /**
     * @string string fieldvaribale
     */
    private String string;
    /**
     * @index an int to keep track of whitch index of the string iterating throug
     */
    private int index;


    /**
     * 
     * @param string takes in a string from our fieldvaribles
     */
    public PatternedTetrominoFactory(String string) {
        this.string = string;
        this.index = 0;
    }

    /**
     * @return returns a new Tetromino object based on a string with chars, iterates trhoug the string by adding 1 to our 
     * index field varible.
     */
    @Override
    public Tetromino getNext() {
        char c = string.charAt(index);
        index = (index + 1) % string.length();
        return Tetromino.newTetromino(c);
    }
    
}
