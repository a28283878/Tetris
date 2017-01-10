package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import controller.GameController;
import controller.MainController;
import model.GameSetting;
import model.Shape;
import model.Shape.Tetrominoes;

;

public class Board extends JPanel implements ActionListener {
	public int mode = 0;
	final int BoardWidth = 10;
	final int BoardHeight = 20;

	Timer timer;
	boolean isFallingFinished = false;
	public static boolean isStarted = false;
	public boolean isPaused = false;
	public int numLinesRemoved = 0;
	int curX = 0;
	int curY = 0;
	JLabel statusbar;
	Shape curPiece;
	Tetrominoes[] board;
	HoldView holdview;

	public Board(GameView parent, GameSetting GS) {

		setFocusable(true);
		curPiece = new Shape();

		timer = new Timer(400 / GS.difficulty, this);
		timer.start();
		setOpaque(false);
		statusbar = parent.getStatusBar();
		holdview = parent.getHoldView();
		board = new Tetrominoes[BoardWidth * BoardHeight];
		addKeyListener(new TAdapter());
	}

	// This constructor is for HoldBoard
	public Board() {
		curPiece = new Shape();
		setOpaque(false);
	}

	public void actionPerformed(ActionEvent e) {
		if (isFallingFinished) {
			isFallingFinished = false;
			newPiece();
		} else {
			oneLineDown();
		}
	}

	int squareWidth() {
		return (int) getSize().getWidth() / BoardWidth;
	}

	int squareHeight() {
		return (int) getSize().getHeight() / BoardHeight;
	}

	Tetrominoes shapeAt(int x, int y) {
		return board[(y * BoardWidth) + x];
	}

	public void start() {
		if (isPaused)
			return;

		isStarted = true;
		isFallingFinished = false;
		numLinesRemoved = 0;
		clearBoard();

		newPiece();
		timer.start();
	}

	public void pause() {
		if (!isStarted)
			return;
		isStarted = !isStarted;
		isPaused = !isPaused;
		if (isPaused) {
			timer.stop();
		} else {
			timer.start();
			statusbar.setText(String.valueOf(numLinesRemoved));
		}
		repaint();
	}

	public void continu() {
		if (!isPaused)
			return;
		isPaused = !isPaused;
		isStarted = !isStarted;
		if (isStarted) {
			timer.start();
		} else {
			timer.start();
			statusbar.setText(String.valueOf(numLinesRemoved));
		}
		repaint();
	}

	public void paint(Graphics g) {
		super.paint(g);

		Dimension size = getSize();
		int boardTop = (int) size.getHeight() - BoardHeight * squareHeight();

		for (int i = 0; i < BoardHeight; ++i) {
			for (int j = 0; j < BoardWidth; ++j) {
				Tetrominoes shape = shapeAt(j, BoardHeight - i - 1);
				if (shape != Tetrominoes.NoShape)
					drawSquare(g, 0 + j * squareWidth(), boardTop + i * squareHeight(), shape);
			}
		}

		if (curPiece.getShape() != Tetrominoes.NoShape) {
			for (int i = 0; i < 4; ++i) {
				int x = curX + curPiece.x(i);
				int y = curY - curPiece.y(i);
				drawSquare(g, 0 + x * squareWidth(), boardTop + (BoardHeight - y - 1) * squareHeight(),
						curPiece.getShape());
			}
		}
		// System.out.println("pause"+isPaused);
		// System.out.println("start"+isStarted);
	}

	// This is only a workaround for HoldBoard to call super.super.paint(g)
	public void paint(Graphics g, boolean b) {
		super.paint(g);
	}

	public void dropDown() {
		int newY = curY;
		while (newY > 0) {
			if (!tryMove(curPiece, curX, newY - 1))
				break;
			--newY;
		}
		pieceDropped();
	}

	private void oneLineDown() {
		if (!tryMove(curPiece, curX, curY - 1))
			pieceDropped();
	}

	public void clearBoard() {
		for (int i = 0; i < BoardHeight * BoardWidth; ++i)
			board[i] = Tetrominoes.NoShape;
	}

	private void pieceDropped() {
		for (int i = 0; i < 4; ++i) {
			int x = curX + curPiece.x(i);
			int y = curY - curPiece.y(i);
			board[(y * BoardWidth) + x] = curPiece.getShape();
		}

		removeFullLines();

		if (!isFallingFinished)
			newPiece();
	}

	private void newPiece() {
		curPiece.setRandomShape();
		curX = BoardWidth / 2 + 1;
		curY = BoardHeight - 1 + curPiece.minY();

		if (!tryMove(curPiece, curX, curY)) {
			curPiece.setShape(Tetrominoes.NoShape);

			timer.stop();
			isStarted = false;
			GameController GC = new GameController();
			GC.Result(numLinesRemoved);

		}
	}

	private void newPiece(Tetrominoes shape) {
		if (shape.equals(Tetrominoes.NoShape))
			curPiece.setRandomShape();
		else {
			curPiece.setShape(shape);
		}
		curX = BoardWidth / 2 + 1;
		curY = BoardHeight - 1 + curPiece.minY();

		if (!tryMove(curPiece, curX, curY)) {
			curPiece.setShape(Tetrominoes.NoShape);

			timer.stop();
			isStarted = false;
			GameController GC = new GameController();
			GC.Result(numLinesRemoved);

		}
	}

