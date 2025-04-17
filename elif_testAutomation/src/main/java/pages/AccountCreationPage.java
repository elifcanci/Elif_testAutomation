package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class AccountCreationPage {
    WebDriver driver;

    public AccountCreationPage(WebDriver driver) {
        this.driver = driver;
    }

    private By passwordInput = By.id("password");
    private By firstNameInput = By.id("first_name");
    private By lastNameInput = By.id("last_name");
    private By addressInput = By.id("address1");
    private By countrySelect = By.id("country");
    private By stateInput = By.id("state");
    private By cityInput = By.id("city");
    private By zipCodeInput = By.id("zipcode");
    private By mobileNumberInput = By.id("mobile_number");
    private By createAccountButton = By.xpath("//button[@data-qa='create-account']");

    public void setPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void setFirstName(String firstName) {
        driver.findElement(firstNameInput).sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        driver.findElement(lastNameInput).sendKeys(lastName);
    }

    public void setAddress(String address) {
        driver.findElement(addressInput).sendKeys(address);
    }

    public void selectCountry(String countryName) {
        Select countryDropdown = new Select(driver.findElement(countrySelect));
        countryDropdown.selectByVisibleText(countryName);
    }

    public void setState(String state) {
        driver.findElement(stateInput).sendKeys(state);
    }

    public void setCity(String city) {
        driver.findElement(cityInput).sendKeys(city);
    }

    public void setZipCode(String zip) {
        driver.findElement(zipCodeInput).sendKeys(zip);
    }

    public void setMobileNumber(String number) {
        driver.findElement(mobileNumberInput).sendKeys(number);
    }

    public void clickCreateAccount() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(createAccountButton));
        element.click();
    }

    public void createNewAccount(String password, String firstName,
                                 String lastName, String address, String country, String state,
                                 String city, String zip, String mobile) {

        setPassword(password);
        setFirstName(firstName);
        setLastName(lastName);
        setAddress(address);
        selectCountry(country);
        setState(state);
        setCity(city);
        setZipCode(zip);
        setMobileNumber(mobile);
    }

    public boolean isAccountCreated() {
        try {
            return driver.findElement(By.xpath("//h2[@data-qa='account-created']")).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
