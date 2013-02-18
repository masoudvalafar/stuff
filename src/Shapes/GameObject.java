package Shapes;

import java.awt.Shape;

public interface GameObject {
	
	int getX();
	void setX(int x);
	int getY();
	void setY(int y);
	double getFaceAngle();
	void setFaceAngle(double angle);
	boolean isAlive();
	void setAlive(boolean alive);
	int getVelocityX();
	void setVelocityX(int speedX);
	int getVelocityY();
	void setVelocityY(int speedY);
	void setShape(Shape shape);
	Shape getShape();
}
