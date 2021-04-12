package com.catagoriesPage;

import java.io.FileInputStream;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.myprimeshop.object.Repository.catagoriesPageObjectRepository;
import com.myprimeshop.testbase.TestBase;
import com.utilities.JxlExcelSheetUtility;
import com.utilities.PropertiesUtility;
public class categoriesPage extends catagoriesPageObjectRepository {
	FileInputStream fis = null;
	//Properties prop;
	public static Logger log=Logger.getLogger(TestBase.class);
	PropertiesUtility proputils=null;
	WebDriver driver;
	JxlExcelSheetUtility value = new JxlExcelSheetUtility();
	public categoriesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void clickCrosebtn() {
		closeAdd.click();
		log.info("cross btn is clicked");
	}
	public void clickCategoriesBtn() {
		clickCategories.click();
		log.info("category btn is clicked");
	}
	public boolean checkTitle() {
		String actualTitle = driver.getTitle();
		String expectedTitle = "MyShopPrime";
		if (actualTitle.equals(expectedTitle)) {
			log.info("Page title matched::" + actualTitle);
			return true;
		} else {
			log.info("Page title not matched::");
			return false;
		}
	}
	public boolean checkCatagories() throws InterruptedException {
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
		if (actualCategories.equals(expectedCategories)) {
			log.info("Page Header Matched::" + expectedCategories);
			return true;
		} else {
			return false;
		}
	}
	public boolean validshopByCatagoriesElement() throws InterruptedException {
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
		if (ActualList.equals(ExpectedList)) {
		     log.info("Page shp by categories Matched::" + ExpectedList);
			return true;
		} else {
			return false;
		}
	}
	public boolean checkValidWomansProduct() throws InterruptedException {
		womwnclick.click();
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
		if (actualProducts.equals(expectedProducts)) {
			log.info("Page women products is Matched::" + expectedProducts);
			return true;
		} else {
			return false;
		}
	}
	public boolean validProductInWallet() throws InterruptedException {
		walletClick.click();
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
		if (actualWallets.equals(expectedWallets)) {
			driver.navigate().back();
			Thread.sleep(3000);
			log.info("Page product wallet is Matched::" + expectedWallets);
			return true;
		} else {
			return false;
		}
	}
	public boolean validProductInMessagersAndDuffleBags() throws InterruptedException {
		firstCategories.click();
		Thread.sleep(5000);
		ArrayList<String> expectedBags = new ArrayList<String>();
		expectedBags.add("ADK Red color Sling-Messenger Bag-AD-BAG-001");
		expectedBags.add("ADK Black color Silb-Messenge Bag-AD-BAG-002");
		expectedBags.add("ADK Tan color Silng-Messenge Bag-AD-BAG-003");
		expectedBags.add("ADK Dark Blue color Silng-Messenge Bag-");
		ArrayList<String> actualBags = new ArrayList<String>();
		for (WebElement element : bagElement) {
			String text = element.getText();
			actualBags.add(text);
		}
		if (actualBags.equals(expectedBags)) {
			driver.navigate().back();
			Thread.sleep(3000);
			log.info("Page products in messenger and duffles is Matched::" + expectedBags);
			return true;
		} else {
			return false;
		}
	}
	public boolean validKitchenTools() throws InterruptedException {
		secondCategoiries.click();
		Thread.sleep(5000);
		ArrayList<String> expectedTools = new ArrayList<String>();
		expectedTools.add("Stainless Steel Oil Dropper, 1 Liter, Silver");
		ArrayList<String> actualTools = new ArrayList<String>();
		WebElement list = kitchenTool;
		String text = list.getText();
		actualTools.add(text);
		log.info(actualTools);
		log.info(expectedTools);
		if (actualTools.equals(expectedTools)) {
			driver.navigate().back();
			Thread.sleep(3000);
			log.info("Page kitchentool is Matched::" + expectedTools);
			return true;
		} else {
			return false;
		}
	}
	public boolean loginUsingExcel() throws Exception{
		menClick.click();
		Thread.sleep(5000);
		footClick.click();
		Actions act=new Actions(driver);
		act.moveToElement(casualClick).click().perform();
		Thread.sleep(5000);
		shoesclick.click();
		Thread.sleep(5000);
		buttonClick.click();
		Thread.sleep(5000);
		nextbuttonClick.click();
		Thread.sleep(5000);//by now
		phoneClick.sendKeys("8975237654");
		OTPClick.click();
		Thread.sleep(30000);
		submitClick.click();
		Thread.sleep(15000);
		anothClick.click();
		Thread.sleep(15000);//pay rs.
		addressClick.click();
		Thread.sleep(5000);//address click
		for(int i=1;i<2;i++){
		nameElement.sendKeys(value.readCell("LoginDataJBK.xls","Sheet1",i, 0));
		Thread.sleep(5000);
		mobileElement.sendKeys(value.readCell("LoginDataJBK.xls","Sheet1",i,1));
		Thread.sleep(5000);
		emailElement.sendKeys(value.readCell("LoginDataJBK.xls","Sheet1",i,2));
		Thread.sleep(5000);
		houseNoElement.clear();
		houseNoElement.sendKeys(value.readCell("LoginDataJBK.xls","Sheet1",i,3));
		Thread.sleep(5000);
		streetaddressElement.sendKeys(value.readCell("LoginDataJBK.xls","Sheet1",i,4));
		Thread.sleep(5000);
		pincodeElement.sendKeys(value.readCell("LoginDataJBK.xls","Sheet1",i,5));
		Thread.sleep(5000);
		saveClick.click();
		log.info("Address saved successfully");
		driver.navigate().to("https://myshopprime.com/suhas.dhanorkar1/gAF4lS8/categories");
		Thread.sleep(5000);
		String expectedTitle="MyShopPrime";
		String actualTitle=driver.getTitle();
		log.info(actualTitle);
		log.info(expectedTitle);
		if (actualTitle.equals(expectedTitle)) {	
			log.info("Page Header Matched::" + expectedTitle);
			return true;
		} else {
		}}
		return false;
	}
	public boolean productDescription() throws InterruptedException {
		womwnclick.click();
		Thread.sleep(5000);
		ethicwearClick.click();
		Thread.sleep(5000);
		sareeClick.click();
		Thread.sleep(5000);
		bluesareeClick.click();
		Thread.sleep(5000);
		ArrayList<String>expectedDescription = new ArrayList<String>();
		expectedDescription.add("Saree Color : Light Blue, Saree Fabric: Georgette, Saree Length : 5.3 mtr, Saree Work : Printed, Blouse Color : Blue, Blouse Fabric : Georgette, Blouse Length : 0.7 mtr, Blouse Work : Printed, Weight Kgs : 0.4, Occasion : Casual,party,wedding");
		ArrayList<String>actualDescription = new ArrayList<String>();
		WebElement list = sareeColor;
			String text = list.getText();
			actualDescription.add(text);
			log.info(actualDescription);
			log.info(expectedDescription);
			
			if (actualDescription.equals(expectedDescription)) {
				driver.navigate().back();
				Thread.sleep(3000);
				driver.navigate().back();
				Thread.sleep(3000);
				log.info("Page Header Matched::" + expectedDescription);
				return true;
			} else {
				return false;
			}
		} 	
	public void waitForElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
}
