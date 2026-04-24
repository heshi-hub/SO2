package drawingTool;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Buttons {
	private JButton addCowButton = new JButton("Add Cow");
	private JButton removeCowButton = new JButton("Remove Cow");
	private JButton clearCowsButton = new JButton("Clear All Cows");
	private JButton changeBgColorButton = new JButton("Change Background Color");
	private JButton changeSpotColorButton = new JButton("Change Spot Color");
	private JButton changeHornColorButton = new JButton("Change Horn Color");
	private JButton addAccessoriesButton = new JButton("Add Accessories");
	private JButton removeAccessoriesButton = new JButton("Remove Accessories");

	public void addActionListener(ActionListener listener) {
		addCowButton.addActionListener(listener);
        removeCowButton.addActionListener(listener);
        clearCowsButton.addActionListener(listener);
        changeBgColorButton.addActionListener(listener); 
        changeSpotColorButton.addActionListener(listener); 
        changeHornColorButton.addActionListener(listener); 
        addAccessoriesButton.addActionListener(listener);
        removeAccessoriesButton.addActionListener(listener);
	}

	public void addButtonsToAPanel(JFrame frame) {
		JPanel menu = new JPanel();
		menu.setLayout(new GridLayout(18, 1, 15, 20));

		menu.add(addCowButton);
		menu.add(removeCowButton);
		menu.add(clearCowsButton);
		menu.add(changeBgColorButton);
		menu.add(changeSpotColorButton);
		menu.add(changeHornColorButton);
		menu.add(addAccessoriesButton);
		menu.add(removeAccessoriesButton);

		menu.setBorder(BorderFactory.createRaisedBevelBorder());
		frame.add(menu, BorderLayout.WEST);
	}

	public JButton getAddCowButton() {
		return addCowButton;
	}

	public JButton getRemoveCowButton() {
		return removeCowButton;
	}

	public JButton getClearCowsButton() {
		return clearCowsButton;
	}
	public JButton getChangeBgColorButton() {
		return changeBgColorButton;
	}
	public JButton getChangeSpotColorButton() {
		return changeSpotColorButton;
	}
	
	public JButton getChangeHornColorButton() {
		return changeHornColorButton;
	}
	
	public JButton getAddAccessoriesButton() {
		return addAccessoriesButton;
	}

	public JButton getRemoveAccessoriesButton() {
		return removeAccessoriesButton;
	}
}