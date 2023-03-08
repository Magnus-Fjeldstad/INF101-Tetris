package no.uib.inf101.tetris.view;

import java.awt.Color;


public class DefaultColorTheme implements ColorTheme {

    @Override
    public Color getCellColor(char c) {
        Color color = switch (c){
            case 'r' -> Color.RED;
            case 'g' -> Color.GREEN;
            case 'b' -> Color.BLACK;
            case 'y' -> Color.YELLOW;

            default -> throw new IllegalArgumentException("No available color for '" + c + "'");            
            };
        return color;
    }

    @Override
    public Color getFrameColor() {
        return Color.PINK;
    }

    @Override
    public Color getBackgroundColor(){
        return Color.BLACK;
    }
    
}
