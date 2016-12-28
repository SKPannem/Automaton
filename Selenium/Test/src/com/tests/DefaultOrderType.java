package com.tests;

import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

import com.components.entities.Start;
import com.components.testdata.LoginData;
import com.components.testdata.OrderData;
import com.iwaf.framework.Initiator;

public class DefaultOrderType extends Initiator{
	@Test(groups={"Default_Order_Type"}, description = "TS_DafaultOrderType_001:Verification of defaul order type for Normal user is 'List'")
	@Features("Default Order Type")
	@Stories("TS_DafaultOrderType_001:Verification of defaul order type for Normal user is 'List'")
	public void VerifyDefaultOrderFromList() {	
		
		LoginData loginData =LoginData.fetch("$NormalUser26");
		OrderData orderData=OrderData.fetch("$OrderData70");
   Start.asTester
		.goToLoginpage()
		.loginToApplication(loginData.UserName, loginData.Password)
		._GoToHomePage()
		.atHomePage()
		//.clickOnExpress()
		.atExpressHomePage()
		.startNewOrder()
		.verifyCreateOrderpage()
		._GoOrderPage()
		.selectDropDownValue(orderData.ProductFrom)
		.clickOnSaveSetting()
		.clickOnCreatNewOrder()
		._GoToHomePage()
		.clickOnHomePageTab()
		.startNewOrder()
		//Verifying Default Selection List
		.verifyDefaultOrder(orderData.ProductFrom);
	}
	
