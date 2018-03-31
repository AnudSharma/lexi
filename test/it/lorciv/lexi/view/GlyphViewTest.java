package it.lorciv.lexi.view;

import javax.swing.JFrame;

import it.lorciv.lexi.model.BorderDecorator;
import it.lorciv.lexi.model.Character;
import it.lorciv.lexi.model.Circle;
import it.lorciv.lexi.model.Column;
import it.lorciv.lexi.model.Glyph;
import it.lorciv.lexi.model.Rectangle;
import it.lorciv.lexi.model.Row;

public class GlyphViewTest {
	
	public static void main(String[] args) {
		
		Glyph col = new Column();
		{
			Glyph row1 = new Row();
			{
				for(char c : "Ciao, mi chiamo Lorenzo_^".toCharArray()) {
					row1.add(new BorderDecorator(new Character(c)));
				}
				row1.add(new BorderDecorator(new Rectangle(55, 52)));
				row1.add(new BorderDecorator(new Circle(48)));
			}
			col.add(new BorderDecorator(row1));
			
			Glyph row2 = new Row();
			{
				row2.add(new BorderDecorator(new Circle(30)));
				row2.add(new BorderDecorator(new Character('4')));
				row2.add(new BorderDecorator(new Circle(56)));
			}
			col.add(new BorderDecorator(row2));
			
			Glyph row3 = new Row();
			{
				for(char c : "Hello, world!".toCharArray()) {
					row3.add(new BorderDecorator(new Character(c)));
				}
			}
			col.add(new BorderDecorator(row3));
			
			Glyph row4 = new Row();
			{
				row4.add(new BorderDecorator(new Circle(80)));
				row4.add(new BorderDecorator(new Character('c')));
			}
			col.add(new BorderDecorator(row4));
		}
		GlyphView panel = new GlyphView(new BorderDecorator(col));
		
		JFrame frame = new JFrame();
		frame.getContentPane().add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
}
