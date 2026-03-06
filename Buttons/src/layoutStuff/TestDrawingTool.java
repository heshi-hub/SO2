package layoutStuff;

import java.awt.Dimension;
import javax.swing.JFrame;

public class TestDrawingTool {
	private JFrame applicationFrame;

    public TestDrawingTool(String title) {
        applicationFrame = new JFrame(title);
        Dimension screenSize = applicationFrame.getToolkit().getScreenSize();
        applicationFrame.setBounds(0, 0, screenSize.width, screenSize.height);

        applicationFrame.setVisible(true);
        applicationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
