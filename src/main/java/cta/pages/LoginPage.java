package cta.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.swing.JPasswordField;

import org.jboss.aerogear.security.otp.Totp;


public class LoginPage {
    // Variables
    private WebDriver driver;



    // Locators
    @FindBy(xpath = "//input[@id='identifierId']")
    public WebElement emailGoogleLocator;

    @FindBy(xpath = "//div[@id='identifierNext']//button")
    public WebElement nextEmailGoogleButtonLocator;

    @FindBy(xpath = "//input[@name='Passwd']")
    public WebElement passwordGoogleLocator;

    @FindBy(xpath = "//div[@id='passwordNext']//button")
    public WebElement nextPasswordGoogleButtonLocator;

    @FindBy(xpath = "//input[@name='totpPin']")
    public WebElement enterCodeFieldLocator;

    @FindBy(xpath = "//div[@id='totpNext']//button")
    public WebElement nextAuthCodeGoogleButtonLocator;

    // Constructor

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Methods
    
   

    public void enterGoogleAuthenticatiorCode(WebDriver driver,String googleSecretKey){
        WebElement element = enterCodeFieldLocator;
		Totp totp = new Totp(googleSecretKey);
		String verificationCode = totp.now();
        element.clear();
        element.sendKeys(verificationCode);
        System.out.println("Authentication Code is entered!");
    }

    public void clickGoogleAuthenticatorCodeNextButton(WebDriver driver){
        WebElement element = nextAuthCodeGoogleButtonLocator;
        element.click();
        System.out.println("Next Auth Code clicked!");
    }


    public void clickNextPasswordGoogle(WebDriver driver){
        WebElement element = nextPasswordGoogleButtonLocator;
        element.click();
        System.out.println("Next password clicked!");
    }

    public void enterPasswordGoogle(WebDriver driver,String password) {
        WebElement element = passwordGoogleLocator;
        element.clear();
        element.sendKeys(password);
        String enteredValue = element.getAttribute("value");
        if (enteredValue.equals(password)) {
            System.out.println("Password entered successfully.");
        } else {
            System.out.println("Password entry failed. ");
        }
    }

    public void clickNextEmailGoogle(WebDriver driver){
        WebElement element = nextEmailGoogleButtonLocator;
        element.click();
        System.out.println("Next Email clicked!");
    }

    public void enterEmailGoogle(WebDriver driver,String username) {
        WebElement element = emailGoogleLocator;
        element.clear();
        element.sendKeys(username);
        String enteredValue = element.getAttribute("value");
        if (enteredValue.equals(username)) {
            System.out.println("Email entered successfully.");
        } else {
            System.out.println("Email entry failed. ");
        }
    }

    public void navigate() {
    driver.get("https://accounts.google.com/");
    }

    
}
