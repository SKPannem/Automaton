package com.tests;

import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

import com.components.entities.Start;
import com.components.testdata.LoginData;
import com.components.testdata.OrderData;
import com.iwaf.framework.Initiator;

public class COGM_SilverExpressSearch extends Initiator{
	
	/*
	 * TC_ImageSearch_002 and TS_SilverSearch_001 are merged together 
	 */
	@Test(groups={"Conduct a Search"}, description = "TS_SilverSearch_001:Verify whether CAKE descriptions are getting displayed on My Lists page when logged in as Normal user")
	@Features("Conduct a Search")
	@Stories("TS_SilverSearch_001:Verify whether CAKE descriptions are getting displayed on My Lists page when logged in as Normal user")
	public void TS_SilverSearch_001() {	
		
		
		
	
		LoginData loginData =LoginData.fetch("$COGMFlex2N");
		OrderData orderData =OrderData.fetch("$COGM_ItemMylist");
		String tcName="TS_SilverSearch_001";
			Start.asTester
			.goToLoginpage()
			.loginToApplication(loginData.UserName, loginData.Password)
			._GoToHomePage()
			.atHomePage()
			.clickOnExpress()
			.atExpressHomePage()
			._GoToListPage()
			.clickOnListTab()
			.clickOnCreateNewList()
			.enterListNameInPopup(tcName)
			.clickOnCreateList()
			.clickOnListTab()
			._GoToHomePage()
			.verifyListpage()
			._GoToListPage()
			.clickOnMyListLink()
			.getListNumberByListName(tcName)
			._GoToHomePage()
			//Adding Items to List
			.enterAnyItemInSearchBox(orderData.UPC)
			.clickOnSearchButton()
			.checkOnAllItem()
			._GoToListPage()
			.clickOnAddToList()
			.clickOnExistingList(tcName)
			.clickOnConform()
			.clickOnListTab()
			.clickOnMyListLink()
			.clickOnAnyListNumber(tcName)
			._GoToHomePage()
			.searchOnPrductDescription(orderData.UPC,orderData.ItemName )
			.checkImagenotPresent(orderData.UPC)
			;
		
	}
	//sq.esysco.net there is no sysco list .Scripted based on flex2.
	@Test(groups={"Conduct a Search"}, description = "TS_SilverSearch_002:Verify whether CAKE descriptions are getting displayed on Sysco Lists page when logged in as Normal user")
	@Features("Conduct a Search")
	@Stories("TS_SilverSearch_002:Verify whether CAKE descriptions are getting displayed on Sysco Lists page when logged in as Normal user")
	public void TS_SilverSearch_002() {	
		
		
		LoginData loginData =LoginData.fetch("$COGMFlex2N1");
		OrderData orderData =OrderData.fetch("$COGM_ItemDataSyscoList");
		String tcName="TS_SilverSearch_002";
			
			
			
			Start.asTester
			.goToLoginpage()
			.loginToApplication(loginData.UserName, loginData.Password)
			._GoToHomePage()
			.atHomePage()
			.clickOnExpress()
			.atExpressHomePage()
			._GoToListPage()
			.clickOnListTab()
			.clickOnSyscoRecommendedLink(orderData.ListName)
			//.getListNumberForSyscoList(orderData.ListName,tcName)
			.clickOnSelectedSyscoList(orderData.ListName.trim())
			._GoToHomePage()
			.enterUPCInSearchBox(orderData.UPC)
			.searchOnPrductDescription(orderData.UPC,orderData.ItemName )
			.checkImagenotPresent(orderData.UPC)
			
			;
			
			
	}
	@Test(groups={"Conduct a Search"}, description = "TS_SilverSearch_003:Verify whether CAKE descriptions are getting displayed on Shared Lists page when logged in as Normal user")
	@Features("Conduct a Search")
	@Stories("TS_SilverSearch_003:Verify whether CAKE descriptions are getting displayed on Shared Lists page when logged in as Normal user")
	public void TS_SilverSearch_003() {	
		
		
		
			
			
			
		LoginData loginData_01 =LoginData.fetch("$COGMFlex2N2");	
		LoginData loginData_02 =LoginData.fetch("$COGMFlex2N15");
		
		
		OrderData orderData_001 =OrderData.fetch("$COGM_ItemMylist2");
		
		
		String key1=loginData_01.UserName;
		String key2=loginData_02.UserName;
		String key3="TS_SilverSearch_003";
		
			Start.asTester
			.goToLoginpage()
			//Creating List For 1st User
			.loginToApplication(loginData_01.UserName, loginData_01.Password)
			._GoToHomePage()
			.atHomePage()
			.clickOnExpress()
			.verifyHomePage()
			._GoToListPage()
			//Creating List
			.clickOnListTab()
			.clickOnCreateNewList()
			.enterListNameInPopup(key1)
			.clickOnCreateList()
			.clickOnListTab()
			._GoToHomePage()
			.verifyListpage()
			._GoToListPage()
			.clickOnMyListLink()
			.getListNumberByListName(key1)
			._GoToHomePage()
			//Adding Items to List
			.enterAnyItemInSearchBox(orderData_001.UPC)
			.clickOnSearchButton()
			._GoToListPage()
			.checkOnItem(orderData_001.UPC.split(";"))
			.clickOnAddToList()
			.clickOnExistingList(key1)
			.clickOnConform()
			.clickOnListTab()
			.clickOnMyListLink()
			.clickOnAnyListNumber(key1)
			._GoToHomePage()
			.enterUPCInSearchBox(orderData_001.UPC)
			.searchOnPrductDescription(orderData_001.UPC,orderData_001.ItemName )
			._GoOrderPage()
			.close()
			
			//Validating user2 List Shared List
			
			._atLoginPage()
			.loginToApplication(loginData_02.UserName, loginData_02.Password)
	        ._GoToHomePage()
			.atHomePage()
			.clickOnExpress()
			.atExpressHomePage()
			._GoToListPage()
			.clickOnListTab()
			.clickOnShareListLink()
			.validateListNameInSharedList(key1)
			.clickOnAnyListNumber(key1)
			._GoToHomePage()
			.enterUPCInSearchBox(orderData_001.UPC)
			.searchOnPrductDescription(orderData_001.UPC,orderData_001.ItemName )
			.checkImagenotPresent(orderData_001.UPC)
			
			;
			
			
	}
	@Test(groups={"Conduct a Search"}, description = "TS_SilverSearch_004:Verify whether CAKE descriptions are getting displayed on Edit Lists page when logged in as Normal user")
	@Features("Conduct a Search")
	@Stories("TS_SilverSearch_004:Verify whether CAKE descriptions are getting displayed on Edit Lists page when logged in as Normal user")
	public void TS_SilverSearch_004() {	
		
		
			
			
		LoginData loginData_01 =LoginData.fetch("$COGMFlex2N3");	
		
		
		
		OrderData orderData_001 =OrderData.fetch("$COGM_ItemMylist2");
			
		String key1=loginData_01.UserName;
				
			Start.asTester
			.goToLoginpage()
			//Creating List For 1st User
			.loginToApplication(loginData_01.UserName, loginData_01.Password)
			._GoToHomePage()
			.atHomePage()
			.clickOnExpress()
			.verifyHomePage()
			._GoToListPage()
			//Creating List
			.clickOnListTab()
			.clickOnCreateNewList()
			.enterListNameInPopup(key1)
			.clickOnCreateList()
			.clickOnListTab()
			._GoToHomePage()
			.verifyListpage()
			._GoToListPage()
			.clickOnMyListLink()
			.getListNumberByListName(key1)
			._GoToHomePage()
			//Adding Items to List
			.enterAnyItemInSearchBox(orderData_001.UPC)
			.clickOnSearchButton()
			._GoToListPage()
			.checkOnItem(orderData_001.UPC.split(";"))
			.clickOnAddToList()
			.clickOnExistingList(key1)
			.clickOnConform()
			.clickOnListTab()
			.clickOnMyListLink()
			.clickOnAnyListNumber(key1)
			._GoToHomePage()
			.enterUPCInSearchBox(orderData_001.UPC)
			.searchOnPrductDescription(orderData_001.UPC,orderData_001.ItemName )
			._GoToListPage()
			.clickOnEditList()
			.searchOnPrductDescriptionInEditList(orderData_001.UPC )
			
			
			;
			
			
	}
	@Test(groups={"Conduct a Search"}, description = "TS_SilverSearch_005:Verify whether CAKE descriptions are getting displayed on Order guide page when logged in as Normal user")
	@Features("Conduct a Search")
	@Stories("TS_SilverSearch_005:Verify whether CAKE descriptions are getting displayed on Order guide page when logged in as Normal user")
	public void TS_SilverSearch_005() {	
	LoginData loginData =LoginData.fetch("$COGMFlex2N4");
	OrderData orderData=OrderData.fetch("$COGM_ItemMylist4");
	Start.asTester
	.goToLoginpage()
	.loginToApplication(loginData.UserName, loginData.Password)
	._GoToHomePage()
	
	.clickOnExpress()
	.atExpressHomePage()
	.atExpressOrderingPage()
	.enterAnyItemInSearchBox(orderData.UPC)
	.clickOnSearchButton()
	
	.enterOrderQuantity(orderData.UPC, orderData.CaseQuantity)
	._GoOrderPage()
	.clickForPopup()
	.enterOrderName("SyscoOrder")
	.clickOnCreatNewOrder()
	.clickOnViewOrder()
	.clickSubmitOrder()
	.clickOrderReminderSubmitNormal()
	.verifyAndConfirmOrder()
	//.clickOnAcknowledgementButton()
	//.clickOrderReminderSubmitNormal()
	
	._GoToOrdeGuidePage()
	.clickOnOrderGuideTab()
	.verifyOrderGuidepage()
	.enterTypeInSearchBox(orderData.UPC)
	._GoToHomePage()
	.searchOnPrductDescription(orderData.UPC,orderData.ItemName )
	
	;
	}
	/*
	 * Selected item does not have an image(valid image)
	 */
	@Test(groups={"Conduct a Search"}, description = "TS_SilverSearch_006:Verify whether CAKE descriptions are getting displayed on search results page when logged in as Normal user")
	@Features("Conduct a Search")
	@Stories("TS_SilverSearch_006:Verify whether CAKE descriptions are getting displayed on search results page when logged in as Normal user")
	public void TS_SilverSearch_006() {	
	LoginData loginData =LoginData.fetch("$COGMFlex2N5");
	OrderData orderData =OrderData.fetch("$COGM_ItemMylist4");
		Start.asTester
		.goToLoginpage()
		.loginToApplication(loginData.UserName, loginData.Password)
		._GoToHomePage()
		.atHomePage()
		.clickOnExpress()
		.atExpressHomePage()
		.enterAnyItemInSearchBox(orderData.UPC)
		.clickOnSearchButton()
		.searchOnPrductDescription(orderData.UPC,orderData.ItemName )
		.checkOMXMountainImage(orderData.UPC)
		;
	}
	@Test(groups={"Conduct a Search"}, description = "TS_SilverSearch_007:Verify whether CAKE descriptions are getting displayed on Product cards when logged in as Normal user")
	@Features("Conduct a Search")
	@Stories("TS_SilverSearch_007:Verify whether CAKE descriptions are getting displayed on Product cards when logged in as Normal user.")
	public void TS_SilverSearch_007() {	
	LoginData loginData =LoginData.fetch("$COGMFlex2N6");
	OrderData orderData =OrderData.fetch("$COGM_ItemMylist");
		Start.asTester
		.goToLoginpage()
		.loginToApplication(loginData.UserName, loginData.Password)
		._GoToHomePage()
		.atHomePage()
		.clickOnExpress()
		.atExpressHomePage()
		._GoToProductCatalog()
		.clickOnProductTab()
		.verifyProductButton()
		._GoToHomePage()
		.enterAnyItemInSearchBox(orderData.UPC)
		.clickOnSearchButton()
		.searchOnPrductDescription(orderData.UPC,orderData.ItemName )
		.clickOnPrduct(orderData.UPC)
		.switchToProductInfoWindow()
		._GoToOrdeGuidePage()
		.validateProductInfo(orderData.UPC)
		._GoToHomePage()
		.searchOnPrductDescriptionInProductcard(orderData.UPC,orderData.ItemName )
		.checkImageInProductInfoWindow(orderData.UPC)
		;
	}
	@Test(groups={"Conduct a Search"}, description = "TS_SilverSearch_008:erify whether CAKE descriptions are getting displayed on OOE when logged in as Normal user")
	@Features("Conduct a Searcherify whether CAKE descriptions are getting displayed on OOE when logged in as Normal user")
	public void TS_SilverSearch_008() {	
	LoginData loginData =LoginData.fetch("$COGMFlex2N7");
	OrderData orderData =OrderData.fetch("$COGM_ItemMylist");
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
		.selectTypeFromDropDown("Quick Order Entry")
		.clickOnCreatNewOrder()
		// Adding items and creating order through QOE
		.enterQuickOrderEntryDetailsWithoutAdd(orderData.UPC.split(";"),orderData.CaseQuantity.split(";"),orderData.SplitQuantity.split(";"))
		._GoToHomePage()
		.searchOnPrductDescriptionInQuickOrderEntry(orderData.UPC,orderData.ItemName )
		;
	}
	@Test(groups={"Conduct a Search"}, description = "TS_SilverSearch_009:Verify whether CAKE descriptions are getting displayed on open order when logged in as Normal user")
	@Features("Conduct a Search")
	@Stories("TS_SilverSearch_009:Verify whether CAKE descriptions are getting displayed on open order when logged in as Normal user")
	public void TS_SilverSearch_009() {	
	LoginData loginData =LoginData.fetch("$COGMFlex2MA");
	OrderData orderData =OrderData.fetch("$COGM_ItemMylist5");
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
		.selectTypeFromDropDown("Quick Order Entry")
		.clickOnCreatNewOrder()
		// Adding items and creating order through QOE
		.enterQuickOrderEntryDetailsWithoutAdd(orderData.UPC.split(";"),orderData.CaseQuantity.split(";"),orderData.SplitQuantity.split(";"))
		._GoToHomePage()
		.searchOnPrductDescriptionInQuickOrderEntry(orderData.UPC,orderData.ItemName )
		;
	}
	@Test(groups={"Conduct a Search"}, description = "TS_SilverSearch_010:Verify whether CAKE descriptions are getting displayed on recent order when logged in as Normal user")
	@Features("Conduct a Search")
	@Stories("TS_SilverSearch_010:Verify whether CAKE descriptions are getting displayed on recent order when logged in as Normal user")
	public void TS_SilverSearch_010() {	
	LoginData loginData =LoginData.fetch("$COGMFlex2N8");
	OrderData orderData=OrderData.fetch("$COGM_ItemMylist4");
	String key1="Quick Order_010";
	Start.asTester
	.goToLoginpage()
	.loginToApplication(loginData.UserName, loginData.Password)
	._GoToHomePage()
	
	.clickOnExpress()
	.atExpressHomePage()
	.atExpressOrderingPage()
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
	.getTextOrderNumber(key1)
	._GoOrderPage()
	.orderPageTab()
	._GoToHomePage()
	//Validating Open order Status
	.clickOnOpenOrderLink()
	.validateStatusOfOpenOrder(key1)
	.clickOnAnyOrder(key1)
	._GoToHomePage()
	.searchOnPrductDescription(orderData.UPC,orderData.ItemName )
	.checkImagenotPresent(orderData.UPC)
	;
	}
	
