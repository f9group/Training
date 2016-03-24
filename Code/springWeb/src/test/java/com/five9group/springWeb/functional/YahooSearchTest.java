package com.five9group.springWeb.functional; 
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class YahooSearchTest {

	//this is an sample test. use this to extend functional tests
	
	private WebDriver driver;
	private String expectedTitle ="Donald Trump - Yahoo Search Results";

	@Before
	public void setUp() {
		// Create a new instance of the html unit driver
		driver = new HtmlUnitDriver();

		//Navigate to desired web page
		driver.get("http://yahoo.com");
	}
	
	@Test
	public void shouldBeAbleToSerarch() 
	{
		 driver.findElement(By.xpath(".//*[@id='uh-search-box']")).sendKeys("Donald Trump");
         driver.findElement(By.xpath(".//*[@id='uh-search-button']")).click();
		// verify title of index page
         String actualTitle = driver.getTitle();
         assertThat(actualTitle, equalTo(expectedTitle));



	}

}
