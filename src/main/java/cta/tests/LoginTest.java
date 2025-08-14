package cta.tests;

import cta.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
  public static void main(String[] args) {
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();

    LoginPage login = new LoginPage(driver);
    login.navigate();

    System.out.println("Sleep 3 seconds!");
    sleep(3000);

    login.enterUsername("vanja.mojsilovic@spothopperapp.com");

    System.out.println("Sleep another 3 seconds!");
    sleep(3000);

    driver.quit();
  }

    private static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
