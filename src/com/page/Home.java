package com.page;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Home {
	

	// Declaring WebDriver variables;
	private WebDriver driver;
	private String urlAddress;

	// instantiating ChromeDriver();
	// initialize driver variable
	public Home(String urlAddress, WebDriver driver) {
		this.driver = driver;
		this.urlAddress = urlAddress;
	}

	// load the Constant MD home page
	public void loadHomePage() {
		this.driver.get(this.urlAddress);
	}

	// return the title of the home page
	public String getHomePageTitle() {
		return this.driver.getTitle();
	}

	public int getHeaderLink() {
		return this.driver.findElements(By.cssSelector("#mainNavbar > ul > li")).size();
	}

	public ArrayList<String> getSubMenuesInText(String headerMenu) {
		
		ArrayList<String> string = new ArrayList<String>();

		if (headerMenu == "Product") {

			Actions action = new Actions(this.driver);

			action.moveToElement(this.driver.findElement(By.cssSelector(".dropdown-toggle"))).perform();
			
			List<WebElement> elms = this.driver.findElements(By.cssSelector(".dropdown-menu > li > a"));
			for (WebElement e : elms) {
				//System.out.println(e.getText());
				string.add(e.getText());
			}
			return string;

		} else {
			System.out.println("Wrong header title: " + headerMenu);
		}

		return null;
	}
	
	public void clickOnSubmenu(String headerMenu, String locators) {
		
		if (headerMenu == "Product") {
			Actions action = new Actions(this.driver);
			action.moveToElement(this.driver.findElement(By.cssSelector(".dropdown-toggle"))).perform();
			this.driver.findElement(By.xpath(locators)).click();
		} else {
			System.out.println("Wrong header title: " + headerMenu);
		}
	}
	
	public void clickOnHome() {
		this.driver.findElement(By.cssSelector("#mainNavbar > ul > li > a")).click();
	}
	
}

