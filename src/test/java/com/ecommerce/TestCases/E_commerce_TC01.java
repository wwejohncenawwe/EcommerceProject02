package com.ecommerce.TestCases;

import org.testng.annotations.Test;

import com.ecommerce.BaseClass.E_commerce_BaseClass;
import com.ecommerce.PojoClass.E_commerce_SearchModule_PojoClass;
import com.ecommerce.TestData.E_commerce_DataProvider;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

public class E_commerce_TC01 extends E_commerce_BaseClass {

	@Test(dataProvider="searchdata",dataProviderClass=E_commerce_DataProvider.class,description="test start")
	@Description("test start")
	@Epic("EP1")
	@Feature("Feature1")
	@Story("story1")
	@Step("step1")
	@Severity(SeverityLevel.MINOR)
	public void SearchModule_TC(String data) throws InterruptedException {
		E_commerce_SearchModule_PojoClass pojo=new E_commerce_SearchModule_PojoClass(driver);
		logger.info("Closing Loginpage");
		pojo.setLoginClose();
		logger.info("Searching on SearchBox");
		pojo.setSearchBox(data+"\n");
		logger.info("Search Completed");
		Thread.sleep(2000);
		pojo.getSearchbrand();
		logger.info("search brand selected done");
		Thread.sleep(2000);
		pojo.getRatings();
		logger.info("rating selected");
		Thread.sleep(2000);
		pojo.getMobileselect();
		logger.info("mobile link clicked");
		
			}

}
