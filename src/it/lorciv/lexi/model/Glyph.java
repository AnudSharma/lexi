package it.lorciv.lexi.model;

import java.awt.Graphics;

import it.lorciv.lexi.util.Point;
import it.lorciv.lexi.util.Rect;

public interface Glyph {
	
	void draw(Graphics g);
	
	Rect bounds();
	
	boolean intersects(Point target);
	
	void position(Point target);
	
	void add(Glyph child);
	
	void remove(Glyph child);

}
