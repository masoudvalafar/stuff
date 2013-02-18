package Shapes;

import java.awt.Shape;
import java.awt.geom.Rectangle2D;

public class Ship implements GameObject{

	boolean alive;
	Shape shape;
	double faceAngel = 90;
	int velocityX = 0;
	int velocityY = 0;
	int x = 0;
	int y = 0;

	public Ship() {
		setAlive(true);
		setX(200);
		setY(410);
		setShape(new Rectangle2D.Double(0, 0, 10, 10));
	}

	public double getFaceAngle() {
		return faceAngel;
	}

	public void setFaceAngle(double angle) {
		this.faceAngel = angle;
	}

	public Shape getShape() {
		return shape;
	}

	public void setShape(Shape shape) {
		this.shape = shape;
	}
	
	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public int getVelocityX() {
		return velocityX;
	}

	public void setVelocityX(int velocityX) {
		this.velocityX = velocityX;
	}

	public int getVelocityY() {
		return velocityY;
	}

	public void setVelocityY(int velocityY) {
		this.velocityY = velocityY;
	}

}