	@Test(groups={"Conduct a Search"}, description = "TS_SilverSearch_012:Verify whether CAKE descriptions are getting displayed on Sysco Lists page when logged in as Normal user")
	@Features("Conduct a Search")
	@Stories("TS_SilverSearch_012:Verify whether CAKE descriptions are getting displayed on Sysco Lists page when logged in as Normal user")
	public void TS_SilverSearch_012() {	
	LoginData loginData =LoginData.fetch("$COGMFlex2N9");
	OrderData orderData=OrderData.fetch("$COGM_ItemMylist4");
	String key1="Quick Order_010";
	Start.asTester
	.goToLoginpage()
	.loginToApplication(loginData.UserName, loginData.Password)
	._GoToHomePage()
	.atHomePage()
	.clickOnExpress()
	.atExpressHomePage()
	.atExpressOrderingPage()
	._GoItemDeletePage()
    .atOrderTab()
    .viewAllSumittedOrder()
    .selectSubmittedOrderfromDBonItembasis(loginData.OpCo, loginData.Customer,orderData.UPC)
    ._GoToHomePage()
    .checkImagenotPresent(orderData.UPC)
    

    ;
	}
	
	//Here merge TS_SilverSearch_011 and TS_SilverSearch_013
	 
	@Test(groups={"Conduct a Search"}, description = "TS_SilverSearch_011:Verify whether CAKE descriptions are getting displayed on Sysco Lists page when logged in as Normal user")
	@Features("Conduct a Search")
	@Stories("TS_SilverSearch_011:Verify whether CAKE descriptions are getting displayed on Sysco Lists page when logged in as Normal user")
	public void TS_SilverSearch_011() {	
	
		
		LoginData loginData =LoginData.fetch("$COGMFlex2N10");
		//LoginData loginData =LoginData.fetch("$OMUser16");
		OrderData orderData_01=OrderData.fetch("$COGM_ItemMylist7");
		//OrderData orderData_02=OrderData.fetch("$OrderData34");
		String strKeyOrder="TS_SilverSearch_011";
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
				.orderToDeliveredStatusDB("TS_SilverSearch_011")
				 ._GoItemDeletePage()
				.atOrderTab()
				.viewAllhistoriallink()
				.selectDeliveredOrderLink(orderData_01.OrderName,"TS_SilverSearch_011")
				._GoToHomePage()
				.searchOnPrductDescription(orderData_01.UPC,orderData_01.ItemName )
				.checkImagenotPresent(orderData_01.UPC)
				._GoItemDeletePage()
				.clickReOrderButton()
				._GoToHomePage()
				.searchOnPrductDescription(orderData_01.UPC,orderData_01.ItemName )
				
				;		
	}
	
