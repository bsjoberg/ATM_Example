package nicebank;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import hooks.ServerHooks;

public class AtmUserInterface implements Teller {

	private final EventFiringWebDriver webDriver;
	
	public AtmUserInterface() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\brian\\Documents\\workspace\\chromedriver_win32\\chromedriver.exe");
		this.webDriver = new EventFiringWebDriver(new ChromeDriver());
	}
	
	public void withdrawFrom(Account account, int dollars) {
		try {
			webDriver.get("http://localhost:" + ServerHooks.PORT);
			webDriver.findElement(By.id("amount"))
				.sendKeys(String.valueOf(dollars));
			webDriver.findElement(By.id("withdraw")).click();
		}
		finally {
			webDriver.close();
		}
	}

}
