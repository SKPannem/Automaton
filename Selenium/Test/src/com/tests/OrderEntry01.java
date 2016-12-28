package com.tests;

import java.awt.AWTException;

import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

import com.components.entities.Start;
import com.components.testdata.LoginData;
import com.components.testdata.OrderData;
import com.iwaf.framework.Initiator;

public class OrderEntry01 extends  Initiator{
	@Test(groups={"OrderEntry01"}, description = "Order Entry Submit_001 : Validate Max quantity alert")
	@Features("Order Submit")
	@Stories("Order Entry Submit_001 :Validate Max quantity alert")
	public void SubmitTestWithMoreQuantity() throws AWTException{
		LoginData loginData =LoginData.fetch("$OMUser10");
		OrderData orderData1 = OrderData.fetch("$OrderData1");
		String upc=orderData1.UPC;
		String[] arrUPC=upc.split(";");
		String quantity=orderData1.CaseQuantity;
		String[] arrQuantity=quantity.split(";");
		String splitValue=orderData1.SplitQuantity;
		String[] arrSplitValue=splitValue.split(";");
		
	    Start.asTester
		.goToLoginpage()
		.loginToApplication(loginData.UserName, loginData.Password)
		._GoToHomePage()
		.atHomePage()
		//.clickOnExpress()	
		.atExpressHomePage()
		._GoOrderPage()
		.orderPageTab()
		.verifyOrderPage()
        ._GoToHomePage()
        .startNewOrder()
        ._GoOrderPage()
		.atCreateOrderPage()
		//Creating Order From Quick Order
		.selectTypeFromDropDown(orderData1.ProductFrom)
		.clickOnCreatNewOrder()
		.atQuickOrderEntryPagePopUp()
		//Adding 3 items 
		.enterQuickOrderEntryDetailsWithoutAdd(arrUPC,arrQuantity,arrSplitValue)
	    .clickOnAddToOrderInQuickOrder()
		.clickSubmitOrder()
		.clickOrderReminderSubmitNormal()
		//validating Alert
		.validateQunatityPopup()
		//Updating Quantity having more Than 25
		.changeOrderQuantity(arrUPC[2],arrQuantity[1])
		.changeOrderQuantity(arrUPC[3],arrQuantity[1])
		.clickOnContinueButton()
		.clickOnAcknowledgementButton();
	}

