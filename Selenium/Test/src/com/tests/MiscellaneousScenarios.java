package com.tests;

import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

import com.components.entities.Start;
import com.components.testdata.LoginData;
import com.components.testdata.OrderData;
import com.iwaf.framework.Initiator;

public class MiscellaneousScenarios extends Initiator {
	@Test(groups={"Miscellaneous_Scenarios"}, description = "TS_GTIN_001:Verification of GTIN field at product card")
	@Features("Miscellaneous Scenarios")
	@Stories("TS_GTIN_001:Verification of GTIN field at product card")
	public void VerifyGTIN() {	
		
		LoginData loginData =LoginData.fetch("$Msnormal1");
		OrderData orderdata=OrderData.fetch("$OrderData72");
		Start.asTester
		.goToLoginpage()
		.loginToApplication(loginData.UserName, loginData.Password)
		._GoToHomePage()
		.atHomePage()
		//.clickOnExpress()
		.atExpressHomePage()
		._GoToHomePage()
		.enterAnyItemInSearchBox(orderdata.ItemName)
		.clickOnSearchButton()
		.clickOnPrduct(orderdata.UPC)
		.switchToProductInfoWindow()
		//Verify GTN number
		.verifyGTINNumber();
	}
	@Test(groups={"Miscellaneous_Scenarios"}, description = "TS_Product Card_001:Verification of Product card printing functionality")
	@Features("Miscellaneous Scenarios")
	@Stories("TS_Product Card_001:Verification of Product card printing functionality")
	public void VerifyPrintPreview() {	
		
		LoginData loginData =LoginData.fetch("$Msnormal2");
		OrderData orderdata=OrderData.fetch("$OrderData73");
		Start.asTester
		.goToLoginpage()
		.loginToApplication(loginData.UserName, loginData.Password)
		._GoToHomePage()
		.atHomePage()
		//.clickOnExpress()
		.atExpressHomePage()
		._GoToHomePage()
		.enterAnyItemInSearchBox(orderdata.ItemName)
		.clickOnSearchButton()
		.clickOnPrduct(orderdata.UPC)
		.switchToProductInfoWindow()
		.clickOnPrintProductInfo()
		.clickOnCancelPrintInProductInfo();
	}
	@Test(groups={"Miscellaneous_Scenarios"}, description = "TS_Product Card_002:Verification of item add from product card")
	@Features("Miscellaneous Scenarios")
	@Stories("TS_Product Card_002:Verification of item add from product card")
	public void VerifyItemsInOrder() {	
		String key="TS_Product Card_002";
		LoginData loginData =LoginData.fetch("$MsNormal3");
		OrderData orderdata=OrderData.fetch("$OrderData74");
		Start.asTester
		.goToLoginpage()
		.loginToApplication(loginData.UserName, loginData.Password)
		._GoToHomePage()
		.atHomePage()
		//.clickOnExpress()
		.atExpressHomePage()
		._GoToHomePage()
		.enterAnyItemInSearchBox(orderdata.ItemName)
		.clickOnSearchButton()
		.enterOrderQuantity(orderdata.UPC,orderdata.CaseQuantity)
		._GoOrderPage()
		.clickForPopup()
		._GoToHomePage()
		.verifyCreateOrderpage()
		._GoOrderPage()
		.enterOrderName(orderdata.OrderName)
		.clickOnCreatNewOrder()
		.orderPageTab()
		._GoToHomePage()
		.clickOnOpenOrderLink()
		.getOrderNumberByOrderName(orderdata.OrderName,key)
		.clickOnAnyOrder(key)
		.verifyValidItem(orderdata.UPC)
		.enterAnyItemInSearchBox(orderdata.ItemName)
		.clickOnSearchButton()
		.clickOnPrduct(orderdata.UPC)
		.switchToProductInfoWindow()
		.enterOrderQuantityInProductWindow(orderdata.CaseQuantity,orderdata.UPC)
	    .clickOnAddToOrderinProductWindow();
	}
	@Test(groups={"Miscellaneous_Scenarios"}, description = "Order submit_001:Verify whether the multibuyer user is able to create orders.")
	@Features("Miscellaneous Scenarios")
	@Stories("Order submit_001:Verify whether the multibuyer user is able to create orders.")
	public void CreateOrderMultiBuyer() {	
		LoginData loginData = LoginData.fetch("$multibuyer001");
		// create order data
		OrderData orderData = OrderData.fetch("$OrderData142");
		OrderData orderData1 = OrderData.fetch("$OrderData138");
		OrderData orderData2 = OrderData.fetch("$OrderData139");
		OrderData orderData3 = OrderData.fetch("$OrderData140");
		Start.asTester
				.goToLoginpage()
				.loginToApplication(loginData.UserName, loginData.Password)
				._GoToHomePage()
				.atHomePage()
				//.clickOnExpress()
				.atExpressHomePage()
				.entercustomerMA( loginData.Customer)
				.selectCustomerMA()
				.atExpressHomePage()
				.atExpressOrderingPage()
				.enterAnyItemInSearchBox(orderData.ItemName)
			    .clickOnSearchButton()
			    .iteminsearchbox4( orderData.UPC , orderData.CaseQuantity )
			    ._GoOrderPage()
			    .clickForPopup()
			    .enterOrderName(orderData.OrderName)
			    .clickOnCreatNewOrder()
			    ._GoToHomePage()
			    .iteminsearchbox4( orderData1.UPC , orderData1.CaseQuantity )
			    .iteminsearchbox4( orderData2.UPC , orderData2.CaseQuantity )
			    .iteminsearchbox4( orderData3.UPC , orderData3.CaseQuantity )
			    ._GoOrderPage()
				.clickOnViewOrder()
				.clickSubmitOrder()
				.clickOrderReminderSubmitNormal()
				//.verifyAndConfirmOrder()
		         .clickOnAcknowledgementButton();
	}
	@Test(groups={"Miscellaneous_Scenarios"}, description = "Order submit_001:Verify whether the Multi approver user is able to create orders.")
	@Features("Miscellaneous Scenarios")
	@Stories("Order submit_002:Verify whether the Multi approver user is able to create orders.")
	public void CreateOrderMultiapprover() {	
		LoginData loginData = LoginData.fetch("$multiapp001");
		// create order data
		OrderData orderData = OrderData.fetch("$OrderData141");
		OrderData orderData1 = OrderData.fetch("$OrderData138");
		OrderData orderData2 = OrderData.fetch("$OrderData139");
		OrderData orderData3 = OrderData.fetch("$OrderData140");
		Start.asTester
				.goToLoginpage()
				.loginToApplication(loginData.UserName, loginData.Password)
				._GoToHomePage()
				.atHomePage()
				//.clickOnExpress()
				.atExpressHomePage()
				.atExpressOrderingPage()
				.enterAnyItemInSearchBox(orderData.ItemName)
			    .clickOnSearchButton()
			    .iteminsearchbox4( orderData.UPC , orderData.CaseQuantity )
			    ._GoOrderPage()
			    .clickForPopup()
			    .enterOrderName(orderData.OrderName)
			    .clickOnCreatNewOrder()
			    ._GoToHomePage()
			    .iteminsearchbox4( orderData1.UPC , orderData1.CaseQuantity )
			    .iteminsearchbox4( orderData2.UPC , orderData2.CaseQuantity )
			    .iteminsearchbox4( orderData3.UPC , orderData3.CaseQuantity )
			    ._GoOrderPage()
				.clickOnViewOrder()
				.clickSubmitOrder()
				.clickOrderReminderSubmitNormal()
				.verifyAndConfirmOrder();
	}
	@Test(groups={"Miscellaneous_Scenarios","SauceLabSmoke"}, description = "Order submit_003:Verify whether the Sales associate  user is able to create orders.")
	@Features("Miscellaneous Scenarios")
	@Stories("Order submit_003:Verify whether the Sales associate  user is able to create orders.")
	public void CreateOrderSalesAssociate() {	
		LoginData loginData = LoginData.fetch("$orderMA");
		// create order data
		OrderData orderData = OrderData.fetch("$OrderData144");
		OrderData orderData1 = OrderData.fetch("$OrderData138");
		OrderData orderData2 = OrderData.fetch("$OrderData139");
		OrderData orderData3 = OrderData.fetch("$OrderData140");
		Start.asTester
				.goToLoginpage()
				.loginToApplication(loginData.UserName, loginData.Password)
				._GoToHomePage()
				.atHomePage()
				//.clickOnExpress()
				.atExpressHomePage()
				.entercustomerMA( loginData.Customer)
				.selectCustomerMA()
				.atExpressHomePage()
				.atExpressOrderingPage()
				.enterAnyItemInSearchBox(orderData.ItemName)
			    .clickOnSearchButton()
			    .iteminsearchbox4( orderData.UPC , orderData.CaseQuantity )
			    ._GoOrderPage()
			    .clickForPopup()
			    .enterOrderName(orderData.OrderName)
			    .clickOnCreatNewOrder()
			    ._GoToHomePage()
			    .iteminsearchbox4( orderData1.UPC , orderData1.CaseQuantity )
			    .iteminsearchbox4( orderData2.UPC , orderData2.CaseQuantity )
			    .iteminsearchbox4( orderData3.UPC , orderData3.CaseQuantity )
			    ._GoOrderPage()
				.clickOnViewOrder()
				.clickSubmitOrder()
				.clickOrderReminderSubmitNormal()
				.verifyAndConfirmOrder();
	}
	@Test(groups={"Miscellaneous_Scenarios"}, description = "TS_SME_Source code_005:Verify whether the source code is showing as 'Express' in source column .")
	@Features("Miscellaneous Scenarios")
	@Stories("TS_SME_Source code_005:Verify whether the source code is showing as 'Express' in source column .")
	public void SourceCodeVerification() {	
		
		LoginData loginData =LoginData.fetch("$MsNormal4");
		OrderData orderdata_001=OrderData.fetch("$OrderData81");
		Start.asTester
		.goToLoginpage()
		.loginToApplication(loginData.UserName, loginData.Password)
		._GoToHomePage()
		.atHomePage()
		//.clickOnExpress()
		.atExpressHomePage()
		.startNewOrder()
		._GoOrderPage()
		.selectTypeFromDropDown(orderdata_001.ProductFrom)
		.clickOnCreatNewOrder()
		.orderPageTab()
		.verifyOrderPage()
		._GoToHomePage()
		//Verifying Source Column against All Order
		.clickOnOpenOrderLink()
		.verifySourceColumnOpenOrder()
		._GoOrderPage()
		.orderPageTab()
		._GoToHomePage()
		.clickOnSubmittedOrdersLink()
		.verifySourceColumnRecentOrder()
		._GoOrderPage()
		.orderPageTab()
		._GoToHomePage()
		.clickOnCancelledOrder()
		.verifySourceColumnHistoricalOrder();
	}
	@Test(groups={"Miscellaneous_Scenarios"}, description = "TS_Order_Running_Total-001:Verification of Order total at active order section after creating order from List")
	@Features("Miscellaneous Scenarios")
	@Stories("TS_Order_Running_Total-001:Verification of Order total at active order section after creating order from List")
	/*public void VerifyQuantityAndPrice() {	
		String key="TS_Order_Running_Total-001";
		LoginData loginData =LoginData.fetch("$MsNormal5");
		OrderData orderdata_001=OrderData.fetch("$OrderData82");
		OrderData orderdata_002=OrderData.fetch("$OrderData83");
		Start.asTester
		.goToLoginpage()
		.loginToApplication(loginData.UserName, loginData.Password)
		._GoToHomePage()
		.atHomePage()
		//.clickOnExpress()
		.atExpressHomePage()
		//Creating List 
		._GoToOrdeGuidePage()
		.clickOnOrderGuideTab()
		.checkMultipleItem(orderdata_001.UPC.split(";"))
		._GoToListPage()
		.clickOnAddToList()
		.clickOnCreateNewListLink()
		.enterListName(key)
		.clickOnCreatNewListInAddListPopup()
		.clickOnListTab()
		.clickOnMyListLink()
		.getListNumberByListName(key)
		._GoOrderPage()
		.orderPageTab()
		._GoToHomePage()
		//Creating Order From List
		.startNewOrder()
		._GoOrderPage()
		.selectTypeFromDropDown(orderdata_001.ProductFrom)
		.clickOnCreatNewOrder()
		._GoToListPage()
		.clickOnMyListLink()
		.clickOnAnyListNumber(key)
		.checkItemsFromLists(orderdata_001.UPC.split(";"))
		.enterQuantityListMultiple(orderdata_001.UPC.split(";"), orderdata_001.CaseQuantity.split(";"))
		.clickOnViewOrder()
		._GoToHomePage()
		//Verifying Quantity In Active Order Section
		.verifyQunatityActiveOrder(orderdata_001.CaseQuantity.split(";"))
		._GoToHomePage()
		//Search For The Item
		.enterAnyItemInSearchBox(orderdata_001.ItemName)
		.clickOnSearchButton()
		._GoToListPage()
		.checkOnItem(orderdata_002.UPC.split(";"))
		.enterQuantitySearchMultiple(orderdata_002.UPC.split(";"), orderdata_002.CaseQuantity.split(";"))
		.clickOnViewOrder()
		._GoToHomePage()
		//Verifying Updated Quantity In Active Order Section
		.verifyQunatityActiveOrder(orderdata_002.CaseQuantity.split(";"));*/
		public void VerifyQuantityAndPrice() {
		
		LoginData loginData = LoginData.fetch("$normaluser001");
		// create order data
		OrderData orderData = OrderData.fetch("$OrderData137");
		OrderData orderData1 = OrderData.fetch("$OrderData138");
		OrderData orderData2 = OrderData.fetch("$OrderData139");
		//OrderData orderData3 = OrderData.fetch("$OrderData140");
		Start.asTester
				.goToLoginpage()
				.loginToApplication(loginData.UserName, loginData.Password)
				._GoToHomePage()
				.atHomePage()
				//.clickOnExpress()
				.atExpressHomePage()
				.atExpressOrderingPage()
				.enterAnyItemInSearchBox(orderData.ItemName)
			    .clickOnSearchButton()
			    .iteminsearchbox4( orderData.UPC , orderData.CaseQuantity )
			    ._GoOrderPage()
			    .clickForPopup()
			    .enterOrderName(orderData.OrderName)
			    .clickOnCreatNewOrder()
			    ._GoToHomePage()
			    .iteminsearchbox4( orderData1.UPC , orderData1.CaseQuantity )
			    .iteminsearchbox4( orderData2.UPC , orderData2.CaseQuantity )
			    .iteminsearchbox4( orderData2.UPC , orderData2.CaseQuantity )
			    ._GoOrderPage()
				.clickOnViewOrder()
				._GoToHomePage()
				.activeordersectionverification();
	}
	
