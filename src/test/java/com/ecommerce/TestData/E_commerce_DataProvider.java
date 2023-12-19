package com.ecommerce.TestData;

import org.testng.annotations.DataProvider;

import com.ecommerce.BaseClass.E_commerce_BaseClass;
import com.ecommerce.Utilities.E_commerce_ReadExcel;

public class E_commerce_DataProvider extends E_commerce_BaseClass {

	String[][] Exceldata=null;

	@DataProvider(name="searchdata")
	public String[][] getData(){
		//		logger.error("Loading Excel Data");
		Exceldata=getExcelData();
		return Exceldata;
	}
	public String[][] getExcelData(){
		String path="D:\\Eclipse Workspace\\E-Commerce-Project\\src\\test\\java\\com\\ecommerce\\TestData\\TC01.xlsx";
		//		logger.info("Getting Rowcount");
		int rowcount=E_commerce_ReadExcel.getRowCount(path,"searchbox");
		//		logger.info("Getting Cellcount");
		int cellcount=E_commerce_ReadExcel.getCellCount(path,"searchbox", rowcount);
		String datavalue[][]=new String[rowcount][cellcount];
		for(int i=1;i<=rowcount;i++) {
			for(int j=0;j<cellcount;j++) {
				datavalue[i-1][j]=E_commerce_ReadExcel.getCellData(path,"searchbox", i, j);
			}
		}
		//		logger.info("ExcelData value Feteched Done");
		return datavalue;
	}
}
