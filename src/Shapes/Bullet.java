package Shapes;

import java.awt.Shape;
import java.awt.geom.Rectangle2D;

public class Bullet implements GameObject {

	boolean alive;
	Shape shape;
	double faceAngel = 90;
	int x = 0;
	int y = 0;
	int velocityX = 0;
	int velocityY = 0;
	int width = 5;
	
	public Bullet(){
		setAlive(true);
		setVelocityX(0);
		setVelocityY(-5);
		setShape(new Rectangle2D.Double(0, 0, this.width, 5));
	}
	
	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	@Override
	public Shape getShape() {
		return this.shape;
	}
	
	@Override
	public void setShape(Shape shape) {
		this.shape = shape;
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public void setX(int x) {
		this.x = x;
	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public void setY(int y) {
		this.y = y;
	}

	@Override
	public double getFaceAngle() {
		return faceAngel;
	}

	@Override
	public void setFaceAngle(double angle) {
		this.faceAngel = angle;
	}

	@Override
	public boolean isAlive() {
		return alive;
	}

	@Override
	public int getVelocityX() {
		return velocityX;
	}

	@Override
	public void setVelocityX(int speedX) {
		this.velocityX = speedX;
	}

	@Override
	public int getVelocityY() {
		return velocityY;
	}

	@Override
	public void setVelocityY(int speedY) {
		this.velocityY = speedY;
	}

	public void updatePosition() {
		if (isAlive()){
			setX(getX() + getVelocityX());
			setY(getY() + getVelocityY());
		}
	}

	public boolean outOfBount(int shipY) {
		if (getY() < shipY - 400)
			return true;
		
		return false;
	}
	
}
