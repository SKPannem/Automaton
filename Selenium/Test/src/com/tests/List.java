package com.tests;

import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

import com.components.entities.Start;
import com.components.pages.HomePage;
import com.components.testdata.LoginData;
import com.components.testdata.OrderData;
import com.iwaf.framework.Initiator;

public class List extends Initiator{
	@Test(groups={"List"}, description = "List_000 : Verification of List Creation after selecting items from Product catalogue and order guide")
	@Features("List")
	@Stories("List_000 : Verification of List Creation after selecting items from Product catalogue and order guide")
	public void AddItemsToList() {	
	    String tcName="List_000";
		LoginData loginData =LoginData.fetch("$NormalUser19");	
		OrderData orderData_001 =OrderData.fetch("$OrderData41");
		OrderData orderData_003 =OrderData.fetch("$OrderData40");
		String upcs=orderData_001.UPC;
		String[] upcNumber=upcs.split(";");
		Start.asTester
			.goToLoginpage()
			.loginToApplication(loginData.UserName, loginData.Password)
			._GoToHomePage()
			.atHomePage()
			//.clickOnExpress()
			.atExpressHomePage()
			._GoToHomePage()
			//Searching any Items
			.enterAnyItemInSearchBox(orderData_003.ItemName)
			.clickOnSearchButton()
			._GoOrderPage()
			.checkOnItem(orderData_003.UPC.split(";"))
			._GoToListPage()
			.clickOnAddToList()
			.clickOnCreateNewListLink()
			.enterListName(tcName)
			.clickOnCreatNewListInAddListPopup()
			.clickOnListTab()
			.clickOnMyListLink()
			.getListNumberByListName(tcName)
			.clickOnAnyListNumberwithId(tcName)
			.verifyItemsInList(orderData_003.UPC)
			._GoToOrdeGuidePage()
			//Select Items From Order Guide
			.clickOnOrderGuideTab()
		    .checkMultipleItem(upcNumber)
			._GoToListPage()
			//Creating List
			.clickOnAddToList()
			.clickOnCreateNewListLink()
			.enterListName(tcName)
			.clickOnCreatNewListInAddListPopup()
			.clickOnListTab()
			.clickOnMyListLink()
			.getListNumberByListName(tcName)
			.clickOnAnyListNumber(tcName)
			//Verifying Items  In Lists
			.verifyMultpleItemsInList(upcNumber)
			.checkItemsFromLists(upcNumber)
			.clickOnAddToList()
			.clickOnCreateNewListLink()
			.enterListName(tcName)
			.clickOnCreatNewListInAddListPopup()
			.clickOnListTab()
			.clickOnMyListLink()
			.getListNumberByListName(tcName)
			.clickOnAnyListNumber(tcName)
			.verifyMultpleItemsInList(upcNumber);
			
			
	}
	@Test(groups={"List"}, description = "List_005:Verification of adding item to list by clicking on save to list from product card")
	@Features("List")
	@Stories("List_005 : Verification of adding item to list by clicking on save to list from product card")
	public void CreateNewList() {	
		String key="List_005";
		LoginData loginData =LoginData.fetch("$NormalUser18");	
		OrderData orderData =OrderData.fetch("$OrderData43");
        System.out.println("login_data and order_data are ready");
        Start.asTester
		.goToLoginpage()
		.loginToApplication(loginData.UserName, loginData.Password)
		._GoToHomePage()
		.atHomePage()
		//.clickOnExpress()
		.atExpressHomePage()
		._GoToHomePage()
		//Searching Items
		.enterAnyItemInSearchBox(orderData.ItemName)
		.clickOnSearchButton()
		.clickOnPrduct(orderData.UPC)
		//Switching To Product info window
		.switchToProductInfoWindow()
		._GoToListPage()
		.clickOnAddToListInProductInfoWindow()
		.clickOnCreateNewListInProductInfoWindow()
		.enterListNameInPopup(key)
		.clickOnCreateNewListPopup()
		._GoToHomePage()
		.switchToMainWindow()
		._GoToOrdeGuidePage()
		.clickOnOrderGuideTab()
		.clickOnSaveAsList()
		.enterNameOfList()
		.clickOnSaveNewList()
		._GoToListPage()
		//View Created List
		.clickOnVisitListNow()
		.clickOnMyListLink()
		.validateListNameInSaveList(key);
	}
	@Test(groups={"List"}, description = "List_005_02 : Validate create new list functionality.")
	@Features("List")
	@Stories("List_005_02 :Validate create new list functionality.")
	public void addItemsToListFromProductGuide() {	
		String key="List_005_02";
		LoginData loginData =LoginData.fetch("$NormalUser17");	
		Start.asTester
			.goToLoginpage()
			.loginToApplication(loginData.UserName, loginData.Password)
			._GoToHomePage()
			.atHomePage()
			//.clickOnExpress()
			.atExpressHomePage()
			._GoToListPage()
			.clickOnListTab()
			._GoToHomePage()
			.verifyListpage()
			._GoToListPage()
			.clickOnMyListLink()
			.clickOnCreateNewList()
			.verifyCreateListPopup()
			.enterListNameInPopup(key)
			.clickOnCreateList()
			.clickOnListTab()
			.clickOnMyListLink()
			.getListNumberByListName(key)
			.validateListNameInMyList(key);
	}
	@Test(groups={"List"}, description = "List_009_01 :Validate cancel option in Delete list functionality")
	@Features("List")
	@Stories("List_009_01 : Validate cancel option in Delete list functionality")
	public void CancelDeleteListInMyList() {	
		String tcName="List_009_01";
		LoginData loginData =LoginData.fetch("$NormalUser16");	
		OrderData orderData =OrderData.fetch("$OrderData15");
		Start.asTester
		.goToLoginpage()
		.loginToApplication(loginData.UserName, loginData.Password)
		._GoToHomePage()
		.atHomePage()
		//.clickOnExpress()
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
		.enterAnyItemInSearchBox(orderData.ItemName)
		.clickOnSearchButton()
		.checkOnAllItem()
		._GoToListPage()
		.clickOnAddToList()
		.clickOnExistingList(tcName)
		.clickOnConform()
		.clickOnListTab()
		.clickOnMyListLink()
		.clickOnAnyListNumber(tcName)
		.selectDeleteListFromDropDown()
		.verifyDeleteListPopup()
		.clickOnCancelInDeleteListPopup()
		.validateDeleteListPopupAfterCancel();
	}
	@Test(groups={"List"}, description = "List_009_02 :Validate Delete list functionality.")
	@Features("List")
	@Stories("List_009_02 : Validate Delete list functionality.")
	public void DeleteListInMyList() {	
		String tcName="List_009_01";
		LoginData loginData =LoginData.fetch("$NormalUser15");
		OrderData orderData =OrderData.fetch("$OrderData45");
		Start.asTester
			.goToLoginpage()
			.loginToApplication(loginData.UserName, loginData.Password)
			._GoToHomePage()
			.atHomePage()
			//.clickOnExpress()
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
			.enterAnyItemInSearchBox(orderData.ItemName)
			.clickOnSearchButton()
			.checkOnAllItem()
			._GoToListPage()
			.clickOnAddToList()
			.clickOnExistingList(tcName)
			.clickOnConform()
			.clickOnListTab()
			.clickOnMyListLink()
			.clickOnAnyListNumber(tcName)
			.selectDeleteListFromDropDown()
			.verifyDeleteListPopup()
			.clickOnDeleteInDeleteListPopup()
			._GoToHomePage()
			.verifyListpage()
			._GoOrderPage();
	}
	@Test(groups={"List"}, description = "List_001 : Validate Lists Type and Edit List for All User")
	@Features("List")
	@Stories("List_001 : Validate Lists Type and Edit List for All User")
	public void validateListInMultipleUser() {	
		
		LoginData loginData_01 =LoginData.fetch("$NormalUser13");	
		LoginData loginData_02 =LoginData.fetch("$NormalUser14");
		
		
		OrderData orderData_001 =OrderData.fetch("$OrderData47");
		OrderData orderData_003 =OrderData.fetch("$OrderData46");
		
		String key1=loginData_01.UserName;
		String key2=loginData_02.UserName;
		String key3="List_001";
		
			Start.asTester
			.goToLoginpage()
			//Creating List For 1st User
			.loginToApplication(loginData_01.UserName, loginData_01.Password)
			._GoToHomePage()
			.atHomePage()
			//.clickOnExpress()
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
			.enterAnyItemInSearchBox(orderData_001.ItemName)
			.clickOnSearchButton()
			._GoToListPage()
			.checkOnItem(orderData_001.UPC.split(";"))
			.clickOnAddToList()
			.clickOnExistingList(key1)
			.clickOnConform()
			._GoOrderPage()
			.close()
			._GoToLoginPage()
			//Creating List In 2nd User
			.loginToApplication(loginData_02.UserName, loginData_02.Password)
			._GoToHomePage()
			.atHomePage()
			//.clickOnExpress()
			.verifyHomePage()
			._GoToListPage()
			//Creating List
			.clickOnListTab()
			.clickOnCreateNewList()
			.enterListNameInPopup(key2)
			.clickOnCreateList()
			.clickOnListTab()
			._GoToHomePage()
			.verifyListpage()
			._GoToListPage()
			.clickOnMyListLink()
			.getListNumberByListName(key2)
			._GoToHomePage()
			//Adding Items to List
			.enterAnyItemInSearchBox(orderData_001.ItemName)
			.clickOnSearchButton()
			._GoToListPage()
			.checkOnItem(orderData_001.UPC.split(";"))
			.clickOnAddToList()
			.clickOnExistingList(key2)
			.clickOnConform()
			._GoOrderPage()
			.close()
			._atLoginPage()
			
			//Validating User1 List In MyList & Shared List
			
			.loginToApplication(loginData_01.UserName, loginData_01.Password)
			._GoToHomePage()
			.atHomePage()
			//.clickOnExpress()
			.verifyHomePage()
			._GoToListPage()
			.clickOnListTab()
			.clickOnMyListLink()
			.validateListNameInMyList(key1)
			.clickOnShareListLink()
			.validateListNameInSharedList(key2)
			._GoOrderPage() 
			.close()
			
			//Validating user2 List In MyList & Shared List
			
			._atLoginPage()
			.loginToApplication(loginData_02.UserName, loginData_02.Password)
	        ._GoToHomePage()
			.atHomePage()
			//.clickOnExpress()
			.atExpressHomePage()
			._GoToListPage()
			.clickOnListTab()
			.clickOnMyListLink()
			.validateListNameInMyList(key2)
			.clickOnShareListLink()
			.validateListNameInSharedList(key1)
			._GoOrderPage() 
			.close()
			
			
			
			
			//Verifying Edit List Option
			._atLoginPage()
			.loginToApplication(loginData_01.UserName, loginData_01.Password)
			._GoToHomePage()
			.atHomePage()
			//.clickOnExpress()
			.atExpressHomePage()
			._GoToListPage()
			.clickOnListTab()
			.clickOnSyscoRecommendedLink(orderData_003.ListName)
			.getListNumberForSyscoList(orderData_003.ListName,key3)
			.clickOnAnyListNumber(key3)
			.verifyEditListInSyscoList()
			.clickOnShareListLink()
			.clickOnAnyListNumberwithId(key2)
			.verifyEditListInSharedList()
			.clickOnMyListLink()
			.clickOnAnyListNumberwithId(key1)
			.verifyEditListInMyList()
			;
	}
   @Test(groups={"List"}, description = "List_002_01 :Validate List import functionality(cancel import).")
	@Features("List")
	@Stories("List_002_01 :Validate List import functionality(cancel import).")
	public void ImportList() {	
		
		LoginData loginData =LoginData.fetch("$NormalUser12");
		Start.asTester
			.goToLoginpage()
			.loginToApplication(loginData.UserName, loginData.Password)
			._GoToHomePage()
			.atHomePage()
			//.clickOnExpress()
			.verifyHomePage()
			.atExpressHomePage()
			._GoToListPage()
			.clickOnListTab()
			._GoToHomePage()
			.verifyListpage()
			._GoToListPage()
			.clickOnImportList()
			.clickOnCancelImportList();
			
	}
	@Test(groups={"List"}, description = "List_006 :Validate Group Items by functionality under Sysco Recommended Lists'")
	@Features("List")
	@Stories("List_006 : Validate Group Items by functionality under Sysco Recommended Lists'")
	public void OrderSyscoList() {	
		String key="List_006";
		LoginData loginData =LoginData.fetch("$NormalUser11");
		OrderData orderData =OrderData.fetch("$OrderData49");
		String groupByItem=orderData.GroupBY;
		String[] dropDownvalues=groupByItem.split(";"); 
		Start.asTester
			.goToLoginpage()
			.loginToApplication(loginData.UserName, loginData.Password)
			._GoToHomePage()
			.atHomePage()
			//.clickOnExpress()
			.atExpressHomePage()
			._GoToListPage()
			.clickOnListTab()
			._GoToHomePage()
			.verifyListpage()
			._GoToListPage()
			.clickOnSyscoRecommendedLink(orderData.ListName)
			.getListNumberForSyscoList(orderData.ListName,key)
			.clickOnAnyListNumber(key)
			.getGroupItemsDropDown(dropDownvalues)
			.selectFromGroupBy("groupby")
			.validatGroupByDontGroup()
			.selectFromGroupBy("sysco")
			.validatGroupBySysoCategories()
		    .selectFromGroupBy("my")
		    .validatGroupByMyCategories();
		
	}
	@Test(groups={"List"}, description = "List_010 :Lists with multiple items exist in Shared Lists . Order qty = , < , > list qty")
	@Features("List")
	@Stories("List_010 :Lists with multiple items exist in Shared Lists . Order qty = , < , > list qty")
	public void CreateOrderFromSharedList() {	
		String key1="List_010";
		LoginData loginData =LoginData.fetch("$NormalUser9");
		
		OrderData orderData =OrderData.fetch("$OrderData50");
		//OrderData orderData1 =OrderData.fetch("$OrderData53");
		//OrderData orderData2 =OrderData.fetch("$OrderData54");
		
		LoginData loginData_user2 =LoginData.fetch("$NormalUser10");
		String upcs=orderData.UPC;
		String[] upcNumber=upcs.split(";");
		String quantity=orderData.CaseQuantity;
		String[] listQuantity=quantity.split(";");
		String key2=loginData_user2.UserName;
		
		
		Start.asTester
			.goToLoginpage()
			.loginToApplication(loginData.UserName, loginData.Password)
			._GoToHomePage()
			.atHomePage()
			//.clickOnExpress()
			.atExpressHomePage()
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
			.enterAnyItemInSearchBox(orderData.ItemName)
			.clickOnSearchButton()
			._GoToListPage()
			.checkOnItem(orderData.UPC.split(";"))
			.clickOnAddToList()
			.clickOnExistingList(key1)
			.clickOnConform()
			.clickOnListTab()
			.clickOnMyListLink()
			.clickOnAnyListNumberwithId(key1)
			.clickOnEditList()
			//Entering List Quantity
			.enterListQuantity(upcNumber,listQuantity)
			//.clickOnSaveList()
			.clickOnSaveList1()
			._GoOrderPage()
			.close()
			._atLoginPage()
			//Logging New User For Shared List
			.loginToApplication(loginData_user2.UserName, loginData_user2.Password)
			._GoToHomePage()
			.atHomePage()
			//.clickOnExpress()
			.atExpressHomePage()
			._GoToListPage()
			.clickOnListTab()
			.clickOnShareListLink()
			.clickOnAnyListNumberwithId(key1)
			//Entering Order Quantity Equal To List Quantity
			.enterOrderQuantity(0,upcNumber,listQuantity)
			._GoOrderPage()
			.clickForPopup()
			.enterOrderName(orderData.OrderName)
			.clickOnCreatNewOrder()
			.clickOnViewOrder()
			//Submitting Order
			.clickSubmitOrder()
			.atOrderReminderPagePopUp()
			.clickOrderReminderSubmitNormal()
			.verifyAndConfirmOrder();
			//.clickOnAcknowledgementButton();
			
	}
			
		
	@Test(groups={"List"}, description = "List_012 :Lists with multiple items exist in My Lists .Order qty = , < , > list qty")
	@Features("List")
	@Stories("List_012 : Lists with multiple items exist in My Lists .Order qty = , < , > list qty")
	public void CreateOrderFromMyList() {	
		
		LoginData loginData =LoginData.fetch("$OMUser45");
		OrderData orderData =OrderData.fetch("$OrderData51");
		OrderData orderData1 =OrderData.fetch("$OrderData52");
		OrderData orderData2 =OrderData.fetch("$OrderData53");
		
		String upcs=orderData.UPC;
		String[] upcNumber=upcs.split(";");
		String quantity=orderData.CaseQuantity;
		String[] listQuantity=quantity.split(";");
		String key1="List_010";
		String key2=loginData.UserName;
		Start.asTester
			.goToLoginpage()
			.loginToApplication(loginData.UserName, loginData.Password)
			._GoToHomePage()
			.atHomePage()
			//.clickOnExpress()
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
			.enterAnyItemInSearchBox(orderData.ItemName)
			.clickOnSearchButton()
			._GoToListPage()
			.checkOnItem(orderData.UPC.split(";"))
			.clickOnAddToList()
			.clickOnExistingList(key1)
			.clickOnConform()
			.clickOnListTab()
			.clickOnMyListLink()
			.clickOnAnyListNumber(key1)
			.clickOnEditList()
			//Entering List Quantity
			.enterListQuantity(upcNumber,listQuantity)
			//.clickOnSaveList()
			.clickOnSaveList1()
			//Entering Order Quantity Equal To List Quantity
			.enterOrderQuantity(0,upcNumber,listQuantity)
			._GoOrderPage()
			.clickForPopup()
			.enterOrderName(orderData.OrderName)
			.clickOnCreatNewOrder()
			.clickOnViewOrder()
			//Submitting Order
			.clickSubmitOrder()
			.clickOrderReminderSubmitNormal()
			.clickOnAcknowledgementButton();
			
	}
	@Test(groups={"List"}, description = "List_013 :Validation of add/remove items from list.")
	@Features("List")
	@Stories("List_013 : Validation of add/remove items from list.")
	public void AddDeleteItemInList() {	
		
		LoginData loginData =LoginData.fetch("$NormalUser8");
		OrderData orderData_01 = OrderData.fetch("$OrderData63");
		String key1="Lists_013";
		String key2=loginData.UserName;
		Start.asTester
			.goToLoginpage()
			.loginToApplication(loginData.UserName, loginData.Password)
			._GoToHomePage()
			.atHomePage()
			//.clickOnExpress()
			.atExpressHomePage()
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
			.enterAnyItemInSearchBox(orderData_01.ItemName)
			.clickOnSearchButton()
			.checkOnAllItem()
			._GoToListPage()
			.clickOnAddToList()
			.clickOnExistingList(key1)
			.clickOnConform()
			//Creating One More List To Add Items
			.clickOnListTab()
			.clickOnCreateNewList()
			.enterListNameInPopup(key2)
			.clickOnCreateList()
			.clickOnListTab()
			.clickOnMyListLink()
			.getListNumberByListName(key2)
			.clickOnAnyListNumber(key1)
			.checkItemsFromLists(orderData_01.UPC.split(";"))
		    .clickOnAddToList()
		    //Adding Items In Second Lists
		    .clickOnExistingList(key2)
		    .clickOnConform()
		    .clickOnListTab()
		    .clickOnMyListLink()
		    .clickOnAnyListNumber(key2)
		    ._GoToHomePage()
		    //Verifying Items In Second List
		    .validateSUPCInList(orderData_01.UPC.split(";"))
		    ._GoToListPage()
		    .clickOnEditList()
		    //Selecting & Deleting Items From List
		    .selectAllListInEditList()
		    .deleteAllSelectedList()
		    //.clickOnSaveList()
		    .clickOnSaveList1()
		    .clickOnMyListLink()
		    .clickOnAnyListNumber(key2)
		    //Validating Deleted Items
		    .validateDeletedList(orderData_01.UPC.split(";"))
		    ;
			
	}
	@Test(groups={"List"}, description = "Lists_014 :Validate list tools under Sysco Recommended Lists' ")
	@Features("List")
	@Stories("Lists_014 : Validate list tools under Sysco Recommended Lists' ")
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
			//.clickOnExpress()
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
	@Test(groups={"List"}, description = "Lists_015 :Validate list tools under Shared Lists. ")
	@Features("List")
	@Stories("Lists_015 : Validate list tools under Shared Lists. ")
	public void VerfiyListDrpDownMenuInSharedList() {	
		
		LoginData loginData_001 =LoginData.fetch("$NormalUser31");	
		LoginData loginData_002 =LoginData.fetch("$NormalUser32");	
		OrderData orderData =OrderData.fetch("$OrderData67");
        System.out.println("login_data and order_data are ready");
        String key1=loginData_001.UserName;
		Start.asTester
			.goToLoginpage()
			.loginToApplication(loginData_001.UserName, loginData_001.Password)
			._GoToHomePage()
			.atHomePage()
			//.clickOnExpress()
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
			//.clickOnExpress()
			.atExpressHomePage()
			._GoToListPage()
			.clickOnListTab()
			.clickOnShareListLink()
			.clickOnAnyListNumber(key1)
			.checkDropDowninList(orderData.GroupBY.split(";"));
			
			
	}
	@Test(groups={"List","SauceLabSmoke"}, description = "Lists_017 :Validate list tools under My Lists")
	@Features("List")
	@Stories("Lists_017 : Validate list tools under My Lists")
	public void VerfiyListDrpDownMenuInMyList() {	
		LoginData loginData =LoginData.fetch("$NormalUser4");	
		OrderData orderData =OrderData.fetch("$OrderData68");
		String key=loginData.UserName;
		Start.asTester
			.goToLoginpage()
			.loginToApplication(loginData.UserName, loginData.Password)
			._GoToHomePage()
			.atHomePage()
			//.clickOnExpress()
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
			.clickOnAnyListNumberwithId(key)
			.clickOnEditList()
			//Entering List Quantity
			.enterListQuantity(orderData.UPC.split(";"),orderData.CaseQuantity.split(";"))
			//.clickOnSaveList()
			.clickOnSaveList1()
			//Validate Drop down
			.checkDropDowninList(orderData.GroupBY.split(";"))
			//Selecting List Tools And Validate it
			.selectUseListQuantityFromDropDown()
			.validateUseListQunatity(orderData.UPC.split(";"))
			.selectPrintListFromDropDown()
			.selectCopyListFromDropDown()
			.selectExportListFromDropDown()
			.clickCancelOnExport();
			
	}
	@Test(groups={"List"}, description = "Lists_018 :Verification of creation of list with more than 500 items")
	@Features("List")
	@Stories("Lists_018 : Verification of creation of list with more than 500 items")
	public void CreateListWithFiveHundredItems() {	
		
		LoginData loginData =LoginData.fetch("$NormalUser3");	
		OrderData orderData =OrderData.fetch("$OrderData69");
		String key=loginData.UserName;
		HomePage homePage=Start.asTester
			.goToLoginpage()
			.loginToApplication(loginData.UserName, loginData.Password)
			._GoToHomePage()
			.atHomePage()
			//.clickOnExpress()
			.atExpressHomePage()
			._GoToListPage()
			.clickOnListTab()
			//Creating New List
			.clickOnCreateNewList()
			.enterListNameInPopup(key)
			.clickOnCreateList()
			.clickOnListTab()
			.clickOnMyListLink()
			.getListNumberByListName(key)
			._GoToHomePage();
		//Adding 500 items To list
		   for(int i=0;i<orderData.ItemName.split(";").length;i++){
			homePage.enterAnyItemInSearchBox(orderData.ItemName.split(";")[i])
			.clickOnSearchButton()
			.checkOnAllItem()
			._GoToListPage()
			.clickOnAddToList()
			.clickOnExistingList(key)
			.clickOnConform()
			.clickOnMultiAddValidation();
		   }
		   homePage._GoToListPage()
		   .clickOnListTab()
		   .clickOnMyListLink()
		   .clickOnAnyListNumberwithId(key)
		   //Validating 500 items in List
		   .validateNumberOfItemsInList()
		   //Validating Items Present In List
		   ._GoToHomePage()
		   .enterUPCInSearchBox(orderData.UPC)
		   .validateSUPCInList(orderData.UPC.split(";"));
	}
}
