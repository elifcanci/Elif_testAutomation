package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    By SignupNameInput = By.xpath("//input[@name='name']");
    By SignupEmailInput = By.xpath("//input[@data-qa='signup-email']");
    By signupBtn = By.xpath("//button[@data-qa='signup-button']");
    By loginEmailInput = By.xpath("//input[@data-qa='login-email']");
    By loginPasswordInput = By.xpath("//input[@data-qa='login-password']");
    By loginBtn = By.xpath("//button[@data-qa='login-button']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterSignupInfo(String name, String email) {
        driver.findElement(SignupNameInput).sendKeys(name);
        driver.findElement(SignupEmailInput).sendKeys(email);
    }

    public void clickSignupButton() {
        driver.findElement(signupBtn).click();
    }

    public void login(String email, String password) {
        driver.findElement(loginEmailInput).sendKeys(email);
        driver.findElement(loginPasswordInput).sendKeys(password);
        driver.findElement(loginBtn).click();
    }
}
