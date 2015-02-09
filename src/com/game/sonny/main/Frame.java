package com.game.sonny.main;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Frame {

	Game game;
	String title;
	
	public Frame (int width, int height, String title, Game game){
		
		this.game = game;
		this.title = title;	
		
		game.setPreferredSize(new Dimension (width, height));
		game.setMinimumSize(new Dimension (width, height));
		game.setMaximumSize(new Dimension (width, height));
		
		setFrame ();
		
	}
	
	public void setFrame (){
		JFrame frame = new JFrame(title);
		frame.add(game);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		
		game.start();
		
		
		
		
	}
	
	
	
	
}
