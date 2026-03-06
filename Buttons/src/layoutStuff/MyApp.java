package layoutStuff;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyApp extends JFrame {
private static final long serialVersionUID = 1L;
    
    public MyApp(String title) {
        setTitle(title);
        
        Dimension screenSize = getToolkit().getScreenSize();
        setSize(new Dimension(screenSize.width, screenSize.height));
        setLocation(screenSize.width / 2, screenSize.height / 2);
        
        setLayout(new FlowLayout(FlowLayout.CENTER, 100, 2));
        for (int i = 0; i < 100; i++) {
            JPanel myPanel = new JPanel();
            myPanel.setBackground(randomColor());
            add(myPanel);
        }
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    private Color randomColor() {
        int r = between(0, 2);
        if (r == 0) {
            return Color.YELLOW;
        } else if (r == 1) {
            return Color.BLUE;
        } else {
            return Color.GREEN;
        }
    }
    
    private int between(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }

    public static void main(String[] arg) {
        new MyApp("Title of my app");
    }
}
