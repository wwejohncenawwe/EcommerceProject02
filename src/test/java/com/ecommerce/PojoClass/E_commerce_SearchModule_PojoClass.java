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
	@FindBy(xpath="//div[text()='APPLE']")
	@CacheLookup
	private WebElement searchbrand;
	@FindBy(xpath="4★ & above")
	@CacheLookup
	private WebElement ratings;
	@FindBy(xpath="//div[@data-id='MOBGHWFHQHE7ZPSB']/child::div/a")
	@CacheLookup
	private WebElement mobileselect;


	public WebElement getLoginClose() {
		return loginClose;
	}
	public WebElement getSearchBox() {
		return searchBox;
	}
	public WebElement getSearchbrand() {
		return searchbrand;
	}
	public WebElement getRatings() {
		return ratings;
	}
	public WebElement getMobileselect() {
		return mobileselect;
	}
	public void setLoginClose() {
		getLoginClose();
		btnClick(loginClose);
	}
	public void setSearchBox(String string) {
		getSearchBox();
		type(searchBox, string);
	}
	public void setSearchbrand(WebElement searchbrand) {
		getSearchbrand();
		btnClick(searchbrand);
	}

	public void setRatings(WebElement ratings) {
		getRatings();
		btnClick(ratings);
	}

	public void setMobileselect(WebElement mobileselect) {
		getMobileselect();
		btnClick(mobileselect);
	}


}
