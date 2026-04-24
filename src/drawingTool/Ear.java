package drawingTool;

import java.awt.Color;

public class Ear {
    private int width;
    private int height;
    
    public Ear(int width, int height) {
    	this.width = width;
    	this.height = height;
    }

    public void drawAt(int left, int bottom) {
        int top = bottom - height;
        Drawing.pen().setColor(Color.ORANGE);  
        Drawing.pen().fillOval(left, top, width, height);  
    }

	public int getWidth() {
		return width;
	}
}