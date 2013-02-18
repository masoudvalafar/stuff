import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JFrame;

import Shapes.Bullet;
import Shapes.DestroyableObject;
import Shapes.Ship;
import eventHandling.KeyEventHandler;

public class AsteroidGameJFrame extends JFrame {

	static AsteroidGameJFrame screen;
	private static final long serialVersionUID = 1L;

	// event handler
	KeyEventHandler keyEventHandler;

	// use this as a double buffer,
	private BufferedImage backbuffer;
	// the main drawing object for the back buffer
	private Graphics2D g2d;
	// toggle for drawing bounding boxes
	boolean showBounds = false;

	AffineTransform identity = new AffineTransform();

	// game objects
	ArrayList<Bullet> bullets = new ArrayList<>();
	ArrayList<DestroyableObject> destroyableObjects = new ArrayList<>();
	Ship ship = new Ship();

	public AsteroidGameJFrame() {
		super("JFrameDemo");
		setSize(400, 500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		backbuffer = new BufferedImage(640, 480, BufferedImage.TYPE_INT_RGB);
		g2d = backbuffer.createGraphics();

		keyEventHandler = new KeyEventHandler();
		keyEventHandler.setShip(ship);
		keyEventHandler.setBullets(bullets);
		keyEventHandler.keyBinding(this);

		GameUpdate();

	}

	private void GameUpdate() {

		while (true) {
			try {
				updateObjects();
				update();
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

	public void update() {
		g2d.setTransform(identity);
		g2d.setPaint(Color.BLACK);
		g2d.fillRect(0, 0, getSize().width, getSize().height);

		g2d.setColor(Color.WHITE);
		g2d.drawString("Ship: " + ship.getX() + " " + ship.getY(), 50, 50);

		// draw the game graphics
		drawShip();
		drawBullets();
		drawEnemies();

		// repaint the JFrame window
		repaint();
	}

	private void drawEnemies() {
		for(DestroyableObject d: destroyableObjects){
			g2d.setTransform(identity);
			g2d.translate(d.getX(), d.getY());
			g2d.setColor(Color.GREEN);
			g2d.fill(d.getShape());
		}
	}

	private void drawBullets() {
		for (Bullet b : bullets) {
			g2d.setTransform(identity);
			g2d.translate(b.getX(), b.getY());
			g2d.setColor(Color.BLUE);
			g2d.draw(b.getShape());
		}
	}

	public void drawShip() {
		g2d.setTransform(identity);
		g2d.translate(ship.getX(), ship.getY());
		g2d.setColor(Color.ORANGE);
		g2d.fill(ship.getShape());
	}

	private void updateObjects() {
		// updating the ship
		ship.setX(ship.getX() + ship.getVelocityX());
		ship.setY(ship.getY() + ship.getVelocityY());

		// updating the bullets
		ArrayList<Bullet> bulletsToRemove = new ArrayList<>();
		for (Bullet b : bullets) {
			b.updatePosition();
			if (b.outOfBount(ship.getY())) {
				b.setAlive(false);
				bulletsToRemove.add(b);
			}
		}
		for (Bullet b : bulletsToRemove) {
			bullets.remove(b);
		}

		// update enemies!
		createEnemey();
		updateEnemies();
		
		// collision detection
		detectCollisiotns();

	}

	private void updateEnemies() {
		// TODO Auto-generated method stub
	}

	private void detectCollisiotns() {
		for (DestroyableObject d: destroyableObjects){
			for (Bullet b: bullets){
				if ?
			}
		}
	}

	private void createEnemey() {
		if (destroyableObjects.size() == 0) {
			DestroyableObject d = new DestroyableObject(100, 100);
			destroyableObjects.add(d);
		}

	}

	public void paint(Graphics g) {
		g.drawImage(backbuffer, 0, 0, this);
	}

	public static void main(String[] args) {
		screen = new AsteroidGameJFrame();
	}

}
