package view;

import java.awt.Color;
import java.awt.Graphics;

import model.Shape;
import model.Shape.Tetrominoes;

public class NextBoard extends Board{

	public NextBoard() {
		super();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g, false);
		if (!nextPiece.getShape().equals(Tetrominoes.NoShape)) {
			for (int i = 0; i < 4; ++i) {
				int x = curX - nextPiece.x(i);
				int y = curY - nextPiece.y(i);
				drawSquare(g,(int) (40 + x * squareWidth()),(int) (50 + y * squareHeight()),
						nextPiece.getShape());
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
	
	public Tetrominoes next(Shape shape) {
		Tetrominoes temp = nextPiece.getShape();
		nextPiece.setShape(shape.getShape());
		repaint();
		return temp;
	}
	
}
