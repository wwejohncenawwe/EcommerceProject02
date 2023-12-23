package com.ecommerce.PojoClass;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecommerce.BaseClass.E_commerce_BaseClass;

public class E_Commerce_MobileselectModule_PojoClass extends E_commerce_BaseClass {

	public WebDriver ldriver;

	public E_Commerce_MobileselectModule_PojoClass(WebDriver rdriver){
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}

	@FindBy(xpath="//div[text()='Newest First']")
	@CacheLookup
	private WebElement pricefilter;

	@FindBy(xpath="//div[@id='container']/div/div[3]/div/div[2]/div/div/div/div/div/following::div/div/div/div/a")
	@CacheLookup
	private List<WebElement> mobileselect;

	public WebElement getPriceFilter() {
		return pricefilter;
	}

	public List<WebElement> getMobileselect() {
		return mobileselect;
	}


	public void setPriceFilter() {
		getPriceFilter();
		webdriverClickWait(pricefilter);
		btnClick(pricefilter);
		logger.info("Mobile Price Filter Selected");
	}

	public void setMobileselect()  {
		getMobileselect();
		for (WebElement webelement:mobileselect) {
			switch (webelement.getText()) {
			case "APPLE iPhone 15 Pro":webelement.click();
			logger.info("Mobile Selected :  "+webelement.getText());
			break;
			case "APPLE iPhone 14 Pro":webelement.click();
			logger.info("Mobile Selected :  "+webelement.getText());
			break;
			case "APPLE iPhone 13 Pro":webelement.click();
			logger.info("Mobile Selected :  "+webelement.getText());
			break;
			case "APPLE iPhone 15":webelement.click();
			logger.info("Mobile Selected :  "+webelement.getText());
			break;
			case "APPLE iPhone 14":webelement.click();
			logger.info("Mobile Selected :  "+webelement.getText());
			break;
			case "APPLE iPhone 13":webelement.click();
			logger.info("Mobile Selected :  "+webelement.getText());
			break;
			case "APPLE iPhone 15 Plus":webelement.click();
			logger.info("Mobile Selected :  "+webelement.getText());
			break;
			case "APPLE iPhone 14 Plus":webelement.click();
			logger.info("Mobile Selected :  "+webelement.getText());
			break;
			case "APPLE iPhone 13 Plus":webelement.click();
			logger.info("Mobile Selected :  "+webelement.getText());
			break;
			default:webelement.click();
			logger.info("Mobile Selected :  "+webelement.getText());
			break;
			}	
			break;
		}
	}

}










