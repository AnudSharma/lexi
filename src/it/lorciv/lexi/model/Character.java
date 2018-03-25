package it.lorciv.lexi.model;

import java.awt.Color;
import java.awt.Graphics;

import it.lorciv.lexi.util.Point;
import it.lorciv.lexi.util.Rect;

public class Character implements Glyph {

	private Rect bounds;
	private char value;
	
	public Character(char value) {
		this.value = value;
		bounds = new Rect(0, 0, 10, 10);
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(Color.RED);
		g.drawRect(bounds.getOrigin().getX(), bounds.getOrigin().getY(), bounds.getWidth(), bounds.getHeight());
		g.setColor(Color.BLACK);
		
		int x = bounds.getOrigin().getX();
		int y = bounds.getOrigin().getY() + bounds.getHeight();
		
		g.drawString(value + "", x, y);
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
		throw new UnsupportedOperationException("Character is not a composite");
	}

	@Override
	public void remove(Glyph child) {
		throw new UnsupportedOperationException("Character is not a composite");
	}
	
	@Override
	public String toString() {
		return "Character " + value;
	}
	
}
