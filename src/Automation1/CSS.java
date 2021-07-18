package Automation1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CSS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
WebDriver driver;
driver = new ChromeDriver();
driver.get("http://automationpractice.com/index.php");
driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
//Explicit Wait WebDriverWait exp=new WebDriverWait(driver, 5);
//CSS rule 1 tagName[attribute='value']
		driver.findElement(By.cssSelector("a[class='login']")).click();
//Validation method 1 isDisplayed
		System.out.println(driver.findElement(By.cssSelector("a[class='login']")).isDisplayed()  + "--Signin Button Found");
//CSS rule 2 tagName#id-value
		driver.findElement(By.cssSelector("input#email_create")).sendKeys("jsmith5678@yahoo.com");
//Validation method 2 isSelected
		System.out.println(driver.findElement(By.cssSelector("input#email_create")).isSelected()  +"--Email address is Selected");
//CSS rule 3  tagname.class-value
		driver.findElement(By.cssSelector("button.btn.btn-default.button.button-medium.exclusive")).click();
//Validation method 3 isEnabled
		System.out.println(driver.findElement(By.cssSelector("button.btn.btn-default.button.button-medium.exclusive")).isEnabled()  +"--Create an account button is Enabled");
//CSS rule 5 #id-value
		driver.findElement(By.cssSelector("#id_gender1")).click();
//Validation method 4 .size()
		int Mr=driver.findElements(By.cssSelector("#id_gender1")).size();
		System.out.println(Mr +"--Mr in the page");
		System.out.println(driver.findElements(By.cssSelector("#id_gender1")).size()+"--count");
//CSS rule 6 tagName[attribute*='sub_string_slashunder']
		driver.findElement(By.cssSelector("input[id*='_gender2']")).click();
		System.out.println(driver.findElement(By.cssSelector("input[id*='_gender2']")).isDisplayed()+"--Mrs is displayed");
		System.out.println(driver.findElement(By.cssSelector("input[id*='_gender2']")).isSelected()+"--Mrs is selected");
		System.out.println(driver.findElement(By.cssSelector("input[id*='_gender2']")).isEnabled()+"--Mrs is enabled");
		System.out.println(driver.findElements(By.cssSelector("input[id*='_gender2']")).size()+"--count");
//CSS rule 7 tagName[attribute^='start of String']
		System.out.println(driver.findElement(By.cssSelector("input[id^='custom']")).isEnabled()+"--First name is enabled");
		driver.findElement(By.cssSelector("input[id^='custom']")).sendKeys("John");
		System.out.println(driver.findElement(By.cssSelector("input[id^='custom']")).isSelected()+"--First name is selected");
//CSS rule 8 tagName[attribute1='value'][attribute2='value']
		driver.findElement(By.cssSelector("input[id='customer_lastname'][name='customer_lastname']")).sendKeys("Smith");
		System.out.println(driver.findElement(By.cssSelector("input[id='customer_lastname'][name='customer_lastname']")).isDisplayed()+"--last name is displayed");
		System.out.println(driver.findElement(By.cssSelector("input[id='customer_lastname'][name='customer_lastname']")).isSelected()+"--Last name is selected");
//CSS rule - 9 tag[attribute$=suffix of the string]
		driver.findElement(By.cssSelector("input[id$=wd]")).sendKeys("ABC5678");

//CSS rule 4 .class-value.class-value..... *if multiple value of class with spaces
		driver.findElement(By.cssSelector(".form-control[5]")).sendKeys("16");
		System.out.println(driver.findElement(By.cssSelector(".form-control")).isDisplayed()+"--Days is displayed");
		System.out.println(driver.findElement(By.cssSelector(".form-control")).isSelected()+"--Days is selected");
		System.out.println(driver.findElement(By.cssSelector(".form-control")).isEnabled()+"--Days is enabled");
		System.out.println(driver.findElements(By.cssSelector(".form-control")).size()+"--count");


		
		
		
		
		
		
		
		
		
		
	}

}
