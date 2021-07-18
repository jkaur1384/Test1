package Automation1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Startup {

	public static void main(String[] args) {
// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver;
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.findElement(By.className("login")).click();
		driver.findElement(By.id("email_create")).sendKeys("thisemail@yahoo.com");
		driver.findElement(By.linkText("Contact us")).click();
		driver.findElement(By.partialLinkText("Sign")).click();
//an example of relative xpath-line 20
		driver.findElement(By.xpath("//*[@id=\"search_query_top\"]")).sendKeys("shirts");
//an example of absolute or full xpath-line 21
		driver.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[2]/form/button")).click();

//Relative x-path rule number 1.//tagName[@attribute='value']
		driver.findElement(By.xpath("//a[@class='login']")).click();
		driver.findElement(By.xpath("//button[@id='SubmitCreate']")).click();
		// Relative x-path rule number 2.
		// //tagName[@attribute='value'][@attribute='value']
		driver.findElement(By.xpath("//input[@id='email_create'][@name='email_create']")).sendKeys("apurbaa@yahoo.com");
		// relative x-path rule number 3. //tagName[contains(@attribute,'value')]
		driver.findElement(By.xpath("//button[contains(@id,'SubmitCreate')]")).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.id("id_gender1")).click();
		driver.findElement(By.name("customer_firstname")).sendKeys("yourwish");
		driver.findElement(By.xpath("//input[@id='customer_lastname']")).sendKeys("caring");
		driver.findElement(By.xpath("//input[@name='email'][@id='email']")).clear();
		driver.findElement(By.xpath("//input[@name='email'][@id='email']")).sendKeys("thus@yahoo.com");
		driver.findElement(By.xpath("//input[contains(@id,'passwd')]")).sendKeys("abc123");
		driver.findElement(By.id("address1")).sendKeys("45 union st");
		driver.findElement(By.className("inline-infos")).isDisplayed();

	
	}	

}
