package com.TestCategoriesPage;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.catagoriesPage.categoriesPage;
import com.myprimeshop.testbase.TestBase;
import com.utilities.PropertiesUtility;

public class CategoriesPageTest extends TestBase {
	PropertiesUtility proputils=null;
	SoftAssert sa = new SoftAssert();
	categoriesPage op;
	//categoriesPage op;
	public CategoriesPageTest() {
		super();
	}
	@BeforeSuite
	public void setUp() {
		initialization();
		op = new categoriesPage(driver); 
	}
	@AfterSuite
	public void tearDown() {
		driver.quit();
	}
	@Test(priority = 1)
	public void crossBtn() {
		op.clickCrosebtn();
	}
	@Test(priority = 2)
	public void categoryBtn() {
		op.clickCategoriesBtn();
	}
	@Test(priority = 3)
	public void validTitle() {
		Assert.assertTrue(op.checkTitle());
	}
	@Test(priority = 4)
	public void validCategories() throws InterruptedException {
		Assert.assertTrue(op.checkCatagories());
	}
	@Test(priority = 5)
	public void validByCategoriElement() throws InterruptedException {
		Assert.assertTrue(op.validshopByCatagoriesElement());
	}
	@Test(priority = 6)
	public void validWomenProducts() throws InterruptedException {
		Assert.assertTrue(op.checkValidWomansProduct());
	}
	@Test(priority = 7)
	public void validproductswallet() throws InterruptedException {
		Assert.assertTrue(op.validProductInWallet());
	}
	@Test(priority = 8)
	public void validProductMassagnerDuffle() throws InterruptedException {
		Assert.assertTrue(op.validProductInMessagersAndDuffleBags());
	}
	@Test(priority = 9)
	public void validToolsInKitchen() throws InterruptedException {
		Assert.assertTrue(op.validKitchenTools());
	}
	@Test(priority = 10)
	public void buyProductValid() throws Exception {
		Assert.assertTrue(op.loginUsingExcel());
	}
	@Test(priority = 11)
	public void validproductDescription() throws InterruptedException {
		Assert.assertTrue(op.productDescription());
	}
   
}
	
	
	
