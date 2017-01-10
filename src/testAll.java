import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.Shape;
import view.Board;

public class testAll {
	Board board;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		board = new Board();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test3() {
		Shape shape = new Shape();
		shape.setRandomShape();
		int current = Shape.shapeMode;
		for (int i = 0; i < 100; ++i) {
			shape.setRandomShape();
			if (current != Shape.shapeMode)
				return;
		}
		fail("test 3 generate random failed");
	}

	@Test
	public void test4() {
		Shape shape = new Shape();
		shape.setShape(Shape.Tetrominoes.LShape);
		int[][] coord = shape.getCoord();
		shape = shape.rotate();
		int[][] rotateCoord = shape.getCoord();
		if (coord.equals(rotateCoord))
			fail("test 4 rotate failed");

	}

	@Test
	public void test5() {
		Board board = new Board();
		board.removeFullLines(1);
		if (board.numLinesRemoved != 1)
			fail("Not yet implemented");
	}

	@Test
	public void test6() {
		
	}

	@Test
	public void test10() {
		Board board = new Board();
		board.moveLeft();
		if(board.mode != 1)
		    fail("failed move left");
		board.moveRight();
		if(board.mode != 2)
		    fail("failed move right");
	}

}
