package com.TestCategoriesPage;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RemainingfailedTest {
WebDriver driver;	
	@Test(priority = 3)
	public void checkShopByTopCategories() {
		List<WebElement> list = driver.findElements(By.xpath("//a[@class=\"block rounded border border-solid border-gray-300 text-xs p-2 mr-2 mb-2\"]"));
		for (WebElement element : list) {
			String text = element.getText();
			System.out.println(text);
			if (text.contains("Kitchen Tools")) {
				System.out.println(element.getText());
				Assert.assertEquals("Kitchen Tools", element.getText());
				break;
			}
		}
	}
	@Test(priority = 7)
	public void validProductInActiveWear() throws InterruptedException {
		driver.findElement(By.linkText("Active Wear")).click();
		Thread.sleep(5000);
		ArrayList<String> listProduct = new ArrayList<String>();
		listProduct.add("Cotton Spandex Tracksuit For Women's");
		listProduct.add("Trendy Cotton Track Pant With T Shirt");
		listProduct.add("Stylish Cotton Rib Stretchable Color Blocked Trach Suit For Women");
		listProduct.add("Stylish Cotton Rib Stretchable Color Blocked Trach Suit For Women");
		listProduct.add("Stylish Cotton Rib Stretchable Multicolored Track Suit For Women");
		listProduct.add("Stylish Cotton Rib Stretchable Multicolored Track Suit For Women");
		System.out.println(listProduct);
		ArrayList<String> expectedList=listProduct;
		List<WebElement>list=driver.findElements(By.xpath("//p[contains(text(),\"Cotton Spandex Tracksuit For Women's\") or contains(text(),\"Trendy Cotton Track Pant With T Shirt\") or contains(text(),\"Stylish Cotton Rib Stretchable Color Blocked Trach Suit For Women\") or contains(text(),\"Stylish Cotton Rib Stretchable Color Blocked Trach Suit For Women\") or contains(text(),\"Stylish Cotton Rib Stretchable Multicolored Track Suit For Women\")]"));
		for(WebElement element : list) {
			Thread.sleep(3000);
			String actualList=element.getText();
			System.out.println(actualList);
				Assert.assertEquals(actualList, expectedList);
				if(actualList.equals(expectedList)) {
					driver.navigate().back();
					break;
				}
			}
		}
	@Test(priority = 8)
	public void checkValidMensProducts() throws InterruptedException {
		driver.findElement(By.xpath("//div[text()=\"Men\"]")).click();
		List<WebElement>list=driver.findElements(By.xpath("//div[contains(text(),'Topwear') or contains(text(),'Bottomwear') or contains(text(),'Footwear') or contains(text(),'Winter Wear') or contains(text(),'Watches & Wearables') or contains(text(),'Bags & Wallets') or contains(text(),'Accessories')]"));
		for(WebElement element :list) {
			String text = element.getText();
			System.out.println(text);
			if(text.contains("Accessories")) {
				System.out.println(element.getText());
				String actualList=element.getText();
				String expectedIteration="Accessories";
				Assert.assertEquals(expectedIteration, actualList);	
			}
			
		}
	}
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
	
}
