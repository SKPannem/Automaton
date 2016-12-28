package com.components.pages;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.el.Constants;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.iwaf.framework.BasePage;
import com.iwaf.framework.TestProperties;
import com.iwaf.framework.components.Target;

public class SupportFunctions extends BasePage {
	private static String winHandleBefore;
	public static String parent ;
	public static Connection connection;
	public void waitForLoading(int iTime,By byXpath){
		//waiting for a while before loading progress bar comes
		getCommand().waitFor(3);
		getCommand().getDriver().manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
		
		if (!getCommand().getDriver().findElements(byXpath).isEmpty()){
			(new WebDriverWait(getCommand().getDriver(), iTime)).until(ExpectedConditions.invisibilityOfElementLocated(byXpath));
			getCommand().getDriver().manage().timeouts().setScriptTimeout(iTime+200, TimeUnit.SECONDS);
		}
	}
	/*chrome and ie*/
	public void selectDropDownValue(By xpath,String strValue){
		WebElement webDropDwn = getCommand().getDriver().findElement(xpath);
		Select selDrop= new Select(webDropDwn);
		if(Arrays.asList("*chrome","*iexplore").contains(TestProperties.getProperties("test.browser")))
		{
			selDrop.selectByValue(strValue);			
			//selDrop.selectByVisibleText(strValue);		
		}else{
			selDrop.selectByValue(strValue);	
		}
	}
	public void selectDropDownGeneric(By xpath,String strValue){
		WebElement webDropDwn = getCommand().getDriver().findElement(xpath);
		Select selDrop= new Select(webDropDwn);
		webDropDwn.click();
		if(Arrays.asList("*chrome","*iexplore").contains(TestProperties.getProperties("test.browser")))
		{
			selDrop.selectByValue(strValue);	
		}
		
		else{
			selDrop.selectByVisibleText(strValue);	
			WebElement webDrpDwn = (WebElement)getCommand().getDriver().findElement(xpath);
			webDrpDwn.sendKeys(Keys.ENTER);
		}
	}
	/******  Create xl file and write data to xl ***/
	public void writeOutputData(String filepName,String label,String cellValue) 
	{
		try {
		String filepath="OutputData//"+filepName;
		File f=new File(filepath);
		if(!f.exists())
		{
		FileOutputStream fileOut = new FileOutputStream(filepath);
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet worksheet = workbook.createSheet(filepName);
		if(worksheet.getLastRowNum()==0)
		{
		HSSFRow row1 = worksheet.createRow((short) 0);
		HSSFCell cellA1 = row1.createCell(0);
		cellA1.setCellValue(label);
		HSSFCell cellA2 = row1.createCell(1);
		cellA2.setCellValue(cellValue);
		workbook.write(fileOut);
		fileOut.flush();
		
		
		fileOut.close();
		}
		}
		else
		{
			FileInputStream fsIP= new FileInputStream(new File(filepath));
			 
			 HSSFWorkbook workbook = new HSSFWorkbook(fsIP);
			 
			 HSSFSheet worksheet = workbook.getSheet(filepName);
			 System.out.print("worksheet.getLastRowNum()===="+worksheet.getLastRowNum());
			 if(worksheet.getLastRowNum()>=0)
				{
		FileOutputStream output_file =new FileOutputStream(new File(filepath));
		HSSFRow row1 = worksheet.createRow(worksheet.getLastRowNum()+1);
		HSSFCell cellA1 = row1.createCell(0);
		cellA1.setCellValue(label);
		HSSFCell cellA2 = row1.createCell(1);
		cellA2.setCellValue(cellValue);
		worksheet.getPhysicalNumberOfRows();
		workbook.write(output_file);
		output_file.flush();
		output_file.close();
				}
		}
		
		
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	}	
	/******  Delete  xl file ***/
	public void deleteOutputData(String filepName) 
	{
		
			String filepath="OutputData//"+filepName;
		try{
			File f = new File(filepath);
			System.out.println("Path:"+f.getAbsolutePath());

			if(f.exists())
			{
			    System.out.println("File Exist"+filepath);
			    f.delete();

			}
			else
			{
			    System.out.println("Not Exixts");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/********* Reading xl file ************/
	public String readOutputData(String filepName,String keyValue)
	{
		String filepath="OutputData//"+filepName;
		try {FileInputStream fileInputStream = new FileInputStream(filepath);
			HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);
			HSSFSheet worksheet = workbook.getSheet(filepName);
			int size=worksheet.getLastRowNum();
			for(int i=0;i<=size;i++)
			{
			HSSFRow row1 = worksheet.getRow(i);
			HSSFCell cellA1 = row1.getCell(0);
			String a1Val = cellA1.getStringCellValue();
			if(a1Val.compareTo(keyValue)==0)
			{
			HSSFCell cellB1 = row1.getCell(1);
			String b1Val = cellB1.getStringCellValue();
			
			
			System.out.println("A1: " + a1Val);
			System.out.println("B1: " + b1Val);
			return b1Val;
			}
		}
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getSelectedValue(By byXpath){
		WebElement webDropDwn = getCommand().getDriver().findElement(byXpath);
		Select selDrop= new Select(webDropDwn);
		//webDropDwn.click();
		WebElement selVal = selDrop.getFirstSelectedOption();	
		System.out.println(selVal.getAttribute("value"));
		return selVal.getText();
	}
	public void switchWindow(){
		try{
			/*winHandleBefore = getCommand().getDriver().getWindowHandle();
			for(String winHandle:getCommand().getDriver().getWindowHandles()){
				getCommand().getDriver().switchTo().window(winHandle);
			}*/
			
			 parent = getCommand().driver.getWindowHandle();

		      // after clicking on the link
		      //wait('100');
			  getCommand().waitFor(20);
		       Set<String> availableWindows = getCommand().driver.getWindowHandles();
		       String newWindow = null;
		       for (String window : availableWindows) {
		           if (!parent.equals(window)) {
		               newWindow = window;
		           }
		       }
		       //assertNotNull(newWindow);

		       // switch to new window
		       getCommand().driver.switchTo().window(newWindow);
		}catch (Exception e) {
			e.printStackTrace();
			//return "FAIL";
		}
		
		//return "PASS";
	}
	public void switchWindowBack(){
		try{			
			getCommand().getDriver().close();
			//getCommand().getDriver().switchTo().window(winHandleBefore);
			getCommand().getDriver().switchTo().window(parent);

		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void switchBetweenTabs(){
		Actions aTab = new Actions(getCommand().getDriver());
		aTab.sendKeys(Keys.CONTROL + "\t");
	}
	public List<WebElement> getDropdownList(By byXpath){
		WebElement webDropDwn = getCommand().getDriver().findElement(byXpath);
		Select selDrop= new Select(webDropDwn);
		webDropDwn.click();
		List<WebElement> allOptions = selDrop.getOptions();
		if ("*firefox".contains(TestProperties.getProperties("test.browser")))
		{
		  webDropDwn.sendKeys(Keys.ENTER);
		}
		return allOptions;
	}
	public void moveMouseTo(By byXpath){
		//try{
		Actions aMouse=new Actions(getCommand().getDriver());
		WebElement element=getCommand().getDriver().findElement(byXpath);
		aMouse.moveToElement(element).clickAndHold().build().perform();
		//WebElement element=getCommand().getDriver().findElement(byXpath);
		//JavascriptExecutor js =  (JavascriptExecutor)getCommand().getDriver();
		//String strMouseHover = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover',true,false); arguments[0].dispatchEvent(evObj);}else if(document.createEventObject){arguments[0].fireEvent('onmouseover');}";
		//String strMouseHover = "arguments[0].click();";
		//String strMouseHover = "$('ul.menus.menu-secondary.sf-js-enabled.sub-menu li').hover()";
		//js.executeScript(strMouseHover,element);
		//Thread.sleep(1000);
		//}catch (Exception e) {
		//	e.printStackTrace();
		//}
	}
	public String getAlertText(){
		WebDriver driver=getCommand().getDriver();
		Alert alert=driver.switchTo().alert();
		String alertMsg=alert.getText();
		return alertMsg;
	}
	public void connectToDB(){
		try{
			String url = TestProperties.getProperties("dbUrl");
			String driverclass = TestProperties.getProperties("dbDriverClass");
			String username = TestProperties.getProperties("dbUser");
			String password = TestProperties.getProperties("dbPass");
			
			Class.forName(driverclass).newInstance();
			connection = DriverManager.getConnection(url, username, password);
			connection.setAutoCommit(false);
	
			connection.setTransactionIsolation(Connection.TRANSACTION_NONE);
			System.out.println("connectDb connected to: " + url);

		}catch(SQLException sqle){
			sqle.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void closeDBConnection(){
		try{

			if ( connection != null ) {
			     connection.commit();
			     connection.close();
			     connection = null;
			 };

		}catch(SQLException sqle){
			sqle.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList retrieveData(String strQuery){
		ArrayList arrData=new ArrayList();
	    
		try{		
			//Connect to DB
			new SupportFunctions().connectToDB();
			
			//Retrieve Data
			Statement readStmt = connection.createStatement();
			ResultSet rs = readStmt.executeQuery(strQuery);
			// ResultSetMetaData rsm = rs.getMetaData();
			
			 int count = rs.getMetaData().getColumnCount();
			/*//get resultTable and define headings
			
			 for (int i = 1; i <= count; i++) {
			     sb.append(rsm.getColumnLabel(i) + "t");
			 };*/

			 //   read table data by row
			 int j = 0;
			 while (rs.next()) {   
				 ArrayList tempData=new ArrayList();
			     for (int i = 1; i <= count; i++) {
			    	 tempData.add(rs.getString(i));
			    	 
			    	}
			     arrData.add(tempData);
			     
			 }
			 
			 //Close Connection
			 new SupportFunctions().closeDBConnection();
			 
		}catch(SQLException sqle){
			sqle.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return  arrData;
	}
	public void keyBoardEvent(){
		WebDriver driver=getCommand().getDriver();
		Actions act=new Actions(driver);
		act.sendKeys(Keys.ENTER);
	}

	public String updateData(String strQuery){
		String flag="false";   
		try{
			
			//Connect to DB
			new SupportFunctions().connectToDB();
			
			//Retrieve Data
			Statement readStmt = connection.createStatement();
			//ResultSet rs = readStmt.executeQuery(strQuery);
			readStmt.executeUpdate(strQuery);
			flag="True";
			//Close Connection
			 new SupportFunctions().closeDBConnection();
			 
		}catch(SQLException sqle){
			sqle.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
		
	}
	/*
	 * In IE for ckecking object visibility
	 */
	public void waitForObject(int iTime,int iStaticTime,Target target){
		if ("*iexplore".contains(TestProperties.getProperties("test.browser")))
		{
		//waiting for a while before loading progress bar comes
		getCommand().waitFor(iStaticTime);
		getCommand().getDriver().manage().timeouts().setScriptTimeout(iStaticTime + 5, TimeUnit.SECONDS);
		
		//if (!getCommand().getDriver().findElements(byXpath).isEmpty()){
			(new WebDriverWait(getCommand().getDriver(), iTime)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(target.getTargetValue())));
			getCommand().getDriver().manage().timeouts().setScriptTimeout(iTime+200, TimeUnit.SECONDS);
		//}
		}
	}
	/*
	 * In IE for ckecking object visibility
	 */
	public void waitForStatic(int iStaticTime){
		if ("*iexplore".contains(TestProperties.getProperties("test.browser")))
		{
		//waiting for a while before loading progress bar comes
		getCommand().waitFor(iStaticTime);
		getCommand().getDriver().manage().timeouts().setScriptTimeout(iStaticTime + 20, TimeUnit.SECONDS);
		
		
		}
	}
	/*
	 * In IE for chkecking object visibility
	 */
	public void click(Target target,int iTries){
		if ("*iexplore".contains(TestProperties.getProperties("test.browser")))
		{
			int iTryCount = 0;
			while(iTryCount < iTries){
				try{
					getCommand().click(target);
					break;
		
				}catch (Exception e) {
					System.out.println("Ignore Exception");
					iTryCount = iTryCount + 1;
				}				
			}			
				
		}else{
			getCommand().click(target);
		}
	}
	
	public void ScrollInToView(Target target){
		WebElement webObj = getCommand().getDriver().findElement(By.xpath(target.getTargetValue()));
		((JavascriptExecutor)getCommand().getDriver()).executeScript("arguments[0].scrollIntoView(true);", webObj);
		getCommand().waitFor(5);	
		getCommand().getDriver().manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
	}
}