	// In ORM pop up  not able to validate the item description(due to test data issue).
	 
	@Test(groups={"Conduct a Search"}, description = "Verify whether CAKE descriptions are getting displayed in order reminder modal")
	@Features("Conduct a Search")
	@Stories("TS_SilverSearch_014:Verify whether CAKE descriptions are getting displayed in order reminder modal")
	public void TS_SilverSearch_014() {	
	LoginData loginData =LoginData.fetch("$COGMFlex2N11");
	OrderData orderData=OrderData.fetch("$COGM_ItemMylist4");
	
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
	.selectTypeFromDropDown(orderData.ProductFrom)
	.clickOnCreatNewOrder()
	.atQuickOrderEntryPagePopUp()
	.enterQuickOrderEntryDetailsWithoutAdd(orderData.UPC.split(";"),orderData.CaseQuantity.split(";"),orderData.SplitQuantity.split(";"))
	._GoToHomePage()
	.searchOnPrductDescriptionInQuickOrderEntry(orderData.UPC,orderData.ItemName )
	;
	  
	}
	
	@Test(groups={"Conduct a Search"}, description = "TS_SilverSearch_017:Verify whether CAKE descriptions are getting displayed in all screens when logged in as MA user ")
	@Features("Conduct a Search")
	@Stories("TS_SilverSearch_017:Verify whether CAKE descriptions are getting displayed in all screens when logged in as MA user ")
	public void TS_SilverSearch_017() {	
	LoginData loginData =LoginData.fetch("$COGMFlex2N12");
	OrderData orderData=OrderData.fetch("$COGM_ItemMylist4");
	String tcName="TS_SilverSearch_017";
	Start.asTester
	.goToLoginpage()
	.loginToApplication(loginData.UserName, loginData.Password)
	._GoToHomePage()
	.atHomePage()
	.clickOnExpress()
	.atExpressHomePage()
	._GoToListPage()
	.clickOnListTab()
	.clickOnCreateNewList()
	.enterListNameInPopup(tcName)
	.clickOnCreateList()
	.clickOnListTab()
	._GoToHomePage()
	.verifyListpage()
	._GoToListPage()
	.clickOnMyListLink()
	.getListNumberByListName(tcName)
	._GoToHomePage()
	//Adding Items to List
	.enterAnyItemInSearchBox(orderData.UPC)
	.clickOnSearchButton()
	.checkOnAllItem()
	._GoToListPage()
	.clickOnAddToList()
	.clickOnExistingList(tcName)
	.clickOnConform()
	.clickOnListTab()
	
	// * In My list
	 
	.clickOnMyListLink()
	.clickOnAnyListNumber(tcName)
	._GoToHomePage()
	.searchOnPrductDescription(orderData.UPC,orderData.ItemName )
	
	
	
	// * quick order entry	
	 
	._GoOrderPage()
	.orderPageTab()
	._GoToHomePage()
	.startNewOrder()
	._GoOrderPage()
	.atCreateOrderPage()
	.selectTypeFromDropDown(orderData.ProductFrom)
	.clickOnCreatNewOrder()
	.atQuickOrderEntryPagePopUp()
	.enterQuickOrderEntryDetailsWithoutAdd(orderData.UPC.split(";"),orderData.CaseQuantity.split(";"),orderData.SplitQuantity.split(";"))
	._GoToHomePage()
	.searchOnPrductDescriptionInQuickOrderEntry(orderData.UPC,orderData.ItemName )
	._GoOrderPage()
	.clickOnAddToOrderInQuickOrder()
	
	._GoToProductCatalog()
	.clickOnProductTab()
	.verifyProductButton()
	._GoToHomePage()
	.enterAnyItemInSearchBox(orderData.UPC)
	.clickOnSearchButton()
	.searchOnPrductDescription(orderData.UPC,orderData.ItemName )
	.clickOnPrduct(orderData.UPC)
	.switchToProductInfoWindow()
	._GoToOrdeGuidePage()
	.validateProductInfo(orderData.UPC)
	._GoToHomePage()
	.searchOnPrductDescriptionInProductcard(orderData.UPC,orderData.ItemName )
	;

	  
	}
	@Test(groups={"Conduct a Search"}, description = "TS_SilverSearch_002:Verify whether CAKE descriptions are getting displayed on Sysco Lists page when logged in as Normal user")
	@Features("Conduct a Search")
	@Stories("TS_SilverSearch_002:Verify whether CAKE descriptions are getting displayed on Sysco Lists page when logged in as Normal user")
	public void TS_SilverSearch_019() {	
		//Need multi buyer user
	LoginData loginData =LoginData.fetch("$COGMFlex2MB");
	OrderData orderData=OrderData.fetch("$COGM_ItemMylist4");
	String tcName="TS_SilverSearch_019";
	Start.asTester
	.goToLoginpage()
	.loginToApplication(loginData.UserName, loginData.Password)
	._GoToHomePage()
	.atHomePage()
	.clickOnExpress()
	.atExpressHomePage()
	._GoToListPage()
	.clickOnListTab()
	.clickOnCreateNewList()
	.enterListNameInPopup(tcName)
	.clickOnCreateList()
	.clickOnListTab()
	._GoToHomePage()
	.verifyListpage()
	._GoToListPage()
	.clickOnMyListLink()
	.getListNumberByListName(tcName)
	._GoToHomePage()
	//Adding Items to List
	.enterAnyItemInSearchBox(orderData.UPC)
	.clickOnSearchButton()
	.checkOnAllItem()
	._GoToListPage()
	.clickOnAddToList()
	.clickOnExistingList(tcName)
	.clickOnConform()
	.clickOnListTab()
	
	//* In My list
	 
	.clickOnMyListLink()
	.clickOnAnyListNumber(tcName)
	._GoToHomePage()
	.searchOnPrductDescription(orderData.UPC,orderData.ItemName )
	
	
	
	 //* quick order entry	
	 
	._GoOrderPage()
	.orderPageTab()
	._GoToHomePage()
	.startNewOrder()
	._GoOrderPage()
	.atCreateOrderPage()
	.selectTypeFromDropDown(orderData.ProductFrom)
	.clickOnCreatNewOrder()
	.atQuickOrderEntryPagePopUp()
	.enterQuickOrderEntryDetailsWithoutAdd(orderData.UPC.split(";"),orderData.CaseQuantity.split(";"),orderData.SplitQuantity.split(";"))
	._GoToHomePage()
	.searchOnPrductDescriptionInQuickOrderEntry(orderData.UPC,orderData.ItemName )
	._GoOrderPage()
	.clickOnAddToOrderInQuickOrder()
	
	._GoToProductCatalog()
	.clickOnProductTab()
	.verifyProductButton()
	._GoToHomePage()
	.enterAnyItemInSearchBox(orderData.UPC)
	.clickOnSearchButton()
	.searchOnPrductDescription(orderData.UPC,orderData.ItemName )
	.clickOnPrduct(orderData.UPC)
	.switchToProductInfoWindow()
	._GoToOrdeGuidePage()
	.validateProductInfo(orderData.UPC)
	._GoToHomePage()
	.searchOnPrductDescriptionInProductcard(orderData.UPC,orderData.ItemName )
	;

	  
	}
	@Test(groups={"Conduct a Search"}, description = "TS_SilverSearch_002:Verify whether CAKE descriptions are getting displayed on Sysco Lists page when logged in as Normal user")
	@Features("Conduct a Search")
	@Stories("TS_SilverSearch_002:Verify whether CAKE descriptions are getting displayed on Sysco Lists page when logged in as Normal user")
	public void TS_SilverSearch_020() {	
	LoginData loginData =LoginData.fetch("$COGMFlex2MA");
	OrderData orderData=OrderData.fetch("$COGM_ItemMylist5");
	String tcName="TS_SilverSearch_017";
	Start.asTester
	.goToLoginpage()
	.loginToApplication(loginData.UserName, loginData.Password)
	._GoToHomePage()
	.atHomePage()
	.clickOnExpress()
	.atExpressHomePage()
	._GoToListPage()
	.clickOnListTab()
	.clickOnCreateNewList()
	.enterListNameInPopup(tcName)
	.clickOnCreateList()
	.clickOnListTab()
	._GoToHomePage()
	.verifyListpage()
	._GoToListPage()
	.clickOnMyListLink()
	.getListNumberByListName(tcName)
	._GoToHomePage()
	//Adding Items to List
	.enterAnyItemInSearchBox(orderData.UPC)
	.clickOnSearchButton()
	.checkOnAllItem()
	._GoToListPage()
	.clickOnAddToList()
	.clickOnExistingList(tcName)
	.clickOnConform()
	.clickOnListTab()
	
	 //* In My list
	 
	.clickOnMyListLink()
	.clickOnAnyListNumber(tcName)
	._GoToHomePage()
	.searchOnPrductDescription(orderData.UPC,orderData.ItemName )
	
	
	
	// * quick order entry	
	 
	._GoOrderPage()
	.orderPageTab()
	._GoToHomePage()
	.startNewOrder()
	._GoOrderPage()
	.atCreateOrderPage()
	.selectTypeFromDropDown(orderData.ProductFrom)
	.clickOnCreatNewOrder()
	.atQuickOrderEntryPagePopUp()
	.enterQuickOrderEntryDetailsWithoutAdd(orderData.UPC.split(";"),orderData.CaseQuantity.split(";"),orderData.SplitQuantity.split(";"))
	._GoToHomePage()
	.searchOnPrductDescriptionInQuickOrderEntry(orderData.UPC,orderData.ItemName )
	._GoOrderPage()
	.clickOnAddToOrderInQuickOrder()
	
	._GoToProductCatalog()
	.clickOnProductTab()
	.verifyProductButton()
	._GoToHomePage()
	.enterAnyItemInSearchBox(orderData.UPC)
	.clickOnSearchButton()
	.searchOnPrductDescription(orderData.UPC,orderData.ItemName )
	.clickOnPrduct(orderData.UPC)
	.switchToProductInfoWindow()
	._GoToOrdeGuidePage()
	.validateProductInfo(orderData.UPC)
	._GoToHomePage()
	.searchOnPrductDescriptionInProductcard(orderData.UPC,orderData.ItemName )
	
	;

	  
	}
	
