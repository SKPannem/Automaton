package com.tests;


	import org.testng.annotations.Test;

	import ru.yandex.qatools.allure.annotations.Features;
	import ru.yandex.qatools.allure.annotations.Stories;

	import com.components.entities.Start;
	import com.components.testdata.LoginData;
	import com.components.testdata.OrderData;


import com.iwaf.framework.Initiator;

	public class ISRItem extends Initiator{
	
		@Test(groups={"ISR_OrderSpecific"}, description = "Order_057 : Try to delete items from an open order")
		@Features("ISR Order Specific")
		@Stories("Order_057 : Try to delete items from an open order")
		public void DeleteItemFromOpenOrders()  {	
			
			LoginData loginData =LoginData.fetch("$ISRUSR1");	
			OrderData orderData = OrderData.fetch("$QuickISR057");
			
			Start.asTester
			   .goToLoginpage()
				.loginToApplication(loginData.UserName, loginData.Password)
				._GoToHomePage()
				.atHomePage()
				.clickOnExpress()
				.atExpressHomePage()
				.SelectLocation(loginData.OpCo, loginData.Customer)
				.atExpressOrderingPage()
				.startNewOrder()
				._GoOrderPage()
			    .atCreateOrderPage()
			    .enterOrderDetails(orderData.OrderName, orderData.ProductFrom)
			   	._GoItemDeletePage()
			   	.atQuickOrderEntryPagePopUpForIsr()
				.enterQuickOrderEntryDetailsForIsr(orderData.UPC,orderData.CaseQuantity,orderData.SplitQuantity)
				.atOrderTab()
				.viewAllopenlink()
				.viewOpenOrderItems()
				.deleteOpenOrderItems(orderData.UPC)
				._GoOrderPage()
				.close();
				
				;
		}
		
		
		@Test(groups={"ISR_OrderSpecific"}, description = "Order_069 :Modify an order and verify the updates")
		@Features("ISR Order Edit Specific")
		@Stories("Order_069 : Modify an order and verify the updates")
		public void Modify_Open_Order () {	
			
			LoginData loginData =LoginData.fetch("$ISRUSR2");	
			OrderData orderData = OrderData.fetch("$QuickISR069");
			
			
			Start.asTester
				.goToLoginpage()
				
				.loginToApplication(loginData.UserName, loginData.Password)
				._GoToHomePage()
				.atHomePage()
				.clickOnExpress()
				.atExpressHomePage()
				.SelectLocation(loginData.OpCo, loginData.Customer)
				.atExpressOrderingPage()
				.startNewOrder()
				._GoOrderPage()
			    .atCreateOrderPage()
			    .enterOrderDetails(orderData.OrderName, orderData.ProductFrom)
			   	._GoItemDeletePage()
			   	.atQuickOrderEntryPagePopUpForIsr()
				.enterQuickOrderEntryDetailsForIsr(orderData.UPC,orderData.CaseQuantity,orderData.SplitQuantity)
				.atOrderTab()
				.viewAllopenlink()
				.viewOpenOrderItems()
				.updateOpenOrderItems(orderData.UPC,orderData.UpdateQuanty)
				._GoOrderPage()
				.close()
				._GoToLoginPage()
				.loginToApplication(loginData.UserName, loginData.Password)
				._GoToHomePage()
				.atHomePage()
				.clickOnExpress()
				.atExpressHomePage()
				.SelectLocation(loginData.OpCo, loginData.Customer)
				.atExpressOrderingPage()
				._GoItemDeletePage()
				.atOrderTab()
				.viewAllopenlink()
				.viewOpenOrderItems()
				.verifyUpdatedItemQuantity(orderData.UPC,orderData.UpdateQuanty)
			   	;
		}
		
		

		
		
		@Test(groups={"ISR_OrderSpecific"}, description = "Hand Pricing for Associates_a:Modify an order and change the hand price of an item.")
		@Features("ISR Hand Pricing Specific")
		@Stories("Hand Pricing for Associates_a : Modify an order and change the hand price of an item")
		public void Hand_Pricing_Associates_a () {	
			
			LoginData loginData =LoginData.fetch("$ISRUSRHA");	
			OrderData orderData = OrderData.fetch("$QuickISRHA");
			
			
			Start.asTester
				.goToLoginpage()
				.loginToApplication(loginData.UserName, loginData.Password)
				._GoToHomePage()
				.atHomePage()
				.clickOnExpress()
				.atExpressHomePage()
				.SelectLocation(loginData.OpCo, loginData.Customer)
				.atExpressOrderingPage()
				._GoItemDeletePage()
				.searchItemPrice(orderData.UPC)
				.UpdateItemPrice(orderData.UPC,orderData.UpdatePrice)
			    .verifyUpdatedItemPrice(orderData.UPC,orderData.UpdatePrice)
			    .createISRNewOrder()
			    ._GoOrderPage()
			    .atCreateOrderPage()
			    .enterOrderDetails(orderData.OrderName, orderData.ProductFrom)
			   	._GoItemDeletePage()
			   	.addItemToOrder(orderData.UPC,orderData.UpdateQuanty)
			    .createOrderXl()
			    .selectInvoice()
			    ._GoOrderPage()
			    .clickSubmitOrder()
			    .atOrderReminderPagePopUp()
			    .clickOrderReminderSubmit()
			    .verifyAndConfirmOrder()
			    .verifyOrderOverviewAfterCreate()
			    ._GoItemDeletePage()
			    .selectSubmittedOrder(orderData.OrderName)
			    .modifyOrder()
			    .modifyHandPrice(orderData.UPC,orderData.CurrentPrice)
			    ._GoOrderPage()
			    .clickSubmitOrder()
			    .atOrderReminderPagePopUp()
			    .clickOrderReminderSubmit()
			    .verifyAndConfirmOrder()
			    .verifyOrderOverviewAfterCreate()
			    ._GoItemDeletePage()
			    .selectSubmittedOrder(orderData.OrderName)
			    .verifyModifyOrderItemPrice(orderData.UPC,orderData.CurrentPrice)
			   	
				;
		}
		
		
	
		@Test(groups={"ISR_OrderSpecific"}, description = "Hand Pricing for Associates_b:Verify that Hand pricing is getting saved even if  user logs out of the application.")
		@Features("ISR Hand Pricing Specific")
		@Stories("Hand Pricing for Associates_b : Verify that Hand pricing is getting saved even if  user logs out of the application")
		public void Hand_Pricing_Associates_b (){	
			
			LoginData loginData =LoginData.fetch("$ISRUSRHB");	
			OrderData orderData = OrderData.fetch("$QuickISRHB");
			
			
			Start.asTester
				.goToLoginpage()
				.loginToApplication(loginData.UserName, loginData.Password)
				._GoToHomePage()
				.atHomePage()
				.clickOnExpress()
				.atExpressHomePage()
				.SelectLocation(loginData.OpCo, loginData.Customer)
				.atExpressOrderingPage()
				._GoItemDeletePage()
				.createISRNewOrder()
			    ._GoOrderPage()
			    .atCreateOrderPage()
			    .enterOrderDetails(orderData.OrderName, orderData.ProductFrom)
			   	._GoItemDeletePage()
			   	.addItemToOpenOrder(orderData.UPC,orderData.UpdateQuanty,orderData.UpdatePrice)
			    //.viewIsrOrder()
			     .createhandPriceXl()
			     ._GoOrderPage()
				.close()
				._GoToLoginPage()
				.loginToApplication(loginData.UserName, loginData.Password)
				._GoToHomePage()
				.atHomePage()
				.clickOnExpress()
				.atExpressHomePage()
				.SelectLocation(loginData.OpCo, loginData.Customer)
				.atExpressOrderingPage()
				._GoItemDeletePage()
				.atOrderTab()
				.viewAllopenlink()
				.viewOpenOrderItemsHandPrice()
				.verifyItemPriceUpdateAfterLogin(orderData.UPC,orderData.UpdatePrice)
			   
				;
		}

		
		
		
		@Test(groups={"ISR_OrderSpecific"}, description = "Hand Pricing for Associates_c:Verify that price gets updated depending on the delivery date.")
		@Features("ISR Hand Pricing Specific")
		@Stories("Hand Pricing for Associates_c : Verify that price gets updated depending on the delivery date")
		public void Hand_Pricing_Associates_c (){	
			
			LoginData loginData =LoginData.fetch("$ISRUSRHC");	
			OrderData orderData = OrderData.fetch("$QuickISRHC");
			
			
			Start.asTester
				.goToLoginpage()
				.loginToApplication(loginData.UserName, loginData.Password)
				._GoToHomePage()
				.atHomePage()
				.clickOnExpress()
				.atExpressHomePage()
				.SelectLocation(loginData.OpCo, loginData.Customer)
				.atExpressOrderingPage()
				._GoItemDeletePage()
				.createISRNewOrder()
			    ._GoOrderPage()
			    .atCreateOrderPage()
			    .enterOrderDetails(orderData.OrderName, orderData.ProductFrom)
			   	._GoItemDeletePage()
			   	.addItemToOpenOrder(orderData.UPC,orderData.CaseQuantity,orderData.UpdatePrice)
			   	.changeShippingCondition()
			   	.ChangeDeliveryDate()
			    .reValidateAlert()
			    .revertOriginalPriceCheck(orderData.UPC)
			    .updateAgainHandPriceNew(orderData.UPC,orderData.UpdatePrice)
			    .changeShippingConditiontoSecondRun()
			    .ChangeDeliveryDateAgain()
			    .reValidateAlert()
			    .revertOriginalPriceCheck(orderData.UPC)
			    .updateAgainHandPrice(orderData.UPC,orderData.CurrentPrice)
			    .changeShippingCondition()
			    .ChangeDeliveryDateNext()
			    .reValidateAlert()
			    .revertOriginalPriceCheck(orderData.UPC)
			   
				;
		}
				
		@Test(groups={"ISR_OrderSpecificModify"}, description = "Order_073:Try to edit an open order with delivery date in the past")
		@Features("ISR Order Edit Specific")
		@Stories("Order_073 : Try to edit an open order with delivery date in the past")
		public void Order_073 (){	
			
			LoginData loginData =LoginData.fetch("$ISRUSR3");	
			//OrderData orderData = OrderData.fetch("$QuickISRHC");
			
			
			Start.asTester
			.goToLoginpage()
			.loginToApplication(loginData.UserName, loginData.Password)
			._GoToHomePage()
			.atHomePage()
			.clickOnExpress()
			.atExpressHomePage()
			.SelectLocation(loginData.OpCo, loginData.Customer)
			.atExpressOrderingPage()
			._GoItemDeletePage()
            .atOrderTab()
			.viewAllopenlink()
            .viewOpenOrderItemsFromDB(loginData.OpCo, loginData.Customer)
                      
			;
		}


		
		@Test(groups={"ISR_OrderSpecificModify"}, description = "Order_075:Try to edit an open order with delivery date in the past")
		@Features("Iser Order specific")
		@Stories("Order_075 : Try to edit an open order with delivery date in the past")
		public void Order_075 (){	
			
			LoginData loginData =LoginData.fetch("$ISRUSR4");	
			//OrderData orderData = OrderData.fetch("$QuickISRHC");
			
			
			Start.asTester
			.goToLoginpage()
			.loginToApplication(loginData.UserName, loginData.Password)
			._GoToHomePage()
			.atHomePage()
			.clickOnExpress()
			.atExpressHomePage()
			.SelectLocation(loginData.OpCo, loginData.Customer)
			.atExpressOrderingPage()
			._GoItemDeletePage()
            .atOrderTab()
			.viewAllopenlink()
            .viewOpenOrderItemsFromDB(loginData.OpCo, loginData.Customer)
            ._GoOrderPage()
			.clickSubmitOrder()
			.atOrderReminderPagePopUp()
			.clickOrderReminderSubmit()
			.verifyAndConfirmOrder()
			.verifyOrderOverviewAfterCreate()
           	;
		}
	
		

	
		@Test(groups={"ISR_OrderSpecific"}, description = "Order_082:Create a new order with Non Stock,Drop Ship and Demand Status Item ")
		@Features("ISR Order Specific")
		@Stories("Order_082 : Create a new order with Non Stock,Drop Ship and Demand Status Item ")
		public void Order_082 (){	
			
			LoginData loginData =LoginData.fetch("$ISRUSR5");	
			OrderData orderData = OrderData.fetch("$QuickISRHC");
			
			
			Start.asTester
				.goToLoginpage()
				.loginToApplication(loginData.UserName, loginData.Password)
				._GoToHomePage()
				.atHomePage()
				.clickOnExpress()
				.atExpressHomePage()
				.SelectLocation(loginData.OpCo, loginData.Customer)
				.atExpressOrderingPage()
				._GoItemDeletePage()
				.createISRNewOrder()
			    ._GoOrderPage()
			    .atCreateOrderPage()
			    .enterOrderDetails(orderData.OrderName, orderData.ProductFrom)
			    ._GoItemDeletePage()
			    .addItemFromDB(loginData.OpCo, loginData.Customer)
			    ._GoOrderPage()
			    .clickSubmitOrder()
			    .atOrderReminderPagePopUp()
			    .clickOrderReminderSubmit()
			    ._GoItemDeletePage()
			    .cancellableItemsAlertPopDiv()
			    ._GoOrderPage()
			    .verifyAndConfirmOrder()
			    .verifyOrderOverviewAfterCreate()
			    ;
		}
		
		
		
		@Test(groups={"ISR_OrderSpecific"}, description = "Order_083:Create a new order with Non Stock,Drop Ship and Demand Status Item and try to cancel the order")
		@Features("ISR Order Specific")
		@Stories("Order_083:Create a new order with Non Stock,Drop Ship and Demand Status Item and try to cancel the order")
		public void Order_083 (){	
			
			LoginData loginData =LoginData.fetch("$ISRUSR6");	
			OrderData orderData = OrderData.fetch("$QuickISRHC");
			
			
			Start.asTester
				.goToLoginpage()
				.loginToApplication(loginData.UserName, loginData.Password)
				._GoToHomePage()
				.atHomePage()
				.clickOnExpress()
				.atExpressHomePage()
				.SelectLocation(loginData.OpCo, loginData.Customer)
				.atExpressOrderingPage()
				._GoItemDeletePage()
				.createISRNewOrder()
			    ._GoOrderPage()
			    .atCreateOrderPage()
			    .enterOrderDetails(orderData.OrderName, orderData.ProductFrom)
			    ._GoItemDeletePage()
			    .addItemFromDB(loginData.OpCo, loginData.Customer)
			    ._GoOrderPage()
			    .clickSubmitOrder()
			    .atOrderReminderPagePopUp()
			    .clickOrderReminderSubmit()
			    ._GoItemDeletePage()
			    .cancelOrderItemsAlertPopDiv()
			    
			    ;
		}
		

		
		
		@Test(groups={"ISR_OrderSpecific"}, description = "Order_086:Create new order for a future delivery date with only Out of stock items & verify that order does not get cancelled")
		@Features("ISR Order Specific")
		@Stories("Order_086:Create new order for a future delivery date with only Out of stock items & verify that order does not get cancelled")
		public void Order_086 (){	
			
			LoginData loginData =LoginData.fetch("$ISRUSR7");	
			OrderData orderData = OrderData.fetch("$QuickISRHC");
			
			
			Start.asTester
				.goToLoginpage()
				.loginToApplication(loginData.UserName, loginData.Password)
				._GoToHomePage()
				.atHomePage()
				.clickOnExpress()
				.atExpressHomePage()
				.SelectLocation(loginData.OpCo, loginData.Customer)
				.atExpressOrderingPage()
				._GoItemDeletePage()
				.createISRNewOrder()
			    ._GoOrderPage()
			    .atCreateOrderPage()
			    .enterOrderDetails(orderData.OrderName, orderData.ProductFrom)
			    ._GoItemDeletePage()
			    .addItemOutOfStockFromDB(loginData.OpCo, loginData.Customer)
			    .clickShippingBtn()
			   	.ChangeDeliveryDate()
			    .reValidateAlert()
			    ._GoOrderPage()
			    .clickSubmitOrder()
			    .atOrderReminderPagePopUp()
			    .clickOrderReminderSubmit()
			    .verifyAndConfirmOrder()
			    .verifyOrderOverviewAfterCreate()
			  
			    ;
		}
		
	
		@Test(groups={"ISR_OrderSpecific"}, description = "Order_087:Create new order with normal items for a del.date after 48 hrs and verify the item status column, conf.Qtys column and the Ord.Qty s column")
		@Features("ISR_OrderSpecific")
		@Stories("Order_087:Create new order with normal items for a del.date after 48 hrs and verify the item status column, conf.Qtys column and the Ord.Qty s column")
		public void Order_087 (){	
			
			LoginData loginData =LoginData.fetch("$ISRUSR8");	
			OrderData orderData = OrderData.fetch("$QuickISRHC");
			
			
			Start.asTester
				.goToLoginpage()
				.loginToApplication(loginData.UserName, loginData.Password)
				._GoToHomePage()
				.atHomePage()
				.clickOnExpress()
				.atExpressHomePage()
				.SelectLocation(loginData.OpCo, loginData.Customer)
				.atExpressOrderingPage()
				._GoItemDeletePage()
				.createISRNewOrder()
			    ._GoOrderPage()
			    .atCreateOrderPage()
			    .enterOrderDetails(orderData.OrderName, orderData.ProductFrom)
			    ._GoItemDeletePage()
			    .addOneItemGromDB(loginData.OpCo, loginData.Customer)
			    .createfutureOrderXl()
			    .selectInvoice()
			    .clickShippingBtn()
			   	.ChangeDeliveryDateAgain()
			    .reValidateAlert()
			    ._GoOrderPage()
			    .clickSubmitOrder()
			    .atOrderReminderPagePopUp()
			    .clickOrderReminderSubmit()
			    .verifyAndConfirmOrder()
			    .verifyOrderOverviewAfterCreate()
			    ._GoItemDeletePage()
			     .selectFutureSubmittedOrder(orderData.OrderName)
			     .checkItemStatus()
			    ;
		}
		
		
		
		
		
		@Test(groups={"ISR_OrderSpecific"}, description = "Order_089:Delete any item from the submitted future order and verify the item status of the deleted item")
		@Features("ISR Order Specific")
		@Stories("Order_089: Delete any item from the submitted future order and verify the item status of the deleted item")
		public void Order_089() {	
			
			LoginData loginData =LoginData.fetch("$ISRUSR9");	
			OrderData orderData = OrderData.fetch("$QuickISRHA");
			
			
			Start.asTester
				.goToLoginpage()
				.loginToApplication(loginData.UserName, loginData.Password)
				._GoToHomePage()
				.atHomePage()
				.clickOnExpress()
				.atExpressHomePage()
				.SelectLocation(loginData.OpCo, loginData.Customer)
				.atExpressOrderingPage()
				._GoItemDeletePage()
				.createISRNewOrder()
			    ._GoOrderPage()
			    .atCreateOrderPage()
			    .enterOrderDetails(orderData.OrderName, orderData.ProductFrom)
			   	._GoItemDeletePage()
			   	.addTwoItemFromDB(loginData.OpCo, loginData.Customer)
			     .storeOrderNum_089()
			     .selectInvoice()
			    ._GoOrderPage()
			    .clickSubmitOrder()
			   .atOrderReminderPagePopUp()
			   .clickOrderReminderSubmit()
			    .verifyAndConfirmOrder()
			    .verifyOrderOverviewAfterCreate()
			    ._GoItemDeletePage()
			    .selectNormalSubmittedOrder_089(orderData.OrderName)
			    .modifyOrder()
			    .toDeleteItem()
			    ._GoOrderPage()
			    .clickSubmitOrder()
			    .atOrderReminderPagePopUp()
			    .clickOrderReminderSubmit()
			    .verifyAndConfirmOrder()
			    .verifyOrderOverviewAfterCreate()
			    ._GoItemDeletePage()
			    .selectNormalSubmittedOrder_089(orderData.OrderName)
			    ;
		}
		
		
		
		
		@Test(groups={"ISR_OrderSpecific"}, description = "Order_093:Modify an order and change the hand price of an item.")
		@Features("ISR Order Specific")
		@Stories("Order_093: Modify an order and change the hand price of an item")
		public void Order_093() {	
			
			LoginData loginData =LoginData.fetch("$ISRUSR10");	
			OrderData orderData = OrderData.fetch("$QuickISRHA");
			
			
			Start.asTester
				.goToLoginpage()
				.loginToApplication(loginData.UserName, loginData.Password)
				._GoToHomePage()
				.atHomePage()
				.clickOnExpress()
				.atExpressHomePage()
				.SelectLocation(loginData.OpCo, loginData.Customer)
				.atExpressOrderingPage()
				._GoItemDeletePage()
				.createISRNewOrder()
			    ._GoOrderPage()
			    .atCreateOrderPage()
			    .enterOrderDetails(orderData.OrderName, orderData.ProductFrom)
			   	._GoItemDeletePage()
			   	.addOneItemGromDB(loginData.OpCo, loginData.Customer)
			    .storeOrderNumForReorder()
			    ._GoOrderPage()
			    .clickSubmitOrder()
			   .atOrderReminderPagePopUp()
			   .clickOrderReminderSubmit()
			    .verifyAndConfirmOrder()
			    .verifyOrderOverviewAfterCreate()
			    ._GoItemDeletePage()
			    .refreshSumittedOrder()
			    ._GoItemDeletePage()
			    .togetSumittedOrderNum(loginData.OpCo)
			    .atOrderTab()
			    .viewAllhistoriallink()
			    .selectDeliveredOrder(orderData.OrderName)
			    .clickReOrderButton()
			    .getReOrderName()
			    .addOneItemForReOrderDB(loginData.OpCo, loginData.Customer)
			    ._GoOrderPage()
			    .clickSubmitOrder()
			   .atOrderReminderPagePopUp()
			    .clickOrderReminderSubmit()
			    .verifyAndConfirmOrder()
			    .verifyOrderOverviewAfterCreate()
			    ;
		}
		
		
		
		@Test(groups={"ISR_OrderSpecificModify"}, description = "Order_114:Verify that user is able to Modify any submitted order")
		@Features("ISR Order Specific")
		@Stories("Order_114: Verify that user is able to Modify any submitted order")
		public void Order_114() {	
			
			LoginData loginData =LoginData.fetch("$ISRUSR11");
			//LoginData loginData =LoginData.fetch("$ISRUSR8");
			OrderData orderData = OrderData.fetch("$QuickISRHA");
			
			
			Start.asTester
				.goToLoginpage()
				.loginToApplication(loginData.UserName, loginData.Password)
				._GoToHomePage()
				.atHomePage()
				.clickOnExpress()
				.atExpressHomePage()
				.SelectLocation(loginData.OpCo, loginData.Customer)
				.atExpressOrderingPage()
				._GoItemDeletePage()
			    .atOrderTab()
			    .viewAllSumittedOrder()
			   // .selectSubmittedOrderFromDB_114(loginData.OpCo,loginData.UserName)
			    .selectSubmittedOrderFromDB(loginData.OpCo, loginData.Customer)
			    .modifyOrder()
				
			
			    ;
		}
		
		
		
		@Test(groups={"ISR_OrderSpecificModify"}, description = "Order_115:Verify that user is able to Cancel any submitted order")
		@Features("ISR Order Specific")
		@Stories("Order_115: Verify that user is able to Cancel any submitted order")
		public void Order_115() {	
			
			LoginData loginData =LoginData.fetch("$ISRUSR12");	
			OrderData orderData = OrderData.fetch("$QuickISRHA");
			
			
			Start.asTester
				.goToLoginpage()
				.loginToApplication(loginData.UserName, loginData.Password)
				._GoToHomePage()
				.atHomePage()
				.clickOnExpress()
				.atExpressHomePage()
				.SelectLocation(loginData.OpCo, loginData.Customer)
				.atExpressOrderingPage()
				._GoItemDeletePage()
			    .atOrderTab()
			    .viewAllSumittedOrder()
			    .selectSubmittedOrderFromDB(loginData.OpCo,loginData.Customer)
			    .cancelOrderLink()
			    .cancelOrderPopup()
					
			    ;
		}
		
		
		
		@Test(groups={"ISR_OrderSpecific"}, description = "Order_130:Create a new order with Non Stock,Drop Ship and Demand Status Item ")
		@Features("ISR Order Specific")
		@Stories("Order_130: Create a new order with Non Stock,Drop Ship and Demand Status Item ")
		public void Order_130 (){	
			
			LoginData loginData =LoginData.fetch("$ISRUSR13");	
			OrderData orderData = OrderData.fetch("$QuickISRHC");
			//System.out.println("I did it -->"+loginData.UserName);
			
			Start.asTester
				.goToLoginpage()
				.loginToApplication(loginData.UserName, loginData.Password)
				._GoToHomePage()
				.atHomePage()
				.clickOnExpress()
				.atExpressHomePage()
				.SelectLocation(loginData.OpCo, loginData.Customer)
				.atExpressOrderingPage()
				._GoItemDeletePage()
				.createISRNewOrder()
			    ._GoOrderPage()
			    .atCreateOrderPage()
			    .enterOrderDetails(orderData.OrderName, orderData.ProductFrom)
			    ._GoItemDeletePage()
			    .addItemFromDB(loginData.OpCo, loginData.Customer)
			    .storeOrderNum_130()
			    .selectInvoice()
			    ._GoOrderPage()
			    .clickSubmitOrder()
			    .atOrderReminderPagePopUp()
			    .clickOrderReminderSubmit()
			    ._GoItemDeletePage()
			    .cancellableItemsAlertPopDiv()
			    ._GoOrderPage()
			    .verifyAndConfirmOrder()
			    .verifyOrderOverviewAfterCreate()
			     ._GoItemDeletePage()
			    .refreshSumittedOrder()
			    .atOrderTab()
			    .viewAllSumittedOrder()
			    .selectSubmittedOrderFromDB_130(loginData.OpCo)
			     .modifyOrder()
			     .checkQntyEdit()
			    ;
		}
		
		
		@Test(groups={"ISR_OrderSpecific"}, description = "Order_133:Create a new order with Non Stock,Drop Ship and Demand Status Item ")
		@Features("ISR Order Specific")
		@Stories("Order_133 : Create a new order with Non Stock,Drop Ship and Demand Status Item ")
		public void Order_133 (){	
			
			LoginData loginData =LoginData.fetch("$ISRUSR14");	
			OrderData orderData = OrderData.fetch("$QuickISRHC");
			
			
			Start.asTester
			.goToLoginpage()
			.loginToApplication(loginData.UserName, loginData.Password)
			._GoToHomePage()
			.atHomePage()
			.clickOnExpress()
			.atExpressHomePage()
			.SelectLocation(loginData.OpCo, loginData.Customer)
			.atExpressOrderingPage()
			._GoItemDeletePage()
			.createISRNewOrder()
		    ._GoOrderPage()
		    .atCreateOrderPage()
		    .enterOrderDetails(orderData.OrderName, orderData.ProductFrom)
		    ._GoItemDeletePage()
		    .addItemFromDB(loginData.OpCo, loginData.Customer)
		    .addItemOutOfStockFromDB(loginData.OpCo, loginData.Customer)
		    .storeOrderNum_133()
		    .selectInvoice()
		    ._GoOrderPage()
			    .clickSubmitOrder()
			    .atOrderReminderPagePopUp()
			    .clickOrderReminderSubmit()
			    ._GoItemDeletePage()
			    .cancellableItemsAlertPopDiv()
			    ._GoOrderPage()
			    .verifyAndConfirmOrder()
			    .verifyOrderOverviewAfterCreate()
			     ._GoItemDeletePage()
			    .refreshSumittedOrder()
			    .atOrderTab()
			    .viewAllSumittedOrder()
			    .selectSubmittedOrderFromDB_133(loginData.OpCo)
			    .modifyOrder()
			    .checkQntyEdit()
			    .searchItemToAddExistingOrders()
			    .clickListTab()
			    .createNewList()
			    .create_NewMyList()
			    .quickOrderEntrupopup()
			    .addToList()
			    .checkQntyEdit()
			    .clickOnOrderGuide()
			    .searchOrderGuideItem()
			    ;
		}
		
	
		@Test(groups={"ISR_OrderSpecific"}, description = "Order_158:Create a new order with Non Stock,Drop Ship and Demand Status Item ")
		@Features("ISR Order Specific ")
		@Stories("Order_158 : Create a new order with Non Stock,Drop Ship and Demand Status Item ")
		public void Order_158 (){	
			
			LoginData loginData =LoginData.fetch("$ISRUSR15");	
			OrderData orderData = OrderData.fetch("$QuickISRHC");
			
			
			Start.asTester
			.goToLoginpage()
			.loginToApplication(loginData.UserName, loginData.Password)
			._GoToHomePage()
			.atHomePage()
			.clickOnExpress()
			.atExpressHomePage()
			.SelectLocation(loginData.OpCo, loginData.Customer)
			.atExpressOrderingPage()
			._GoItemDeletePage()
			.createISRNewOrder()
		    ._GoOrderPage()
		    .atCreateOrderPage()
		    .enterOrderDetails(orderData.OrderName, orderData.ProductFrom)
		    ._GoItemDeletePage()
		    .addNonStockItem(loginData.OpCo, loginData.Customer)
		     .storeOrderNum_158()
		    ._GoOrderPage()
		    .clickSubmitOrder()
		    .atOrderReminderPagePopUp()
			    .clickOrderReminderSubmit()
		    ._GoItemDeletePage()
		    .cancellableItemsAlertPopDiv()
		    ._GoOrderPage()
		    .verifyAndConfirmOrder()
		    .verifyOrderOverviewAfterCreate()
		    ._GoItemDeletePage()
			.selectNormalSubmittedOrder_158(orderData.OrderName)
		    .cancelOrderLink()
			.cancelOrderPopup()
			.CheckCancelNonStockItem()
		    ;
		}
		
		
		@Test(groups={"ISR_OrderSpecific"}, description = "Order_159:Create a new order with Non Stock,Drop Ship and Demand Status Item ")
		@Features("ISR Order Specific")
		@Stories("Order_159 : Create a new order with Non Stock,Drop Ship and Demand Status Item ")
		public void Order_159 (){	
			
			LoginData loginData =LoginData.fetch("$ISRUSR16");	
			OrderData orderData = OrderData.fetch("$QuickISRHC");
			
			
			Start.asTester
			.goToLoginpage()
			.loginToApplication(loginData.UserName, loginData.Password)
			._GoToHomePage()
			.atHomePage()
			.clickOnExpress()
			.atExpressHomePage()
			.SelectLocation(loginData.OpCo, loginData.Customer)
			.atExpressOrderingPage()
			._GoItemDeletePage()
			.createISRNewOrder()
		    ._GoOrderPage()
		    .atCreateOrderPage()
		    .enterOrderDetails(orderData.OrderName, orderData.ProductFrom)
		    ._GoItemDeletePage()
		    .addDemandStatusItem(loginData.OpCo, loginData.Customer)
		     .storeOrderNum_159()
		    ._GoOrderPage()
		    .clickSubmitOrder()
		    .atOrderReminderPagePopUp()
			 .clickOrderReminderSubmit()
		     .verifyAndConfirmOrder()
		    .verifyOrderOverviewAfterCreate()
		    ._GoItemDeletePage()
			.selectNormalSubmittedOrder_159(orderData.OrderName)
		    .cancelOrderLink()
			.cancelOrderPopup()
			.CheckCancelDemandStatusItem()
		    ;
		}
		
		
		@Test(groups={"ISR_OrderSpecific"}, description = "Order_160:Create a new order with Non Stock,Drop Ship and Demand Status Item ")
		@Features("ISR_OrderSpecific")
		@Stories("Order_160 : Create a new order with Non Stock,Drop Ship and Demand Status Item ")
		public void Order_160 (){	
			
			LoginData loginData =LoginData.fetch("$ISRUSR17");	
			OrderData orderData = OrderData.fetch("$QuickISRHC");
			
			
			Start.asTester
			.goToLoginpage()
			.loginToApplication(loginData.UserName, loginData.Password)
			._GoToHomePage()
			.atHomePage()
			.clickOnExpress()
			.atExpressHomePage()
			.SelectLocation(loginData.OpCo, loginData.Customer)
			.atExpressOrderingPage()
			._GoItemDeletePage()
			.createISRNewOrder()
		    ._GoOrderPage()
		    .atCreateOrderPage()
		    .enterOrderDetails(orderData.OrderName, orderData.ProductFrom)
		    ._GoItemDeletePage()
		    .addRemoteStockItem(loginData.OpCo, loginData.Customer)
		     .storeOrderNum_160()
		    ._GoOrderPage()
		    .clickSubmitOrder()
		    .atOrderReminderPagePopUp()
			    .clickOrderReminderSubmit()
		    ._GoItemDeletePage()
		    .cancellableItemsAlertPopDiv()
		    ._GoOrderPage()
		    .verifyAndConfirmOrder()
		    .verifyOrderOverviewAfterCreate()
		    ._GoItemDeletePage()
			.selectNormalSubmittedOrder_160(orderData.OrderName)
		    .cancelOrderLink()
			.cancelOrderPopup()
			.CheckCancelRemoteStatusItem()
		    ;
		}
		
		
		@Test(groups={"ISR_OrderSpecific"}, description = "Order_161:Create a new order with Non Stock,Drop Ship and Demand Status Item ")
		@Features("ISR Order Specific")
		@Stories("Order_161: Create a new order with Non Stock,Drop Ship and Demand Status Item ")
		public void Order_161 (){	
			
			LoginData loginData =LoginData.fetch("$ISRUSR18");	
			OrderData orderData = OrderData.fetch("$QuickISRHC");
			
			
			Start.asTester
			.goToLoginpage()
			.loginToApplication(loginData.UserName, loginData.Password)
			._GoToHomePage()
			.atHomePage()
			.clickOnExpress()
			.atExpressHomePage()
			.SelectLocation(loginData.OpCo, loginData.Customer)
			.atExpressOrderingPage()
			._GoItemDeletePage()
			.createISRNewOrder()
		    ._GoOrderPage()
		    .atCreateOrderPage()
		    .enterOrderDetails(orderData.OrderName, orderData.ProductFrom)
		    ._GoItemDeletePage()
		    .addRemoteStockItem(loginData.OpCo, loginData.Customer)
		     .storeOrderNum_161()
		    ._GoOrderPage()
		    .clickSubmitOrder()
		    .atOrderReminderPagePopUp()
			.clickOrderReminderSubmit()
		    ._GoItemDeletePage()
		    .cancellableItemsAlertPopDiv()
		    ._GoOrderPage()
		    .verifyAndConfirmOrder()
		    .verifyOrderOverviewAfterCreate()
		    ._GoItemDeletePage()
			.selectNormalSubmittedOrder(orderData.OrderName)
		    .cancelOrderLink()
			.cancelOrderPopup()
			.CheckCancelDropStatusItem()
		    ;
		}
		
	
		
		
		
		@Test(groups={"ISR_OrderSpecificModify"}, description = "Order_162:Try to edit the canceled items in an order which is in cancelled status")
		@Features("ISR Order Specific")
		@Stories("Order_162: Try to edit the canceled items in an order which is in cancelled status")
		public void Order_162() {	
			
			LoginData loginData =LoginData.fetch("$ISRUSR19");	
			OrderData orderData = OrderData.fetch("$QuickISRHA");
			
			
			Start.asTester
				.goToLoginpage()
				.loginToApplication(loginData.UserName, loginData.Password)
				._GoToHomePage()
				.atHomePage()
				.clickOnExpress()
				.atExpressHomePage()
				.SelectLocation(loginData.OpCo, loginData.Customer)
				.atExpressOrderingPage()
				._GoItemDeletePage()
			    .atOrderTab()
			    .viewAllhistoriallink()
			    .selectCancelledOrderFromDB(loginData.OpCo)
			    .checkEditable_162()
					
			    ;
		}
		
	
		
		 @Test(groups={"ISR_OrderSpecific"}, description = "User Creation_001:Delete any item from the submitted future order and verify the item status of the deleted item")
		@Features("ISR User Creation")
		@Stories("User Creation_001: Delete any item from the submitted future order and verify the item status of the deleted item")
		public void user_Creation_001() {	
			
			LoginData loginData =LoginData.fetch("$ADMIN");	
			//OrderData orderData = OrderData.fetch("$QuickISRHA");
			
			
			Start.asTester
				.goToLoginpage()
				.loginToApplication(loginData.UserName, loginData.Password)
				._GoToHomePage()
				.atHomePage()
				._GoItemDeletePage()
				.clickISR_link()
				.clickISR_userLink()
				.addNewISR_userLink()
				.addContactName()
				.selectSyscoMarket()	
				.clickSaveUser()
				.clickLogOut()
				.firstloginNewISRUser()
				.change_password("sysco123")
			    .selectSecurityQuestions()
				.selectSecurityQuestionsAnswers("sysco123")
				. click_submit()
				._GoToHomePage()
				.atHomePage()
				.clickOnExpress()
				.atExpressHomePage()
				.SelectLocation(loginData.OpCo, loginData.Customer)
				.atExpressOrderingPage()
				._GoItemDeletePage()
				.checkSuccess_001()
			    ;
		}
		
		@Test(groups={"ISR_OrderSpecific"}, description = "Order_147:Create a new order with Non Stock,Drop Ship and Demand Status Item ")
		@Features("ISR_OrderSpecific")
		@Stories("Order_147 : Create a new order with Non Stock,Drop Ship and Demand Status Item ")
		public void Order_147 (){	
			
			LoginData loginData =LoginData.fetch("$ISRUSR20");	
			OrderData orderData = OrderData.fetch("$QuickISRHC");
			
			
			Start.asTester
				.goToLoginpage()
				.loginToApplication(loginData.UserName, loginData.Password)
				._GoToHomePage()
				.atHomePage()
				.clickOnExpress()
				.atExpressHomePage()
				.SelectLocation(loginData.OpCo, loginData.Customer)
				.atExpressOrderingPage()
				._GoItemDeletePage()
				.createISRNewOrder()
			    ._GoOrderPage()
			    .atCreateOrderPage()
			    .enterOrderDetails(orderData.OrderName, orderData.ProductFrom)
			    ._GoItemDeletePage()
			    .addOneItemFromDB_147(loginData.OpCo, loginData.Customer)
			    .storeOrderNum_147()
			    .selectInvoice()
			    ._GoOrderPage()
			    .clickSubmitOrder()
			    .atOrderReminderPagePopUp()
			    .clickOrderReminderSubmit()
			    .verifyAndConfirmOrder()
			    .verifyOrderOverviewAfterCreate()
			     ._GoItemDeletePage()
			    .refreshSumittedOrder()
			    .atOrderTab()
			    .viewAllSumittedOrder()
			    .selectNormalSubmittedOrder_147(orderData.OrderName)
			    .modifyOrder()
			    .checkQntyEdit_147()
			    .searchItemToAddExistingOrders_147()
			    .clickListTab()
			    .createNewList()
			    .createNewList_147()
			    .quickOrderEntrupopup_147()
			    .addToList()
			    .clickOnOrderGuide()
			    .searchOrderGuideItem_147()
			    ;
		}
	
		@Test(groups={"ISR_OrderSpecific"}, description = "case_splits_001:Create an order with both split and case of an item")
		@Features("ISR Case Split Item")
		@Stories("case_splits_001 :Create an order with both split and case of an item ")
		public void case_splits_001(){	
			
			LoginData loginData =LoginData.fetch("$ISRUSR21");	
			OrderData orderData = OrderData.fetch("$QuickISRHC");
			
			
			Start.asTester
				.goToLoginpage()
				.loginToApplication(loginData.UserName, loginData.Password)
				._GoToHomePage()
				.atHomePage()
				.clickOnExpress()
				.atExpressHomePage()
				.SelectLocation(loginData.OpCo, loginData.Customer)
				.atExpressOrderingPage()
				._GoItemDeletePage()
				.createISRNewOrder()
			    ._GoOrderPage()
			    .atCreateOrderPage()
			    .enterOrderDetails(orderData.OrderName, orderData.ProductFrom)
			    ._GoItemDeletePage()
			    .addCaseandSplitItem_001(loginData.OpCo, loginData.Customer)
			    .verifyViewOrdergrid_001()
			    .checkdeleteBtnCase_001()
			    .cliclAddtoList()
			    .createNewListCaseSplit()
			    .createNewListCaseSplitPopup()
			    .createNewListCaseSplitItem()
			    .clickListTab()
			    .getCsaeSplitList_001()
			  
			    ;
		}
		

		@Test(groups={"ISR_OrderSpecific"}, description = "case_splits_010:Create an order with both split and case of an item")
		@Features("ISR Case Split Item")
		@Stories("case_splits_010 :Create an order with both split and case of an item ")
		public void case_splits_010(){	
			
			LoginData loginData =LoginData.fetch("$ISRUSR22");	
			OrderData orderData = OrderData.fetch("$QuickISRHC");
			
			
			Start.asTester
				.goToLoginpage()
				.loginToApplication(loginData.UserName, loginData.Password)
				._GoToHomePage()
				.atHomePage()
				.clickOnExpress()
				.atExpressHomePage()
				.SelectLocation(loginData.OpCo, loginData.Customer)
				.atExpressOrderingPage()
				._GoItemDeletePage()
				.createISRNewOrder()
			    ._GoOrderPage()
			    .atCreateOrderPage()
			    .enterOrderDetails(orderData.OrderName, orderData.ProductFrom)
			    ._GoItemDeletePage()
			    .addCaseandSplitItem_010(loginData.OpCo, loginData.Customer)
			    .storeOrderNum_010()
			    .selectInvoice()
			    ._GoOrderPage()
		        .clickSubmitOrder()
		        .atOrderReminderPagePopUp()
			    .clickOrderReminderSubmit()
	    	    .verifyAndConfirmOrder()
		        .verifyOrderOverviewAfterCreate()
		        ._GoItemDeletePage()
			    .selectNormalSubmittedOrder_010(orderData.OrderName)
			    .modifyOrder()
			    .checkdeleteBtnCase_010()
			    ._GoOrderPage()
		        .clickSubmitOrder()
		        .atOrderReminderPagePopUp()
			    .clickOrderReminderSubmit()
	    	    .verifyAndConfirmOrder()
		        .verifyOrderOverviewAfterCreate()
		        ._GoItemDeletePage()
			    .selectNormalSubmittedOrder_010(orderData.OrderName)
			   ;
		}

		@Test(groups={"ISR_OrderSpecific"}, description = "case_splits_011:Create an order with both split and case of an item")
		@Features("ISR Case Split Item")
		@Stories("case_splits_011 :Create an order with both split and case of an item ")
		public void case_splits_011(){	
			
			LoginData loginData =LoginData.fetch("$ISRUSR23");	
			OrderData orderData = OrderData.fetch("$QuickISRHC");
			//System.out.println("I did it -->"+loginData.UserName);
			
			Start.asTester
				.goToLoginpage()
				.loginToApplication(loginData.UserName, loginData.Password)
				._GoToHomePage()
				.atHomePage()
				.clickOnExpress()
				.atExpressHomePage()
				.SelectLocation(loginData.OpCo, loginData.Customer)
				.atExpressOrderingPage()
				._GoItemDeletePage()
				.createISRNewOrder()
			    ._GoOrderPage()
			    .atCreateOrderPage()
			    .enterOrderDetails(orderData.OrderName, orderData.ProductFrom)
			    ._GoItemDeletePage()
			    .addCaseandSplitItem_011(loginData.OpCo, loginData.Customer)
			    .storeOrderNum_011()
			    .selectInvoice()
			    ._GoOrderPage()
		        .clickSubmitOrder()
		        .atOrderReminderPagePopUp()
			    .clickOrderReminderSubmit()
	    	    .verifyAndConfirmOrder()
		        .verifyOrderOverviewAfterCreate()
		        ._GoItemDeletePage()
			    .selectNormalSubmittedOrder_011(orderData.OrderName)
			    .modifyOrder()
			    .checkdeleteBtnCase_011()
			    ._GoOrderPage()
		        .clickSubmitOrder()
		        .atOrderReminderPagePopUp()
			    .clickOrderReminderSubmit()
	    	    .verifyAndConfirmOrder()
		        .verifyOrderOverviewAfterCreate()
		        ._GoItemDeletePage()
			    .selectNormalSubmittedOrder_011(orderData.OrderName)
			   ;
		}

	   @Test(groups={"ISR_OrderSpecific"}, description = "ISR_Order Summary Report_001 :Verify whether reports are getting generated when the user selects submitted Dates")
		@Features("ISR Order Summary Report")
		@Stories("ISR_Order Summary Report_001: Verify whether reports are getting generated when the user selects submitted Dates")
		public void Order_Summary_Report_001 () {	
			
			LoginData loginData =LoginData.fetch("$ISRUSR24");	
				Start.asTester
				.goToLoginpage()
				.loginToApplication(loginData.UserName, loginData.Password)
				._GoToHomePage()
				.atHomePage()
				.clickOnExpress()
				.atExpressHomePage()
				.SelectLocation(loginData.OpCo, loginData.Customer)
				.atExpressOrderingPage()
				._GoItemDeletePage()
				.clickOrderSummaryReport()
				.summaryReportPopup()
			    .selectUserDiv(loginData.UserName)
			    .changePopupSubDate()
			    .clickApply()
			    .checkSummaryReport(loginData.UserName);
				;
		}
		
		@Test(groups={"ISR_OrderSpecific"}, description = "ISR_Order Summary Report_002 :Verify whether reports are getting generated when the user selects submitted Dates")
		@Features("ISR Order Summary Report")
		@Stories("ISR_Order Summary Report_002: Verify whether reports are getting generated when the user selects submitted Dates")
		public void Order_Summary_Report_002 () {	
			
			LoginData loginData =LoginData.fetch("$ISRUSR25");	
					
			Start.asTester
				.goToLoginpage()
				.loginToApplication(loginData.UserName, loginData.Password)
				._GoToHomePage()
				.atHomePage()
				.clickOnExpress()
				.atExpressHomePage()
				.SelectLocation(loginData.OpCo, loginData.Customer)
				.atExpressOrderingPage()
				._GoItemDeletePage()
				.clickOrderSummaryReport()
				.summaryReportPopup()
			    .selectUserDivForDeliveryReport(loginData.UserName)
			    .changePopupDelDate()
			    .clickApply()
			    .checkSummaryReport(loginData.UserName);
				;
		}
		
		
		@Test(groups={"ISR_OrderSpecific"}, description = "ISR_Special orders item display_001 :Verify whether the filter is applied and only special orders are getting displayed ")
		@Features("ISR Special Order Item display")
		@Stories("ISR_Special orders item display_001: Verify whether the filter is applied and only special orders are getting displayed ")
		public void ISR_Special_orders_display_001 () {	
			
			LoginData loginData =LoginData.fetch("$ISRUSR26");	
					
			Start.asTester
				.goToLoginpage()
				.loginToApplication(loginData.UserName, loginData.Password)
				._GoToHomePage()
				.atHomePage()
				.clickOnExpress()
				.atExpressHomePage()
				.SelectLocation(loginData.OpCo, loginData.Customer)
				.atExpressOrderingPage()
				._GoItemDeletePage()
				.clickOnOrderGuide()
				.clickOnStockIndicator()
				.selectSpecialOrder()
				.checkSpecialOrder()
				;
		}
		
	}


