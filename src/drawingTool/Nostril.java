package drawingTool;

import java.awt.Color;

public class Nostril {
    private int width;
    private int height;

    public Nostril(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void drawAt(int left, int top) {
        Drawing.pen().setColor(Color.BLACK);
        Drawing.pen().fillOval(left, top, width, height);
    }

    // Getter for width
    public int getWidth() {
        return width;
    }

    // Getter for height
    public int getHeight() {
        return height;
    }
}