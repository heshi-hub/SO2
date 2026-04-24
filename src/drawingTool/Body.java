package drawingTool;

import java.awt.Color;

public class Body {
    private int width;
    private int height;
    
    private Spot[] spots; // composite
    private Tail tail;  // composite
    private Leg frontLeftLeg, frontRightLeg, backLeftLeg, backRightLeg; // composite
    
    public Body(int width, int height) {
    	 this.width = width;
         this.height = height;

       // Pass width and height to subcomponents 
         this.tail = new Tail(width, height);
         this.frontLeftLeg = new Leg(height);
         this.frontRightLeg = new Leg(height);
         this.backLeftLeg = new Leg(height);
         this.backRightLeg = new Leg(height);
   	
      // Spots use relative sizes (percentages of body)
         spots = new Spot[] {
             new Spot(0.2, 0.2), new Spot(0.25, 0.25),
             new Spot(0.15, 0.2), new Spot(0.2, 0.25),
             new Spot(0.2, 0.2), new Spot(0.25, 0.25),
             new Spot(0.2, 0.15), new Spot(0.15, 0.15)
            }; 
    }
    
    public void drawAt(int left, int bottom) {
        int top = bottom - height;

        // Draw body oval
        Drawing.pen().fillOval(left, top, width, height);

        // Spot positions as percentages of body dimensions
        double[][] spotPositions = {
            {0.1, 0.3}, {0.2, 0.3}, {0.35, 0.6}, {0.45, 0.55},
            {0.6, 0.4}, {0.7, 0.4}, {0.40, 0.10}, {0.5, 0.15}
        };

        for (int i = 0; i < spots.length; i++) {
            int spotX = left + (int)(spotPositions[i][0] * width);
            int spotY = bottom - (int)(spotPositions[i][1] * height);
            spots[i].drawAt(spotX, spotY, width, height);  // use body size for actual pixel size
        }
        

        // Tail
        tail.drawAt(left + (int)(0.95 * width), bottom + (int)(0.001 * height));

        // Legs
        frontLeftLeg.drawAt(left + (int)(0.15 * width), bottom + (int)(0.25 * height));
        frontRightLeg.drawAt(left + (int)(0.32 * width), bottom + (int)(0.25 * height));
        backLeftLeg.drawAt(left + (int)(0.57 * width), bottom + (int)(0.25 * height));
        backRightLeg.drawAt(left + (int)(0.72 * width), bottom + (int)(0.25 * height));
    }

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public Leg getLeg() {
		return backLeftLeg;
	}

	public void setSpotColor(Color c) {
        for (Spot s : spots) {
            s.setColor(c);
        }		
	}
}