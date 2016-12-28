package com.tests;

import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

import com.components.entities.Start;
import com.components.testdata.LoginData;
import com.components.testdata.OrderData;
import com.iwaf.framework.Initiator;

public class HomePageValidation extends Initiator {
	@Test(groups={"Home_Page"}, description = "Home Page_006 :Validating Search in different screens")
	@Features("Search Functionality")
	@Stories("Home Page_006 :Validating Search in different screens")
	public void ValidateSeach() {	
		
		LoginData loginData =LoginData.fetch("$NormalUser20");
		OrderData orderData_Valid=OrderData.fetch("$OrderData102");
		OrderData orderData_InValid=OrderData.fetch("$OrderData103");
   Start.asTester
		.goToLoginpage()
		.loginToApplication(loginData.UserName, loginData.Password)
		._GoToHomePage()
		.atHomePage()
		//.clickOnExpress()
		.atExpressHomePage()
		.atExpressOrderingPage()
		.clickOnHomePageTab()
		.verifySearchBox()
		._GoOrderPage()
		.orderPageTab()
		._GoToHomePage()
		.verifySearchBox()
		._GoToListPage()
		.clickOnListTab()
		._GoToHomePage()
		.verifySearchBox()
		._GoToOrdeGuidePage()
		.clickOnOrderGuideTab()
		._GoToHomePage()
		.verifySearchBox()
		._GoToProductCatalog()
		.clickOnProductTab()
		._GoToHomePage()
		.verifySearchBox()
		.enterAnyItemInSearchBox(orderData_Valid.ItemName)
		.clickOnSearchButton()
		.verifyValidItemName(orderData_Valid.ItemName)
		.enterAnyItemInSearchBox(orderData_InValid.ItemName)
		.clickOnSearchButton()
		.verifyInValidItemName(orderData_InValid.ItemName)
		.enterAnyItemInSearchBox(orderData_Valid.UPC)
		.clickOnSearchButton()
		.verifyValidItem(orderData_Valid.UPC)
		.enterAnyItemInSearchBox(orderData_InValid.UPC)
		.clickOnSearchButton()
		.verifyInvalidItem(orderData_InValid.UPC)
		.enterAnyItemInSearchBox(orderData_Valid.BrandName)
		.clickOnSearchButton()
		.verifyValidBrandName(orderData_Valid.BrandName)
		.enterAnyItemInSearchBox(orderData_InValid.BrandName)
		.clickOnSearchButton()
		.verifyInValidBrandName(orderData_InValid.BrandName)
		._GoToHomePage()
		.enterAnyItemInSearchBox(orderData_Valid.BrandName.substring(0, 3))
		.verifyDropDownInSearchBox(orderData_Valid.BrandName.substring(0, 3));
		
		
	}
	@Test(groups={"Home_Page"}, description = "Home Page_009 : Verifying Order In Header Area")
	@Features("Page Navigation")
	@Stories("Home Page_009 :Verifying Order In Header Area ")
	public void ValidateOrder() {	
		
		LoginData loginData =LoginData.fetch("$NormalUser21");
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
		._GoToHomePage()
		.clickOnHomePageTab()
		.verifyOrder()
		._GoOrderPage()
		.orderPageTab()
		._GoToHomePage()
		.verifyOrder()
		._GoToListPage()
		.clickOnListTab()
		._GoToHomePage()
		.verifyOrder()
		._GoToProductCatalog()
		.clickOnProductTab()
		._GoToHomePage()
		.verifyOrder()
		._GoToOrdeGuidePage()
		.clickOnOrderGuideTab()
		._GoToHomePage()
		.verifyOrder()
		.clickOnOrder()
		._GoOrderPage()
		.verifyOrderlandingPage();
	}
	@Test(groups={"Home_Page"}, description = "Home Page_010 : Verifying List Page")
	@Features("Page Navigation")
	@Stories("Home Page_010 :Verifying List Page")
	public void VerifyListPage() {	
		
		LoginData loginData =LoginData.fetch("$NormalUser1");
		Start.asTester
		.goToLoginpage()
		.loginToApplication(loginData.UserName, loginData.Password)
		._GoToHomePage()
		.atHomePage()
		//.clickOnExpress()
		.atExpressHomePage()
		.atExpressOrderingPage()
		.clickOnHomePageTab()
		._GoToListPage()
		.verifyList()
		._GoOrderPage()
		.orderPageTab()
		._GoToListPage()
		.verifyList()
		._GoToOrdeGuidePage()
		.clickOnOrderGuideTab()
		._GoToListPage()
		.verifyList()
		._GoToProductCatalog()
		.clickOnProductTab()
		._GoToListPage()
		.clickOnListTab()
		.verifyList()
		._GoToHomePage()
		.verifyListpage();
		
	}
	@Test(groups={"Home_Page"}, description = "Home Page_011 : Verifying Order Guide In Header Area")
	@Features("Page Navigation")
	@Stories("Home Page_011 :Verifying Order Guide In Header Area ")
	public void VerifyOrderGuidePage() {	
		
		LoginData loginData =LoginData.fetch("$NormalUser22");
		Start.asTester
		.goToLoginpage()
		.loginToApplication(loginData.UserName, loginData.Password)
		._GoToHomePage()
		.atHomePage()
		//.clickOnExpress()
		.atExpressHomePage()
		.atExpressOrderingPage()
		.clickOnHomePageTab()
		._GoToOrdeGuidePage()
		.verifyOrderGuideButton()
		._GoOrderPage()
		.orderPageTab()
		._GoToOrdeGuidePage()
		.verifyOrderGuideButton()
		._GoToListPage()
		.clickOnListTab()
		._GoToOrdeGuidePage()
		.verifyOrderGuideButton()
		._GoToProductCatalog()
		.clickOnProductTab()
		._GoToOrdeGuidePage()
		.clickOnOrderGuideTab()
		.verifyOrderGuideButton();
	}
	@Test(groups={"Home_Page"}, description = "Home Page_012 : Verifying Product Tab In Header Area")
	@Features("Page Navigation")
	@Stories("Home Page_012 :Verifying Product Tab In Header Area ")
	public void VerifyProductPage() {	
		
		LoginData loginData =LoginData.fetch("$NormalUser23");
		OrderData orderData = OrderData.fetch("$OrderData5");
		 String data_Items=orderData.ItemName;
		 String[] arrData_Items=data_Items.split(";");
		Start.asTester
		.goToLoginpage()
		.loginToApplication(loginData.UserName, loginData.Password)
		._GoToHomePage()
		.atHomePage()
		//.clickOnExpress()
		.atExpressHomePage()
		.atExpressOrderingPage()
		.clickOnHomePageTab()
		._GoToProductCatalog()
		.verifyProductButton()
		._GoOrderPage()
		.orderPageTab()
		._GoToProductCatalog()
		.verifyProductButton()
		._GoToOrdeGuidePage()
		.clickOnOrderGuideTab()
		._GoToProductCatalog()
		.verifyProductButton()
		._GoToProductCatalog()
		.clickOnProductTab()
		.verifyProductButton()
		.verifyBrowseCatalogOption()
		.clickOnProductCategory(arrData_Items[0])
		.verifyShowAllCategoryOption();
		
	}
	
