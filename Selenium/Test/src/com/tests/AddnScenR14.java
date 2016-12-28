package com.tests;

//import org.apache.commons.lang3.RandomStringUtils;
import java.awt.AWTException;

import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

import com.components.entities.Start;
import com.components.testdata.LoginData;
import com.components.testdata.OrderData;
import com.iwaf.framework.Initiator;

public class AddnScenR14 extends Initiator{
	@Test(groups={"AddnScenR14"}, description = "TS_SME_Custom_Lists_Togglev5_003_005 : Verify whether the user is able to share a list to a particular user")
	@Features("AddnScenR14")
	@Stories("TS_SME_Custom_Lists_Togglev5_003_005 : Verify whether the user is able to share a list to a particular user")
	public void ShareAndVerfiySharedListPermissionMB() {	
		
		LoginData loginData1 =LoginData.fetch("$R14MBUser1");
		LoginData loginData2 =LoginData.fetch("$R14MBUser2");
		OrderData orderData_001 =OrderData.fetch("$OrderData121");
		OrderData orderData_002 =OrderData.fetch("$OrderData122");
		
		String key = "Togglev5_003_005";
		Start.asTester
			.goToLoginpage()
			.loginToApplication(loginData1.UserName, loginData1.Password)
			._GoToHomePage()
			.atHomePage()
			.clickOnExpress()
			.atExpressHomePage()
			//Create a List
			.enterAnyItemInSearchBox(orderData_001.ItemName)
			.clickOnSearchButton()
			._GoOrderPage()
			.checkOnItem(orderData_001.UPC.split(";"))
			._GoToListPage()
			.clickOnAddToList()
			.clickOnCreateNewListLink()
			.enterListName(key)
			.clickOnCreatNewListInAddListPopup()
			//Share List from MyLsit
			.clickOnListTab()
			.clickOnMyListLink()
			.getListNumberByListName(key)
			.clickOnAnyListNumber(key)			
			.shareListWithUser(loginData2.UserName,"A")	
			._GoOrderPage()
			.close()
			//login as the other user and select the shared list
			._atLoginPage()
			.loginToApplication(loginData2.UserName, loginData2.Password)
			._GoToHomePage()
			.atHomePage()
			.clickOnExpress()
			.atExpressHomePage()
			._GoToListPage()
			.clickOnListTab()
			.clickOnShareListLink()
			.clickOnAnyListNumber(key)
			//add new item
			._GoToHomePage()
			.enterAnyItemInSearchBox(orderData_002.ItemName)
			.clickOnSearchButton()
			._GoToListPage()
			.checkOnItem(orderData_002.UPC.split(";"))			
			.clickOnAddToList()
			.clickOnExistingList(key)
			.clickOnConform()
			//verify item added
			.clickOnListTab()
			.clickOnShareListLink()
			.clickOnAnyListNumber(key)
			.verifyItemsInList(orderData_002.UPC)
			.clickOnEditList()
			.selectAllListInEditList()
			.verifyDeleteItemEnabled()
			.clickOnSaveList()
			;
	}
	/*
	@Test(groups={"test"}, description = "TS_order_confirmation email _change_001 : Verification of e email confirmation message for SME (Normal user) ")
	@Features("AddnScenR14")
	@Stories("TS_order_confirmation email _change_001 : Verification of e email confirmation message for SME (Normal user) ")
	public void VerifyOrderConfirmationMail() {	
		
		LoginData loginData =LoginData.fetch("$MultiApprMA16");
		OrderData orderData_001 =OrderData.fetch("$OrderData123");
		
		Start.asTester
		.goToLoginpage()
		.loginToApplication(loginData.UserName, loginData.Password)
		._GoToHomePage()
		.atHomePage()
		.clickOnExpress()
		.atExpressHomePage()
		.atExpressOrderingPage()
		._GoOrderPage()
		.orderPageTab()
		.verifyOrderPage()
		._GoToHomePage()
		.startNewOrder()
		._GoOrderPage()
		.atCreateOrderPage()
		.selectTypeFromDropDown(orderData_001.ProductFrom)
		.clickOnCreatNewOrder()
		.atQuickOrderEntryPagePopUp()
		.enterQuickOrderEntryDetailsWithoutAdd(orderData_001.UPC.split(";"),orderData_001.CaseQuantity.split(";"),orderData_001.SplitQuantity.split(";"))
		.clickOnAddToOrderInQuickOrder()
		.verifyOrderlandingPage()
		.clickSubmitOrder()
		.clickOrderReminderSubmitNormal()
		.verifyAndConfirmOrder()		
		.close()
		._GoToHomePage()
		.connectToUrl("http://outlook.com/sysco.com")		
		;
	}
	*/
	@Test(groups={"AddnScenR14"}, description = "TS_SME_New Customer Express Only_001:Verify wheher only sysco market express is present while creating new users")
	@Features("AddnScenR14")
	@Stories("TS_SME_New Customer Express Only_001:Verify wheher only sysco market express is present while creating new users")
	public void user_Creation_001() {	
		
		LoginData loginData =LoginData.fetch("$AdminNew");	
		//OrderData orderData = OrderData.fetch("$QuickISRHA");
		
		//*************change description
		Start.asTester
		.goToLoginpage()
		.loginToApplication(loginData.UserName, loginData.Password)
		._GoToHomePage()
		.atHomePage()
		._GoIFGPage()
		.ClikonEsysco()
		.Enter_Opco(loginData.OpCo)
		.clickOnActiveCustomer()
		.selectCustomer(loginData.Customer)
		.verifySMXOnly()
		;
	}
	@Test(groups={"AddnScenR14"}, description =  "TS_Defect_002 : Verify whether the user is not able to enter double decimals while hand pricing an item")
	@Features("AddnScenR14")
	@Stories("TS_Defect_002 :Verify whether the user is not able to enter double decimals while hand pricing an item")
	public void TS_Defect_002 (){	
		
		LoginData loginData =LoginData.fetch("$SALES001");	
		OrderData orderData=OrderData.fetch("$HandPriceOrderData");
		
		Start.asTester
		.goToLoginpage()
		.loginToApplication(loginData.UserName, loginData.Password)
		._GoToHomePage()
		.atHomePage()
		.clickOnExpress()
		.atExpressHomePage()
		._GoItemDeletePage()
		.clickOnOrderGuide()
		._GoToOrdeGuidePage()
		.validatePriceColumn()
		.enterTypeInSearchBox(orderData.UPC)
		.validatePriceColumn()
		._GoItemDeletePage()
		.UpdateOrderGuideItemPrice(orderData.UPC, orderData.UpdatePrice)
		;
		
	
	}
	@Test(groups = { "AddnScenR14" }, description = "Verify whether order is getting submitted if the MA user select Off day as Delivery date")
	@Features("AddnScenR14")
	@Stories("TS_SME_MA Persona –Core Functionality_006:Verify whether order is getting submitted if the MA user select Off day as Delivery date")
	public void OffdayOrderBySalesAssociate() {
		// create sales-associate login user
		LoginData loginData = LoginData.fetch("$SalesAssociateUser3");
		// create order data
		OrderData orderData = OrderData.fetch("$OrderData126");

		Start.asTester
				.goToLoginpage()
				.loginToApplication(loginData.UserName, loginData.Password)
				._GoToHomePage()
				.atHomePage()
				.clickOnExpress()
				.atExpressHomePage()
				.startNewOrder()
				._GoOrderPage()
				.selectTypeFromDropDown(orderData.ProductFrom)
				.clickOnCreatNewOrder()
				._GoToOrdeGuidePage()
				.atOrderGuidePage()
				.enterOrderQuantity(orderData.UPC.split(";"),
						orderData.CaseQuantity.split(";"))
				.checkMultipleItem(orderData.UPC.split(";"))
				._GoOrderPage()
				.clickOnViewOrder()
				.clickOnShippingTab()
				.selectOffDay()
				._GoItemDeletePage()
				.reValidateAlert()
				._GoOrderPage()
				.clickSubmitOrder()
				.clickOrderReminderSubmitNormal()
				.verifyAndConfirmOrder();
	}
	
