package MITM;

import java.util.Set;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import baseUtility.baseClasss;
import genericUtility.webdriverUtil;
import pom.oppo;

public class withBaseClass extends baseClasss {

	@Parameters("browser")
	@Test
	public void working() {
		
	
		webdriverUtil webUtil = new webdriverUtil(driver);

		// kaam
		ExtentTest test = Report.createTest("test script");

		oppo oopoWork = new pom.oppo(driver);
		oopoWork.getOpportunities().click();
		oopoWork.getCreateOppor().click();
		String name = "bun" + webUtil.randomNum();
		oopoWork.getOpporName().sendKeys(name);
		oopoWork.getRelatedTo().click();

		
		String parent1 = driver.getWindowHandle();
		
		Set<String> child = driver.getWindowHandles();

		for (String i : child) {
			driver.switchTo().window(i);

		}
		WebElement orgName = oopoWork.getRelatedToOrgName();
		String confOrgName = orgName.getText();
		orgName.click();

		driver.switchTo().window(parent1);
		oopoWork.getSave().click();
		
		
		

		// verify

		WebElement ele = oopoWork.getVerifyOpporName();
		String namwa = ele.getText();
		WebElement ele2 = oopoWork.getVerifyOrgName();
		String conf = ele2.getText();
//		if (namwa.contains(name) && conf.contains(confOrgName)) {
//			System.out.println("pass");
//		} else {
//			System.out.println("fail");
//		}
		
//		SoftAssert sa=new SoftAssert();
//		sa.assertEquals(namwa, name);
//		System.out.println("pass");
//		sa.assertNotEquals(conf,confOrgName);
//		System.out.println("fail");
		Assert.assertEquals(namwa, name);
		System.out.println("pass");
		Assert.assertNotEquals(conf,confOrgName);
		System.out.println("fail");
		

		test.log(Status.PASS, "This test script pass");

	}

}
