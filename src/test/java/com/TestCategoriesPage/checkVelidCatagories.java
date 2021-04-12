package com.TestCategoriesPage;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.utilities.JxlExcelSheetUtility;

public class checkVelidCatagories {
	WebDriver driver;
	JxlExcelSheetUtility value = new JxlExcelSheetUtility();
	@BeforeSuite
	public void openBrowser() throws Exception {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://myshopprime.com/suhas.dhanorkar1");
		driver.manage().window().maximize();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//button[@class=\"focus:outline-none border-0 p-2\"]")).click();
		driver.findElement(By.xpath("//p[text()=\"Categories\"]")).click();
		Thread.sleep(10000);
	}

	@Test(priority = 1)
	public void checkTitle() {
		String actualTitle = driver.getTitle();
		System.out.println("check title of webPage::" + actualTitle);
		String expectedTitle = "MyShopPrime";
		Assert.assertEquals(actualTitle, expectedTitle);
	}

	@Test(priority = 2)
	public void checkCatagories() throws InterruptedException {
		ArrayList<String> expectedCategories = new ArrayList<String>();
		expectedCategories.add("Women");
		expectedCategories.add("Men");
		expectedCategories.add("Baby & Kids");
		expectedCategories.add("Home & Living");
		ArrayList<String> actualCategories = new ArrayList<String>();
		for (String name : expectedCategories) {
			Thread.sleep(10000);
			waitForElement(driver.findElement(By.xpath("//div[text()='" + name + "']")));
			WebElement category = driver.findElement(By.xpath("//div[text()='" + name + "']"));
			actualCategories.add(category.getText());
		}
		System.out.println(actualCategories);
		System.out.println(expectedCategories);
		Assert.assertEquals(actualCategories, expectedCategories);
	}

