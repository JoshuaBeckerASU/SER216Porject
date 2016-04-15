package com.neet.DiamondHunter.Main;

import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;
import javax.swing.plaf.metal.MetalComboBoxUI;

import com.neet.DiamondHunter.GameState.PlayState;
import com.neet.DiamondHunter.Manager.GameStateManager;
import com.neet.DiamondHunter.Manager.JukeBox;

/**
 * added for in game toolbar
 * @author Joshua Becker
 * PopUpMetalComboBox found: http://www.coderanch.com/t/338399/GUI/java/Java-drop-JComboBox
 */

public class ToolBar extends JToolBar
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3393336406883439194L;
	GameStateManager gsm;
	GamePanel gp;
	
	public ToolBar(String name, GameStateManager gsm, GamePanel gamePanel)
	{
		super(name);
		this.gsm = gsm;
		this.gp = gamePanel;
		designToolBar();
	}
	public ToolBar(GameStateManager gsm, GamePanel gamePanel)
	{
		super();
		this.gsm = gsm;
		this.gp = gamePanel;
		designToolBar();
	}
	private void designToolBar()
	{
		// Set up Help button
		JButton button = new JButton("Help");
		button.setActionCommand("Help");
		button.addActionListener(new ButtonListener());
		add(button);
		
		//Adding New Game Button
		button = new JButton("Main Menu");
		button.setActionCommand("MainMenu");
		button.addActionListener(new ButtonListener());
		add(button);
		
		//Adding Music Options
		String [] musicOptions = new String [14];
		
		musicOptions[0] = "Music Options"; musicOptions[1] = "Mute"; musicOptions[2] = "UnMute";
		
		for(int i = 0; i < 10;i++)
			musicOptions[i+3] = ""+i;
		
	    JComboBox<String> comboBox = new JComboBox<String>(musicOptions);
		comboBox.setActionCommand("MusicOptions");
		comboBox.addActionListener(new ComboBoxListener(comboBox));
		comboBox.setUI(new PopUpMetalComboBoxUI());
		add(comboBox);
		
		// Set up button to add printer
		comboBox = new JComboBox<String>(new String [] {"Change Song","Original", "new Music"});
		comboBox.setActionCommand("Change Song");
		comboBox.addActionListener(new ComboBoxListener(comboBox));
		comboBox.setUI(new PopUpMetalComboBoxUI());
		add(comboBox);
		this.setFloatable(false);
		this.setFocusable(false);
		this.setBackground(java.awt.Color.BLACK);
		FlowLayout layout = new FlowLayout();
		layout.setVgap(0);
		layout.setHgap(15);
		this.setLayout(layout);
		this.setMargin(new Insets(0,30,0,30));
		
	}
	/**
	 * 
	 * @author Joshua Becker
	 *
	 */
	private class ComboBoxListener implements ActionListener
	{
		JComboBox<String> target;
		public ComboBoxListener(JComboBox<String> target)
		{
			super();
			this.target = target;
		}
		@Override
		public void actionPerformed(ActionEvent com) {
			String command = com.getActionCommand();
			switch(command)
			{
				case "Change Music": //TODO Change music here
					break;
				case "MusicOptions": 
						switch((String)target.getSelectedItem())
						{
						case "Mute":												
							JukeBox.stop("music1");
							target.setSelectedIndex(0);
							break;
						case "UnMute":
							JukeBox.loop("music1");
							target.setSelectedIndex(0);
							break;
						default: 
							JOptionPane.showMessageDialog(gp, "Unknown Command", "Unknown Command", JOptionPane.PLAIN_MESSAGE);
							break;
						}
					break;
				default: JOptionPane.showMessageDialog(gp, "Unknown Command", "Unknown Command", JOptionPane.PLAIN_MESSAGE);
					break;
			}
			gp.requestFocus();
		}
	}
	/**
	 * 
	 * @author Joshua Becker
	 *
	 */
	private class ButtonListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent com) {
			String command = com.getActionCommand();
			switch(command)
			{
				case "Help": 
							if(!gsm.isPaused())
								gsm.setPaused(true);
							else
								gsm.setPaused(false);
					break;
				case "MainMenu": 
								gsm.setState(GameStateManager.MENU);
								JukeBox.stop("music1");
								GamePanel.s_ToolBar.setVisible(false);
					break;
				case "Pause": 
								gsm.setPaused(true);
					break;
				case "Mute": 
								JukeBox.setVolume("music1", 100);
					break;
				case "UnMute":
								JukeBox.setVolume(JukeBox.getCurrentSong(), 0);
					break;
					
				default: 
					JOptionPane.showMessageDialog(gp, "Unknown Command", "Unknown Command", JOptionPane.PLAIN_MESSAGE);
					break;
			}
			gp.requestFocus();
		}
	}
	public class PopUpMetalComboBoxUI extends MetalComboBoxUI {
		  
		   protected ComboPopup createPopup() {
		      return new BasicComboPopup(comboBox) {
		         /**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				protected Rectangle computePopupBounds(int px, int py, int pw, int ph) {
		            Rectangle rect = super.computePopupBounds(px, py, pw, ph);
		            rect.y = -rect.height;
		            return rect;
		         }
		      };
		   }
		}
}
