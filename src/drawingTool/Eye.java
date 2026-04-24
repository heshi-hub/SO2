package drawingTool;

import java.awt.Color;

public class Eye {
    private int width;
    private int height;

    public Eye(int width, int height) {
        this.width = width;
        this.height = height;
    }
    
    public void drawAt(int left, int bottom) {
        int top = bottom - height;
        Drawing.pen().setColor(Color.BLACK);  
        Drawing.pen().fillOval(left, top, width, height);  
    }
}