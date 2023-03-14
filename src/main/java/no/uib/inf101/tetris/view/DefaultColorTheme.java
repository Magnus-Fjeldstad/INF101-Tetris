package no.uib.inf101.tetris.view;

import java.awt.Color;


public class DefaultColorTheme implements ColorTheme {


    /**
     * SelfImport Colors
     * How to:
     * Color color = new Color(r,g,b);
     */

    private final Color gameOverColor = new Color (0, 0, 0, 128);
    private final Color crazyOrange = new Color(248,178,67);
    private final Color cornflowerBlue = new Color(116, 148, 234);
    private final Color springGreen = new Color(53, 255, 105);
    private final Color steelPink = new Color(209, 56, 191);
    private final Color maueve = new Color(226, 160, 255);
    private final Color azuere = new Color (49, 133, 252);
    private final Color cyan = new Color(0, 255, 255);

    /**
     * @param c takes in a Char c and returns a color
     * @return  a color of a cell
     */

    @Override
    public Color getCellColor(char c) {
        Color color = switch (c){
            //default color of a cell
            case '-' -> Color.darkGray;
            //PieceColors
            case 'T' -> cyan;
            case 'J' -> crazyOrange;
            case 'S' -> cornflowerBlue;
            case 'Z' -> springGreen;
            case 'I' -> steelPink;
            case 'O' -> maueve;
            case 'L' -> azuere;
            
            default -> throw new IllegalArgumentException("No available color for '" + c + "'");            
            };
        return color;
    }

    @Override
    public Color getShadowColor(char c) {
        Color color = switch (c){
            //PieceColors
            case 'T' -> new Color(0, 255, 255, 128);
            case 'J' -> new Color(248,178,67, 128);
            case 'S' -> new Color(116, 148, 234,128);
            case 'Z' -> new Color(53, 255, 105 , 128);
            case 'I' -> new Color(209, 56, 191 ,128);
            case 'O' -> new Color(226, 160, 255 ,128);
            case 'L' -> new Color (49, 133, 252, 128);
            
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
        return Color.BLACK;
    }

    /**
     * @return gameover Color
     */
    @Override
    public Color getGameOverColor() {
        return gameOverColor;
    }
    
    
}
