package testcase;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreateLead extends CommonClass {
	@BeforeTest
	public void fileName() {
		excelFileName = "Test_Data"; 
	}

	@Test(dataProvider = "SetUpData")
	public void RunCreateLead(String cName, String fName, String lName, String pNumber) {
		
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cName);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fName);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lName);
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(pNumber);
		driver.findElement(By.name("submitButton")).click();
		
}	
}