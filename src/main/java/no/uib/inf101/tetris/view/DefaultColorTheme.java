package no.uib.inf101.tetris.view;

import java.awt.Color;


public class DefaultColorTheme implements ColorTheme {

    /**
     * @param c takes in a Char c and returns a color
     * @return returns a color of a cell
     */
    @Override
    public Color getCellColor(char c) {
        Color color = switch (c){
            case 'r' -> Color.RED;
            case 'g' -> Color.GREEN;
            case 'b' -> Color.BLUE;
            case 'y' -> Color.YELLOW;
            case 'p' -> Color.PINK;
            case 'T' -> Color.MAGENTA;
            case 'J' -> Color.MAGENTA;
            case 'S' -> Color.MAGENTA;
            case 'Z' -> Color.MAGENTA;
            case 'I' -> Color.MAGENTA;
            case 'O' -> Color.MAGENTA;
            case 'L' -> Color.MAGENTA;
            case '-' -> Color.BLACK;


            default -> throw new IllegalArgumentException("No available color for '" + c + "'");            
            };
        return color;
    }
    /**
     * @return returns the color of the Frame
     */
    @Override
    public Color getFrameColor() {
        return Color.WHITE;
    }

    /**
     * @return returns the color of the background
     */
    @Override
    public Color getBackgroundColor(){
        return Color.DARK_GRAY;
    }
    
}
