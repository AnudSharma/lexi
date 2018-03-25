package it.lorciv.lexi.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import it.lorciv.lexi.model.Circle;
import it.lorciv.lexi.model.Glyph;
import it.lorciv.lexi.model.Rectangle;
import it.lorciv.lexi.model.Row;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainView extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Glyph document;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView frame = new MainView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		document = new Row();
		contentPane.add(new GlyphView(document), BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JButton btnCharacter = new JButton("Character");
		btnCharacter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				document.add(new it.lorciv.lexi.model.Character('a'));
				contentPane.repaint();
			}
		});
		panel.add(btnCharacter);
		
		JButton btnCircle = new JButton("Circle");
		btnCircle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				document.add(new Circle(35));
				contentPane.repaint();
			}
		});
		panel.add(btnCircle);
		
		JButton btnRectangle = new JButton("Rectangle");
		btnRectangle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				document.add(new Rectangle(60, 30));
				contentPane.repaint();
			}
		});
		panel.add(btnRectangle);
	}

}
