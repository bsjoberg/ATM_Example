package hooks;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class SomeTestHooks {
	@Before
	public void beforeCallingScenario() {
		System.out.println("*********** About to start scenairo.");
	}
	
	@After
	public void afterCallingScenario(Scenario scenario) {
		System.out.println("*********** Just finished running scenairo: " +
				scenario.getStatus());		
	}
}
