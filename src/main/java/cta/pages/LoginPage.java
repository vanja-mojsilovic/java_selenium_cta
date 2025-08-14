package cta.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


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

    // Constructor

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Methods

    public void clickNextPasswordGoogle(WebDriver driver){
        WebElement element = nextPasswordGoogleButtonLocator;
        element.click();
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
    }

    public void enterEmailGoogle(WebDriver driver,String username) {
        WebElement element = emailGoogleLocator;
        element.clear();
        element.sendKeys(username);
        String enteredValue = element.getAttribute("value");
        if (enteredValue.equals(username)) {
            System.out.println("Username entered successfully.");
        } else {
            System.out.println("Username entry failed. ");
        }
    }

    public void navigate() {
    driver.get("https://accounts.google.com/");
    }

    
}
