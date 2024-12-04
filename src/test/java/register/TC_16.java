package register;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_16 {
	@Test
	public void VerifyMandatoryfieldsintheRegisterAccountpagearenotacceptingonlyspaces()
	{
		WebDriver driver=new ChromeDriver();
	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://tutorialsninja.com/demo/");

		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		
		driver.findElement(By.id("input-firstname")).sendKeys("    ");
		driver.findElement(By.id("input-lastname")).sendKeys("     ");
		driver.findElement(By.id("input-telephone")).sendKeys("     ");
  		driver.findElement(By.id("input-email")).sendKeys("   ");
  		driver.findElement(By.id("input-password")).sendKeys("     ");
  		driver.findElement(By.id("input-confirm")).sendKeys("     ");
  		//driver.findElement(By.xpath("//*[text()='Yes']"));
  		driver.findElement(By.name("agree")).click();
  		driver.findElement(By.xpath("//input[@value='Continue']")).click();
  		
  		String ExpectedFirstNameWarning="First Name must be between 1 and 32 characters!";
  		String ExpectedLastNameWarning="Last Name must be between 1 and 32 characters!";
  		String ExpectedEmailWarning="E-Mail Address does not appear to be valid!";
        //String ExpectedTelephoneWarning="";
  		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div")).getText(),ExpectedFirstNameWarning);
  		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div")).getText(),ExpectedLastNameWarning);
  		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-email']/following-sibling::div")).getText(),ExpectedEmailWarning);

       driver.quit();
 
		
		
		
	}


}
