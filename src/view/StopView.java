package view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.SwingConstants;

import controller.GameController;
import controller.MainController;


public class StopView extends JWindow {
	JButton Back;
	JButton Continue;
	JPanel panel = new JPanel();
	
	public StopView() {
		setSize(300,60);
		setLocationRelativeTo(null);
		Back = new JButton("Menu");
		Back.setFont(Back.getFont().deriveFont(24.0f));
		Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainController MC = new MainController();
				MC.Menu();
				
			}
		});
		panel.add(Back);
		Continue = new JButton("Continue");
		Continue.setFont(Continue.getFont().deriveFont(24.0f));
		Continue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameController GC = new GameController();
				GC.Game();
				
			}
		});
		panel.add(Continue);
		add(panel);
		
		setVisible(true);
	}
}