	@Test(groups = { "AddnScenR14" }, description = "Verify whether the required DB files are getting updated after modifying an order from e sysco")
	@Features("AddnScenR14")
	@Stories("TS_OrderResponse_002:Verify whether the required DB files are getting updated after modifying an order from e sysco")
	public void VerifySubmittedOrderModify() throws AWTException {
		// create login user
		// LoginData loginData = LoginData.fetch("$OMUser26");
		LoginData loginData = LoginData.fetch("$NormalUser25");
		// create order data
		OrderData orderData = OrderData.fetch("$OrderData22");
		String strKeyOrder = loginData.UserName;
		System.out.println("Login_data and Order_data are ready");

		Start.asTester
		.goToLoginpage()
		.loginToApplication(loginData.UserName, loginData.Password)
		._GoToHomePage()
		.atHomePage()
		.clickOnExpress()
			.atExpressHomePage()
			.atExpressOrderingPage()
			._GoOrderPage()
			.orderPageTab()
			.verifyOrderPage()
			._GoToHomePage()
			.startNewOrder()
			.verifyCreateOrderpage()
			._GoOrderPage()
			//Creating order
			.selectTypeFromDropDown("Quick Order Entry")
			.clickOnCreatNewOrder()
			// Adding items and creating order through QOE
			.enterQuickOrderEntryDetailsWithoutAdd(orderData.UPC.split(";"),orderData.CaseQuantity.split(";"),orderData.SplitQuantity.split(";"))
			.clickOnAddToOrderInQuickOrder()
			._GoToHomePage()
			.getTextOrderNumber(strKeyOrder)
			._GoOrderPage()
			//Submitting the order
			.clickSubmitOrder()
			.clickOrderReminderSubmitNormal()
			.verifyAndConfirmOrder()
			.orderPageTab()
			.orderPageTab()
			._GoToHomePage()
			.clickOnSubmittedOrdersLink()
			.clickOnAnyOrder(strKeyOrder)
			//Modifying the submitted order
			.clickOnModifyInSubmittedOrder()
			.acceptAlert_Modify()
			.clickOnQuickOrderEntry()
			._GoOrderPage()
			.enterQuickOrderEntryDetailsWithoutAdd(orderData.UPC.split(";"),orderData.CaseQuantity.split(";"),orderData.SplitQuantity.split(";"))
			.clickOnAddToOrderInQuickOrder()
			.changeOrderQuantity(orderData.UPC, orderData.CaseQuantity)
			.clickToDeleteOneLine(orderData.UPC)
			.selectDeliveryDateAfterModify()
			.clickSubmitOrder()
			.clickOrderReminderSubmitNormal()
			.verifyAndConfirmOrder()
			._GoToHomePage()
			//Validating total price
			.getTotalOrderFromDB(strKeyOrder,loginData.Customer)
			.validateTotalPrice(strKeyOrder)
			._GoOrderPage()
			.close();
	}