	@Test(groups={"Conduct a Search"}, description = "TS_SilverSearch_002:Verify whether CAKE descriptions are getting displayed on Sysco Lists page when logged in as Normal user")
	@Features("Conduct a Search")
	@Stories("TS_SilverSearch_002:Verify whether CAKE descriptions are getting displayed on Sysco Lists page when logged in as Normal user")
	public void TS_SilverSearch_018() {	
		
		 //* CSR User
		 
	LoginData loginData =LoginData.fetch("$COGMFlex2CSR");
	OrderData orderData=OrderData.fetch("$COGM_ItemMylist4");
	String tcName="TS_SilverSearch_018";
	
	Start.asTester
	.goToLoginpage()
	.loginToApplication(loginData.UserName, loginData.Password)
	._GoToHomePage()
	.atHomePage()
	.clickOnExpress()
	.atExpressHomePage()
	.SelectLocation(loginData.OpCo, loginData.Customer)
	.atExpressOrderingPage()
	._GoToListPage()
	.clickOnListTab()
	.clickOnCreateNewList()
	.enterListNameInPopup(tcName)
	.clickOnCreateList()
	.clickOnListTab()
	._GoToHomePage()
	.verifyListpage()
	._GoToListPage()
	.clickOnMyListLink()
	.getListNumberByListName(tcName)
	._GoToHomePage()
	//Adding Items to List
	.enterAnyItemInSearchBox(orderData.UPC)
	.clickOnSearchButton()
	.checkOnAllItem()
	._GoToListPage()
	.clickOnAddToList()
	.clickOnExistingList(tcName)
	.clickOnConform()
	.clickOnListTab()
	
	// * In My list
	 
	.clickOnMyListLink()
	.clickOnAnyListNumber(tcName)
	._GoToHomePage()
	.searchOnPrductDescription(orderData.UPC,orderData.ItemName )
	
	
	
	 //* quick order entry	
	 
	._GoOrderPage()
	.orderPageTab()
	._GoToHomePage()
	.startNewOrder()
	._GoOrderPage()
	.atCreateOrderPage()
	.selectTypeFromDropDown(orderData.ProductFrom)
	.clickOnCreatNewOrder()
	.atQuickOrderEntryPagePopUp()
	.enterQuickOrderEntryDetailsWithoutAdd(orderData.UPC.split(";"),orderData.CaseQuantity.split(";"),orderData.SplitQuantity.split(";"))
	._GoToHomePage()
	.searchOnPrductDescriptionInQuickOrderEntry(orderData.UPC,orderData.ItemName )
	._GoOrderPage()
	.clickOnAddToOrderInQuickOrder()
	
	._GoToProductCatalog()
	.clickOnProductTab()
	.verifyProductButton()
	._GoToHomePage()
	.enterAnyItemInSearchBox(orderData.UPC)
	.clickOnSearchButton()
	.searchOnPrductDescription(orderData.UPC,orderData.ItemName )
	.clickOnPrduct(orderData.UPC)
	.switchToProductInfoWindow()
	._GoToOrdeGuidePage()
	.validateProductInfo(orderData.UPC)
	._GoToHomePage()
	.searchOnPrductDescriptionInProductcard(orderData.UPC,orderData.ItemName )
	;

	  
	}
	