	@Test(groups={"OrderEntry01"}, description = "Order Entry Submit_0025 : Verification of price validation at order details page for catch weiht and non catch weight item")
	@Features("Order Submit")
	@Stories("Order Entry Submit_0025 : Verification of price validation at order details page for catch weiht and non catch weight item")
	public void ValidateTotalPrice() {	
		
		LoginData loginData =LoginData.fetch("$OMUser11");	
		OrderData orderData_NoncatchWeight = OrderData.fetch("$OrderData117");
		OrderData orderData_catchWeight = OrderData.fetch("$OrderData6");
        String key="Order Entry Submit_0025";
		System.out.println("login_data and order_data are ready");
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
            ._GoOrderPage()
			.atCreateOrderPage()
			.selectTypeFromDropDown(orderData_NoncatchWeight.ProductFrom)
			.clickOnCreatNewOrder()
			.atQuickOrderEntryPagePopUp()
			//Creating order with case and split non catch weight items
			.enterQuickOrderEntryDetailsWithoutAdd(orderData_NoncatchWeight.UPC.split(";"),orderData_NoncatchWeight.CaseQuantity.split(";"),orderData_NoncatchWeight.SplitQuantity.split(";"))
			.clickOnAddToOrderInQuickOrder()
			._GoToHomePage()
			.getTextOrderNumber(key)
			._GoOrderPage()
		    .clickSubmitOrder()
		    .clickOrderReminderSubmitNormal()
		    .clickOnAcknowledgementButton()
		    ._GoToHomePage()
		    //Validating total price
		    .getTotalPriceFromDB(key)
		    .validateTotalPrice(key)
		    ._GoOrderPage()
		    .orderPageTab()
            ._GoToHomePage()
            //Creating order with catch weight case and split item
            .startNewOrder()
            ._GoOrderPage()
			.atCreateOrderPage()
			.selectTypeFromDropDown(orderData_catchWeight.ProductFrom)
			.clickOnCreatNewOrder()
			.atQuickOrderEntryPagePopUp()
			.enterQuickOrderEntryDetailsWithoutAdd(orderData_catchWeight.UPC.split(";"),orderData_catchWeight.CaseQuantity.split(";"),orderData_NoncatchWeight.SplitQuantity.split(";"))
			.clickOnAddToOrderInQuickOrder()
			._GoToHomePage()
			.getTextOrderNumber(key)
			._GoOrderPage()
		    .clickSubmitOrder()
		    .clickOrderReminderSubmitNormal()
		    .clickOnAcknowledgementButton()
		     ._GoToHomePage()
		    //Validating Total Price
		    .getTotalPriceFromDB(key)
		    .validateTotalPrice(key)
		    ._GoOrderPage()
		    .orderPageTab()
            ._GoToHomePage()
            .startNewOrder()
            ._GoOrderPage()
			.atCreateOrderPage()
			.selectTypeFromDropDown(orderData_catchWeight.ProductFrom)
			.clickOnCreatNewOrder()
			.atQuickOrderEntryPagePopUp()
			//Creating order with case only catch weight item
			.enterQuickOrderEntryDetailsWithoutAdd(orderData_catchWeight.UPC.split(";"),orderData_catchWeight.CaseQuantity.split(";"),"".split(""))
			.clickOnAddToOrderInQuickOrder()
			._GoToHomePage()
			.getTextOrderNumber(key)
			._GoOrderPage()
		    .clickSubmitOrder()
		    .clickOrderReminderSubmitNormal()
		    .clickOnAcknowledgementButton()
		    ._GoToHomePage()
		    .getTotalPriceFromDB(key)
		    .validateTotalPrice(key)
		     ._GoOrderPage()
		    .orderPageTab()
            ._GoToHomePage()
            .startNewOrder()
            ._GoOrderPage()
			.selectTypeFromDropDown(orderData_catchWeight.ProductFrom)
			.clickOnCreatNewOrder()
			.atQuickOrderEntryPagePopUp()
			//Creating an order with split only catch weight item
			.enterQuickOrderEntryDetailsWithoutAdd(orderData_catchWeight.UPC.split(";"),orderData_catchWeight.CaseQuantity.split(";"),orderData_NoncatchWeight.SplitQuantity.split(";"))
			.clickOnAddToOrderInQuickOrder()
			.verifyOrderlandingPage()
			._GoToHomePage()
			.getTextOrderNumber(key)
			._GoOrderPage()
		    .clickSubmitOrder()
		    .clickOrderReminderSubmitNormal()
		    .clickOnAcknowledgementButton()
		    ._GoToHomePage()
		    .getTotalPriceFromDB(key)
		    .validateTotalPrice(key);
	
	}
	 @Test(groups={"OrderEntry01"}, description = "Order Entry Submit_002 : Validate Delivery date calendar Off day display.")
	@Features("Order Submit")
	@Stories("Order Entry Submit_002 : Validate Delivery date calendar Off day display.")
	public void verifyDeliveryDate(){
		LoginData loginData =LoginData.fetch("$OMUser12");		
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
		._GoOrderPage()
	    .clickOnDeliveyDate()
	    //validating Saturday,Sunday & Weekday
	    .selectSaturday()
		.selectSunday()
		.selectWeekDay();
		
	}
   @Test(groups={"OrderEntry01"}, description = "Order Entry Submit_006_02 : Validate create an order functionality and cancelling the 'Create New Order' screen")
	@Features("Order Submit")
	@Stories("Order Entry Submit_006_02 : Validate create an order functionality and cancelling the 'Create New Order' screen")
	public void verifyFields(){
		LoginData loginData =LoginData.fetch("$OMUser13");
		OrderData orderData = OrderData.fetch("$OrderData30");
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
		.atCreateOrderPage()
		//Verifying Functionalities In create Order pop up
		.verifyCreateOrderPopupFunctions()
		.viewDropDown(orderData.ProductFrom)
		.clickOnCancelButton()
		._GoToHomePage()
		//Verify pop up After Cancel
		.verifyCreateOrderAfterCancel();
	}

