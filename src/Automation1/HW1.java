package Automation1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HW1 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver;
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.findElement(By.className("login")).click();
		driver.findElement(By.id("email_create")).sendKeys("thus@yahoo.com");
		driver.findElement(By.linkText("Contact us")).click();
		driver.findElement(By.partialLinkText("Sign")).click();
//an example of relative xpath-line 20
		driver.findElement(By.xpath("//*[@id=\"search_query_top\"]")).sendKeys("shirts");
//an example of absolute or full xpath-line 21
		driver.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[2]/form/button")).click();

//Relative x-path rule number 1.//tagName[@attribute='value']
		driver.findElement(By.xpath("//a[@class='login']")).click();
		driver.findElement(By.xpath("//button[@id='SubmitCreate']")).click();
// Relative x-path rule number 2. //tagName[@attribute='value'][@attribute='value']
		driver.findElement(By.xpath("//input[@id='email_create'][@name='email_create']")).sendKeys("thus@yahoo.com");
// relative x-path rule number 3. //tagName[contains(@attribute,'value')]
		driver.findElement(By.xpath("//button[contains(@id,'SubmitCreate')]")).click();
//relative x-path rule number 4.//tagName[starts-with(@attribute,'value')]
		driver.findElement(By.xpath("//select[starts-with(@id,'passwd')]")).sendKeys("abc123");
//relative x-path rule number 5.//tagName[starts-with(@attribute,'value')and(@attribute='value')] //Didn't work.
			//rules 1 //tagName[@attribute='value'] worked 
//Relative x-path rule 6. //tagName[starts-with(@attribute,'value') or (@attribute='value')] worked 
				WebElement drpdays = driver.findElement(By.xpath("//select[starts-with(@id,'day') or (@name='day')]"));
				drpdays.click();
				Select Day=new Select (drpdays);
				Day.selectByIndex(10);
//Relative x-path rules 7 //*[@attribute='value']
			      WebElement drpmonth= driver.findElement(By.xpath(" //*[@id='months']"));
			     //Thread.sleep(2000);
			drpmonth.click();
			Select Month=new Select(drpmonth);
			Month.selectByVisibleText("May ");
//Relative x-path rule 8 //*[@attribute='value' or @attribute='value']     
			WebElement drpyear= driver.findElement(By.xpath("//*[@id='years' or @name='years']"));
			drpyear.click();
			Select Year=new Select (drpyear);
			Year.selectByValue("2021");
//Relative x-path rule 9 //*[@attribute='value' and @attribute='value']
			driver.findElement(By.xpath(" //*[@type='checkbox' and @name='newsletter']")).click();
//Relative x-path rule 10 //*[@attribute='value' and @attribute='value' or @attribute='value']
			driver.findElement(By.xpath("//*[@type='checkbox' and @name='optin' or @id='optin']")).click();


				
				
	

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
//Relative x-path rule 13 	//tagname/button/preceding::input[@name='value']
		//driver.findElement(By.xpath("//input/preceding::input[@type='radio']")).click();
// Relative x-path rule 14 	//tagname/button/following::input[@name='value']
		//driver.findElement(By.xpath("//input/preceding::input[@id='id_gender2']")).click();
		driver.findElement(By.xpath("//input/following::input[@value='2']")).click();
		
		//driver.close();
			
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);//Needed extra time to locate the element.
		driver.findElement(By.id("id_gender1")).click();//We are using id to locate the elements.
		driver.findElement(By.name("customer_firstname")).sendKeys("yourwish");//We are using name to locate the element.
		driver.findElement(By.xpath("//input[@id='customer_lastname']")).sendKeys("caring");//We are using x-path rule #1 to locate the element. 
		driver.findElement(By.xpath("//input[@name='email'][@id='email']")).clear();//We are using x-path rule #2 to locate the element.
		driver.findElement(By.xpath("//input[@name='email'][@id='email']")).sendKeys("thus@yahoo.com");//We are using x-path rule #2 to locate the element.
		driver.findElement(By.xpath("//input[contains(@id,'passwd')]")).sendKeys("abc123");//We are using x-path rule 3 to locate the element.
		driver.findElement(By.id("address1")).sendKeys("45 union st");//We are using id to locate the element.
		driver.findElement(By.className("inline-infos")).isDisplayed();//We are using class-name to locate the element. 
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		//Relative x-path Rule 2.//tagName[@attribute='value'][@attribute='value']
		driver.findElement(By.xpath("//input[@name='customer_firstname'][@id='customer_firstname']")).sendKeys("John");
		//Relative x-path Rule 3.//tagName[contains(@attribute,'value')]
		driver.findElement(By.xpath("//input[contains(@id,'customer_lastname')]")).sendKeys("Smith");
		//Relative x-path Rule 1.//tagName[@attribute='value']
		driver.findElement(By.xpath("//input[@id='email']"));
		//Relative x-path Rule 4.//tagName[starts-with(@attribute,'value')]
		driver.findElement(By.xpath("//input[starts-with(@name,'passwd')]")).sendKeys("Abc1234");
		//Relative x-path Rule 5.//tagName[starts-with(@attribute,'value')and(@attribute='value')]
		driver.findElement(By.xpath("//input[starts-with(@name,'address1')and(@id='address1')]")).sendKeys("55 Water st");
		//Relative x-path Rule 6. //tagName[starts-with(@attribute,'value') or (@attribute='value')]
			WebElement drpday = driver.findElement(By.xpath("//select[starts-with(@id,'day') or (@name='day')]"));
			drpday.click();
			Select day = new Select(drpday);
			day.selectByIndex(5);
		//Relative x-path Rule 7.//*[@attribute='value']
			//WebElement drpmonth = //*[@id='months']
			//drpmonth		
		
		
		
		
		
		
		driver.close();
		driver.quit();
		
		
		
	}

}
