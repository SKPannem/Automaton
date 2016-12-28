package com.tests;

import java.awt.AWTException;

import org.testng.annotations.Test;

import com.components.entities.Start;
import com.components.pages.OrderPage;
import com.components.testdata.LoginData;
import com.components.testdata.OrderData;
import com.iwaf.framework.Initiator;

import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;


public class SMEHandPricing extends Initiator {
	@Test(groups={"HandPricing"}, description = "TS_SME_HandPricing_021 : Verify whether ALT+G is enabled in all screens")
	@Features("HandPricing")
	@Stories("TS_SME_HandPricing_021 : Verify whether ALT+G is enabled in all screens")
	
	public void detailsTabVerify() throws AWTException{
		
		LoginData loginData =LoginData.fetch("$HPriceSA2");
		OrderData orderData_003 =OrderData.fetch("$OrderData40");
		String key="TS_SME_HandPricing_021";
		String tcName="TS_SME_HandPricing_021";
			Start.asTester
				.goToLoginpage()
				.loginToApplication(loginData.UserName, loginData.Password)
				._GoToHomePage()
				.atHomePage()
				.clickOnExpress()
				.atExpressHomePage()
			    ._GoToOrdeGuidePage()
			    .clickOnOrderGuideTab()
			    .verifyPricingTab()
			    ._GoOrderPage()
			    .orderPageTab()
			    ._GoToHomePage()
			    .clickOnSubmittedOrdersLink()
			    .getOrderNumberFromDataBase('S',key,loginData.Customer)
		        .clickOnAnyOrder(key)
		        ._GoToOrdeGuidePage()
		        .verifyPricingTab()
		         ._GoToHomePage()
			   //Searching any Items
			    .enterAnyItemInSearchBox(orderData_003.ItemName)
			    .clickOnSearchButton()
			    ._GoOrderPage()
			    .checkOnItem(orderData_003.UPC.split(";"))
			    ._GoToListPage()
			    //Creating list
			    .clickOnAddToList()
			    .clickOnCreateNewListLink()
			    .enterListName(tcName)
			    .clickOnCreatNewListInAddListPopup()
		        ._GoToListPage()
		         .clickOnListTab()
			    .clickOnMyListLink()
			    .getListNumberByListName(tcName)
			    .clickOnAnyListNumber(tcName)
			    ._GoToOrdeGuidePage()
			    //Verifying pricing tab
			     .verifyPricingTab();
			
	}
	@Test(groups={"HandPricing"}, description = "TS_SME_HandPricing_027 : Verify whether hand pricing is lost once the user logs out of the session")
	@Features("HandPricing")
	@Stories("TS_SME_HandPricing_027 : Verify whether hand pricing is lost once the user logs out of the session")
    public void handPriceVerifyInMyList() throws AWTException{
		
		LoginData loginData =LoginData.fetch("$HPriceSA3");
		OrderData orderData_003 =OrderData.fetch("$OrderData40");
		String key="TS_SME_HandPricing_027";
		String tcName="TS_SME_HandPricing_027";
		String priceKey=loginData.UserName;
			Start.asTester
				.goToLoginpage()
				.loginToApplication(loginData.UserName, loginData.Password)
		         ._GoToHomePage()
		         .atHomePage()
				.clickOnExpress()
				.atExpressHomePage()
			   //Searching any Items
			    .enterAnyItemInSearchBox(orderData_003.ItemName)
			    .clickOnSearchButton()
			    ._GoOrderPage()
			    .checkOnItem(orderData_003.UPC.split(";"))
			    ._GoToListPage()
			    //Creating list
			    .clickOnAddToList()
			    .clickOnCreateNewListLink()
			    .enterListName(tcName)
			    .clickOnCreatNewListInAddListPopup()
		        ._GoToListPage()
		         .clickOnListTab()
			    .clickOnMyListLink()
			    .getListNumberByListName(tcName)
			    .clickOnAnyListNumber(tcName)
			    ._GoOrderPage()
			    .getOrigionalPrice(orderData_003.UPC,priceKey)
			    .enterHandPrice(orderData_003.UPC)
			    .verifyHandPrice(orderData_003.UPC, priceKey)
			    .close()
			    ._GoToLoginPage()
			    .loginToApplication(loginData.UserName, loginData.Password)
	            ._GoToHomePage()
		         .atHomePage()
				.clickOnExpress()
				._GoToListPage()
		         .clickOnListTab()
			    .clickOnMyListLink()
			    .clickOnAnyListNumber(tcName)
			    ._GoOrderPage()
			    //Verifying hand price after log out
			    .verifyHandPriceAfterLogOut(orderData_003.UPC, priceKey)
			    ;
	
			
	}
	@Test(groups={"HandPricing"}, description = "TS_SME_HandPricing_028 : Verify while creating an order hand pricing is effective for the item .")
	@Features("HandPricing")
	@Stories("TS_SME_HandPricing_028 : Verify while creating an order hand pricing is effective for the item .")
    public void handPriceVerifyInOrder() throws AWTException{
		
		LoginData loginData =LoginData.fetch("$HPriceSA4");
		OrderData orderData_003 =OrderData.fetch("$OrderData40");
		OrderData orderData_004 =OrderData.fetch("$OrderData109");
		String tcName="TS_SME_HandPricing_028";
		String priceKey=loginData.UserName;
		String key="handPriceVerifyInOrder";
			Start.asTester
				.goToLoginpage()
				.loginToApplication(loginData.UserName, loginData.Password)
		         ._GoToHomePage()
		         .atHomePage()
				.clickOnExpress()
				.atExpressHomePage()
			  //Searching any Items
			    .enterAnyItemInSearchBox(orderData_003.ItemName)
			    .clickOnSearchButton()
			    ._GoOrderPage()
			    .checkOnItem(orderData_003.UPC.split(";"))
			    ._GoToListPage()
			    //Creating list
			    .clickOnAddToList()
			    .clickOnCreateNewListLink()
			    .enterListName(tcName)
			    .clickOnCreatNewListInAddListPopup()
		        ._GoToListPage()
		         .clickOnListTab()
			    .clickOnMyListLink()
			    .getListNumberByListName(tcName)
			    .clickOnAnyListNumber(tcName)
			    ._GoOrderPage()
			    .getOrigionalPrice(orderData_003.UPC,priceKey)
			    .enterHandPrice(orderData_003.UPC)
			    .verifyHandPrice(orderData_003.UPC, priceKey)
			    .orderPageTab()
			    ._GoToHomePage()
			    //Creating Order
			    .startNewOrder()
		        ._GoOrderPage()
		        .enterOrderName(orderData_004.OrderName)
		        .selectTypeFromDropDown(orderData_004.ProductFrom)
		        .clickOnCreatNewOrder()
		        ._GoToHomePage()
		        ._GoToListPage()
			    .clickOnMyListLink()
			    .clickOnAnyListNumber(tcName)
			    .enterQuantityListMultiple(orderData_003.UPC.split(";"),orderData_003.CaseQuantity.split(";"))
			    .clickOnViewOrder()
			    ._GoToHomePage()
			     .getTextOrderNumber(key)
			    ._GoOrderPage()
			    .verifyHandPrice(orderData_003.UPC, priceKey)
			   ._GoToOrdeGuidePage()
			   .clickOnOrderGuideTab()
			   .enterOrderQuantity(orderData_004.UPC.split(";"),orderData_004.CaseQuantity.split(";"))
			   .clickOnViewOrder()
			   ._GoOrderPage()
			   .clickSubmitOrder()
			   .clickOrderReminderSubmitNormal()
			   .verifyAndConfirmOrder()
			   ._GoToHomePage()
			   .clickOnSubmittedOrdersLink()
			   .clickOnAnyOrder(key)
			   ._GoOrderPage()
			   //Verifying hand price for submitted order
			   .verifyHandPriceSubmittedOrder(orderData_003.UPC, priceKey)
			    ;
	
			
	}
	@Test(groups={"HandPricing"}, description = "TS_SME_HandPricing_034 : Verify whether the SUPC of an item is clickable and validate whether ASOH of the item is getting displayed.")
	@Features("HandPricing")
	@Stories("TS_SME_HandPricing_034 : Verify whether the SUPC of an item is clickable and validate whether ASOH of the item is getting displayed")
    public void verifyInventory() throws AWTException{
		
		LoginData loginData =LoginData.fetch("$HPriceSA5");
		OrderData orderData_003 =OrderData.fetch("$OrderData115");
		String data_Items=orderData_003.ItemName;
	    String[] arrData_Items=data_Items.split(";");
			Start.asTester
				.goToLoginpage()
				.loginToApplication(loginData.UserName, loginData.Password)
		         ._GoToHomePage()
		         .atHomePage()
				.clickOnExpress()
				.atExpressHomePage()
				._GoToProductCatalog()
			    .clickOnProductTab()
			    .clickOnProductCategory(arrData_Items[0])
	           .clickOnSubCategory(arrData_Items[1])
	           .clickOnSelectedItem(arrData_Items[2])
	           ._GoToHomePage()
	           .enterUPCInSearchBox(orderData_003.UPC)
	           //Verifying inventory
	           .clickOnSUPCVerifyInventory(orderData_003.UPC);
			   
	
			
	}
	@Test(groups={"HandPricing"}, description = "TS_SME_HandPricing_036 : Verify whether the user is able to hand price the items after modifying an order.")
	@Features("HandPricing")
	@Stories("TS_SME_HandPricing_036 : Verify whether the user is able to hand price the items after modifying an order.")
    public void verifyHandPriceModifyOrder() throws AWTException{
		
		LoginData loginData =LoginData.fetch("$HPriceSA6");
		OrderData orderData_004 =OrderData.fetch("$OrderModifyHP");
		String strKeyOrder="TS_SME_HandPricing_036";
		String priceKey=loginData.UserName;
			Start.asTester
				.goToLoginpage()
				.loginToApplication(loginData.UserName, loginData.Password)
		         ._GoToHomePage()
		         .atHomePage()
				.clickOnExpress()
				.atExpressHomePage()
				._GoOrderPage()
				.orderPageTab()
				._GoToHomePage()
			    .startNewOrder()
		        ._GoOrderPage()
		        .enterOrderName(orderData_004.OrderName)
		        .selectTypeFromDropDown(orderData_004.ProductFrom)
		        .clickOnCreatNewOrder()
	            //Adding items and creating order through QOE
	          .enterQuickOrderEntryDetailsWithoutAdd(orderData_004.UPC.split(";"),orderData_004.CaseQuantity.split(";"),orderData_004.SplitQuantity.split(";"))
	           .clickOnAddToOrderInQuickOrder()
	            ._GoToHomePage()
		      .getTextOrderNumber(strKeyOrder)
		     ._GoOrderPage()
		       .clickSubmitOrder()
		       .clickOrderReminderSubmitNormal()
		         .verifyAndConfirmOrder()
		         .orderPageTab()
		         .orderPageTab()
			   ._GoToHomePage()
			   .clickOnSubmittedOrdersLink()
			   .clickOnAnyOrder(strKeyOrder)
			   .clickOnModifyInSubmittedOrder()
			   .acceptAlert_Modify()
			   ._GoOrderPage()
			    .getOrigionalPrice(orderData_004.UPC,priceKey)
			    .enterHandPrice(orderData_004.UPC)
			    .verifyHandPrice(orderData_004.UPC, priceKey)
			    ._GoOrderPage()
			   .clickSubmitOrder()
			   .clickOrderReminderSubmitNormal()
			   .verifyAndConfirmOrder()
			   ._GoToHomePage()
			   .clickOnSubmittedOrdersLink()
			   .clickOnAnyOrder(strKeyOrder)
			   ._GoOrderPage()
			   .verifyHandPriceSubmittedOrder(orderData_004.UPC, priceKey)
			   ;
			 
			   	
	}
	@Test(groups={"HandPricing"}, description = "TS_SME_Set_PMT_012 : Verify whether Set PMT feature is not available for users other than sales associate")
	@Features("HandPricing")
	@Stories("TS_SME_Set_PMT_012 : Verify whether Set PMT feature is not available for users other than sales associate")
    public void verifySetPMT() throws AWTException{
		
		LoginData loginData1 =LoginData.fetch("$HPriceNU");
		LoginData loginData2 =LoginData.fetch("$HPriceMA");
		LoginData loginData3 =LoginData.fetch("$HPriceMB");
		LoginData loginData4 =LoginData.fetch("$HPriceSA1");
			Start.asTester
				.goToLoginpage()
				.loginToApplication(loginData4.UserName, loginData4.Password)
		         ._GoToHomePage()
		         .atHomePage()
				.clickOnExpress()
				.atExpressHomePage()
		        ._GoToOrdeGuidePage()
			    .clickOnOrderGuideTab()
			    .verifyPMTColumnSA("Sales associate User")
			    ._GoOrderPage()
			    .close()
			    ._atLoginPage()
				.loginToApplication(loginData3.UserName, loginData3.Password)
		         ._GoToHomePage()
		         .atHomePage()
				.clickOnExpress()
				.atExpressHomePage()
		        ._GoToOrdeGuidePage()
			    .clickOnOrderGuideTab()
			    .verifyPMTColumnOtherUser("MultiBuyer User")
			    ._GoOrderPage()
			    .close()
			    ._atLoginPage()
				.loginToApplication(loginData2.UserName, loginData2.Password)
		         ._GoToHomePage()
		         .atHomePage()
				.clickOnExpress()
				.atExpressHomePage()
		        ._GoToOrdeGuidePage()
			    .clickOnOrderGuideTab()
			    .verifyPMTColumnOtherUser("MultiApprover User")
			    ._GoOrderPage()
			    .close()
			    ._atLoginPage()
				.loginToApplication(loginData1.UserName, loginData1.Password)
		         ._GoToHomePage()
		         .atHomePage()
				.clickOnExpress()
				.atExpressHomePage()
		        ._GoToOrdeGuidePage()
			    .clickOnOrderGuideTab()
			    .verifyPMTColumnOtherUser("Normal User")
			    ._GoOrderPage()
			    .close()
			    
			   ;
			 
			   	
	}
	@Test(groups={"HandPricing"}, description = "TS_SME_Set_PMT_002 : Verify whether the user is able to enable set PMT check box for all hand pricable items across all screens")
	@Features("HandPricing")
	@Stories("TS_SME_Set_PMT_002 : Verify whether the user is able to enable set PMT check box for all hand pricable items across all screens")
    public void verifySetPMTAllPages() throws AWTException{
		
		LoginData loginData4 =LoginData.fetch("$HPriceSA7");
		OrderData pmt1 =OrderData.fetch("$OrderData127");
		OrderData pmt2 =OrderData.fetch("$OrderData128");
		OrderData pmt3 =OrderData.fetch("$OrderData129");
		OrderData pmt4 =OrderData.fetch("$OrderData130");
		
		String data_Items=pmt3.ItemName;
	    String[] arrData_Items=data_Items.split(";");
		String key="TS_SME_Set_PMT_002";
			Start.asTester
				.goToLoginpage()
				.loginToApplication(loginData4.UserName, loginData4.Password)
		         ._GoToHomePage()
		         .atHomePage()
				.clickOnExpress()
				.atExpressHomePage()
		        ._GoToOrdeGuidePage()
			    .clickOnOrderGuideTab()
			    .verifyPMTColumnSA("Sales associate User")
			    .enterTypeInSearchBox(pmt1.UPC)
			    .clickOnPMTCheckBox(pmt1.UPC)
				.verifyPMTCheckBox(pmt1.UPC)
				.setHandPrice(pmt1.UPC)
			    .checkMultipleItem(pmt2.UPC.split(";"))
		        ._GoToListPage()
		        .clickOnAddToList()
		        .clickOnCreateNewListLink()
		        .enterListName(key)
	        	.clickOnCreatNewListInAddListPopup()
		        .clickOnListTab()
		        .clickOnMyListLink()
		        .getListNumberByListName(key)
		        .clickOnAnyListNumber(key)
		        ._GoToOrdeGuidePage()
		        .clickOnPMTCheckBox(pmt2.UPC)
				.verifyPMTCheckBox(pmt2.UPC)
				._GoToProductCatalog()
			    .clickOnProductTab()
			     .clickOnProductCategory(arrData_Items[0])
	             .clickOnSubCategory(arrData_Items[1])
	             .clickOnSelectedItem(arrData_Items[2])
	             ._GoToHomePage()
	              .enterUPCInSearchBox(pmt3.UPC)
	             ._GoToOrdeGuidePage()
		         .clickOnPMTCheckBox(pmt3.UPC)
				 .verifyPMTCheckBox(pmt3.UPC)
				 ._GoToHomePage()
				 .enterAnyItemInSearchBox(pmt4.UPC)
			     .clickOnSearchButton()
			     ._GoToOrdeGuidePage()
			     .clickOnPMTCheckBox(pmt4.UPC)
				 .verifyPMTCheckBox(pmt4.UPC)
			   ;
			 
			   	
	}
	@Test(groups={"HandPricing"}, description =  "TS_SME_HandPricing_001 : Verify whether the user is able to hand price an inactive item")
	@Features("HandPricing")
	@Stories("TS_SME_HandPricing_001 :Verify whether the user is able to hand price an inactive item")
	public void TS_SME_HandPricing_001 (){	
		
		LoginData loginData =LoginData.fetch("$SALES002");	
		OrderData orderData=OrderData.fetch("$HandPriceOrderData");
		
		Start.asTester
		.goToLoginpage()
		.loginToApplication(loginData.UserName, loginData.Password)
		._GoToHomePage()
		.atHomePage()
		.clickOnExpress()
		.atExpressHomePage()
		._GoItemDeletePage()
		
		.clickListTab()
		.createNewList()
		.create_NewMyListNew()
		.addInactiveItemtoList(loginData.OpCo, loginData.CustomerName, "I")
		._GoItemDeletePage()
		.inActiveItemToList()
		.clickListTab()
		.checkMyList()
		.UpdateMylistItemPrice()
		;
		
		
	

}
}
