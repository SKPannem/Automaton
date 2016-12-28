package com.tests;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.testng.annotations.AfterSuite;

import com.iwaf.framework.TestProperties;

public class RealTimeReportBackUp {
	@AfterSuite(alwaysRun=true)
	public void copyToTempFldr() {
		try{
			if(TestProperties.RETRY_COUNT!=0){
				FileUtils.copyDirectory(new File(System.getProperty("user.dir") + "/Real_Time_Reports"),new File(System.getProperty("user.dir") + "/realtimereportbkup"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
		
}