    @Test(groups={"OrderEntry01"}, description = "Order Entry Submit_007 : Validate Create new order functionality from Order guide")
	@Features("Order Submit")
	@Stories("Order Entry Submit_007 : Validate Create new order functionality from Order guide")
	public void verifyFieldsAndSubmitOrder(){
		LoginData loginData =LoginData.fetch("$OMUser14");	
		OrderData orderData = OrderData.fetch("$OrderData32");
		System.out.println((orderData.ProductFrom.split(";")[1]));
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
		.atCreateOrderPage()
		//Verifying Functionalities In create Order pop up
		.verifyCreateOrderPopupFunctions()
		.viewDropDown(orderData.ProductFrom)
		.selectTypeFromDropDown(orderData.ProductFrom.split(";")[1])
		.clickOnCreatNewOrder()
		._GoToHomePage()
		.verifyOrderGuidepage()
		._GoOrderPage()
		._GoToOrdeGuidePage()
		.atOrderGuidePage()
		//Enter Quantity
		.enterOrderQuantity(orderData.UPC.split(";"), orderData.CaseQuantity.split(";"))
		.checkMultipleItem(orderData.UPC.split(";"))
		._GoToListPage()
		//Submitting Order
		.clickOnViewOrder()
		._GoOrderPage()
		.clickSubmitOrder()
		.clickOrderReminderSubmitNormal()
		.clickOnAcknowledgementButton();
		

   }
    @Test(groups={"OrderEntry01"}, description = "Order Entry Submit_008 :Validate Create new order functionality from Lists")
	@Features("Order Submit")
	@Stories("Order Entry Submit_008 : Validate Create new order functionality from Lists")
	public void VerifyNewOrderFields(){
		LoginData loginData =LoginData.fetch("$OMUser15");	
		OrderData orderData_01=OrderData.fetch("$OrderData30");
		OrderData orderData_02=OrderData.fetch("$OrderData31");
		String items=orderData_02.UPC;
		String[] upcNumbers=items.split(";");
		String itemquantity=orderData_02.CaseQuantity;
		String[] quantity=itemquantity.split(";");
		String key="Order Entry Submit_008";
		System.out.println("logain_data and order_data are ready ");
		Start.asTester
			.goToLoginpage()
			.loginToApplication(loginData.UserName, loginData.Password)
			._GoToHomePage()
			.atHomePage()
			//.clickOnExpress()
			.atExpressHomePage()	
			.atExpressOrderingPage()
			._GoToListPage()
		   //Creating List
		    ._GoToOrdeGuidePage()
		    .clickOnOrderGuideTab()
		    .checkMultipleItem(upcNumbers)
		    ._GoToListPage()
		    .clickOnAddToList()
		    .clickOnCreateNewListLink()
			.enterListName(key)
			.clickOnCreatNewListInAddListPopup()
			._GoOrderPage()
			.orderPageTab()
			.verifyOrderPage()
			._GoToHomePage()
			.startNewOrder()
			._GoOrderPage()
			//Verifying Functionalities In create Order pop up
		     .verifyCreateOrderPopupFunctions()
			.viewDropDown(orderData_01.ProductFrom)
		    .selectTypeFromDropDown(orderData_02.ProductFrom)
	        .clickOnCreatNewOrder()
	        ._GoToHomePage()
	        .verifyListpage()
	        ._GoToListPage()
	        .clickOnMyListLink()
	        .getListNumberByListName(key)
	        .clickOnAnyListNumber(key)
	        //Enter Quantity
	        .enterQuantityListMultiple(upcNumbers, quantity)
	        ._GoOrderPage()
	        //Submitting Order
	        .clickOnViewOrder()
	        .clickSubmitOrder()
	        .clickOrderReminderSubmitNormal()
	        .clickOnAcknowledgementButton();
			
	} 
    @Test(groups={"OrderEntry01"}, description = "Order Entry Submit_009: Validate Create new order functionality from Historical Orders")
	@Features("Order Submit")
	@Stories("Order Entry Submit_009 : Validate Create new order functionality from Historical Orders")
	public void OrderFromHistoricalOrder(){
		LoginData loginData =LoginData.fetch("$NormalUser30");
		//LoginData loginData =LoginData.fetch("$OMUser16");
		OrderData orderData_01=OrderData.fetch("$OrderData33");
		//OrderData orderData_02=OrderData.fetch("$OrderData34");
		String strKeyOrder="Order Entry Submit_009";
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
			     .clickOnExpress()
				.atExpressHomePage()
				.atExpressOrderingPage()
				._GoOrderPage()
				.orderPageTab()
				._GoToHomePage()
				.startNewOrder()
				._GoOrderPage()
				// Verifying Functionalities In create Order pop up
				.verifyCreateOrderPopupFunctions()
				.viewDropDown(orderData_01.ProductFrom)
				.selectDropDownValue("Historical Orders")
				.clickOnCreatNewOrder()
				._GoToHomePage()
				// .getOrderNumberFromDataBase('X',key,loginData.Customer)
				.clickOnAnyOrder(strKeyOrder)
				._GoToHistoricalOrderPage()
				// Click On Reorder
				.clickOnReOrder()
				._GoToHomePage()
				// .getOrderDetails(key)
				.enterMultipleQuantity()
				// .getOrderDetails()
				._GoOrderPage()
				.clickSubmitOrder()
				.clickOrderReminderSubmitNormal()
				.verifyAndConfirmOrder();
	}
    
