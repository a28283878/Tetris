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
	public JButton Stop;
	JLabel statusbar;
	TetrisPanel GamePanel;
	JPanel InfoPanel;
	public final Board board;
	public GameView(){
		
		statusbar = new JLabel("Score : 0");

        board = new Board(this);
        board.start();
		setSize(300,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GamePanel = new TetrisPanel();
		GamePanel.setBackground(Color.WHITE);
		GamePanel.setLayout(new BorderLayout());
		GamePanel.add(board,BorderLayout.CENTER);
		setContentPane(GamePanel);
		
		InfoPanel = new JPanel();
		
		statusbar.setFont(statusbar.getFont().deriveFont(18.0f));
		InfoPanel.add(statusbar, BorderLayout.WEST);
		
		Stop = new JButton("stop");
		Stop.setFont(Stop.getFont().deriveFont(18.0f));
		Stop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainController MC = new MainController();
				MC.stop();
			}
		});
		
		InfoPanel.add(Stop,BorderLayout.EAST);
		
		getContentPane().add(InfoPanel,BorderLayout.SOUTH);
        
	}
	 public JLabel getStatusBar() {
	       return statusbar;
	   }
}
