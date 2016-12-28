
/**
 ********************************************************************************************************************************************
 ********************************************************************************************************************************************
 *																																		   	*
 * 2011-2012 Infosys Limited, Banglore, India. All Rights Reserved																			*
 * Version: 2.0																																*
 * 																																			*
 * Except for any free or open source software components embedded in this Infosys proprietary software program ("Program"),				*
 * this Program is protected by copyright laws, international treaties and other pending or existing intellectual property rights in India, *
 * the United States and other countries. Except as expressly permitted, any unautorized reproduction, storage, transmission 				*
 * in any form or by any means (including without limitation electronic, mechanical, printing, photocopying, recording or otherwise), 		*
 * or any distribution of this Program, or any portion of it, may result in severe civil and criminal penalties, 							*
 * and will be prosecuted to the maximum extent possible under the law 																		*
 *																																			*
 ********************************************************************************************************************************************
 ********************************************************************************************************************************************
 **/
package com.components.pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.components.repository.SiteRepository;
import com.iwaf.framework.TestProperties;
import com.iwaf.framework.components.SoftAssertion;
import com.iwaf.framework.components.Target;
import com.iwaf.framework.components.IReporter.LogType;
import com.sun.xml.bind.v2.schemagen.xmlschema.List;

public class LoginPage extends SitePage{

	public static final Target LOGO = new Target("LibraryLogo","//*[@id='container']/div[1]/div[1]/img",Target.XPATH);
	public static final Target txt_UserName = new Target("txt_UserName","//input[@id='userId']",Target.XPATH);
	public static final Target txt_Password = new Target("txt_Password","//input[@id='password']",Target.XPATH);
	public static final Target btn_SignIn = new Target("btn_SignIn","//*[@name='login']",Target.XPATH);
	public static final Target txt_UserNameReEnter = new Target("txt_UserNameReEnter","//input[@type='password']",Target.XPATH);
	public static final Target txt_Search = new Target("txt_Search","//input[@value='Customer Name or ID']",Target.XPATH);
	public static final Target btn_ForceLogin = new Target("btn_ForceLogin","//input[@type='submit']",Target.XPATH);
    public static final Target btn_Search = new Target("btn_Search","//*[@class='srbt']",Target.XPATH);
	public static final Target link_MultiApprover = new Target("link_MultiApprover","//*[@id='locations-container']/ul/li[1]",Target.XPATH);
	
	public LoginPage(SiteRepository repository){
		super(repository);
	}

	public LoginPage atLoginPage(){
		log("Opened eSysco Login Page ",LogType.STEP);
		return this;
	}

