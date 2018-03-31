package it.lorciv.lexi.model;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import it.lorciv.lexi.util.Point;
import it.lorciv.lexi.util.Rect;

public class Column implements Glyph {
	
	private List<Glyph> children;
	private Rect bounds;
	
	public Column() {
		children = new ArrayList<Glyph>();
		bounds = new Rect(0, 0, 0, 0);
	}

	@Override
	public void draw(Graphics g) {
		System.out.println("Start drawing " + toString());
		Point currentPosition = bounds.getOrigin();
		for (Glyph child : children) {
			child.position(currentPosition);
			child.draw(g);
			currentPosition = currentPosition.sum(new Point(0, child.bounds().getHeight()));
		}
		System.out.println("End drawing " + toString());
	}

	@Override
	public Rect bounds() {
		return bounds;
	}

	@Override
	public boolean intersects(Point target) {
		for (Glyph child : children) {
			if (child.intersects(target)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void position(Point target) {
		bounds = bounds.moveTo(target);
	}

	@Override
	public void add(Glyph child) {
		children.add(child);
		updateBounds();
	}

	@Override
	public void remove(Glyph child) {
		children.remove(child);
		updateBounds();
	}
	
	private void updateBounds() {
		int width = 0;
		int height = 0;
		
		for (Glyph child : children) {
			height += child.bounds().getHeight();
			if (child.bounds().getWidth() > width) {
				width = child.bounds().getWidth();
			}
		}
		
		bounds = new Rect(bounds.getOrigin(), width, height);
	}
	
	@Override
	public String toString() {
		return "Column of " + children.size() + " elements";
	}

}
