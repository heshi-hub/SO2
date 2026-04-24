package drawingTool;

import java.awt.Color;
import java.awt.Point;

public class Cow implements LocatedRectangle {
    private Head head; // composite
    private Body body; // composite
    private Color color; 
    private Point position;
    
    // Constants
    private static final int BASE_BODY_WIDTH = 150;
    private static final int BASE_BODY_HEIGHT = 80;
    private static final double HEAD_HEIGHT_RATIO = 0.5;
    private static final double BODY_OFFSET_RATIO = 0.6;

    // Store dimensions directly to avoid changing Head/Body
    private int headSize;
    private int bodyWidth;
    private int bodyHeight;
        
    public Cow(Point position, double scale, Color color, Horn horn) {
        this.position = position;
        this.color = color;

        bodyWidth = (int) (BASE_BODY_WIDTH * scale);
        bodyHeight = (int) (BASE_BODY_HEIGHT * scale);
        headSize = (int) (bodyHeight * HEAD_HEIGHT_RATIO);

        this.head = new Head(headSize, color, horn);
        this.body = new Body(bodyWidth, bodyHeight);        
    }

    // Vertical offset for head based on head size
    private int verticalOffset() {
        return (int) (0.15 * headSize);
    }

    // Box
    @Override
    public void draw() {
        drawAt(position.x, position.y);
        Drawing.pen().setColor(Color.black);
        Drawing.pen().drawRect(address().x - head.getEar().getWidth() , address().y, width(),height()
        );
    }

    public void drawAt(int left, int top) {

        int adjustedLeft = left;
        int adjustedTop = top;

        int bodyX = adjustedLeft + (int)(BODY_OFFSET_RATIO * headSize);
        int bodyY = adjustedTop + heightWithoutMargin();

        int headX = adjustedLeft;
        int headY = bodyY - verticalOffset();

        Drawing.pen().setColor(color);
        body.drawAt(bodyX, bodyY);
        head.drawAt(headX, headY);
    }
    
    public void setSpotColor(Color c) {
        body.setSpotColor(c);
    }
    
    public void setHornColor(Color color) {
        head.setHornColor(color);
    }
    
    @Override
    public Point address() {
        return position;
    }

    @Override
    public int width() {
        return head.getWidth() + body.getWidth(); 
    }

    @Override
    public int height() {
        return body.getHeight() + body.getLeg().getHeight(); 
    }

    // Internal height without margin
    private int heightWithoutMargin() {
        return Math.max(bodyHeight, headSize + verticalOffset());
    }

    public int getHeadSize() {
        return headSize;
    }
    
    public double getBodyOffsetRatio() {
        return BODY_OFFSET_RATIO;
    }
    
    public int getHeightWithoutMarginValue() {
        return heightWithoutMargin();
    }

	public int getBodyWidth() {
		return bodyWidth;
	}
	
	public int getBodyHeight() {
	    return bodyHeight;
	}
}