   @Test(groups={"OrderEntry01"}, description = "Order Entry Submit_010 :Validate Create new order functionality from Product Catalog")
	@Features("Order Submit")
	@Stories("Order Entry Submit_010 : Validate Create new order functionality from Product Catalog")
	public void OrderFromProductCatlogue(){
		LoginData loginData =LoginData.fetch("$OMUser17");	
		OrderData orderData_001 = OrderData.fetch("$OrderData35");
		OrderData orderData_002 = OrderData.fetch("$OrderData36");
	    String data=orderData_001.ItemName;
	    String[] arrData=data.split(";");
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
			//Verifying Functionalities In create Order pop up
		    .verifyCreateOrderPopupFunctions()
			.viewDropDown(orderData_001.ProductFrom)
	        .selectTypeFromDropDown(orderData_002.ProductFrom)
	        .clickOnCreatNewOrder()
	        ._GoToProductCatalog()
	        //Click On Product category
	        .clickOnProductCategory(arrData[0])
	        .clickOnSubCategory(arrData[1])
	        .clickOnSelectedItem(arrData[2])
	        ._GoToOrdeGuidePage()
	        .enterOrderQuantity(orderData_001.UPC.split(";"),orderData_001.CaseQuantity.split(";"))
	        ._GoOrderPage()
	        .clickOnViewOrder()
	        .clickSubmitOrder()
			.clickOrderReminderSubmitNormal()
			.clickOnAcknowledgementButton();
	       
	}
    @Test(groups={"OrderEntry01","SauceLabSmoke"}, description = "Order Entry Submit_011_01:Validate Create new order functionality from Quick order entry")
	@Features("Order Submit")
	@Stories("Order Entry Submit_011_01 : Validate Create new order functionality from Quick order entry")
	public void CreateOrderFromQuickEntry() {	
		
		LoginData loginData =LoginData.fetch("$OMUser18");	
		OrderData orderData_001 = OrderData.fetch("$OrderData37");
		OrderData orderData_002 = OrderData.fetch("$OrderData38");
		
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
			//Verifying Functionalities In create Order pop up
		   .verifyCreateOrderPopupFunctions()
			.viewDropDown(orderData_001.ProductFrom)
	        .selectTypeFromDropDown(orderData_002.ProductFrom)
			//.QOE()
	        .clickOnCreatNewOrder()
			.enterQuickOrderEntryDetailsWithoutAdd(orderData_001.UPC.split(";"),orderData_001.CaseQuantity.split(";"), orderData_001.SplitQuantity.split(";"))
			.clickOnAddToOrderInQuickOrder()
			.clickSubmitOrder()
			.clickOrderReminderSubmitNormal()
			.clickOnAcknowledgementButton()
			.close()
			;
	}
     @Test(groups={"OrderEntry01"}, description = "Order Entry Submit_011_02 : Validate Create new order functionality from Quick order entry and cancelling without creating an order")
	@Features("Order Submit")
	@Stories("Order Entry Submit_011_02 : Validate Create new order functionality from Quick order entry and cancelling without creating an order")
	public void ValidateOrderFromQuickEntry() {	
		
		LoginData loginData =LoginData.fetch("$OMUser19");	
		OrderData orderData_001 = OrderData.fetch("$OrderData39");
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
			//Verifying Functionalities In create Order pop up
		    .verifyCreateOrderPopupFunctions()
			.viewDropDown(orderData_001.ProductFrom)
	        .selectDropDownValue((orderData_001.ProductFrom.split(";"))[5])
	        .clickOnCreatNewOrder()
	        .atQuickOrderEntryPagePopUp()
			.enterQuickOrderEntryDetailsWithoutAdd(orderData_001.UPC.split(";"),orderData_001.CaseQuantity.split(";"), orderData_001.SplitQuantity.split(";"))
			.clickOncancelOrder()
			._GoToHomePage()
			.verifyCreateOrderAfterCancel();
	} 
   
