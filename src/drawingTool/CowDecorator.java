package drawingTool;

public abstract class CowDecorator implements LocatedRectangle{
	private LocatedRectangle baseCow;
	
	public CowDecorator(LocatedRectangle baseCow) {
		this.baseCow = baseCow;
	}
	
	public static Cow unwrapToCow(LocatedRectangle obj) {
	    if (obj instanceof Cow cow) {
	        return cow;
	    } else if (obj instanceof CowDecorator decorator) {
	        return unwrapToCow(decorator.getBaseCow());
	    } else {
	        return null;
	    }    
	}

	public LocatedRectangle getBaseCow() {
		return baseCow;
	}
}
