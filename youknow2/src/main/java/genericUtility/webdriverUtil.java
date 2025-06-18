package genericUtility;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class webdriverUtil {
	WebDriver driver;
	Actions act;
	
	public webdriverUtil(WebDriver driver) {
		this.driver=driver;
	}

	public void maximizeWindow() {
		driver.manage().window().maximize();
	}

	public void implicitWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

	public int randomNum() {
		return ((int) (Math.random() * 10000));
	}

	public void switchWindow(String url) {
		Set<String> child = driver.getWindowHandles();
		for (String i : child) {
			driver.switchTo().window(i);
			if (driver.getCurrentUrl().contains(url)) {
				break;
			}

		}
	}
	
	public void moveMouse(WebElement ele) {
		new Actions(driver);
		act.moveToElement(ele).build().perform();
	}
	
}
