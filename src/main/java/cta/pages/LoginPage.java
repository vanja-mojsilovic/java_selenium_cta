package cta.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {
    // Variables
    private WebDriver driver;



    // Locators
    @FindBy(xpath = "//input[@id='identifierId']")
    private WebElement usernameField;


    // Methods

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigate() {
    driver.get("https://accounts.google.com/");
    }

    public void enterUsername(String username) {
        WebElement element = usernameField;
        element.sendKeys(username);
    }

    public void enterPassword(String password) {
    driver.findElement(By.id("password")).sendKeys(password);
    }

    public void submit() {
    driver.findElement(By.cssSelector("button[type='submit']")).click();
    }
}
