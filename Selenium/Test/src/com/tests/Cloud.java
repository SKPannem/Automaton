/*package com.tests;



import java.awt.AWTException;

import com.iwaf.framework.Initiator;

import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

import com.components.entities.Start;
import com.components.testdata.LoginData;
import com.components.testdata.OrderData;
import com.iwaf.framework.Initiator;

public class Cloud extends Initiator {
	
	@Test(groups={"CloudPricing"}, description = "Verify CP")
	@Features("CloudPricing")
	@Stories("Verify CP")
	public void CloudForCaseItem() throws AWTException {
		LoginData loginData = LoginData.fetch("$clouduser1");
		// create order data
		OrderData orderData = OrderData.fetch("$OrderData146");
		Start.asTester
				.goToLoginpage()
				.loginToApplication(loginData.UserName, loginData.Password)
				._GoToHomePage()
				.atHomePage()
				.clickOnExpress()
				.atExpressHomePage()
				.entercustomerMA( loginData.Customer)
				.selectCustomerMA()
				.atExpressHomePage()
				.enterAnyItemInSearchBox(orderData.UPC)
				.clickOnSearchButton()
				.SMXPrice(orderData.UPC)
				.logincloud("arah4883", "Fossil123")
				.selectopco()
				.getcloudprice(orderData.UPC, loginData.Customer)
				.compareSMXandCP();
	}
	@Test(groups={"CloudPricing"}, description = "Verify CP")
	@Features("CloudPricing")
	@Stories("Verify CP")
	public void CloudForSplitItem() throws AWTException {
		LoginData loginData = LoginData.fetch("$clouduser1");
		// create order data
		OrderData orderData = OrderData.fetch("$OrderData147");
		Start.asTester
				.goToLoginpage()
				.loginToApplication(loginData.UserName, loginData.Password)
				._GoToHomePage()
				.atHomePage()
				.clickOnExpress()
				.atExpressHomePage()
				.entercustomerMA( loginData.Customer)
				.selectCustomerMA()
				.atExpressHomePage()
				.enterAnyItemInSearchBox(orderData.UPC)
				.clickOnSearchButton()
				.SMXPricesplititem(orderData.UPC)
				.logincloud("arah4883", "Fossil123")
				.selectopco()
				.getcloudpricesplit(orderData.UPC, loginData.Customer)
				.compareSMXandCP();
	}
	@Test(groups={"AfterR14"}, description = "Change password for new users")
	@Features("AddnScenR14")
	@Stories("change pass")
	public void changepassword() {
		//LoginData loginData =LoginData.fetch("$ADMIN");	
		LoginData loginData1 =LoginData.fetch("$clouduser1");	
		LoginData loginData2 =LoginData.fetch("$clouduser2");
		LoginData loginData3 =LoginData.fetch("$clouduser3");
		LoginData loginData4 =LoginData.fetch("$clouduser4");
		//LoginData loginData5 =LoginData.fetch("$mauser005");
		//OrderData orderdata1=OrderData.fetch("$HPriceSCSR2");
		
		Start.asTester
		   .goToLoginpage()
			//.loginToApplication(loginData.UserName, loginData.Password)
			._GoToHomePage()
			.atHomePage()
			._GoItemDeletePage()
			.firstloginNewUSer( loginData1.UserName)
				.change_password("Sysco123")
			    .selectSecurityQuestions()
				.selectSecurityQuestionsAnswers("sysco123")
				. click_submit()
				._GoToHomePage()
				.atHomePage()
				.clickOnExpress()
				.close()
				._GoItemDeletePage()
			.firstloginNewUSer( loginData2.UserName)
				.change_password("Sysco123")
			    .selectSecurityQuestions()
				.selectSecurityQuestionsAnswers("sysco123")
				. click_submit()
				._GoToHomePage()
				.atHomePage()
				.clickOnExpress()
				.close()
				._GoItemDeletePage()
				.firstloginNewUSer( loginData3.UserName)
				.change_password("Sysco123")
			    .selectSecurityQuestions()
				.selectSecurityQuestionsAnswers("sysco123")
				. click_submit()
				._GoToHomePage()
				.atHomePage()
				.clickOnExpress()
				.close()
				._GoItemDeletePage()
			.firstloginNewUSer( loginData4.UserName)
				.change_password("Sysco123")
			    .selectSecurityQuestions()
				.selectSecurityQuestionsAnswers("sysco123")
				. click_submit()
				._GoToHomePage()
				.atHomePage()
				.clickOnExpress()
				.close();
	}
}
*/