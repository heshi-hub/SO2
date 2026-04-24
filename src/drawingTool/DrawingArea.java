package drawingTool;

import java.awt.Graphics;
import javax.swing.JPanel;

public class DrawingArea extends JPanel {
    private static final long serialVersionUID = 1L;
    private Scene scene;

    public DrawingArea(int initialCowCount) {
        this.scene = new Scene(initialCowCount);
        
    	//this.scene = new TestScene();
    }
    
    @Override
	protected void paintComponent(Graphics pen) {
        super.paintComponent(pen); // clear previous drawings

        Drawing.set(pen); // initialize the drawing pen
      
        // Draw all cows in the scene
        scene.draw();
    }	
    public Scene getScene() {
        return scene;
    }
}