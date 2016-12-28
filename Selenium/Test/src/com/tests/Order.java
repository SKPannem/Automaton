package com.tests;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

import com.components.entities.Start;
import com.components.pages.OrderPage;
import com.components.pages.SupportFunctions;
import com.components.testdata.LoginData;
import com.components.testdata.OrderData;
import com.iwaf.framework.Initiator;
import com.iwaf.framework.components.IReporter.LogType;

public class Order extends  Initiator {	
	
   
	@Test(groups={"Order"}, description = "Order Entry Submit_024 :Validate item status in Order Confirmation page.")
	@Features("Order Submit")
	@Stories("Order Entry Submit_024 : Validate item status in Order Confirmation page.")
	public void checkItemStatusAfterSubmit() {	
		String key="Order Entry Submit_024";
		//LoginData loginData_NUser =LoginData.fetch("$OMUser27");
		LoginData loginData_MUser =LoginData.fetch("$OMUser26");
		OrderData orderData_16 =OrderData.fetch("$OrderData53");
	    System.out.println("login_data and order_data are ready");
		Start.asTester
			.goToLoginpage()
			.loginToApplication(loginData_MUser.UserName, loginData_MUser.Password)
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
			.enterOrderName(orderData_16.OrderName)
			.selectTypeFromDropDown(orderData_16.ProductFrom)
			.clickOnCreatNewOrder()
			.enterQuickOrderEntryDetailsWithoutAdd(orderData_16.UPC.split(";"),orderData_16.CaseQuantity.split(";"),orderData_16.SplitQuantity.split(";"))
		    .clickOnAddToOrderInQuickOrder()
		    ._GoToHomePage()
		    .getTextOrderNumber(key)
		    ._GoOrderPage()
		    .clickSubmitOrder()
		    .clickOrderReminderSubmitNormal()
		    .verifyAndConfirmOrder()
		    ._GoToHomePage()
		    .updateOutOfStockDB(key,orderData_16.UPC.split(";")[0])
		    //.updateSubstituteItem(key,orderData_16.UPC.split(";")[1])
			._GoOrderPage()
			.close()
			._atLoginPage()
			.loginToApplication(loginData_MUser.UserName, loginData_MUser.Password)
			._GoToHomePage()
			.atHomePage()
			//.clickOnExpress()
			.atExpressHomePage()
			._GoOrderPage()
			.orderPageTab()
			._GoToHomePage()
			.clickOnSubmittedOrdersLink()
			.clickOnAnyOrder(key)
			._GoToHomePage()
			.validateConfirmedItem()
			.validateOutOfStock();
		     /*.clickOnModify()
			.acceptAlert_Modify()
			._GoOrderPage()
			._GoToHomePage()
			.clickOnQuickOrderEntry()
			._GoOrderPage()
			.enterQuickOrderEntryDetails(orderData_16.UPC.split(";")[5], orderData_16.CaseQuantity.split(";")[5],orderData_16.SplitQuantity.split(";")[5])
			.clickSubmitOrder()
			.clickOrderReminderSubmitNormal()
			.clickOnAcknowledgementButton();*/
	}
	
