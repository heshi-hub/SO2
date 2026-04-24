package drawingTool;

import java.awt.Color;

public class Tail {
    private int width;
    private int height;
    private Color color = Color.WHITE; 
    private TailTip tip;  // composite

    public Tail(int bodyWidth, int bodyHeight) {
        this.width = (int)(0.05 * bodyWidth);
        this.height = (int)(0.4 * bodyHeight);
    	this.tip = new TailTip((int)(0.08 * bodyWidth));
    }

    public void drawAt(int left, int bottom) {
        int top = bottom - height;
        Drawing.pen().setColor(color);
        Drawing.pen().fillRect(left, top, width, height);

        tip.drawAt(left - 3, top + height + 5);  
    }
}