	@Test(priority = 3)
	public void validshopByCatagoriesElement() throws InterruptedException {
		ArrayList<String> ExpectedList = new ArrayList<String>();
		ExpectedList.add("Wallets");
		ExpectedList.add("Active Wear");
		ExpectedList.add("Messenger & Duffle Bags");
		ExpectedList.add("Kitchen Tools");
		ArrayList<String> ActualList = new ArrayList<String>();
		for (String name : ExpectedList) {
			Thread.sleep(5000);
			waitForElement(driver.findElement(By.xpath("//a[text()='" + name + "']")));
			WebElement catagories = driver.findElement(By.xpath("//a[text()='" + name + "']"));
			ActualList.add(catagories.getText());
		}
		System.out.println(ActualList);
		System.out.println(ExpectedList);
		Assert.assertEquals(ActualList, ExpectedList);
	}
	@Test(priority = 4)
	public void checkValidWomansProduct() throws InterruptedException {
		driver.findElement(By.xpath("//div[text()=\"Women\"]")).click();
		ArrayList<String> expectedProducts = new ArrayList<String>();
		expectedProducts.add("Ethnic Wear");
		expectedProducts.add("Western Wear");
		expectedProducts.add("Jewellery");
		expectedProducts.add("Watches & Wearables");
		expectedProducts.add("Winter Wear");
		ArrayList<String> actualProducts = new ArrayList<String>();
		for (String products : expectedProducts) {
			Thread.sleep(1000);
			waitForElement(driver.findElement(By.xpath("//div[text()='" + products + "']")));
			WebElement productWoomen = driver.findElement(By.xpath("//div[text()='" + products + "']"));
			actualProducts.add(productWoomen.getText());
		}
		System.out.println(actualProducts);
		System.out.println(expectedProducts);
		Assert.assertEquals(actualProducts, expectedProducts);
	}
	@Test(priority = 5)
	public void validProductInWallet() throws InterruptedException {
		driver.findElement(By.linkText("Wallets")).click();
		Thread.sleep(5000);
		ArrayList<String> expectedWallets = new ArrayList<String>();
		expectedWallets.add("Essential Genuine Leather Solid Wallet");
		expectedWallets.add("Trendy PU Black Chip ATM Wallet For Men");
		expectedWallets.add("Trendy PU Card Holder Wallet");
		ArrayList<String> actualWallets = new ArrayList<String>();
		for (String wallets : expectedWallets) {
			Thread.sleep(5000);
			waitForElement(driver.findElement(By.xpath("//p[text()='" + wallets + "']")));
			WebElement walletName = driver.findElement(By.xpath("//p[text()='" + wallets + "']"));
			actualWallets.add(walletName.getText());
		}
		System.out.println(actualWallets);
		System.out.println(expectedWallets);
		Assert.assertEquals(actualWallets, expectedWallets);
		if (actualWallets.equals(expectedWallets)) {
			driver.navigate().back();
			Thread.sleep(3000);
		}
	}
	@Test(priority = 6)
	public void validProductInMessagersAndDuffleBags() throws InterruptedException {
		driver.findElement(By.linkText("Messenger & Duffle Bags")).click();
		Thread.sleep(5000);
		ArrayList<String> expectedBags = new ArrayList<String>();
		expectedBags.add("ADK Red color Sling-Messenger Bag-AD-BAG-001");
		expectedBags.add("ADK Black color Silb-Messenge Bag-AD-BAG-002");
		expectedBags.add("ADK Tan color Silng-Messenge Bag-AD-BAG-003");
		expectedBags.add("ADK Dark Blue color Silng-Messenge Bag-");
		ArrayList<String> actualBags = new ArrayList<String>();
		List<WebElement> list = driver.findElements(By.xpath("//p[@class=\"text-xs truncate text-gray-600 leading-6 mb-2\"]"));
		for (WebElement element : list) {
			String text = element.getText();
			actualBags.add(text);
		}
		System.out.println(actualBags);
		System.out.println(expectedBags);
		Assert.assertEquals(actualBags, expectedBags);
		if (actualBags.equals(expectedBags)) {
			driver.navigate().back();
		}
	}
	@Test(priority = 7)
	public void validKitchenTools() throws InterruptedException {
		driver.findElement(By.linkText("Kitchen Tools")).click();
		Thread.sleep(5000);
		ArrayList<String> expectedTools = new ArrayList<String>();
		expectedTools.add("Stainless Steel Oil Dropper, 1 Liter, Silver");
		ArrayList<String> actualTools = new ArrayList<String>();
		WebElement list = driver.findElement(By.xpath("//p[@class=\"text-xs truncate text-gray-600 leading-6 mb-2\"]"));
		String text = list.getText();
		actualTools.add(text);
		System.out.println(actualTools);
		System.out.println(expectedTools);
		Assert.assertEquals(actualTools, expectedTools);
		if (actualTools.equals(expectedTools)) {
			driver.navigate().back();
		}
	}
	@Test(priority = 8)
	public void loginUsingExcel()throws Exception{
	driver.findElement(By.xpath("//div[text()='Men']")).click();
	Thread.sleep(5000);
	driver.findElement(By.xpath("//div[text()='Footwear']")).click();
	Actions act=new Actions(driver);
	act.moveToElement(driver.findElement(By.xpath("//a[text()='Casual Shoes']"))).click().perform();
	Thread.sleep(5000);
	driver.findElement(By.xpath("//img[@alt='Men Blue Slip-On Canvas Casual Shoes']")).click();
	Thread.sleep(5000);
	driver.findElement(By.xpath("//button[text()='UK6']")).click();
	Thread.sleep(5000);
	driver.findElement(By.xpath("//button[@class='sc-kGXeez sc-ksYbfQ kvajiu']")).click();
	Thread.sleep(5000);//by now
	driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("8975237654");
	driver.findElement(By.xpath("//button[text()='Send OTP']")).click();
	Thread.sleep(30000);
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	Thread.sleep(15000);
	driver.findElement(By.xpath("//a[@class='sc-kGXeez sc-hIVACf itkzsS']")).click();
	Thread.sleep(15000);//pay rs.
	driver.findElement(By.xpath("//button[text()='Add New Address']")).click();
	Thread.sleep(5000);//address click
	for(int i=1;i<2;i++){
	driver.findElement(By.id("name")).sendKeys(value.readCell("LoginDataJBK.xls","Sheet1",i, 0));
	Thread.sleep(5000);
	driver.findElement(By.id("mobile")).sendKeys(value.readCell("LoginDataJBK.xls","Sheet1",i,1));
	Thread.sleep(5000);
	driver.findElement(By.id("email")).sendKeys(value.readCell("LoginDataJBK.xls","Sheet1",i,2));
	Thread.sleep(5000);
	driver.findElement(By.id("houseNo")).clear();
	driver.findElement(By.id("houseNo")).sendKeys(value.readCell("LoginDataJBK.xls","Sheet1",i,3));
	Thread.sleep(5000);
	driver.findElement(By.id("streetAddress")).sendKeys(value.readCell("LoginDataJBK.xls","Sheet1",i,4));
	Thread.sleep(5000);
	driver.findElement(By.id("pincode")).sendKeys(value.readCell("LoginDataJBK.xls","Sheet1",i,5));
	Thread.sleep(5000);
	driver.findElement(By.xpath("//button[text()='Save Address']")).click();
	System.out.println("Address saved successfully");
	driver.navigate().to("https://myshopprime.com/suhas.dhanorkar1/gAF4lS8/categories");
	Thread.sleep(5000);
	String text=driver.getTitle();
	System.out.println(text);
 	}}
	
	@Test(priority = 9)
	public void productDescription() throws InterruptedException {
		driver.findElement(By.xpath("//div[text()=\"Women\"]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[text()=\"Ethnic Wear\"]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[text()=\"Sarees\"]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//p[text()=\"Blue Printed Georgette Saree\"]")).click();
		Thread.sleep(5000);
		ArrayList<String>expectedDescription = new ArrayList<String>();
		expectedDescription.add("Saree Color : Light Blue, Saree Fabric: Georgette, Saree Length : 5.3 mtr, Saree Work : Printed, Blouse Color : Blue, Blouse Fabric : Georgette, Blouse Length : 0.7 mtr, Blouse Work : Printed, Weight Kgs : 0.4, Occasion : Casual,party,wedding");
		ArrayList<String>actualDescription = new ArrayList<String>();
		WebElement list = driver.findElement(By.xpath("//span[text()=\"Saree Color : Light Blue, Saree Fabric: Georgette, Saree Length : 5.3 mtr, Saree Work : Printed, Blouse Color : Blue, Blouse Fabric : Georgette, Blouse Length : 0.7 mtr, Blouse Work : Printed, Weight Kgs : 0.4, Occasion : Casual,party,wedding\"]"));
			String text = list.getText();
			actualDescription.add(text);
			System.out.println(actualDescription);
			System.out.println(expectedDescription);
			Assert.assertEquals(actualDescription, expectedDescription);
			if(actualDescription.equals(expectedDescription)) {
				driver.navigate().back();
				driver.navigate().back();
		}      	
	}
	public void waitForElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	@AfterSuite
	public void BrowserClose() {
		driver.close();
	}
}