	@Test(groups={"Miscellaneous_Scenarios"}, description = "TS_Order_Running_Total-002:Verification of Order total at active order section while reordering an order")
	@Features("Miscellaneous Scenarios")
	@Stories("TS_Order_Running_Total-002:Verification of Order total at active order section while reordering an order")
	public void VerifyTotalQuantityAndPriceHistoricalOrder() {	
		String key="TS_Order_Running_Total-002";
		LoginData loginData =LoginData.fetch("$MsNormal6");
		OrderData orderdata_001=OrderData.fetch("$OrderData84");
		OrderData orderdata_002=OrderData.fetch("$OrderData85");
		String key2=loginData.UserName;
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
		.selectTypeFromDropDown(orderdata_001.ProductFrom)
		.clickOnCreatNewOrder()
		._GoToHomePage()
		.verifyHistoricalOrderPage()
		//Getting  One Historical Order Number From DB
		.getOrderNumberFromDataBase('C',key,loginData.Customer)
		.clickOnAnyOrder(key)
		._GoToHistoricalOrderPage()
		//Click On reorder
		.clickOnReOrder()
		._GoToHomePage()
		//Getting UPC,Quantity And Total Price From DB
		//.getOrderDetails(key)
		//Verifying Total Price And Total Quantity
		.validateTotalPriceHistoricalOrder()
		.validateQunatityHistoricalOrders(key2)
		.clickOnQuickOrderEntry()
		._GoOrderPage()
		//Adding one more Item to the Order
		.enterQuickOrderEntryDetails(orderdata_001.UPC,orderdata_001.CaseQuantity,orderdata_001.SplitQuantity)
		._GoToOrdeGuidePage()
		//Verifying If The Item Is Added
		.validateUPC(orderdata_001.UPC)
		._GoToHomePage()
		//Verify Quantity After Quick Order
		.verifyUpdatedQuantity(orderdata_001.CaseQuantity,key2)
		//Adding Items By searching The Item
		.enterAnyItemInSearchBox(orderdata_002.ItemName)
		.clickOnSearchButton()
		.enterOrderQuantity(orderdata_002.UPC, orderdata_002.CaseQuantity)
		._GoOrderPage()
		.clickForPopup()
		.clickOnViewOrder()
		._GoToHomePage()
		//Verifying Quantity After Search
		.verifyUpdatedQuantity(orderdata_002.CaseQuantity,key2)
		._GoOrderPage()
		.clickSubmitOrder()
		.clickOrderReminderSubmitNormal()
		.clickOnAcknowledgementButton();
		
		;
	}
}
