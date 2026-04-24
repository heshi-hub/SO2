package drawingTool;

import java.awt.Color;

public class RectangularHorn extends Horn {

    public RectangularHorn(double scale) {
        super(scale);
    }

    @Override
    public void drawAt(int left, int bottom, Color color) {
        Drawing.pen().setColor(color);
        Drawing.pen().fillRect(left, bottom - getHeight(), getWidth(), getHeight());
    }
}