	public LoginPage loginToApplication(String UserName,String Password){
		if ("*iexplore".contains(TestProperties.getProperties("test.browser")) && getCommand().getDriver().getTitle().contains("Certificate")){
			getCommand().getDriver().get("javascript:document.getElementById('overridelink').click();");
		//getCommand().getDriver().findElement(By.id("overridelink")).click();
	   }
		(new SupportFunctions()).waitForStatic(3);
		getCommand().waitForTargetPresent(txt_UserName);
		if (getCommand().isTargetPresent(txt_UserName)){
			(new SupportFunctions()).waitForStatic(2);
			log("Enter User Name " + UserName,LogType.STEP);
			getCommand().sendKeys(txt_UserName, UserName);
			(new SupportFunctions()).waitForStatic(3);
		}
		if (getCommand().isTargetPresent(txt_Password)){
			log("Enter Password",LogType.STEP);	
			getCommand().sendKeys(txt_Password, Password);
		}		
		if (getCommand().isTargetPresent(btn_SignIn)){
			log("Click on Submit Button",LogType.STEP);	
			getCommand().click(btn_SignIn);
			//log("Login Successful",LogType.STEP);	

		}
		
		getCommand().waitFor(3);
		if(!getCommand().getDriver().findElements(By.xpath(txt_UserNameReEnter.getTargetValue())).isEmpty()){
		if (getCommand().isTargetPresent(txt_UserNameReEnter)){
			log("User already logged in,Force Login",LogType.STEP);	
			getCommand().sendKeys(txt_UserNameReEnter, Password);
			log("Re- entered password",LogType.STEP);	
		}
		
		if (getCommand().isTargetPresent(btn_ForceLogin)){	
			log("Click on Force Login Button",LogType.STEP);
			getCommand().click(btn_ForceLogin);			
		}
		
		log("Login Successful",LogType.STEP);	
		}
		return this;
		
	}
	public LoginPage verifyLoginPageAfterSignout(){
		
		getCommand().waitForTargetPresent(LOGO);
		if (getCommand().isTargetPresent(LOGO)){
			log("Logout Successful.",LogType.STEP);		
		}
		return this;
	}
	
	
	public LoginPage clickOnUserTiedWithMultiApprover(){
		//Waiting For The Object In IE
		  new SupportFunctions().waitForStatic(5);
		getCommand().waitForTargetPresent(link_MultiApprover);
		if (getCommand().isTargetPresent(link_MultiApprover)){
			log("Click On The User",LogType.STEP);	
			getCommand().click(link_MultiApprover);
		}
		return this;
	}
	public LoginPage verifyLocationByName(String cName ){
		getCommand().waitForTargetPresent(txt_Search);
		if (getCommand().isTargetPresent(txt_Search)){
			getCommand().clear(txt_Search).sendKeys(txt_Search,cName);
			log(" User Able To Search By Customer Number:"+cName,LogType.STEP);	
		}
		else{
			SoftAssertion.fail("Failed::Not Searched By customer Name ");
		}
		return this;
		
	}
	
