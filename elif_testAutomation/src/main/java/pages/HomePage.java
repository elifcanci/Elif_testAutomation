package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    By signupLoginBtn = By.xpath("//a[contains(text(),'Signup / Login')]");
    By loggedInText = By.xpath("//a[contains(text(),'Logged in as')]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToHomePage() {
        driver.get("https://www.automationexercise.com/");
    }

    public void clickSignupLogin() {
        driver.findElement(signupLoginBtn).click();
    }

    public boolean isUserLoggedIn() {
        return driver.findElement(loggedInText).isDisplayed();
    }
}
