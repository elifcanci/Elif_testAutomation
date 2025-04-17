package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CheckoutPage {
    WebDriver driver;

    By proceedToCheckoutBtn = By.xpath("//a[contains(text(),'Proceed To Checkout')]");
    By placeOrderBtn = By.xpath("//a[contains(text(),'Place Order')]");
    By nameOnCardInput = By.name("name_on_card");
    By cardNumberInput = By.name("card_number");
    By cvcInput = By.name("cvc");
    By expiryMonthInput = By.name("expiry_month");
    By expiryYearInput = By.name("expiry_year");
    By payAndConfirmBtn = By.xpath("//button[@data-qa='pay-button']");
    By orderSuccessMessage = By.xpath("//p[contains(text(),'Congratulations! Your order has been confirmed!')]");
    By downloadInvoiceBtn = By.xpath("//a[contains(text(),'Download Invoice')]");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickElementAfterHidingIframe(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            ((JavascriptExecutor) driver)
                    .executeScript("document.getElementById('aswift_1').style.display='none'");
        } catch (Exception e) {
            System.out.println("Iframe gizlenemedi veya bulunamadı.");
        }

        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public void proceedToCheckout() {
        clickElementAfterHidingIframe(proceedToCheckoutBtn);
    }

    public void clickPlaceOrder() {
        clickElementAfterHidingIframe(placeOrderBtn);
    }

    public void fillPaymentDetails() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(nameOnCardInput)).sendKeys("Egem Test");
        wait.until(ExpectedConditions.visibilityOfElementLocated(cardNumberInput)).sendKeys("1234 5678 9012 3456");
        wait.until(ExpectedConditions.visibilityOfElementLocated(cvcInput)).sendKeys("123");
        wait.until(ExpectedConditions.visibilityOfElementLocated(expiryMonthInput)).sendKeys("12");
        wait.until(ExpectedConditions.visibilityOfElementLocated(expiryYearInput)).sendKeys("2026");
    }


    public void confirmOrder() {
        driver.findElement(payAndConfirmBtn).click();
    }

    public boolean isOrderPlaced() {
        return driver.findElement(orderSuccessMessage).isDisplayed();
    }

    public void downloadInvoice() {
        driver.findElement(downloadInvoiceBtn).click();
    }
}
