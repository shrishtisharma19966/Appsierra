package Automation.goibibo;


import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Goibibo {
	@Test
	public static void ticketBook() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\ShrishtiStudy\\LatestChromeDriver\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.goibibo.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//div[@class='fltSwitchOpt dIF alignItemsCenter ico15']/span[2]")).click();
		WebElement source = driver.findElement(By.id("gosuggest_inputSrc"));
		source.sendKeys("Delhi");
		WebDriverWait w = new WebDriverWait(driver,10);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("react-autosuggest-1")));
		source.sendKeys(Keys.ARROW_DOWN);
		source.sendKeys(Keys.ENTER);
		WebElement destination = driver.findElement(By.id("gosuggest_inputDest"));
		destination.sendKeys("Mumbai");
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("react-autosuggest-1")));
		destination.sendKeys(Keys.ARROW_DOWN);
		destination.sendKeys(Keys.ENTER);
		//Thread.sleep(1000);
		driver.findElement(By.id("departureCalendar")).click();
		driver.findElement(By.xpath("//div[@aria-label='Wed Aug 19 2020']")).click();
		driver.findElement(By.id("returnCalendar")).click();
		driver.findElement(By.xpath("//div[@aria-label='Fri Aug 21 2020']")).click();
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='fb ico11  hpyBlueLt ']"))).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='custRad']"))).click();
		driver.findElement(By.xpath("//input[@value='BOOK']")).click();
		driver.findElement(By.xpath("//input[@name='insure']")).click();
		try {
			driver.findElement(By.id("impInfo")).click();	
		}
		catch(Exception e ) {
			e.printStackTrace();
		}
		Scanner sc = new Scanner(System.in);
		WebElement dropdown = driver.findElement(By.id("Adulttitle1"));
		dropdown.click();
		for(int i=0;i<3;i++) {
			dropdown.sendKeys(Keys.ARROW_DOWN);
		}
		dropdown.click();
		System.out.println("Enter First name");
		driver.findElement(By.name("AdultfirstName1")).sendKeys(sc.nextLine());
		System.out.println("Enter Middle name");
		driver.findElement(By.name("AdultmiddleName1")).sendKeys(sc.nextLine());
		System.out.println("Enter Last name");
		driver.findElement(By.name("AdultlastName1")).sendKeys(sc.nextLine());
		System.out.println("Enter email");
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys(sc.nextLine());
		System.out.println("Enter mobile no.");
		driver.findElement(By.name("mobile")).sendKeys(sc.nextLine());
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='button orange col-md-3 fr large dF justifyCenter min37']"))).click();
		driver.findElement(By.xpath("//button[@class='button blue large fb padLR30']")).click();
		driver.findElement(By.xpath("//button[@class='width100 ico14 padLR20 white button hpyOrangeBg large txtCenter marginT15 brdrTLR0 padTB5 bkPgPrcd']")).click();
		driver.findElement(By.id("wallet")).click();
	}
}