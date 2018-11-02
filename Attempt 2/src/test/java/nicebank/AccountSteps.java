package nicebank;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import support.KnowsTheDomain;

public class AccountSteps {
	KnowsTheDomain helper;
	
	public AccountSteps() {
		helper = new KnowsTheDomain();
	}
	
	@Given("^I have deposited (\\$\\d+\\.\\d+) in my account$")
	public void iHaveDeposited$InMyAccount(Money amount) throws Throwable {
	    helper.getMyAccount().deposit(amount);
	    
	    Assert.assertEquals("Incorrect account balance - ", amount, helper.getMyAccount().getBalance());
	}
}
