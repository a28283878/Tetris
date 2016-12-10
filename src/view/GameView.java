package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.MainController;

public class GameView extends JFrame{
	JButton Back;
	JLabel statusbar;
	TetrisPanel GamePanel;
	JPanel InfoPanel;
	public GameView(){
		setSize(300,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GamePanel = new TetrisPanel();
		GamePanel.setBackground(Color.WHITE);
		getContentPane().add(GamePanel);
		
		InfoPanel = new JPanel();
		
		statusbar = new JLabel("Score : 0");
		statusbar.setFont(statusbar.getFont().deriveFont(18.0f));
		InfoPanel.add(statusbar, BorderLayout.WEST);
		
		Back = new JButton("Back");
		Back.setFont(Back.getFont().deriveFont(18.0f));
		Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainController MC = new MainController();
				MC.Menu();
			}
		});
		
		InfoPanel.add(Back,BorderLayout.EAST);
		
		getContentPane().add(InfoPanel,BorderLayout.SOUTH);
        
	}
}
