// The entry point of the game.
// This class loads up a JFrame window and
// puts a GamePanel into it.

package com.neet.DiamondHunter.Main;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;

public class Game {
	
	public static void main(String[] args) 
	{
		
		JFrame window = new JFrame("Diamond Hunter");
		window.setLayout(new GridLayout(1,1,0,0));
		window.add(new GamePanel());
		
		window.setResizable(false);
		window.setBackground(Color.BLACK);

		window.pack();
		
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
}
