import static org.junit.Assert.*;

import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.junit.testcase.AssertJSwingJUnitTestCase;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import view.MenuView;
import static org.assertj.swing.core.matcher.JButtonMatcher.withText;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.swing.launcher.ApplicationLauncher.application;
import static org.assertj.swing.finder.WindowFinder.findFrame;
public class testAll extends AssertJSwingJUnitTestCase{
	private FrameFixture window;
	public void testMenu() {
		MenuView frame = GuiActionRunner.execute(() -> new MenuView());
	    // IMPORTANT: note the call to 'robot()'
	    // we must use the Robot from AssertJSwingJUnitTestCase
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	    window = new FrameFixture(robot(), frame);
		window.resizeWidthTo(300);
		window.resizeHeightTo(600);
	    window.show(); // shows the frame to test
//	    assertJRobot.cleanUpWithoutDisposingWindows();

//		window.textBox("Title").setText("123");
		window.button("Start").click();
		window.resizeWidthTo(300);
		window.resizeHeightTo(600);
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
