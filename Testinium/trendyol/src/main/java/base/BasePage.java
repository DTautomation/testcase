package base;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.google.common.base.Function;

import pages.HomePage;

public abstract class BasePage {

    public WebDriver driver;
    public WebDriverWait wait;
    public final By txtErrorMessage= By.cssSelector(".alert-danger");


    public BasePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    protected void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    protected void fillInput(By locator, String value) {
        WebElement webElement = wait.until(ExpectedConditions.elementToBeClickable(locator));
        webElement.clear();
        webElement.sendKeys(value);

    }

    public void scrollToTop() {
        ((JavascriptExecutor) driver)
                .executeScript("window.scrollTo(0, -document.body.scrollHeight)");
    }
    
    public void scrollToBottom() {
        ((JavascriptExecutor) driver)
                .executeScript("window.scrollTo(0, 250)");
    }


    private void pressSpace() {
        Actions action = new Actions(driver);
        action.sendKeys(Keys.SPACE).build().perform();
    }

    public void pressEnter() {
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).build().perform();
    }
    
    public void waitForPageLoad() {
	    Wait<WebDriver> wait = new WebDriverWait(driver, 10);
	    wait.until(new Function<WebDriver, Boolean>() {
	        public Boolean apply(WebDriver driver) {
	            System.out.println("Current Window State       : "
	                + String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState")));
	            return String
	                .valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"))
	                .equals("complete");
	        }
	    });
	}

 
    

}