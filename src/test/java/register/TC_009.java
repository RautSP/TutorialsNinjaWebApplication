package register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_009 {
	@Test
	public void VerifyRgeisteringaccountByFillinigExistingFunctionality()
	{
		WebDriver driver=new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.xpath("//a[text()='Register']")).click();
		driver.findElement(By.id("input-firstname")).sendKeys("shital");
		driver.findElement(By.id("input-lastname")).sendKeys("raut");
		driver.findElement(By.id("input-email")).sendKeys("shitalpandurangraut@gmail.com");
		driver.findElement(By.id("input-telephone")).sendKeys("12345");
		driver.findElement(By.id("input-password")).sendKeys("Sprmay2024##");
		driver.findElement(By.id("input-confirm")).sendKeys("Sprmay2024##");
		driver.findElement(By.xpath("//input[@name='newsletter'][@value='0']"));
  		driver.findElement(By.name("agree")).click();

		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		
		String ExpectedWarning="Warning: E-Mail Address is already registered!";
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText(), ExpectedWarning );




	}

}
