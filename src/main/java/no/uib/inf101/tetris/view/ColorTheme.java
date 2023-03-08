package no.uib.inf101.tetris.view;
import java.awt.Color;

public interface ColorTheme {
    //gets the color of the cell
    Color getCellColor(char c);

    //gets the color of the frame
    Color getFrameColor();

    //get the background color
    Color getBackgroundColor();

}
