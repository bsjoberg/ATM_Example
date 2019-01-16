package nicebank;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class AtmUserInterface implements Teller {

	private final EventFiringWebDriver webDriver;
	
	public AtmUserInterface() {
		this.webDriver = new EventFiringWebDriver(new ChromeDriver());
	}
	
	public void withdrawFrom(Account account, int dollars) {
		// TODO Auto-generated method stub
		
	}

}
