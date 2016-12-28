package com.components.testdata;

import com.iwaf.framework.TestProperties;

public class ColumnsSelected {

	public String Columns;

	public static ColumnsSelected fetch(String key){
		ReadExcel readExcelData = new ReadExcel();
		Object obj = readExcelData.loadExcelByKey("ColumnsSelected",TestProperties.getProperties("testdata.path")+"Column_Selected.xls",key);

		return (ColumnsSelected)obj;
	}
}
