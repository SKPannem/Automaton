package com.tests;

import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

import com.components.entities.Start;
import com.components.testdata.LoginData;
import com.components.testdata.OrderData;
import com.iwaf.framework.Initiator;

public class OrderGuide extends Initiator {
	@Test(groups={"Order_Guide"}, description = "Order Guide_001_01 : Validate pricing display for all users ")
	@Features("Order Guide")
	@Stories("Order Guide_001_01 :Validate pricing display for all users")
	public void validatePriceColumn(){
		LoginData loginData =LoginData.fetch("$OGNormalUser1");
   Start.asTester
		.goToLoginpage()
		.loginToApplication(loginData.UserName, loginData.Password)
		._GoToHomePage()
		.atHomePage()
		//.clickOnExpress()
		.atExpressHomePage()
		._GoToHomePage()
		.verifyHomePage()
		._GoToOrdeGuidePage()
		.clickOnOrderGuideTab()
		//Validate Live Price Column
		.validatePriceColumn()
		.validatePriceColumnName();
	}
	@Test(groups={"Order_Guide"}, description = "Order Guide_002_01 : Validate Print option in Order Guide by selecting Live Price option.")
	@Features("Order Guide")
	@Stories("Order Guide_002_01 : Validate Print option in Order Guide by selecting Live Price option.")
	public void PrintLivePrice(){
		LoginData loginData =LoginData.fetch("$OGNormalUser2");
		Start.asTester
		.goToLoginpage()
		.loginToApplication(loginData.UserName, loginData.Password)
		._GoToHomePage()
		.atHomePage()
		//.clickOnExpress()
		.atExpressHomePage()
		._GoToHomePage()
		.verifyHomePage()
		._GoToOrdeGuidePage()
		.clickOnOrderGuideTab()
		.verifyOrderGuidepage()
		.clickOnPrint()
		.checkOnLivePricing()
		._GoToProductCatalog()
		.clickOnCancelButton();
	}
	@Test(groups={"Order_Guide"}, description = "Order Guide_002_02 :Validate Print option in Order Guide by selecting Default Price option.")
	@Features("Order Guide")
	@Stories("Order Guide_002_02 :Validate Print option in Order Guide by selecting Default Price option.")
	public void PrintLivePrice2(){
		LoginData loginData =LoginData.fetch("$OGNormalUser3");
		Start.asTester
		.goToLoginpage()
		.loginToApplication(loginData.UserName, loginData.Password)
		._GoToHomePage()
		.atHomePage()
		//.clickOnExpress()
		.atExpressHomePage()
		._GoToOrdeGuidePage()
		.clickOnOrderGuideTab()
		.verifyOrderGuidepage()
		.clickOnPrint()
		.checkOnLivePricing()
		._GoToProductCatalog()
		.clickOnCancelButton();
	}
	@Test(groups={"Order_Guide"}, description = "Order Guide_003_01 : Validate Export option in Order Guide by selecting Live Price option.")
	@Features("Order Guide")
	@Stories("Order Guide_003_01 : Validate Export option in Order Guide by selecting Live Price option.")
	public void ExportLivePrice(){
		LoginData loginData =LoginData.fetch("$OGNormalUser4");
		Start.asTester
		.goToLoginpage()
		.loginToApplication(loginData.UserName, loginData.Password)
		._GoToHomePage()
		.atHomePage()
		//.clickOnExpress()
		.atExpressHomePage()
		._GoToHomePage()
		._GoToOrdeGuidePage()
		.clickOnOrderGuideTab()
		.verifyOrderGuidepage()
		.clickOnExport()
		.checkOnLivePricingInExportPopUp()
		._GoToProductCatalog()
		.clickOnCancelButton();
	}
	@Test(groups={"Order_Guide"}, description = "Order Guide_005 : Validate 'Replaced' by tag in Product alert section for a product. ")
	@Features("Order Guide")
	@Stories("Order Guide_005 : Validate 'Replaced' by tag in Product alert section for a product.")
	public void validateProductName(){
		LoginData loginData =LoginData.fetch("$OGNormalUser5");
		OrderData orderData = OrderData.fetch("$OrderData120");
		Start.asTester
		.goToLoginpage()
		.loginToApplication(loginData.UserName, loginData.Password)
		._GoToHomePage()
		.atHomePage()
		//.clickOnExpress()
		.atExpressHomePage()	
		.atExpressHomePage()
		.verifyHomePage()
		._GoToHomePage()
		._GoToOrdeGuidePage()
		.clickOnOrderGuideTab()
		.verifyOrderGuidepage()
		.enterTypeInSearchBox(orderData.UPC)
		.validateProductColumn();
	}
	
