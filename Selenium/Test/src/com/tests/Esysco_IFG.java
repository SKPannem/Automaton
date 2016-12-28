package com.tests;


    import java.awt.AWTException;

import org.testng.annotations.Test;

	import ru.yandex.qatools.allure.annotations.Features;
	import ru.yandex.qatools.allure.annotations.Stories;

	import com.components.entities.Start;
	import com.components.testdata.LoginData;
	import com.components.testdata.OrderData;
	import com.iwaf.framework.Initiator;
	public class Esysco_IFG extends Initiator{
		
		@Test(groups={"IFG_Specific"}, description = "BR001_01 : Create IFG User")
		@Features("IFG_Specific")
		@Stories("BR001_01 : Create IFG Normal User")
		public void CreateIFGNormalUser()  {	
			
			LoginData loginData =LoginData.fetch("$ADMIN");	
			LoginData loginDataOpco =LoginData.fetch("$IFGOPCO");
			
			
			Start.asTester
			   .goToLoginpage()
				.loginToApplication(loginData.UserName, loginData.Password)
				._GoToHomePage()
				.atHomePage()
				._GoIFGPage()
				.ClikonEsysco()
				.Enter_Opco(loginDataOpco.OpCo)
				.clickOnActiveCustomer()
				.selectIFGCustomer()
				.createNewIFGUser("Noramal")
				.clickLogOut()
				.firstloginNewISRUser()
				.change_password("sysco123")
			    .selectSecurityQuestions()
				.selectSecurityQuestionsAnswers("sysco123")
				. click_submit()
				;
		}
		@Test(groups={"IFG_Specific"}, description = "BR001_02 : Create IFG MultiBuyer User")
		@Features("IFG_Specific")
		@Stories("BR001_02 : Create IFG Multibuyer User")
        public void CreateIFGMultiBuyerUser()  {	
			
			LoginData loginData =LoginData.fetch("$ADMIN");	
			LoginData loginDataOpco =LoginData.fetch("$IFGOPCO");
			
			
			Start.asTester
			   .goToLoginpage()
				.loginToApplication(loginData.UserName, loginData.Password)
				._GoToHomePage()
				.atHomePage()
				._GoIFGPage()
				.ClikonEsysco()
				.Enter_Opco(loginDataOpco.OpCo)
				.clickOnActiveCustomer()
				.selectIFGCustomer()
				.createNewIFGUser("MULTIBUYER")
				.clickLogOut()
				.firstloginNewISRUser()
				.change_password("sysco123")
			    .selectSecurityQuestions()
				.selectSecurityQuestionsAnswers("sysco123")
				. click_submit()
				;
		}
		
		
		@Test(groups={"IFG_Specific"}, description =  "BR001_04 : Validation of Sysco Market Express home page for IFG user")
		@Features("IFG_Specific")
		@Stories("BR001_04 : Validation of Sysco Market Express home page for IFG user")
		public void BR001_04(){	
			
			LoginData loginData =LoginData.fetch("$IFGUSER04");	
			Start.asTester
			.goToLoginpage()
			.loginToApplication(loginData.UserName, loginData.Password)
			._GoToHomePage()
			.atHomePage()
			.clickOnExpress()
			.atExpressHomePage()
			._GoIFGPage()
			.homePageLinkValidation();
		}
		
		@Test(groups={"IFG_Specific"}, description =  "BR003_02 : Validate whether a different list of container types are displayed when different 'Shipment From' option(Ocean/Air/Ground) is chosen.")
		@Features("IFG_Specific")
		@Stories("BR003_02 :Validate whether a different list of container types are displayed when different 'Shipment From' option(Ocean/Air/Ground) is chosen")
		public void BR003_02 (){	
			
			LoginData loginData =LoginData.fetch("$IFGUSER09");	
			
			
			Start.asTester
			.goToLoginpage()
			.loginToApplication(loginData.UserName, loginData.Password)
			._GoToHomePage()
			.atHomePage()
			.clickOnExpress()
			.atExpressHomePage()
			._GoIFGPage()
			.CreateNewOrder()
			.selectShipment("Ocean FCL","11")
			.validateContainersizeOrType_OCEANFCL ()
			.selectShipment("Ocean LCL","10")
			.validateContainersizeOrType_OCEANLCL ()
			.selectShipment("AIR","40")
			.validateContainersizeOrType_OCEANLCL ()
			.selectShipment("TRUCK FTL","30")
			.selectShipment("TRUCK LTL","31")
			.validateContainersizeOrType_OCEANLCL ()
			;
		
		}
		
		@Test(groups={"IFG_Specific"}, description =  "BR005_01 : Validate whether customer is prompted to accept general disclaimer if 'Multi-Temp w/Bulkhead' option selected as Container Type.")
		@Features("IFG_Specific")
		@Stories("BR005_01 :Validate whether customer is prompted to accept general disclaimer if 'Multi-Temp w/Bulkhead' option selected as Container Type.")
		public void BR005_01 (){	
			
			LoginData loginData =LoginData.fetch("$IFGUSER10");	
			
			
			Start.asTester
			.goToLoginpage()
			.loginToApplication(loginData.UserName, loginData.Password)
			._GoToHomePage()
			.atHomePage()
			.clickOnExpress()
			.atExpressHomePage()
			._GoIFGPage()
			.CreateNewOrder()
			.selectShipment("Ocean LCL","10")
			.validateContainersizeOrType_OCEANLCL ()
			.selectContainersizeOrType("NA","MT")
			.createOrder()
			.validateMsgSelected_MULTI_TEMP2()
			.clickonActiveOrder()
			/*._GoOrderPage()
			.clickOnViewOrder()*/
			._GoIFGPage()
			.deleteorder1();
		
		}
		
		
		@Test(groups={"IFG_Specific"}, description =  "BR005_02 : Validate whether customer can change the container type from the disclaimer window")
		@Features("IFG_Specific")
		@Stories("BR005_02 :Validate whether customer can change the container type from the disclaimer window")
		public void BR005_02 (){	
			
			LoginData loginData =LoginData.fetch("$IFGUSER11");	
			
			
			Start.asTester
			.goToLoginpage()
			.loginToApplication(loginData.UserName, loginData.Password)
			._GoToHomePage()
			.atHomePage()
			.clickOnExpress()
			.atExpressHomePage()
			._GoIFGPage()
			.CreateNewOrder()
			.selectShipment("Ocean LCL","10")
			.selectContainersizeOrType("NA","MT")
			.createOrder()
			.validateMsgSelected_MULTI_TEMP_Change()
			.selectContainersizeOrType("NA","DR")
			.createOrder()
			.clickonActiveOrder()
			;
		
		}
		
		@Test(groups={"IFG_Specific"}, description =  "BR010_01 : Validate whether containers have limitations decision based on dry/cooler/freezer. ie. Customer should not be able to put freezer /cooler product on dry container")
		@Features("IFG_Specific")
		@Stories("BR010_01 :Validate whether containers have limitations decision based on dry/cooler/freezer. ie. Customer should not be able to put freezer /cooler product on dry container")
		public void BR010_01_n() throws AWTException {	
			
			LoginData loginData =LoginData.fetch("$IFGUSER12");	
			OrderData orderData = OrderData.fetch("$IFGdryitem1");
			OrderData orderData1 = OrderData.fetch("$IFGcooleritem1");
			OrderData orderData2 = OrderData.fetch("$IFGfreezeritem1");
			Start.asTester
			.goToLoginpage()
			.loginToApplication(loginData.UserName, loginData.Password)
			._GoToHomePage()
			.atHomePage()
			.clickOnExpress()
			.atExpressHomePage()
			._GoIFGPage()
			.CreateNewOrder()
			.selectShipment("Ocean LCL","10")
			.selectContainersizeOrType("NA","DR")
			.createOrder()
			.iteminsearchbox1(orderData.UPC, orderData.CaseQuantity)
			.iteminsearchbox1(orderData1.UPC, orderData1.CaseQuantity)
			.alert_Product_Flag_Change2()
			.selectShipment("Ocean LCL","10")
			.selectContainersizeOrType("NA","FR")
			.createOrder()
			//.update_containerType()
			//.close_containerType()
			.iteminsearchbox1(orderData2.UPC, orderData2.CaseQuantity)
			.iteminsearchbox1(orderData1.UPC, orderData1.CaseQuantity)
			.iteminsearchbox1(orderData.UPC, orderData.CaseQuantity)
			.alert_Product_Flag_Change1()
			.changeContainerType("MT")
			.update_containerType()
			.validateMsgSelected_MULTI_TEMP()
			.close_containerType()
			//.iteminsearchbox1(orderData1.UPC, orderData1.CaseQuantity)
			//.iteminsearchbox1(orderData2.UPC, orderData2.CaseQuantity)
			.clickOnViewOrder()
			._GoOrderPage()
			.clickSubmitOrder()
			.clickOrderReminderSubmitNormal()
			.verifyAndConfirmOrder();
		
		}
		
		
		@Test(groups={"IFG_Specific"}, description =  "BR011_01 : VValidate whether user is getting an error message when selecting an item for an inaccurate container type")
		@Features("IFG_Specific")
		@Stories("BR011_01 :Validate whether user is getting an error message when selecting an item for an inaccurate container type")
		public void BR011_01(){	
			
			LoginData loginData =LoginData.fetch("$IFGUSER13");	
			Start.asTester
			.goToLoginpage()
			.loginToApplication(loginData.UserName, loginData.Password)
			._GoToHomePage()
			.atHomePage()
			.clickOnExpress()
			.atExpressHomePage()
			._GoIFGPage()
			.CreateNewOrder()
			.addItemToOrder("Product Catalog")
			.selectShipment("Ocean LCL","10")
			.selectContainersizeOrType("NA","DR")
			.createOrder()
			._GoItemDeletePage()
			.addCoolItem(loginData.OpCo)
			._GoIFGPage()
			.alert_Product_Flag_Accept_Change_Displayed();
		
		}
		
	
		@Test(groups={"IFG_Specific"}, description =  "BR011_02 : Validate whether user can add a new container when 'Add Container' option is selected in the error message displayed when inaccurate container type is selected.")
		@Features("IFG_Specific")
		@Stories("BR011_02 :Validate whether user can add a new container when 'Add Container' option is selected in the error message displayed when inaccurate container type is selected.")
		public void BR011_02() throws AWTException{	
			
			LoginData loginData =LoginData.fetch("$IFGUSER14");	
			OrderData orderData2 = OrderData.fetch("$IFGfreezeritem1");
			
			Start.asTester
			.goToLoginpage()
			.loginToApplication(loginData.UserName, loginData.Password)
			._GoToHomePage()
			.atHomePage()
			.clickOnExpress()
			.atExpressHomePage()
			._GoIFGPage()
			.CreateNewOrder()
			.selectShipment("Ocean LCL","10")
			.selectContainersizeOrType("NA","DR")
			.createOrder()
			.iteminsearchbox1(orderData2.UPC, orderData2.CaseQuantity)
			.alert_Product_Flag_Change2()
			.selectShipment("Ocean LCL","10")
			.selectContainersizeOrType("NA","FR")
			.createOrder()
			//._GoItemDeletePage()
			//.addCoolItem(loginData.OpCo)
			//._GoIFGPage()
			//.alert_Product_Flag()
			//.selectContainersizeOrType("NA","FR")
			.deleteorder();
		}
		
		@Test(groups={"IFG_Specific"}, description =  "BR011_03 : Validate whether user can change to a new container when 'Change Container' option is selected in the error message displayed when inaccurate container type is selected.")
		@Features("IFG_Specific")
		@Stories("BR011_03 :Validate whether user can change to a new container when 'Change Container' option is selected in the error message displayed when inaccurate container type is selected.")
		public void BR011_03() throws AWTException{	
			
			LoginData loginData =LoginData.fetch("$IFGUSER15");	
			OrderData orderData2 = OrderData.fetch("$IFGfreezeritem1");
			
			Start.asTester
			.goToLoginpage()
			.loginToApplication(loginData.UserName, loginData.Password)
			._GoToHomePage()
			.atHomePage()
			.clickOnExpress()
			.atExpressHomePage()
			._GoIFGPage()
			.CreateNewOrder()
			//.addItemToOrder("Product Catalog")
			.selectShipment("Ocean LCL","10")
			.selectContainersizeOrType("NA","DR")
			.createOrder()
			.iteminsearchbox1(orderData2.UPC, orderData2.CaseQuantity)
			//._GoItemDeletePage()
			//.addCoolItem(loginData.OpCo)
			._GoIFGPage()
			.alert_Product_Flag_Change1()
			.update_containerType()
			.close_containerType()
			._GoOrderPage()
			.clickOnViewOrder()
			._GoIFGPage()
			.deleteorder();
		}
		
		@Test(groups={"IFG_Specific"}, description =  "BR017_01 : Validate whether Order summary captures the container type, shipment information, weight and cube information and ETA Arrival details.")
		@Features("IFG_Specific")
		@Stories("BR017_01 :Validate whether Order summary captures the container type, shipment information, weight and cube information and ETA Arrival details.")
		public void BR017_01(){	
			
			LoginData loginData =LoginData.fetch("$IFGUSER16");
			Start.asTester
			.goToLoginpage()
			.loginToApplication(loginData.UserName, loginData.Password)
			._GoToHomePage()
			.atHomePage()
			.clickOnExpress()
			.atExpressHomePage()
			._GoIFGPage()
			.CreateNewOrder()
			//.addItemToOrder("Product Catalog")
			.selectShipment("Ocean LCL","10")
			.selectContainersizeOrType("NA","FR")
			.createOrder()
			._GoItemDeletePage()
			.addCoolItem(loginData.OpCo)
			.addCoolItemisValid()
			._GoIFGPage()
			._GoOrderPage()
			.clickOnViewOrder()
			._GoIFGPage()
			.ckeckSubmitButton("FROZEN","Ocean LCL");
		
		}
		
		@Test(groups={"IFG_Specific"}, description =  "BR021_01 : Validate whether weight and cube dimensions can be displayed in both metric system and standard system by hitting 'Metrics' button in order summary page.")
		@Features("IFG_Specific")
		@Stories("BR021_01 :Validate whether weight and cube dimensions can be displayed in both metric system and standard system by hitting 'Metrics' button in order summary page.")
		public void BR021_01(){	
			
			LoginData loginData =LoginData.fetch("$IFGUSER17");	
			
			
			Start.asTester
			.goToLoginpage()
			.loginToApplication(loginData.UserName, loginData.Password)
			._GoToHomePage()
			.atHomePage()
			.clickOnExpress()
			.atExpressHomePage()
			._GoIFGPage()
			.CreateNewOrder()
			.addItemToOrder("Product Catalog")
			.selectShipment("Ocean LCL","10")
			.selectContainersizeOrType("NA","FR")
			.createOrder()
			._GoItemDeletePage()
			.addCoolItem(loginData.OpCo)
			.addCoolItemisValid()
			._GoIFGPage()
			._GoOrderPage()
			.clickOnViewOrder()
			._GoIFGPage()
			.ckeckSubmitButton("FROZEN","Ocean LCL")
			.ckeckStandardUnits()
			
			;
		
		}
		
		
		@Test(groups={"IFG_Specific"}, description =  "BR019_01 : Validate whether Shelf life and Ti* Hi values are captured as two separate columns in the order summary page.")
		@Features("IFG_Specific")
		@Stories("BR019_01 :Validate whether Shelf life and Ti* Hi values are captured as two separate columns in the order summary page.")
		public void BR019_01(){	
			
			LoginData loginData =LoginData.fetch("$IFGUSER18");	
			
			
			Start.asTester
			.goToLoginpage()
			.loginToApplication(loginData.UserName, loginData.Password)
			._GoToHomePage()
			.atHomePage()
			.clickOnExpress()
			.atExpressHomePage()
			._GoIFGPage()
			.CreateNewOrder()
			.addItemToOrder("Product Catalog")
			.selectShipment("Ocean LCL","10")
			.selectContainersizeOrType("NA","FR")
			.createOrder()
			._GoItemDeletePage()
			.addCoolItem(loginData.OpCo)
			.addCoolItemisValid()
			._GoIFGPage()
			._GoOrderPage()
			.clickOnViewOrder()
			._GoIFGPage()
			.ckeckSubmitButton("FROZEN","Ocean LCL")
			.Checktihi_ShelLife()
			.clickOn_ColumnSettings()
			//Remove Ti/Hi
			.chkDiv_ColmnSettings()
			.Checktihi_ShelLife()
			
			//Add Ti/Hi
			.clickOn_ColumnSettings()
			.chkDiv_ColmnSettings()
			.Checktihi_ShelLife()
			;
		
		}
		
		@Test(groups={"IFG_Specific"}, description =  "BR030_04 : Validate whether delete functionality of shipments for Multibuyer")
		@Features("IFG_Specific")
		@Stories("BR030_04 :Validate whether delete functionality of shipments for Multibuyer")
		public void BR030_04(){	
			
			LoginData loginData =LoginData.fetch("$IFGMultiBuyer");	
			
			
			Start.asTester
			.goToLoginpage()
			.loginToApplication(loginData.UserName, loginData.Password)
			._GoToHomePage()
			.atHomePage()
			.clickOnExpress()
			.atExpressHomePage()
			._GoIFGPage()
			.shippmentTab()
			.clickOnshippmentTab()
			._GoItemDeletePage()
			.selectSubmittedOrder(loginData.OpCo,loginData.Customer)
			.selectDeliveredOrder(loginData.OpCo,loginData.Customer)
			;
		
		}
		
		@Test(groups={"IFG_Specific"}, description =  "BR030_05 : Validate whether ‘+’ symbol is used to unfold the remaining records and ‘–‘ to fold the records back to the first shipment record if the shipment has more than one container and order.")
		@Features("IFG_Specific")
		@Stories("BR030_05 :Validate whether ‘+’ symbol is used to unfold the remaining records and ‘–‘ to fold the records back to the first shipment record if the shipment has more than one container and order.")
		public void BR030_05(){	
			
			LoginData loginData =LoginData.fetch("$IFGMultiBuyer");	
			
			
			Start.asTester
			.goToLoginpage()
			.loginToApplication(loginData.UserName, loginData.Password)
			._GoToHomePage()
			.atHomePage()
			.clickOnExpress()
			.atExpressHomePage()
			._GoIFGPage()
			.shippmentTab()
			.clickOnshippmentTab()
			._GoItemDeletePage()
			.selectSubmittedOrder(loginData.OpCo,loginData.Customer)
			._GoIFGPage()
			.validatePlus_minus()
			;
		
		}
		

		@Test(groups={"IFG_Specific"}, description =  "BR032_01 : Validate whether total dollar spend is not getting displayed in the Active Order section")
		@Features("IFG_Specific")
		@Stories("BR032_01 :Validate whether total dollar spend is not getting displayed in the Active Order section")
		public void BR032_01() throws AWTException{	
			
			LoginData loginData =LoginData.fetch("$IFGUSER19");	
			OrderData orderData = OrderData.fetch("$IFGfreezeritem2");
			OrderData orderData1 = OrderData.fetch("$IFGfreezeritem3");
			Start.asTester
			.goToLoginpage()
			.loginToApplication(loginData.UserName, loginData.Password)
			._GoToHomePage()
			.atHomePage()
			.clickOnExpress()
			.atExpressHomePage()
			._GoIFGPage()
			.CreateNewOrder()
			//.addItemToOrder("Product Catalog")
			.selectShipment("Ocean FCL","11")
			.selectContainersizeOrType("20","FR")
			.createOrder()
			.iteminsearchbox1(orderData.UPC, orderData.CaseQuantity)
			/*._GoItemDeletePage()
			.addCoolItem(loginData.OpCo)
			.addCoolItemisValid()*/
			._GoOrderPage()
			.clickOnViewOrder()
			._GoIFGPage()
			.CheckActiveOrder_green()
			.iteminsearchbox1(orderData1.UPC, orderData1.CaseQuantity)
			._GoOrderPage()
			//.changeOrderQuantity(orderData1.UPC, orderData1.CaseQuantity)
			.clickOnViewOrder()
			//._GoItemDeletePage()
			//.increaseTheQuantity("790")
			._GoIFGPage()
			.CheckActiveOrder_red()
			.deleteorder();
			
			
		
		}

		 
	
		@Test(groups={"IFG_Specific"}, description =  "BR027_01 : Validate whether Lead time for ETA/Delivery date is 24 hours( one day) when Ground shipment is selected")
		@Features("IFG_Specific")
		@Stories("BR027_01 :Validate whether Lead time for ETA/Delivery date is 24 hours( one day) when Ground shipment is selected")
		public void BR027_01(){	
			
			LoginData loginDataIFG =LoginData.fetch("$IFGUSER20");	
			LoginData loginData =LoginData.fetch("$ADMIN");	
			LoginData loginDataOpco =LoginData.fetch("$IFGOPCO");
			/*Start.asTester
			   .goToLoginpage()
				.loginToApplication(loginData.UserName, loginData.Password)
				._GoToHomePage()
				.atHomePage()
				._GoIFGPage()
				.ClikonEsysco()
				.Enter_Opco(loginDataOpco.OpCo)
				.clickOnActiveCustomer()
				.selectIFGCustomer()
				.custSetUpDay("10")
				.clickLogOut();*/
				Start.asTester
				.goToLoginpage()
				.loginToApplication(loginDataIFG.UserName, loginDataIFG.Password)
			    ._GoToHomePage()
			    .atHomePage()
			    .clickOnExpress()
			    .atExpressHomePage()
			    ._GoIFGPage()
			   .updateDeliveryCalander(loginDataIFG.Customer)
			   .CreateNewOrder()
			  // .addItemToOrder("Product Catalog")
			   .selectShipment("TRUCK FTL","30")
			   ._GoItemDeletePage()
			   .validateIFGDeliveryDate()
			   ._GoIFGPage()
			   .selectShipment("AIR","40")
			    ._GoItemDeletePage()
			   .validateIFGDeliveryDate()
			   ._GoIFGPage()
			   .selectShipment("Ocean FCL","11")
			    ._GoItemDeletePage()
			   .validateIFGDeliveryDate()
			   .validateEnabledIFGDeliveryDate()
			   ._GoIFGPage()
			   .selectShipment("Ocean LCL","10")
			   .selectContainersizeOrType("NA","FR")
			   .createOrder()
			   ._GoItemDeletePage()
			   .addCoolItem(loginDataIFG.OpCo)
			   .addCoolItemisValid()
			   ._GoOrderPage()
				.clickOnViewOrder()
				._GoOrderPage()
		        .clickSubmitOrder()
		        .clickOrderReminderSubmitNormal()
		        .verifyAndConfirmOrder();
		
		}

		@Test(groups={"IFG_Specific"}, description =  "BR002_02 : Validate whether order can be created by selecting 'Ocean' as the Shipment from option")
		@Features("IFG_Specific")
		@Stories("BR002_02 :Validate whether order can be created by selecting 'Ocean FCL' as the Shipment from option")
		public void OrderCreation_ocean_FCL () throws AWTException{	
			
			LoginData loginData =LoginData.fetch("$IFGUSER05");	
			OrderData orderData = OrderData.fetch("$IFGdryitem1");
			//OrderData orderData1 = OrderData.fetch("$IFGcooleritem1");
			//OrderData orderData2 = OrderData.fetch("$IFGfreezeritem1");
			OrderData orderData3 = OrderData.fetch("$IFGOceanFCL");
			Start.asTester
			.goToLoginpage()
			.loginToApplication(loginData.UserName, loginData.Password)
			._GoToHomePage()
			.atHomePage()
			.clickOnExpress()
			.atExpressHomePage()
			._GoIFGPage()
			.CreateNewOrder()
			.enterOrderName(orderData3.OrderName)
			.selectShipment("Ocean FCL","11")
			.selectContainersizeOrType("40","DR")
			.createOrder()
			.clickonActiveOrder()
			.iteminsearchbox1(orderData.UPC, orderData.CaseQuantity)
			//.iteminsearchbox1(orderData1.UPC, orderData.CaseQuantity)
			//.iteminsearchbox1(orderData2.UPC, orderData.CaseQuantity)
			.clickOnViewOrder()
			._GoOrderPage()
			.clickSubmitOrder()
			._GoIFGPage()
			.containerundercapacity()
			._GoOrderPage()
			.clickOrderReminderSubmitNormal()
			.verifyAndConfirmOrder();
		
		}
		
		@Test(groups={"IFG_Specific"}, description =  "BR002_03 : Validate whether order can be created by selecting 'Ocean' as the Shipment from option")
		@Features("IFG_Specific")
		@Stories("BR002_03 :Validate whether order can be created by selecting 'AIR' as the Shipment from option")
		public void OrderCreation_AIR () throws AWTException{	
			
			LoginData loginData =LoginData.fetch("$IFGUSER06");	
			OrderData orderData = OrderData.fetch("$IFGdryitem1");
			//OrderData orderData1 = OrderData.fetch("$IFGcooleritem1");
			//OrderData orderData2 = OrderData.fetch("$IFGfreezeritem1");
			OrderData orderData3 = OrderData.fetch("$Air");
			
			Start.asTester
			.goToLoginpage()
			.loginToApplication(loginData.UserName, loginData.Password)
			._GoToHomePage()
			.atHomePage()
			.clickOnExpress()
			.atExpressHomePage()
			._GoIFGPage()
			.CreateNewOrder()
			.enterOrderName(orderData3.OrderName)
			.selectShipment("AIR","40")
			.selectContainersizeOrType("NA","DR")
			.createOrder()
			.clickonActiveOrder()
			.iteminsearchbox1(orderData.UPC, orderData.CaseQuantity)
			//.iteminsearchbox1(orderData1.UPC, orderData.CaseQuantity)
			//.iteminsearchbox1(orderData2.UPC, orderData.CaseQuantity)
			.clickOnViewOrder()
			._GoOrderPage()
			.clickSubmitOrder()
			.clickOrderReminderSubmitNormal()
			.verifyAndConfirmOrder();
		
		}
		
		@Test(groups={"IFG_Specific"}, description =  "BR002_04 : Validate whether order can be created by selecting 'Ocean' as the Shipment from option")
		@Features("IFG_Specific")
		@Stories("BR002_04 :Validate whether order can be created by selecting 'Truck LTL' as the Shipment from option")
		public void OrderCreation_TrucK_LTL () throws AWTException{	
			
			LoginData loginData =LoginData.fetch("$IFGUSER07");	
			OrderData orderData = OrderData.fetch("$IFGdryitem1");
			OrderData orderData1 = OrderData.fetch("$IFGcooleritem1");
			//OrderData orderData2 = OrderData.fetch("$IFGfreezeritem1");
			OrderData orderData3 = OrderData.fetch("$truckLTL");
			Start.asTester
			.goToLoginpage()
			.loginToApplication(loginData.UserName, loginData.Password)
			._GoToHomePage()
			.atHomePage()
			.clickOnExpress()
			.atExpressHomePage()
			._GoIFGPage()
			.CreateNewOrder()
			.enterOrderName(orderData3.OrderName)
			.selectShipment("TRUCK LTL","31")
			.selectContainersizeOrType("NA","FR")
			.createOrder()
			.clickonActiveOrder()
			//.iteminsearchbox1(orderData.UPC, orderData.CaseQuantity)
			.iteminsearchbox1(orderData1.UPC, orderData.CaseQuantity)
			//.iteminsearchbox1(orderData2.UPC, orderData.CaseQuantity)
			.clickOnViewOrder()
			._GoOrderPage()
			.clickSubmitOrder()
			.clickOrderReminderSubmitNormal()
			.verifyAndConfirmOrder();
		
		}
		
		@Test(groups={"IFG_Specific"}, description =  "BR003_01 : Validate whether order can be created by selecting 'Ocean' as the Shipment from option")
		@Features("IFG_Specific")
		@Stories("BR003_01 :Validate whether order can be created by selecting 'Ocean LCL' as the Shipment from option")
		public void OrderCreation_OceanLCL () throws AWTException{	
			
			LoginData loginData =LoginData.fetch("$IFGUSER08");	
			OrderData orderData = OrderData.fetch("$IFGdryitem1");
			OrderData orderData3 = OrderData.fetch("$IFGOceanLCL");

			Start.asTester
			.goToLoginpage()
			.loginToApplication(loginData.UserName, loginData.Password)
			._GoToHomePage()
			.atHomePage()
			.clickOnExpress()
			.atExpressHomePage()
			._GoIFGPage()
			.CreateNewOrder()
			.enterOrderName(orderData3.OrderName)
			.selectShipment("Ocean LCL","10")
			.selectContainersizeOrType("NA","DR")
			.createOrder()
			.clickonActiveOrder()
			.iteminsearchbox1(orderData.UPC, orderData.CaseQuantity)
			//.iteminsearchbox1(orderData1.UPC, orderData.CaseQuantity)
			//.iteminsearchbox1(orderData2.UPC, orderData.CaseQuantity)
			.clickOnViewOrder()
			._GoOrderPage()
			.clickSubmitOrder()
			.clickOrderReminderSubmitNormal()
			.verifyAndConfirmOrder();
		
		}
		@Test(groups={"IFG_Specific"}, description =  "Order_creation :Order_creation")
		@Features("IFG_Specific")
		@Stories("Order_creation:Order_creation")
		public void OrderCreation_TruckFTL() throws AWTException{	
			
			LoginData loginData =LoginData.fetch("$IFGUSER07");	
			OrderData orderData = OrderData.fetch("$IFGdryitem1");
			OrderData orderData1 = OrderData.fetch("$IFGcooleritem1");
			//OrderData orderData2 = OrderData.fetch("$IFGfreezeritem1");
			OrderData orderData3 = OrderData.fetch("$truckFTL");
			Start.asTester
			.goToLoginpage()
			.loginToApplication(loginData.UserName, loginData.Password)
			._GoToHomePage()
			.atHomePage()
			.clickOnExpress()
			.atExpressHomePage()
			._GoIFGPage()
			.CreateNewOrder()
			.enterOrderName(orderData3.OrderName)
			.selectShipment("TRUCK FTL","30")
			.selectContainersizeOrType("48 HC","FR")
			.createOrder()
			.clickonActiveOrder()
			//.iteminsearchbox1(orderData.UPC, orderData.CaseQuantity)
			.iteminsearchbox1(orderData1.UPC, orderData.CaseQuantity)
			//.iteminsearchbox1(orderData2.UPC, orderData.CaseQuantity)
			.clickOnViewOrder()
			._GoOrderPage()
			.clickSubmitOrder()
			._GoIFGPage()
			.containerundercapacity()
			._GoOrderPage()
			.clickOrderReminderSubmitNormal()
			.verifyAndConfirmOrder();
		}
	}


