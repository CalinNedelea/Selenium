import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.annotation.WillClose;
import java.time.Duration;

public class FacebookLoginTest {
    private WebDriver driver;


    @BeforeClass
    public  void setup(){
        System.setProperty("web-driver.chrome.driver",
                "C:\\Users\\alexa\\Desktop\\Curs testare\\Curs 17\\chromedriver_win32\\chromeDriver.exe");
        driver = new ChromeDriver();
    }
    @Test
    public void testFacebookLogin(){
        driver.get("https://www.facebook.com");

        try{
            WebElement acceptaAllCookiesBtn = new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.elementToBeClickable(By.xpath("//button" +
                            "[contains(., 'Allow')]")));
            acceptaAllCookiesBtn.click();
        }catch (Exception e){
            System.out.println("Cookie banner not or could not be interacted with.");
        }

        driver.findElement(By.id("email")).sendKeys("your_facebook_email");
        driver.findElement(By.id("pass")).sendKeys("your_facebook_password");
        driver.findElement(By.name("login")).click();

        WebElement element = driver.findElement(By.linkText("Find your account and log in."));
        Assert.assertEquals(true, element.isDisplayed());

        driver.quit();
    }
}
