package stepdefs;

import base.BaseTest;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pages.*;
import utils.DriverFactory;

public class SignupSteps extends BaseTest {

    WebDriver driver;
    HomePage homePage;
    AccountCreationPage accountCreationPage;
    LoginPage loginPage;

    public SignupSteps() {
        driver = DriverFactory.getDriver();
        homePage = new HomePage(driver);
        accountCreationPage = new AccountCreationPage(driver);
        loginPage = new LoginPage(driver);
    }

    @Given("Kullanıcı anasayfaya gider")
    public void kullaniciAnasayfayaGider() {
        homePage.goToHomePage();
    }

    @When("Kullanıcı 'Signup Login' sekmesine tıklar")
    public void signupLoginButonunaTiklar() {
        homePage.clickSignupLogin();
    }

    @And("Kullanıcı ad olarak {string}, email olarak {string} girer")
    public void kullaniciAdVeEmailGirer(String name, String email) {
        loginPage.enterSignupInfo(name, email);
    }

    @And("Kullanıcı 'Signup' butonuna tıklar")
    public void signupButonunaTiklar() {
        loginPage.clickSignupButton();
    }

    @And("Kullanıcı bilgilerini doldurur ve hesabı oluşturur")
    public void kullaniciBilgileriDoldurur() {
        AccountCreationPage accountCreationPage = new AccountCreationPage(driver); // Bu sınıfı ayrıca oluşturacağız.
        accountCreationPage.createNewAccount(
                "egem12",       // password
                "Egem",                  // first name
                "Test",                  // last name
                "Egemsoft Mahallesi",    // address
                "India",                 // country
                "Ontario",               // state
                "Toronto",               // city
                "M4B1B3",                // zip
                "5555555555"             // mobile
        );
    }

    @Then("Hesabın başarıyla oluşturulduğu mesajı görülür")
    public void hesapBasariylaOlustu() {
        AccountCreationPage accountCreationPage = new AccountCreationPage(driver);
        assert accountCreationPage.isAccountCreated();
    }
}
