package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.MainController;
import model.GameSetting;

public class SettingView extends JFrame{
	JButton Back,Send;
	JLabel txtDifficulty;
	JTextField Difficulty;
	public GameSetting GS = new GameSetting();
	
	public SettingView(){
		setSize(300,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		txtDifficulty = new JLabel("Difficulty : ");
		txtDifficulty.setFont(txtDifficulty.getFont().deriveFont(24.0f));
		txtDifficulty.setBounds(20, 20, 240, 30);
		getContentPane().add(txtDifficulty);	
		
		Difficulty = new JTextField();
		Difficulty.setText(String.valueOf(GS.difficulty));
		Difficulty.setBounds(20, 60, 240, 30);
		getContentPane().add(Difficulty);
		
		Send = new JButton("Send");
		Send.setFont(Send.getFont().deriveFont(24.0f));
		Send.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GS.difficulty = Integer.valueOf(Difficulty.getText().toString());
				MainController MC = new MainController();
				MC.gamesetting = GS;
				MC.Menu();
			}
		});
		Send.setBounds(20, 470, 240, 30);
		getContentPane().add(Send);
		
		Back = new JButton("Cancel");
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
