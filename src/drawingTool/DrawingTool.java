/**
 * Provides a test application window with a panel "DrawingArea" and some "Buttons".
 * 
 * @author Björn Gottfried
 * @version 2.0
 */

package drawingTool;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class DrawingTool extends JFrame implements ActionListener {
	private DrawingArea drawing;
	private Buttons buttons = new Buttons();

	public DrawingTool(String title) {
		super(title);
		
		setLayout(new BorderLayout());

		constructButtonMenu();
		constructDrawingArea();

		Dimension screenSize = getToolkit().getScreenSize();
		setBounds(0, 0, screenSize.width, screenSize.height);

		setVisible(true);
	}
	
	private void constructButtonMenu() {
		buttons.addButtonsToAPanel(this);
		buttons.addActionListener(this);
	}

    private void constructDrawingArea() {
        int initialCows = 0;
        String input = JOptionPane.showInputDialog("How many cows? (1–5)");
        if (input != null && input.length() == 1 && "12345".contains(input)) {
            initialCows = Integer.parseInt(input);
        } else {
            System.out.println("Invalid input. Try again or you got 1 cow.");
            initialCows = 1;
        }

        drawing = new DrawingArea(initialCows);
        add(drawing, BorderLayout.CENTER);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == buttons.getAddCowButton()) {
			tidyUpDrawingArea();
			drawing.getScene().addCow();
		} else if (e.getSource() == buttons.getRemoveCowButton()) {
			tidyUpDrawingArea();
			drawing.getScene().removeCow();
		} else if (e.getSource() == buttons.getClearCowsButton()) {
			tidyUpDrawingArea();
			drawing.getScene().clearCows();
		} else if (e.getSource() == buttons.getChangeBgColorButton()) {
	        int r = RandomNumber.between(0, 255);
	        int g = RandomNumber.between(0, 255);
	        int b = RandomNumber.between(0, 255);
	        drawing.setBackground(new Color(r, g, b));
	        drawing.repaint();
		} else if (e.getSource() == buttons.getChangeSpotColorButton()) {
	        int r = RandomNumber.between(0, 255);
	        int g = RandomNumber.between(0, 255);
	        int b = RandomNumber.between(0, 255);
	        Color newSpotColor = new Color(r, g, b);
	        drawing.getScene().setSpotColor(newSpotColor);
	        drawing.repaint();
		} else if (e.getSource() == buttons.getChangeHornColorButton()) {
            int r = RandomNumber.between(0, 255);
            int g = RandomNumber.between(0, 255);
            int b = RandomNumber.between(0, 255);
            Color newHornColor = new Color(r, g, b);
            drawing.getScene().setHornColor(newHornColor);
            drawing.repaint();
		} else if (e.getSource() == buttons.getAddAccessoriesButton()) {
		    tidyUpDrawingArea();
		    drawing.getScene().addAccessoriesToAll();
		    drawing.repaint();
		} else if (e.getSource() == buttons.getRemoveAccessoriesButton()) {
		    tidyUpDrawingArea();
		    drawing.getScene().removeAccessoriesFromAll();
		    drawing.repaint();
		}	
	}

	private void tidyUpDrawingArea() {
		drawing.removeAll();
		drawing.revalidate();
		drawing.repaint();		
	}
	
	public static void main(String[] args) {
		new DrawingTool("Draw a cow");
	}
}