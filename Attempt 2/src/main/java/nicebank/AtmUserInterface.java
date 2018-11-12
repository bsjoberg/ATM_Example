package nicebank;

import org.openqa.selenium.By;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import hooks.ServerHooks;

public class AtmUserInterface implements Teller {
	private final EventFiringWebDriver webDriver;
	
	public AtmUserInterface(EventFiringWebDriver driver) {
		this.webDriver = new EventFiringWebDriver(driver);
	}
	
	public boolean withdrawFrom(Account account, int dollars) {
		try {
			webDriver.get("http://localhost:" + ServerHooks.PORT);
			webDriver.findElement(By.id("amount"))
					.sendKeys(String.valueOf(dollars));
			webDriver.findElement(By.id("withdraw")).click();
		} finally {
			webDriver.close();
		}
		
		return false;
	}
	
	public String checkBalance(Account account) {
		try {
			webDriver.get("http://localhost:" + ServerHooks.PORT);
			webDriver.findElement(By.id("balance")).click();
		} finally {
			webDriver.close();
		}
		
		return null;
	}
}