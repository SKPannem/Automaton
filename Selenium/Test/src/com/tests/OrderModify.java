package com.tests;

import java.awt.AWTException;

import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

import com.components.entities.Start;
import com.components.testdata.LoginData;
import com.components.testdata.OrderData;
import com.iwaf.framework.Initiator;

public class OrderModify extends  Initiator {	
	@Test(groups={"Order_Modify"}, description = "Order Entry Submit_001 :Verification of order modification by adding a line , increasing qty , decreasing qty , deleting a line & validate order total")
	@Features("Order Modify")
	@Stories("Order Entry Submit_001 : Verification of order modification by adding a line , increasing qty , decreasing qty , deleting a line & validate order total")
	public void modifySubmittedOrder() throws AWTException {
		LoginData loginData =LoginData.fetch("$OMUser34");
		OrderData orderData_BeforeModify = OrderData.fetch("$OrderData22");
		OrderData orderData_AfterModify = OrderData.fetch("$ModifyItem");
		
		String strKeyOrder="Order_Entry_Submit_00_OrderNumber";
        System.out.println("Login_data and Order_data are ready");
        
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
		.selectTypeFromDropDown(orderData_BeforeModify.ProductFrom)
		.clickOnCreatNewOrder()
	    //Adding items and creating order through QOE
	    .enterQuickOrderEntryDetailsWithoutAdd(orderData_BeforeModify.UPC.split(";"),orderData_BeforeModify.CaseQuantity.split(";"),orderData_BeforeModify.SplitQuantity.split(";"))
	    .clickOnAddToOrderInQuickOrder()
	    ._GoToHomePage()
		 .getTextOrderNumber(strKeyOrder)
		 ._GoOrderPage()
		.clickSubmitOrder()
		.clickOrderReminderSubmitNormal()
		.verifyAndConfirmOrder()
		.orderPageTab()
		._GoToHomePage()
		.clickOnSubmittedOrdersLink()
		 .clickOnSubmittedOrder(strKeyOrder)
		 .clickOnModifyInSubmittedOrder()
		 .acceptAlert_Modify()
		 .clickOnQuickOrderEntry()
		 ._GoOrderPage()
		 .enterQuickOrderEntryDetailsWithoutAdd(orderData_AfterModify.UPC.split(";"),orderData_AfterModify.CaseQuantity.split(";"), orderData_AfterModify.SplitQuantity.split(";"))
         .clickOnAddToOrderInQuickOrder()
		 .changeOrderQuantity(orderData_BeforeModify.UPC, orderData_BeforeModify.CaseQuantity)
		    //.changeOrderQuantity(orderData.UPC, orderData.CaseQuantity)
		 .clickToDeleteOneLine(orderData_BeforeModify.UPC)
		 .selectDeliveryDateAfterModify()
		 .clickSubmitOrder()
		 .clickOrderReminderSubmitNormal()
		 .verifyAndConfirmOrder()
		 ._GoToHomePage()
		 .getTotalOrderFromDB(strKeyOrder,loginData.Customer)
		 .validateTotalPrice(strKeyOrder)
		 ._GoOrderPage()
		 .close();
		 } 
	@Test(groups={"Order_Modify"}, description = "Order Entry Submit_002 : Veriofication of order modification by adding items to order from quick order entry , lists , og , product sreach , product catalog ,etc & validate order total")
	@Features("Order Submit")
	@Stories("Order Entry Submit_002 : Veriofication of order modification by adding items to order from quick order entry , lists , og , product sreach , product catalog ,etc & validate order total")
	public void AddItemsFromAll() {	
		
		
		LoginData loginData =LoginData.fetch("$OMUser29");
		OrderData orderData_001 = OrderData.fetch("$OrderData109");
		OrderData orderData_002 = OrderData.fetch("$OrderData112");
		OrderData orderData_003 = OrderData.fetch("$OrderData113");
		OrderData orderData_004 = OrderData.fetch("$OrderData114");
		OrderData orderData_005 = OrderData.fetch("$OrderData115");
		
		String key1="Order Entry Submit_002_01";
		String key=loginData.UserName;
		
		String data=orderData_005.ItemName;
	    String[] arrData=data.split(";");
       
	    OrderData orderData_01=OrderData.fetch("$OrderData33");
		//OrderData orderData_02=OrderData.fetch("$OrderData34");
		String strKeyOrder="Order Entry Submit_002_02";
		
		Start.asTester
			.goToLoginpage()
			.loginToApplication(loginData.UserName, loginData.Password)
			._GoToHomePage()
			.atHomePage()
			//.clickOnExpress()
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
				.enterQuickOrderEntryDetailsWithoutAdd(orderData_01.UPC.split(";"),orderData_01.CaseQuantity.split(";"),orderData_01.SplitQuantity.split(";"))
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
				//Making Order to moved into delivered status
				.orderToDeliveredStatus(strKeyOrder)
				//Login to same user 
				.close()
			._atLoginPage()
			.loginToApplication(loginData.UserName, loginData.Password)
			._GoToHomePage()
			.atHomePage()
			//.clickOnExpress()
			.atExpressHomePage()
			.atExpressOrderingPage()
			//Creating List
			._GoToListPage()
			.clickOnListTab()
			.clickOnCreateNewList()
			.enterListNameInPopup(key)
			.clickOnCreateList()
			.clickOnListTab()
			._GoToHomePage()
			.verifyListpage()
			._GoToListPage()
			.clickOnMyListLink()
			.getListNumberByListName(key)
			._GoToHomePage()
			//Adding Items to List
			.enterAnyItemInSearchBox(orderData_002.ItemName)
			.clickOnSearchButton()
			._GoToListPage()
			.checkOnItem(orderData_002.UPC.split(";"))
			.clickOnAddToList()
			.clickOnExistingList(key)
			.clickOnConform()
			._GoOrderPage()
		    .orderPageTab()
		    .verifyOrderPage()
		    ._GoToHomePage()
			.clickOnSubmittedOrdersLink()
			.clickOnAnyOrder(strKeyOrder)
			.clickOnModifyInSubmittedOrder()
			.acceptAlert_Modify()
			.getTotalQuantityAfterModify(key1)
			.clickOnQuickOrderEntry()
			._GoOrderPage()
			//Adding Items From Quick Order Entry
            .enterQuickOrderEntryDetailsWithoutAdd(orderData_001.UPC.split(";"),orderData_001.CaseQuantity.split(";"), orderData_001.SplitQuantity.split(";"))
            .clickOnAddToOrderInQuickOrder()
         
            ._GoToHomePage()
            .getUpdatedQuantity(key1, orderData_001.CaseQuantity.split(";"))
            //Adding Items From List
            .clickOnGoToList()
            ._GoToListPage()
            .clickOnMyListLink()
            .clickOnAnyListNumber(key)
            .enterQuantityListMultiple(orderData_002.UPC.split(";"),orderData_002.CaseQuantity.split(";"))
            .clickOnViewOrder()
            ._GoToHomePage()
            .getUpdatedQuantity(key1, orderData_002.CaseQuantity.split(";"))
            //Adding Items From OrderGuide
            .clickOnGoToOrderGuide()
            ._GoToOrdeGuidePage()
            .checkMultipleItem(orderData_003.UPC.split(";"))
            .enterOrderQuantity(orderData_003.UPC.split(";"),orderData_003.CaseQuantity.split(";"))
            .clickOnViewOrder()
            ._GoToHomePage()
            .getUpdatedQuantity(key1, orderData_003.CaseQuantity.split(";"))
            //Adding Items By Search
            .enterAnyItemInSearchBox(orderData_004.ItemName)
			.clickOnSearchButton()
			.enterOrderQuantity(orderData_004.UPC, orderData_004.CaseQuantity)
			._GoToListPage()
			.clickOnViewOrder()
			._GoToHomePage()
			.getUpdatedQuantity(key1, orderData_004.CaseQuantity.split(";"))
			//Adding Items From Product Catalog
			._GoToProductCatalog()
			.clickOnProductTab()
			.clickOnProductCategory(arrData[0])
	        .clickOnSubCategory(arrData[1])
	        .clickOnSelectedItem(arrData[2])
	        ._GoToListPage()
	        .enterQuantitySearchMultiple(orderData_005.UPC.split(";"),orderData_005.CaseQuantity.split(";"))
	        .clickOnViewOrder()
	        ._GoToHomePage()
	        .getUpdatedQuantity(key1, orderData_005.CaseQuantity.split(";"))
	        ._GoOrderPage()
	        .selectDeliveryDateAfterModify()
	        .clickSubmitOrder()
	        .clickOrderReminderSubmitNormal()
	        .verifyAndConfirmOrder()
	        ._GoToHomePage()
	        .getTotalOrderFromDB(strKeyOrder,loginData.Customer)
	        .validateTotalPriceAfterModify(strKeyOrder);
	} 
	@Test(groups={"Order_Modify"}, description = "Order Entry Submit_027_03 : Modify The Order which are modified by another user ")
	@Features("Order Modify")
	@Stories("Order Entry Submit_027_03 : Modify The Order which are modified by another user")
	public void modifyOrderByAnotherUser() {	
		String key="Order Entry Submit_027_03";
		LoginData loginData1 =LoginData.fetch("$OMUser6");
		LoginData loginData2 =LoginData.fetch("$OMUser7");
		OrderData orderData1 = OrderData.fetch("$OrderData72");
		OrderData orderData2 = OrderData.fetch("$OrderData69");
        System.out.println("Login_data and Order_data are ready");
		Start.asTester
		    .goToLoginpage()
	         .loginToApplication(loginData1.UserName, loginData1.Password)
	         ._GoToHomePage()
	        .atHomePage()
	        //.clickOnExpress()
	        .startNewOrder()
	        ._GoOrderPage()
	        .selectTypeFromDropDown(orderData1.ProductFrom)
	        .clickOnCreatNewOrder()
	        .enterQuickOrderEntryDetailsWithoutAdd(orderData1.UPC.split(";"), orderData1.CaseQuantity.split(";"),orderData1.SplitQuantity.split(";"))
	        .clickOnAddToOrderInQuickOrder()
	        ._GoToHomePage()
	        .getTextOrderNumber(key)
	        ._GoOrderPage()
	         .close()
			._atLoginPage()
			.loginToApplication(loginData2.UserName,loginData2.Password)
			._GoToHomePage()
			.atHomePage()
			//.clickOnExpress()
			.atExpressHomePage()
			.atExpressOrderingPage()
			._GoOrderPage()
		    .orderPageTab()
		    .verifyOrderPage()
		    ._GoToHomePage()
		    .clickOnOpenOrderLink()
			.clickOnAnyOrder(key)
			.clickOnQuickOrderEntry()
			._GoOrderPage()
            .enterQuickOrderEntryDetailsWithoutAdd(orderData2.UPC.split(";"),orderData2.CaseQuantity.split(";"), orderData2.SplitQuantity.split(";"))
            .clickOnAddToOrderInQuickOrder()
            ._GoToHomePage()
            .clickOnDeleteItem()
            ._GoOrderPage()
            .clickSubmitOrder()
            .clickOrderReminderSubmitNormal()
            .verifyAndConfirmOrder()
            ._GoToHomePage()
            .validateUserDB(loginData2.UserName,key);
			
	}
    @Test(groups={"Order_Modify"}, description = "Order Entry Submit_016 : Modify The Order which are modified by another user ")
	@Features("Order Modify")
	@Stories("Order Entry Submit_016 : Modify The Order which are modified by another user")
	public void verifyModify() {	
		String key="Order Entry Submit_016";
		LoginData loginData1 =LoginData.fetch("$OMUser6");
		LoginData loginData2 =LoginData.fetch("$OMUser6");
		//String key2=loginData1.UserName;
		//String key3=loginData2.UserName;
		OrderData orderData = OrderData.fetch("$OrderData72");
        System.out.println("Login_data and Order_data are ready");
		Start.asTester
		    .goToLoginpage()
	         .loginToApplication(loginData1.UserName, loginData1.Password)
	         ._GoToHomePage()
	        .atHomePage()
	        //.clickOnExpress()
	        .startNewOrder()
	        ._GoOrderPage()
	        .selectTypeFromDropDown(orderData.ProductFrom)
	        //Creating Order
	        .clickOnCreatNewOrder()
	        .enterQuickOrderEntryDetailsWithoutAdd(orderData.UPC.split(";"), orderData.CaseQuantity.split(";"),orderData.SplitQuantity.split(";"))
	        .clickOnAddToOrderInQuickOrder()
	        ._GoToHomePage()
	        .getTextOrderNumber(key)
	        ._GoOrderPage()
	        .clickSubmitOrder()
	        .clickOrderReminderSubmitNormal()
	        .verifyAndConfirmOrder()
	        .orderPageTab()
	        ._GoToHomePage()
	        .clickOnSubmittedOrdersLink()
	        .clickOnAnyOrder(key)
	        ._GoOrderPage()
	        .verifyDeleteLink();
	        }
	@Test(groups={"Order_Modify"}, description = "Order Entry Submit_027_02 : Verify that orders in Submitted Status cannot be modified after cutoff time")
	@Features("Order Modify")
	@Stories("Order Entry Submit_027_02 : Verify that orders in Submitted Status cannot be modified after cutoff time")
	public void OrderSubmitvalidation() {	
		String strKeyOrder="Order Entry Submit_027_02";
		LoginData loginData =LoginData.fetch("$OMUser5");
		OrderData orderData = OrderData.fetch("$OrderData22");
		
		Start.asTester
		.goToLoginpage()
		.loginToApplication(loginData.UserName, loginData.Password)
		._GoToHomePage()
		.atHomePage()
		//.clickOnExpress()
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
			.verifyModify()
			._GoOrderPage()
			.close();
	}
	
	 
	
