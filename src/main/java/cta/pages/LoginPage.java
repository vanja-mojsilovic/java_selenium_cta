package cta.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

//import javax.swing.JPasswordField;

import org.jboss.aerogear.security.otp.Totp;


public class LoginPage extends BasePage {
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

    @FindBy(xpath ="//button[@name='googleSignUpButton']")
	List <WebElement> googleContinueWithGoogleLocator;

    @FindBy(xpath ="//button//span[contains(text(),'Continue')]")
	WebElement googleAccountContinueLocator;



    // Constructor

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Methods
    
    public void spothopperappLogin(){
		List<WebElement> elements = waitForVisibilityOfElements(driver, googleContinueWithGoogleLocator, 15);
		if(!elements.isEmpty()) {
			clickElement(driver, elements.get(0), "googleAccountLocator", 15);
            System.out.println("Continue With Google Clicked!");
			//clickElement(driver, googleAccountContinueLocator, "googleAccountContinueLocator", 15);
			//clickElement(driver, googleContinueWithGoogleLocator.get(1), "googleContinueWithGoogleLocator", 15);
		}
        System.out.println("Spothopper App Continue With Google Clicked!");
    }

    public void enterGoogleAuthenticatorCode(String googleSecretKey){
        WebElement element = enterCodeFieldLocator;
		Totp totp = new Totp(googleSecretKey);
		String verificationCode = totp.now();
        element.clear();
        element.sendKeys(verificationCode);
        System.out.println("Authentication Code is entered!");
    }

    public void clickGoogleAuthenticatorCodeNextButton(){
        WebElement element = nextAuthCodeGoogleButtonLocator;
        element.click();
        System.out.println("Next Auth Code clicked!");
    }


    public void clickNextPasswordGoogle(){
        WebElement element = nextPasswordGoogleButtonLocator;
        element.click();
        System.out.println("Next password clicked!");
    }

    public void enterPasswordGoogle(String password) {
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

    public void clickNextEmailGoogle(){
        WebElement element = nextEmailGoogleButtonLocator;
        element.click();
        System.out.println("Next Email clicked!");
    }

    public void enterEmailGoogle(String username) {
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


    


}
