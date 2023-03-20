package no.uib.inf101.tetris.view;

import java.awt.Color;


public class DefaultColorTheme implements ColorTheme {


    /**
     * SelfImport Colors
     * How to:
     * Color color = new Color(r,g,b);
     */


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
            case 'T' -> new Color(0, 255, 255);
            case 'J' -> new Color(248,178,67);
            case 'S' -> new Color(116, 148, 234);
            case 'Z' -> new Color(53, 255, 105);
            case 'I' -> new Color(209, 56, 191);
            case 'O' -> new Color(226, 160, 255);
            case 'L' -> new Color (49, 133, 252);
            
            default -> throw new IllegalArgumentException("No available color for '" + c + "'");            
            };
        return color;
    }

    @Override
    public Color getShadowColor(char c) {
        Color shadowColor = switch (c){
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
        return shadowColor;
    }


    
    @Override
    public Color getFrameColor() {
        return Color.WHITE;
    }

   
    @Override
    public Color getBackgroundColor(){       
        return Color.LIGHT_GRAY;
    }

   
    @Override
    public Color getGameOverColor() {
        return new Color (0, 0, 0, 128);
    }
    
    
}
