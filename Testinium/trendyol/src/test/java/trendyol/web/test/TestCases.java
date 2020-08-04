package trendyol.web.test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import base.BasePage;
import pages.HomePage;
import pages.PricePage;
import pages.ProductPage;
import pages.SearchPage;
import config.TestConfig;

import java.util.Objects;

public class TestCases extends BaseWebTest {

	@Test (priority = 1 )
	@Description("Loaded Page Control")
    @Severity(SeverityLevel.BLOCKER)
	public void homePageControl(){ 
		HomePage homePage=new HomePage(driver, wait);
		driver.get(homePage.getUrl());
		driver.manage().window().maximize();
		homePage.waitForPageLoad();
		driver.get(homePage.getUrl());
	
	}

    @Test(priority = 2)
    @Description("Sign-in success")
    @Severity(SeverityLevel.BLOCKER)
    public void successSignIn() throws InterruptedException {
        HomePage homePage = new HomePage(driver, wait);
        homePage.goToTrendyol();
        homePage.clickSignInButton();
        homePage.fillEmailField(Objects.requireNonNull(TestConfig.getProperty("email")));
        homePage.fillPasswordField(Objects.requireNonNull(TestConfig.getProperty("password")));
        homePage.clickSignInSubmit();
        homePage.closeSignInPopUp();
    }
    
    @Test(priority = 3)
    @Description("Homepage search")
    @Severity(SeverityLevel.MINOR)
    public void search()  {
        HomePage homePage = new HomePage(driver, wait);
        SearchPage searchPage = new SearchPage(driver, wait);
        ProductPage productPage = new ProductPage(driver, wait);
        homePage.goToTrendyol();
        homePage.fillSearchField(Objects.requireNonNull(TestConfig.getProperty("search")));
		/*
		 * searchPage.clicSecondProduct(); productPage.addToBasket();
		 */
    }

  

   

    @Test(priority = 4)
    @Description("Add to cart")
    @Severity(SeverityLevel.BLOCKER)
    public void addToBasket() {
        HomePage homePage = new HomePage(driver, wait);
        SearchPage searchPage = new SearchPage(driver, wait);
        ProductPage productPage = new ProductPage(driver, wait);
        
		/*
		 * homePage.goToTrendyol(); homePage.clickTab(2); homePage.clickAnyBoutique();
		 */
        searchPage.clickAnyProduct();
        ((JavascriptExecutor) driver)
        .executeScript("window.scrollTo(0, 250)");
        productPage.addToBasket();
    }
    
    
    @Test(priority = 5)
    @Description("Compare Prices")
    @Severity(SeverityLevel.BLOCKER)
    public void comparePrices() throws InterruptedException {
        //HomePage homePage = new HomePage(driver, wait);
        PricePage pricePage = new PricePage(driver, wait);
        SearchPage searchPage = new SearchPage(driver, wait);
        HomePage homePage = new HomePage(driver, wait);
        
        pricePage.comparePrice();
        

        //homePage.goToTrendyol();
        //homePage.clickTab(5);
        //homePage.clickAnyBoutique();
     
    }
    
  
    
    @Test(priority = 6)
    @Description("Control number")
    @Severity(SeverityLevel.BLOCKER)
    public void controlNumber() throws InterruptedException {
        //HomePage homePage = new HomePage(driver, wait);
        PricePage pricePage = new PricePage(driver, wait);
        
       pricePage.increaseProduct();
       pricePage.controlNumberProduct();
        
        

        //homePage.goToTrendyol();
        //homePage.clickTab(5);
        //homePage.clickAnyBoutique();
     
    }
    
    @Test(priority = 7)
    @Description("Delete cart and controle")
    @Severity(SeverityLevel.BLOCKER)
    public void deleteAndControl() throws InterruptedException {
        //HomePage homePage = new HomePage(driver, wait);
        PricePage pricePage = new PricePage(driver, wait);
        
       pricePage.DeleteCart();
       
       pricePage.DeleteCartControle();
        
        

        //homePage.goToTrendyol();
        //homePage.clickTab(5);
        //homePage.clickAnyBoutique();
     
    }
    
 

}
