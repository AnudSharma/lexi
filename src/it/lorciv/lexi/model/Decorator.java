package it.lorciv.lexi.model;

import java.awt.Graphics;

import it.lorciv.lexi.util.Point;
import it.lorciv.lexi.util.Rect;

public abstract class Decorator implements Glyph {
	
	private Glyph component;
	
	public Decorator(Glyph component) {
		this.component = component;
	}
	
	@Override
	public void draw(Graphics g) {
		component.draw(g);
	}

	@Override
	public Rect bounds() {
		return component.bounds();
	}

	@Override
	public boolean intersects(Point target) {
		return component.intersects(target);
	}

	@Override
	public void position(Point target) {
		component.position(target);
	}

	@Override
	public void add(Glyph child) {
		component.add(child);
	}

	@Override
	public void remove(Glyph child) {
		component.remove(child);
	}
	
}
