package com.tests;

import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

import com.components.entities.Start;
import com.components.testdata.LoginData;
import com.iwaf.framework.Initiator;

public class CustomerSelectionAndSwitch extends Initiator {
	@Test(groups={"Customer_Selection_Switch"}, description = "Account Selection_001 :Validate account  for Multibuyer")
	@Features("Customer Selection and switch")
	@Stories("Account Selection_001 : Validate account  for Multibuyer")
	public void ValidateCustomerDetails() {	
		
		LoginData loginData =LoginData.fetch("$MultiBuyerUser4");	
		String[] customerName=loginData.CustomerName.split(";");
		String[] customerNumber=loginData.Customer.split(";");
		Start.asTester
		.goToLoginpage()
		.loginToApplication(loginData.UserName, loginData.Password)
		._GoToHomePage()
		.atHomePage()
		//.clickOnExpress()
		.atExpressHomePage()
		._atLoginPage()
		.validateCustomer()
		.validateCustomerAddress()
		.validateCustomerNumber()
		.validateCustomerOpcoName()
		.verifySearchByName(customerName)
		.verifySearchByNumber(customerNumber)
		.verifyLocationByName(customerName[0])
		.verifyLocationByNumber(customerNumber[0])
		._GoToLoginPage();
	
		} 
	@Test(groups={"Customer_Selection_Switch"}, description = "Login_005 : Validation of Log in functionality for different type for eSysco users")
	@Features("Customer Selection and switch")
	@Stories("Login_005 : Validation of Log in functionality for different type for eSysco users")
	public void ValidateLogIn() {	
		LoginData loginData_MBUser =LoginData.fetch("$CSUser1");
		LoginData loginData_NUser =LoginData.fetch("$CSUser2");
		LoginData loginData_MAUser =LoginData.fetch("$CSUser3");
		LoginData loginData_SAUser =LoginData.fetch("$CSUser4");
		LoginData loginData_CSRUser =LoginData.fetch("$CSUser6");
		Start.asTester
		.goToLoginpage()
		.loginToApplication(loginData_MBUser.UserName, loginData_MBUser.Password)
		._GoToHomePage()
		.atHomePage()
		//.clickOnExpress()
		.atExpressHomePage()
		.atExpressOrderingPage()
		.verifyHomePage()
		._GoOrderPage()
		.close()
		._GoToLoginPage()
		.verifyClosedUser()
		.loginToApplication(loginData_MAUser.UserName, loginData_MAUser.Password)
		._GoToHomePage()
		.atHomePage()
		//.clickOnExpress()
		.atExpressHomePage()
		.verifyHomePage()
		._GoOrderPage()
		.close()
		._atLoginPage()
		._GoToLoginPage()
		.verifyClosedUser()
		.loginToApplication(loginData_SAUser.UserName, loginData_SAUser.Password)
		._GoToHomePage()
		.atHomePage()
		//.clickOnExpress()
		.atExpressHomePage()
		.verifyHomePage()
		._GoOrderPage()
		.close()
		._atLoginPage()
		._GoToLoginPage()
		.verifyClosedUser()
		._atLoginPage()
		.loginToApplication(loginData_NUser.UserName, loginData_NUser.Password)
		._GoToHomePage()
		.atHomePage()
		//.clickOnExpress()
		.atExpressHomePage()
		.verifyHomePage()
		._GoOrderPage()
		.close()
		._atLoginPage()
		._GoToLoginPage()
		.verifyClosedUser()
		.loginToApplication(loginData_CSRUser.UserName, loginData_CSRUser.Password)
		._GoToHomePage()
		.atHomePage()	
		//.clickOnExpress()
		.atExpressHomePage()
		.SelectLocation(loginData_CSRUser.OpCo, loginData_CSRUser.Customer)
		//.clickOnExpress()
		.atExpressHomePage()
		._GoOrderPage()
		.close()
		._GoToLoginPage()
		.verifyClosedUser();
		
	}
	
	@Test(groups={"Customer_Selection_Switch"}, description = "HomePage_016_02 : Validate Active Order or Location for Multi buyer users selection of 'Yes' from the message box")
	@Features("Customer Selection and switch")
	@Stories("HomePage_016_02 : Validate Active Order or Location for Multi buyer users selection of 'Yes' from the message box")
	public void SearchItemAndCreatOrder() {	
		
		LoginData loginData =LoginData.fetch("$CSUser7");	
		//String[] customerNumber=loginData.Customer.split(";");
		Start.asTester
		.goToLoginpage()
		.loginToApplication(loginData.UserName, loginData.Password)
		._GoToHomePage()
		.atHomePage()
		//.clickOnExpress()
		._atLoginPage()
		.validateActiveOrderSection()
		.clickOnCustomer(0)
		._GoToHomePage()
		.verifyHomePage()
		.clickOnLocation()
		._atLoginPage()
		.validateCustomer()
		.clickOnCustomer(1)
		._GoToHomePage()
		.validateMsgAtSwitchCustomerPopUp()
		.clickYesToSwitch()
		.validateHeaderPage();
		
		
	}
}
