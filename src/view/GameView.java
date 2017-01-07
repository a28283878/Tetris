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

import controller.GameController;
import controller.MainController;
import model.GameSetting;

public class GameView extends JFrame {
	public GameSetting GS = new GameSetting();;
	public JButton Stop;
	JLabel statusbar;
	TetrisPanel GamePanel;
	JPanel InfoPanel;
	public Board board;
	HoldView holdView;

	public GameView() {
		holdView = new HoldView(this);
	}

	public JLabel getStatusBar() {
		return statusbar;
	}
	
	public HoldView getHoldView() {
		return holdView;
	}

	public void GamePrepare() {
		statusbar = new JLabel("Score : 0");

		board = new Board(this, GS);
		board.start();
		setSize(300, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		GamePanel = new TetrisPanel();
		GamePanel.setBackground(Color.WHITE);
		GamePanel.setLayout(new BorderLayout());
		GamePanel.add(board, BorderLayout.CENTER);
		setContentPane(GamePanel);

		InfoPanel = new JPanel();
		InfoPanel.setPreferredSize(new Dimension(300, 50));

		statusbar.setFont(statusbar.getFont().deriveFont(18.0f));
		InfoPanel.add(statusbar, BorderLayout.WEST);

		Stop = new JButton("stop");
		Stop.setFont(Stop.getFont().deriveFont(18.0f));
		Stop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameController GC = new GameController();
				GC.stop();
			}
		});

		InfoPanel.add(Stop, BorderLayout.EAST);

		 getContentPane().add(InfoPanel,BorderLayout.SOUTH);
	}
	
	@Override
	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		super.setVisible(b);
		holdView.setVisible(b);
	}
}
