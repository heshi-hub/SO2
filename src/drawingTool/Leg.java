package drawingTool;

import java.awt.Color;

public class Leg {
    private int width;
    private int height;
    private Color color = Color.WHITE;
    private Hoof hoof; // composite

    public Leg(int bodyHeight) {
    	this.width = (int)(0.13 * bodyHeight);
    	this.height = (int)(0.40 * bodyHeight);
    	this.hoof = new Hoof(bodyHeight);
    }

    public void drawAt(int left, int bottom) {
        int top = bottom - height;
        Drawing.pen().setColor(color);
        Drawing.pen().fillRect(left, top, width, height);
        
        hoof.drawAt(left, top + height);  
    }

	public int getHeight() {
		return height;
	}
}