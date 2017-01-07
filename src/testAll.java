import static org.junit.Assert.*;

import org.assertj.swing.core.BasicComponentFinder;
import org.assertj.swing.core.ComponentFinder;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.finder.WindowFinder;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.junit.testcase.AssertJSwingJUnitTestCase;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

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
	public void testMenu() {
//		http://joel-costigliola.github.io/assertj/assertj-swing-basics.html
//		http://joel-costigliola.github.io/assertj/assertj-swing-lookup.html
		
		MenuView frame = GuiActionRunner.execute(() -> new MenuView());
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	    window = new FrameFixture(robot(), frame);
		window.resizeWidthTo(300);
		window.resizeHeightTo(600);
	    window.show(); // shows the frame to test
//	    assertJRobot.cleanUpWithoutDisposingWindows();
//	    GuiActionRunner.execute(() -> window.button("Start").click());
	    robot().click(window.button("Start").target());

//		window.button("Start").doubleClick();
//		window.resizeWidthTo(300);
//		window.resizeHeightTo(600);
//	    window.show(); // shows the frame to test
//		robot().finder().findByName("GameViewPanel", true);
//		FrameFixture gamePanel = robot().finder().findByName("GameView");
//		FrameFixture gamePanel = findFrame(GameView.class).withTimeout(5000).using(robot());
//		FrameFixture gamePanel2 = findFrame(TetrisPanel.class).withTimeout(5000).using(robot());
		FrameFixture gamePanel = findFrame(tetris.class).withTimeout(5000).using(robot());

		gamePanel.target().setLocationRelativeTo(null);
		gamePanel.target().setVisible(true);
		gamePanel.resizeWidthTo(300);
		gamePanel.resizeHeightTo(600);
		gamePanel.show(); // shows the frame to test
		gamePanel.button("Start").click();
//		window.target().setLocationRelativeTo(null);
//		window.target().setVisible(true);
//		window.resizeWidthTo(300);
//		window.resizeHeightTo(600);
//	    window.show(); // shows the frame to test
//		window.button("Start").click();

//		FrameFixture gamePanel = WindowFinder.findFrame("GameViewPanel").withTimeout(3000).using(robot());
//		gamePanel.label("GV_Title").requireText("Tetris Game");
//		window.resizeWidthTo(300);
//		window.resizeHeightTo(600);
	}
	@Test
	public void test() {
		testMenu();
//		fail("Not yet implemented");
//		assertThat(objectToTest). // code completion -> assertions specific to objectToTest

	}
	@Override
	protected void onSetUp() {
		
		
		
	}
	

}
