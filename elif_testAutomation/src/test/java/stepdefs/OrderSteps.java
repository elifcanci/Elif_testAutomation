package stepdefs;

import base.BaseTest;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pages.*;
import utils.DriverFactory;

public class OrderSteps extends BaseTest {

    WebDriver driver;
    HomePage homePage;
    LoginPage loginPage;
    ProductPage productPage;
    CheckoutPage checkoutPage;

    public OrderSteps() {
        driver = DriverFactory.getDriver();
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
        checkoutPage = new CheckoutPage(driver);
    }

    @Given("Kullanıcı anasayfadadır")
    public void kullaniciAnasayfayaGider() {
        homePage.goToHomePage();
    }

    @When("Kullanıcı 'Login' butonuna tıklar")
    public void signupLoginButonunaTiklar() {
        homePage.clickSignupLogin();
    }

    @When("Kullanıcı email olarak {string} ve şifre olarak {string} girip giriş yapar")
    public void kullaniciGirisYapar(String email, String password) {
        loginPage.login(email, password);
    }

    @When("Kullanıcı ürün sayfasına gider ve bir ürün sepete ekler")
    public void urunSepeteEkle() {
        productPage.goToProductPage();
        productPage.addFirstProductToCart();
    }

    @When("Kullanıcı sepeti görüntüler ve ödeme aşamasına geçer")
    public void sepeteGit() {
        productPage.clickViewCart();
        checkoutPage.proceedToCheckout();
        checkoutPage.clickPlaceOrder();
    }

    @When("Kullanıcı ödeme bilgilerini doldurur ve siparişi tamamlar")
    public void odemeYap() {
        checkoutPage.fillPaymentDetails();
        checkoutPage.confirmOrder();
    }

    @Then("Siparişin başarıyla verildiği mesajı görüntülenir")
    public void siparisBasarili() {
        assert checkoutPage.isOrderPlaced();
    }

    @When("Kullanıcı 'Download Invoice' butonuna tıklar")
    public void faturayiIndir() {
        checkoutPage.downloadInvoice();
    }

    @Then("'invoice.txt' dosyasının indirildiği doğrulanır")
    public void invoiceKontrol() {
        String userHome = System.getProperty("user.home");
        String downloadPath = userHome + "/Downloads/invoice.txt";
        java.io.File file = new java.io.File(downloadPath);
        assert file.exists() : "Fatura dosyası bulunamadı!";
    }
}
