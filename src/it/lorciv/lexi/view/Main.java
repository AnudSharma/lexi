package it.lorciv.lexi.view;

import javax.swing.JFrame;

import it.lorciv.lexi.model.Character;
import it.lorciv.lexi.model.Circle;
import it.lorciv.lexi.model.Glyph;
import it.lorciv.lexi.model.Rectangle;
import it.lorciv.lexi.model.Row;

public class Main {
	
	public static void main(String[] args) {
		
		Glyph r = new Row();
		r.add(new Character('c'));
		r.add(new Rectangle(30, 50));
		r.add(new Character('S'));
		r.add(new Character('a'));
		r.add(new Rectangle(20, 20));
		
		for(char c : "Ciao, mi chiamo Lorenzo".toCharArray()) {
			r.add(new Character(c));
		}
		
		r.add(new Rectangle(55, 52));
		r.add(new Circle(48));
		
		GlyphView panel = new GlyphView(r);
		
		JFrame frame = new JFrame();
		frame.getContentPane().add(panel);
		frame.setSize(100, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}
	
}
