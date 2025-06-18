package MITM;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pom.login;
import pom.logout;
import pom.oppo;

public class withTestNG {
	
	@Parameters("browser")
	@Test
	public void working() {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
	driver.get("http://49.249.28.218:8888/");

	
	login l=new pom.login(driver);
	l.getUn().sendKeys("admin");
	l.getPass().sendKeys("admin");
	l.getBtn().click();
	
	
	//kaam

	
	oppo oopoWork=new pom.oppo(driver);
	oopoWork.getOpportunities().click();
	oopoWork.getCreateOppor().click();
	String name= "bun"+(int)(Math.random()*1000);
	oopoWork.getOpporName().sendKeys(name);
	oopoWork.getRelatedTo().click();
	
	String parent1=driver.getWindowHandle();
	Set<String> child=driver.getWindowHandles();
	
	for(String i: child ) {
		driver.switchTo().window(i);
		
	}
	WebElement orgName=oopoWork.getRelatedToOrgName();
	String confOrgName= orgName.getText();
	orgName.click();
	
	driver.switchTo().window(parent1);
	oopoWork.getSave().click();
	
	
	//verify

	WebElement ele=oopoWork.getVerifyOpporName();
	String namwa=ele.getText();
	WebElement ele2=oopoWork.getVerifyOrgName();
	String conf=ele2.getText();
	if(namwa.contains(name)&&conf.contains(confOrgName)) {
		System.out.println("pass");
	}
	else {
		System.out.println("fail");
	}
	

	//logout

	
	Actions act=new Actions(driver);
	logout out= new pom.logout(driver);
	act.moveToElement(out.getProfile()).perform();
	out.getSignout().click();
	driver.quit();
	
	
}

}
