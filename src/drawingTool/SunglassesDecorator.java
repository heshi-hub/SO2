package drawingTool;

import java.awt.Color;
import java.awt.Point;

public class SunglassesDecorator extends CowDecorator {
    private int width;
    private int height;

    public SunglassesDecorator(LocatedRectangle baseCow) {
        super(baseCow);

        Cow cow = CowDecorator.unwrapToCow(baseCow);
            int headSize = cow.getHeadSize();
            this.width  = (int)(headSize * 0.6);
            this.height = (int)(headSize * 0.15);
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
        getBaseCow().draw(); // draw base cow

        Cow cow = CowDecorator.unwrapToCow(this);
        if (cow == null) return;

        int headSize = cow.getHeadSize();
        Point pos = cow.address();

        int headX = pos.x;
        int headY = pos.y + cow.getHeightWithoutMarginValue() - headSize;

        int gx = headX + (int)(0.15 * headSize);
        int gy = headY + (int)(0.1 * headSize);

        Drawing.pen().setColor(Color.BLACK);
        Drawing.pen().fillOval(gx,          gy, width / 2, height);        
        Drawing.pen().fillOval(gx + width/2, gy, width / 2, height);       
        Drawing.pen().fillRect(gx + width/2 - height/4, gy + height/3,  height / 2, height / 6);
    }

}