	//@Test(groups = { "AddnScenR14" }, description = "Verify whether the Admin user is able to do Mass setup for MA users on clicking import button in create new user page.")
	//@Features("AddnScenR14")
	//@Stories("TS_MA_Access_TS_001:Verify whether the Admin user is able to do Mass setup for MA users on clicking import button in create new user page.")
	//public void CreateNewMultiApproverUser() {
		// create sales-associate login user
	//	LoginData loginData = LoginData.fetch("$AdminNew");
		//String usertype = "MULTIAPPROVER";
		// password = "sysco123";
//
		//Start.asTester.goToLoginpage()
		//		.loginToApplication(loginData.UserName, loginData.Password)
		//		._GoToHomePage().atHomePage()._GoIFGPage().ClikonEsysco()
		//		.Enter_Opco(loginData.OpCo).clickOnActiveCustomer()
		//		.selectCustomer(loginData.Customer)
		//		.createNewUser(usertype).clickLogOut()
		//		.firstloginNewISRUser().change_password(password)
		//		.selectSecurityQuestions()
		//		.selectSecurityQuestionsAnswers(password).click_submit();
//}
	@Test(groups = { "AddnScenR14" }, description = "Verify whether the new Gluten free disclaimer is present in product card")
	@Features("AddnScenR14")
	@Stories("TS_SME_Gluten-Free_disclaimer_001: Verify whether the new Gluten free disclaimer is present in product card")
	public void VerifyGlutenFreeDisclaimer() {
		// create login user
		LoginData loginData_MUser = LoginData.fetch("$OMUser26");
		// create order data
		OrderData orderData_124 = OrderData.fetch("$OrderData125");
		System.out.println("login_data is ready");

		Start.asTester
				.goToLoginpage()
				.loginToApplication(loginData_MUser.UserName,
						loginData_MUser.Password)._GoToHomePage().atHomePage()
				.clickOnExpress().atExpressHomePage()._GoToOrdeGuidePage()
				.atOrderGuidePage().clickOnOrderGuideTab()._GoToHomePage()
				.atHomePage().clickOnPrduct(orderData_124.UPC)
				.switchToProductInfoWindow()._GoToProductCatalog()
				.clickOnNutritionTab().mouseHoverOnDisclaimer()
				.VerifyGlutenFreeDisclaimer();
	}

}
