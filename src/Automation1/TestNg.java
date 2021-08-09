package Automation1;

import java.util.concurrent.TimeUnit;




import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TestNg {
	WebDriver driver;
	WebDriverWait Ex;

@BeforeTest	
	public void setup() {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		Ex=new WebDriverWait(driver, 10);

}


 @Test (priority=0)
	 public void openurl() {
	 driver.get("http://automationpractice.com/index.php");
}	 



 @Test (priority=1)
	 public void signin() {
	 driver.findElement(By.className("login")).click(); 	
String ExpectedURL="http://automationpractice.com/index.php?controller=authentication&back=my-account";
String ActualURL=driver.getCurrentUrl();
Assert.assertEquals(ActualURL, ExpectedURL);
System.out.println("Assert Passed");
}
	
@Test (priority=2,invocationCount=3)
public void enteremail() {
	driver.findElement(By.id("email_create")).sendKeys("jsmith5678@yahoo.com");
String ExpectedForm="create-account_form";
String ActualForm=driver.findElement(By.id("create-account_form")).getAttribute("id");
Assert.assertEquals(ExpectedForm,ActualForm );
System.out.println("Form was found");
driver.findElement(By.id("email_create")).clear();
driver.findElement(By.id("email_create")).sendKeys("jsmith5678@yahoo.com");

}

@Test(priority=3,dependsOnMethods= {"enteremail"})
public void clicksubmit() {
WebElement SubmitCreate =driver.findElement(By.xpath("//button[@id='SubmitCreate']")); 
SubmitCreate.click();
Assert.assertEquals(true, SubmitCreate.isEnabled());
System.out.println("SubmitCreate Assert Passed");
}	
	
@Test(priority=4) 
public void personalinfo() {
	
	String ExpectedURL="http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation";
	Ex.until(ExpectedConditions.urlToBe(ExpectedURL));
	String ExpectedForm="account-creation_form";
	String ActualForm=driver.findElement(By.id("account-creation_form")).getAttribute("id");
	Assert.assertEquals(ExpectedForm,ActualForm );
	System.out.println("Form was found");
}
	@Test(priority=5)
public void selectdays() {
	WebElement drpdays=driver.findElement(By.id("days"));
	//Ex.until(ExpectedConditions.elementToBeClickable(drpdays));
	drpdays.click();
	Select Days=new Select (drpdays);
	Days.selectByVisibleText("10  ");
	String Option=Days.getFirstSelectedOption().getText();
	Assert.assertEquals("10  ",Option );
	}	
@Test(priority=6)
public void company() {
	WebElement company=driver.findElement(By.id("company"));
	company.sendKeys("Abctech");
	String Expected="Abctech";
	String Actual=driver.findElement(By.id("company")).getAttribute("value");
	Assert.assertEquals(Actual,Expected );
	System.out.println(Actual);
}
@Test(priority=7)
public void mobilephone() {
	WebElement mobilephone=driver.findElement(By.id("phone_mobile"));
	Assert.assertEquals(true, mobilephone.isDisplayed());
	System.out.println("--isDisplayed Assertion Passed");
	mobilephone.sendKeys("5145586952");
	Assert.assertEquals(true, mobilephone.isEnabled());
	System.out.println("--isEnabled Assertion Passed");
	Assert.assertEquals(false, mobilephone.isSelected());
	System.out.println("--isSelected Assertion Passed");
	String ExpectedValue="5145586952";
	String Actualvalue=driver.findElement(By.id("phone_mobile")).getAttribute("value");
	Assert.assertEquals( Actualvalue,ExpectedValue );
	System.out.println(Actualvalue+"--Assertion passed");
	int mobilenumber=driver.findElements(By.id("phone_mobile")).size();
		if(mobilenumber==0)
		{	
		System.out.println("--Mobilenumber is verified");
		}
		else if (mobilenumber==1) {
			System.out.println("Mobile Number Duplicate found" );
		}
		
		
		else
		{
			System.out.println("--Mobilenumber is not verified");
		}
}
@AfterTest
public void closetab() {
driver.close();
}
}
	
	