	@Test(groups={"Order_Modify"}, description = "Order Entry Submit_025_01 : Verify that orders in Pending Approval status cannot be modified")
	@Features("Order Modify")
	@Stories("Order Entry Submit_025_01 : Verify that orders in Pending Approval status cannot be modified")
	public void ModifyPendingOrder() {	
		String key="Order Entry Submit_025_01";
		LoginData loginDataMA =LoginData.fetch("$OMUser2");
		LoginData loginDataNA =LoginData.fetch("$ONUser1");
		OrderData orderData = OrderData.fetch("$OrderData72");
        System.out.println("Login_data and Order_data are ready");
		Start.asTester
		   .goToLoginpage()
		     .loginToApplication(loginDataNA.UserName, loginDataNA.Password)
		    ._GoToHomePage()
		     .atHomePage()
		    //.clickOnExpress()
		    .startNewOrder()
		    ._GoOrderPage()
		    .selectTypeFromDropDown(orderData.ProductFrom)
		    .clickOnCreatNewOrder()
		    .enterQuickOrderEntryDetailsWithoutAdd(orderData.UPC.split(";"), orderData.CaseQuantity.split(";"),orderData.SplitQuantity.split(";"))
		    .clickOnAddToOrderInQuickOrder()
		    ._GoToHomePage()
		    .getTextOrderNumber(key)
		    ._GoOrderPage()
		    .clickSubmitOrder()
		    .clickOrderReminderSubmitNormal()
		    .clickOnAcknowledgementButton()
		    .close()
		    ._atLoginPage()
			.loginToApplication(loginDataMA.UserName, loginDataMA.Password)
			._GoToHomePage()
			.atHomePage()
			//.clickOnExpress()
			.atExpressHomePage()
			.atExpressOrderingPage()
			._GoOrderPage()
		    .orderPageTab()
		    .verifyOrderPage()
		    ._GoToHomePage()
			.clickOnPendingOrdersLink()
			.clickOnAnyOrder(key)
			//Verifying Modify Order
			.verifyModify();
	} 
	@Test(groups={"Order_Modify"}, description = "Order Entry Submit_025_03 : Verify that orders in Cancelled Status cannot be modified ")
	@Features("Order Modify")
	@Stories("Order Entry Submit_025_03 : Verify that orders in Cancelled Status cannot be modified")
	public void ModifyCancelledOrder() {	
		String key="Order Entry Submit_025_03";
		LoginData loginData =LoginData.fetch("$OMUser3");
		Start.asTester
			.goToLoginpage()
			.loginToApplication(loginData.UserName, loginData.Password)
			._GoToHomePage()
			.atHomePage()
			
			//.clickOnExpress()
			.atExpressHomePage()
			.atExpressOrderingPage()
			._atLoginPage()
			._GoOrderPage()
		    .orderPageTab()
		    .verifyOrderPage()
		    ._GoToHomePage()
		    //Getting Cancelled Order
			.getOrderNumberFromDataBase('X',key,loginData.Customer)
			.clickOnCancelledOrder()
			.clickOnAnyOrder(key)
			//Verifying Modify Cancelled Order
			.verifyModify();
	}
	
