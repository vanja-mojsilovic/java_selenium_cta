package cta.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.github.dockerjava.core.dockerfile.DockerfileStatement.Env;

import io.github.cdimascio.dotenv.Dotenv;


public class VariablesPage {
    private WebDriver driver;

    private static final Dotenv dotenv = Dotenv.configure()
                                                .ignoreIfMissing()
                                                .load();


    public String emailGoogle = "vanja.mojsilovic@spothopperapp.com";
    public String passwordGoogle = get("VANJA_GOOGLE_PASSWORD");
    public VariablesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public static String get(String key) {
        String value = System.getenv(key); // GitHub Actions or OS-level
        if (value == null || value.isEmpty()) {
            value = dotenv.get(key);       // Local .env fallback
        }
        return value;
    }


}
