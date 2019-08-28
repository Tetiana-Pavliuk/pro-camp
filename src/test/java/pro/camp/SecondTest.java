package pro.camp;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SecondTest {
    WebDriver driver;

    @Before
    public void startBrowser() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        //driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
    }

    @After
    public void stopBrowser() {
        driver.quit();
    }

    @Test
    public void test() {
        driver.get("http://demo.litecart.net/admin");

        WebDriverWait wait = new WebDriverWait(driver,120);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("login")));
        driver.findElement(By.name("login")).click();


        List<WebElement> elements = driver.findElements(By.xpath("//div[@id='box-apps-menu-wrapper']//a"));
        for (WebElement paragraph : elements) {
            paragraph.click();
            List<WebElement> subelements = driver.findElements(By.xpath("//div[@id='box-apps-menu-wrapper']/ul//ul//a"));
            for (WebElement subparagraph : subelements) {
                subparagraph.click();
                WebElement h1 = driver.findElement(By.xpath("//h1"));
                Assert.assertTrue(h1.isDisplayed());
            }
            WebElement h1 = driver.findElement(By.xpath("//h1"));
            Assert.assertTrue(h1.isDisplayed());
        }
    }
}
