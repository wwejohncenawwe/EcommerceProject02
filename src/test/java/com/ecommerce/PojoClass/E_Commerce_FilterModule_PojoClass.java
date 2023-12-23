package com.ecommerce.PojoClass;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecommerce.BaseClass.E_commerce_BaseClass;

public class E_Commerce_FilterModule_PojoClass  extends E_commerce_BaseClass{

	public WebDriver ldriver;
	JavascriptExecutor js=(JavascriptExecutor)driver;

	public E_Commerce_FilterModule_PojoClass(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}

	@FindBy(xpath="//div[text()='Brand']")
	@CacheLookup
	private WebElement searchbrand;

	@FindBy(xpath="//div[text()='APPLE']")
	@CacheLookup
	private WebElement selectbrand;

	@FindBy(xpath="//div[text()='Customer Ratings']")
	@CacheLookup
	private WebElement searchrating;

	@FindBy(xpath="//div[text()='4★ & above']")
	@CacheLookup
	private WebElement selectrating;


	public WebElement getSearchBrand() {
		return searchbrand;
	}

	public WebElement getSelectBrand() {
		return selectbrand;
	}

	public WebElement getSearchRating() {
		return searchrating;
	}

	public WebElement getSelectRating() {
		return selectrating;
	}


	public void setSearchBrand() {
		getSearchBrand();
		webelementDisplayed(searchbrand);
		js.executeScript("arguments[0].scrollIntoView(true);", searchbrand);
	}

	public void setSelectBrand() {
		getSelectBrand();
		webdriverClickWait(selectbrand);
		btnClick(selectbrand);
		logger.info("Search Brand Selected");
	}

	public void setSearchRating() {
		getSearchRating();
		webelementDisplayed(searchrating);
		js.executeScript("window.scrollBy(0,600)");
	}

	public void setSelectRating() {
		getSelectRating();
		webdriverClickWait(selectrating);
		btnClick(selectrating);
		logger.info("Search Rating Selected");
	}
}