	/*
	
	 * START SPRINT2 TEST CASE
	 
	
	/*
	 * 
	 */
	@Test(groups={"Conduct a Search"}, description = "TS_SilverSearchByBrandName:Search the item based on brand name.")
	@Features("Conduct a Search")
	@Stories("TS_SilverSearchByBrandName:Search the item based on brand name")
	public void TS_SilverSearchByBrandName() {	
		LoginData loginData =LoginData.fetch("$COGMFlex2N13");
		OrderData orderData=OrderData.fetch("$COGM_ItemMylist5");
		
		
		Start.asTester
		.goToLoginpage()
		.loginToApplication(loginData.UserName, loginData.Password)
		._GoToHomePage()
		.atHomePage()
		.clickOnExpress()
		.atExpressHomePage()
		._GoToProductCatalog()
		.clickOnProductTab()
		._GoItemDeletePage()
		.selectBrandNameFromDB(loginData.OpCo, orderData.UPC, "TS_SilverSearchByBrandName","TS_SilverSearchByBrandNameDB")
		._GoToHomePage()
		.enterAnyCakeDescriptiondInSearchBox("TS_SilverSearchByBrandName")
		.clickOnSearchButton()
		.verifySearchValidBrandName("TS_SilverSearchByBrandNameDB")
	//	.checkImage(orderData.UPC)
		;
		
	

	  
	}
	
