package register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utility.Commonutilitise;

public class TC_017 {
	WebDriver driver;
	@AfterMethod
	public void teardown()
	{
	driver.quit();	
	}
	@Test(dataProvider="userdata")
	public void VerifyRegisterAccountUsingPasswordWhichDoesNotFollowPasswordComplexityStandard(String userdata) {
		 driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.xpath("//span[text()='My Account']")).click();driver.findElement(By.linkText("Register")).click();
        driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys("reva");
        driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys("raut");

		driver.findElement(By.id("input-telephone")).sendKeys("1234567");
		driver.findElement(By.id("input-email")).sendKeys(Commonutilitise.GenerateEmail());
		driver.findElement(By.id("input-password")).sendKeys("userdata");
		driver.findElement(By.id("input-confirm")).sendKeys("userdata");
		driver.findElement(By.xpath("//*[text()='Yes']"));
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		String ExpectedWarningMassage="User Should Have To Follow Password Complexity";
		
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id=input-password]/following-sibling::div")).getText(), ExpectedWarningMassage);
		
	}
	@DataProvider(name="userdata")
	public Object[][] createData() {
		return new Object[][] { 
		{"12345"}, {"Abc2123"}, {"AsweQw@@"} };
	}
	

}
