package com.ecommerce.TestData;

import org.testng.annotations.DataProvider;

import com.ecommerce.BaseClass.E_commerce_BaseClass;
import com.ecommerce.Utilities.E_commerce_ReadExcel;

public class E_commerce_DataProvider extends E_commerce_BaseClass {

	String[][] Data=null;

	String path="D:\\Eclipse Workspace\\E-Commerce-Project\\src\\test\\java\\com\\ecommerce\\TestData\\TC01.xlsx";

	@DataProvider(name="addtocart")
	public String[][] getData1(){
		Data=getExcelData02();
		return Data;
	}

	//	public String[][] getExcelData01(){
	//		int rowcount=E_commerce_ReadExcel.getRowCount(path,"searchbox");
	//		int cellcount=E_commerce_ReadExcel.getCellCount(path,"searchbox", rowcount);
	//		String datavalue[][]=new String[rowcount][cellcount];
	//		for(int i=1;i<=rowcount;i++) {
	//			for(int j=0;j<cellcount;j++) {
	//				datavalue[i-1][j]=E_commerce_ReadExcel.getCellData(path,"searchbox", i, j);
	//			}
	//		}
	//		return datavalue;
	//	}

	public String[][] getExcelData02() {
		int rowcount=E_commerce_ReadExcel.getRowCount(path,"addtocart");
		int cellcount=E_commerce_ReadExcel.getCellCount(path,"addtocart", rowcount);
		String datavalue[][]=new String[rowcount][cellcount];
		for(int i=1;i<=rowcount;i++) {
			for(int j=0;j<cellcount;j++) {
				datavalue[i-1][j]=E_commerce_ReadExcel.getCellData(path,"addtocart", i, j);
			}
		}
		return datavalue;
	}
}	
