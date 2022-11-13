import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class TestNGConteWebsite {
    @Test
    public void commonSearchTermResultsNotEmpty() {
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

        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By
                        .xpath("/html/body/div[5]/div[6]/div/div[2]/div/div[2]/div[3]/div[2]/div/div")));  // мы ждем, пока не появятся все элементы с таким локатором

        // подсчитать количество элементов в списке результатов поиска:
        List<WebElement> searchResults = driver
                 .findElements(By.xpath("/html/body/div[5]/div[6]/div/div[2]/div/div[2]/div[3]/div[2]/div/div"));
        System.out.println("Search results number for requested term: " + searchResults.size());
        Assert.assertTrue(searchResults.size() > 0, "Search results are empty!");
        driver.quit();

    }
}
