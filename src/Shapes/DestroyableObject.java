package Shapes;

import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.util.Random;

public class DestroyableObject implements GameObject {
	
	private int x;
	private int y;
	private double angle;
	private boolean alive;
	private int velX;
	private int velY;
	private Shape shape;

	Random rand = new Random();
	private int width;
	private int height;

	public DestroyableObject(int x, int y){
		setX(x);
		setY(y);
		
		this.width = rand.nextInt(45) + 5;
		this.height = rand.nextInt(45) + 5;
		setShape(new Rectangle2D.Double(0, 0, this.width, this.height));
	}

	public int getHeight(){
		return height;
	}
	
	public int getWidth(){
		return width;
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
		return angle;
	}

	@Override
	public void setFaceAngle(double angle) {
		this.angle = angle;
	}

	@Override
	public boolean isAlive() {
		return alive;
	}

	@Override
	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	@Override
	public int getVelocityX() {
		return velX;
	}

	@Override
	public void setVelocityX(int speedX) {
		this.velX = speedX;
	}

	@Override
	public int getVelocityY() {
		return velY;
	}

	@Override
	public void setVelocityY(int speedY) {
		this.velY = speedY;
	}

	@Override
	public void setShape(Shape shape) {
		this.shape = shape;
	}

	@Override
	public Shape getShape() {
		return shape;
	}

}
