package fun;

import org.junit.Assert;

import cucumber.api.PendingException;
import cucumber.api.Transform;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import transforms.MoneyConverter;

public class Steps {
	KnowsMyAccount helper;
	
	class KnowsMyAccount {
		private Account myAccount;
		private CashSlot cashSlot;
		
		public Account getMyAccount() {
			if (myAccount == null) {
				myAccount = new Account();
			}
			return myAccount;
		}
		
		public CashSlot getCashSlot() {
			if (cashSlot == null) {
				cashSlot = new CashSlot();
			}
			return cashSlot;
		}
	}
	
	class CashSlot {
		public int getContents() {
			return 0;
		}
	}
	
	class Account {
		private Money balance;
		
		Account() {
			balance = new Money();
		}
		

		public void deposit(Money amount) {
			balance = balance.add(amount);
		}
		
		public Money getBalance() {
			return balance;
		}
	}
	
	class Teller {
		public void withdrawFrom(Account account, int dollars) {
			
		}
	}
	
	public Steps() {
		helper = new KnowsMyAccount();
	}
	
	@Given("^I have deposited \\$(\\d+\\.\\d+) in my account$")
	public void iHaveDeposited$InMyAccount(@Transform(MoneyConverter.class)Money amount) throws Throwable {
	    helper.getMyAccount().deposit(amount);
	    
	    Assert.assertEquals("Incorrect Account Balance - ", amount, helper.getMyAccount().getBalance());
	}

	@When("^I withdraw \\$(\\d+)$")
	public void iWithdraw$(int amount) throws Throwable {
		Teller teller = new Teller();
		teller.withdrawFrom(helper.getMyAccount(), amount);
	}

	@Then("^\\$(\\d+) should be dispensed$")
	public void $ShouldBeDispensed(int dollars) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    Assert.assertEquals("Incorrect amount dispensed", dollars, helper.getCashSlot().getContents());
	}
}
