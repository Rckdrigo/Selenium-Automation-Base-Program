package org.globant.reviewBoard;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.globant.reviewBoard.ReviewRequestPage;

public class TestUnitario {
	WebDriver driver;
	String[] teams = {"CharlieAlfa","CharlieBravo","CharlieCharlie","CharlieDelta","CharlieEcho","CharlieFoxtrot",
			"MikeAlfa","OscarAlfa","QuebecAlfa","RomeoAlfa","RomeoBravo","RomeoCharlie","RomeoDelta","RomeoEcho",
			"TangoAlfa","TangoBravo","XrayAlfa"};
	
	@BeforeMethod(alwaysRun= true)
	public void before() throws Exception{
		driver = new FirefoxDriver();
	}
	
	@Test
	public void goToReviewRequest() throws IOException{		
		
		for(int i = 0; i < teams.length; i++){
			driver.get("http://landev.dev.biz.globant.com/groups/"+teams[i]+"/");
			ReviewRequestPage rrp = new ReviewRequestPage(driver);
			rrp.generateTable(teams[i]);
			rrp.generateFile(teams[i]);
		}
		
	}
	
	@AfterMethod(alwaysRun= true)
	public void after(){
		driver.quit();
	}
}
