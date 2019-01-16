package nicebank;

import org.junit.Assert;

import cucumber.api.Transform;
import cucumber.api.java.en.Given;
import support.KnowsTheDomain;
import transforms.MoneyConverter;

public class AccountSteps {
	KnowsTheDomain helper;
	
	public AccountSteps(KnowsTheDomain helper) {
		this.helper = helper;
	}
	
	@Given("^I have deposited \\$(\\d+\\.\\d+) in my account$")
	public void iHaveDeposited$InMyAccount(@Transform(MoneyConverter.class)Money amount) throws Throwable {
	    helper.getMyAccount().deposit(amount);
	    
	    Assert.assertEquals("Incorrect Account Balance - ", amount, helper.getMyAccount().getBalance());
	}
}
