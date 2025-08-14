package cta.tests;

import cta.pages.LoginPage;
import cta.pages.VariablesPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();

        if (System.getenv("CI") != null) {
            options.addArguments("--headless");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
        }

        WebDriver driver = new ChromeDriver(options);

        LoginPage loginPage = new LoginPage(driver);
        VariablesPage variablesPage = new VariablesPage(driver);
        loginPage.navigate();
        sleep(1000);
        loginPage.enterEmailGoogle(driver,variablesPage.emailGoogle);
        sleep(1000);
        loginPage.clickNextEmailGoogle(driver);
        sleep(3000);
        loginPage.enterPasswordGoogle(driver,variablesPage.passwordGoogle);
        sleep(1000);
        loginPage.clickNextPasswordGoogle(driver);
        sleep(3000);
        driver.quit();
        System.exit(0);

    }

    private static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
