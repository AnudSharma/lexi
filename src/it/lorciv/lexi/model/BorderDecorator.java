package it.lorciv.lexi.model;

import java.awt.Color;
import java.awt.Graphics;

public class BorderDecorator extends Decorator {

	public BorderDecorator(Glyph component) {
		super(component);
	}
	
	@Override
	public void draw(Graphics g) {
		super.draw(g);
		drawBorder(g);
	}

	private void drawBorder(Graphics g) {
		int x = bounds().getOrigin().getX();
		int y = bounds().getOrigin().getY();
		int w = bounds().getWidth();
		int h = bounds().getHeight();
		g.setColor(Color.RED);
		g.drawRect(x, y, w, h);
	}

}
