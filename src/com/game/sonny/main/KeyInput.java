package com.game.sonny.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.game.sonny.objects.LeftPlayer;
import com.game.sonny.objects.RightPlayer;

public class KeyInput extends KeyAdapter {

	private LeftPlayer lp;
	private RightPlayer rp;
	private int vel = 10;

	public KeyInput(LeftPlayer lp, RightPlayer rp) {
		this.lp = lp;
		this.rp = rp;
		
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_ESCAPE) {
			System.exit(1);
		}

		// LEFT PLAYER
		if (key == KeyEvent.VK_S) {
			lp.setVelY(vel);
		}

		if (key == KeyEvent.VK_W) {
			lp.setVelY(-vel);
		}
		if (key == KeyEvent.VK_A) {
			lp.setVelX(-vel);
		}
		if (key == KeyEvent.VK_D) {
			lp.setVelX(vel);
		}

		// RIGHT PLAYER
		if (key == KeyEvent.VK_DOWN) {
			rp.setVelY(vel);
		}

		if (key == KeyEvent.VK_UP) {
			rp.setVelY(-vel);
		}
		if (key == KeyEvent.VK_LEFT) {
			rp.setVelX(-vel);
		}
		if (key == KeyEvent.VK_RIGHT) {
			rp.setVelX(vel);
		}

	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_ESCAPE) {
			System.exit(1);
		}

		// LEFT PLAYER
		if (key == KeyEvent.VK_S) {
			lp.setVelY(0);
		}

		if (key == KeyEvent.VK_W) {
			lp.setVelY(0);
		}
		if (key == KeyEvent.VK_A) {
			lp.setVelX(0);
		}
		if (key == KeyEvent.VK_D) {
			lp.setVelX(0);
		}

		// RIGHT PLAYER
		if (key == KeyEvent.VK_DOWN) {
			rp.setVelY(0);
		}

		if (key == KeyEvent.VK_UP) {
			rp.setVelY(0);
		}
		if (key == KeyEvent.VK_LEFT) {
			rp.setVelX(0);
		}
		if (key == KeyEvent.VK_RIGHT) {
			rp.setVelX(0);
		}
		
	}

}
