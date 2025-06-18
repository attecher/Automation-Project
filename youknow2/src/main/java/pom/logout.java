package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class logout {
	WebDriver driver;

	public logout(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement profile;

	@FindBy(linkText = "Sign Out")
	private WebElement signout;

	public WebElement getProfile() {
		return profile;
	}

	public WebElement getSignout() {
		return signout;
	}

}
