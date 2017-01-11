package view;

import java.awt.Color;
import java.awt.Graphics;

import model.Shape;
import model.Shape.Tetrominoes;

public class HoldBoard extends Board{

	public HoldBoard() {
		super();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g, false);
		if (!curPiece.getShape().equals(Tetrominoes.NoShape)) {
			for (int i = 0; i < 4; ++i) {
				int x = curX - curPiece.x(i);
				int y = curY - curPiece.y(i);
				drawSquare(g,(int) (40 + x * squareWidth()),(int) (50 + y * squareHeight()),
						curPiece.getShape());
			}
		}
	}
	
	@Override
	int squareHeight() {
		// TODO Auto-generated method stub
		return (int) getSize().getWidth() / 5;
	}
	
	@Override
	int squareWidth() {
		// TODO Auto-generated method stub
		return (int) getSize().getHeight() / 5;
	}
	
	public Tetrominoes hold(Shape shape) {
		Tetrominoes temp = curPiece.getShape();
		curPiece.setShape(shape.getShape());
		repaint();
		return temp;
	}
	
}
