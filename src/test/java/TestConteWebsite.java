import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestConteWebsite {
    public static void main(String args[]) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://conteshop.by/");
        WebElement searchInputElement = driver
                .findElement(By
                        .xpath("/html/body/div[4]/div[2]/div[1]/div/div[2]/div[3]/noindex/form/input[1]"));
        searchInputElement.sendKeys("Юбка");
        searchInputElement.click();
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[4]/div[2]/div[1]/div/div[2]/div[3]/noindex/form/input[2]")));
        searchInputElement.sendKeys(Keys.ENTER);
        Thread.sleep(5000);
        driver.quit();
    }
}
