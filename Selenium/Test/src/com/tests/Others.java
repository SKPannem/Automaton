package com.tests;

import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

import com.components.entities.Start;
import com.components.testdata.LoginData;
import com.components.testdata.OrderData;
import com.iwaf.framework.Initiator;

public class Others  extends Initiator{ 
	@Test(groups={"Others"}, description = "Lists_014 :Validate list tools under Sysco Recommended Lists' ")
	@Features("print_List")
	@Stories("print_Lists_014 : Validate list tools under Sysco Recommended Lists' ")
	public void VerfiyListDrpDownMenuInSyscoList() {	
		
		String tcName="ANDYS DINER Order Guide";
		LoginData loginData =LoginData.fetch("$NormalUser7");	
		OrderData orderData_001 =OrderData.fetch("$OrderData145");
		OrderData orderData_002 =OrderData.fetch("$OrderData64");
		String key=loginData.UserName;
		Start.asTester
			.goToLoginpage()
			.loginToApplication(loginData.UserName, loginData.Password)
			._GoToHomePage()
			.atHomePage()
			.clickOnExpress()
			.atExpressHomePage()
			._GoToListPage()
			.clickOnListTab()
			//.Clicking On Sysco Recommended  Link
			//.clickOnSyscoRecommendedLink(orderData_001.ListName)
			//.getListNumberForSyscoList(orderData_001.ListName,key)
			.clickOnSyscoLIst(tcName)
			//.clickOnAnyListNumber(tcName)
			//.syscoList(orderData_001.ListName)
			.checkDropDowninList(orderData_001.GroupBY.split(";"))
			.selectPrintListFromDropDown()
			.selectCopyListFromDropDown()
			.selectExportListFromDropDown()
			.checkDropDownInExportList(orderData_002.GroupBY.split(";"))
			.clickCancelOnExport()
			;
	}
	@Test(groups={"Others"}, description = "print_Lists_015 :Validate list tools under Shared Lists. ")
	@Features("print_List")
	@Stories("print_Lists_015 : Validate list tools under Shared Lists. ")
	public void VerfiyListDrpDownMenuInSharedList() {	
		
		LoginData loginData_001 =LoginData.fetch("$NormalUser31");	
		LoginData loginData_002 =LoginData.fetch("$NormalUser32");	
		OrderData orderData =OrderData.fetch("$OrderData67");
		OrderData orderData2 =OrderData.fetch("$OrderData120");
        System.out.println("login_data and order_data are ready");
        String key1=loginData_001.UserName;
		Start.asTester
			.goToLoginpage()
			.loginToApplication(loginData_001.UserName, loginData_001.Password)
			._GoToHomePage()
			.atHomePage()
			.clickOnExpress()
			.atExpressHomePage()
			._GoToListPage()
			.clickOnListTab()
			._GoToHomePage()
			.verifyListpage()
			._GoToListPage()
			//Creating New List in user-1
			.clickOnCreateNewList()
			.enterListNameInPopup(key1)
			.clickOnCreateList()
			.clickOnListTab()
			.clickOnMyListLink()
			.getListNumberByListName(key1)
			._GoToHomePage()
			//Adding Items to List
			.enterAnyItemInSearchBox(orderData.ItemName)
			.clickOnSearchButton()
			.checkOnAllItem()
			._GoToListPage()
			.clickOnAddToList()
			.clickOnExistingList(key1)
			.clickOnConform()
			._GoOrderPage()
			.close()
			._atLoginPage()
			//Logging  Another User 
			.loginToApplication(loginData_002.UserName, loginData_002.Password)
			._GoToHomePage()
			.atHomePage()
			.clickOnExpress()
			.atExpressHomePage()
			._GoToListPage()
			.clickOnListTab()
			.clickOnShareListLink()
			.clickOnAnyListNumber(key1)
			.checkDropDowninList(orderData.GroupBY.split(";"))
			.selectPrintListFromDropDown()
			.selectCopyListFromDropDown()
			.selectExportListFromDropDown()
			.checkDropDownInExportList(orderData2.GroupBY.split(";"));
			//.clickCancelOnExport()
			;
	}
	@Test(groups={"Others"}, description = "Lists_017 :Validate list tools under My Lists")
	@Features("print_List")
	@Stories("print_Lists_017 : Validate list tools under My Lists")
	public void VerfiyListDrpDownMenuInMyList() {	
		LoginData loginData =LoginData.fetch("$NormalUser4");	
		OrderData orderData =OrderData.fetch("$OrderData68");
		String key=loginData.UserName;
		Start.asTester
			.goToLoginpage()
			.loginToApplication(loginData.UserName, loginData.Password)
			._GoToHomePage()
			.atHomePage()
			.clickOnExpress()
			.atExpressHomePage()
			._GoToListPage()
			.clickOnListTab()
			._GoToHomePage()
			.verifyListpage()
			._GoToListPage()
			//Creating New List
			.clickOnCreateNewList()
			.enterListNameInPopup(key)
			.clickOnCreateList()
			.clickOnListTab()
			.clickOnMyListLink()
			.getListNumberByListName(key)
			._GoToHomePage()
			//Adding Items to List
			.enterAnyItemInSearchBox(orderData.ItemName)
			.clickOnSearchButton()
			.checkOnAllItem()
			._GoToListPage()
			.clickOnAddToList()
			.clickOnExistingList(key)
			.clickOnConform()
			._GoToListPage()
			.clickOnListTab()
			.clickOnMyListLink()
			.clickOnAnyListNumber(key)
			.clickOnEditList()
			//Entering List Quantity
			.enterListQuantity(orderData.UPC.split(";"),orderData.CaseQuantity.split(";"))
			//.clickOnSaveList()
			.clickOnSaveList1()
			//Validate Drop down
			.checkDropDowninList(orderData.GroupBY.split(";"))
			//Selecting List Tools And Validate it
			.selectUseListQuantityFromDropDown()
			._GoOrderPage()
			.clickOnCreatNewOrder()
			._GoToListPage()
			.validateUseListQunatity(orderData.UPC.split(";"))
			.selectPrintListFromDropDown()
			.selectCopyListFromDropDown()
			//.selectExportListFromDropDown()
			//.clickCancelOnExport()
			.selectSendListFromDropDown()
			//Deleting List And Validating It In My list
			.selectDeleteListFromDropDown()
			.clickOnDeleteInDeleteListPopup()
			.clickOnListTab()
			.clickOnMyListLink()
			.validateListNameInMyListAfterDelete(key);
	}
	@Test(groups={"Others"}, description = "List_002_01 :Validate List import functionality(cancel import).")
	@Features("import_List")
	@Stories("import_List_002_01 :Validate List import functionality(cancel import).")
	public void ImportList() {	
		
		LoginData loginData =LoginData.fetch("$NormalUser12");
		Start.asTester
			.goToLoginpage()
			.loginToApplication(loginData.UserName, loginData.Password)
			._GoToHomePage()
			.atHomePage()
			.clickOnExpress()
			.verifyHomePage()
			.atExpressHomePage()
			._GoToListPage()
			.clickOnListTab()
			._GoToHomePage()
			.verifyListpage()
			._GoToListPage()
			.clickOnImportList()
			.clickOnCancelImportList();
			;
	}
	
