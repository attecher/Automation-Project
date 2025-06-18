package MITM;

import java.time.Duration;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import pom.login;
import pom.logout;
import pom.oppo;


public class practiceOpp {
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
		driver.get("http://49.249.28.218:8888/");
		
//		driver.findElement(By.name("user_name")).sendKeys("admin");
//		driver.findElement(By.name("user_password")).sendKeys("admin");
//		driver.findElement(By.id("submitButton")).click();
		
		login l=new pom.login(driver);
		l.getUn().sendKeys("admin");
		l.getPass().sendKeys("admin");
		l.getBtn().click();
		
		
		//kaam
		
//		driver.findElement(By.linkText("Opportunities")).click();
//		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
//		String name= "bun"+(int)Math.random()*1000;
//		driver.findElement(By.name("potentialname")).sendKeys(name);
//		
//		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/select.gif\"]")).click();
//		
//		String parent1=driver.getWindowHandle();
//		Set<String> child=driver.getWindowHandles();
//		
//		for(String i: child ) {
//			driver.switchTo().window(i);
//			
//		}
//		
//		System.out.println(parent1);
//		System.out.println(child);
//		WebElement orgname=driver.findElement(By.id("4"));
//		String conforgname= orgname.getText();
//		orgname.click();
//
//		driver.switchTo().window(parent1);
//		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
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
		
//		WebElement ele=driver.findElement(By.id("dtlview_Opportunity Name"));
//		String namwa=ele.getText();
//		WebElement ele2 =driver.findElement(By.cssSelector("a[title=\"Organizations\"]"));
//		String conf=ele2.getText();
//		if(namwa.contains(name)&&conf.contains(conforgname)) {
//			System.out.println("pass");
//		}
//		else {
//			System.out.println("fail");
//		}
		
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
		
		
		
	
//		
		//logout
//		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
//		Actions act=new Actions(driver);
//		act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
//		driver.findElement(By.linkText("Sign Out"));
//		driver.quit();
		
		Actions act=new Actions(driver);
		logout out= new pom.logout(driver);
		act.moveToElement(out.getProfile()).perform();
		out.getSignout().click();
		driver.quit();
		
		
	}


}
