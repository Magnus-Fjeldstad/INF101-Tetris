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

            //default color of a cell
            case '-' -> Color.BLACK;
            //PieceColors
            case 'T' -> Color.CYAN;
            case 'J' -> Color.MAGENTA;
            case 'S' -> Color.PINK;
            case 'Z' -> Color.RED;
            case 'I' -> Color.green;
            case 'O' -> Color.BLUE;
            case 'L' -> Color.ORANGE;
            


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

    /**
     * @return gameover Color
     */
    @Override
    public Color getGameOverColor() {
        return new Color(0, 0, 0, 128); 
    }
    
}
