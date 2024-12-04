package register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_014 {
	@Test
	public void verifymandatryfieldsinregisterAccountFields() {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Register")).click();
        String expectedContent = "\"* \"";
		String expectedColor = "rgb(255, 0, 0)";
        WebElement firstNameLabel  =driver.findElement(By.cssSelector("label[for='input-firstname']"));
        WebElement lastNameLabel  =driver.findElement(By.cssSelector("label[for='input-lastname']"));
        WebElement Email  =driver.findElement(By.cssSelector("label[for='input-email']"));
        WebElement Telephone  =driver.findElement(By.cssSelector("label[for='input-telephone']"));
        WebElement password =driver.findElement(By.cssSelector("label[for='input-password']"));
        WebElement passwordconfirm  =driver.findElement(By.cssSelector("label[for='input-confirm']"));
       
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String firstNameLabel1 = (String) js.executeScript(
                "return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');",firstNameLabel );
        String fistNameLabelColor = (String)js.executeScript("return window.getComputedStyle(arguments[0],'::before').getPropertyValue('color')", firstNameLabel);
		 Assert.assertEquals(fistNameLabelColor, expectedColor);

		 
		 
	    String lastNameLabel1 = (String) js.executeScript( "return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');",
	                lastNameLabel );
	        String lastNameLabelColor = (String)js.executeScript("return window.getComputedStyle(arguments[0],'::before').getPropertyValue('color')", lastNameLabel);
			 Assert.assertEquals(lastNameLabel, expectedColor);
			 
		String Email1= (String) js.executeScript( "return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');",
				Email );
		        String EmailColor = (String)js.executeScript("return window.getComputedStyle(arguments[0],'::before').getPropertyValue('color')", Email);
				 Assert.assertEquals(EmailColor, expectedColor);
				 
				 
	   String Telephone1 = (String) js.executeScript( "return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');",
			   Telephone );
			        String TelephoneColor = (String)js.executeScript("return window.getComputedStyle(arguments[0],'::before').getPropertyValue('color')", Telephone);
					 Assert.assertEquals(Telephone1, expectedColor);
					 
	    String password1 = (String) js.executeScript( "return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');",
	    		password );
		String passwordColor = (String)js.executeScript("return window.getComputedStyle(arguments[0],'::before').getPropertyValue('color')", Telephone);
									 Assert.assertEquals(password, expectedColor);
									 
        
		String passwordconfirm1= (String) js.executeScript( "return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');",
				passwordconfirm );
		String passwordconfirmColor = (String)js.executeScript("return window.getComputedStyle(arguments[0],'::before').getPropertyValue('color')", passwordconfirm);
		Assert.assertEquals(passwordconfirm, expectedColor);
	}

}
