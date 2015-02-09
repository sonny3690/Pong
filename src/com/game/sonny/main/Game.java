package com.game.sonny.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import com.game.sonny.objects.Ball;
import com.game.sonny.objects.LeftPlayer;
import com.game.sonny.objects.RightPlayer;

public class Game extends Canvas implements Runnable {

	// Window Variables
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width - 15;
	public static final int HEIGHT = Toolkit.getDefaultToolkit()
			.getScreenSize().height - 90;

	// System Variables
	private boolean running = false;
	private Thread thread;
	private float playerVX = 0, playerVY = 0;
	private Font scoreFont = new Font("SERIF", Font.PLAIN, 32);

	// Objects
	private LeftPlayer lp;
	private RightPlayer rp;
	private Ball ball;
	private int lscore = 0, rscore = 0;

	public void init() {
		lp = new LeftPlayer(100, 300, this);
		rp = new RightPlayer(700, 300);

		ball = new Ball(getWidth() / 2 - 32 / 2, getHeight() / 2 - 32 / 2, rp,
				lp, this);

		this.addKeyListener(new KeyInput(lp, rp));
		
		 try {
	            // Set cross-platform Java L&F (also called "Metal")
	        UIManager.setLookAndFeel(
	            UIManager.getCrossPlatformLookAndFeelClassName());
	    }catch (Exception e){
	    	e.printStackTrace();
	    }

	}

	public synchronized void start() {
		if (running)
			return;

		running = true;
		thread = new Thread(this);
		thread.start();
	}

	public void run() { // system main loop
		init();
		this.requestFocus();

		long lastTime = System.nanoTime();
		final double amountofTicks = 60D;
		double ns = 1000000000 / amountofTicks;
		double delta = 0;
		int updates = 0;
		int frames = 0;
		long timer = System.currentTimeMillis();
		while (running) {
			// the game loop
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;

			if (delta >= 1) {
				tick();
				updates++;
				delta--;
			}
			render();
			frames++;

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println(updates + " Ticks, FPS " + frames);
				updates = 0;
				frames = 0;
			}

		}

	}

	public void score(char d) {

		if (d == 'l') {
			lscore++;
			ball = new Ball(getWidth() / 2 - 32 / 2, getHeight() / 2 - 32 / 2,
					rp, lp, this);
		} else if (d == 'r') {
			rscore++;
			ball = new Ball(getWidth() / 2 - 32 / 2, getHeight() / 2 - 32 / 2,
					rp, lp, this);
		}

	}

	public void tick() {
		lp.tick();
		rp.tick();
		ball.tick();

		if (rscore >= 5) {
			JOptionPane.showMessageDialog(null, "Left Wins!");
			System.exit(1);
		}
		if (lscore >= 5) {
			JOptionPane.showMessageDialog(null, "Right Wins!");
			System.exit(1);
		}

	}

	public void render() {
		BufferStrategy bs = this.getBufferStrategy();

		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}

		Graphics g = bs.getDrawGraphics();

		// //////////////////////////////
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());

		// Graphics2D

		Graphics2D g2d = (Graphics2D) g;

		g.setColor(Color.WHITE);

		// ANTI-ALIASING
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_OFF);
		g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
				RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);

		g.setColor(Color.BLACK);
		g2d.drawLine(WIDTH / 2, 0, WIDTH / 2, HEIGHT + 30);
		// g2d.fillOval(WIDTH/2-20, HEIGHT.2 40,40);

		g.setColor(Color.WHITE);
		g2d.drawLine(WIDTH / 2, 0, WIDTH / 2, HEIGHT + 30);
		g2d.setFont(scoreFont);
		g2d.drawString(rscore + ":" + lscore, 30, 30);

		lp.render(g);
		rp.render(g);
		ball.render(g);

		// //////////////////////////////

		g.dispose();
		bs.show();

	}

	public static void main(String[] args) {
		new Frame(WIDTH, HEIGHT, "Pong", new Game());
	}

}