	@Test(groups={"Order_Modify"}, description = "Order Entry Submit_025_04 : Verify that orders in Delivered Status cannot be modified ")
	@Features("Order Modify")
	@Stories("Order Entry Submit_025_04 : Verify that orders in Delivered Status cannot be modified")
	public void ModifyDeliveredOrder() {	
		
		LoginData loginData =LoginData.fetch("$OMUser4");
		
		OrderData orderData_01=OrderData.fetch("$OrderData33");
		//OrderData orderData_02=OrderData.fetch("$OrderData34");
		String strKeyOrder="Order Entry Submit_025_04";
		Start.asTester
			.goToLoginpage()
			.loginToApplication(loginData.UserName, loginData.Password)
			._GoToHomePage()
			.atHomePage()
			//.clickOnExpress()
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
				.enterQuickOrderEntryDetailsWithoutAdd(orderData_01.UPC.split(";"),orderData_01.CaseQuantity.split(";"),orderData_01.SplitQuantity.split(";"))
				.clickOnAddToOrderInQuickOrder()
				._GoToHomePage()
				.getTextOrderNumber(strKeyOrder)
				._GoOrderPage()
				//Submitting the order
				.clickSubmitOrder()
				.clickOrderReminderSubmitNormal()
				.verifyAndConfirmOrder()
				//.checkrefnumber(strKeyOrder)
				.orderPageTab()
				.orderPageTab()
				._GoToHomePage()
				.clickOnSubmittedOrdersLink()
				//Making Order to moved into delivered status
				.orderToDeliveredStatus(strKeyOrder)
				//Login to same user 
				.close()
				._atLoginPage()
				.loginToApplication(loginData.UserName, loginData.Password)
			     ._GoToHomePage()
			      .atHomePage()
			     //.clickOnExpress()
				.atExpressHomePage()
				.atExpressOrderingPage()
				._GoOrderPage()
				.orderPageTab()
				._GoToHomePage()
				.clickOnCancelledOrder()
				.clickOnAnyOrder(strKeyOrder)
			     .verifyModify()
			    ._GoOrderPage()
			      .close();
	}
	
	
	
