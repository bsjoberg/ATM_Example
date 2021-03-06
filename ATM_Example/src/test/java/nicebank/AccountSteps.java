package nicebank;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import support.KnowsTheDomain;

public class AccountSteps {
	KnowsTheDomain helper;
	
	public AccountSteps(KnowsTheDomain helper) {
		this.helper = helper;
	}
	
	@Given("^my account has been credited with (\\$\\d+\\.\\d+)$")
	public void iHaveDeposited$InMyAccount(Money amount) throws Throwable {
	    helper.getMyAccount().credit(amount);
	}
	
	@Then("^the balance of my account should be (\\$\\d+\\.\\d+)$")
	public void theBalanceOfMyAccountShouldBe$(Money balance) throws Throwable {
		int timeoutMilliSecs = 3000;
		int pollIntervalMilliSecs = 100;
		
		while (!helper.getMyAccount().getBalance().equals(balance) && timeoutMilliSecs > 0) {
			try {
				Thread.sleep(pollIntervalMilliSecs);
				timeoutMilliSecs -= pollIntervalMilliSecs;
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}
		
		Assert.assertEquals("Incorrect Account Balance - ", balance, helper.getMyAccount().getBalance());
	}
	
	@Then("^I should be told that I have insufficient funds$")
	public void iShouldBeToldThatIHaveInsufficientFunds() throws Throwable {
	    Assert.assertFalse(helper.getMyAccount().hasSufficientFunds());
	}
}
