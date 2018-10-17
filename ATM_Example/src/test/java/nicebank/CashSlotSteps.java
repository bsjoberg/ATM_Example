package nicebank;

import static org.junit.Assert.assertEquals;

import cucumber.api.java.en.Then;
import support.KnowsTheDomain;

public class CashSlotSteps {
	KnowsTheDomain helper;
	
	public CashSlotSteps(KnowsTheDomain helper) {
		this.helper = helper;
	}

	@Then("^\\$(\\d+) should be dispensed$")
	public void $ShouldBeDispensed(int dollars) throws Throwable {
	    assertEquals("Incorrect amount dispensed - ", dollars, helper.getCashSlot().getContents());
	}
	
	@Then("^nothing should be dispensed$")
	public void nothingShouldBeDispensed() throws Throwable {
	    assertEquals("Incorrect amount dispensed - ", 0, helper.getCashSlot().getContents());
	}
}
