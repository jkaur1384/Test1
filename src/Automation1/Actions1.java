package Automation1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Actions1 {
	WebDriver driver;
	WebDriverWait Ex;
	Actions build;
	JavascriptExecutor js;
	@BeforeTest	
	public void setup() {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(7,TimeUnit.SECONDS);
		Ex=new WebDriverWait(driver, 6);
 build = new Actions(driver);
 js=(JavascriptExecutor) driver;
}

@Test(priority=0)
public void actions() throws InterruptedException {
	driver.get("https://www.facebook.com/");
	WebElement email = driver.findElement(By.id("email"));
	Action series = build.moveToElement(email).click().keyDown(email, Keys.SHIFT).sendKeys(email, "hello").keyUp(email, Keys.SHIFT).build();
	series.perform();
	driver.get("https://demoqa.com/droppable");
	WebElement from = driver.findElement(By.id("draggable"));
	WebElement to = driver.findElement(By.id("droppable"));
	Action series2 = build.dragAndDrop(from, to).build();
	series2.perform();
	driver.navigate().refresh();
	Thread.sleep(5000);
	//Ex.until(ExpectedConditions.stalenessOf(from));
	//Action series3 = build.moveToElement(from).clickAndHold().release(to).build();
	//series3.perform();
}
@Test(priority=1)
public void alerts1() {
	driver.get("https://demoqa.com/alerts");
	driver.findElement(By.id("alertButton")).click();
	driver.switchTo().alert().accept();
	driver.findElement(By.id("confirmButton")).click();
	driver.switchTo().alert().dismiss();
	driver.findElement(By.id("promtButton")).click();
	driver.switchTo().alert().sendKeys("Jenn");
	driver.switchTo().alert().accept();
	
}

@Test (priority=2)
public void frames() throws InterruptedException {
	driver.get("https://demoqa.com/frames");
	//FIRST CHILD
	driver.switchTo().frame(1);
	WebElement sampleText = driver.findElement(By.id("sampleHeading"));
	System.out.println(sampleText.getText());
	//COMING BACK TO MAIN WINDOW
	driver.switchTo().defaultContent();
	driver.switchTo().frame(2);
	WebElement fra2 = driver.findElement(By.id("sampleHeading"));
	System.out.println(fra2.getText());
	
	driver.switchTo().defaultContent();
	WebElement iframe1 = driver.findElement(By.id("frame1"));
	driver.switchTo().frame(iframe1);
	driver.switchTo().defaultContent();
	//Scroll down to the end of the page 
	js.executeScript("window.scrollBy(0, window.innerHeight)");

	driver.switchTo().frame(2);
	//Scroll down on x and y coordinate
	js.executeScript("window.scrollBy(48,148),''; ");
	Thread.sleep(1000);
	//Scroll up based on x and y coordinate
	js.executeScript("window.scrollBy(48,-148),''; ");
	//Scroll right based on x coordinate and y coordinate=0 
	js.executeScript("window.scrollBy(100,0)");
	//Scroll left based on x coordinate and y coordinate=0
	js.executeScript("window.scrollBy(-100,0)");
	driver.switchTo().defaultContent();
	driver.get("https://demoqa.com/elements");
	WebElement checkBox = driver.findElement(By.id("item-1"));
	Thread.sleep(1000);
	js.executeScript("arguments[0].scrollIntoView();", checkBox);
	


}


	
	
	
	
}





