package no.uib.inf101.tetris.view;

import java.awt.Color;


public class DefaultColorTheme implements ColorTheme {


    /**
     * SelfImport Colors
     * How to:
     * Color color = new Color(r,g,b);
     */

    private final Color gameOverColor = new Color (0, 0, 0, 128);
    private final Color papayWhip = new Color(255, 239, 213);
    private final Color bloodRed = new Color(106, 4, 0);
    private final Color crazyOrange = new Color(248,178,67);
    private final Color cornflowerBlue = new Color(116, 148, 234);
    private final Color springGreen = new Color(53, 255, 105);
    private final Color steelPink = new Color(209, 56, 191);
    private final Color maueve = new Color(226, 160, 255);
    private final Color azuere = new Color (49, 133, 252);
    private final Color celadon = new Color(184, 216, 186);
    /**
     * @param c takes in a Char c and returns a color
     * @return  a color of a cell
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
            case '-' -> celadon;
            //PieceColors
            case 'T' -> Color.CYAN;
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
        return papayWhip;
    }

    /**
     * @return gameover Color
     */
    @Override
    public Color getGameOverColor() {
        return gameOverColor;
    }
    
}
