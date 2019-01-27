package support;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import nicebank.Account;
import nicebank.AtmUserInterface;
import nicebank.CashSlot;
import nicebank.Teller;

public class KnowsTheDomain {
		private Account myAccount;
		private CashSlot cashSlot;
		private Teller teller;
		private EventFiringWebDriver webDriver;
		
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
		
		public Teller getTeller() {
			if (teller == null) {
				teller = new AtmUserInterface();
			}
			return teller;
		}
		
		public EventFiringWebDriver getWebDriver() {
	        if (webDriver == null){
	        	System.setProperty("webdriver.chrome.driver", "C:\\Users\\brian\\Documents\\workspace\\chromedriver_win32\\chromedriver.exe");
	        	webDriver = new EventFiringWebDriver(new ChromeDriver());
	        }

	        return webDriver;
	    }
	}
