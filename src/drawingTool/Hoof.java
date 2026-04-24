package drawingTool;

import java.awt.Color;

public class Hoof {
    private int width;
    private int height;

    public Hoof(int bodyHeight) {
        this.width = (int)(0.13 * bodyHeight); 
        this.height = (int)(0.07 * bodyHeight);
    }

    public void drawAt(int left, int bottom) {
        int top = bottom - height;
        Drawing.pen().setColor(Color.BLACK);
        Drawing.pen().fillRect(left, top, width, height);
    }
}