package com.tests;

import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

import com.components.entities.Start;
import com.components.testdata.LoginData;
import com.components.testdata.OrderData;
import com.iwaf.framework.Initiator;

public class Reports extends Initiator{
	@Test(groups={"Reports"}, description = "Reports_TS_001: Verification of Reports modal for MA/MB users")
	@Features("Reports")
	@Stories("Reports_TS_001 :Verification of Reports modal for MA/MB users")
	public void VerifyReport() {	
		
		LoginData loginData_MBUser =LoginData.fetch("$ReportUser2");
		LoginData loginData_MAUser =LoginData.fetch("$ReportUser1");	
		Start.asTester
		.goToLoginpage()
		.loginToApplication(loginData_MAUser.UserName, loginData_MAUser.Password)
		._GoToHomePage()
		.atHomePage()
		//.clickOnExpress()
		.atExpressHomePage()
		._GoToHomePage()
		.clickOnReportTab()
		.validateReportPopup()
		.selectCustomerFromDropDown(loginData_MAUser.Customer)
		.validateReportSummary()
		.closeReportSummary()
		._GoOrderPage()
		.close()
		._atLoginPage()
		.loginToApplication(loginData_MBUser.UserName, loginData_MBUser.Password)
		._GoToHomePage()
		.atHomePage()
		//.clickOnExpress()
		.atExpressHomePage()
		.atExpressOrderingPage()
		._GoToHomePage()
		.clickOnReportTab()
		.validateReportPopup()
		.selectCustomerFromDropDown(loginData_MBUser.Customer)
		.validateReportSummary()
		.closeReportSummary()
		._GoOrderPage()
		.close();
	}
	@Test(groups={"Reports"}, description = "Reports_TS_002: Verification of filtering of reports")
	@Features("Reports")
	@Stories("Reports_TS_002 :Verification of filtering of reports")
	public void searchItemAndCreatOrder() {	
		
		LoginData loginData =LoginData.fetch("$ReportUser3");	
		Start.asTester
		.goToLoginpage()
		.loginToApplication(loginData.UserName, loginData.Password)
		._GoToHomePage()
		.atHomePage()
		//.clickOnExpress()
		.atExpressHomePage()
		._GoToHomePage()
		.clickOnReportTab()
		.validateReportPopup()
		.validateReportSummary()
		.selectOrderSubmittedOption()
		.selectDate(1)
		.clickOnApplyButton()
		.validateReportSummary()
		.selectDeliveryDateOption()
		.clickOnApplyButton()
		.validateReportSummary();
	}
	@Test(groups={"Reports"}, description = "TS_SME_Order Summary Report_009: Verify whether reports are getting generated when the user select Delivery dates")
	@Features("Reports")
	@Stories("TS_SME_Order Summary Report_009 :Verify whether reports are getting generated when the user select Delivery date")
	public void Order_Summary_Report_009() {		
	
		LoginData loginData = LoginData.fetch("$R14mauser1");
		// create order data
		//OrderData orderData = OrderData.fetch("$OrderData126");
		Start.asTester
				.goToLoginpage()
				.loginToApplication(loginData.UserName, loginData.Password)
				._GoToHomePage()
				.atHomePage()
				//.clickOnExpress()
				.atExpressHomePage()
				.entercustomerMA(loginData.Customer)
				.selectCustomerMA()
				.atExpressHomePage()
				.atExpressOrderingPage()
				._GoToHomePage()
				.ordersummaryMAuser()
				.validateReportPopup()
				. validateReportMAuser() 
				//.selectCustomerFromDropDown(loginData_MAUser.Customer)
				//.verifyCustomerInOrderSummaryReport(loginData_MAUser.Customer)
				.changePopupDelDate()
				.clickApply()
				.validateReportSummaryMauser();
	}
	@Test(groups={"Reports"}, description = "TS_SME_Order Summary Report_010: Verify whether default dates are getting displayed on clicking RESET button")
	@Features("Reports")
	@Stories("TS_SME_Order Summary Report_010 :Verify whether default dates are getting displayed on clicking RESET button")
	public void Order_Summary_Report_010() {
		LoginData loginData = LoginData.fetch("$ReportMAUser2");
		// create order data
		//OrderData orderData = OrderData.fetch("$OrderData126");
		Start.asTester
				.goToLoginpage()
				.loginToApplication(loginData.UserName, loginData.Password)
				._GoToHomePage()
				.atHomePage()
				//.clickOnExpress()
				.atExpressHomePage()
				.entercustomerMA( loginData.Customer)
				.selectCustomerMA()
				.atExpressHomePage()
				.atExpressOrderingPage()
				._GoToHomePage()
				.ordersummaryMAuser()
				.validateReportPopup()
				.validateReportMAuser() 
				.changePopupSubDate()
				.clickApply()
				.validateReportSummaryMauser()
				.clickReset()
				.validateDefaultDates();
		
	}
	@Test(groups={"Reports"}, description = "TS_SME_Order Summary Report_011: Verify whether the user is able to select date range within past 7 days as submitted dates to view the orders submitted on those day")
	@Features("Reports")
	@Stories("TS_SME_Order Summary Report_011 :Verify whether the user is able to select date range within past 7 days as submitted dates to view the orders submitted on those day")
	public void Order_Summary_Report_011() {	
		LoginData loginData = LoginData.fetch("$ReportMAUser3");
		// create order data
		//OrderData orderData = OrderData.fetch("$OrderData126");
		Start.asTester
				.goToLoginpage()
				.loginToApplication(loginData.UserName, loginData.Password)
				._GoToHomePage()
				.atHomePage()
				//.clickOnExpress()
				.atExpressHomePage()
				.entercustomerMA( loginData.Customer)
				.selectCustomerMA()
				.atExpressHomePage()
				.atExpressOrderingPage()
				._GoToHomePage()
				.ordersummaryMAuser()
				.validateReportPopup()
				. validateReportMAuser() 
				.changePopupSubDate()
				.clickApply()
				.validateReportSummaryMauser();
	}
	@Test(groups={"Reports"}, description = "TS_SME_Order Summary Report_012: Verify whether the user is able to select data range within next 7 days from today's date as delivery dates to view the orders delivered on those days")
	@Features("Reports")
	@Stories("TS_SME_Order Summary Report_012 :Verify whether the user is able to select data range within next 7 days from today's date as delivery dates to view the orders delivered on those days")
	public void Order_Summary_Report_012() {	

		LoginData loginData_MAUser =LoginData.fetch("$ReportMAUser4");	
		OrderData orderData_16 =OrderData.fetch("$ReportOrder1");
	    System.out.println("login_data and order_data are ready");
	     String key="Reports_TS_012";
		Start.asTester
		.goToLoginpage()
		.loginToApplication(loginData_MAUser.UserName, loginData_MAUser.Password)
		._GoToHomePage()
		.atHomePage()
		//.clickOnExpress()
		.atExpressHomePage()				
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
	    /*.clickOnShippingTab()
			.selectOffDay()
			._GoItemDeletePage()
			.reValidateAlert()
			._GoOrderPage()*/
	    .clickSubmitOrder()
	    .clickOrderReminderSubmitNormal()
	    .verifyAndConfirmOrder()
	    ._GoToHomePage()
		.clickOnSubmittedOrdersLink()
		.clickOnAnyOrder(key)
	    ._GoItemDeletePage()
	    .cancelOrderLink()
	    .cancelOrderPopup()
		._GoToHomePage()
		.ordersummaryMAuser()
		.validateReportPopup()
		. validateReportMAuser() 
	   // .clickOnReportTab()
	   // .validateReportPopup()
	   // .selectCustomerFromDropDown(loginData_MAUser.Customer)
	  //  .verifyCustomerInOrderSummaryReport(loginData_MAUser.Customer)
	    .changePopupDelDate()
	    .clickApply()
	    //.validateReportSummary()
	    .validateReportSummaryMauser()
	    .validateOrderStatus();	   	
		
	}
		
}
