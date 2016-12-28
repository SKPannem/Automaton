package com.components.testdata;

import com.iwaf.framework.BasePage;
import com.iwaf.framework.TestProperties;

public class ItemData {
	
	public String ReservedForTestCase;
	public String SyscoUPC;
	public String Sequence;
	public String Quantity;
	public String QuantityUnit;
	public String Yield;
	public String Weight;
	public String WeightUnit;
	public String Volume;
	public String VolumeUnit;
	public String Portion;
	public String PortionUnit;
	public String Price;

	public static ItemData fetch(String key){
		ReadExcel readExcelData = new ReadExcel();
		Object obj = readExcelData.loadExcelByKey("ItemData",TestProperties.getProperties("testdata.path")+"Item_Data.xls",key);

		return (ItemData)obj;
	}
}