	 /* Selected item must have the image
	 * */
	 
	@Test(groups={"Conduct a Search"}, description = "TS_SilverSearchByCAKEDescription:Search the item based on brand name. when logged in as Normal user")
	@Features("Conduct a Search")
	@Stories("TS_SilverSearchByCAKEDescription:Search the item based on brand name. when logged in as Normal user")
	public void TS_SilverSearchByCAKEDescription() {	
		LoginData loginData =LoginData.fetch("$COGMFlex2N16");
		OrderData orderData=OrderData.fetch("$COGM_ItemMylist5");
		String tcName="TS_SilverSearchByCAKEDescription";
		
		Start.asTester
		.goToLoginpage()
		.loginToApplication(loginData.UserName, loginData.Password)
		._GoToHomePage()
		.atHomePage()
		.clickOnExpress()
		.atExpressHomePage()
		._GoToProductCatalog()
		.clickOnProductTab()
		._GoToHomePage()
		.selectOnPrductDescriptionFromDB(orderData.UPC,"TS_SilverSearchByCAKEDescription")
		.enterAnyCakeDescriptiondInSearchBox("TS_SilverSearchByCAKEDescription")
		.clickOnSearchButton()
		.searchOnPrductDescription(orderData.UPC,orderData.ItemName )
		.checkImage(orderData.UPC)
		;
		


	  
	}
	@Test(groups={"Conduct a Search"}, description = "TS_SilverSearchByProductNameandBrandname: Search the item based on brand name and product name. when logged in as Normal user")
	@Features("Conduct a Search")
	@Stories("TS_SilverSearchByProductNameandBrandname :Search the item based on brand name and Product name. when logged in as Normal user")
	public void TS_SilverSearchByProductNameandBrandname() {	
		LoginData loginData =LoginData.fetch("$COGMFlex2N17");
		OrderData orderData=OrderData.fetch("$COGM_ItemMylist5");
		String tcName="TS_SilverSearchByProductNameandBrandname";
		
		Start.asTester
		.goToLoginpage()
		.loginToApplication(loginData.UserName, loginData.Password)
		._GoToHomePage()
		.atHomePage()
		.clickOnExpress()
		.atExpressHomePage()
		._GoToProductCatalog()
		.clickOnProductTab()
		._GoItemDeletePage()
		.selectBrandNameandDescriptionFromDB(loginData.OpCo, orderData.UPC, "TS_SilverSearchByProductNameandBrandname")
		._GoToHomePage()
		.enterAnyCakeDescriptiondInSearchBox("TS_SilverSearchByProductNameandBrandname")
		.clickOnSearchButton()
		.searchOnPrductDescription(orderData.UPC,orderData.ItemName )
		
		;
		
		


	  
	}
	//Selected item must have an image
	@Test(groups={"Conduct a Search"}, description = "TC_ImageSearch_001: Verify whether thumbnail image is getting displayed on SMX when an Normal user conducts search ")
	@Features("Conduct a Search")
	@Stories("TC_ImageSearch_001 :Verify whether thumbnail image is getting displayed on SMX when an Normal user conducts search ")
	public void TC_ImageSearch_001() {	
		LoginData loginData =LoginData.fetch("$COGMFlex2N17");
		OrderData orderData=OrderData.fetch("$COGM_ItemMylist5");
		Start.asTester
		.goToLoginpage()
		.loginToApplication(loginData.UserName, loginData.Password)
		._GoToHomePage()
		.atHomePage()
		.clickOnExpress()
		.atExpressHomePage()
		._GoToProductCatalog()
		.clickOnProductTab()
		._GoToHomePage()
	    .enterAnyItemInSearchBox(orderData.UPC)
	    .clickOnSearchButton()
	    .checkImage(orderData.UPC)
	    .clickOnImagePath(orderData.UPC)
	    ;

		 
	}

	
	@Test(groups={"Conduct a Search"}, description = "TC_ImageSearch_004:Verify whether thumbnail image is NOT getting displayed on Order guide page ")
	@Features("Conduct a Search")
	@Stories("TC_ImageSearch_004:Verify whether thumbnail image is NOT getting displayed on Order guide page ")
	public void TC_ImageSearch_004(){
		LoginData loginData =LoginData.fetch("$COGMFlex2N18");
		OrderData orderData=OrderData.fetch("$COGM_ItemMylist7");
		Start.asTester
		.goToLoginpage()
		.loginToApplication(loginData.UserName, loginData.Password)
		._GoToHomePage()
		.atHomePage()
		.clickOnExpress()
		.atExpressHomePage()	
		.atExpressHomePage()
		.verifyHomePage()
		._GoToHomePage()
		._GoToOrdeGuidePage()
		.clickOnOrderGuideTab()
		.verifyOrderGuidepage()
		.enterTypeInSearchBox(orderData.UPC)
		._GoToHomePage()
		.checkImagenotPresent(orderData.UPC)
		;
		
	}

