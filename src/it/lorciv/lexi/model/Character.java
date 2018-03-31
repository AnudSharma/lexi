package it.lorciv.lexi.model;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import it.lorciv.lexi.util.Point;
import it.lorciv.lexi.util.Rect;

public class Character implements Glyph {

	private Rect bounds;
	private char value;
	
	public Character(char value) {
		this.value = value;
		bounds = new Rect(0, 0, 15, 15);
	}
	
	public char getValue() {
		return value;
	}
	
	@Override
	public void draw(Graphics g) {
		System.out.println("Drawing " + toString());
		int x = bounds.getOrigin().getX() + 5;
		int y = bounds.getOrigin().getY() + 12;
		g.setFont(new Font("Monospaced", Font.PLAIN, 12));
		g.setColor(Color.BLACK);
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
		return "Character " + getValue();
	}
	
}
