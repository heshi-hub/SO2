package drawingTool;

import java.awt.Color;

public class Head {
    private int width;
    private int height;
    private Color color = Color.WHITE; // set from Cow constructor
    
    private Eye leftEye, rightEye; // composite
    private Nose nose; // composite
    private Ear leftEar, rightEar; // composite
    private Horn leftHorn, rightHorn; // composite
    
    // Fields to remember each horn's color
    private Color leftHornColor;
    private Color rightHornColor;

    // Add a constructor that accepts headSize
    public Head(int headSize, Color color, Horn horn) {
        this.width = headSize;  
        this.height = headSize; 
        this.color = color;
        
        leftEye = new Eye(width / 8, height / 8);
        rightEye = new Eye(width / 8, height / 8);
        
        int noseWidth = width / 3;
        int noseHeight = height / 5;
        nose = new Nose(noseWidth, noseHeight);
        
     // Pass ear size relative to head size
        int earWidth = (int)(width * 0.3);
        int earHeight = (int)(height * 0.2);
        leftEar = new Ear(earWidth, earHeight);
        rightEar = new Ear(earWidth, earHeight);
        
     // Clone horn with scale relative to head size   
        double hornScale = (double) headSize / 100;  // Normalize scale (100 is base)
        leftHorn = cloneHorn(horn, hornScale);
        rightHorn = cloneHorn(horn, hornScale);
        
     // Assign their colors here:
        leftHornColor  = randomHornColor();
        rightHornColor = randomHornColor();
    }
    
    private Horn cloneHorn(Horn horn, double scale) {
        if (horn instanceof RectangularHorn) {
            return new RectangularHorn(scale);
        } else if (horn instanceof TriangleHorn) {
            return new TriangleHorn(scale);
        } else {
            return new Horn(scale) {  
                @Override
                public void drawAt(int left, int bottom, Color color) {
                    // Simple rectangle as fallback
                    Drawing.pen().setColor(color);
                    Drawing.pen().fillRect(left, bottom - height, width, height);
                }
            };
        }
    }
    
    private Color randomHornColor() {
        int r = RandomNumber.between(0, 255);
        int g = RandomNumber.between(0, 255);
        int b = RandomNumber.between(0, 255);
        return new Color(r, g, b);
    }
    
    // Change horns color
    public void setHornColor(Color color) {
        this.leftHornColor = color;
        this.rightHornColor = color;
    }

    public void drawAt(int left, int bottom) {
        int top = bottom - height;
        
        // Head
        Drawing.pen().setColor(color);
        Drawing.pen().fillOval(left, top, width, height);

        // Eyes 
        leftEye.drawAt(left + (int)(0.2 * width), top + (int)(0.35 * height));
        rightEye.drawAt(left + (int)(0.6 * width), top + (int)(0.35 * height));

        // Nose
        nose.drawAt(left + (int)(0.3 * width), top + (int)(0.8 * height));
        
        // Ears
        leftEar.drawAt(left - (int)(0.15 * width), top + (int)(0.4 * height));
        rightEar.drawAt(left + width - (int)(0.15 * width), top + (int)(0.4 * height));
        
        // Horns
        leftHorn.drawAt(left + (int)(0.25 * width), top + (int)(0.08 * height), leftHornColor);
        rightHorn.drawAt(left + width - (int)(0.35 * width), top + (int)(0.08 * height), rightHornColor);
    }
    
    public int getWidth() {
    	return width;
    }

	public Ear getEar() {
		return leftEar;
	}
}