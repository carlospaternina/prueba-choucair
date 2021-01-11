package com.pruebaautomatizacion.choucair;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WordpressPost {
	
	private WebDriver driver;
	By pageLinkLocator = By.linkText("Posts");
	By postPageLocator = By.name("Author");
	By addPostLocator = By.linkText("Add New");
	By addNewPostLocator = By.name("Welcome to the block editor");
	By nextButtonLocator = By.xpath("//button[@aria-label='Close dialog']");
	By bodyPostLocator = By.xpath("//p[@data-title='Paragraph']");
	By buttonPublishLocator = By.xpath("//button[@class='components-button editor-post-publish-panel__toggle editor-post-publish-button__button is-primary']");
	By publishPostLocator = By.linkText("Publish");
	
	
	

	@Before
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://s1.demo.opensourcecms.com/wordpress/wp-login.php");
		
	}
	
	@Test
	public void testWordpressPage() throws InterruptedException {
		
		WebElement userwp = driver.findElement(By.id("user_login"));
		userwp.clear();
		userwp.sendKeys("opensourcecms");
		WebElement password = driver.findElement(By.id("user_pass"));
		password.clear();
		password.sendKeys("opensourcecms");
		password.submit();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		assertEquals("Dashboard ‹ opensourcecms — WordPress", driver.getTitle());
		driver.findElement(pageLinkLocator).click();
		Thread.sleep(3000);
		driver.findElement(addPostLocator).click();
		Thread.sleep(4000);
		driver.findElement(nextButtonLocator).click();
		Thread.sleep(4000);
		WebElement titlePost = driver.findElement(By.id("post-title-0"));
		titlePost.clear();
		titlePost.sendKeys("Esto es un titulo de prueba");
		Thread.sleep(3000);
		driver.findElement(buttonPublishLocator).click();
		
		
	}
	@After
	public void tearDown() {
		driver.quit();
	}
}
