package it.lorciv.lexi.model;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import it.lorciv.lexi.util.Point;
import it.lorciv.lexi.util.Rect;

public class Row implements Glyph {

	private List<Glyph> children;
	private Rect bounds;
	
	public Row() {
		children = new ArrayList<Glyph>();
		bounds = new Rect(0, 0, 0, 0);
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(Color.RED);
		g.drawRect(bounds.getOrigin().getX(), bounds.getOrigin().getY(), bounds.getWidth(), bounds.getHeight());
		g.setColor(Color.BLACK);
		System.out.println("Start drawing row");
		Point currentPosition = bounds.getOrigin();
		for (Glyph child : children) {
			child.position(currentPosition);
			child.draw(g);
			currentPosition = currentPosition.sum(new Point(child.bounds().getWidth(), 0));
		}
		System.out.println("End drawing row");
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
			width += child.bounds().getWidth();
			if (child.bounds().getHeight() > height) {
				height = child.bounds().getHeight();
			}
		}
		
		bounds = new Rect(bounds.getOrigin(), width, height);
	}
	
	@Override
	public String toString() {
		return "Row of " + children.size() + " elements";
	}

}
