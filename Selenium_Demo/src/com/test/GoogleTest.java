package com.test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleTest {
	WebDriver driver;
	@BeforeMethod
	public void setUp(){
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\PGanbote\\Downloads\\chrome\\chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver","D:\\chrome\\chromedriver.exe");
		//driver=new ChromeDriver();
		String exePath="C:\\Users\\PGanbote\\Downloads\\chrome\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver",exePath);
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
		
		
		
			
	}
	
	@Test(priority=1,groups="test2")
	public void googleTitelTest(){
		String title=driver.getTitle();
		System.out.println(title);
	}
	@Test(priority=3,groups="test1")
	public void googlelogotest(){
		boolean b=driver.findElement(By.xpath("//*[@id='hplogo']")).isDisplayed();
	}
	
	@Test(priority=2,groups="test2")
	public void Maillinktext(){
		boolean b=driver.findElement(By.linkText("Gmail")).isDisplayed();
	}
	
	
	@AfterMethod
	public void teardown(){
		driver.close();
	}

}
