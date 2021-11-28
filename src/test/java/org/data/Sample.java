package org.data;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;

import org.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Sample extends BaseClass {
public static void main(String[] args) throws AWTException {
	
	launchChrome();
	maxWindow();
	launchUrl("https://www.facebook.com/");
	pageTitle();
	pageUrl();
	
	WebElement usr = driver.findElement(By.name("email"));
	insertValues(usr, "Greens@gmail.com");
	selectText();
	rightClick(usr);
	for (int i = 0; i < 3; i++) {
		downKey();
	}
	enterKey();
	
	//textboxInput(locateWebelement(By.name("pass")), "1234567");
	
	//btnClick(locateWebelement(By.name("login")));

	
	printText(locateWebelement(By.name("login")));
	
	
	
	

}
}
