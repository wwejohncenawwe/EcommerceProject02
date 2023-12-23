package com.ecommerce.TestCases;

import org.testng.annotations.Test;

import com.ecommerce.BaseClass.E_commerce_BaseClass;
import com.ecommerce.PojoClass.E_Commerce_PojoClassManager;
import com.ecommerce.TestData.E_commerce_DataProvider;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

public class E_commerce_TC01 extends E_commerce_BaseClass {

	@Test(dataProvider="addtocart",dataProviderClass=E_commerce_DataProvider.class,description="Test Start")
	@Description("E-Commerce-Automation--Test Started")
	@Epic("Flipkart Automation")
	@Feature("Functional Testing")
	@Story("Search-Filter-Buy")
	@Step("Test TC-01")
	@Severity(SeverityLevel.MINOR)
	public void E_commerce_Flipkart_TC(String emailid,String phoneno) throws InterruptedException {
		E_Commerce_PojoClassManager pojo=new E_Commerce_PojoClassManager();

		pojo.getSearch().setLoginClose();

		pojo.getSearch().setSearchBox("mobile"+"\n");

		pojo.getFilter().setSearchBrand();

		pojo.getFilter().setSelectBrand();

		pojo.getFilter().setSearchRating();

		pojo.getFilter().setSelectRating();

		pojo.getMobileSelect().setPriceFilter();
		Thread.sleep(2000);
		pojo.getMobileSelect().setMobileselect();

		pojo.getAddToCart().setAddToCart();

		pojo.getAddToCart().setCartlist();

		pojo.getAddToCart().setPlaceorder();

		pojo.getAddToCart().setEmailid(emailid);

		pojo.getAddToCart().setBtnemailContinue();

		pojo.getAddToCart().setMobileno(phoneno);

		pojo.getAddToCart().setBtnmobile();
		
		pojo.getAddToCart().setOtp();

		pojo.getAddToCart().setResult();

	}
}
