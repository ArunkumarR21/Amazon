package org.sample;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class AmazonMain extends Basecls {
	ExtentReports reports;
	ExtentHtmlReporter htmlReporter;
	ExtentTest test;

	@BeforeClass
	public void tc0() throws IOException {
		reports = new ExtentReports();
		htmlReporter = new ExtentHtmlReporter("Amazon.html");
		reports.attachReporter(htmlReporter);
		getDriver();
		launchUrl("https://www.amazon.in/");
		driver.manage().window().maximize();
		screenShot("C:\\Users\\Hp\\eclipse-workspace\\AmazonTestNG\\target\\Home.png");
	}

	@BeforeMethod
	public void tc1() {
		Date date = new Date();
		System.out.println(date);

	}

	@Test
	public void tc2() throws IOException {
		HomePagePOM home = new HomePagePOM();
		test = reports.createTest("Validating home page");
		test.log(Status.INFO, "Verify url");
		if (driver.getCurrentUrl().contains("amazon")) {
			test.log(Status.PASS, "Validated url");
		} else {
			test.log(Status.FAIL, "Invalid URL");
		} 
		home.getTxtSignIn().click();
		WebElement txtSignIn = driver.findElement(By.xpath("//h1[@class='a-spacing-small']"));
		String text = txtSignIn.getText();
		System.out.println(text);
		Assert.assertEquals(text, "Sign-In");
		home.getTxtEmail().sendKeys(Basecls.filecreationpath(
				"C:\\Users\\Hp\\eclipse-workspace\\AmazonTestNG\\Excel\\Amazon.xlsx", "Sheet1", 1, 0));
		home.getBtnContinue().click();
		home.getTxtPassword().sendKeys(Basecls.filecreationpath(
				"C:\\Users\\Hp\\eclipse-workspace\\AmazonTestNG\\Excel\\Amazon.xlsx", "Sheet1", 1, 1));
		home.getBtnSignIn().click();
		
	}

	@Test
	public void tc3() throws IOException {
		test = reports.createTest("Product Search");
		WebElement btnSearch = driver.findElement(By.id("nav-search-submit-button"));
		test.log(Status.INFO, "Verifying Home page");
		if (btnSearch.isDisplayed()) {
			test.log(Status.PASS, "Search Button Enabled");
			File screenShot = btnSearch.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenShot, new File("SearchProduct.png"));
			test.addScreencastFromPath("SearchProduct.png");
		} else {
			test.log(Status.FAIL, "Search Button is not enabled");
		}
		ProductSearchPOM search = new ProductSearchPOM();
		search.getTxtSignIn().sendKeys(Basecls.filecreationpath(
				"C:\\Users\\Hp\\eclipse-workspace\\AmazonTestNG\\Excel\\Amazon.xlsx", "Sheet1", 1, 2));
		WebElement btnSearch2 = search.getBtnSearch();
		btnSearch2.click();
		}

	@Test
	private void tc4() throws IOException {
		test = reports.createTest("Cart Page Validation");
		AddtoCart add = new AddtoCart();
		WebElement btnProductClick = add.getBtnProductClick();
		test.log(Status.INFO, "Verifying Add Cart page");
		if (btnProductClick.isEnabled()) {
			test.log(Status.PASS, "Add cart button is Enabled");
			File screenShot = btnProductClick.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenShot, new File("Addcart.png"));
			test.addScreencastFromPath("Addcart.png");
		} else {
			test.log(Status.FAIL, "Add cart Button is not enabled");
		}
		btnProductClick.click();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		String parentWindow = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();
		for (String string : windowHandles) {
			if (!(parentWindow.equals(string))) {
				driver.switchTo().window(string);
			}
		}
		WebElement btnAddToCart = add.getBtnAddToCart();
		screenShot("C:\\Users\\Hp\\eclipse-workspace\\AmazonTestNG\\target\\Cart.png");
		boolean addCartEnabled = btnAddToCart.isEnabled();
		System.out.println("Cart Button Enabled: " + addCartEnabled);
		btnAddToCart.click();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		WebElement btnProceedButton = add.getBtnProceedButton();
		btnProceedButton.click();
		screenShot("C:\\Users\\Hp\\eclipse-workspace\\AmazonTestNG\\target\\Proceed.png");
		WebElement txtTitle = driver.findElement(By.xpath("//h1[@class='a-spacing-base']"));
		test.log(Status.INFO, "Proceed window");
		if (txtTitle.isDisplayed()) {
			test.log(Status.PASS, "Proceed window displayed");
			File screenShot = txtTitle.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenShot, new File("Proceedpaymentpage.png"));
			test.addScreencastFromPath("Proceedpaymentpage.png");
		} else {
			test.log(Status.FAIL, "Add cart Button is not enabled");
		}
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.navigate().refresh();
		driver.switchTo().window(parentWindow);
		driver.navigate().refresh();
	}

	@Test
	public void tc5() throws IOException {
		CartDeletionPOM delete = new CartDeletionPOM();
		WebElement btnCart = delete.getBtnCart();
		boolean displayed = btnCart.isDisplayed();
		System.out.println("Cart Button Displayed: " + displayed);
		btnCart.click();
		screenShot("C:\\Users\\Hp\\eclipse-workspace\\AmazonTestNG\\target\\cartdeletion.png");
		WebElement btnDelete = delete.getBtnDelete();
		boolean enabled = btnDelete.isEnabled();
		System.out.println("Cart Delete Button Displayed: " + enabled);
		btnDelete.click();
		screenShot("C:\\Users\\Hp\\eclipse-workspace\\AmazonTestNG\\target\\OnceCartDeleted.png");

	}

	public void tc6() {
		Date date1 = new Date();
		System.out.println(date1);

	}

	@AfterClass
	public void tc7() {
		reports.flush();
		driver.quit();
	}

}
