package drawingTool;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

public class Scene {

    private final ArrayList<LocatedRectangle> cows = new ArrayList<>();

    public Scene(int howMany) {
        for (int i = 0; i < howMany; i++) {
        	addCow();
        }
    }

    // Method to add a new cow at a random position without intersecting existing cows
    public void addCow() {
        final int MAX_ATTEMPTS = 100;
        int attempts = 0;
        boolean haveAddedCow = false;
        while (attempts < MAX_ATTEMPTS && !haveAddedCow) {
            if (addCowAtRandomPosition()) {
                System.out.println("Added a new cow successfully.");
                haveAddedCow = true;
            }
            attempts++;
        }
        System.out.println("Failed to add a new cow after " + MAX_ATTEMPTS + " attempts.");
    }

    private boolean addCowAtRandomPosition() {
        int x = RandomNumber.between(0, 1500);
        int y = RandomNumber.between(0, 850);
        int scale = RandomNumber.between(1, 4);

        Horn horn = createRandomHorn();
        Cow newCow = new Cow(new Point(x, y), scale, Color.WHITE, horn);
        
        // Decorate the cow
        LocatedRectangle decoratedCow = newCow;
        
        decoratedCow = new BellDecorator(decoratedCow);

        if (!cowIntersected(newCow)) {
            cows.add(newCow);
            System.out.println("Added cow at " + x + "," + y);
            return true;
        } 
        return false;
    }

    // Remove the last cow in the list, if any
    public void removeCow() {
        if (!cows.isEmpty()) {
            cows.remove(cows.size() - 1);
            System.out.println("Removed one cow");
        } else {
            System.out.println("No cows to remove");
        }
    }

    // Clear all cows
    public void clearCows() {
        cows.clear();
        System.out.println("Cleared all cows");
    }
    
    // Change spot color on all cows
    public void setSpotColor(Color c) {
	    for (LocatedRectangle obj : cows) {
	        if (obj instanceof Cow cow) {
	            cow.setSpotColor(c);
	        } else if (obj instanceof CowDecorator decorator) {
	            Cow baseCow = unwrapToCow(decorator);
	            if (baseCow != null) baseCow.setSpotColor(c);
	        }
	    }
	 }

    // Change horn color on all cows
    public void setHornColor(Color c) {
        for (LocatedRectangle obj : cows) {
            if (obj instanceof Cow cow) {
                cow.setHornColor(c);
            } else if (obj instanceof CowDecorator decorator) {
                Cow baseCow = unwrapToCow(decorator);
                if (baseCow != null) baseCow.setHornColor(c);
            }
        }
    }
    
    public void addAccessoriesToAll() {
        for (int i = 0; i < cows.size(); i++) {
            LocatedRectangle cow = cows.get(i);

            // Always unwrap to the base cow before redecorating
            Cow baseCow = CowDecorator.unwrapToCow(cow);

            // Start fresh from base cow
            LocatedRectangle decoratedCow = baseCow;

            // Wrap with all desired decorators
            decoratedCow = new BellDecorator(decoratedCow);
            decoratedCow = new SunglassesDecorator(decoratedCow);     

            // Replace the old cow with the decorated one
            cows.set(i, decoratedCow);
        }
    }
   
    public void removeAccessoriesFromAll() {
        for (int i = 0; i < cows.size(); i++) {
            Cow baseCow = CowDecorator.unwrapToCow(cows.get(i));
            if (baseCow != null) {
                cows.set(i, baseCow);
            }
        }
    }

    private Cow unwrapToCow(LocatedRectangle obj) {
        if (obj instanceof Cow cow) {
            return cow;
        } else if (obj instanceof CowDecorator decorator) {
            return unwrapToCow(decorator.getBaseCow());
        }
        return null;
    }
    
    //getter to get the internal cow list
    public ArrayList<LocatedRectangle> getCows() {
        return cows;
    }
    
    private boolean cowIntersected(LocatedRectangle newCow) {
        boolean intersects = false;
        int i = 0;
        System.out.println("Checking for intersections");
        while (!intersects && i < cows.size()) {
            LocatedRectangle currentCow = cows.get(i);
            intersects = currentCow.intersects(newCow, 0); 

            if (intersects) System.out.println("newCow Intersected at " + i);
            i++;
        }
        return intersects;
    }

    public void draw() {
        System.out.println("\n\n Drawing cows " + cows.size());
        for (LocatedRectangle cow : cows) {
            cow.draw();
        }
    }

    private Horn createRandomHorn() {
        int type = RandomNumber.between(0, 1);
        if (type == 0) {
            return new RectangularHorn(1.0);
        } else {
            return new TriangleHorn(1.0);
        }
    }
}