package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ProductPage {
    WebDriver driver;

    By firstProduct = By.xpath("(//a[@class='btn btn-default add-to-cart'])[1]");
    By viewCartButton = By.xpath("//u[contains(text(),'View Cart')]");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToProductPage() {
        driver.get("https://www.automationexercise.com/products");
    }

    public void addFirstProductToCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            ((JavascriptExecutor) driver).executeScript("document.getElementById('aswift_1').style.display='none'");
        } catch (Exception e) {
            System.out.println("Iframe gizlenemedi veya bulunamadı.");
        }

        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(firstProduct));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public void clickViewCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(viewCartButton));
        element.click();
    }
}