    @Test(groups={"OrderEntry01"}, description = "Order Entry Submit_013 : Validate 'Save these settings' checkbox in Create New Order screen")
	@Features("Order Submit")
	@Stories("Order Entry Submit_013 : Validate 'Save these settings' checkbox in Create New Order screen ")
	public void ValidateStatusOfOrderInMultiUser() {	
		
		LoginData loginData1 =LoginData.fetch("$OMUser8");
		LoginData loginData2 =LoginData.fetch("$OMUser9");
		
		OrderData orderData = OrderData.fetch("$OrderData38");
        String key="Order Entry Submit_013";
		System.out.println("login_data and order_data are ready");
		Start.asTester
			.goToLoginpage()
			.loginToApplication(loginData1.UserName, loginData1.Password)
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
		    .clickSubmitOrder()
		    .clickOrderReminderSubmitNormal()
		    .clickOnAcknowledgementButton()
		    //Validating Modified user for User1
		    ._GoToHomePage()
		    .validateLastmodifiedbyuser(loginData1.UserName)
		    ._GoOrderPage()
		    .close()
		    ._atLoginPage()
		    .loginToApplication(loginData2.UserName, loginData2.Password)
			._GoToHomePage()
			.atHomePage()
			.clickOnExpress()
			.atExpressHomePage()
			.atExpressOrderingPage()
            ._GoOrderPage()
		    .orderPageTab()
		    ._GoToHomePage()
            .clickOnOpenOrderLink()
            .clickOnAnyOrder(key)
             //Validating Modified user for User1
		    .validateLastmodifiedbyuser(loginData1.UserName)
		    .clickOnModify()
		    .acceptAlert_Modify()
		    //.enterOrderQuantity(orderData.CaseQuantity, orderData.UPC)
		    ._GoOrderPage()
		    .clickSubmitOrder()
		    .clickOrderReminderSubmitNormal()
		    .clickOnAcknowledgementButton()
		    ._GoToHomePage()
		     //Validating Modified user for User2
		    .validateLastmodifiedbyuser(loginData2.UserName)
		    ._GoOrderPage()
		    .close()
            ._atLoginPage()
	        .atLoginPage()
	        .loginToApplication(loginData1.UserName, loginData1.Password)
		    ._GoToHomePage()
		    .atHomePage()
		    .clickOnExpress()
		    .atExpressHomePage()
		    .atExpressOrderingPage()
            ._GoOrderPage()
		    .orderPageTab()
		    .verifyOrderPage()
		    ._GoToHomePage()
            .clickOnOpenOrderLink()
            .clickOnAnyOrder(key)
             //Validating Modified user for User2
	        .validateLastmodifiedbyuser(loginData2.UserName)
	        .clickOnModify()
	        .acceptAlert_Modify()
	        ._GoOrderPage()
	        .clickSubmitOrder()
	        .clickOrderReminderSubmitNormal()
	        .clickOnAcknowledgementButton()
	        ._GoToHomePage()
	         //Validating Modified user for User1
	        .validateLastmodifiedbyuser(loginData1.UserName)
	        ._GoOrderPage()
	        .close();
	}
	
  
	
