package pages;

import base.BasePage;
import config.TestConfig;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;
import java.util.Objects;

public class HomePage extends BasePage {

	public static String webUrl = "https://www.trendyol.com";

    private String boutiquePlaceHolderImageUrl = "https://static.dsmcdn.com/frontend/web/production/large_boutique_placeholder.png";

    private String xPathPopUpCloseButton = "//a[@class='fancybox-item fancybox-close']";
    private String xPathSignInMenu = "//li[@id='accountBtn']";
    private String xPathSignInButton = "//div[@class='account-button login']";
    private String classSignInModalCloseButton = "modal-close";
    private String xPathEmailField = "//input[@id='email']";
    private String xPathPasswordField = "//input[@id='password']";
    private String xPathSignInSubmitButton = "//a[@id='loginSubmit']";
    private String xPathMainTab = "//ul[@class='main-nav']";
    private String classTab = "category-header";
    private String xPathBoutiqueImagesContainer = "//div[@class='component-list component-big-list']";
    private String classBoutiqueImageArticle = "component-item";
    private String xPathRandomBoutique = "//article[1]//a[1]//span[1]//img[1]";
    private String searchField = "//*[@id=\"auto-complete-app\"]/div/div/input";


    public HomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @Step("Opens trendyol.com")
    public void goToTrendyol() {
        driver.get(Objects.requireNonNull(TestConfig.getProperty("web_url")));
        closePopup();
    }
    
	public String getUrl(){
		return webUrl;
	}

    private void closePopup() {
        try {
            click(By.xpath(xPathPopUpCloseButton));
        } catch (Exception ignored) {
        }
    }

    @Step("Clicks sign-in button on homepage")
    public void clickSignInButton(){
        Actions actions = new Actions(driver);
        WebElement webElement = driver.findElement(By.xpath(xPathSignInMenu));
        actions.moveToElement(webElement).build().perform();
        click(By.xpath(xPathSignInButton));
    }

    /*private void pressSpace() {
        Actions action = new Actions(driver);
        action.sendKeys(Keys.SPACE).build().perform();*/

    @Step("Fills search field")
    public void fillSearchField(String search) {
        fillInput(By.xpath(searchField), search);
        pressEnter();
    }

    @Step("Fills email field")
    public void fillEmailField(String email) {
        fillInput(By.xpath(xPathEmailField), email);
    }

    @Step("Fills password field ")
    public void fillPasswordField(String password) {
        fillInput(By.xpath(xPathPasswordField), password);
    }

    @Step("Clicks sign-in button")
    public void clickSignInSubmit() {
        click(By.xpath(xPathSignInSubmitButton));
    }

    @Step("Closes sign-in popUp")
    public void closeSignInPopUp() {
        try {
            click(By.className(classSignInModalCloseButton));
        } catch (Exception ignored) {
        }
    }



    @Step("Clicks tab")
    public void clickTab(int tabIndex) {
        scrollToTop();
        wait.until(ExpectedConditions.elementToBeClickable(
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPathMainTab)))
                        .findElements(By.className(classTab)).get(tabIndex))).click();

    }
    
 
    
}




