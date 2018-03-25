package it.lorciv.lexi.view;

import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

import it.lorciv.lexi.model.Glyph;

public class GlyphView extends JPanel {
	
	private Glyph document;
	
	private static final long serialVersionUID = 1L;
	
	public GlyphView(Glyph document) {
		this.document = document;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		g.setFont(new Font("Monospaced", Font.PLAIN, 12));
		
		document.draw(g);
	}

}
