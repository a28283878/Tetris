package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import controller.MainController;

public class SettingView extends JFrame{
	JButton Back;
	
	public SettingView(){
		setSize(300,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		Back = new JButton("Back");
		Back.setFont(Back.getFont().deriveFont(24.0f));
		Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainController MC = new MainController();
				MC.Menu();
			}
		});
		Back.setBounds(20, 510, 240, 30);
		getContentPane().add(Back);
	}
}
