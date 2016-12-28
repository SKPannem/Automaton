package com.components.testdata;

import com.iwaf.framework.BasePage;
import com.iwaf.framework.TestProperties;

public class OrderData {
	
	public String OrderName;
	public String ProductFrom;
	public String UPC;
	public String CaseQuantity;
	public String SplitQuantity;
	public String UpdateQuanty;
	public String UpdatePrice;
	public String CurrentPrice;
	public String ItemName;
	public String GroupBY;
	public String ListName;
	public String BrandName;

	public static OrderData fetch(String key){
		ReadExcel readExcelData = new ReadExcel();
		Object obj = readExcelData.loadExcelByKey("OrderData",TestProperties.getProperties("testdata.path")+"Order_Data.xls",key);

		return (OrderData)obj;
	}
}