	@Test(groups={"OrderEntry01"}, description = "Order Entry Submit_019 : Validate Alerts column.")
	@Features("Order Submit")
	@Stories("Order Entry Submit_019 : Validate Alerts column.")
	public void VerifyAlertColumnForOrders() {	
		LoginData loginData =LoginData.fetch("$OMUser22");	
		Start.asTester
			.goToLoginpage()
			.loginToApplication(loginData.UserName, loginData.Password)
			._GoToHomePage()
			.atHomePage()
			//.clickOnExpress()
			.atExpressHomePage()
			._GoOrderPage()
			.orderPageTab()
			.verifyOrderPage()
			//Verifying Alert against All Order
			.verifyAlertAnyOrder()
			//Moving Cursor On Alert Indicator
			._GoToHomePage()
		    .clickOnCancelledOrder()
		    ._GoOrderPage()
			.moveCursorToAlertColummn()
			;
	}
	@Test(groups={"OrderEntry01"}, description = "Order Entry Submit_020_02 :Verify different order status for an order created by a Normal user(not tied to a multi-approver) -order cancelled ")
	@Features("Order Submit")
	@Stories("Order Entry Submit_020_02 : Verify different order status for an order created by a Normal user(not tied to a multi-approver) -order cancelled")
	public void validateOrderOpenStatus(){
		String key="Order Entry Submit_020_02";	
		LoginData loginData =LoginData.fetch("$OMUser23");
		OrderData orderData = OrderData.fetch("$OrderData38");
		Start.asTester
		.goToLoginpage()
		.loginToApplication(loginData.UserName, loginData.Password)
		._GoToHomePage()
		.atHomePage()
		//.clickOnExpress()
		.atExpressHomePage()	
		._GoToHomePage()
		._GoOrderPage()
	    .orderPageTab()
	    .verifyOrderPage()
		._GoToHomePage()
		//Creating Order
		.startNewOrder()
		._GoOrderPage()
		.enterOrderName(orderData.OrderName)
		.selectTypeFromDropDown(orderData.ProductFrom)
		.clickOnCreatNewOrder()
		.atQuickOrderEntryPagePopUp()
		.enterQuickOrderEntryDetailsWithoutAdd(orderData.UPC.split(";"), orderData.CaseQuantity.split(";"),orderData.SplitQuantity.split(";"))
		.clickOnAddToOrderInQuickOrder()
		._GoToHomePage()
		.getTextOrderNumber(key)
		._GoOrderPage()
		.orderPageTab()
		._GoToHomePage()
		//Validating Open order Status
		.clickOnOpenOrderLink()
		.validateStatusOfOpenOrder(key)
		.clickOnAnyOrder(key);
		
	} 
	@Test(groups={"OrderEntry01"}, description = "Order Entry Submit_021_02 : Verify different order status for an order created by a Normal user tied to a multi-approver-order rejected ")
	@Features("Order Submit")
	@Stories("Order Entry Submit_021_02 : Verify different order status for an order created by a Normal user tied to a multi-approver-order rejected")
	public void validateOrderStatus(){
		String key="Order Entry Submit_021_02";
		LoginData loginData_Normal =LoginData.fetch("$OMUser24");
		LoginData loginData_Approver =LoginData.fetch("$OMUser25");
		OrderData orderData = OrderData.fetch("$OrderData38");
   Start.asTester
		.goToLoginpage()
		.loginToApplication(loginData_Normal.UserName, loginData_Normal.Password)
		._GoToHomePage()
		.atHomePage()
		//.clickOnExpress()
		.atExpressHomePage()	
		._GoToHomePage()
		._GoOrderPage()
		.orderPageTab()
		._GoToHomePage()
		//Creating Order
		.startNewOrder()
		._GoOrderPage()
		.enterOrderName(orderData.OrderName)
		.selectTypeFromDropDown(orderData.ProductFrom)
		.clickOnCreatNewOrder()
		.atQuickOrderEntryPagePopUp()
		.enterQuickOrderEntryDetailsWithoutAdd(orderData.UPC.split(";"), orderData.CaseQuantity.split(";"),orderData.SplitQuantity.split(";"))
		.clickOnAddToOrderInQuickOrder()
		._GoToHomePage()
		.getTextOrderNumber(key)
		._GoOrderPage()
		.orderPageTab()
		._GoToHomePage()
		.clickOnOpenOrderLink()
		.validateStatusOfOpenOrder(key)
		.clickOnAnyOrder(key)
		._GoOrderPage()
		.clickSubmitOrder()
		.clickOrderReminderSubmitNormal()
		.clickOnAcknowledgementButton()
		._GoOrderPage()
		.close()
		._atLoginPage()
		//Log in As MultiApprover tied up
		.loginToApplication(loginData_Approver.UserName, loginData_Approver.Password)
		._GoToHomePage()
		.atHomePage()
		.clickOnExpress()
		.atExpressHomePage()
		._GoToLoginPage()
		//.clickOnUserTiedWithMultiApprover()
		._GoOrderPage()
	     .orderPageTab()
		 ._GoToHomePage()
		 //Validating Status Pending Order
		.clickOnPendingOrdersLink()
		.validatePendingApprovalOrderStatus(key)
		.clickOnAnyOrder(key)
		._GoOrderPage()
		.clickOnRejectOrderButton()
		.enterRejectMessage()
		._GoOrderPage()
		.orderPageTab()
		._GoToHomePage()
		//Validate Status Reject Order
		.clickOnOpenOrderLink()
		.validateStatusOfRejectOrder(key);
		
	
	} 
	
