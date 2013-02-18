package eventHandling;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JRootPane;
import javax.swing.KeyStroke;

import Shapes.Bullet;
import Shapes.Ship;

public class KeyEventHandler{

	private Ship ship;
	private ArrayList<Bullet> bullets;

	public void setShip(Ship ship) {
		this.ship = ship;
	}
	
	public void setBullets(ArrayList<Bullet> bullets) {
		this.bullets = bullets;
	}

	private void createBullet() {
		Bullet bullet = new Bullet();
		int x = ship.getX();
		int y = ship.getY();
		bullet.setX(x);
		bullet.setY(y);
		bullets.add(bullet);
	}

	public void keyBinding(JFrame asteroidGameJFrame) {
		JRootPane rootPane = asteroidGameJFrame.getRootPane(); 
		
		KeyStroke escapeKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false);
	    Action escapeAction = new AbstractAction() {
			private static final long serialVersionUID = 1L;
			public void actionPerformed(ActionEvent e) {
	            System.out.println("asdasd");
	         }
	    };
	    rootPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(escapeKeyStroke, "ESCAPE");
	    rootPane.getActionMap().put("ESCAPE", escapeAction);
	    
	    KeyStroke leftArrowKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, false);
	    Action leftArrowKeyAction = new AbstractAction() {
			private static final long serialVersionUID = 1L;
			public void actionPerformed(ActionEvent e) {
				ship.setX(ship.getX() - 1);
	         }
	    };
	    rootPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(leftArrowKeyStroke, "LEFT_ARROW_KEY");
	    rootPane.getActionMap().put("LEFT_ARROW_KEY", leftArrowKeyAction);
	    
	    KeyStroke rightArrowKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, false);
	    Action rightArrowKeyAction = new AbstractAction() {
			private static final long serialVersionUID = 1L;
			public void actionPerformed(ActionEvent e) {
				ship.setX(ship.getX() + 1);
	         }
	    };
	    rootPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(rightArrowKeyStroke, "RIGHT_ARROW_KEY");
	    rootPane.getActionMap().put("RIGHT_ARROW_KEY", rightArrowKeyAction);
	    
	    KeyStroke spaceKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, false);
	    Action spaceKeyAction = new AbstractAction() {
			private static final long serialVersionUID = 1L;
			public void actionPerformed(ActionEvent e) {
				createBullet();
	         }
	    };
	    rootPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(spaceKeyStroke, "SPACE_KEY");
	    rootPane.getActionMap().put("SPACE_KEY", spaceKeyAction);
	}
}
