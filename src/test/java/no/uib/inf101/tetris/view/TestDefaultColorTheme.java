package no.uib.inf101.tetris.view;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import java.awt.Color;



public class TestDefaultColorTheme {
    @Test
    public void sanityTestDefaultColorTheme() {
    ColorTheme colors = new DefaultColorTheme();
    assertEquals(Color.LIGHT_GRAY, colors.getBackgroundColor());
    assertEquals(Color.black, colors.getFrameColor());
    assertEquals(Color.darkGray, colors.getCellColor('-'));
    assertThrows(IllegalArgumentException.class, () -> colors.getCellColor('\n'));

}
}


