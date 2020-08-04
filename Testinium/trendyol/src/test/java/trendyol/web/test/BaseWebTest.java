package trendyol.web.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import config.TestConfig;

public class BaseWebTest {

    public WebDriver driver;
    public WebDriverWait wait;

    private RemoteWebDriver createBrowserParameter(String browser) {
        if (browser.equals("chrome")) {
            return new ChromeDriver();
        } else if (browser.equals("firefox")) {
            return new FirefoxDriver();
        } else {
            throw new IllegalArgumentException("Browser parameter can be either 'chrome' or 'firefox' not anything else");
        }
    }

    @BeforeClass
    public void setup() {
        driver = createBrowserParameter(TestConfig.getProperty("browser"));
        wait = new WebDriverWait(driver, 15);
        driver.manage().window().maximize();
    }

    
    
	
	  @AfterClass public void teardown() { driver.quit(); }
	 

}
