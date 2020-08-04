package pages;

import base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage extends BasePage {

    private String xPathAddToBasketButton = "//div[@class='add-to-bs-tx']";

    public ProductPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @Step("Adds product to basket")
    public void addToBasket() {
        click(By.xpath(xPathAddToBasketButton));
    }


}
