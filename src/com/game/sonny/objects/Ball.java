package com.game.sonny.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import com.game.sonny.main.Game;

public class Ball {

	private float x, y;
	private final float xspeed = 5, yspeed = 4;
	private float velX = xspeed, velY = yspeed;
	private int i = 1;

	// objects
	private RightPlayer rp;
	private LeftPlayer lp;
	private Game game;

	public Ball(int x, int y, RightPlayer rp, LeftPlayer lp, Game game) {
		setX(x);
		setY(y);

		this.rp = rp;
		this.lp = lp;
		this.game = game;
	}

	public void tick() {
		x += velX;
		y += velY;

		System.out.printf("SPEED: (%f,%f)\n", velX, y);
		Collision();

	}

	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;

		// ANTI-ALIASING
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
				RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

		g2d.setColor(Color.YELLOW);
		g2d.fillOval((int) x, (int) y, 32, 32);

		g2d.draw(lp.LeftUp());
		g2d.draw(lp.LeftDown());
		// g2d.draw(lp.LeftRight());
		// g2d.draw(lp.LeftLeft());

		g2d.draw(rp.RightUp());
		g2d.draw(rp.RightDown());
		// g2d.draw(rp.RightRight());
		g2d.draw(rp.RightLeft());
		// g2d.draw(boundary3());

	}

	public float getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, 32, 32);
	}

	public void Collision() {

		if (getBounds().intersects(lp.LeftUp())) {
			setXSpeed();
			return;
		}

		if (getBounds().intersects(lp.LeftDown())) {
			setXSpeed();
			return;
		}

		if (getBounds().intersects(lp.LeftRight())
				|| getBounds().intersects(lp.LeftLeft())) {
			setYSpeed();
		}

		if (getBounds().intersects(rp.RightUp())
				|| getBounds().intersects(rp.RightDown())) {
			setXSpeed();
			return;

		}

		if (getBounds().intersects(rp.RightRight())
				|| getBounds().intersects(rp.RightLeft())) {

			setXSpeed();
			return;
		}

		if (getBounds().intersects(boundary1())) {
			// LEFT
			game.score('l');

			return;

		}
		if (getBounds().intersects(boundary2())) {
			// TOP

			setYSpeed();

			return;
		}
		if (getBounds().intersects(boundary3())) {
			// RIGHT
			game.score('r');
		}
		if (getBounds().intersects(boundary4())) {
			// BOTTOM
			setYSpeed();
			return;

		} else {
			x += velX;
			y += velY;
		}

	}

	public void setYSpeed() {
		if (y > 0) {
			y -= yspeed;
			return;
		}
		if (y < 0) {
			y += yspeed;
			return;
		}
		return;

	}

	public void setXSpeed() {
		if (x > 0) {
			x -= xspeed;
			return;
		}
		if (x < 0) {
			x += xspeed;
			return;
		}
		return;

	}

	public Rectangle boundary1() {
		return new Rectangle(0, 0, 1, Game.HEIGHT + 10);
	}

	public Rectangle boundary2() {
		return new Rectangle(0, 0, Game.WIDTH, 1);
	}

	public Rectangle boundary3() {
		// RIGHT
		return new Rectangle(Game.WIDTH + 5, 0, 1, Game.HEIGHT + 10);
	}

	public Rectangle boundary4() {
		// BOTTOM
		return new Rectangle(0, Game.HEIGHT + 9, Game.WIDTH, 1);
	}

}
