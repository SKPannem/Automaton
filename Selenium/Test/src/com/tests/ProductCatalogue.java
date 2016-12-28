package com.tests;

import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

import com.components.entities.Start;
import com.components.testdata.ColumnsSelected;
import com.components.testdata.LoginData;
import com.components.testdata.OrderData;
import com.iwaf.framework.Initiator;

public class ProductCatalogue extends Initiator {
	@Test(groups={"Product_Catalog"}, description = "Product Catalogue_003 : Validate Stock type column display,Filter and Narrow your results section.")
	@Features("Product Catalogue")
	@Stories("ProductCatalogue_003 :Validate Stock type column display,Filter and Narrow your results section.")
	public void validateProductStockIndicator() {	
		
		LoginData loginData =LoginData.fetch("$PNormalUser1");	
		OrderData orderData = OrderData.fetch("$OrderData5");
	    String data=orderData.ItemName;
	    String[] arrData=data.split(";");
        System.out.println("login_data and order_data are ready");
		Start.asTester
			.goToLoginpage()
			.loginToApplication(loginData.UserName, loginData.Password)
			._GoToHomePage()
			.atHomePage()
			//.clickOnExpress()
			.atExpressHomePage()
			._GoToProductCatalog()
			.clickOnProductTab()
			.verifyProductButton()
			.clickOnProductCategory(arrData[0])
	        .clickOnSubCategory(arrData[1])
	        .clickOnSelectedItem(arrData[2])
	        .clickOnNarrowResult()
	        .verifyNarrowResult(orderData.GroupBY.split(";"))
	        .validateStockIndicatorFilter()
	        .checkOnStockItem()
	        .checkValidationStockType()
	        .clickOnResetFilter()
	        .checkOnRemoteItem()
	        .checkValidationRemoteType()
	        .clickOnResetFilter()
	        .checkOnDemandStatus()
	        .checkValidationDemandStatus()
	        .clickOnResetFilter()
	        .clickOnCategory()
	        .checkOnCategory()
	        .checkValidationCategory(arrData[0])
	        .clickOnResetFilter()
	        .clickOnBrand()
	        .validateBrand()
	        .clickOnStorage()
	        .validateStorage();
	}
	@Test(groups={"Product_Catalog"}, description = "Product Catalogue_005_01 : Validate Add to List functionality for an user other than demo user(Adding to a existing list)")
	@Features("Product Catalogue")
	@Stories("ProductCatalogue_005_01 :Validate Add to List functionality for an user other than demo user(Adding to a existing list)")
	public void validateAddToExistingList() {	
		
		LoginData loginData =LoginData.fetch("$PNormalUser2");	
		OrderData orderData = OrderData.fetch("$OrderData5");
	    String data_Items=orderData.ItemName;
	    String[] arrData_Items=data_Items.split(";");
	    String key="ProductCatalogue_005_01";
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
			._GoToProductCatalog()
			.clickOnProductTab()
			.verifyProductButton()
			.clickOnProductCategory(arrData_Items[0])
	        .clickOnSubCategory(arrData_Items[1])
	        .clickOnSelectedItem(arrData_Items[2])
	        ._GoToListPage()
		     .checkOnItem(orderData.UPC.split(";"))
		    .clickOnAddToList()
		    .clickOnExistingList(key)
		    .clickOnConform()
		    .clickOnListTab()
		    .clickOnMyListLink()
		    .clickOnAnyListNumber(key)
		    .verifyMultpleItemsInList(orderData.UPC.split(";"));
		    
	}
	@Test(groups={"Product_Catalog"}, description = "Product Catalogue_005_02 : Validate Add to List functionality for an user other than demo user (Adding to a new list).")
	@Features("Product Catalogue")
	@Stories("ProductCatalogue_005_02 :Validate Add to List functionality for an user other than demo user (Adding to a new list).")
	public void validateAddToNewList() {	
		
		LoginData loginData =LoginData.fetch("$PNormalUser3");	
		OrderData orderData = OrderData.fetch("$OrderData5");
	    String data_Items=orderData.ItemName;
	    String[] arrData_Items=data_Items.split(";");
	    String key="ProductCatalogue_005_02";
        Start.asTester
			.goToLoginpage()
			.loginToApplication(loginData.UserName, loginData.Password)
			._GoToHomePage()
			.atHomePage()
			//.clickOnExpress()
			.atExpressHomePage()
			._GoToProductCatalog()
			.clickOnProductTab()
			.verifyProductButton()
			.clickOnProductCategory(arrData_Items[0])
	        .clickOnSubCategory(arrData_Items[1])
	        .clickOnSelectedItem(arrData_Items[2])
	        ._GoToListPage()
		     .checkOnItem(orderData.UPC.split(";"))
		    .clickOnAddToList()
		    .clickOnCreateNewListLink()
		    .enterListName(key)
		    .clickOnCreatNewListInAddListPopup()
		    .clickOnListTab()
		    .clickOnMyListLink()
		    .getListNumberByListName(key)
		    .clickOnAnyListNumber(key)
		    .verifyMultpleItemsInList(orderData.UPC.split(";"));
	}
	@Test(groups={"Product_Catalog"}, description = "Product Catalogue_007_01 : Add And Remove Operation In Column setting")
	@Features("Product Catalogue")
	@Stories("ProductCatalogue_007_01 :Add And Remove Operation In Column setting")
	public void validateColumnSettings() {	
		
		LoginData loginData =LoginData.fetch("$PNormalUser4");	
		OrderData orderData = OrderData.fetch("$OrderData5");
		ColumnsSelected column_Selected=ColumnsSelected.fetch("$ColumnsAdded");
	    String data_Items=orderData.ItemName;
	    String[] arrData_Items=data_Items.split(";");
		Start.asTester
			.goToLoginpage()
			.loginToApplication(loginData.UserName, loginData.Password)
			._GoToHomePage()
			.atHomePage()
			//.clickOnExpress()
			.atExpressHomePage()
			._GoToProductCatalog()
			.clickOnProductTab()
			.clickOnProductCategory(arrData_Items[0])
	        .clickOnSubCategory(arrData_Items[1])
	        .clickOnSelectedItem(arrData_Items[2])
	        .clickOnColumnSetting()
	        .clickOnCloseWindow()
	        .clickOnColumnSetting()
	        .clickOnRemoveAll()
	        .validateItems_RemoveAll()
	        .getColumns_AddAllSection()
	        .clickOnOkButton()
	        .validateColumnInProductPageAfterRemoveAll()
	        .clickOnColumnSetting()
	        .clickOnAddAll()
	        .validateItems_AddAll()
	        .clickOnOkButton()
	        .validateColumnInProductPageAfterAddAll()
	        .clickOnColumnSetting()
	        .clickOnRemoveAll()
	        .selectColumnsInAnySection(column_Selected.Columns.split(";"))
	        .clickOnOkButton()
	        .validateSelectedColumn(column_Selected.Columns.split(";"));
	        
	}
	@Test(groups={"Product_Catalog"}, description = "Product Catalogue_007_02 :Cancelling The Column setting Window")
	@Features("Product Catalogue")
	@Stories("ProductCatalogue_007_02 :Cancelling The Column setting Window")
	public void validateCancelColumnSettings() {	
		
		LoginData loginData =LoginData.fetch("$PNormalUser5");	
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
			._GoToProductCatalog()
			.clickOnProductTab()
			.clickOnProductCategory(arrData_Items[0])
	        .clickOnSubCategory(arrData_Items[1])
	        .clickOnSelectedItem(arrData_Items[2])
	        .clickOnColumnSetting()
	        .clickOnCloseWindow()
	        .validateColumnSelectWindowAfterCancel();
	}
	@Test(groups={"Product_Catalog"}, description = "Product Catalogue_008 :Validating Show Price Button")
	@Features("Product Catalogue")
	@Stories("ProductCatalogue_008 :Validating Show Price Button")
	public void validateShowPrice() {	
		
		LoginData loginData =LoginData.fetch("$PNormalUser6");	
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
			._GoToProductCatalog()
			.clickOnProductTab()
			.clickOnProductCategory(arrData_Items[0])
	        .clickOnSubCategory(arrData_Items[1])
	        .clickOnSelectedItem(arrData_Items[2])
	        .clickOnShowHidePrice()
	        .clickOnShowHidePrice();
	}
	@Test(groups={"Product_Catalog"}, description = "Product Catalogue_009 : Validating Print Popup")
	@Features("Product Catalogue")
	@Stories("ProductCatalogue_009 :Validating Print Popup")
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
			//.clickOnExpress()
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
	@Test(groups={"Product_Catalog"}, description = "Product Catalogue_010 : Printing product information")
	@Features("Product Catalogue")
	@Stories("ProductCatalogue_010 :Printing product information")
	public void validatePrintProductInfo() {	
		
		LoginData loginData =LoginData.fetch("$PNormalUser8");	
		OrderData orderData =OrderData.fetch("$OrderData43");
		Start.asTester
			.goToLoginpage()
			.loginToApplication(loginData.UserName, loginData.Password)
			._GoToHomePage()
			.atHomePage()
			//.clickOnExpress()
			.atExpressHomePage()
			._GoToHomePage()
			.enterAnyItemInSearchBox(orderData.ItemName)
			.clickOnSearchButton()
			.clickOnPrduct(orderData.UPC)
			.switchToProductInfoWindow()
			.clickOnPrintProductInfo()
			.switchToMainWindow();
			
	}
    @Test(groups={"Product_Catalog"}, description = "Product Catalogue_011 : Printing Preview Page")
	@Features("Product Catalogue")
	@Stories("ProductCatalogue_011 :Printing Preview Page")
	public void validateProductPreview() {	
		
		LoginData loginData =LoginData.fetch("$PNormalUser9");	
		OrderData orderData = OrderData.fetch("$OrderData1");
		Start.asTester
			.goToLoginpage()
			.loginToApplication(loginData.UserName, loginData.Password)
			._GoToHomePage()
			.atHomePage()
			//.clickOnExpress()
			.atExpressHomePage()
			.enterAnyItemInSearchBox(orderData.ItemName)
			.clickOnSearchButton()
			._GoToProductCatalog()
			.clickOnPrint();
	}
	@Test(groups={"Product_Catalog"}, description = "Product Catalogue_012 : Validating Product Card")
	@Features("Product Catalogue")
	@Stories("ProductCatalogue_012 :Validating Product Card")
	public void validateProductCardOptions() {	
		
		LoginData loginData =LoginData.fetch("$PNormalUser10");	
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
			._GoToProductCatalog()
			.clickOnProductTab()
			.clickOnProductCategory(arrData_Items[0])
	        .clickOnSubCategory(arrData_Items[1])
	        .clickOnSelectedItem(arrData_Items[2])
	        ._GoToHomePage()
	        .clickOnPrduct(orderData.UPC.split(";")[0])
	        .switchToProductInfoWindow()
	        ._GoToProductCatalog()
	        .validateProductInfo()
	        ._GoToHomePage()
	        .switchToMainWindow();
			
	}
	@Test(groups={"Product_Catalog"}, description = "Product Catalogue_013 : Removing Some Columns From Column Setting")
	@Features("Product Catalogue")
	@Stories("ProductCatalogue_013 :Removing Some Columns From Column Setting")
	public void validateRemoveColumnSettings() {	
		
		LoginData loginData =LoginData.fetch("$PNormalUser11");	
		OrderData orderData = OrderData.fetch("$OrderData1");
        System.out.println("login_data and order_data are ready");
		Start.asTester
			.goToLoginpage()
			.loginToApplication(loginData.UserName, loginData.Password)
			._GoToHomePage()
			.atHomePage()
			//.clickOnExpress()
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
	@Test(groups={"Product_Catalog"}, description = "Product Catalogue_014 : Printing Items categorised by sysco category ")
	@Features("Product Catalogue")
	@Stories("ProductCatalogue_014 :Printing Items categorised by sysco category")
	public void validatePrintSyscoCategory() {	
		
		LoginData loginData =LoginData.fetch("$PNormalUser12");	
		OrderData orderData = OrderData.fetch("$OrderData1");
        System.out.println("login_data and order_data are ready");
		Start.asTester
			.goToLoginpage()
			.loginToApplication(loginData.UserName, loginData.Password)
			._GoToHomePage()
			.atHomePage()
			//.clickOnExpress()
			.atExpressHomePage()
			.enterAnyItemInSearchBox(orderData.ItemName)
			.clickOnSearchButton()
			._GoToProductCatalog()
			.clickOnGroupByCategory()
			.clickOnPrint()
			.clickOnCancelButton();
	}
}
