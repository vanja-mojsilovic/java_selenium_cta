package cta.tests;

import cta.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();

        // Enable headless mode only in CI environments
        if (System.getenv("CI") != null) {
            options.addArguments("--headless");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
        }

        WebDriver driver = new ChromeDriver(options);

        LoginPage login = new LoginPage(driver);
        login.navigate();

        System.out.println("Sleep 3 seconds!");
        sleep(3000);

        login.enterUsername("vanja.mojsilovic@spothopperapp.com");

        System.out.println("Sleep another 3 seconds!");
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