	@Test(groups={"Order","SauceLabSmoke"}, description = "Order Entry Submit_026 : Verification of order creation by entring qty at product card")
	@Features("Order Submit")
	@Stories("Order Entry Submit_026 : Verification of order creation by entring qty at product card")
	public void SearchItemAndCreatOrder() {	
		//String key="Order Entry Submit_026";
		LoginData loginData =LoginData.fetch("$OMUser28");	
		OrderData orderData = OrderData.fetch("$OrderData2");
		String key="Order Entry Submit_026";
		Start.asTester
		.goToLoginpage()
		.loginToApplication(loginData.UserName, loginData.Password)
		._GoToHomePage()
		.atHomePage()
		//.clickOnExpress()
		.atExpressHomePage()
		.startNewOrder()
		._GoOrderPage()
		.clickOnCreatNewOrder()
		._GoToHomePage()
		.enterAnyItemInSearchBox(orderData.ItemName)
		.clickOnSearchButton()
		.clickOnPrduct(orderData.UPC)
		.switchToWindowAutomatic(key)
		.switchToProductInfoWindow()
		.enterOrderQuantityInProductWindow(orderData.CaseQuantity,orderData.UPC)
		.clickOnAddToOrderinProductWindow()
		.switchToMainWindowClose(key)
		._GoOrderPage()
		.clickOnViewOrder()
		.clickSubmitOrder()
		.clickOrderReminderSubmitNormal()
		.clickOnAcknowledgementButton();
	}
	
	
	@Test(groups={"Order"}, description = "Order Entry Submit_030 : Verifying the text in description")
	@Features("Order Submit")
	@Stories("Order Entry Submit_030 : Verifying the text in description")
	public void VerifyingText() {	
		
		LoginData loginData =LoginData.fetch("$OMUser42");
		OrderData orderData = OrderData.fetch("$OrderData16");
		System.out.println("login_data and order_data are ready ");
		Start.asTester
			.goToLoginpage()
			.loginToApplication(loginData.UserName, loginData.Password)
			._GoToHomePage()
			.atHomePage()
			//.clickOnExpress()
			.atExpressHomePage()
			.atExpressOrderingPage()
			._GoToHomePage()
			.enterAnyItemInSearchBox(orderData.ItemName)
			.clickOnSearchButton()
			.vefifyTextInDescrition()
			//.enterUPCInSearchBox(orderData.UPC)
			.enterOrderQuantity(orderData.UPC,orderData.CaseQuantity)	
			._GoOrderPage()
			.clickForPopup()
			//.enterQuantityForItem(orderData.CaseQuantity)
			.clickOnCreatNewOrder()
			.clickOnViewOrder()
			.clickSubmitOrder()
			.clickOrderReminderSubmitNormal()
		    .clickOnAcknowledgementButton();
			
	}
	@Test(groups={"Order"}, description = "Order Entry Submit_015_06 : Order import using option 6-CSV")
	@Features("Order Submit")
	@Stories("Order Entry Submit_015_06 :Order import using option 6-CSV")
	public void ImportOrder() {	
		
		LoginData loginData =LoginData.fetch("$OMUser41");
		OrderData orderData = OrderData.fetch("$OrderData66");
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
			._GoOrderPage()
			.clickOnImportOrder()
			////.viewImportOrderDropDown(orderData.GroupBY.split(";"))
	//.selectCSVFromImportDropMenu()
			.verifyimportoptionsorder()
			.clickOnImportCancelButton();
		    
	}
	@Test(groups={"Order"}, description = "Order Entry Submit_015_07 : Verification error while Importing Order containing error. Rectify the eror and submit it")
	@Features("Order Submit")
	@Stories("Order Entry Submit_015_07 :Verification error while Importing Order containing error. Rectify the eror and submit it")
	public void VerifyImportOrder() {	
		
		LoginData loginData =LoginData.fetch("$OMUser43");
		OrderData orderData = OrderData.fetch("$OrderData64");
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
			._GoOrderPage()
			.clickOnImportOrder()
			.clickOnImportCancelButton();
		    
	}
	@Test(groups={"Order"}, description = "Order Entry Submit_027 : Submit Order through Sysco list")
	@Features("Order Submit")
	@Stories("Order Entry Submit_027 : Submit Order through Sysco list")
	public void submitOrderFromSyscoList() {
		//String tcName="ANDYS DINER Order Guide";
		//LoginData loginData =LoginData.fetch("$NormalUser7");	
		String tcName="ARTURO'S #2 Order Guide";
		LoginData loginData =LoginData.fetch("$OMUser40");
	    OrderData orderData = OrderData.fetch("$OrderData65");
        System.out.println("login_data and order_data are ready");
        String key="Order Entry Submit_027";
		Start.asTester
			.goToLoginpage()
			.loginToApplication(loginData.UserName, loginData.Password)
			._GoToHomePage()
			.atHomePage()
			//.clickOnExpress()
			.atExpressHomePage()
			.atExpressOrderingPage()
			.startNewOrder()
			._GoOrderPage()
			.clickOnCreatNewOrder()
			._GoToListPage()
			.atListPage()
			.clickOnListTab()
			//.clickOnSyscoRecommendedLink(orderData.ListName)
			//.getListNumberForSyscoList(orderData.ListName,key)
			//.clickOnAnyListNumber(key)
			.clickOnSyscoLIst(tcName)
			._GoToListPage()
			.enterQuantityListMultiple(orderData.UPC.split(";"),orderData.CaseQuantity.split(";"))
			//.enterQuantityToItemInSyscoList(orderData.CaseQuantity)
			._GoOrderPage()
			.clickOnViewOrder()
			.clickSubmitOrder()
			.clickOrderReminderSubmitNormal()
			.clickOnAcknowledgementButton();
		
	
	}
	@Test(groups={"Order","SauceLabSmoke"}, description = "Order Entry Submit_028 :Submit order from Order guide ")
	@Features("Order Submit")
	@Stories("Order Entry Submit_028 :Submit order From order guide")
	public void SumitOrderFromOrderGuide() {	
		
		LoginData loginData =LoginData.fetch("$OMUser39");
		OrderData orderData = OrderData.fetch("$OrderData71");
		Start.asTester
		.goToLoginpage()
		.loginToApplication(loginData.UserName, loginData.Password)
		._GoToHomePage()
		.atHomePage()
		//.clickOnExpress()
		.atExpressHomePage()
		.startNewOrder()
		._GoOrderPage()
		.selectTypeFromDropDown(orderData.ProductFrom)
		.clickOnCreatNewOrder()
		._GoToOrdeGuidePage()
		.atOrderGuidePage()
		.enterOrderQuantity(orderData.UPC.split(";"),orderData.CaseQuantity.split(";"))
		.checkMultipleItem(orderData.UPC.split(";"))
		._GoOrderPage()
		.clickOnViewOrder()
		.clickSubmitOrder()
		.clickOrderReminderSubmitNormal()
		.clickOnAcknowledgementButton();
	}
	@Test(groups={"Order"}, description = "Order Entry Submit_031 : Submit 100 items")
	@Features("Order Submit")
	@Stories("Order Entry Submit_031 : Submit 100 items")
	public void SubmitMultipleItems() {	
		
		LoginData loginData =LoginData.fetch("$OMUser38");
		OrderData orderData1 = OrderData.fetch("$OrderData22");
		OrderPage orderPage=Start.asTester
		.goToLoginpage()
		.loginToApplication(loginData.UserName, loginData.Password)
		._GoToHomePage()
		.atHomePage()
		//.clickOnExpress()
		.atExpressHomePage()
		.startNewOrder()
		._GoOrderPage()
		.atCreateOrderPage()
		.selectTypeFromDropDown(orderData1.ProductFrom)
		.clickOnCreatNewOrder();

			ArrayList upc = new SupportFunctions().retrieveData("SELECT PGITEM FROM ESPGPGTF where PGAVSK<>0 and PGOPCO ='  020' and PGSTKI in('S')and PGITST not in('I') and PGITPR<>'Y'");
			for(int i=1;i<=10;i++){
				ArrayList arrFirstRow = (ArrayList)upc.get(i);
			    String upcNumber=(String) arrFirstRow.get(0);
			orderPage.enterQuickOrderEntryDetailsWithoutAdd(upcNumber.split(";"),orderData1.CaseQuantity.split(";"),orderData1.SplitQuantity.split(";"));
			
		}
		orderPage
		.clickOnAddToOrderInQuickOrder()
		//.addMultipleItems()
		//.clickOnViewOrder()
		.clickSubmitOrder()
		.clickOrderReminderSubmitNormal()
		.clickOnAcknowledgementButton()
		.close();
		
		
	}
	@Test(groups={"Order"}, description = "Order Entry Submit_032 :Submit the order")
	@Features("Order Submit")
	@Stories("Order Entry Submit_032 :Submit the order")
	public void submitOrder() {	
		
		LoginData loginData =LoginData.fetch("$OMUser37");
		OrderData orderData=OrderData.fetch("$OrderData28");
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
		.selectTypeFromDropDown(orderData.ProductFrom)
		.clickOnCreatNewOrder()
		.atQuickOrderEntryPagePopUp()
		.enterQuickOrderEntryDetailsWithoutAdd(orderData.UPC.split(";"),orderData.CaseQuantity.split(";"),orderData.SplitQuantity.split(";"))
		.clickOnAddToOrderInQuickOrder()
		.verifyOrderlandingPage()
		.clickSubmitOrder()
		.clickOrderReminderSubmitNormal()
		.clickOnAcknowledgementButton()
		.close();
	}
	@Test(groups={"Order","SauceLabSmoke"}, description = "Order Entry Submit_033 : Submit order from the List ")
	@Features("Order Submit")
	@Stories("Quick Order Entry_033 : Submit order from the List")
	public void submitOrderFromList(){
		String key="Quick Order Entry_033";
		    LoginData loginData =LoginData.fetch("$OMUser36");
		    OrderData orderData = OrderData.fetch("$OrderData116");
		   Start.asTester
		    .goToLoginpage()
		    .loginToApplication(loginData.UserName, loginData.Password)
		    ._GoToHomePage()
		    .atHomePage()
		    //.clickOnExpress()
		    .atExpressHomePage()	
		    ._GoOrderPage()
		    .orderPageTab()
			._GoToListPage()
			//Creating List
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
			.enterAnyItemInSearchBox(orderData.ItemName)
			.clickOnSearchButton()
			._GoToListPage()
			.checkOnItem(orderData.UPC.split(";"))
			.clickOnAddToList()
			.clickOnExistingList(key)
			.clickOnConform()
			.clickOnListTab()
			.clickOnMyListLink()
			.clickOnAnyListNumber(key)
			.clickOnEditList()
			//Entering List Quantity
			.enterListQuantity(orderData.UPC.split(";"),orderData.CaseQuantity.split(";"))
			//.clickOnSaveList()
			.clickOnSaveList1()
		    .selectUseListQuantityFromDropDown()
		    ._GoOrderPage()
			.clickOnCreatNewOrder()
		    ._GoOrderPage()
		    .clickOnViewOrder()
		    .clickSubmitOrder()
		    .clickOrderReminderSubmitNormal()
		    .clickOnAcknowledgementButton()
		    .close();
	}
	@Test(groups={"Order"}, description = "Order Entry Submit_029 :submit the product from the product grid")
	@Features("Order Submit")
	@Stories("Order Entry Submit_029 : submit the product from the product grid")
	public void submitOrderFromProduct() {	
		LoginData loginData =LoginData.fetch("$OMUser35");
		OrderData orderData = OrderData.fetch("$OrderData35");
		Start.asTester
		.goToLoginpage()
		.loginToApplication(loginData.UserName, loginData.Password)
		._GoToHomePage()
		.atHomePage()
		//.clickOnExpress()
		.atExpressHomePage()
		._GoOrderPage()
		.orderPageTab()
		._GoToHomePage()
		.startNewOrder()
		._GoOrderPage()
		.clickOnCreatNewOrder()
		._GoToProductCatalog()
		.clickOnProductTab()
		.clickOnProductCategory(orderData.ItemName.split(";")[0])
		.clickOnSelectedItem(orderData.ItemName.split(";")[1])
		.clickOnSelectedItem(orderData.ItemName.split(";")[2])
		._GoToListPage()
		.enterQuantitySearchMultiple(orderData.UPC.split(";"),orderData.CaseQuantity.split(";"))
		.clickOnViewOrder()
		._GoOrderPage()
		.clickSubmitOrder()
		.clickOrderReminderSubmitNormal()
		.clickOnAcknowledgementButton();
		
	}
	
	
	@Test(groups={"Order"}, description = "Order Entry Sumit_030 :Verification of order creation with Leaving soon and replaced by items")
	@Features("Order Submit")
	@Stories("Order Entry Sumit_030 :Verification of order creation with Leaving soon and replaced by items")
	public void searchItemSubmitOrder() {	
		
		LoginData loginData =LoginData.fetch("$OMUser33");
		OrderData orderData = OrderData.fetch("$OrderData38");
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
			.enterOrderQuantity(orderData.UPC, orderData.CaseQuantity)
			._GoOrderPage()
			.clickForPopup()
			.enterOrderName(orderData.OrderName)
			.clickOnCreatNewOrder()
			.clickOnViewOrder()
			.clickSubmitOrder()
			.clickOrderReminderSubmitNormal()
			.clickOnAcknowledgementButton()
			.close();
	}
	@Test(groups={"Order"}, description = "Quick Order_001 :Validation of Quick order entry")
	@Features("Order Submit")
	@Stories("Quick Order_001 :Validation of Quick order entry")
	public void StatusOfTheOrderWithDiffQuantity(){
		String key="Quick Order_001";
		LoginData loginData =LoginData.fetch("$NormalUser1");
		OrderData orderData1 =OrderData.fetch("$OrderData85");
		OrderData orderData2= OrderData.fetch("$OrderData17");
		OrderData orderData3= OrderData.fetch("$OrderData18");
		OrderData orderData4= OrderData.fetch("$OrderData110");
		OrderData orderData5= OrderData.fetch("$OrderData111");
		OrderData orderData6= OrderData.fetch("$OrderData118");
		//String[] splitCaseValue=(orderData1.CaseQuantity).split(";");
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
		.clickOnCreatNewOrder()
		._GoToHomePage()
		.getTextOrderNumber(key)
		._GoOrderPage()
		.orderPageTab()
		._GoToHomePage()
		.clickOnOpenOrderLink()
		.clickOnAnyOrder(key)
		.clickOnQuickOrderEntry()
		._GoOrderPage()
		.atQuickOrderEntryPagePopUp()
		.enterQuickOrderEntryDetailsWithoutAdd(orderData1.UPC.split(";"),orderData1.CaseQuantity.split(";"),orderData3.SplitQuantity.split(";"))
		.validateValidItemStatus(orderData1.UPC)
		.validateQuickOrderQunatity(orderData1.UPC,orderData1.CaseQuantity)
		.validateQuickSplitItem(orderData1.UPC,"")
		
		.enterQuickOrderEntryDetailsWithoutAdd("".split(";"), orderData2.CaseQuantity.split(";"),"".split(";"))
		.validateNullUpc(orderData2.UPC)
		
		
		.enterQuickOrderEntryDetailsWithoutAdd(orderData3.UPC.split(";"),orderData3.CaseQuantity.split(";") , orderData1.SplitQuantity.split(";"))
		.validateInvalidItemStatus(orderData3.UPC)
		.deleteRow(orderData3.UPC)
		
		.enterQuickOrderEntryDetailsWithoutAdd(orderData1.UPC.split(";"),orderData4.CaseQuantity.split(";"),orderData4.SplitQuantity.split(";"))
		.validateNotSplitItemStatus(orderData1.UPC)
		.validateQuickOrderQunatity(orderData1.UPC,orderData1.CaseQuantity)
		.validateQuickSplitItem(orderData1.UPC,"")
		
		.enterQuickOrderEntryDetailsWithoutAdd(orderData6.UPC.split(";"), orderData6.CaseQuantity.split(";"),orderData6.SplitQuantity.split(";"))
		.validateValidItemStatus(orderData6.UPC)
		.validateQuickOrderQunatity(orderData6.UPC,orderData6.CaseQuantity)
		.validateQuickSplitItem(orderData6.UPC,orderData6.SplitQuantity)
		
		.enterQuickOrderEntryDetailsWithoutAdd(orderData5.UPC.split(";"), orderData5.CaseQuantity.split(";"),orderData5.SplitQuantity.split(";"))
		.validateInvalidSplitItemStatus(orderData5.UPC)
		.validateQuickOrderQunatity(orderData5.UPC,orderData5.CaseQuantity)
		.validateQuickSplitItem(orderData5.UPC,orderData5.SplitQuantity)
		
		.enterQuickOrderEntryDetailsWithoutAdd(orderData5.UPC.split(";"), orderData3.CaseQuantity.split(";"),orderData3.SplitQuantity.split(";"))
		.validateInvalidSplitItemStatus(orderData5.UPC)
		.validateQuickOrderQunatity(orderData5.UPC,orderData3.CaseQuantity)
		.validateQuickSplitItem(orderData5.UPC,orderData5.SplitQuantity)
		
		.enterQuickOrderEntryDetailsWithoutAdd(orderData5.UPC.split(";"), orderData3.SplitQuantity.split(";"),orderData4.SplitQuantity.split(";"))
		.validateValidItemStatus(orderData5.UPC)
		.validateQuickOrderQunatity(orderData5.UPC,orderData5.CaseQuantity)
		.validateQuickSplitItem(orderData5.UPC,orderData4.SplitQuantity)
		
		.clickOnAddToOrderInQuickOrder()
		.clickSubmitOrder()
		.clickOrderReminderSubmitNormal()
		.clickOnAcknowledgementButton();
	}
	@Test(groups={"Order"}, description = "Quick Order_002 : Validation of Quick order entry")
	@Features("Order Submit")
	@Stories("Quick Order_002 : Validation of Quick order entry")
	public void validateOrderFromQuickOrder() {	
		LoginData loginData =LoginData.fetch("$OMUser32");
		OrderData orderData_01 = OrderData.fetch("$OrderData6");
		OrderData orderData_02 = OrderData.fetch("$OrderData7");
		OrderData orderData_03 = OrderData.fetch("$OrderData8");
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
			.enterOrderName(orderData_01.OrderName)
			.selectTypeFromDropDown(orderData_01.ProductFrom)
			.clickOnCreatNewOrder()
			.atQuickOrderEntryPagePopUp()
			
		    .enterQuickOrderEntryDetailsWithoutAdd(orderData_01.UPC.split(";"), orderData_01.CaseQuantity.split(";"),orderData_01.SplitQuantity.split(";"))
			.validateOrderInQuickOrderPopUp(orderData_01.UPC.split(";"), orderData_01.CaseQuantity.split(";"), orderData_01.SplitQuantity.split(";"))
			.validateQuickOrderQunatity(orderData_01.UPC,orderData_01.CaseQuantity)
			.validateQuickSplitItem(orderData_01.UPC,"")
			
			.enterQuickOrderEntryDetailsWithoutAdd(orderData_02.UPC.split(";"), orderData_02.CaseQuantity.split(";"),orderData_02.SplitQuantity.split(";"))
			.validateOrderInQuickOrderPopUp(orderData_02.UPC.split(";"), orderData_02.CaseQuantity.split(";"), orderData_02.SplitQuantity.split(";"))
			.validateQuickOrderQunatity(orderData_02.UPC,orderData_02.CaseQuantity)
			.validateQuickSplitItem(orderData_02.UPC,orderData_02.SplitQuantity)
			
			.enterQuickOrderEntryDetailsWithoutAdd(orderData_03.UPC.split(";"), orderData_03.CaseQuantity.split(";"),orderData_03.SplitQuantity.split(";"))
			.validateOrderInQuickOrderPopUp(orderData_03.UPC.split(";"), orderData_03.CaseQuantity.split(";"), orderData_03.SplitQuantity.split(";"))
			.validateQuickOrderQunatity(orderData_03.UPC,orderData_03.CaseQuantity)
			.validateQuickSplitItem(orderData_03.UPC,orderData_03.SplitQuantity)
			
		    .clickOnAddToOrderInQuickOrder()
			.clickSubmitOrder()
			.clickOrderReminderSubmitNormal()
			.clickOnAcknowledgementButton()
			.close();
			
			
	}
	@Test(groups={"Order"}, description = "Orders_Print_001 :Verification of print functionality for recent orders")
	@Features("Orders Print")
	@Stories("Orders_Print_001 :Verification of print functionality for recent orders")
	public void printRecentOrders(){
	String key="Orders_Print_001";
		LoginData loginData =LoginData.fetch("$OMUser31");
		Start.asTester
		.goToLoginpage()
		.loginToApplication(loginData.UserName, loginData.Password)
		._GoToHomePage()
		.atHomePage()
		//.clickOnExpress()
		.atExpressHomePage()	
		.atExpressHomePage()
		._GoOrderPage()
		.orderPageTab()
		.verifyOrderPage()
		._GoToHomePage()
		.clickOnSubmittedOrdersLink()
		._GoToHomePage()
		//Getting Submitted Order Number From DB
		.getOrderNumberFromDataBase('S',key,loginData.Customer)
		.clickOnAnyOrder(key)
		._GoOrderPage()
		.clickOnPrintOrder()
		//Validating Print Pop up Modal
		.validatePrintPopup()
		.clickOnCancelPrint();
	}
	@Test(groups={"Order"}, description = "Orders_Print_002 :Verification of print functionality from historical order details page")
	@Features("Orders Print")
	@Stories("Orders_Print_002 :Verification of print functionality from historical order details page")
	public void printHistoricalOrders(){
		String key="Orders_Print_002";
		LoginData loginData =LoginData.fetch("$OMUser30");
		OrderData orderData_02=OrderData.fetch("$OrderData34");
		Start.asTester
		.goToLoginpage()
		.loginToApplication(loginData.UserName, loginData.Password)
		._GoToHomePage()
		.atHomePage()
		//.clickOnExpress()
			.atExpressHomePage()	
			.atExpressOrderingPage()
			._GoToHomePage()
			.startNewOrder()
			._GoOrderPage()
			//Verifying Functionalities In create Order pop up
	        .selectTypeFromDropDown(orderData_02.ProductFrom)
	        .clickOnCreatNewOrder()
	        ._GoToHomePage()
	        .getOrderNumberFromDataBase('X',key,loginData.Customer)
	        .clickOnAnyOrder(key)
	        ._GoOrderPage()
		    .clickOnPrintOrder()
		    //Validating Print Pop up Modal
		    .validatePrintPopup()
		    .clickOnCancelPrint();
	}
	
	

	
}
