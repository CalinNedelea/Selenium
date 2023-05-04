import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Curs17 {
    public String baseUrl = "http://www.browserstack.com/";

    String driverPath = "\"C:\\Users\\alexa\\Desktop\\Curs testare\\Curs17\\chromedriver_win32\"";

    public WebDriver driver;

    @BeforeTest
    public void launchBrowser(){
        System.out.println("lauching Chrome browser");
        System.setProperty("webDriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.get(baseUrl);
    }
    @Test
    public void verifyHomepageTitle(){
        String expectedTitle = "Most Reliable App & Cross Browser Testing Platform | BrowserStack";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }
    @AfterTest
    public void terminateBrowser(){
        driver.close();
    }
}