 /* Select an item with Multiple image
 */
	@Test(groups={"Conduct a Search"}, description = "TC_ImageSearch_007:Verify whether thumbnail image is NOT getting displayed on Order guide page ")
	@Features("Conduct a Search")
	@Stories("TC_ImageSearch_007:Verify whether thumbnail image is NOT getting displayed on Order guide page ")
	public void TC_ImageSearch_007(){
		LoginData loginData =LoginData.fetch("$COGMFlex2N6");
		OrderData orderData =OrderData.fetch("$COGM_MultipleImage");
			Start.asTester
			.goToLoginpage()
			.loginToApplication(loginData.UserName, loginData.Password)
			._GoToHomePage()
			.atHomePage()
			.clickOnExpress()
			.atExpressHomePage()
			._GoToProductCatalog()
			.clickOnProductTab()
			.verifyProductButton()
			._GoToHomePage()
			.enterAnyItemInSearchBox(orderData.UPC)
			.clickOnSearchButton()
			.clickOnPrduct(orderData.UPC)
			.switchToProductInfoWindow()
			._GoToOrdeGuidePage()
			._GoToHomePage()
			.checkImageInProductInfoWindow(orderData.UPC)
			.checkMultipleImageInProductInfoWindow(orderData.UPC)
			;
	}
	
	
	/* Select an item with Multiple image
	 */
		@Test(groups={"Conduct a Search"}, description = "TC_ImageSearch_007:Verify whether thumbnail image is NOT getting displayed on Order guide page ")
		@Features("Conduct a Search")
		@Stories("TC_ImageSearch_007:Verify whether thumbnail image is NOT getting displayed on Order guide page ")
		public void TS_ImageSearch_018(){
			LoginData loginData =LoginData.fetch("$COGMFlex2N6");
			OrderData orderData =OrderData.fetch("$COGM_Abbrevation");
				Start.asTester
				.goToLoginpage()
				.loginToApplication(loginData.UserName, loginData.Password)
				._GoToHomePage()
				.atHomePage()
				.clickOnExpress()
				.atExpressHomePage()
				._GoToProductCatalog()
				.clickOnProductTab()
				.verifyProductButton()
				._GoItemDeletePage()
		        .selectAbbrivationFromDB(loginData.OpCo, orderData.UPC, "TC_ImageSearch_007")
		        ._GoToHomePage()
		        .enterAnyCakeDescriptiondInSearchBox("TC_ImageSearch_007")
		        .clickOnSearchButton()
		        .checkImage(orderData.UPC)
				;
		}
		
		
}
	
