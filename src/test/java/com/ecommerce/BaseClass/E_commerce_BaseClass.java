package com.ecommerce.BaseClass;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.ecommerce.Utilities.E_commerce_ReadConfig;

public class E_commerce_BaseClass {

	public static WebDriver driver;
	public static Logger logger;
	E_commerce_ReadConfig config=new E_commerce_ReadConfig();
	public String appUrl=config.getApplicationUrl();
	public String chromeLocation=config.getBrowserLocation();

	@Parameters("browser")
	@BeforeMethod
	public void setUp(@Optional("brow")String browser) {
		logger=Logger.getLogger(E_commerce_BaseClass.class);
		PropertyConfigurator.configure("log4j.properties");
		logger.info("Browser Ready To Launch");
		switch (browser) {
		case "CHROME":
			System.setProperty("webdriver.chrome.driver",chromeLocation);
			driver=new ChromeDriver();
			break;
		default:
			System.setProperty("webdriver.chrome.driver",chromeLocation);
			driver=new ChromeDriver();
			break;
		}
		logger.info("Chrome Browser Launched");
		logger.info("Browser Maximized");
		implicitMethod();
		maximizeBrowser();
		logger.info("Browser Going To Hit Url");
		navigateUrl();
		logger.info("URL Hit Success");
	}
	public void implicitMethod() {
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}
	public void maximizeBrowser() {
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	}
	public void type(WebElement webelement,String value) {
		webelement.sendKeys(value);
	}
	public void btnClick(WebElement webelement) {
		webelement.click();
	}
	public String getTitle() {
		String title=driver.getTitle();
		return title;
	}
	public String getCurrentUrl() {
		String currenturl=driver.getCurrentUrl();
		return currenturl;
	}
	public String getPageSource() {
		String pagesource=driver.getPageSource();
		return pagesource;
	}
	public void selectByVisibleText(WebElement web,String text) {
		Select select=new Select(web);
		select.selectByVisibleText(text);
	}
	public void selectByValue(WebElement web,String value) {
		Select select=new Select(web);
		select.selectByValue(value);
	}
	public void selectByIndex(WebElement web,int num) {
		Select select=new Select(web);
		select.selectByIndex(num);
	}
	public void moveToElement(WebElement web) {
		Actions action=new Actions(driver);
		action.moveToElement(web).click().build().perform();
	}
	public void dragToElement(WebElement web1,WebElement web2) {
		Actions action=new Actions(driver);
		action.dragAndDrop(web1, web2);
	}
	public String randomNumeric(int num) {
		String randomnumeric=RandomStringUtils.randomNumeric(num);
		return randomnumeric;
	}
	public void alertAccept() {
		Alert alert=driver.switchTo().alert();
		alert.accept();
	}
	public void alertDismiss() {
		Alert alert=driver.switchTo().alert();
		alert.dismiss();
	}
	public void alertSendkeys(String value) {
		Alert alert=driver.switchTo().alert();
		alert.sendKeys(value);
	}
	public String getWindowhandle() {
		String window=driver.getWindowHandle();
		return window;
	}
	public Set<String> getWindowhandles() {
		Set<String> windows=driver.getWindowHandles();
		return windows;
	}
	public void defaultContent() {
		driver.switchTo().defaultContent();
	}
	public void webdriverClickWait(WebElement web) {
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(web));
	}
	public boolean webdriverVisibleWait(WebElement web) {
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(web));
		return true;
	}
	public void webdriverAlertWait() {
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.alertIsPresent());
	}
	public void fluentClickWait(WebDriver driver,WebElement web) {
		FluentWait<WebDriver> wait=new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofSeconds(1)).ignoring(Throwable.class);
		wait.until(ExpectedConditions.elementToBeClickable(web));
	}
	public void fluentAlertWait(WebDriver driver) {
		FluentWait<WebDriver> wait=new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofSeconds(1)).ignoring(Throwable.class);
		wait.until(ExpectedConditions.alertIsPresent());
	}
	public boolean webelementSelected(WebElement webelement) {
		boolean value=webelement.isSelected();
		return value;
	}
	public boolean webelementDisplayed(WebElement webelement) {
		boolean value=webelement.isDisplayed();
		return value;
	}
	public boolean webelementEnabled(WebElement webelement) {
		boolean value=webelement.isEnabled();
		return value;
	}
	public void navigateUrl() {
		driver.navigate().to(appUrl);
	}
	public void captureScreenshot1(WebDriver driver,String testname) {
		String timestamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File target=new File(System.getProperty("user.dir")+"/Screenshot Passed/"+timestamp+" "+testname+".png");
		try {
			FileUtils.copyFile(source, target);
		} catch (IOException e) {
			e.printStackTrace();
		}
		logger.info("Passed Screenshot Captured Success");
	}
	public void captureScreenshot2(WebDriver driver,String testname) {
		Robot robot = null;
		try {
			robot=new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}Dimension size=Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle rec=new Rectangle(size);
		BufferedImage source=robot.createScreenCapture(rec);
		File target=new File(System.getProperty("user.dir")+"/Screenshot Failed/"+testname+".png");
		try {
			ImageIO.write(source,"png",target);
		} catch (IOException e) {
			e.printStackTrace();
		}
		logger.info("Failed Screenshot Captured Success");
	}
	@AfterMethod
	public void tearDown() throws InterruptedException {
		driver.quit();
		logger.info("Browser Closed Successfully");
	}


}
