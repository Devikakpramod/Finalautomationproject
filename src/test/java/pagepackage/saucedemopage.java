package pagepackage;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import basepackage.basecls;  // Import basecls to access the screenshot method

public class saucedemopage {
    WebDriver driver;
    basecls baseClass;  // Declare a reference to basecls

    @FindBy(xpath="//*[@id=\"user-name\"]")
    WebElement Suaceusername;
    
    @FindBy(xpath="//*[@id=\"password\"]")
    WebElement Saucepassword;
    
    @FindBy(xpath="//*[@id=\"login-button\"]")
    WebElement Sauceloginclick;

    @FindBy(xpath="//*[@id=\"add-to-cart-sauce-labs-backpack\"]")
    WebElement Saucebackpack;

    @FindBy(xpath="//*[@id=\"add-to-cart-sauce-labs-bike-light\"]")
    WebElement Saucebikelight;

    @FindBy(xpath="//*[@id=\"add-to-cart-sauce-labs-bolt-t-shirt\"]")
    WebElement Saucebolttshirt;

    @FindBy(xpath="//*[@id=\"add-to-cart-sauce-labs-fleece-jacket\"]")
    WebElement Saucefleecejacket;

    @FindBy(xpath="//*[@id=\"add-to-cart-sauce-labs-onesie\"]")
    WebElement Sauceonesie;

    @FindBy(xpath="//*[@id=\"add-to-cart-test.allthethings()-t-shirt-(red)\"]")
    WebElement Saucetshirtred;

    @FindBy(xpath="//*[@id=\"shopping_cart_container\"]/a")
    WebElement Sauceclickcart;

    @FindBy(xpath="//*[@id=\"checkout\"]")
    WebElement Sauceclickcheckout;

    @FindBy(xpath="//*[@id=\"first-name\"]")
    WebElement Saucefirstname;

    @FindBy(xpath="//*[@id=\"last-name\"]  ")
    WebElement Saucelastname;

    @FindBy(xpath="//*[@id=\"postal-code\"]")
    WebElement Saucezipcode;

    @FindBy(xpath="//*[@id=\"continue\"]")
    WebElement Saucecontinue;

    @FindBy(xpath="//*[@id=\"cancel\"]")
    WebElement Saucecancel;

    @FindBy(xpath="//*[@id=\"react-burger-menu-btn\"]")
    WebElement Saucehamburger;

    @FindBy(xpath="//*[@id=\"logout_sidebar_link\"]")
    WebElement Saucelogout;

    public saucedemopage(WebDriver driver) {
        this.driver = driver;
        this.baseClass = new basecls(); // Initialize basecls
        PageFactory.initElements(driver, this);
    }

    public void setValues(String Username, String Password) {
        Suaceusername.sendKeys(Username);
        Saucepassword.sendKeys(Password);
        baseClass.takeScreenshot("LoginPage"); // Call screenshot method from basecls
       
    }
    
    
    

    public void clickLoginButton() {
        Sauceloginclick.click();
        baseClass.takeScreenshot("AfterLogin"); // Take screenshot after login click
    }

    public void addingToCart() {
        Saucebackpack.click();
        Saucebikelight.click();
        Saucebolttshirt.click();
        Saucefleecejacket.click();
        Sauceonesie.click();
        Saucetshirtred.click();
        baseClass.takeScreenshot("AfterAddingToCart"); // Take screenshot after adding to cart
    }

    public void clickCart() {
        Sauceclickcart.click();
        baseClass.takeScreenshot("CartPage"); // Take screenshot of the cart page
    }

    public void clickCheckout() {
        Sauceclickcheckout.click();
        baseClass.takeScreenshot("CheckoutPage"); // Take screenshot of the checkout page
    }

    public void setValues2(String FirstName, String LastName, String ZipCode) {
        Saucefirstname.sendKeys(FirstName);
        Saucelastname.sendKeys(LastName);
        Saucezipcode.sendKeys(ZipCode);
        baseClass.takeScreenshot("PersonalDetailsPage"); // Screenshot of personal details
    }

    public void clickContinue() {
        Saucecontinue.click();
        baseClass.takeScreenshot("AfterContinue"); // Screenshot after continue
    }

    public void clickCancel() {
        Saucecancel.click();
        baseClass.takeScreenshot("AfterCancel"); // Screenshot after cancel
    }

    public void clickHamburger() {
        Saucehamburger.click();
        baseClass.takeScreenshot("HamburgerMenu"); // Screenshot of the hamburger menu
    }

    public void clickLogout() {
        Saucelogout.click();
        baseClass.takeScreenshot("LoggedOut"); // Screenshot after logging out
    }
    
    
    public void handleLoginAlert() {
        try {
            // Wait for the alert to be present 
            Alert alert = driver.switchTo().alert();
            
            // Retrieve alert text and print it
            String alertText = alert.getText();
            System.out.println("Alert Text: " + alertText);
            
            // Accept the alert
            alert.accept();
            
            
        } catch (Exception e) {
            System.out.println("No alert found.");
        }
    }
}