	@Test(groups={"Others"}, description = "Product Catalogue_009 : Validating Print Popup")
	@Features("print_Product Catalogue")
	@Stories("print_ProductCatalogue_009 :Validating Print Popup")
	public void validatePrint() {	
		
		LoginData loginData =LoginData.fetch("$PNormalUser7");	
		OrderData orderData = OrderData.fetch("$OrderData5");
	    String data_Items=orderData.ItemName;
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
	        .clickOnPrint()
	        .validatePrintWindow()
	        .checkPrintAddtionalColumn()
	        .uncheckAdditionalColumn();
	}
	@Test(groups={"Others"}, description = "Product Catalogue_010 : Printing product information")
	@Features("print_Product Catalogue")
	@Stories("print_ProductCatalogue_010 :Printing product information")
	public void validatePrintProductInfo() {	
		
		LoginData loginData =LoginData.fetch("$PNormalUser8");	
		OrderData orderData =OrderData.fetch("$OrderData43");
		Start.asTester
			.goToLoginpage()
			.loginToApplication(loginData.UserName, loginData.Password)
			._GoToHomePage()
			.atHomePage()
			.clickOnExpress()
			.atExpressHomePage()
			._GoToHomePage()
			.enterAnyItemInSearchBox(orderData.ItemName)
			.clickOnSearchButton()
			.clickOnPrduct(orderData.UPC)
			.switchToProductInfoWindow()
			.clickOnPrintProductInfo()
			.switchToMainWindow();
			
	}
	@Test(groups={"Others"}, description = "Product Catalogue_011 : Printing Preview Page")
	@Features("print_Product Catalogue")
	@Stories("print_ProductCatalogue_011 :Printing Preview Page")
	public void validateProductPreview() {	
		
		LoginData loginData =LoginData.fetch("$PNormalUser9");	
		OrderData orderData = OrderData.fetch("$OrderData1");
		Start.asTester
			.goToLoginpage()
			.loginToApplication(loginData.UserName, loginData.Password)
			._GoToHomePage()
			.atHomePage()
			.clickOnExpress()
			.atExpressHomePage()
			.enterAnyItemInSearchBox(orderData.ItemName)
			.clickOnSearchButton()
			._GoToProductCatalog()
			.clickOnPrint();
	}
	@Test(groups={"Others"}, description = "Product Catalogue_013 : Removing Some Columns From Column Setting")
	@Features("print_Product Catalogue")
	@Stories("print_ProductCatalogue_013 :Removing Some Columns From Column Setting")
	public void validateRemoveColumnSettings() {	
		
		LoginData loginData =LoginData.fetch("$PNormalUser11");	
		OrderData orderData = OrderData.fetch("$OrderData1");
        System.out.println("login_data and order_data are ready");
		Start.asTester
			.goToLoginpage()
			.loginToApplication(loginData.UserName, loginData.Password)
			._GoToHomePage()
			.atHomePage()
			.clickOnExpress()
			.atExpressHomePage()
			.enterAnyItemInSearchBox(orderData.ItemName)
			.clickOnSearchButton()
			._GoToProductCatalog()
			.clickOnColumnSetting()
			.clickOnRemoveAll()
			.clickOnOkButton()
			.clickOnPrint()
			.clickOnCancelButton();
		
	}
	@Test(groups={"Others"}, description = "Product Catalogue_014 : Printing Items categorised by sysco category ")
	@Features("print_Product Catalogue")
	@Stories("print_ProductCatalogue_014 :Printing Items categorised by sysco category")
	public void validatePrintSyscoCategory() {	
		
		LoginData loginData =LoginData.fetch("$PNormalUser12");	
		OrderData orderData = OrderData.fetch("$OrderData1");
        System.out.println("login_data and order_data are ready");
		Start.asTester
			.goToLoginpage()
			.loginToApplication(loginData.UserName, loginData.Password)
			._GoToHomePage()
			.atHomePage()
			.clickOnExpress()
			.atExpressHomePage()
			.enterAnyItemInSearchBox(orderData.ItemName)
			.clickOnSearchButton()
			._GoToProductCatalog()
			.clickOnGroupByCategory()
			.clickOnPrint()
			.clickOnCancelButton();
	}
	@Test(groups={"Others"}, description = "Order Guide_002_01 : Validate Print option in Order Guide by selecting Live Price option.")
	@Features("print_Order Guide")
	@Stories("print_Order Guide_002_01 : Validate Print option in Order Guide by selecting Live Price option.")
	public void PrintLivePrice(){
		LoginData loginData =LoginData.fetch("$OGNormalUser2");
		Start.asTester
		.goToLoginpage()
		.loginToApplication(loginData.UserName, loginData.Password)
		._GoToHomePage()
		.atHomePage()
		.clickOnExpress()
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
	@Test(groups={"Others"}, description = "Order Entry Submit_015_07 : Verification error while Importing Order containing error. Rectify the eror and submit it")
	@Features("import_Order Submit")
	@Stories("import_Order Entry Submit_015_07 :Verification error while Importing Order containing error. Rectify the eror and submit it")
	public void VerifyImportOrder() {	
		
		LoginData loginData =LoginData.fetch("$OMUser43");
		OrderData orderData = OrderData.fetch("$OrderData64");
		Start.asTester
			.goToLoginpage()
			.loginToApplication(loginData.UserName, loginData.Password)
			._GoToHomePage()
			.atHomePage()
			.clickOnExpress()
			.atExpressHomePage()
			._GoOrderPage()
		    .orderPageTab()
		    .verifyOrderPage()
			._GoOrderPage()
			.clickOnImportOrder()
			.clickOnImportCancelButton();
		    
	}
	@Test(groups={"Others"}, description = "Order Entry Submit_015_06 : Order import using option 6-CSV")
	@Features("import_Order Submit")
	@Stories("import_Order Entry Submit_015_06 :Order import using option 6-CSV")
	public void ImportOrder() {	
		
		LoginData loginData =LoginData.fetch("$OMUser41");
		OrderData orderData = OrderData.fetch("$OrderData64");
		Start.asTester
			.goToLoginpage()
			.loginToApplication(loginData.UserName, loginData.Password)
			._GoToHomePage()
			.atHomePage()
			.clickOnExpress()
			.atExpressHomePage()
			._GoOrderPage()
		    .orderPageTab()
		    .verifyOrderPage()
			._GoOrderPage()
			.clickOnImportOrder()
			//.viewImportOrderDropDown(orderData.GroupBY.split(";"))
			//.selectCSVFromImportDropMenu()
			.verifyimportoptionsorder()
			.clickOnImportCancelButton();
		    
	}


}
