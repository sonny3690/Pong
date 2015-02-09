package com.game.sonny.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import com.game.sonny.main.Game;

public class LeftPlayer {

	private float x, y;
	private float velX = 0, velY = 0;

	private Game game;

	public LeftPlayer(float x, float y, Game game) {
		this.x = x;
		this.y = y;
		this.game = game;
	}

	public void tick() {

		if (x <= 0)
			x = 0;
		if (x >= Game.WIDTH / 2)
			x = Game.WIDTH / 2;
		if (y <= 0)
			y = 0;
		if (y >= Game.HEIGHT - 71)
			y = Game.HEIGHT - 71;

	}

	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;

		// ANTI-ALIASING
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_OFF);
		g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
				RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);

		g2d.setColor(Color.WHITE);
		g2d.fillRect((int) x, (int) y, 25, 80);
		g2d.drawOval(game.WIDTH / 2 - 50, game.HEIGHT / 2 - 50, 100, 100);
		// the board

		// Left Player
		g2d.setColor(Color.RED);
		g2d.fillRect((int) x + 3, (int) y, 19, 80);

		g.setColor(Color.BLACK);
		// g2d.drawLine(Game.WIDTH / 2, 0, Game.WIDTH / 2, Game.HEIGHT + 30);
		// g2d.fillOval(400 - 50 + 1, 300 - 50 + 1, 98, 98);

		g.setColor(Color.WHITE);
		g2d.drawLine(Game.WIDTH / 2, 0, Game.WIDTH / 2, Game.HEIGHT + 30);

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
		return new Rectangle((int) x, (int) y, 25, 80);
	}

	public Rectangle LeftUp() {
		return new Rectangle((int) x + 3, (int) y, 19, 1);
	}

	public Rectangle LeftDown() {
		return new Rectangle((int) x + 3, (int) y + 80, 19, 1);
	}

	public Rectangle LeftRight() {
		return new Rectangle((int) x + 25, (int) y, 1, 80);
	}

	public Rectangle LeftLeft() {
		return new Rectangle((int) x, (int) y, 1, 80);
	}

	public Rectangle rtCorner() {
		return new Rectangle((int) x, (int) y + 19, 3, 3);
	}

}
