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
	}
	
	@Then("^the balance of my account should be \\$(\\d+\\.\\d+)$")
	public void theBalanceOfMyAccountShouldBe$(@Transform(MoneyConverter.class)Money amount) throws Throwable {
        int timeoutMilliSecs = 3000;
        int pollIntervalMilliSecs = 100;

        while (!helper.getMyAccount().getBalance().equals(amount) 
                                                    && timeoutMilliSecs > 0){
            Thread.sleep(pollIntervalMilliSecs);
            timeoutMilliSecs -= pollIntervalMilliSecs;
        }

        Assert.assertEquals(
                "Incorrect account balance -",
                amount,
                helper.getMyAccount().getBalance());
	}
}
