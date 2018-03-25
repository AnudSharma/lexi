package it.lorciv.lexi.util;

public final class Point {
	
	private int x;
	private int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Point sum(Point that) {
		return new Point(x + that.getX(), y + that.getY());
	}

	public Point subtract(Point that) {
		return new Point(x - that.getX(), y - that.getY());
	}

	public Point multiply(Point that) {
		return new Point(x * that.getX(), y * that.getY());
	}

	public Point divide(Point that) {
		return new Point(x / that.getX(), y / that.getY());
	}

	public Point opposite() {
		return new Point(-x, -y);
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Point)) {
			return false;
		}
		Point that = (Point) obj;
		return x == that.getX() && y == that.getY();
	}

	@Override
	public int hashCode() {
		return x + y;
	}

	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}

}