	@Test(groups={"Home_Page","SauceLabSmoke"}, description = "Home Page_025_01 : Validate View order button for all users which have active orders")
	@Features("View Order")
	@Stories("Home Page_025_01 :Validate View order button for all users which have active orders")
	public void VerfiyViewOrderInAllPageWithActiveOrder() {	
		
		LoginData loginData =LoginData.fetch("$NormalUser24");
		OrderData orderData=OrderData.fetch("$OrderData90");
		Start.asTester
		.goToLoginpage()
		.loginToApplication(loginData.UserName, loginData.Password)
		._GoToHomePage()
		.atHomePage()
		//.clickOnExpress()
		.atExpressHomePage()
		.atExpressOrderingPage()
		//Creating Order
		.startNewOrder()
		._GoOrderPage()
		.atCreateOrderPage()
		.enterOrderName(orderData.OrderName)
		.selectTypeFromDropDown(orderData.ProductFrom)
		.clickOnCreatNewOrder()
		.atQuickOrderEntryPagePopUp()
		.enterQuickOrderEntryDetailsWithoutAdd(orderData.UPC.split(";"),orderData.CaseQuantity.split(";"),orderData.SplitQuantity.split(";"))
		.clickOnAddToOrderInQuickOrder()
		//Verifying view Order button in each page
		._GoToHomePage()
		.clickOnHomePageTab()
		._GoOrderPage()
		.verifyViewOrderButton()
		._GoOrderPage()
		.orderPageTab()
		.verifyViewOrderButton()
		._GoToProductCatalog()
		.clickOnProductTab()
		._GoOrderPage()
		.verifyViewOrderButton()
		._GoToListPage()
		.clickOnListTab()
		._GoOrderPage()
		.verifyViewOrderButton()
		._GoToOrdeGuidePage()
		.clickOnOrderGuideTab()
		._GoOrderPage()
		.verifyViewOrderButton()
		//Verify Active Order
		._GoToHomePage()
		.clickOnHomePageTab()
		._GoOrderPage()
		.clickOnViewOrder()
	    ._GoToOrdeGuidePage()
		.validateUPC(orderData.UPC)
		._GoOrderPage()
		.orderPageTab()
		.clickOnViewOrder()
		._GoToOrdeGuidePage()
		.validateUPC(orderData.UPC)
		._GoToListPage()
		.clickOnListTab()
		._GoOrderPage()
		.clickOnViewOrder()
		._GoToOrdeGuidePage()
		.validateUPC(orderData.UPC)
		._GoToProductCatalog()
		.clickOnProductTab()
		._GoOrderPage()
		.clickOnViewOrder()
		._GoToOrdeGuidePage()
		.validateUPC(orderData.UPC)
		._GoToOrdeGuidePage()
		.clickOnOrderGuideTab()
		._GoOrderPage()
		.clickOnViewOrder()
		._GoToOrdeGuidePage()
		.validateUPC(orderData.UPC)
		._GoOrderPage()
		//submit The Order
		.clickSubmitOrder()
		.clickOrderReminderSubmitNormal()
		.clickOnAcknowledgementButton();

	}
	@Test(groups={"Home_Page"}, description = "Home Page_025_02 : Validate View order button for all users which does not have active orders.")
	@Features("View Order")
	@Stories("Home Page_025_02 :Validate View order button for all users which does not have active orders.")
	public void VerfiyViewOrderInAllPageWithOutActiveOrder() {	
		String strKeyOrder="Home Page_025_02";
		LoginData loginData =LoginData.fetch("$NormalUser25");
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
				.clickOnHomePageTab()
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
				._GoToHomePage()
				.clickOnHomePageTab()
				.verifyViewOrderWithoutOrder()
				._GoOrderPage()
				.orderPageTab()
				._GoToHomePage()
				.verifyViewOrderWithoutOrder()
				._GoToProductCatalog()
				.clickOnProductTab()
				._GoToHomePage()
				.verifyViewOrderWithoutOrder()
				._GoToListPage()
				.clickOnListTab()
				._GoToHomePage()
				.verifyViewOrderWithoutOrder()
				._GoToOrdeGuidePage()
				.clickOnOrderGuideTab()
				._GoToHomePage()
				.verifyViewOrderWithoutOrder()
				._GoOrderPage()
				.orderPageTab()
				._GoToHomePage()
				.clickOnSubmittedOrdersLink()
				.clickOnAnyOrder(strKeyOrder)
				.clickOnModifyInSubmittedOrder()
				.acceptAlert_Modify()
				// Verifying View Order Button After Modify
				.clickOnHomePageTab()
				._GoOrderPage()
				.verifyViewOrderButton()
				._GoOrderPage()
				.orderPageTab()
				.verifyViewOrderButton()
				._GoToListPage()
				.clickOnListTab()
				._GoOrderPage()
				.verifyViewOrderButton()
				._GoToProductCatalog()
				.clickOnProductTab()
				._GoOrderPage()
				.verifyViewOrderButton()
				._GoToOrdeGuidePage()
				.clickOnOrderGuideTab()
				._GoOrderPage()
				.verifyViewOrderButton()
				.clickOnViewOrder()
				.selectDeliveryDateAfterModify()
				.clickSubmitOrder()
				.clickOrderReminderSubmitNormal()
				.verifyAndConfirmOrder();
		
	}

}
