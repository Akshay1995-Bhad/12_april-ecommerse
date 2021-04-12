package com.myprimeshop.object.Repository;



import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class catagoriesPageObjectRepository {

	@FindBy(xpath="//button[@class=\"focus:outline-none border-0 p-2\"]")
	public WebElement closeAdd;
   
	@FindBy(xpath="//p[text()=\"Categories\"]")
	public WebElement clickCategories;
	
	/*@FindBy(xpath="//div[text()='" + name + "']")
	public WebElement categories;
	
	@FindBy(xpath="//a[text()='" + name + "']")
	public WebElement topCatagories;*/
	
	@FindBy(xpath="//div[text()=\"Women\"]")
	public WebElement womwnclick;
	
	/*@FindBy(xpath="//div[text()='\" + products + \"']")
	public WebElement womensProducts;*/
	
	@FindBy(linkText="Wallets")
	public WebElement walletClick;
	
	/*@FindBy(xpath="//p[text()='\" + wallets + \"']")
	public WebElement wallet;*/
	
	@FindBy(linkText="Messenger & Duffle Bags")
	public WebElement firstCategories;
	
	@FindBy(xpath="//p[@class=\"text-xs truncate text-gray-600 leading-6 mb-2\"]")
	public List<WebElement> bagElement;
	
	@FindBy(linkText="Kitchen Tools")
	public WebElement secondCategoiries;
	
	@FindBy(xpath="//p[@class=\"text-xs truncate text-gray-600 leading-6 mb-2\"]")
	public WebElement kitchenTool;
	
	@FindBy(xpath="//div[text()='Men']")
	public WebElement menClick;
	
	@FindBy(xpath="//div[text()='Footwear']")
	public WebElement footClick;
	
	@FindBy(xpath="//a[text()='Casual Shoes']")
	public WebElement casualClick;
	
	@FindBy(xpath="//img[@alt='Men Blue Slip-On Canvas Casual Shoes']")
	public WebElement shoesclick;
	
	@FindBy(xpath="//button[text()='UK6']")
	public WebElement buttonClick;
	
	@FindBy(xpath="//button[@class='sc-kGXeez sc-ksYbfQ kvajiu']")
	public WebElement nextbuttonClick;
	
	@FindBy(xpath="//input[@name='phone']")
	public WebElement phoneClick;
	
	@FindBy(xpath="//button[text()='Send OTP']")
	public WebElement OTPClick;
	
	@FindBy(xpath="//button[@type='submit']")
	public WebElement submitClick;
	
	@FindBy(xpath="//a[@class='sc-kGXeez sc-hIVACf itkzsS']")
	public WebElement anothClick;
	
	@FindBy(xpath="//button[text()='Add New Address']")
	public WebElement addressClick;
	
	@FindBy(id="name")
	public WebElement nameElement;
	
	@FindBy(id="mobile")
	public WebElement mobileElement;
	
	@FindBy(id="email")
	public WebElement emailElement;
	
	@FindBy(id="houseNo")
	public WebElement houseNoElement;
	
	@FindBy(id="streetAddress")
	public WebElement streetaddressElement;
	
	@FindBy(id="pincode")
	public WebElement pincodeElement;
	
	@FindBy(xpath="//button[text()='Save Address']")
	public WebElement saveClick;
	
	@FindBy(xpath="//div[text()=\"Ethnic Wear\"]")
	public WebElement ethicwearClick;
	
	@FindBy(xpath="//a[text()=\"Sarees\"]")
	public WebElement sareeClick;
	
	@FindBy(xpath="//p[text()=\"Blue Printed Georgette Saree\"]")
	public WebElement bluesareeClick;
	
	@FindBy(xpath="//span[text()=\"Saree Color : Light Blue, Saree Fabric: Georgette, Saree Length : 5.3 mtr, Saree Work : Printed, Blouse Color : Blue, Blouse Fabric : Georgette, Blouse Length : 0.7 mtr, Blouse Work : Printed, Weight Kgs : 0.4, Occasion : Casual,party,wedding\"]")
	public WebElement sareeColor;
}
