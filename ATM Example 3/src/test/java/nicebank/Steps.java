package nicebank;

import org.junit.Assert;

import cucumber.api.Transform;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import nicebank.Money;
import support.KnowsTheDomain;
import transforms.MoneyConverter;

public class Steps {
	KnowsTheDomain helper;
	
	public Steps() {
		helper = new KnowsTheDomain();
	}
	
	@Given("^I have deposited \\$(\\d+\\.\\d+) in my account$")
	public void iHaveDeposited$InMyAccount(@Transform(MoneyConverter.class)Money amount) throws Throwable {
	    helper.getMyAccount().deposit(amount);
	    
	    Assert.assertEquals("Incorrect Account Balance - ", amount, helper.getMyAccount().getBalance());
	}

	@When("^I withdraw \\$(\\d+)$")
	public void iWithdraw$(int amount) throws Throwable {
		helper.getTeller().withdrawFrom(helper.getMyAccount(), amount);
	}

	@Then("^\\$(\\d+) should be dispensed$")
	public void $ShouldBeDispensed(int dollars) throws Throwable {
	    Assert.assertEquals("Incorrect amount dispensed", dollars, helper.getCashSlot().getContents());
	}
}