	private boolean tryMove(Shape newPiece, int newX, int newY) {
		for (int i = 0; i < 4; ++i) {
			int x = newX + newPiece.x(i);
			int y = newY - newPiece.y(i);
			if (x < 0 || x >= BoardWidth || y < 0 || y >= BoardHeight) {

				return false;
			}

			if (shapeAt(x, y) != Tetrominoes.NoShape) {

				return false;
			}

		}

		// System.out.println(numLinesRemoved);
		curPiece = newPiece;
		curX = newX;
		curY = newY;
		repaint();
		return true;
	}

	public void removeFullLines() {
		int numFullLines = 0;

		for (int i = BoardHeight - 1; i >= 0; --i) {
			boolean lineIsFull = true;

			for (int j = 0; j < BoardWidth; ++j) {
				if (shapeAt(j, i) == Tetrominoes.NoShape) {
					lineIsFull = false;
					break;
				}
			}

			if (lineIsFull) {
				++numFullLines;
				for (int k = i; k < BoardHeight - 1; ++k) {
					for (int j = 0; j < BoardWidth; ++j)
						board[(k * BoardWidth) + j] = shapeAt(j, k + 1);
				}
			}
		}

		if (numFullLines > 0) {
			numLinesRemoved += numFullLines;
			// System.out.println("update statusbar: " +
			// String.valueOf(numLinesRemoved));
			statusbar.setText("Score : " + String.valueOf(numLinesRemoved));
			isFallingFinished = true;
			curPiece.setShape(Tetrominoes.NoShape);
			repaint();

		}
	}
	public void removeFullLines(int numberLines) {
		int numFullLines = 0;
		for (int i = BoardHeight - 1; i >= 0; --i) {
			boolean lineIsFull = true;

			for (int j = 0; j < BoardWidth; ++j) {
			
			}

			if (lineIsFull) {
				++numFullLines;
			}
		}
		numFullLines = 0;
		numFullLines += numberLines;
		if (numFullLines > 0) {
			numLinesRemoved += numFullLines;
			
			//System.out.println("numLinesRemoved: " + String.valueOf(numFullLines));
			// String.valueOf(numLinesRemoved));
			//statusbar.setText("Score : " + String.valueOf(numLinesRemoved));
			isFallingFinished = true;
			//curPiece.setShape(Tetrominoes.NoShape);
			//repaint();
		}
		
	}
	public void setPos(int x, int y) {
		curPiece.setShape(Tetrominoes.ZShape);
		board[(y * BoardWidth) + x] = shapeAt(1, 1);
	}

	protected void drawSquare(Graphics g, int x, int y, Tetrominoes shape) {
		Color colors[] = { new Color(0, 0, 0), new Color(204, 102, 102), new Color(102, 204, 102),
				new Color(102, 102, 204), new Color(204, 204, 102), new Color(204, 102, 204), new Color(102, 204, 204),
				new Color(218, 170, 0) };

		Color color = colors[shape.ordinal()];

		g.setColor(color);
		g.fillRect(x + 1, y + 1, squareWidth() - 2, squareHeight() - 2);

		g.setColor(color.brighter());
		g.drawLine(x, y + squareHeight() - 1, x, y);
		g.drawLine(x, y, x + squareWidth() - 1, y);

		g.setColor(color.darker());
		g.drawLine(x + 1, y + squareHeight() - 1, x + squareWidth() - 1, y + squareHeight() - 1);
		g.drawLine(x + squareWidth() - 1, y + squareHeight() - 1, x + squareWidth() - 1, y + 1);
	}

	class TAdapter extends KeyAdapter {

		public void keyPressed(KeyEvent e) {

			if (!isStarted || curPiece.getShape() == Tetrominoes.NoShape) {
				return;
			}

			int keycode = e.getKeyCode();

			if (keycode == 'p' || keycode == 'P') {
				pause();
				return;
			}

			if (isPaused)
				return;

			switch (keycode) {
			case KeyEvent.VK_LEFT:
				moveLeft();
				break;
			case KeyEvent.VK_RIGHT:
				moveRight();
				break;
			case KeyEvent.VK_DOWN:
				tryMove(curPiece, curX, curY - 1);
				// for unit test left
				mode = 3;
				break;
			case KeyEvent.VK_UP:
				tryMove(curPiece.rotate(), curX, curY);
				// for unit test left
				mode = 4;
				break;
			case KeyEvent.VK_SPACE:
				dropDown();
				break;
			case 'd':
				oneLineDown();
				break;
			case 'D':
				oneLineDown();
				break;
			case 'h':
			case 'H':
				newPiece(holdview.hold(curPiece));
				break;
			}

		}
	}
	public void moveLeft(){
		tryMove(curPiece, curX - 1, curY);
		// for unit test left
		mode = 1;
	}
	public void moveRight(){
		tryMove(curPiece, curX + 1, curY);
		mode = 2;
	}

}