	@Test(groups={"Order_Guide"}, description = "Order Guide_010 : Validate Date Picker.")
	@Features("Order Guide")
	@Stories("Order Guide_010 : Validate Date Picker.")
	public void validateItemHistory(){
		LoginData loginData =LoginData.fetch("$OGNormalUser6");
		Start.asTester
		.goToLoginpage()
		.loginToApplication(loginData.UserName, loginData.Password)
		._GoToHomePage()
		.atHomePage()
		//.clickOnExpress()
		.atExpressHomePage()
		._GoToHomePage()
		._GoToOrdeGuidePage()
		.clickOnOrderGuideTab()
		.verifyOrderGuidepage()
		.selectCustomDate()
		.validateItemsHistory(84)
		.validateItemsHistory(1);
	}
	@Test(groups={"Order_Guide"}, description = "Order Guide_011 : Validate Narrow your results")
	@Features("Order Guide")
	@Stories("Order Guide_011 :Validate Narrow your results")
	public void validateItemFilter(){
		LoginData loginData =LoginData.fetch("$OGNormalUser7");
		OrderData orderData = OrderData.fetch("$OrderData106");
		Start.asTester
		.goToLoginpage()
		.loginToApplication(loginData.UserName, loginData.Password)
		._GoToHomePage()
		.atHomePage()
		//.clickOnExpress()
		.atExpressHomePage()
		._GoToHomePage()
		._GoToOrdeGuidePage()
		.clickOnOrderGuideTab()
		.verifyOrderGuidepage()
		.verifyNarrowResult(orderData.GroupBY.split(";"));
	}
	@Test(groups={"Order_Guide"}, description = "Order Guide_012 :Validate Search within items in Order Guide")
	@Features("Order Guide")
	@Stories("Order Guide_012 :Validate Search within items in Order Guide")
	public void validateSearchItemUPCBrandName(){
		LoginData loginData =LoginData.fetch("$OGNormalUser8");
		OrderData orderData = OrderData.fetch("$OrderData106");
		Start.asTester
		.goToLoginpage()
		.loginToApplication(loginData.UserName, loginData.Password)
		._GoToHomePage()
		.atHomePage()
		//.clickOnExpress()
		.atExpressHomePage()
		._GoToHomePage()
		._GoToOrdeGuidePage()
		.clickOnOrderGuideTab()
		.verifyOrderGuidepage()
		.enterTypeInSearchBox(orderData.UPC)
		.validateUPC(orderData.UPC)
		.enterTypeInSearchBox(orderData.BrandName)
		.validateBrandName(orderData.BrandName)
		.enterTypeInSearchBox(orderData.ItemName)
		.validateItemName(orderData.ItemName);
	}
	@Test(groups={"Order_Guide"}, description = "Order Guide_014 :Validate Group by category in Order Guide")
	@Features("Order Guide")
	@Stories("Order Guide_014 :Validate Group by category in Order Guide")
	public void validateGroupByCategory(){
		LoginData loginData =LoginData.fetch("$OGNormalUser9");
		Start.asTester
		.goToLoginpage()
		.loginToApplication(loginData.UserName, loginData.Password)
		._GoToHomePage()
		.atHomePage()
		//.clickOnExpress()
		.atExpressHomePage()
		._GoToHomePage()
		._GoToOrdeGuidePage()
		.clickOnOrderGuideTab()
		.verifyOrderGuidepage()
		.checkGroupByCategory()
		._GoToListPage()
		.validatGroupBySysoCategories()
		._GoToOrdeGuidePage()
		.UnCheckGroupByCategory()
		._GoToListPage()
		.validatGroupByDontGroup();
	}
	@Test(groups={"Order_Guide"}, description = "Order Guide_015 :Validate Hide Price button for all Users")
	@Features("Order Guide")
	@Stories("Order Guide_015 :Validate Hide Price button for all Users")
	public void validatePriceHide(){
		LoginData loginData =LoginData.fetch("$OGNormalUser10");
		Start.asTester
		.goToLoginpage()
		.loginToApplication(loginData.UserName, loginData.Password)
		._GoToHomePage()
		.atHomePage()
		//.clickOnExpress()
		.atExpressHomePage()
		._GoToHomePage()
		._GoToOrdeGuidePage()
		.clickOnOrderGuideTab()
		.verifyOrderGuidepage()
		._GoToProductCatalog()
		.clickOnShowHidePrice()
		.clickOnShowHidePrice();
	}
	@Test(groups={"Order_Guide"}, description = "Order Guide_016_01 :Validate Save as a list and successfully saving it.")
	@Features("Order Guide")
	@Stories("Order Guide_016_01 :Validate Save as a list and successfully saving it.")
	public void CreateNewList(){
		LoginData loginData =LoginData.fetch("$OGNormalUser11");
		OrderData orderData = OrderData.fetch("$OrderData107");
		String key=loginData.UserName;
		String upcs=orderData.UPC;
		String[] upcArray=upcs.split(";");
		Start.asTester
		.goToLoginpage()
		.loginToApplication(loginData.UserName, loginData.Password)
		._GoToHomePage()
		.atHomePage()
		//.clickOnExpress()
		.atExpressHomePage()
		._GoToHomePage()
		._GoToOrdeGuidePage()
		.clickOnOrderGuideTab()
		.verifyOrderGuidepage()
		.checkMultipleItem(orderData.UPC.split(";"))
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
		.validateItemsInList(upcArray);
	}
	@Test(groups={"Order_Guide"}, description = "Order Guide_016_02 :Validate Save as a list and saving it to a list with same name.")
	@Features("Order Guide")
	@Stories("Order Guide_016_02 :Validate Save as a list and saving it to a list with same name.")
	public void validateDuplicateListName(){
		LoginData loginData =LoginData.fetch("$OGNormalUser12");
		OrderData orderData = OrderData.fetch("$OrderData108");
		//String upcs=orderData.UPC;
		//String[] upcArray=upcs.split(";");
		String key="Order Guide_016_02";
		Start.asTester
		.goToLoginpage()
		.loginToApplication(loginData.UserName, loginData.Password)
		._GoToHomePage()
		.atHomePage()
		//.clickOnExpress()
		.atExpressHomePage()
		._GoToListPage()
		.clickOnListTab()
		//Create New List
		.clickOnCreateNewList()
		.enterListNameInPopup(key)
		.clickOnCreateList()
		._GoToOrdeGuidePage()
		.clickOnOrderGuideTab()
		.verifyOrderGuidepage()
		.checkMultipleItem(orderData.UPC.split(";"))
		._GoToListPage()
		.clickOnAddToList()
		.clickOnCreateNewListLink()
		.enterDuplicateListName(key)
		._GoToOrdeGuidePage()
		.clickOnCreatNewListPopup()
		//Validating Duplicate List name
		.validateDuplicateListName();
	}
	@Test(groups={"Order_Guide"}, description = "Order Guide_016_03 :Validate Save as a list and clicking on save button.")
	@Features("Order Guide")
	@Stories("Order Guide_016_03 :Validate Save as a list and clicking on save button.")
	public void VerifyListSaveAs(){
		LoginData loginData =LoginData.fetch("$OGNormalUser13");
		Start.asTester
		.goToLoginpage()
		.loginToApplication(loginData.UserName, loginData.Password)
		._GoToHomePage()
		.atHomePage()
		//.clickOnExpress()
		.atExpressHomePage()	
		._GoToHomePage()
		._GoToOrdeGuidePage()
		.clickOnOrderGuideTab()
		.verifyOrderGuidepage()
		.clickOnSaveAsList()
		.clickOnCancelSaveAsListPopUp()
		.validateSaveListPopupAfterCancel();
	}
	@Test(groups={"Order_Guide"}, description = "Order Guide_017_01 :Validate Add to List functionality by adding to an existing list")
	@Features("Order Guide")
	@Stories("Order Guide_017_01 :Validate Add to List functionality by adding to an existing list")
	public void AddItemFromExistingList(){
		LoginData loginData =LoginData.fetch("$OGNormalUser14");
		OrderData orderData = OrderData.fetch("$OrderData109");
		//String upcs=orderData.UPC;
		//String[] upcArray=upcs.split(";");
		String key="Order Guide_017_01";
		Start.asTester
		.goToLoginpage()
		.loginToApplication(loginData.UserName, loginData.Password)
		._GoToHomePage()
		.atHomePage()
		//.clickOnExpress()
		.atExpressHomePage()	
		._GoToListPage()
		.clickOnListTab()
		//Create New List
		.clickOnCreateNewList()
		.enterListNameInPopup(key)
		.clickOnCreateList()
		.clickOnListTab()
		.clickOnMyListLink()
		.getListNumberByListName(key)
		._GoToOrdeGuidePage()
		.clickOnOrderGuideTab()
		.verifyOrderGuidepage()
		//Select Items
		.checkMultipleItem(orderData.UPC.split(";"))
		._GoToListPage()
		.clickOnAddToList()
		//Adding Items To Existing List
		.clickOnExistingList(key)
		.clickOnConform()
		.clickOnListTab()
		.clickOnMyListLink()
		.clickOnAnyListNumber(key)
		._GoToOrdeGuidePage()
		//Validating Items In List
		.validateItemsInList(orderData.UPC.split(";"));
		//.validateItemsInList1(orderData.UPC);
		
	}
	@Test(groups={"Order_Guide"}, description = "Order Guide_017_02 :Validate Add to List functionality by creating a new list")
	@Features("Order Guide")
	@Stories("Order Guide_017_02 :Validate Add to List functionality by creating a new list")
	public void CreateNewListFromOrderGuide(){
		LoginData loginData =LoginData.fetch("$OGNormalUser15");
		OrderData orderData = OrderData.fetch("$OrderData109");
		//String upcs=orderData.UPC;
		//String[] upcArray=upcs.split(";");
		String key="Order Guide_017_02";
		Start.asTester
		.goToLoginpage()
		.loginToApplication(loginData.UserName, loginData.Password)
		._GoToHomePage()
		.atHomePage()
		//.clickOnExpress()
		.atExpressHomePage()	
		._GoToHomePage()
		._GoToOrdeGuidePage()
		.clickOnOrderGuideTab()
		.verifyOrderGuidepage()
		.checkMultipleItem(orderData.UPC.split(";"))
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
		//Validating Items In List
		.validateItemsInList(orderData.UPC.split(";"));
	}
	@Test(groups={"Order_Guide"}, description = "Order Guide_017_03 :Validate Add to List functionality by adding to an existing list and cancelling the save.")
	@Features("Order Guide")
	@Stories("Order Guide_017_03 :Validate Add to List functionality by adding to an existing list and cancelling the save.")
	public void AddItemToExistingList(){
		LoginData loginData =LoginData.fetch("$OGNormalUser16");
		OrderData orderData = OrderData.fetch("$OrderData109");
		String key="Order Guide_017_03";
		Start.asTester
		.goToLoginpage()
		.loginToApplication(loginData.UserName, loginData.Password)
		._GoToHomePage()
		.atHomePage()
		//.clickOnExpress()
		.atExpressHomePage()	
		._GoToListPage()
		.clickOnListTab()
		//Create New List
		.clickOnCreateNewList()
		.enterListNameInPopup(key)
		.clickOnCreateList()
		.clickOnListTab()
		.clickOnMyListLink()
		.getListNumberByListName(key)
		._GoToOrdeGuidePage()
		.clickOnOrderGuideTab()
		.verifyOrderGuidepage()
		//Select Items
		.checkMultipleItem(orderData.UPC.split(";"))
		._GoToListPage()
		.clickOnAddToList()
		//Adding Items To Existing List
		.clickOnExistingList(key)
		.clickOnCancelOnAddToListPopUp()
		._GoToOrdeGuidePage()
		.validateAddListPopupAfterCancel();
	}
	@Test(groups={"Order_Guide"}, description = "Order Guide_018_03 : Validate Clear Settings for All User")
	@Features("Order Guide")
	@Stories("Order Guide_018_03 : Validate Clear Settings for All User")
	public void validateDefaultSetting(){
		LoginData loginData =LoginData.fetch("$OGNormalUser17");
		Start.asTester
		.goToLoginpage()
		.loginToApplication(loginData.UserName, loginData.Password)
		._GoToHomePage()
		.atHomePage()
		//.clickOnExpress()
		.atExpressHomePage()	
		._GoToHomePage()
		._GoToOrdeGuidePage()
		.clickOnOrderGuideTab()
		.verifyOrderGuidepage()
		.clickOnClearSetting()
		.validateDefaultColumn()
		._GoOrderPage()
		.close();
	}
	@Test(groups={"Order_Guide"}, description = "Order Guide_019 :Validation of Split/ Case item display.")
	@Features("Order Guide")
	@Stories("Order Guide_019 : Validation of Split/ Case item display.")
	public void VerfiyColumnForMultipleItem(){
		LoginData loginData =LoginData.fetch("$OGNormalUser18");
		OrderData orderData_01 = OrderData.fetch("$OrderData119");
		OrderData orderData_02 = OrderData.fetch("$OrderData23");
		Start.asTester
		.goToLoginpage()
		.loginToApplication(loginData.UserName, loginData.Password)
		._GoToHomePage()
		.atHomePage()
		//.clickOnExpress()
		.atExpressHomePage()	
		._GoToHomePage()
		._GoToOrdeGuidePage()
		.clickOnOrderGuideTab()
		.verifyOrderGuidepage()
		.enterTypeInSearchBox(orderData_01.UPC)
		.validateOrderQunatityUnitCS(orderData_01.UPC)
		.validateOrderQunatityUnitEA(orderData_01.UPC)
		.validateSplitRecordUPC(orderData_01.UPC)
		.validateCheckBox(orderData_01.UPC)
		.validateCheckBoxForSplitItem(orderData_01.UPC)
		.enterTypeInSearchBox(orderData_02.UPC)
		.validateOrderQunatityUnitCS(orderData_02.UPC)
		.validateNonSplitRecordUPC(orderData_02.UPC)
		.validateCheckBox(orderData_02.UPC)
		.enterTypeInSearchBox(orderData_01.UPC)
		.validateQunatityText(orderData_01.UPC)
		.validateSplitQunatity(orderData_01.UPC)
		.verifyDropDownValuesInSplitItem(orderData_01.UPC);
		
	}
	@Test(groups={"Order_Guide"}, description = "Order Guide_013 :Verification of Order Guide.")
	@Features("Order Guide")
	@Stories("Order Guide_013 : Verification of Order Guide.")
	public void VerfiyColumn(){
		LoginData loginData =LoginData.fetch("$OGNormalUser19");
		OrderData orderData_01 = OrderData.fetch("$OrderData21");
		Start.asTester
		.goToLoginpage()
		.loginToApplication(loginData.UserName, loginData.Password)
		._GoToHomePage()
		.atHomePage()
		//.clickOnExpress()
		.atExpressHomePage()	
		._GoToHomePage()
		._GoToOrdeGuidePage()
		.clickOnOrderGuideTab()
		.verifyOrderGuidepage()
		.validateOrderBefore()
		.validateLastOrder()
		.selectCustomDate()
		.validateItemsHistory(28)
		.validateYes()
		._GoToHomePage()
		.clickOnPrduct(orderData_01.UPC)
		.switchToProductInfoWindow()
		._GoToOrdeGuidePage()
		.validateProductInfo(orderData_01.UPC)
		._GoToHomePage()
		.switchToMainWindow();
	}
}
