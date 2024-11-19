package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class loginAutomationDataFormDatabase {
	public static void main(String[] args) throws SQLException {
		String host = "localhost";
		String port = "3306";
		String databasename = "qadbt";
		String userName = "root";
		String password = "Password@123";
		String browserName=null;
		String url=null;
		String emailID=null;
		String passwordl=null;
		WebDriver driver=null;

		Connection connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + databasename + "", userName, password);

		Statement statement = connection.createStatement();

		ResultSet resultSet = statement.executeQuery("select * from LoginCredentials where LoginCredentialsid=2;");
		
		while (resultSet.next()) {
			browserName=resultSet.getString("BrowserName");
			url=resultSet.getString("URL");
			emailID=resultSet.getString("EmailID");
			passwordl=resultSet.getString("Password");
		}
		
		
		switch (browserName.toLowerCase()) {
		
		case "chrome": driver=new ChromeDriver();
			           break;
			
		case "firefox": driver=new FirefoxDriver();
		              break;
		              
		case "edge": driver=new EdgeDriver();
                      break;

		default: System.out.println("There is no browser to Launch with the name "+browserName);
			break;
		}
		
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.findElement(By.id("emailId")).click();
		driver.findElement(By.id("emailId")).sendKeys(emailID);
		driver.findElement(By.cssSelector("input[name='password']")).click();
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys(passwordl);
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("a[title='Products']"))));
		
		
		driver.findElement(By.cssSelector("a[title='Products']")).isDisplayed();
		
		driver.quit();
		System.out.println("The End");
		
		 resultSet.close();
	     statement.close();
	     connection.close();
	}

}
