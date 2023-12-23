package com.ecommerce.PojoClass;

import com.ecommerce.BaseClass.E_commerce_BaseClass;

public class E_Commerce_PojoClassManager  extends E_commerce_BaseClass{

	E_commerce_SearchModule_PojoClass search;
	E_Commerce_FilterModule_PojoClass filter;
	E_Commerce_MobileselectModule_PojoClass mobileselect;
	E_Commerce_AddtoCartModule_PojoClass addtocart;

	public  E_commerce_SearchModule_PojoClass getSearch() {
		logger.info("Search POJO is NULL So Object Is Created");
		return(search==null)? search=new E_commerce_SearchModule_PojoClass(driver):search;
	}

	public  E_Commerce_FilterModule_PojoClass getFilter() {
		logger.info("Filter POJO is NULL So Object Is Created");
		return(filter==null)? filter=new E_Commerce_FilterModule_PojoClass(driver):filter;
	}

	public  E_Commerce_MobileselectModule_PojoClass getMobileSelect() {
		logger.info("MobileSelect POJO is NULL So Object Is Created");
		return(mobileselect==null)? mobileselect=new E_Commerce_MobileselectModule_PojoClass(driver):mobileselect;
	}

	public  E_Commerce_AddtoCartModule_PojoClass getAddToCart() {
		logger.info("AddToCart POJO is NULL So Object Is Created");
		return(addtocart==null)? addtocart=new E_Commerce_AddtoCartModule_PojoClass(driver):addtocart;
	}


}
