package it.lorciv.lexi.model;

import java.awt.Graphics;

import it.lorciv.lexi.util.Point;
import it.lorciv.lexi.util.Rect;

public class Circle implements Glyph {
	
	private Rect bounds;
	
	public Circle(int radius) {
		bounds = new Rect(0, 0, radius * 2, radius * 2);
	}

	@Override
	public void draw(Graphics g) {
		int x = bounds.getOrigin().getX();
		int y = bounds.getOrigin().getY();
		int w = bounds.getWidth();
		int h = bounds.getHeight();
		
		g.drawOval(x, y, w, h);
	}

	@Override
	public Rect bounds() {
		return bounds;
	}

	@Override
	public boolean intersects(Point target) {
		return bounds.contains(target);
	}

	@Override
	public void position(Point target) {
		bounds = bounds.moveTo(target);
	}

	@Override
	public void add(Glyph child) {
		throw new UnsupportedOperationException("Circle is not a composite");
	}

	@Override
	public void remove(Glyph child) {
		throw new UnsupportedOperationException("Circle is not a composite");
	}
	
	@Override
	public String toString() {
		return "Circle";
	}

}
