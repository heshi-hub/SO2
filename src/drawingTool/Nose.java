package drawingTool;

import java.awt.Color;

public class Nose {
    private int width;
    private int height;
    private Nostril leftNostril, rightNostril; // composite

    public Nose(int width, int height) {
        this.width = width;
        this.height = height;

        // Set nostril sizes relative to nose size
        int nostrilWidth = width / 8;
        int nostrilHeight = height / 2;

        leftNostril = new Nostril(nostrilWidth, nostrilHeight);
        rightNostril = new Nostril(nostrilWidth, nostrilHeight);
    }

    public void drawAt(int left, int bottom) {
        int top = bottom - height;

        // Draw the nose base
        Drawing.pen().setColor(Color.PINK);
        Drawing.pen().fillOval(left, top, width, height);

        // Draw nostrils using getter for width
        leftNostril.drawAt(left + width / 4, top + height / 4);
        rightNostril.drawAt(left + (width * 3) / 4 - rightNostril.getWidth(), top + height / 4);
    }
}