	//SMX plus
	@Test(groups={"Order_Modify"}, description = "Order Entry Submit_017_01 :Validate Delete Order functionality. ")
	@Features("Order Modify")
	@Stories("Order Entry Submit_017_01 : Validate Delete Order functionality.")
	public void DeleteAndValidateOpenOrder() {	
		String key="Order Entry Submit_017_01";
		LoginData loginData =LoginData.fetch("$OMUser43");
		OrderData orderData = OrderData.fetch("$OrderData38");
		Start.asTester
			.goToLoginpage()
			.loginToApplication(loginData.UserName, loginData.Password)
			._GoToHomePage()
			.atHomePage()
			//.clickOnExpress()
			.atExpressHomePage()
			.atExpressOrderingPage()
			._GoOrderPage()
		    .orderPageTab()
		    .verifyOrderPage()
		    ._GoToHomePage()
		   //Creating Order
			.startNewOrder()
            ._GoOrderPage()
		    .atCreateOrderPage()
		    .enterOrderName(orderData.OrderName)
		    .selectTypeFromDropDown(orderData.ProductFrom)
		    .clickOnCreatNewOrder()
		    .enterQuickOrderEntryDetailsWithoutAdd(orderData.UPC.split(";"),orderData.CaseQuantity.split(";"),orderData.SplitQuantity.split(";"))
		    .clickOnAddToOrderInQuickOrder()
		    ._GoToHomePage()
		    .getTextOrderNumber(key)
			._GoOrderPage()
			.clickOnDeleteLink()
			//Validate Deleted Order In Open Order
			.validateAlertDeleteOrder()
			.orderPageTab()
			._GoToHomePage()
			.clickOnOpenOrderLink()
			.validateDeletedOrder(key)
			._GoOrderPage()
			.orderPageTab()
			._GoToHomePage()
			.clickOnSubmittedOrdersLink()
			.validateDeletedOrder(key)
			._GoOrderPage()
			.orderPageTab()
			._GoToHomePage()
			.clickOnCancelledOrder()
			.validateDeletedOrder(key);
			
	}
	 @Test(groups={"Order_Modify"}, description = "Order Entry Submit_018_01 : Validate Delete Order functionality before cut off time.")
		@Features("Order Modify")
		@Stories("Order Entry Submit_018_01 : Validate Delete Order functionality before cut off time.")
		public void DeleteSubmittedOrder() {
		String strKeyOrder="Order Entry Submit_018_01";	
			LoginData loginData =LoginData.fetch("$OMUser20");
			OrderData orderData = OrderData.fetch("$OrderData22");
			
			Start.asTester
			.goToLoginpage()
			.loginToApplication(loginData.UserName, loginData.Password)
			._GoToHomePage()
			.atHomePage()
			//.clickOnExpress()
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
			    ._GoOrderPage()
			    //Verifying delete order link
			    .verifyCancelLink()
			    .close();
		}
	 @Test(groups={"Order_Modify"}, description = "Order Entry Submit_018_02 : Validate Delete Order functionality after cut off time.")
		@Features("Order_Modify")
		@Stories("Order Entry Submit_018_02 : Validate Delete Order functionality after cut off time.")
		public void VerfiySubmittedOrderDelete() {	
			String key="Order Entry Submit_018_02";	
			LoginData loginData =LoginData.fetch("$OMUser21");
			System.out.println("Login_data and Order_data are ready");
			Start.asTester
				.goToLoginpage()
				.loginToApplication(loginData.UserName, loginData.Password)
				._GoToHomePage()
				.atHomePage()
				//.clickOnExpress()
				.atExpressHomePage()
				.atExpressOrderingPage()
				._GoOrderPage()
			    .orderPageTab()
			    .verifyOrderPage()
			    ._GoToHomePage()
			    .clickOnSubmittedOrdersLink()
			    .getOrderNumberFromDataBase('S',key,loginData.Customer)
			    .clickOnAnyOrder(key)
			    ._GoOrderPage()
			    .verifyCancelLink()
			    .close();
		}
}
