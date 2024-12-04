package register;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_005 {
	@Test
	public void VerifyingRegisterAccountBySubcribeNewsletter()
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys("shital");
		driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys("raut");
		driver.findElement(By.id("input-email")).sendKeys(GenerateEmail());

		driver.findElement(By.id("input-telephone")).sendKeys("1234567");
		driver.findElement(By.id("input-password")).sendKeys("SPRmay2024##");
		driver.findElement(By.id("input-confirm")).sendKeys("SPRmay2024##");
		driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		driver.findElement(By.linkText("Continue")).click();
		driver.findElement(By.linkText("Subscribe / unsubscribe to newsletter")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Newsletter']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).isSelected());
		driver.quit();
	}
	
	public String GenerateEmail()

	{
		return new Date().toString().replaceAll("\\s","").replaceAll("\\:","")+"@gmail.com";
		
	}

}
