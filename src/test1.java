
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
import org.assertj.swing.timing.Pause;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import controller.MainController;
import view.GameView;
import view.MenuView;
import view.SettingView;
import view.StopView;
import view.TetrisPanel;
import view.tetris;

import static org.assertj.swing.core.matcher.JButtonMatcher.withText;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.swing.launcher.ApplicationLauncher.application;
import static org.assertj.swing.finder.WindowFinder.findFrame;

public class test1 extends AssertJSwingJUnitTestCase {
	// http://joel-costigliola.github.io/assertj/assertj-swing-basics.html
	// http://joel-costigliola.github.io/assertj/assertj-swing-lookup.html
	// http://joel-costigliola.github.io/assertj/assertj-swing-input.html
	// assert function can read
	// https://objectpartners.com/2013/09/18/the-benefits-of-using-assertthat-over-other-assert-methods-in-unit-tests/

	private FrameFixture window;

	@Test
	public void test1_Setting_difficult() {
		MenuView frame = GuiActionRunner.execute(() -> new MenuView());
		// frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		window = new FrameFixture(robot(), frame);
		// window.requireVisible();
		window.resizeWidthTo(300);
		window.resizeHeightTo(600);
		window.show(); // shows the frame to test
		GuiActionRunner.execute(() -> window.button("Setting").target().doClick());
		FrameFixture settingView = findFrame(SettingView.class).withTimeout(5000).using(robot());
		settingView.requireVisible();
		settingView.target().setLocationRelativeTo(null);
		settingView.target().setVisible(true);
		settingView.resizeWidthTo(300);
		settingView.resizeHeightTo(600);
		settingView.show(); // shows the frame to test
		GuiActionRunner.execute(() -> settingView.textBox("Difficulty").target().setText("5"));
		//Pause.pause(5000);
		GuiActionRunner.execute(() -> settingView.button("Send").target().doClick());
		assertEquals(MainController.gamesetting.difficulty, 5);

	}

	@Override
	protected void onSetUp() {

	}

}
