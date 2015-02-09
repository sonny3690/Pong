package com.game.sonny.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import com.game.sonny.main.Game;

public class RightPlayer {

	private float x, y;
	private float velX = 0, velY = 0;

	public RightPlayer(float x, float y) {
		setX(x);
		setY(y);
		
	}

	public void tick() {
		x += velX;
		y += velY;

		if (x <= Game.WIDTH / 2)
			x = Game.WIDTH / 2;
		if (x >= Game.WIDTH - 16)
			x = Game.WIDTH - 16;
		if (y <= 0)
			y = 0;
		if (y >= Game.HEIGHT - 71)
			y = Game.HEIGHT - 71;

	}

	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.BLUE);

		// ANTI-ALIASING
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_OFF);
		g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
				RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);

		g2d.fillRect((int) x, (int) y, 25, 80);

	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getVelX() {
		return velX;
	}

	public void setVelX(float velX) {
		this.velX = velX;
	}

	public float getVelY() {
		return velY;
	}

	public void setVelY(float velY) {
		this.velY = velY;
	}

	public Rectangle getBounds() {
		return new Rectangle((int)x,(int) y, 25, 80);
	}
	
	public Rectangle RightUp(){
		return new Rectangle((int) x+3,(int) y, 19, 1);
	}
	
	public Rectangle RightDown(){
		return new Rectangle((int) x+3,(int) y+80, 19, 1);
	}
	
	public Rectangle RightRight(){
		return new Rectangle((int) x + 25,(int) y, 1, 80);
	}
	
	public Rectangle RightLeft(){
		return new Rectangle((int) x,(int) y, 1, 80);
	}
	
	

}
