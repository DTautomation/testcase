package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import base.BasePage;
import io.qameta.allure.Step;

public class PricePage extends BasePage {
	
	private String xPathPriceProductPage = "div.pd-app-container div.pr-cn:nth-child(2) div.pr-cn-in div.pr-in-w div.pr-in-cn div.pr-bx-w div.pr-bx-dsc div.pr-bx-pr-dsc div:nth-child(2) > span.prc-dsc";
	private String xPathPriceBasketPage = "//dd[@class='total-price']";
	private String xPathBasketIcon = "//i[@class='icon navigation-icon-basket']";
	private String xPathIncreaseProduct = "//body//button[2]";
	private String xPathNumberOfProducts="//input[@class='counter-content']";
	private String xPathDeleteCart ="//body/div[@id='container']/div[@class='wrapper']/div[contains(@class,'col-lg-12 col-md-12 col-xs-12')]/section[@id='basketTemplate']/section[@id='basketContent']/div/div[@id='partial-basket']/div[@class='pb-wrapper']/div[@class='pb-merchant-group']/div[@class='pb-basket-item']/div[@class='pb-basket-item-actions']/button[1]";
	private String xPathConfirmDelete = "//span[contains(text(),'Sil')]";
	
	public PricePage(WebDriver driver, WebDriverWait wait) {
	        super(driver, wait);
	    }
	
  	  
	  @Step("Compare price")
	    public void comparePrice() throws InterruptedException {
		  
		
    String priceProduct1 = driver.findElement(By.cssSelector(xPathPriceProductPage)).getText();

	System.out.println("Ürün sayfasındaki fiyatı : " + priceProduct1);
		
	
    WebElement webElement = driver.findElement(By.xpath(xPathBasketIcon));
    ((JavascriptExecutor) driver)
    .executeScript("window.scrollTo(250, 0)");
    
    webElement.click();
    
    String priceProduct2 = driver.findElement(By.xpath(xPathPriceProductPage)).getText();
	
	System.out.println("Basket sayfasındaki fiyatı : " + priceProduct2);
	
	if(priceProduct1.equals(priceProduct2))
	{
		System.out.println("Ürün fiyatları doğru");
	}
	else 
	{
		System.out.println("Ürün Fiyatları hatalı");
	}

	    }
	  
	  @Step("Increase Product")
	    public void increaseProduct() throws InterruptedException {
		  
		  driver.findElement(By.xpath(xPathBasketIcon)).click();;
		  
		  
 
	    }
	  
	  
	  @Step("Increase Product")
	    public void controlNumberProduct() throws InterruptedException {
		  
		    String NumberofProducts = driver.findElement(By.xpath(xPathNumberOfProducts)).getText();

		    System.out.println(NumberofProducts);
		    
	        String ExpectedTitle = "2" ;
	        
	        Assert.assertEquals(NumberofProducts,ExpectedTitle);


	    }
	  
	  @Step("Delete Cart")
	    public void DeleteCart() throws InterruptedException {
		  
		   driver.findElement(By.xpath(xPathDeleteCart)).click();
		   
		   driver.findElement(By.xpath(xPathConfirmDelete)).click();


	    }
	  
	  @Step("Controle Deleted Cart")
	    public void DeleteCartControle() throws InterruptedException {
		  
		   String NumberofProducts = driver.findElement(By.xpath(xPathNumberOfProducts)).getText();

		   String ExpectedTitle = "0" ;
	        
	       Assert.assertEquals(NumberofProducts, ExpectedTitle);

	    }
	  
	  
	  
	  
}
