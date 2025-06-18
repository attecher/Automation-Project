package baseUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import genericUtility.File_Utility;
import genericUtility.webdriverUtil;
import generic_utility.FileUtility;
import pom.login;
import pom.logout;

public class baseClasss {
	protected WebDriver driver;
//	static WebDriver sdriver;
	SoftAssert sa = new SoftAssert();

	FileUtility fileutil;
	protected ExtentReports Report;
	ExtentTest test;
	
	public File_Utility fileUtil= new File_Utility();
	
	@BeforeSuite
	public void bs() {
		System.out.println("report config and db connection");
		
		ExtentSparkReporter spark=new ExtentSparkReporter("D:\\java qspider\\youknow\\AdvanceRepo\\Report.html");
		spark.config().setDocumentTitle("Opportunity Report");
		spark.config().setReportName("Draft");
		spark.config().setTheme(Theme.DARK);
		
		Report = new ExtentReports();
		Report.attachReporter(spark);
		Report.setSystemInfo("windows", "11");
		Report.setSystemInfo("date", "78 - June - 1999");
		
	}
	@BeforeTest
	public void bt() {
		test = Report.createTest("before test");
		Reporter.log("pre condition",true);
		test.log(Status.INFO, "Before test executed successfully");
		
	}
	@BeforeClass
	public void browserOpen() throws IOException {
		System.out.println("-----opening browser------");
		String BROWSER = fileUtil.getDataFromProp("bro");

		switch (BROWSER.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		default:
			System.out.println("Invalid browser specified. Defaulting to Chrome.");
			driver = new ChromeDriver();
			break;
		}
		
		webdriverUtil webUtil = new webdriverUtil(driver);
//		sdriver = driver;
		webUtil.maximizeWindow();
		webUtil.implicitWait();
		driver.get("http://49.249.28.218:8888/");
		
		test=Report.createTest("before class");
		test.log(Status.PASS, "before class pass");
		
	}
	@BeforeMethod
	public void login() {
		login l=new pom.login(driver);
		l.getUn().sendKeys("admin");
		l.getPass().sendKeys("admin");
		l.getBtn().click();
		System.out.println("logged in");
		
		test = Report.createTest("before method");
		test.log(Status.PASS, "before method pass");
		
	}
	
	//test method run hoga
	
	@AfterMethod
	public void logout() {
		Actions act=new Actions(driver);
		logout out= new pom.logout(driver);
		act.moveToElement(out.getProfile()).perform();
		out.getSignout().click();
		System.out.println("logged out");
		
		test=Report.createTest("after method");
		test.log(Status.PASS, "after method pass");
		
	}
	@AfterClass
	public void closingBrowser() {
		System.out.println("successful execution");
		driver.quit();
		sa.assertAll();
		
		test=Report.createTest("after class");
		test.log(Status.PASS, "after class pass");
		
	}
	@AfterTest
	public void at() {
		System.out.println("post condition");
		
		test=Report.createTest("after test");
		test.log(Status.PASS, "after test pass");
		
	}
	@AfterSuite
	public void as() {
		Report.flush();
		System.out.println("db close and report backup");
		
		test=Report.createTest("after suite");
		test.log(Status.PASS, "after suite pass");
		
	}

}
