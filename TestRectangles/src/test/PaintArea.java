package test;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.JComponent;

public class PaintArea extends JComponent implements KeyListener {

	/**
	 * Create the panel.
	 */
	public PaintArea() {
		this.setFocusable(true);	//SERVE A KeyTyped()
		addKeyListener(this);
	}
	
	private int size;
	Point coordinates1 = new Point(25, 25);
	Point coordinates2 = new Point(100, 25);
	char command;
	int player1Points = 0;
	int player2Points = 0;
	
	//Rectangle rect1 = new Rectangle(25, 25, size, size);
	//Rectangle rect4 = new Rectangle(100, 25, size, size);
	
	HashMap<Character, Point> input1 = new HashMap<Character, Point>() {{
		put('a', new Point(-30, 0));
		put('w', new Point(0, -30));
		put('d', new Point(30, 0));
		put('s', new Point(0, 30));
		}};
		
	HashMap<Character, Point> input2 = new HashMap<Character, Point>() {{
		put('j', new Point(-30, 0));
		put('i', new Point(0, -30));
		put('l', new Point(30, 0));
		put('k', new Point(0, 30));
		}};
	
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		size = getLevelSize();
		//drawPlayer(g, 25, 25);
		//drawPlayer(g, 75, 25);
		
		Graphics2D g2 = (Graphics2D) g;
	
		//g2.draw(rect1);
		//g2.clearRect(rect1.x, rect1.y, size, size);
		
		
		//g.fillRect(25, 25, size, size);
//		g.clearRect(25, 25, size, size);
//		g2.setColor(Color.BLUE);
//		g2.draw(rect4);
		
		//g.fillRect(100, 25, size, size);
		//g.clearRect(100, 25, size, size);
		movePlayer(g2);
		g2.setColor(Color.BLACK);
		g2.drawString(String.valueOf(player1Points), 25, 100);
		g2.drawString(String.valueOf(player2Points), 100, 100);
		increaseCollisions(new Rectangle(coordinates1.x, coordinates1.y, size, size),
				new Rectangle(coordinates2.x, coordinates2.y, size, size));

		
	}
	
	int getLevelSize() {
		return Math.min(getHeight(), getWidth()) / 10;
	}

	void drawPlayer(Graphics2D g2, int x, int y) {
		g2.draw(new Rectangle(x, y, size, size));
	}

	void movePlayer(Graphics2D g2) {
		if(input1.containsKey(command)) {
			Point newCoordinates = new Point(input1.get(command).x, input1.get(command).y);
			coordinates1.x = coordinates1.x + newCoordinates.x;
			coordinates1.y = coordinates1.y + newCoordinates.y;
			g2.setColor(Color.RED);
			drawPlayer(g2, coordinates1.x, coordinates1.y);
			g2.setColor(Color.BLUE);
			drawPlayer(g2, coordinates2.x, coordinates2.y);
		}
		else if(input2.containsKey(command)) {
			Point newCoordinates = new Point(input2.get(command).x, input2.get(command).y);
			coordinates2.x = coordinates2.x + newCoordinates.x;
			coordinates2.y = coordinates2.y + newCoordinates.y;
			g2.setColor(Color.BLUE);
			drawPlayer(g2, coordinates2.x, coordinates2.y);
			g2.setColor(Color.RED);
			drawPlayer(g2, coordinates1.x, coordinates1.y);
		}
		else {
			g2.setColor(Color.RED);
			drawPlayer(g2, coordinates1.x, coordinates1.y);
			g2.setColor(Color.BLUE);
			drawPlayer(g2, coordinates2.x, coordinates2.y);
		}
	}
	
	public void increaseCollisions(Rectangle p1, Rectangle p2) {
		if(p1.intersects(p2))
			player1Points++;
		
		else if(p2.intersects(p1))
			player2Points++;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		command = e.getKeyChar();
		System.out.print(e.getKeyChar());
		repaint();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}
	

	
}
