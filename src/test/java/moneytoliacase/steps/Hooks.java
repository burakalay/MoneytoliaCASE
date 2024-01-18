package moneytoliacase.steps;



import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import moneytoliacase.testbase.BaseClass;
import moneytoliacase.utils.CommonMethods;

public class Hooks {
	
	@Before
	public void start() throws InterruptedException {
		BaseClass.setUp();
		
		
	}
	@After
	public void end(Scenario scenario) {
		
		
byte[] picture;
		
		if (scenario.isFailed()) {
			// store the screenshot in the failed folder
			picture = CommonMethods.takeScreenshot("failed/" + scenario.getName());		
		} else {
			// store the screenshot in the passed folder
			picture = CommonMethods.takeScreenshot("passed/" + scenario.getName());
		}
		
		scenario.attach(picture, "image/png", scenario.getName());

		BaseClass.tearDown();
		
	}
	
	

}
