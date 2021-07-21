package testcase;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonClass {
	public ChromeDriver driver;
	public String excelFileName;
	@Parameters({"url","username","password"})
	@BeforeMethod
	public void PreCondition(String url, String uName, String Password) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElement(By.id("username")).sendKeys(uName);
		driver.findElement(By.id("password")).sendKeys(Password);
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();	
	}
@AfterMethod	
public void PostCondition() {
	driver.close();		
	}
@DataProvider
public String[][] SetUpData() throws IOException {
	ReadExcelData dataretrive = new ReadExcelData();
	return dataretrive.ReadData(excelFileName);
	}
}