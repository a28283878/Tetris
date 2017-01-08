import static org.junit.Assert.*;

import javax.swing.JFrame;

import org.assertj.swing.core.BasicComponentFinder;
import org.assertj.swing.core.ComponentFinder;
import org.assertj.swing.core.GenericTypeMatcher;
import org.assertj.swing.edt.GuiActionRunner;
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
import view.TetrisPanel;
import view.tetris;

import static org.assertj.swing.core.matcher.JButtonMatcher.withText;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.swing.launcher.ApplicationLauncher.application;
import static org.assertj.swing.finder.WindowFinder.findFrame;
public class testAll extends AssertJSwingJUnitTestCase{
	private FrameFixture window;
	@Test
	public void testMenu() {
//		http://joel-costigliola.github.io/assertj/assertj-swing-basics.html
//		http://joel-costigliola.github.io/assertj/assertj-swing-lookup.html
//		http://joel-costigliola.github.io/assertj/assertj-swing-input.html
//		assert function can read
//	    https://objectpartners.com/2013/09/18/the-benefits-of-using-assertthat-over-other-assert-methods-in-unit-tests/
		System.out.println(window.button("Start").target().getText().toString());

//	    assertJRobot.cleanUpWithoutDisposingWindows();
//	    GuiActionRunner.execute(() -> window.button("Start").click());
	    GuiActionRunner.execute(() -> window.button("Start").target().doClick());

	    FrameFixture gamePanel = findFrame(GameView.class).withTimeout(5000).using(robot());
		gamePanel.requireVisible();

		//		FrameFixture gamePanel2 = findFrame(TetrisPanel.class).withTimeout(5000).using(robot());
//		FrameFixture gamePanel = findFrame(tetris.class).withTimeout(5000).using(robot());

		gamePanel.target().setLocationRelativeTo(null);
		gamePanel.target().setVisible(true);
		gamePanel.resizeWidthTo(300);
		gamePanel.resizeHeightTo(600);
		gamePanel.show(); // shows the frame to test
	    System.out.println(gamePanel.target().getClass().getName().toString());
	    //success
		assertEquals(gamePanel.target().getClass().getName().toString(), "view.GameView");
	    //failed
		assertEquals(gamePanel.target().getClass().getName().toString(), "view.GameView123");

	}
//	@Test
//	public void test() {
//		testMenu();
//		fail("Not yet implemented");
//		assertThat(objectToTest). // code completion -> assertions specific to objectToTest
		 
//	}
	@Override
	protected void onSetUp() {
//		MainController
//		MainController MC = new MainController();
//    	MC.Menu();
		MenuView frame = GuiActionRunner.execute(() -> MainController.Menu);
//		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	    window = new FrameFixture(robot(), frame);
//	    window.requireVisible();
		window.resizeWidthTo(300);
		window.resizeHeightTo(600);
	    window.show(); // shows the frame to test
	}
	

}
