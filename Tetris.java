package view;

import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Point;

import javax.swing.JFrame;

import model.GameSetting;
import model.Shape;
import model.Shape.Tetrominoes;

public class HoldView extends JFrame {
	HoldBoard holdBoard;
	
	public HoldView(GameView parent) {
		setSize(100, 100);
		
		holdBoard = new HoldBoard();
		add(holdBoard);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
//		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setUndecorated(true);
		setLoc();
		//setVisible(true);
	}
	
	private void setLoc() {
		Dimension windowSize = getSize();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Point centerPoint = ge.getCenterPoint();

        int dx = centerPoint.x - windowSize.width / 2;
        int dy = centerPoint.y - windowSize.height / 2;    
        setLocation(dx+145, dy+130);
	}
	
	public Tetrominoes hold(Shape shape) {
		return holdBoard.hold(shape);
	}
}
