package drawingTool;

import java.awt.Color;
import java.awt.Point;

public class BellDecorator extends CowDecorator {
    private int size;

    public BellDecorator(LocatedRectangle baseCow) {
        super(baseCow);
        int bodyWidth = unwrapToCow(baseCow).getBodyWidth();
        this.size = (int)(bodyWidth * 0.1);
    }
    
    @Override
	public Point address() {
    	return getBaseCow().address();
	}

	@Override
	public int width() {
		return getBaseCow().width();
	}

	@Override
	public int height() {
		return getBaseCow().height();
	}

    @Override
    public void draw() {
        getBaseCow().draw(); // Draw the base cow first

        Cow cow = unwrapToCow(getBaseCow());
        if (cow == null) {
            return; // Can't draw the bell without cow info
        }

        Point topLeft = cow.address();
        int left = topLeft.x;
        int top = topLeft.y;
        int bodyWidth  = cow.getBodyWidth();
        int bodyHeight = cow.getBodyHeight();

        // bell position relative to body
        int bodyX = left + cow.getHeadSize(); 
        int bx = bodyX + (int)(0.05 * bodyWidth) - size;
        int by = top + bodyHeight - size;

        // Draw bell body
        Drawing.pen().setColor(Color.YELLOW);
        Drawing.pen().fillOval(bx, by, size, size);

        // Horizontal line inside bell
        int lineY = by + size / 2;
        int x1 = bx + size;
        int x2 = bx;
        Drawing.pen().setColor(Color.DARK_GRAY);
        Drawing.pen().drawLine(x1, lineY, x2, lineY);

        // Clapper
        int clapperSize = size / 5;
        int cx = bx + size / 2 - clapperSize / 2;
        int cy = lineY;
        Drawing.pen().fillOval(cx, cy, clapperSize, clapperSize);
    }
}
