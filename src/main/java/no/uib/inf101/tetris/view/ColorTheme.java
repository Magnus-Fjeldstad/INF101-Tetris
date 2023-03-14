package no.uib.inf101.tetris.view;
import java.awt.Color;

public interface ColorTheme {

    /**
   * Gets the color of the cell.
   *
   * @param c Converts the char "c" to a color
   * @return the color of the cell
   */
    Color getCellColor(char c);

    /**
   * Gets the color of the cell.
   *
   * @param c Converts the char "c" to a color
   * @return the color of the cell
   */
    Color getShadowColor(char c);

    /**
   * Sets the color of the frame of the board.
   *
   * @return the color of the frame
   */
    Color getFrameColor();


    /**
   * Sets the color of the frame of the background.
   *
   * @return the color of the background
   */
    Color getBackgroundColor();

    /**
     * 
     * @return the color that is drawn when game over
     */
    Color getGameOverColor();

}
