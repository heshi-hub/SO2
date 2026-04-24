package drawingTool;

import java.awt.Color;

public class TailTip {
	private int width;
	private int height;
	
	public TailTip(int baseWidth) {
		this.width = baseWidth;
		this.height = baseWidth; 
	}
	
    public void drawAt(int left, int bottom) {
        int top = bottom - height;
        Drawing.pen().setColor(Color.BLACK);  
        Drawing.pen().fillOval(left, top, width, height);
    }
}
