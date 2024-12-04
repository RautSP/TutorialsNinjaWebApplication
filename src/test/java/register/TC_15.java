package register;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;



public class TC_15 {
	@Test
	public void VerifyRegisteredNameStoredindatabase() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("http://localhost/opencart/");
		
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		
		String enteredFirstNameData = "Arun";
		driver.findElement(By.id("input-firstname")).sendKeys(enteredFirstNameData);
		
		String enteredLastNameData = "Motoori";
		driver.findElement(By.id("input-lastname")).sendKeys(enteredLastNameData);
		
		String enteredEmailData =  GenerateEmail();

		 
		
		driver.findElement(By.id("input-email")).sendKeys(enteredEmailData);
		
		String enteredPasswordData = "12345";
		driver.findElement(By.id("input-password")).sendKeys(enteredPasswordData);
		WebElement newsletter = driver.findElement(By.id("input-newsletter"));
		clickElement(driver, newsletter);
		
		WebElement agree = driver.findElement(By.name("agree"));
		clickElement(driver, agree);
		WebElement continueButton = driver.findElement(By.xpath("//button[@class='btn btn-primary']")); 
		clickElement(driver, continueButton);

		// Database credentials
		
		String jdbcURL ="jdbc:mysql://localhost:3306/opencart_db";
        String dbUser ="root";
        String dbPassword ="";
        
        // SQL query
        String sqlQuery = "SELECT * FROM oc_customer";
        
     // JDBC objects
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String firstName = null;
        String lastName = null;
        String email = null;
        int newsletter1 = 1;

        try {
		 // Step 2: Open a connection
        connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
        System.out.println("Connected to the database!");

        // Step 3: Create a statement
        statement = connection.createStatement();

        // Step 4: Execute the query
        resultSet = statement.executeQuery(sqlQuery);

        // Step 5: Process the ResultSet
        while (resultSet.next()) {
            firstName = resultSet.getString("firstname"); // Replace with your column name
            lastName = resultSet.getString("lastname"); // Replace with your column name
            email = resultSet.getString("email");
            newsletter1 = resultSet.getInt("newsletter");
        }

    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        // Step 6: Close resources
        try {
            if (resultSet != null) resultSet.close();
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

        
        Assert.assertEquals(firstName, enteredFirstNameData);
        Assert.assertEquals(lastName, enteredLastNameData);
        Assert.assertEquals(email, enteredEmailData);
        Assert.assertEquals(newsletter1, 1);
        
        driver.quit();
		
	}
	public  String GenerateEmail()

	  {
	  	return new Date().toString().replaceAll("\\s","").replaceAll("\\:","")+"@gmail.com";
	  	
		}
		
	public void clickElement(WebDriver driver, WebElement element) { 
		try { WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element)); 
		element.click(); 
		} 
		catch (ElementClickInterceptedException e) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", element); } }
		
	
}