	@Test(groups={"Default_Order_Type"}, description = "TS_DafaultOrderType_002:Verification of List page loaded while clicking Create new order from home page as normal user")
	@Features("Default Order Type")
	@Stories("TS_DafaultOrderType_002:Verification of List page loaded while clicking Create new order from home page as normal user")
	public void verifyListPage() {	
		
		LoginData loginData =LoginData.fetch("$NormalUser27");
		OrderData orderdata=OrderData.fetch("$OrderData70");
		Start.asTester
		.goToLoginpage()
		.loginToApplication(loginData.UserName, loginData.Password)
		._GoToHomePage()
		.atHomePage()
		//.clickOnExpress()
		.atExpressHomePage()
		.startNewOrder()
		.verifyCreateOrderpage()
		._GoOrderPage()
		.selectDropDownValue(orderdata.ProductFrom)
		.clickOnCreatNewOrder()
		._GoToHomePage()
		//Verifying Default Selection 
		.verifyListpage();
		
	}
	@Test(groups={"Default_Order_Type"}, description = "TS_DafaultOrderType_003:Verification of List page loaded while clicking Create new order from home page as normal user")
	@Features("Default Order Type")
	@Stories("TS_DafaultOrderType_003:Verification of List page loaded while clicking Create new order from home page as normal user")
	public void verifyDefaultListMultibuyer() {	
		
		LoginData loginData =LoginData.fetch("$MultiBuyerUser1");
		OrderData orderData=OrderData.fetch("$OrderData70");
		Start.asTester
		.goToLoginpage()
		.loginToApplication(loginData.UserName, loginData.Password)
		._GoToHomePage()
		.atHomePage()
		//.clickOnExpress()
		.atExpressHomePage()	
		.startNewOrder()
		.verifyCreateOrderpage()
		._GoOrderPage()
		.selectDropDownValue(orderData.ProductFrom)
		.clickOnSaveSetting()
		.clickOnCreatNewOrder()
		._GoToHomePage()
		.clickOnHomePageTab()
		.startNewOrder()
		//Verifying Default Selection List
		.verifyDefaultOrder(orderData.ProductFrom);
		
	}
	@Test(groups={"Default_Order_Type"}, description = "TS_DafaultOrderType_004:Verification of list page loaded on clicking create new order from CNOM as multi buyer user")
	@Features("Default Order Type")
	@Stories("TS_DafaultOrderType_004:Verification of list page loaded on clicking create new order from CNOM as multi buyer user")
	public void verifyListPageMultibuyer() {	
		
		LoginData loginData =LoginData.fetch("$MultiBuyerUser3");
		OrderData orderData=OrderData.fetch("$OrderData70");
		Start.asTester
		.goToLoginpage()
		.loginToApplication(loginData.UserName, loginData.Password)
		._GoToHomePage()
		.atHomePage()
		//.clickOnExpress()
		.atExpressHomePage()	
		.startNewOrder()
		.verifyCreateOrderpage()
		._GoOrderPage()
		.selectDropDownValue(orderData.ProductFrom)
		.clickOnCreatNewOrder()
		._GoToHomePage()
		//Verifying Default Selection List
		.verifyListpage();
		
	}
	@Test(groups={"Default_Order_Type"}, description = "TS_DafaultOrderType_005:Verification default order selection in CNOM for multi aprpover")
	@Features("Default Order Type")
	@Stories("TS_DafaultOrderType_005:Verification default order selection in CNOM for multi aprpover")
	public void verifyDefaultListMultiApprover() {	
		
		LoginData loginData =LoginData.fetch("$MultiapproverUser1");
		OrderData orderdata=OrderData.fetch("$OrderData70");
		Start.asTester
		.goToLoginpage()
		.loginToApplication(loginData.UserName, loginData.Password)
		._GoToHomePage()
		.atHomePage()
		//.clickOnExpress()
		.atExpressHomePage()
		.startNewOrder()
		.verifyCreateOrderpage()
		._GoOrderPage()
		.selectDropDownValue(orderdata.ProductFrom)
		.clickOnSaveSetting()
		.clickOnCreatNewOrder()
		._GoToHomePage()
		.clickOnHomePageTab()
		.startNewOrder()
		//Verifying Default Selection List
		.verifyDefaultOrder(orderdata.ProductFrom);
		
	}
	@Test(groups={"Default_Order_Type"}, description = "TS_DafaultOrderType_006:Verification of List page loaded while clicking create new order as multi approver")
	@Features("Default Order Type")
	@Stories("TS_DafaultOrderType_006:Verification of List page loaded while clicking create new order as multi approver")
	public void verifyListPageMultiApprover() {	
		
		LoginData loginData =LoginData.fetch("$MultiapproverUser2");
		OrderData orderdata=OrderData.fetch("$OrderData70");
		Start.asTester
		.goToLoginpage()
		.loginToApplication(loginData.UserName, loginData.Password)
		._GoToHomePage()
		.atHomePage()
		//.clickOnExpress()
		.atExpressHomePage()	
		.startNewOrder()
		.verifyCreateOrderpage()
		._GoOrderPage()
		.selectDropDownValue(orderdata.ProductFrom)
		.clickOnCreatNewOrder()
		._GoToHomePage()
		//Verifying Default Selection List
		.verifyListpage();
	}
	@Test(groups={"Default_Order_Type"}, description = "TS_DafaultOrderType_007:Verification of default order type for Sales associate user")
	@Features("Default Order Type")
	@Stories("TS_DafaultOrderType_007:Verification of default order type for Sales associate user")
	public void verifyDefaultOrderGuide() {	
		
		LoginData loginData =LoginData.fetch("$SalesAssociateUser1");
		OrderData orderdata=OrderData.fetch("$OrderData71");
		Start.asTester
		.goToLoginpage()
		.loginToApplication(loginData.UserName, loginData.Password)
		._GoToHomePage()
		.atHomePage()
		//.clickOnExpress()
		.atExpressHomePage()
		.startNewOrder()
		.verifyCreateOrderpage()
		._GoOrderPage()
		.selectDropDownValue(orderdata.ProductFrom)
		.clickOnSaveSetting()
		.clickOnCreatNewOrder()
		._GoToHomePage()
		.clickOnHomePageTab()
		.startNewOrder()
		//Verifying Default Selection List
		.verifyDefaultOrder(orderdata.ProductFrom);
		
	}
	@Test(groups={"Default_Order_Type"}, description = "TS_DafaultOrderType_008:Verification of Order guide loaded while clicking create new order from CNOM (home page)")
	@Features("Default Order Type")
	@Stories("TS_DafaultOrderType_008:Verification of Order guide loaded while clicking create new order from CNOM (home page)")
	public void verifyOrderGuidePage() {	
		
		LoginData loginData =LoginData.fetch("$SalesAssociateUser2");
		OrderData orderdata=OrderData.fetch("$OrderData71");
		Start.asTester
		.goToLoginpage()
		.loginToApplication(loginData.UserName, loginData.Password)
		._GoToHomePage()
		.atHomePage()
		//.clickOnExpress()
		.atExpressHomePage()
		.startNewOrder()
		.verifyCreateOrderpage()
		._GoOrderPage()
		.selectDropDownValue(orderdata.ProductFrom)
		.clickOnCreatNewOrder()
		._GoToHomePage()
		//Verifying Default Selection List
		.verifyOrderGuidepage();
		
	}
}
