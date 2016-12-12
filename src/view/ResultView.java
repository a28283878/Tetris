package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.SwingConstants;

import controller.MainController;

public class ResultView extends JWindow {
	JButton Back;
	JLabel Title;
	JLabel result;
	private int X = 0;
	private int Y = 0;
	JPanel panel = new JPanel();
	MainController MC = new MainController();
	public ResultView() {
		setSize(300,150);
		setLocationRelativeTo(null);
		
		Title = new JLabel("GGGGGGGGGG",SwingConstants.CENTER);
		Title.setFont(Title.getFont().deriveFont(36.0f));
		Title.setBounds(20, 5, 240, 100);
		panel.add(Title);
				
		result = new JLabel("",SwingConstants.CENTER);
		result.setFont(result.getFont().deriveFont(36.0f));
		result.setBounds(20, 5, 240, 100);
		panel.add(result);
		
		Back = new JButton("Back");
		Back.setFont(Back.getFont().deriveFont(24.0f));
		Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainController MC = new MainController();
				MC.Menu();				
			}
		});
		panel.add(Back);
		
		add(panel);
		setVisible(true);
	}
	
	public void setResult(int score) {
		result.setText(String.valueOf(score));
	}
}