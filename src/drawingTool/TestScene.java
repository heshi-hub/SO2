package drawingTool;

import java.awt.*;
import java.util.ArrayList;

public class TestScene extends Scene {

    public TestScene() {
        super(0); 

        ArrayList<LocatedRectangle> cowList = getCows(); 

        // Cow 1: Plain
        Cow plainCow = new Cow(new Point(100, 100), 2, Color.WHITE, new TriangleHorn(1.0));
        plainCow.setHornColor(Color.GRAY);
        plainCow.setSpotColor(Color.BLACK);
        cowList.add(plainCow);

        // Cow 2: With Bell
        Cow cowWithBell = new Cow(new Point(100, 500), 2, Color.WHITE, new RectangularHorn(1.0));
        cowWithBell.setHornColor(Color.GRAY);
        cowWithBell.setSpotColor(Color.BLACK);
        LocatedRectangle bellDecorated = new BellDecorator(cowWithBell);
        cowList.add(bellDecorated);

        // Cow 3: With Sunglasses
        Cow cowWithGlasses = new Cow(new Point(700, 100), 2, Color.WHITE, new TriangleHorn(1.0));
        cowWithGlasses.setHornColor(Color.GRAY);
        cowWithGlasses.setSpotColor(Color.BLACK);
        LocatedRectangle glassesDecorated = new SunglassesDecorator(cowWithGlasses);
        cowList.add(glassesDecorated);

        // Cow 4: With Bell & Sunglasses
        Cow fancyCow = new Cow(new Point(700, 500), 2, Color.WHITE, new RectangularHorn(1.0));
        LocatedRectangle fullyDecorated = fancyCow;
        fullyDecorated = new BellDecorator(fullyDecorated);
        fullyDecorated = new SunglassesDecorator(fullyDecorated);
        cowList.add(fullyDecorated);
    }
}
