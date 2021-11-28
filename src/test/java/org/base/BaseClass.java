package org.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	static Actions a;
	static Robot r;
	static JavascriptExecutor js;
	static Alert al;
	static Select s;
	public static void launchChrome() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
	public static void maxWindow() {
		driver.manage().window().maximize();
	}
	public static void launchUrl(String url) {
		driver.get(url);
	}
	public static void pageTitle() {
		System.out.println(driver.getTitle());
	}
	public static void pageUrl() {
		System.out.println(driver.getCurrentUrl());
	}
	public static WebElement locateWebelement(By locator) {
		return driver.findElement(locator);
	}
	public static void insertValues(WebElement ref, String input) {
		ref.sendKeys(input);
	}
	public static void btnClick(WebElement ref) {
		ref.click();
	}
	public static void closeBrowser() {
		driver.quit();
	}
	public static void closeCurrentTab() {
		driver.close();
	}
	public static void printText(WebElement ref) {
		System.out.println(ref.getText());
	}
	public static void printAttribute(WebElement ref, String value) {
		System.out.println(ref.getAttribute(value));
	}
	
	
	//Action Class
	public static void mouseOver(WebElement ref) {
		a=new Actions(driver);
		a.moveToElement(ref).perform();
	}
	public static void dragDrop(WebElement src, WebElement tar) {
		a=new Actions(driver);
		a.dragAndDrop(src, tar).perform();
	}
	public static void leftclick(WebElement ref) {
		a=new Actions(driver);
		a.doubleClick(ref).perform();
	}
	public static void rightClick(WebElement ref) {
		a=new Actions(driver);
		a.contextClick(ref).perform();
	}
	
	//robot
	public static void selectText() throws AWTException {
		r=new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_A);
	}
	public static void copyKey() throws AWTException {
		r=new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_C);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_C);
	}
	public static void pasteKey() throws AWTException {
		r=new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
	}
	public static void downKey() throws AWTException {
		r=new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
	}
	public static void upKey() throws AWTException {
		r=new Robot();
		r.keyPress(KeyEvent.VK_UP);
		r.keyRelease(KeyEvent.VK_UP);
	}
	public static void enterKey() throws AWTException {
		r=new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	public static void tabKey() throws AWTException {
		r=new Robot();
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
	}
	
	//jsexecutor
	public static void scrollDown(WebElement ref) {
		js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollintoView(true)", ref);
	}
	public static void scrollUp(WebElement ref) {
		js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollintoView(false)", ref);
	}
	public static void jsClick(WebElement ref) {
		js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", ref);
	}
	public static void jsInsertvalue(WebElement ref, String input) {
		js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value'," +input+")", ref);
	}
	public static void jsPrintText(WebElement ref) {
		js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].getAttribute('value')", ref);
	}
	
	
	//alert
	public static void acceptAlert() {
		al=driver.switchTo().alert();
		al.accept();
	}
	public static void cancelAlert() {
		al=driver.switchTo().alert();
		al.dismiss();
	}
	public static void insertValuesToAlert(String input) {
		al=driver.switchTo().alert();
		al.sendKeys(input);
	}
	public static void printTextFromAlert() {
		al=driver.switchTo().alert();
		al.getText();
	}
	//frame
	public static void frameCount(String tagname) {
		List<WebElement> allFrames = driver.findElements(By.tagName(tagname));
		System.out.println("No of Frames: "+allFrames.size());
	}
	public static void switchToFrame(int i) {
		driver.switchTo().frame(i);
	}
	
	//select class
	public static void selectValue(WebElement ref, String value) {
		s=new Select(ref);
		s.selectByValue(value);
	}
	public static void selectIndex(WebElement ref, int index) {
		s=new Select(ref);
		s.selectByIndex(index);
	}
	public static void selectVisbleText(WebElement ref, String text) {
		s=new Select(ref);
		s.selectByVisibleText(text);
	}
	
	public static void deselectValue(WebElement ref, String value) {
		s=new Select(ref);
		s.deselectByValue(value);
	}
	public static void deselectIndex(WebElement ref, int index) {
		s=new Select(ref);
		s.deselectByIndex(index);
	}
	public static void deselectVisbleText(WebElement ref, String text) {
		s=new Select(ref);
		s.deselectByVisibleText(text);
	}
	public static void deSelectAll(WebElement ref) {
		s=new Select(ref);
		s.deselectAll();
	}
	public static void getAllOptions(WebElement ref) {
		s=new Select(ref);
		List<WebElement> allOptions = s.getOptions();
		for (WebElement each : allOptions) {
			System.out.println(each.getText());
		}
	}
	public static void printAllSelectedOptions(WebElement ref) {
		s=new Select(ref);
		List<WebElement> allSelected = s.getAllSelectedOptions();
		for (int i = 0; i < allSelected.size(); i++) {
			WebElement eachOpt = allSelected.get(i);
			System.out.println(eachOpt.getText());
		}
	}
	
	public static void printNotSelectedOptions(WebElement ref) {
		s=new Select(ref);
		List<WebElement> allOptions = s.getOptions();
		List<WebElement> allSelected = s.getAllSelectedOptions();
		allOptions.removeAll(allSelected);
		for (WebElement eachNonSelOpt : allOptions) {
			System.out.println(eachNonSelOpt);
		}
		}
	
	
	public static void printFirstSelectedOptions(WebElement ref) {
		s=new Select(ref);
		WebElement firstSelectedOption = s.getFirstSelectedOption();
		System.out.println(firstSelectedOption.getText());
	}
	
	
	//TakeScreenShot
	public static void takeSnap(WebElement ref,String imageName) throws IOException {
		TakesScreenshot tk= (TakesScreenshot) driver;
		File src = tk.getScreenshotAs(OutputType.FILE);
		File des=new File("C:\\Users\\Satz\\eclipse-workspace\\Maven_Sample\\Screenshot\\"+imageName+".png");
		FileUtils.copyFile(src, des);
	}
}