	@Test(groups={"OrderEntry01"}, description = "Order Entry Submit_022_02 : Verify different order status for an order created by a Normal user tied to a multi-approver-order ")
	@Features("Order Submit")
	@Stories("Order Entry Submit_022_02 : Verify different order status for an order created by a Normal user tied to a multi-approver-order ")
	public void validateOrderApprovalSubmittedStatus() {	
		String key="Order Entry Submit_022_02";
		LoginData loginData_Normal =LoginData.fetch("$NormalUser2");
		LoginData loginData_MultiApprover =LoginData.fetch("$MultiapproverUser");
		OrderData orderData = OrderData.fetch("$OrderData52");
		 Start.asTester
		.goToLoginpage()
		.loginToApplication(loginData_Normal.UserName, loginData_Normal.Password)
		._GoToHomePage()
		.atHomePage()
		//.clickOnExpress()
		.atExpressHomePage()	
		._GoToHomePage()
		._GoOrderPage()
		.orderPageTab()
		._GoToHomePage()
		//Creating Order
		.startNewOrder()
		._GoOrderPage()
		.enterOrderName(orderData.OrderName)
		.selectTypeFromDropDown(orderData.ProductFrom)
		.clickOnCreatNewOrder()
		.atQuickOrderEntryPagePopUp()
		.enterQuickOrderEntryDetailsWithoutAdd(orderData.UPC.split(";"), orderData.CaseQuantity.split(";"),orderData.SplitQuantity.split(";"))
		.clickOnAddToOrderInQuickOrder()
		._GoToHomePage()
		.getTextOrderNumber(key)
		._GoOrderPage()
		.orderPageTab()
		._GoToHomePage()
		//Validating The Status
		.clickOnOpenOrderLink()
		.validateStatusOfOpenOrder(key)
		.clickOnAnyOrder(key)
		._GoOrderPage()
		.clickSubmitOrder()
		.clickOrderReminderSubmitNormal()
		.clickOnAcknowledgementButton()
		._GoOrderPage()
		.close()
		._atLoginPage()
		//Log in As MultiApprover tied up
		.loginToApplication(loginData_MultiApprover.UserName, loginData_MultiApprover.Password)
		._GoToHomePage()
		.atHomePage()
		.clickOnExpress()
		.atExpressHomePage()
		._GoToLoginPage()
		//.clickOnUserTiedWithMultiApprover()
		._GoOrderPage()
	     .orderPageTab()
		 ._GoToHomePage()
		 //Validating Status Pending Order
		.clickOnPendingOrdersLink()
		.validatePendingApprovalOrderStatus(key)
		.clickOnAnyOrder(key)
		._GoOrderPage()
		.clickOnApproveButton()
		.clickOrderReminderSubmitNormal()
		.verifyAndConfirmOrder()
		._GoToHomePage()
		.clickOnSubmittedOrdersLink()
		.validateSubmittedOrderStatus(key);
					
	}
}
