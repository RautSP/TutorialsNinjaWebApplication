package register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_004 {
	@Test
	public void ToVerifyProrperMsgsdisplayesWhilenodataprovide() {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		String ExpectedTextOne="First Name must be between 1 and 32 characters!";
		String ExpectedTextTwo="Last Name must be between 1 and 32 characters!";
		String ExpectedTextThree="E-Mail Address does not appear to be valid!";
		String ExpectedTextFour="Telephone must be between 3 and 32 characters!";
		String ExpectedTextFive="Password must be between 4 and 20 characters!";
		String ExpectedTextSix="Warning: You must agree to the Privacy Policy!";
		
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='text-danger'][text()='First Name must be between 1 and 32 characters!']")).getText(),ExpectedTextOne);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div")).getText(), ExpectedTextTwo);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-email']/following-sibling::div")).getText(), ExpectedTextThree);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).getText(), ExpectedTextFour);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).getText(), ExpectedTextFive);
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText(), ExpectedTextSix);
		driver.quit();


		
	}

}