	public LoginPage verifyLocationByNumber(String cNumber){
		getCommand().waitForTargetPresent(txt_Search);
		if (getCommand().isTargetPresent(txt_Search)){
			getCommand().clear(txt_Search).sendKeys(txt_Search,cNumber);
			log("User Able To Search By Customer Number:"+cNumber,LogType.STEP);	
			
		}
		else{
			SoftAssertion.fail("Failed::Not Searched By Customer Number");
		}
	 
		return this;
	}
	public LoginPage verifySearchByName(String[] cName ){
		for(int i=0;i<cName.length;i++){
		getCommand().waitForTargetPresent(txt_Search);
		if (getCommand().isTargetPresent(txt_Search)){
			log("Enter Customer Name:"+cName[i],LogType.STEP);	
			log("User Able To Search By Customer Name:"+cName[i],LogType.STEP);
			getCommand().clear(txt_Search);
			getCommand().sendKeys(txt_Search,cName[i]);
			getCommand().click(btn_Search);
			getCommand().waitFor(3);
		}else{
			SoftAssertion.fail("Failed::Not Searched By Customer Number:"+cName[i]);
		}
	 }
		return this;
		
	}
	public LoginPage verifySearchByNumber(String[] cNumber ){
		for(int i=0;i<cNumber.length;i++){
			System.out.println(cNumber[i]);
		getCommand().waitForTargetPresent(txt_Search);
		if (getCommand().isTargetPresent(txt_Search)){
			log("Enter Customer Name:"+cNumber[i],LogType.STEP);	
			log("User Able To Search By Customer Name:"+cNumber[i],LogType.STEP);
			getCommand().clear(txt_Search).sendKeys(txt_Search,cNumber[i]);
			getCommand().waitFor(3);
		}else{
			SoftAssertion.fail("Failed::Not Searched By Customer Number:"+cNumber[i]);
		}
	 }
		return this;
		
	}
	public LoginPage validateCustomer(){
		//Clearing The Search Box Before Validating
		getCommand().clear(txt_Search);
		getCommand().waitFor(3);
		java.util.List<WebElement> listCustomer=getCommand().getDriver().findElements(By.xpath("//p[@class='customer-name']"));
		for(WebElement e:listCustomer){
			if(e.isDisplayed()){
				System.out.println("cName==========="+e.getText());
				 log("Customer Name '"+e.getText()+"' Is Dispalyed",LogType.STEP);
			}
			else{
				SoftAssertion.fail("Failed::Customer Name Is Not Displayed");
			}
		}
		return this;
	}
	public LoginPage clickOnCustomer(int iCount){
		//Clearing The Search Box Before Validating
		getCommand().clear(txt_Search);
		getCommand().waitFor(3);
		java.util.List<WebElement> listCustomer=getCommand().getDriver().findElements(By.xpath("//p[@class='customer-name']"));
		System.out.println("Total Customer Count========="+listCustomer.size());
		listCustomer.get(iCount).click();
		getCommand().waitFor(10);
		return this;
	}
	public LoginPage validateCustomerAddress(){
		//Clearing The Search Box Before Validating
		getCommand().clear(txt_Search);
		getCommand().waitFor(3);
		java.util.List<WebElement> listAddress=getCommand().getDriver().findElements(By.xpath("//p[@class='delivery-address']"));
		System.out.println("Customer Count========="+listAddress.size());
		for(WebElement e:listAddress){
			if(e.isEnabled()){
				System.out.println("Customer Address==========="+e.getText());
				 log("Customer Address: '"+e.getText()+"' Is Dispalyed",LogType.STEP);
			}
			else{
				SoftAssertion.fail("Failed::Customer Address Is Not Displayed");
			}
		}
		return this;
	}
	public LoginPage validateCustomerNumber(){
		//Clearing The Search Box Before Validating
		getCommand().clear(txt_Search);
		getCommand().waitFor(3);
		java.util.List<WebElement> listNumber=getCommand().getDriver().findElements(By.xpath("//p[@class='customer-number']"));
		System.out.println("Customer Number Count========="+listNumber.size());
		for(WebElement e:listNumber){
			if(e.isEnabled()){
				System.out.println("cNumber==========="+e.getText());
				 log("Customer Number: '"+e.getText()+"' Is Dispalyed",LogType.STEP);
			}
			else{
				SoftAssertion.fail("Failed::Customer Number Is Not Displayed");
			}
		}
		return this;
	}
	public LoginPage validateCustomerOpcoName(){
		//Clearing The Search Box Before Validating
		getCommand().clear(txt_Search);
		getCommand().waitFor(3);
		java.util.List<WebElement> listOpco=getCommand().getDriver().findElements(By.xpath("//p[@class='customer-opco']"));
		System.out.println("Customer Opco========="+listOpco.size());
		for(WebElement e:listOpco){
			if(e.isEnabled()){
				System.out.println("cNumber==========="+e.getText());
				for(int i=0;i<e.getText().split("-").length;i++){
				 log("Customer opco: '"+e.getText().split("-")[0]+"' Is Dispalyed",LogType.STEP);
				 log("Customer Name: '"+e.getText().split("-")[1]+"' Is Dispalyed",LogType.STEP);
				}
			}
			else{
				SoftAssertion.fail("Failed::Customer Opco Is Not Displayed");
				SoftAssertion.fail("Failed::Customer Name Is Not Displayed");
			}
		}
		return this;
	}
	public LoginPage verifyClosedUser(){
		getCommand().waitForTargetVisible(txt_UserName);
		if(getCommand().isTargetPresent(txt_UserName)){
			log("Closed Successfully",LogType.STEP);
		  }
			else{
            SoftAssertion.fail("Failed::Not Closed Succsessfully");
           }
		return this;
	}
	public LoginPage  validateActiveOrderSection(){
		getCommand().waitForTargetVisible(txt_Search);
		if(getCommand().isTargetPresent(txt_Search)){
			log("Active Order Or Location Section Is Displayed",LogType.STEP);
		  }
			else{
            SoftAssertion.fail("Failed::Active Order Or Location Section Is Not Displayed");
           }
		return this;
	}
	public LoginPage closeBrowser(){
	log("Close Browser",LogType.STEP);
	return this;
	}
	
}
