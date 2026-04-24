package drawingTool;

import java.awt.Color;

public class Spot {
    private double widthPercent;
    private double heightPercent;
    private Color color;

    public Spot(double widthPercent, double heightPercent) {
    	this.widthPercent = widthPercent;
        this.heightPercent = heightPercent;
        this.color = Color.BLACK;     // default
    }

    public void setColor(Color c) { 
        this.color = c;
    }
    
    public void drawAt(int left, int bottom, int bodyWidth, int bodyHeight) {
        int width = (int)(this.widthPercent * bodyWidth);
        int height = (int)(this.heightPercent * bodyHeight);
        int top = bottom - height;
        
        Drawing.pen().setColor(color);  
        Drawing.pen().fillOval(left, top, width, height);  
    }
}