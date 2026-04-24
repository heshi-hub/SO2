package drawingTool;

import java.awt.Color;

public abstract class Horn {
    private int width;
    private int height;

    public Horn(double bodyScale) {

        this.width = (int)(bodyScale * 10);  
        this.height = (int)(bodyScale * 50);
    }

    // Abstract method for drawing, subclasses implement
    public abstract void drawAt(int left, int bottom, Color color);

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}