package it.lorciv.lexi.util;

public class Rect {

	private Point origin, extent;
	
	public Rect(Point origin, Point extent) {
		this.origin = origin;
		this.extent = extent;
	}
	
	public Rect(Point origin, int width, int height) {
		this(origin, new Point(origin.getX() + width, origin.getY() + height));
	}
	
	public Rect(int x, int y, int width, int height) {
		this(new Point(x, y), new Point(x + width, y + height));
	}

	public Point getOrigin() {
		return origin;
	}

	public Point getExtent() {
		return extent;
	}

	public int getWidth() {
		return extent.subtract(origin).getX();
	}

	public int getHeight() {
		return extent.subtract(origin).getY();
	}
	
	public Rect moveTo(Point target) {
		return moveBy(target.subtract(origin));
	}
	
	public Rect moveBy(Point target) {
		return new Rect(origin.sum(target), extent.sum(target));
	}

	public boolean isEmpty() {
		return origin.equals(extent);
	}

	public boolean contains(Point point) {
		return point.getX() >= origin.getX() && point.getX() <= extent.getX() 
				&& point.getY() >= origin.getY() && point.getY() <= extent.getY();
	}
	
	@Override
	public int hashCode() {
		return origin.hashCode() + extent.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Rect)) {
			return false;
		}
		Rect that = (Rect) obj;
		return origin.equals(that.getOrigin()) && extent.equals(that.getExtent());
	}
	
	@Override
	public String toString() {
		return "Rect [" + origin + " to " + extent + "]";
	}

}
