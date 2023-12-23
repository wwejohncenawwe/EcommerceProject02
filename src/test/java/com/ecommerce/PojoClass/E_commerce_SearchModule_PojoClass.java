package com.ecommerce.PojoClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecommerce.BaseClass.E_commerce_BaseClass;

public class E_commerce_SearchModule_PojoClass extends E_commerce_BaseClass {

	public WebDriver ldriver;

	public E_commerce_SearchModule_PojoClass(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}

	@FindBy(xpath="//span[@role='button']")
	@CacheLookup
	private WebElement loginClose;

	@FindBy(xpath="//input[@name='q']")
	@CacheLookup
	private WebElement searchBox;


	public WebElement getLoginClose() {
		return loginClose;
	}

	public WebElement getSearchBox() {
		return searchBox;
	}


	public void setLoginClose() {
		getLoginClose();
		btnClick(loginClose);
		logger.info("Login Option Closed");
	}

	public void setSearchBox(String string) {
		getSearchBox();
		webelementDisplayed(searchBox);
		type(searchBox, string);
		logger.info("Search Box Value Entered");
	}
























	//	
	//	public void setOtp() throws InterruptedException {
	//		getOtp();
	//		getSpanmsg();
	//		int max=10;
	//		for(int i=0;i<10;i++) {
	//			if(webelementDisplayed(otp)) {
	//				Thread.sleep(2000);
	//				String otpvalue=randomNumeric(6);
	//				type(otp,otpvalue);
	////				if(webelementDisplayed(spanmsg)){
	////					otp.clear();
	////				}
	//			}else {
	//				logger.info("otp entered success");
	//			}
	//			break;
	//		}


	//	public void setOtp() throws InterruptedException {
	//		getOtp();
	//		boolean value=webdriverVisibleWait(otp);
	//		if(value==true) {
	//			Thread.sleep(1000);
	//			String otpvalue=randomNumeric(6);
	//			type(otp,otpvalue);
	//			if(spanmsg.isDisplayed()) {
	//				setSpanmsg();
	//			}
	//		}else {
	//			logger.info("otp entered success");
	//		}
	//	}
	//	public void setSpanmsg() {
	//		getSpanmsg();
	//		if(webelementDisplayed(spanmsg)) {
	//		int max=10;
	//		for(int i=0;i<max;i++) {
	//			try {
	//				otp.clear();
	//				setOtp();
	//			}catch (InterruptedException e) {
	//				e.printStackTrace();
	//			}
	//
	//			break;
	//		}

	//	}






}