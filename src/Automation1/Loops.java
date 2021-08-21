package Automation1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Loops {

	WebDriver driver;
	WebDriverWait Ex;
	Actions build;
	JavascriptExecutor js; 

	@BeforeTest 
	public void setup() {
	System.setProperty("webdriver.chrome.driver","chromedriver.exe");
	driver=new ChromeDriver ();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	Ex=new WebDriverWait(driver, 6);
	build=new Actions(driver);
	js=(JavascriptExecutor) driver;
	}
	
	@Test (priority=0)
	public void frame() throws InterruptedException {
	driver.get("http://automationpractice.com/index.php");

	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[6]/div/div[2]/div[2]/a[1]")).click();
	driver.findElement(By.cssSelector("#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > a")).click();

	js.executeScript("window.scrollBy(0, window.innerHeight)"); //Scroll Down
	Ex.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#cart_quantity_up_6_31_0_0")));
	WebElement AddToCart=driver.findElement(By.cssSelector("#cart_quantity_up_6_31_0_0"));
	AddToCart.click();
	
//	js.executeScript("arguments[0].scrollIntoView();",AddToCart);
//	WebElement AddToCart=driver.findElement(By.cssSelector("#"))


	int i=1;

	do{
	AddToCart.click();
	i++;
	}
	while (i<5);
	Thread.sleep(2000);
	for (int x=1; x<1; x++)
	{
	
	driver.findElement(By.xpath("//*[@id=\"cart_quantity_down_6_31_0_0\"]")).click();
	
		

	
	
	}
	}
	}















