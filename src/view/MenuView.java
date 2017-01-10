package view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import controller.MainController;


public class MenuView extends JFrame{
	JLabel Title;
	JButton Start;
	JButton Setting;
	JButton Quit;
	
	public MenuView(){
		setSize(300,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		Title = new JLabel("Tetris Game",SwingConstants.CENTER);
		Title.setName("Tetris Game");
		Title.setFont(Title.getFont().deriveFont(36.0f));
		Title.setBounds(20, 5, 240, 100);
		getContentPane().add(Title);
		
		Start = new JButton("Start");
		Start.setName("Start");

		Start.setFont(Start.getFont().deriveFont(24.0f));
		Start.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainController MC = new MainController();
				MC.Start();
				
			}
		});
		Start.setBounds(20, 140, 240, 40);
		getContentPane().add(Start);

		
		Setting = new JButton("Setting");
		Setting.setFont(Setting.getFont().deriveFont(24.0f));
		Setting.setName("Setting");
		Setting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainController MC = new MainController();
				MC.Setting();
			}
		});
		Setting.setBounds(20, 240, 240, 40);
		getContentPane().add(Setting);

		
		Quit = new JButton("Quit");
		Quit.setFont(Quit.getFont().deriveFont(24.0f));
		Quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		Quit.setBounds(20, 340, 240, 40);
		getContentPane().add(Quit);
	
	}
}
