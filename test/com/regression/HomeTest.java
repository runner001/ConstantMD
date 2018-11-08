package com.regression;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.page.Home;

public class HomeTest {
	
	public static void main(String args[]) {
		WebDriver driver = new ChromeDriver();

		Home homePage = new Home("https://www.constantmd.com/", driver);

		homePage.loadHomePage();

		String homePageTitle = homePage.getHomePageTitle();

		System.out.println("Constatn MD, Home Page Title: " + homePageTitle);
		System.out.println("Number of header elements: " + homePage.getHeaderLink());

		ArrayList<String> subMenuesTitle = homePage.getSubMenuesInText("Product");
		for (String s : subMenuesTitle) {

			if (s.length() > 0) {
				System.out.println("Product Sub Menu is: " + s);
			}
		}
		driver.quit();

	}

}
