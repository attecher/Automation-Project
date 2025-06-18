package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class login {
	WebDriver driver;

	public login(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(name = "user_name")
	private WebElement un;

	@FindBy(name = "user_password")
	private WebElement pass;

	@FindBy(id = "submitButton")
	private WebElement btn;
	

	public WebElement getUn() {
		return un;
	}

	public WebElement getPass() {
		return pass;
	}

	public WebElement getBtn() {
		return btn;
	}
}
