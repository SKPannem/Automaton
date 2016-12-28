package com.components.testdata;

import com.components.testdata.ReadExcel;
import com.iwaf.framework.BasePage;
import com.iwaf.framework.TestProperties;

public class LoginData {
	
	public String UserName;
	public String Password;
	public String OpCo;
	public String Customer;
	public String CustomerName;
	public String MailUserID;
	public String MailPassword;
	
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		 // Create a object of ReadWriteExcelProperties
		ReadExcel readExcelData = new ReadExcel();
 
        // Call readExcelFile() method by passing it location of xls
        // This method will load keys and values from xls to HashMap
		//readExcelData.readExcelFile("D:/TestData/Login.xls");
		readExcelData.verfiyAndReadFile("LoginData","D:/TestData/Login.xls","$Admin");
		//LoginData ld = new LoginData();
		//System.out.println("check-->"+ld.UserName);
       
	}
*/	
public static LoginData fetch(String key){
		//BasePage pageObj = new BasePage();		
		ReadExcel readExcelData = new ReadExcel();
		//LoginData obj = pageObj.getCommand().loadYaml(key, "data-pool/Login_Data.yaml");
		//return obj;
		
		Object obj = readExcelData.loadExcelByKey("LoginData",TestProperties.getProperties("testdata.path")+"Login_Data.xls",key);
		
		return (LoginData)obj;
	}
}

