package drawingTool;

import java.awt.Color;
import java.awt.Polygon;

public class TriangleHorn extends Horn {

    public TriangleHorn(double scale) {
        super(scale);
    }

    @Override
    public void drawAt(int left, int bottom, Color color) {
        Drawing.pen().setColor(color);
        int[] xPoints = { left, left + getWidth() / 2, left + getWidth() };
        int[] yPoints = { bottom, bottom - getHeight(), bottom };
        Polygon triangle = new Polygon(xPoints, yPoints, 3);
        Drawing.pen().fillPolygon(triangle);
    }
}