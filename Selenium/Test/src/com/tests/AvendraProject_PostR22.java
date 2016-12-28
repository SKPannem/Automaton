package com.tests;

import java.awt.AWTException;

import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

import com.components.entities.Start;
import com.components.testdata.LoginData;
import com.components.testdata.OrderData;
import com.iwaf.framework.Initiator;

public class AvendraProject_PostR22 extends Initiator {
	
	@Test(groups={"Avendra_Project"}, description = "Verify whether the user is able to submit an order with avendra items")
	@Features("Avendra_Project")
	@Stories("TS_AvendraIcon_001:Verify whether the user is able to submit an order with avendra items")
	public void TS_AvendraIcon_001() {	
		
		//Please do and verify the test data set up before executing this test cases 
		//Test data used here are 5388053 - 2010569,1061415-2090520
		
		LoginData loginData =LoginData.fetch("$AvendraUser");
		OrderData orderData_Avendra = OrderData.fetch("$AvendraOrderData");
		OrderData orderData_Avendra_Sub = OrderData.fetch("$AvendraSubOrderData");
		
		String upc=orderData_Avendra.UPC;
		String[] arrUPC=upc.split(";");
		String quantity=orderData_Avendra.CaseQuantity;
		String[] arrQuantity=quantity.split(";");
		String splitValue=orderData_Avendra.SplitQuantity;
		String[] arrSplitValue=splitValue.split(";");
		String key="TS_AvendraIcon_001";
		
		String strSubItems=orderData_Avendra_Sub.UPC;
		String[] strItems=strSubItems.split(";");
		
		Start.asTester
		.goToLoginpage()
		.loginToApplication(loginData.UserName, loginData.Password)
		._GoToHomePage()
		.atHomePage()
		.clickOnExpress()
		.verifyHomePage()
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
		.iteminsearchbox2(arrUPC[0])
		//Adding Items to List
		._GoToListPage()
		.checkOnItem(arrUPC)
		.clickOnAddToList()
		.clickOnExistingList(key)
		.clickOnConform()
		._GoOrderPage()
		.orderPageTab()
		.verifyOrderPage()
        ._GoToHomePage()
        .startNewOrder()
        ._GoOrderPage()
		.atCreateOrderPage()
		//Creating Order From Quick Order
		.selectTypeFromDropDown(orderData_Avendra.ProductFrom)
		.clickOnCreatNewOrder()
		.atQuickOrderEntryPagePopUp()
		//Adding 2 items 
		.enterQuickOrderEntryDetailsWithoutAdd(arrUPC,arrQuantity,arrSplitValue)
	    .clickOnAddToOrderInQuickOrder()
		.clickSubmitOrder()
		.verifyProductReminderModel()
		.verifySubstituteItemInModel(strItems[0])
		.clickVerifyTickMarkAndYNButton(strItems[0],"Y")
		._GoToListPage()
		.clickOnExistingList(key)
		.clickOnConform()
		._GoOrderPage()
		.clickOnCloseButton()
		.clickOnCrossImage(strItems[0])
		.clickVerifyTickMarkAndYNButton(strItems[0],"N")
		.clickOnContinueButtonOnOrderRemainder()
		.verifyAndConfirmOrder();
		 
	}
	
	@Test(groups={"Avendra_Project"}, description = "TS_HandpriceOOE_001:Verify whether the hand price of an item is retained after adding it to the modified order via OOE")
	@Features("Avendra_Project")
	@Stories("TS_HandpriceOOE_001:Verify whether the hand price of an item is retained after adding it to the modified order via OOE")
	public void TS_HandpriceOOE_001() throws AWTException {	
		
		LoginData loginData =LoginData.fetch("$R22SAUser");
		OrderData handPrice_01=OrderData.fetch("$HandPriceQOE_01");
		OrderData handPrice_02=OrderData.fetch("$HandPriceQOE_02");
		String strKeyHandPrice_01="TS_HandpriceOOE_001_01";
		String strKeyHandPrice_02="TS_HandpriceOOE_001_02";
		String strKeyOrder="TS_HandpriceOOE_001_SubOrder";
		
		Start.asTester
		.goToLoginpage()
		.loginToApplication(loginData.UserName, loginData.Password)
		._GoToHomePage()
		.atHomePage()
		.clickOnExpress()
		.atExpressHomePage()
		.startNewOrder()
		.verifyCreateOrderpage()
		._GoOrderPage()
		//.selectTypeFromDropDown(orderdata.ProductFrom)
		.clickOnCreatNewOrder()
		._GoToHomePage()
		//handPricing the items
		.iteminsearchbox2(handPrice_01.UPC)
		._GoOrderPage()
	    .getOrigionalPrice(handPrice_01.UPC,strKeyHandPrice_01)
	    .enterHandPrice(handPrice_01.UPC)
	    ._GoToHomePage()
	    .iteminsearchbox2(handPrice_02.UPC)
		._GoOrderPage()
	    .getOrigionalPrice(handPrice_02.UPC,strKeyHandPrice_02)
	    .enterHandPrice(handPrice_02.UPC)
	    .clickOnViewOrder()
	    ._GoToHomePage()
	    .clickOnQuickOrderEntry()
	    ._GoOrderPage()
	    //Adding items and creating order through QOE
	    .enterQuickOrderEntryDetailsWithoutAdd(handPrice_01.UPC.split(";"),handPrice_01.CaseQuantity.split(";"),handPrice_01.SplitQuantity.split(";"))
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
		.clickOnAnyOrder(strKeyOrder)
		.clickOnModifyInSubmittedOrder()
		.acceptAlert_Modify()
		.clickOnQuickOrderEntry()
		._GoOrderPage()
		//Adding some more items through QOE
		.enterQuickOrderEntryDetailsWithoutAdd(handPrice_02.UPC.split(";"),handPrice_02.CaseQuantity.split(";"),handPrice_02.SplitQuantity.split(";"))
        .clickOnAddToOrderInQuickOrder()
		 .orderPageTab()
		 .clickOnViewOrder()
		 //Verifying hand-price
		 .verifyHandPrice(handPrice_01.UPC, strKeyHandPrice_01)
		 .verifyHandPrice(handPrice_02.UPC, strKeyHandPrice_02)
		;
		
	}
}
