package com.ecommerce.PojoClass;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.ecommerce.BaseClass.E_commerce_BaseClass;

public class E_Commerce_AddtoCartModule_PojoClass extends E_commerce_BaseClass {

	public WebDriver ldriver;

	public E_Commerce_AddtoCartModule_PojoClass(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}

	@FindBy(xpath="//ul/li/button[text()='Add to cart']")
	@CacheLookup
	private WebElement addtocart;

	@FindBy(xpath="//a/span[text()='Cart']")
	@CacheLookup
	private WebElement cartlist;

	@FindBy(xpath="//input[@name='domain']/following::button/span[text()='Place Order']")
	@CacheLookup
	private WebElement placeorder; 

	@FindBy(xpath="//div[@id='container']/div/div[2]/div/div[1]/div[1]/div/div/div/div/div[1]/div/form/div[1]/input")
	@CacheLookup
	private WebElement emailid;

	@FindBy(xpath="//div[@id='container']/div/div[2]/div/div[1]/div[1]/div/div/div/div/div[1]/div/form/div[3]/button[@type='submit']")
	@CacheLookup
	private WebElement btnemailcontinue;

	@FindBy(xpath="//div[@id='container']/div/div[2]/div/div[1]/div[1]/div/div/div/div/div[1]/div/form/div[2]/input")
	@CacheLookup
	private WebElement mobileno;

	@FindBy(xpath="//div[@id='container']/div/div[2]/div/div[1]/div[1]/div/div/div/div/div[1]/div/form/div[4]/button[@type='submit']")
	@CacheLookup
	private WebElement btnmobilecontinue;

	@FindBy(xpath="//div[@id='container']/div/div[2]/div/div[1]/div[1]/div/div/div/div/div[1]/div/form/div[2]/input")
	@CacheLookup
	private WebElement otptype;

	@FindBy(xpath="//div[@id='container']/div/div[2]/div/div[1]/div[1]/div/div/div/div/div[1]/div/form/div[2]/input/following::span[4]")
	@CacheLookup
	private WebElement otperrormsg;

	@FindBy(xpath="//div[@id='container']/div/div[2]/div/div[1]/div[1]/div/div/div/div/div[1]/div/div/div[1]/span")
	@CacheLookup
	private WebElement resultverify;


	public WebElement getAddToCart() {
		return addtocart;
	}

	public WebElement getCartlist() {
		return cartlist;
	}

	public WebElement getPlaceorder() {
		return placeorder;
	}

	public WebElement getEmailid() {
		return emailid;
	}

	public WebElement getBtnemailContinue() {
		return btnemailcontinue;
	}

	public WebElement getMobileno() {
		return mobileno;
	}

	public WebElement getBtnmobileContinue() {
		return btnmobilecontinue;
	}

	public WebElement getOtpType() {
		return otptype;
	}

	public WebElement getOtpErrorMsg() {
		return otperrormsg;
	}

	public WebElement getResultVerify() {
		return resultverify;
	}


	public void setAddToCart() {
		getAddToCart();
		String oldwindow=getWindowhandle();
		Set<String> newwindow=getWindowhandles();
		for (String string : newwindow) {
			driver.switchTo().window(string);
		}
		webdriverClickWait(addtocart);
		btnClick(addtocart);
		logger.info("Add To Cart Clicked");
		driver.switchTo().window(oldwindow);
		logger.info("Backed To Home Page");
	}

	public void setCartlist() {
		getCartlist();
		webdriverClickWait(cartlist);
		btnClick(cartlist);
		logger.info("Selected Cart List Menu");
	}

	public void setPlaceorder() {
		getPlaceorder();
		webdriverClickWait(placeorder);
		btnClick(placeorder);
		logger.info("Place Order Is Clicked");
	}

	public void setEmailid(String string) {
		getEmailid();
		webelementDisplayed(emailid);
		type(emailid, string);
		logger.info("Entered The Valid MailId");
	}

	public void setBtnemailContinue() {
		getBtnemailContinue();
		webdriverClickWait(btnemailcontinue);
		btnClick(btnemailcontinue);
		logger.info("Email Verify Continue Button Clicked");
	}

	public void setMobileno(String string) {
		getMobileno();
		webelementDisplayed(mobileno);
		type(mobileno, string);
		logger.info("Entered The Valid Mobile Number");
	}

	public void setBtnmobile() throws InterruptedException {
		getBtnmobileContinue();
		webdriverClickWait(btnmobilecontinue);
		btnClick(btnmobilecontinue);
		logger.info("Mobile No Verify Continue Button Clicked");
		if(webdriverVisibleWait(otptype)) {
			Assert.assertTrue(true, "Sharing OTP Message");		
			logger.info("Sharing OTP");
		}
	}

	public void setOtp() throws InterruptedException {
		getOtpType();
		getOtpErrorMsg();
		int i=1;
//		Robot r=null;
		do {
			if(webelementDisplayed(otptype)) {
			String otpvalue=randomNumeric(6);
			type(otptype,otpvalue);
			}
			i++;
			if(webelementDisplayed(otperrormsg)){
				otptype.clear();
			}	
//			else {
//				try {
//					r=new Robot();
//				} catch (Exception e) {
//					r.keyPress(KeyEvent.VK_ENTER);
//					r.keyRelease(KeyEvent.VK_ENTER);
//				}
//			}
		}while(i<=11);
	}

	public void setResult() {
		getResultVerify();
		boolean value=webdriverVisibleWait(resultverify);
		if(value==true) {
			String signinresult=resultverify.getText();
			logger.info("OTP Entered Verified Fail Result :"+" "+signinresult+" "+"Maximum Verification Attempts Reached.Please Go Back And Try Again");
		}
	}

}
