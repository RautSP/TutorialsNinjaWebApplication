package register;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TC_001 {
    @Test
	public  void RegisterWithMandatoryfields() {
          WebDriver driver=new ChromeDriver();
          driver.manage().window().maximize();
          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
          
          driver.get("https://tutorialsninja.com/demo/");
          driver.findElement(By.xpath("//span[text()='My Account']")).click();
          driver.findElement(By.linkText("Register")).click();
          driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys("reva");
          driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys("raut");

  		driver.findElement(By.id("input-telephone")).sendKeys("1234567");
  		driver.findElement(By.id("input-email")).sendKeys(GenerateEmail());
  		driver.findElement(By.id("input-password")).sendKeys("SPRmay2024##");
  		driver.findElement(By.id("input-confirm")).sendKeys("SPRmay2024##");
  		driver.findElement(By.xpath("//*[text()='Yes']"));
  		driver.findElement(By.name("agree")).click();
  		driver.findElement(By.xpath("//input[@value='Continue']")).click();
  		
  		String ExpectedHeading="Your Account Has Been Created!";
  		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='common-success']//h1")).getText(),ExpectedHeading);
  		Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());
  		
  		
  		
  		String ExpextedTextOne="Congratulations! Your new account has been successfully created!";
  		String ExpextedTexttwo="You can now take advantage of member privileges to enhance your online shopping experience with us.\r\n";
  		String ExpextedTextthree="If you have ANY questions about the operation of this online shop, please e-mail the store owner";

  		String ExpextedTextfour="A confirmation has been sent to the provided e-mail address. If you have not received it within the hour, please ";
  		String ExpextedTextfive=" contact us";
  		
  		Assert.assertTrue(driver.findElement(By.id("content")).getText().contains(ExpextedTextOne));
  		//Assert.assertTrue(driver.findElement(By.id("content")).getText().contains(ExpextedTexttwo));
  		Assert.assertTrue(driver.findElement(By.id("content")).getText().contains(ExpextedTextthree));
  		Assert.assertTrue(driver.findElement(By.id("content")).getText().contains(ExpextedTextfour));
  		Assert.assertTrue(driver.findElement(By.id("content")).getText().contains(ExpextedTextfive));
  		
  		driver.findElement(By.xpath("//div[@id='content']//a[text()='Continue']")).click();
  		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
        
  		
  	}
  public  String GenerateEmail()

  {
  	return new Date().toString().replaceAll("\\s","").replaceAll("\\:","")+"@gmail.com";
  	
	}

}
