package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class oppo {

	WebDriver driver;

	public oppo(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Opportunities")
	private WebElement Opportunities;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createOppor;
	
	@FindBy(name = "potentialname")
	private WebElement opporName;
	
	@FindBy(xpath = "//img[@src=\"themes/softed/images/select.gif\"]")
	private WebElement relatedTo;
	@FindBy(id = "4")
	private WebElement relatedToOrgName;
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement save;
	
	//verify
	@FindBy(id = "dtlview_Opportunity Name")
	private WebElement verifyOpporName;
	@FindBy(css = "a[title=\"Organizations\"]")
	private WebElement verifyOrgName;

	public WebElement getOpportunities() {
		return Opportunities;
	}
	public WebElement getCreateOppor() {
		return createOppor;
	}
	public WebElement getOpporName() {
		return opporName;
	}
	public WebElement getRelatedTo() {
		return relatedTo;
	}
	public WebElement getRelatedToOrgName() {
		return relatedToOrgName;
	}
	public WebElement getSave() {
		return save;
	}
	public WebElement getVerifyOpporName() {
		return verifyOpporName;
	}
	public WebElement getVerifyOrgName() {
		return verifyOrgName;
	}
	

}
