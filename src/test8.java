
import static org.junit.Assert.*;

import java.awt.AWTException;
import java.awt.Robot;

import javax.swing.JFrame;

import org.assertj.swing.core.BasicComponentFinder;
import org.assertj.swing.core.BasicRobot;
import org.assertj.swing.core.ComponentFinder;
import org.assertj.swing.core.GenericTypeMatcher;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.finder.FrameFinder;
import org.assertj.swing.finder.WindowFinder;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.junit.testcase.AssertJSwingJUnitTestCase;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import controller.MainController;
import view.GameView;
import view.MenuView;
import view.StopView;
import view.TetrisPanel;
import view.tetris;

import static org.assertj.swing.core.matcher.JButtonMatcher.withText;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.swing.launcher.ApplicationLauncher.application;
import static org.assertj.swing.finder.WindowFinder.findFrame;

public class test8 extends AssertJSwingJUnitTestCase {
	// http://joel-costigliola.github.io/assertj/assertj-swing-basics.html
	// http://joel-costigliola.github.io/assertj/assertj-swing-lookup.html
	// http://joel-costigliola.github.io/assertj/assertj-swing-input.html
	// assert function can read
	// https://objectpartners.com/2013/09/18/the-benefits-of-using-assertthat-over-other-assert-methods-in-unit-tests/

	private FrameFixture window;

	@Test
	public void test8_Continue() {
		MenuView frame = GuiActionRunner.execute(() -> new MenuView());
		// frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		window = new FrameFixture(robot(), frame);
		// window.requireVisible();
		window.resizeWidthTo(300);
		window.resizeHeightTo(600);
		window.show(); // shows the frame to test
		GuiActionRunner.execute(() -> window.button("Start").target().doClick());
		FrameFixture gamePanel = findFrame(GameView.class).withTimeout(5000).using(robot());
		// FrameFixture gamePanel =
		findFrame(GameView.class).withTimeout(5000).using(robot());
		gamePanel.requireVisible();
		gamePanel.target().setLocationRelativeTo(null);
		gamePanel.target().setVisible(true);
		gamePanel.resizeWidthTo(300);
		gamePanel.resizeHeightTo(600);
		gamePanel.show(); // shows the frame to test
		System.out.println(gamePanel.target().getClass().getName().toString());
		// success
		assertEquals(gamePanel.target().getClass().getName().toString(), "view.GameView");
		GuiActionRunner.execute(() -> gamePanel.button("stop").target().doClick());
		FrameFixture stopView = findFrame(StopView.class).withTimeout(5000).using(robot());
		stopView.requireVisible();
		stopView.target().setLocationRelativeTo(null);
		stopView.target().setVisible(true);
		GuiActionRunner.execute(() -> stopView.button("Continue").target().doClick());
		assertEquals(gamePanel.button("stop").target().isEnabled(), true);
		}

	// @Test
	// public void test() {
	// testMenu();
	// fail("Not yet implemented");
	// assertThat(objectToTest). // code completion -> assertions specific to
	// objectToTest

	// }
	@Override
	protected void onSetUp() {

	}

}
