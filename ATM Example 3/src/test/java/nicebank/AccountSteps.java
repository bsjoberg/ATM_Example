package nicebank;

import org.junit.Assert;

import cucumber.api.Transform;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import support.KnowsTheDomain;
import transforms.MoneyConverter;

public class AccountSteps {
	KnowsTheDomain helper;
	
	public AccountSteps(KnowsTheDomain helper) {
		this.helper = helper;
	}
	
	@Given("^my acccount has been credited with \\$(\\d+\\.\\d+)$")
	public void myAcccountHasBeenCreditedWith$(@Transform(MoneyConverter.class)Money amount) throws Throwable {
	    helper.getMyAccount().credit(amount);
	    
	    Assert.assertEquals("Incorrect Account Balance - ", amount, helper.getMyAccount().getBalance());
	}
	
	@Then("^the balance of my account should be \\$(\\d+\\.\\d+)$")
	public void theBalanceOfMyAccountShouldBe$(@Transform(MoneyConverter.class)Money amount) throws Throwable {
		Assert.assertEquals("Incorrect Account Balance - ", amount, helper.getMyAccount().getBalance());
	}
}
